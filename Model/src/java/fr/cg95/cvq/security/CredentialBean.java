package fr.cg95.cvq.security;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
//import fr.cg95.cvq.business.request.Category;
//import fr.cg95.cvq.business.request.CategoryProfile;
//import fr.cg95.cvq.business.request.CategoryRoles;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;

/**
 * A data structure / cache that stores all the credentials necessary when
 * computing access privileges against a given User. This CredentialBean
 * is passed around across all access checks done for a given user.
 *
 * @author bor@zenexity.fr
 */
public class CredentialBean {

    private static Logger logger = Logger.getLogger(CredentialBean.class);

    private Agent agent;
    private Agent proxyAgent;
    private Adult adult;
    private String externalService;
    private LocalAuthority localAuthority;
    private Locale locale;

    private boolean boContext;
    private boolean foContext;
    private boolean adminContext;
    private boolean externalServiceContext;

    /**
     * Used to keep trace of current agent's site roles.
     */
    private SiteRoles[] siteRoles = null;

    /**
     * Used to keep trace of current citizen's "managed" individuals.
     */
    private Set<IndividualRole> individualRoles = null;

    /**
     * Used to keep track of individuals belonging to ecitizen's home folder.
     */
    private Set<Long> individualsIds = null;

    public CredentialBean(LocalAuthority localAuthority, String context) {
        this.localAuthority = localAuthority;
        if (context.equals(SecurityContext.BACK_OFFICE_CONTEXT)) {
            boContext = true;
            foContext = false;
            adminContext = false;
            externalServiceContext = false;
        } else if (context.equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
            boContext = false;
            foContext = true;
            adminContext = false;
            externalServiceContext = false;
        } else if (context.equals(SecurityContext.ADMIN_CONTEXT)) {
            boContext = false;
            foContext = false;
            adminContext = true;
            externalServiceContext = false;
        } else if (context.equals(SecurityContext.EXTERNAL_SERVICE_CONTEXT)) {
            boContext = false;
            foContext = false;
            adminContext = false;
            externalServiceContext = true;
        }
    }

    public boolean isFoContext() {
        return foContext;
    }

    public boolean isBoContext() {
        return boContext;
    }

    public boolean isAdminContext() {
        return adminContext;
    }

    public boolean isExternalServiceContext() {
        return externalServiceContext;
    }

    public void setContext(final String context) {
        if (context.equals(SecurityContext.BACK_OFFICE_CONTEXT)) {
            boContext = true;
            foContext = false;
            adminContext = false;
            externalServiceContext = false;
        } else if (context.equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
            boContext = false;
            foContext = true;
            adminContext = false;
            externalServiceContext = false;
        } else if (context.equals(SecurityContext.EXTERNAL_SERVICE_CONTEXT)) {
            boContext = false;
            foContext = false;
            adminContext = false;
            externalServiceContext = true;
        } else {
            boContext = false;
            foContext = false;
            adminContext = true;
            externalServiceContext = false;
        }
    }

    private void resetCaches() {
		siteRoles = null;
		individualRoles = null;
		individualsIds = null;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;

        // in case we are changing of user inside a transaction, reset the cache
        // (only happens during unit tests)
        resetCaches();

        getSiteRoles();
    }
    
    public Agent getProxyAgent() {
        return proxyAgent;
    }

    public void setProxyAgent(Agent proxyAgent) {
        this.proxyAgent = proxyAgent;
    }

    public Adult getEcitizen() {
        return adult;
    }

    public void setEcitizen(Adult adult) {
        this.adult = adult;

        // in case we are changing of user inside a transaction, reset the cache
        resetCaches();

        this.individualRoles = adult.getIndividualRoles();

        this.individualsIds = new HashSet<Long>();
        List<Individual> individuals = adult.getHomeFolder().getIndividuals();
        for (Individual individual : individuals) {
            this.individualsIds.add(individual.getId());
        }
    }

    public String getExternalService() {
        return externalService;
    }

    public void setExternalService(String externalService) {
        this.externalService = externalService;

        // in case we are changing of user inside a transaction, reset the cache
        resetCaches();
    }

    public LocalAuthority getSite() {
        return localAuthority;
    }

    /**
     * Return the locale for the current thread. Defaults to Locale.FRANCE if none set.
     */
    public final Locale getLocale() {
        return locale != null ? locale : Locale.FRANCE;
    }

    public final void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Returns the array of site-scoped roles the user in the bean belongs to.
     */
    public SiteRoles[] getSiteRoles() {
        if (agent == null) {
            logger.warn("getSiteRoles() no agent");
            return new SiteRoles[0];
        }

        if (siteRoles == null) {
            Set<SiteRoles> siteRolesSet = agent.getSitesRoles();
            siteRoles = new SiteRoles[siteRolesSet.size()];
            int i = 0;
            for (SiteRoles sr : siteRolesSet) {
                siteRoles[i] = sr;
                i++;
            }
        }

        return siteRoles;
    }

    public boolean hasSiteAdminRole() {
        if (agent == null) {
            logger.warn("hasSiteAdminRole() no agent");
            return false;
        }

        if (siteRoles == null) {
            getSiteRoles();
        }

        for (SiteRoles siteRole : siteRoles) {
            if (siteRole.getProfile().equals(SiteProfile.ADMIN))
                return true;
        }

        return false;
    }

    public boolean hasSiteAgentRole() {
        if (agent == null) {
            logger.warn("hasSiteAdminRole() no agent");
            return false;
        }
        
        if (siteRoles == null)
            getSiteRoles();
        
        for (SiteRoles siteRole : siteRoles) {
            if (siteRole.getProfile().equals(SiteProfile.AGENT))
                return true;
        }

        return false;
    }

    public Set<IndividualRole> getIndividualsRoles() {
        return individualRoles;
    }

    /**
     * Return current user's roles on his home folder (and not on individuals).
     */
    public Set<IndividualRole> getHomeFolderRoles() {
        Set<IndividualRole> homeFolderRoles = new HashSet<IndividualRole>();
        for (IndividualRole individualRole : individualRoles) {
            if (individualRole.getHomeFolderId() != null) {
                homeFolderRoles.add(individualRole);
            }
        }

        return homeFolderRoles;
    }

    /**
     * Return current user's roles on his home folder's individuals.
     */
    public Set<IndividualRole> getIndividualRoles(final Long individualId) {
        Set<IndividualRole> roles = new HashSet<IndividualRole>();
        for (IndividualRole individualRole : individualRoles) {
            if (individualRole.getIndividualId() != null && individualRole.getIndividualId().equals(individualId)) {
                roles.add(individualRole);
            }
        }

        return roles;
    }

    /**
     * Return whether given individual belongs to same home folder
     * than currently logged-in ecitizen.
     */
    public boolean belongsToSameHomeFolder(final Long individualId) {
        if (this.individualsIds == null || this.individualsIds.isEmpty())
            return false;
        
        return this.individualsIds.contains(individualId);
    }
}
