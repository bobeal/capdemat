package fr.cg95.cvq.service.users.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;

@Aspect
public class UsersContextAspect implements Ordered {

    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context) && within(fr.cg95.cvq.service.users..*)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        
        if (!context.type().equals(ContextType.ECITIZEN) 
                && !context.type().equals(ContextType.ECITIZEN_AGENT))
            return;
        
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        
        Method method = signature.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        Object[] arguments = joinPoint.getArgs();
        Long homeFolderId = null;
        Long individualId = null;
        int i = 0;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(IsHomeFolder.class)) {
                    if (argument instanceof Long) {
                        homeFolderId = (Long) argument;
                    } else if (argument instanceof HomeFolder) {
                        homeFolderId = ((HomeFolder) argument).getId();
                    }
                } else if (parameterAnnotation.annotationType().equals(IsIndividual.class)) {
                    if (argument instanceof Long) {
                        individualId = (Long) argument;
                    } else if (argument instanceof Individual) {
                        individualId = ((Individual) argument).getId();
                    }
                } 
            }
            i++;
        }

        if (!GenericAccessManager.performPermissionCheck(homeFolderId, individualId, context.privilege()))
            throw new PermissionException("Denied access to method " + method.getName());

    }
    
    @Override
    public int getOrder() {
        return 1;
    }
}
