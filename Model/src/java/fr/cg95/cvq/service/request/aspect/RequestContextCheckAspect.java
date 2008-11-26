package fr.cg95.cvq.service.request.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;
import fr.cg95.cvq.security.annotation.IsSubject;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.service.request.annotation.IsRequestType;

public class RequestContextCheckAspect implements Ordered {
    
    private IRequestDAO requestDAO;
    private IRequestTypeDAO requestTypeDAO;
    
    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context) && within(fr.cg95.cvq.service.request..*)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        
        if (!context.type().equals(ContextType.ECITIZEN) 
                && !context.type().equals(ContextType.ECITIZEN_AGENT))
            return;
        
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        
        Method method = signature.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        Object[] arguments = joinPoint.getArgs();
        Long homeFolderId = null;
        Long requesterId = null;
        Long subjectId = null;
        int i = 0;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(IsHomeFolder.class)) {
                    homeFolderId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(IsIndividual.class)) {
                    requesterId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(IsRequest.class)) {
                    Request request = null;
                    if (argument instanceof Long) {
                        try {
                            request = (Request) requestDAO.findById(Request.class, (Long) argument);
                        } catch (CvqObjectNotFoundException confe) {
                            throw new PermissionException(Request.class, argument, context.privilege());
                        }
                    } else if (argument instanceof Request) {
                        request = (Request) argument;
                    }
                    homeFolderId = request.getHomeFolderId();
                    requesterId = request.getRequesterId();
                    subjectId = request.getSubjectId();
                } else if (parameterAnnotation.annotationType().equals(IsRequestType.class)) {
                    RequestType requestType = null;
                    if (argument instanceof Long) {
                        try {
                            requestType = (RequestType) requestTypeDAO.findById(RequestType.class, (Long) argument);
                        } catch (CvqObjectNotFoundException confe) {
                            throw new PermissionException(Request.class, argument, context.privilege());
                        }                        
                    } else if (argument instanceof RequestType) {
                        requestType = (RequestType) argument;
                    }
                    
                    CategoryRoles[] categoryRoles = 
                        SecurityContext.getCurrentCredentialBean().getCategoryRoles();
                    for (CategoryRoles categoryRole : categoryRoles) {
                        Set<RequestType> categoryRequests = 
                            categoryRole.getCategory().getRequestTypes();
                        if (categoryRequests != null && categoryRequests.contains(requestType)) {
                            // we found the request type we are interested in
                            if (context.privilege().equals(ContextPrivilege.READ)
                                    || (context.privilege().equals(ContextPrivilege.WRITE)
                                            && categoryRole.getProfile().equals(CategoryProfile.READ_WRITE))
                                            || (context.privilege().equals(ContextPrivilege.MANAGE)
                                                    && categoryRole.getProfile().equals(CategoryProfile.MANAGER))) {
                                // that's ok, let's return
                                return;
                            } else {
                                break;
                            }
                        }
                    }
                    
                    // if we are here, that means agent is not authorized
                    throw new PermissionException("Denied " + context.privilege()
                            + " access to request type " + requestType.getLabel()
                            + " for agent " + SecurityContext.getCurrentAgent());
                    
                } else if (parameterAnnotation.annotationType().equals(IsSubject.class)) {
                    
                }
            }
            i++;
        }

        if (!GenericAccessManager.performPermissionCheck(homeFolderId, null, context.privilege()))
            throw new PermissionException("Denied access to method " + method.getName());
        
        if (SecurityContext.isBackOfficeContext()) {
            // for agents, check they have the right privilege for the current request's associated category
            
        }
    }
    
    @Override
    public int getOrder() {
        return 1;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }
}
