package fr.cg95.cvq.security;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;

/**
 * The policy for referential data not managed by CVQ application : Local
 * authorities, Schools, ...
 * 
 * @see CvqPolicy for details
 * @author bor@zenexity.fr
 */
public class AdministratorOnlyPolicy implements PartOfPolicy {

    private static Logger logger = Logger.getLogger(AdministratorOnlyPolicy.class);

    public boolean isWriteAllowed(CredentialBean user, ObjectBean object) {
        logger.warn("isWriteAllowed() should not come here !");
        return false;
    }

    public boolean isReadAllowed(CredentialBean user, ObjectBean object) {
        logger.debug("isReadAllowed() user is logged in, that's enough !");
        return true;
    }

    public boolean isAdminAllowed(CredentialBean user, ObjectBean object) {

        SiteRoles[] siteRoles = user.getSiteRoles();
        logger.debug("isAdminAllowed() user has " + siteRoles.length + " site roles");
        for (int i = 0; i < siteRoles.length; i++) {
            SiteRoles sr = siteRoles[i];
            logger.debug("isAdminAllowed() user has profile " + sr.getProfile());
            if (sr.getProfile().equals(SiteProfile.ADMIN))
                return true;
        }

        return false;
    }

    public boolean isManageAllowed(CredentialBean user, ObjectBean object) {
        logger.warn("isManageAllowed() should not come here !");
        return false;
    }
}
