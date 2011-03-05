package fr.cg95.cvq.service.request.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.business.request.CategoryRoles;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.request.external.RequestExternalAction;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.ICategoryDAO;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.IsUser;
import fr.cg95.cvq.security.annotation.IsRequester;
import fr.cg95.cvq.security.annotation.IsSubject;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.annotation.IsCategory;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.service.request.annotation.IsRequestType;
import fr.cg95.cvq.util.Critere;

@Aspect
public class RequestContextCheckAspect implements Ordered {

    private Logger logger = Logger.getLogger(RequestContextCheckAspect.class);

    private IRequestDAO requestDAO;
    private IRequestTypeDAO requestTypeDAO;
    private ICategoryDAO categoryDAO;

    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context) && within(fr.cg95.cvq.service.request..*)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if (!ArrayUtils.contains(context.types(), ContextType.ECITIZEN)
            && !ArrayUtils.contains(context.types(), ContextType.AGENT)
            && !ArrayUtils.contains(context.types(), ContextType.EXTERNAL_SERVICE)) {
            logger.debug("contextAnnotatedMethod() unhandled context types ("
                    + context.types() + ") on method " + signature.getMethod().getName()
                    + ", ignoring");
            return;
        }

        if (context.privilege().equals(ContextPrivilege.NONE)) {
            logger.debug("contextAnnotatedMethod() no special privilege asked"
                    + " on method " + signature.getMethod().getName() + ", returning");
            return;
        }

        Method method = signature.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        Object[] arguments = joinPoint.getArgs();
        Long homeFolderId = null;
        Long individualId = null;
        Long categoryId = null;
        Request request = null;
        RequestType requestType = null;
        int i = 0;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(IsUser.class)) {
                    if (argument instanceof Long) {
                        Long id = (Long) argument;
                        try {
                            requestDAO.findById(Individual.class, id);
                            individualId = id;
                        } catch (CvqObjectNotFoundException e1) {
                            try {
                                requestDAO.findById(HomeFolder.class, id);
                                homeFolderId = id;
                            } catch (CvqObjectNotFoundException e2) {
                                // no user with this id
                            }
                        }
                    } else if (argument instanceof Individual) {
                        individualId = ((Individual)argument).getId();
                    } else if (argument instanceof HomeFolder) {
                        homeFolderId = ((HomeFolder)argument).getId();
                    }
                } else if (parameterAnnotation.annotationType().equals(IsSubject.class)) {
                    individualId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(IsRequester.class)) {
                    individualId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(IsRequest.class)) {
                    try {
                        request = findRequestByArgument(argument);
                    } catch (CvqObjectNotFoundException confe) {
                        // Handled in finally
                        // FIXME Shouldn't be converted
                    } finally {
                        if (request == null) {
                            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                                    joinPoint.getSignature().getName(), context.types(),
                                    context.privilege(),
                                    "request not found using argument " + (i + 1) + ": "
                                    + argument.getClass().getSimpleName());
                        }
                    }
                    if (SecurityContext.isBackOfficeContext()) {
                        if (request.getRequestType() != null 
                                && request.getRequestType().getCategory() != null)
                            categoryId = request.getRequestType().getCategory().getId();
                        else
                            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                                joinPoint.getSignature().getName(), context.types(),
                                context.privilege(), 
                                "no category associated to request type : "
                                    + request.getRequestType().getLabel());
                    }
                    homeFolderId = request.getHomeFolderId();
                    individualId = request.getSubjectId();
                    // FIXME hack because of stateful request creation
                    HibernateUtil.getSession().evict(request);
                } else if (parameterAnnotation.annotationType().equals(IsRequestType.class)) {

                    // no restrictions on request type services opened to e-citizens
                    if (SecurityContext.isFrontOfficeContext())
                        return;

                    if (argument instanceof Long) {
                        try {
                            requestType = (RequestType) requestTypeDAO.findById(RequestType.class, (Long) argument);
                        } catch (CvqObjectNotFoundException confe) {
                            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                                    joinPoint.getSignature().getName(), context.types(), context.privilege(),
                                    "unknown resource type : " + argument);
                        }
                    } else if (argument instanceof RequestType) {
                        requestType = (RequestType) argument;
                    } else if (argument instanceof String) {
                        requestType = requestTypeDAO.findByLabel((String)argument);
                    }

//                    if (requestType == null) {
//                        throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
//                            joinPoint.getSignature().getName(), context.type(), context.privilege(),
//                            "no request type specified");
//                    }

                    if (requestType != null && requestType.getCategory() != null)
                        categoryId = requestType.getCategory().getId();

                } else if (parameterAnnotation.annotationType().equals(IsCategory.class)) {
                    Category categoryToCheck = null;
                    if (argument instanceof Long) {
                        try {
                            categoryToCheck =
                                (Category) categoryDAO.findById(Category.class, (Long) argument);
                        } catch (CvqObjectNotFoundException confe) {
                            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                                    joinPoint.getSignature().getName(), context.types(),
                                    context.privilege(), "unknown resource type : " + argument);
                        }
                    } else if (argument instanceof Category) {
                        categoryToCheck = (Category) argument;
                    }

                    if (categoryToCheck != null) {
                        categoryId = categoryToCheck.getId();
                    }
                }
            }
            i++;
        }

        if (!GenericAccessManager.performPermissionCheck(homeFolderId, individualId, context))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                    joinPoint.getSignature().getName(), context.types(), context.privilege(),
                    "access denied on home folder " + homeFolderId +
                    " / individual " + individualId);

        if (SecurityContext.isBackOfficeContext()) {

            if (categoryId == null) {
                if (context.privilege().equals(ContextPrivilege.MANAGE)) {
                    // Check when a MANAGE role is asked without a specific category
                    // Typically for statistics service where category filtering is performed later

                    List<Category> managedCategories = 
                        categoryDAO.listByAgent(SecurityContext.getCurrentUserId(), 
                                CategoryProfile.MANAGER);
                    if (managedCategories != null)
                        return;

                    throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                            joinPoint.getSignature().getName(), context.types(), context.privilege(),
                    "current agent does not have a MANAGE role on any category");
                } else {
                    // Check when a READ or READ_WRITE role is asked without a specific category
                    // Typically for local referential data which does not require such a strict check
                    List<Category> categories = 
                        categoryDAO.listByAgent(SecurityContext.getCurrentUserId(), null);
                    if (categories != null)
                        return;

                    throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                            joinPoint.getSignature().getName(), context.types(), context.privilege(),
                    "current agent does not have a role on any category");
                }
            }

            Category categoryToCheck = null;
            try {
                categoryToCheck = (Category) categoryDAO.findById(Category.class, categoryId);
            } catch (CvqObjectNotFoundException confe) {
                // this has been checked before
            }

            // retrieve agent's profile on category
            CategoryProfile agentCategoryProfile = null;
            for (CategoryRoles categoryRoles : categoryToCheck.getCategoriesRoles()) {
                if (categoryRoles.getAgentId().equals(SecurityContext.getCurrentUserId())) {
                    agentCategoryProfile = categoryRoles.getProfile();
                    break;
                }
            }

            // if it has one, check it is sufficient
            if (agentCategoryProfile != null) {
                if (context.privilege().equals(ContextPrivilege.READ)
                        || (context.privilege().equals(ContextPrivilege.WRITE)
                                && (agentCategoryProfile.equals(CategoryProfile.READ_WRITE)
                                        || agentCategoryProfile.equals(CategoryProfile.MANAGER)))
                                        || (context.privilege().equals(ContextPrivilege.MANAGE)
                                                && agentCategoryProfile.equals(CategoryProfile.MANAGER))) {
                    // that's ok, let's return
                    return;
                } 
            }

            // if we are here, that means agent is not authorized
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                    joinPoint.getSignature().getName(), context.types(), context.privilege(),
                    "category " + categoryToCheck.getName());
        }

        if (SecurityContext.isExternalServiceContext()) {
            if (requestType == null)
                try {
                    requestType = request.getRequestType();
                } catch (NullPointerException npe) {
                    // Handled below
                }
            if (requestType == null) {
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                        joinPoint.getSignature().getName(), context.types(), context.privilege(),
                        "no request type specified");
            } else {
                LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
                String externalServiceLabel = SecurityContext.getCurrentExternalService();

                ExternalServiceBean esb = lacb.getBeanForExternalService(externalServiceLabel);

                Collection<String> authorizedRequestTypesLabels =
                    (esb != null) ? esb.getRequestTypes() : Collections.<String>emptyList();

                if (!authorizedRequestTypesLabels.contains(requestType.getLabel())) {
                    throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                        joinPoint.getSignature().getName(), context.types(), context.privilege(),
                        "unauthorized request type");
                }
            }
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestTypeDAO(IRequestTypeDAO requestTypeDAO) {
        this.requestTypeDAO = requestTypeDAO;
    }

    public void setCategoryDAO(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @SuppressWarnings(value="unchecked")
    private Request findRequestByArgument(Object argument) throws CvqObjectNotFoundException {
        Request request = null;

        if (argument instanceof Request) {
            request = (Request) argument;
        } else {
            Long requestId = null;
            if (argument instanceof Long) {
                requestId = (Long) argument;
            } else if (argument instanceof RequestExternalAction) {
                requestId = Long.valueOf(((RequestExternalAction) argument).getKey());
            } else if (argument instanceof Set) {
                Set<Critere> criterionSet = (Set<Critere>) argument;
                for (Critere criterion : criterionSet) {
                    if (RequestExternalAction.SEARCH_BY_KEY.equals(criterion.getAttribut())) {
                        requestId = Long.valueOf((String) criterion.getValue());
                        break;
                    }
                }
            }
            if (requestId != null) {
                request = requestDAO.findById(requestId, false);
            }
        }

        return request;
    }
}
