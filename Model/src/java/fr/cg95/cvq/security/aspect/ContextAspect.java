package fr.cg95.cvq.security.aspect;

import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

@Aspect
public class ContextAspect implements Ordered {

    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        
        ContextType contextType = context.type();
        String securityContext = SecurityContext.getCurrentContext();

        if (contextType.equals(ContextType.ECITIZEN)
                && !securityContext.equals(SecurityContext.FRONT_OFFICE_CONTEXT))
            throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Front Office context");
        
        if (contextType.equals(ContextType.AGENT)) {
            if (!securityContext.equals(SecurityContext.BACK_OFFICE_CONTEXT))
                throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Back Office context");
            boolean isAgent = false;
            SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.AGENT))
                    isAgent = true;
            }
            if (!isAgent)
                throw new PermissionException("method " + joinPoint.getSignature().getName()
                        + " in " + joinPoint.getTarget().getClass()
                        + " requires an agent profile on the site");
        }
        
        if (contextType.equals(ContextType.ADMIN)) {
            if (!securityContext.equals(SecurityContext.BACK_OFFICE_CONTEXT))
                throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Back Office context");
            boolean isAdmin = false;
            SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.ADMIN))
                    isAdmin = true;
            }
            if (!isAdmin)
                throw new PermissionException("method " + joinPoint.getSignature().getName()
                        + " in " + joinPoint.getTarget().getClass()
                        + " requires an admin profile on the site");
        }

        if (contextType.equals(ContextType.SUPER_ADMIN)
                && !securityContext.equals(SecurityContext.ADMIN_CONTEXT))
            throw new PermissionException("method " + joinPoint.getSignature().getName()
                    + " in " + joinPoint.getTarget().getClass()
                    + " can only be called in Admin context");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
