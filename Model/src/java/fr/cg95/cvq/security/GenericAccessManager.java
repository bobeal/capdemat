package fr.cg95.cvq.security;

import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.security.annotation.ContextPrivilege;

public class GenericAccessManager {

    /**
     * Perform generic permission checks suitable for common application use cases.
     * 
     * The checks performed are the following :
     * <ul>
     *   <li>if in Front Office context, check that either current user belongs to the given home folder,
     *         either current user belongs to the same home folder than the given individual</li>
     *   <li>if in Back Office context, check that current agent has an {@link SiteProfile#AGENT agent profile} 
     *         on the site</li>
     * </ul>
     */
    public static boolean performPermissionCheck(Long homeFolderId, Long individualId, 
            ContextPrivilege privilege) {
        
        CredentialBean credentialBean = SecurityContext.getCurrentCredentialBean();
        if (credentialBean.isFoContext()) {
            Adult currentAdult = credentialBean.getEcitizen();
            if (homeFolderId != null) {
                if (!homeFolderId.equals(currentAdult.getHomeFolder().getId()))
                    return false;
            } else if (individualId != null) {
                if (!credentialBean.getManagedIndividualsIds().contains(individualId))
                    return false;
            } else {
                return false;
            }
        } else if (credentialBean.isBoContext()) {
            // TODO : implement privilege checks
            SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
            boolean hasAnAgentProfile = false;
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.AGENT))
                    hasAnAgentProfile = true;
            }
            if (!hasAnAgentProfile)
                return false;
        } else {
            return false;
        }        
        
        return true;
    }

}
