package fr.cg95.cvq.security.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;

@Aspect
public class ContextAspect implements Ordered {

    private Logger logger = Logger.getLogger(ContextAspect.class);
    
    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        
        ContextType contextType = context.type();

        logger.debug("contextAnnotatedMethod() checking access type " + contextType
                + " with privilege " + context.privilege() 
                + " for " + SecurityContext.getCurrentUserLogin()
                + " (" + SecurityContext.getCurrentUserId() + ")"
                + " on resource " + joinPoint.getSignature().getDeclaringType() + "." 
                + joinPoint.getSignature().getName()
        );

        String securityContext = SecurityContext.getCurrentContext();

        if (securityContext.equals(SecurityContext.ADMIN_CONTEXT)) {
            logger.info("contextAnnotatedMethod() letting super adminstrator "
                    + "go through the process");
            return;
        }

        if (contextType.equals(ContextType.UNAUTH_ECITIZEN)
                && (!securityContext.equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                        || SecurityContext.getCurrentEcitizen() != null))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                    joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                    "can only be called by unauthenticad ecitizens");

        if (contextType.equals(ContextType.ECITIZEN_AGENT)) {
            if (securityContext.equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
                if (SecurityContext.getCurrentEcitizen() == null)
                    throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                            joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                            "can only be called by an authenticated ecitizen");
            } else if (securityContext.equals(SecurityContext.BACK_OFFICE_CONTEXT)) {
                if (SecurityContext.getCurrentAgent() == null)
                    throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                            joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                            "can only be called by an authenticated agent");
                boolean isAgent = false;
                SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
                for (SiteRoles siteRole : siteRoles) {
                    if (siteRole.getProfile().equals(SiteProfile.AGENT))
                        isAgent = true;
                }
                if (!isAgent)
                    throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                            joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                            "requires an AGENT profile on the site");
            } else {
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                        joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                        " can only be called an authenticated ecitizen or by an AGENT profile");
            }
        }
        
        if (contextType.equals(ContextType.ECITIZEN)
                && (!securityContext.equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                        || SecurityContext.getCurrentEcitizen() == null))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                    joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                    "can only be called by authenticad ecitizens");
        
        if (contextType.equals(ContextType.AGENT)) {
            if (!securityContext.equals(SecurityContext.BACK_OFFICE_CONTEXT))
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                        joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                        "can only be called by in Back Office context");
            boolean isAgent = false;
            SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.AGENT))
                    isAgent = true;
            }
            if (!isAgent)
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                        joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                        "requires an AGENT profile on the site");
        }

        if (contextType.equals(ContextType.ADMIN)) {
            if (!securityContext.equals(SecurityContext.BACK_OFFICE_CONTEXT))
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                        joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                        "can only be called in Back Office context");
            boolean isAdmin = false;
            SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.ADMIN))
                    isAdmin = true;
            }
            if (!isAdmin)
                throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                        joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                        "requires an ADMIN profile on the site");
        }

        if (contextType.equals(ContextType.SUPER_ADMIN)
                && !securityContext.equals(SecurityContext.ADMIN_CONTEXT))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                    joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                    "can only be called in Admin context");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
