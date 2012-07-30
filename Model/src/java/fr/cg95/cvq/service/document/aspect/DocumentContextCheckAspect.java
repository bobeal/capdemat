package fr.cg95.cvq.service.document.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.*;
import fr.cg95.cvq.service.document.annotation.IsDocument;
import fr.cg95.cvq.service.request.aspect.RequestContextCheckAspect;

@Aspect
public class DocumentContextCheckAspect implements Ordered {

    private Logger logger = Logger.getLogger(RequestContextCheckAspect.class);

    private IDocumentDAO documentDAO;
    private IHomeFolderDAO homeFolderDAO;
    private IIndividualDAO individualDAO;

    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context) && within(fr.cg95.cvq.service.document..*)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if (!ArrayUtils.contains(context.types(), ContextType.ECITIZEN)
                && !ArrayUtils.contains(context.types(), ContextType.AGENT)
                && !ArrayUtils.contains(context.types(), ContextType.UNAUTH_ECITIZEN)
                && !ArrayUtils.contains(context.types(), ContextType.EXTERNAL_SERVICE))
            return;

        if (context.privilege().equals(ContextPrivilege.NONE)) {
            logger.debug("contextAnnotatedMethod() no special privilege asked" + " on method "
                    + signature.getMethod().getName() + ", returning");
            return;
        }

        Method method = signature.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        Object[] arguments = joinPoint.getArgs();
        Long homeFolderId = null;
        Long individualId = null;
        int i = 0;
        Document document = null;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(IsUser.class)) {
                    if (argument instanceof Long) {
                        Long id = (Long)argument;
                        if (individualDAO.findById(id) == null) {
                            if (homeFolderDAO.findById(id) != null)
                                homeFolderId = id;
                        } else {
                            individualId = id;
                        }
                    } else if (argument instanceof Individual) {
                        individualId = ((Individual)argument).getId();
                    } else if (argument instanceof HomeFolder) {
                        homeFolderId = ((HomeFolder)argument).getId();
                    }
                } else if (parameterAnnotation.annotationType().equals(IsDocument.class)) {
                    if (argument instanceof Long) {
                        document = documentDAO.findById((Long) argument);
                        if (document == null)
                            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                                    joinPoint.getSignature().getName(), context.types(), context.privilege(),
                                    "no document match the given id : " + argument);
                    } else if (argument instanceof Document) {
                        document = (Document) argument;
                    } else {
                        throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                                joinPoint.getSignature().getName(), context.types(), context.privilege(),
                                "argument is of an unknown type " + argument);
                    }
                    homeFolderId = document.getHomeFolderId();
                    individualId = document.getIndividualId();
                }
            }
            i++;
        }

        // by-pass security checks for documents created in out-of-account requests
        if (ArrayUtils.contains(context.types(), ContextType.UNAUTH_ECITIZEN)
                && SecurityContext.getCurrentContext().equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                && SecurityContext.getCurrentEcitizen() == null) {
            if (document == null
                    || document.getHomeFolderId() != null
                    || document.getIndividualId() != null) {
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                        joinPoint.getSignature().getName(), context.types(), context.privilege(),
                        "access denied on unauthenticated ecitizen");
            } else {
                return;
            }
        }

        if (!GenericAccessManager.performPermissionCheck(homeFolderId, individualId, context))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(),
                    joinPoint.getSignature().getName(), context.types(), context.privilege(),
                    "access denied on home folder " + homeFolderId + " / individual " + individualId);
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public void setDocumentDAO(IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public void setHomeFolderDAO(IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }

    public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }
}
