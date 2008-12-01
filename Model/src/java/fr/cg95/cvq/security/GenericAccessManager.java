package fr.cg95.cvq.security;

import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.security.annotation.ContextPrivilege;

public class GenericAccessManager {

    private static Logger logger = Logger.getLogger(GenericAccessManager.class);
    
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
                
                // an ecitizen can only access to his own home folder
                if (!homeFolderId.equals(currentAdult.getHomeFolder().getId())) {
                    logger.warn("performPermissionCheck() denying access to home folder "
                            + homeFolderId + " to user " + currentAdult.toString());
                    return false;
                }
                
                // if it requires a modification on home folder, 
                // ensure it has a role of Tutor or Responsible on home folder
                if (privilege.equals(ContextPrivilege.WRITE)) {
                    Set<IndividualRole> homeFolderRoles = credentialBean.getHomeFolderRoles();
                    boolean hasRequiredHomeFolderRole = false;
                    for (IndividualRole homeFolderRole : homeFolderRoles) {
                        if (homeFolderRole.getRole().equals(RoleEnum.TUTOR)
                                || homeFolderRole.getRole().equals(RoleEnum.HOME_FOLDER_RESPONSIBLE)) {
                            hasRequiredHomeFolderRole = true;
                            break;
                        }
                    }
                    
                    if (!hasRequiredHomeFolderRole) {
                        logger.warn("performPermissionCheck() denying write access to home folder "
                                + homeFolderId + " to user " + currentAdult.toString()
                                + " (not enough roles)");
                        return false;
                    }
                }
                
                // no special checks for read privileges, it is sufficient to belong to home folder
                
                
            } else if (individualId != null) {
                
                // to have access on an individual, one has to :
                //   belong to the same home folder than given individual
                //   and :
                //        either have Tutor or Responsible role on home folder
                //        either have Tutor role on individual

                if (!credentialBean.belongsToSameHomeFolder(individualId)) {
                    logger.warn("performPermissionCheck() denying write access to individual "
                            + individualId + " to user " + currentAdult.toString()
                            + " (not same home folder)");
                    return false;
                }
                
                boolean hasRequiredIndividualRole = false;

                // first check home folder scoped roles
                Set<IndividualRole> homeFolderRoles = credentialBean.getHomeFolderRoles();
                for (IndividualRole homeFolderRole : homeFolderRoles) {
                    if (homeFolderRole.getRole().equals(RoleEnum.TUTOR)
                            || homeFolderRole.getRole().equals(RoleEnum.HOME_FOLDER_RESPONSIBLE)) {
                        hasRequiredIndividualRole = true;
                        break;
                    }
                }
                
                // if nothing found, let's check individual scoped roles
                if (!hasRequiredIndividualRole) {
                    Set<IndividualRole> individualRoles = 
                        credentialBean.getIndividualRoles(individualId);
                    for (IndividualRole individualRole : individualRoles) {
                        if (individualRole.getIndividualId().equals(individualId)
                                && individualRole.getRole().equals(RoleEnum.TUTOR)) {
                            hasRequiredIndividualRole = true;
                            break;
                        }
                    }
                }

                if (!hasRequiredIndividualRole) {
                    logger.warn("performPermissionCheck() denying write access to individual "
                            + individualId + " to user " + currentAdult.toString()
                            + " (not enough roles)");
                    return false;
                }

            } else {
                logger.warn("performPermissionCheck() not enough information"
                        + " to give access to user " + currentAdult);
                return false;
            }
        } else if (credentialBean.isBoContext()) {
            SiteRoles[] siteRoles = SecurityContext.getCurrentCredentialBean().getSiteRoles();
            boolean hasAnAgentProfile = false;
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.AGENT))
                    hasAnAgentProfile = true;
            }
            if (!hasAnAgentProfile) {
                logger.warn("performPermissionCheck() agent does not have "
                        + " an AGENT profile (" + SecurityContext.getCurrentAgent() + ")");
                return false;
            }
        } else {
            return false;
        }        
        
        return true;
    }

}
