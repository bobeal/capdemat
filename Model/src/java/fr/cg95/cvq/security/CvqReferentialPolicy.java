package fr.cg95.cvq.security;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.exception.CvqException;

/**
 * The policy for referential data not managed by CVQ application but for
 * whom we manage associations specifics to CVQ : Agents
 *
 * @see CvqPolicy for details
 * @author bor@zenexity.fr
 */
public class CvqReferentialPolicy extends AdministratorOnlyPolicy {

    private static Logger logger = Logger.getLogger(CvqReferentialPolicy.class);

    public boolean isReadAllowed(CredentialBean user, ObjectBean object) {
    	
    		SiteRoles[] siteRoles = user.getSiteRoles();
    		if (siteRoles != null && siteRoles.length > 0) {
    			logger.debug("isReadAllowed() user has a role on the site, ok");
    			return true;
    		} 
    		
    		return false;
    }
    
    public boolean isAdminAllowed(CredentialBean user, ObjectBean object) {

        if (user.isAdminContext()) {
            logger.debug("isAdminAllowed() in special admin context, authorizing action");
            return true;
        } else {
            SiteRoles[] siteRoles = user.getSiteRoles();
            Long currentAgentId;
            try {
                currentAgentId = SecurityContext.getCurrentAgent().getId();
            } catch (CvqException e) {
                return false;
            }
            Long agentId = ((Agent)object.getObject()).getId();
            logger.debug("isAdminAllowed() user has " + siteRoles.length + " site roles");
            for (int i=0; i < siteRoles.length; i++) {
                SiteRoles sr = siteRoles[i];
                logger.debug("isAdminAllowed() user has profile " + sr.getProfile());
                if (sr.getProfile().equals(SiteProfile.ADMIN))
                    return true;
                else if( agentId == currentAgentId )
                    return true;
            }
        }
        return false;
    }
}
