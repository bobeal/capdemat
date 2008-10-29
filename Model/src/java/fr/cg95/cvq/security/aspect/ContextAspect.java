package fr.cg95.cvq.security.aspect;

import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ContextAspect {

    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        ContextType contextType = context.type();
        String securityContext = SecurityContext.getCurrentContext();

        if (contextType.equals(ContextType.BACK_OFFICE) 
                && !securityContext.equals(SecurityContext.BACK_OFFICE_CONTEXT))
            throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Back Office context");
        if (contextType.equals(ContextType.FRONT_OFFICE)
                && !securityContext.equals(SecurityContext.FRONT_OFFICE_CONTEXT))
            throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Front Office context");
        if (contextType.equals(ContextType.ADMIN)
                && !securityContext.equals(SecurityContext.ADMIN_CONTEXT))
            throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Admin context");
    }
}
