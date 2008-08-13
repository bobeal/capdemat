package fr.cg95.cvq.service.authority.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.RequestState;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.dao.authority.ICategoryDAO;
import fr.cg95.cvq.dao.users.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ILdapService;
import fr.cg95.cvq.service.users.IRequestService;
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
    private IRequestDAO requestDAO;

    private ILdapService ldapService;
    private IRequestService requestService;

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

    public Set<Agent> getAll()
        throws CvqException {

        List<Agent> agents = null;
        agents = agentDAO.listAll();
        for (Agent agent : agents)
        	feedWithLdapData(agent);

        return new LinkedHashSet<Agent>(agents);
    }

    public Map<String, Long> getAgentTasks(final String agentLogin)
        throws CvqException {

        logger.debug("getAgentTasks()");

        Map<String, Long> resultMap = new LinkedHashMap<String, Long>();

        Agent agent = getByLogin(agentLogin);
        Set agentCategoryRoles = agent.getCategoriesRoles();
        if (agentCategoryRoles == null || agentCategoryRoles.size() == 0)
            return null;
        Iterator agentCategorysIt = agentCategoryRoles.iterator();
        StringBuffer sb = new StringBuffer();
        while (agentCategorysIt.hasNext()) {
            CategoryRoles categoryRoles = (CategoryRoles) agentCategorysIt.next();
            if (!categoryRoles.getProfile().equals(CategoryProfile.NONE)) {
                if (sb.length() > 0)
                    sb.append(",");
                sb.append("'")
                    .append(categoryRoles.getCategory().getId())
                    .append("'");
            }
        }
        Critere categoryCrit = new Critere();
        categoryCrit.setAttribut("belongsToCategory");
        categoryCrit.setComparatif(Critere.EQUALS);
        categoryCrit.setValue(sb.toString());

        Critere stateCrit = new Critere();
        stateCrit.setAttribut(Request.SEARCH_BY_STATE);
        stateCrit.setComparatif(Critere.EQUALS);
        stateCrit.setValue(RequestState.PENDING);

        // search new requests
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(categoryCrit);
        criteriaSet.add(stateCrit);
        Long requestCount = requestDAO.count(criteriaSet);
        resultMap.put(TASKS_PENDING, requestCount);

        // search in-progress requests
        RequestState states[] = requestService.getPossibleTransitions(RequestState.PENDING);
        long tempCount = 0;
        for (int i = 0; i < states.length; i++) {
            stateCrit.setValue(states[i]);
            tempCount += requestDAO.count(criteriaSet).longValue();
        }
        resultMap.put(TASKS_OPEN, new Long(tempCount));

        // search validated requests
        stateCrit.setValue(RequestState.VALIDATED);
        requestCount = requestDAO.count(criteriaSet);
        resultMap.put(TASKS_VALIDATED, requestCount);

        return resultMap;
    }

    public boolean exists(Long id) throws CvqException {
        return agentDAO.exists(id);
    }

    public Agent getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        Agent agent = null;
        agent = (Agent) agentDAO.findById(Agent.class, id, PrivilegeDescriptor.READ);
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

    public void modifyRights(final Long agentId, final Map categoriesProfiles)
        throws CvqException, CvqObjectNotFoundException {

        if (agentId == null)
            throw new CvqException("No agent id provided");
        Agent agent = getById(agentId);

        ArrayList<String> categoriesList = new ArrayList<String>();

        // decode category <-> profiles assocations
        Set<CategoryRoles> categoriesRolesSet = new LinkedHashSet<CategoryRoles>();
        Iterator it = categoriesProfiles.keySet().iterator();
        while (it.hasNext()) {
            Long categoryId = (Long) it.next();
            Category category = 
            	(Category) categoryDAO.findById(Category.class, categoryId, 
            			PrivilegeDescriptor.READ);
            categoriesList.add(category.getName());
            CategoryProfile profile = (CategoryProfile) categoriesProfiles.get(categoryId);
            logger.debug("modifyRights() adding profile " + profile + " on category " + category.getName());
            categoriesRolesSet.add(new CategoryRoles(profile,category,agent));
        }
        agent.setCategoriesRoles(categoriesRolesSet);
        agentDAO.update(agent);

        logger.debug("Modified agent : " + agent.getId());
    }

    public void modifyProfiles(Agent agent, final List newGroups, final List administratorGroups,
            final List agentGroups, final LocalAuthority localAuthority)
        throws CvqException {
        
        // check if user became administrator
        for (int i = 0; i < newGroups.size(); i++) {
            if (administratorGroups.contains(newGroups.get(i))) {
                Set agentSiteRoles = agent.getSitesRoles();
                Iterator agentSiteRolesIt = agentSiteRoles.iterator();
                boolean alreadyAdmin = false;
                while (agentSiteRolesIt.hasNext()) {
                    SiteRoles siteRoles = (SiteRoles) agentSiteRolesIt.next();
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
        Set agentSiteRoles = agent.getSitesRoles();
        Iterator agentSiteRolesIt = agentSiteRoles.iterator();
        boolean wasAdmin = false;
        while (agentSiteRolesIt.hasNext()) {
            SiteRoles siteRoles = (SiteRoles) agentSiteRolesIt.next();
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
    
    public void setDAO(IAgentDAO agentDAO) {
        this.agentDAO = agentDAO;
    }

    public void setCategoryDAO(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setLdapService(ILdapService ldapService) {
        this.ldapService = ldapService;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }
}

