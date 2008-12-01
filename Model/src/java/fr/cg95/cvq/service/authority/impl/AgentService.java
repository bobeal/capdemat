package fr.cg95.cvq.service.authority.impl;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.dao.authority.ICategoryDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILdapService;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the agent service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class AgentService implements IAgentService {

    private static Logger logger = Logger.getLogger(AgentService.class);

    private IAgentDAO agentDAO;
    private ICategoryDAO categoryDAO;

    private ILdapService ldapService;

    public AgentService() {
        super();
    }

    public Long create(Agent agent) throws CvqException {
        
        if (agent == null)
            throw new CvqException("No agent object provided");
            
        Long agentId = agentDAO.create(agent);

        logger.debug("Created agent object with id : " + agentId);

        return agentId;
    }

    public void modify(final Agent agent) throws CvqException {

        if (agent != null) {
            agentDAO.update(agent);
        }
    }

    public void delete(final String agentLogin)
        throws CvqException {
        
        Agent agent = agentDAO.findByLogin(agentLogin);
        if (agent != null)
            agentDAO.delete(agent);
    }

    public List<Agent> get(final Set<Critere> criteriaSet)
        throws CvqException {

        List<Agent> agents = agentDAO.search(criteriaSet);
        for (Agent agent : agents)
            feedWithLdapData(agent);

        return agents;
    }

    public List<Agent> getAll()
        throws CvqException {

        List<Agent> agents = agentDAO.listAll();
        for (Agent agent : agents) {
            feedWithLdapData(agent);
        }

        return agents;
    }

    public boolean exists(Long id) throws CvqException {
        return agentDAO.exists(id);
    }

    public Agent getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        if (id.longValue() == -1) {
            return null;
        }
        
        Agent agent = null;
        agent = (Agent) agentDAO.findById(Agent.class, id);
        feedWithLdapData(agent);
        return agent;
    }

    public Agent getByLogin(final String login)
        throws CvqException, CvqObjectNotFoundException {

        Agent agent = null;
        agent = agentDAO.findByLogin(login);
        
        if (agent == null)
            throw new CvqObjectNotFoundException("Agent not found in DB, maybe DB needs to be synchronized with LDAP directory ??");

        feedWithLdapData(agent);
        return agent;
    }

    protected void feedWithLdapData(Agent agent)
        throws CvqException {

        try {
            ldapService.completeAgentData(agent);
        } catch (CvqException e) {
            logger.warn("feedWithLdapData() Agent " + agent.getLogin() + " seems to have been "
                    + " removed from LDAP");
        }
    }

    public Set<Agent> getAuthorizedForCategory(Long categoryId) throws CvqException {
        
        Critere critere = new Critere();
        critere.setAttribut(SEARCH_BY_CATEGORY_ID);
        critere.setComparatif(Critere.EQUALS);
        critere.setValue(categoryId);
        
        Set<Critere> critereSet = new HashSet<Critere>();
        critereSet.add(critere);

        List results = agentDAO.search(critereSet);
        return new LinkedHashSet<Agent>(results);
    }

    public void updateUserProfiles(String username, List<String> groups,
            Map<String, String> informations) throws CvqException {

        Agent agent = null;
        try {
            agent = getByLogin(username);
        } catch (CvqObjectNotFoundException confe) {
            agent = new Agent();
            agent.setActive(true);
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
                SecurityContext.getAgentGroups(), SecurityContext.getCurrentSite());
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void addCategoryRole(final Long agentId, final  Long categoryId, 
            final CategoryProfile categoryProfile ) throws CvqException {
        
        if (agentId == null)
            throw new CvqException("No agent id provided");
        Agent agent = getById(agentId);
        
        CategoryRoles categoryRoles = new CategoryRoles();
        categoryRoles.setAgent(agent);
        categoryRoles.setCategory((Category) categoryDAO.findById(Category.class, categoryId));
        categoryRoles.setProfile(categoryProfile);
        agent.getCategoriesRoles().add(categoryRoles);
    
        agentDAO.update(agent);
    }
    
    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void modifyCategoryRole(final Long agentId, final  Long categoryId, 
            final CategoryProfile categoryProfile ) throws CvqException {
        
        if (agentId == null)
            throw new CvqException("No agent id provided");
        Agent agent = getById(agentId);
        
        boolean foundCategoryRole = false;
        for (CategoryRoles categoryRoles : agent.getCategoriesRoles()) {
            if (categoryRoles.getCategory().getId().equals(categoryId)) {
                categoryRoles.setProfile(categoryProfile);
                foundCategoryRole = true;
                break;
            }
        }
        if (!foundCategoryRole) {
            CategoryRoles categoryRoles = new CategoryRoles();
            categoryRoles.setAgent(agent);
            categoryRoles.setCategory((Category) categoryDAO.findById(Category.class, categoryId));
            categoryRoles.setProfile(categoryProfile);
            agent.getCategoriesRoles().add(categoryRoles);
        }
            agentDAO.update(agent);
    }
    
    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void removeCategoryRole(final Long agentId, final  Long categoryId) throws CvqException {
        
        if (agentId == null)
            throw new CvqException("No agent id provided");
        Agent agent = getById(agentId);
        
        boolean foundCategoryRole = false;
        for (CategoryRoles categoryRoles : agent.getCategoriesRoles()) {
            if (categoryRoles.getCategory().getId().equals(categoryId)) {
                agent.getCategoriesRoles().remove(categoryRoles);
                foundCategoryRole = true;
                break;
            }
        }
        if (foundCategoryRole)
            agentDAO.update(agent);
    }
    
    public void modifyProfiles(Agent agent, final List<String> newGroups, 
            final List<String> administratorGroups,
            final List<String> agentGroups, final LocalAuthority localAuthority)
        throws CvqException {
        
        // check if user became administrator
        for (int i = 0; i < newGroups.size(); i++) {
            if (administratorGroups.contains(newGroups.get(i))) {
                Set<SiteRoles> agentSiteRoles = agent.getSitesRoles();
                boolean alreadyAdmin = false;
                for (SiteRoles siteRoles : agentSiteRoles) {
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
            for (int i = 0; i < administratorGroups.size(); i++) {
                if (newGroups.contains(administratorGroups.get(i))) {
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
    
    public Hashtable<String, String> getPreferenceByKey(Agent agent,String key) {
        Hashtable<String, Hashtable<String, String>> preferences;
        if(agent.getPreferences() == null) return null; 
        preferences = agent.getPreferences();
        return preferences.get(key);
    }
    
    public void modifyPreference(Agent agent,String key,Hashtable<String,String> preference) 
    throws CvqException{
        Hashtable<String, Hashtable<String, String>> preferences;
        if(agent.getPreferences() == null) 
            agent.setPreferences(new Hashtable<String, Hashtable<String,String>>());
        
        preferences = agent.getPreferences();
        preferences.put(key, preference);
        agent.setPreferences(preferences);
        this.modify(agent);
    }
    
    public void setDAO(IAgentDAO agentDAO) {
        this.agentDAO = agentDAO;
    }

    public void setCategoryDAO(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void setLdapService(ILdapService ldapService) {
        this.ldapService = ldapService;
    }

    public void setAgentDAO(IAgentDAO agentDAO) {
        this.agentDAO = agentDAO;
    }
}

