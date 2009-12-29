package fr.cg95.cvq.service.authority.impl;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.IAgentService;

/**
 * Implementation of the agent service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class AgentService implements IAgentService {

    private static Logger logger = Logger.getLogger(AgentService.class);

    private IAgentDAO agentDAO;

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public Long create(Agent agent) throws CvqException {
        
        if (agent == null)
            throw new CvqException("No agent object provided");
        if (agentDAO.findByLogin(agent.getLogin()) != null)
            throw new CvqModelException("");
        Long agentId = agentDAO.create(agent);
        logger.debug("Created agent object with id : " + agentId);
        return agentId;
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void modify(final Agent agent) {
        if (agent != null) {
            agentDAO.update(agent);
        }
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void delete(final String agentLogin) {
        Agent agent = agentDAO.findByLogin(agentLogin);
        if (agent != null)
            agentDAO.delete(agent);
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public List<Agent> getAll() {
        return agentDAO.listAll();
    }

    @Override
    public boolean exists(Long id) {
        return agentDAO.exists(id);
    }

    @Override
    public Agent getById(final Long id)
        throws CvqObjectNotFoundException {
        if (id.longValue() == -1) {
            return null;
        }
        return (Agent)agentDAO.findById(Agent.class, id);
    }

    // Since this function is used before an agent logs in,
    // we can't do an access control check
    @Override
    public Agent getByLogin(final String login)
        throws CvqObjectNotFoundException {

        Agent agent = agentDAO.findByLogin(login);
        if (agent == null)
            throw new CvqObjectNotFoundException("agent.error.agentNotFound");

        return agent;
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void updateUserProfiles(String username, List<String> groups,
            Map<String, String> informations) throws CvqException {

        Agent agent = null;
        try {
            agent = getByLogin(username);
        } catch (CvqObjectNotFoundException confe) {
            agent = new Agent();
            agent.setActive(Boolean.TRUE);
            agent.setLogin(username);
            Set<SiteRoles> agentSiteRoles = new HashSet<SiteRoles>();
            SiteRoles defaultSiteRole = new SiteRoles();
            defaultSiteRole.setProfile(SiteProfile.AGENT);
            defaultSiteRole.setAgent(agent);
            agentSiteRoles.add(defaultSiteRole);
            agent.setSitesRoles(agentSiteRoles);

            create(agent);
        }

        if (informations.get("firstName") != null)
            agent.setFirstName(informations.get("firstName"));
        if (informations.get("lastName") != null)
            agent.setLastName(informations.get("lastName"));
        modify(agent);

        modifyProfiles(agent, groups, SecurityContext.getAdministratorGroups(),
                SecurityContext.getAgentGroups());
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void modifyProfiles(Agent agent, final List<String> newGroups, 
            final List<String> administratorGroups,
            final List<String> agentGroups) {
        
        // check if user became administrator
        for (String newGroup : newGroups) {
            if (administratorGroups.contains(newGroup)) {
                boolean alreadyAdmin = false;
                for (SiteRoles siteRoles : agent.getSitesRoles()) {
                    if (siteRoles.getProfile().equals(SiteProfile.ADMIN)) {
                        alreadyAdmin = true;
                        break;
                    }
                }

                if (!alreadyAdmin) {
                    SiteRoles adminSiteRoles = new SiteRoles();
                    adminSiteRoles.setProfile(SiteProfile.ADMIN);
                    adminSiteRoles.setAgent(agent);
                    agent.getSitesRoles().clear();
                    agent.getSitesRoles().add(adminSiteRoles);

                    modify(agent);
                }

                return;
            }
        }
        
        // check if user is no longer administrator
        Set<SiteRoles> agentSiteRoles = agent.getSitesRoles();
        boolean wasAdmin = false;
        for (SiteRoles siteRoles : agentSiteRoles) {
            if (siteRoles.getProfile().equals(SiteProfile.ADMIN)) {
                wasAdmin = true;
                break;
            }
        }
        if (wasAdmin) {
            boolean isAlwaysAdmin = false;
            for (String administratorGroup : administratorGroups) {
                if (newGroups.contains(administratorGroup)) {
                    isAlwaysAdmin = true;
                    break;
                }
            }
            if (!isAlwaysAdmin) {
                SiteRoles defaultSiteRoles = new SiteRoles();
                defaultSiteRoles.setProfile(SiteProfile.AGENT);
                defaultSiteRoles.setAgent(agent);
                agent.getSitesRoles().clear();
                agent.getSitesRoles().add(defaultSiteRoles);

                modify(agent);
            }
        }
    }
    
    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.NONE)
    public Hashtable<String, String> getPreferenceByKey(String key) {
        Agent agent = SecurityContext.getCurrentAgent();
        if (agent.getPreferences() == null) return null;
        else return agent.getPreferences().get(key);
    }
    
    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.NONE)
    public void modifyPreference(String key,
        Hashtable<String,String> preference) {
        Agent agent = SecurityContext.getCurrentAgent();
        if (agent.getPreferences() == null)
            agent.setPreferences(new Hashtable<String, Hashtable<String,String>>());
        agent.getPreferences().put(key, preference);
        modify(agent);
    }
    
    public void setAgentDAO(IAgentDAO agentDAO) {
        this.agentDAO = agentDAO;
    }
}
