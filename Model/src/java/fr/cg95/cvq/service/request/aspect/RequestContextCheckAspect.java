package fr.cg95.cvq.service.request.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;
import fr.cg95.cvq.service.request.annotation.IsRequest;

public class RequestContextCheckAspect implements Ordered {
    
    private IRequestDAO requestDAO;
    
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
