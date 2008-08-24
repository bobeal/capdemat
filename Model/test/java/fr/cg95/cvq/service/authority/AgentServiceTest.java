package fr.cg95.cvq.service.authority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.impl.AgentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

/**
 * The tests for the agent service
 *
 * @author bor@zenexity.fr
 */
public class AgentServiceTest extends ServiceTestCase {

    public void testLoginAndRights() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Agent agent = SecurityContext.getCurrentAgent();

        Map<Long, CategoryProfile> categoriesProfilesMap = new HashMap<Long, CategoryProfile>();
        List<Long> agentCategories = new ArrayList<Long>();

        // try to modify the agent's rights
        Set categoriesRolesSet = agent.getCategoriesRoles();
        Iterator spIt = categoriesRolesSet.iterator();
        while (spIt.hasNext()) {
            CategoryRoles sr = (CategoryRoles) spIt.next();
            Category category = sr.getCategory();
            CategoryProfile profile = sr.getProfile();
            agentCategories.add(category.getId());
            categoriesProfilesMap.put(category.getId(), profile);
            logger.debug("Agent has profile " + profile.toString() + " on category " 
                    + category.getName() + " (" + category.getId() + ")");
        }

        // add agent to the categories it does not belong to
        List<Category> allCategories = iCategoryService.getAll();
        for (int i=0; i < allCategories.size(); i++) {
            Category category = allCategories.get(i);
            logger.debug("Got category : " + category.getName());
            if (!agentCategories.contains(category.getId())) {
                logger.debug("Agent is not registered in category (" + category.getId() 
                        + "), adding it with write modifications");
                categoriesProfilesMap.put(category.getId(), CategoryProfile.READ_WRITE);
            }
        }

        try {
            iAgentService.modifyRights(agent.getId(),categoriesProfilesMap);
            fail("should have thrown an exception");
        } catch (CvqPermissionException cpe) {
            // ok
        }

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        // first, try to modify its rights
        try {
            iAgentService.modifyRights(agent.getId(),categoriesProfilesMap);
        } catch (CvqPermissionException cpe) {
            cpe.printStackTrace();
            fail("should have not thrown an exception");
        }

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // check new associations have been saved
        categoriesRolesSet = agent.getCategoriesRoles();
        assertEquals(categoriesRolesSet.size(), allCategories.size());

        // test agent is correctly set in the requests notes
        CreationBean cb = gimmeAnHomeFolder();
        Request request = iRequestService.getById(cb.getRequestId());
        Assert.assertNull(request.getNotes());
        iRequestService.addNote(request.getId(), RequestNoteType.DEFAULT_NOTE, 
                "Paris est magique");

        // disconnect agent and test the same
        SecurityContext.resetCurrentSite();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        
        try {
            iRequestService.addNote(request.getId(), RequestNoteType.DEFAULT_NOTE,
                                    "Paris Paris Paris");
            fail("should have thrown an exception");
        } catch (CvqException ce) {
            // that's good
        }

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        request = iRequestService.getById(request.getId());
        Set notes = request.getNotes();
        Assert.assertEquals(notes.size(), 1);
        RequestNote rn = (RequestNote) notes.iterator().next();
        Assert.assertEquals(rn.getAgentId(), agent.getId());

        // test search by last intervening agent
        iRequestService.complete(cb.getRequestId());
        Agent currentAgent = SecurityContext.getCurrentAgent();
        Set myAgentRequests = iRequestService.getByLastInterveningAgentId(currentAgent.getId());
        Assert.assertEquals(myAgentRequests.size(), 1);
        // perform the same search ... but with the generic search method
        Critere crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(currentAgent.getId());
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);
        myAgentRequests = iRequestService.get(criteriaSet, null, true);
        Assert.assertEquals(myAgentRequests.size(), 1);

        SecurityContext.resetCurrentSite();
    }
    
    public void testCreate()
        throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName,
                SecurityContext.ADMIN_CONTEXT);
        
        Agent agent = new Agent();
        agent.setFirstName("AgentFirtname");
        agent.setLastName("agentLastName");
        agent.setLogin("agentLogin");
        iAgentService.create(agent);
        
        Agent fetchAgent = iAgentService.getByLogin("agentLogin");
        Assert.assertEquals(agent, fetchAgent);
        
        rollbackTransaction();
    }
}
