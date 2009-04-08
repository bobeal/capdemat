package fr.cg95.cvq.service.authority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
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
        Set<CategoryRoles> categoriesRolesSet = agent.getCategoriesRoles();
        for (CategoryRoles categoryRoles : categoriesRolesSet) {
            Category category = categoryRoles.getCategory();
            CategoryProfile profile = categoryRoles.getProfile();
            agentCategories.add(category.getId());
            categoriesProfilesMap.put(category.getId(), profile);
            logger.debug("Agent has profile " + profile.toString() + " on category " 
                    + category.getName() + " (" + category.getId() + ")");
        }

        // try adding agent to a category it does not belong to
        List<Category> allCategories = iCategoryService.getAll();
        for (Category category : allCategories) {
            if (!agentCategories.contains(category.getId())) {
                try {
                    iAgentService.addCategoryRole(agent.getId(), category.getId(), CategoryProfile.READ_WRITE);
                    fail("should have thrown an exception");
                } catch (PermissionException pe) {
                    // that was expected
                }
                break;
            }
        }

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        // first, try to modify its rights
        for (Category category : allCategories) {
            if (!agentCategories.contains(category.getId())) {
                try {
                    iAgentService.addCategoryRole(agent.getId(), category.getId(), CategoryProfile.READ_WRITE);
                } catch (PermissionException pe) {
                    fail("should not have thrown an exception");
                }
                break;
            }
        }

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // check new associations have been saved
        categoriesRolesSet = agent.getCategoriesRoles();
        assertEquals(categoriesRolesSet.size(), allCategories.size());

        // test agent is correctly set in the requests notes
        CreationBean cb = gimmeAnHomeFolder();
        Request request = iRequestService.getById(cb.getRequestId());
        assertNull(request.getNotes());

        iRequestService.addNote(request.getId(), RequestNoteType.DEFAULT_NOTE, 
                "Paris est magique");

        // disconnect agent and test the same
        SecurityContext.resetCurrentSite();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        
        try {
            iRequestService.addNote(request.getId(), RequestNoteType.DEFAULT_NOTE,
                                    "Paris Paris Paris");
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that's good
        }

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        request = iRequestService.getById(request.getId());
        Set<RequestNote> notes = request.getNotes();
        Assert.assertEquals(notes.size(), 1);
        RequestNote rn = (RequestNote) notes.iterator().next();
        Assert.assertEquals(rn.getAgentId(), agent.getId());

        // test search by last intervening agent
        iRequestWorkflowService.updateRequestState(cb.getRequestId(), RequestState.COMPLETE, null);
        Agent currentAgent = SecurityContext.getCurrentAgent();

        Critere crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(currentAgent.getId());
        Set<Critere> criteriaSet = new HashSet<Critere>();
        criteriaSet.add(crit);

        List<Request> requests = iRequestService.get(criteriaSet, null, null, -1, 0);
        Assert.assertEquals(requests.size(), 1);

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
