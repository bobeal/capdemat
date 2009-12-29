package fr.cg95.cvq.service.authority;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * The tests for the agent service.
 *
 * @author bor@zenexity.fr
 */
public class AgentServiceTest extends ServiceTestCase {
   
    public void testCreate() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        
        Agent agent = new Agent();
        agent.setFirstName("agentFirstName");
        agent.setLastName("agentLastName");
        agent.setLogin("agentLogin");
        iAgentService.create(agent);
        
        continueWithNewTransaction();
        
        Agent fetchAgent = null;
        try {
            fetchAgent = iAgentService.getByLogin("agentLogin");
        } catch (CvqObjectNotFoundException confe) {
            fail("should not have happened");
        }
        assertEquals("agentFirstName", fetchAgent.getFirstName());
        assertEquals("agentLastName", fetchAgent.getLastName());
        assertEquals("agentLogin", fetchAgent.getLogin());

        iAgentService.delete("agentLogin");

        continueWithNewTransaction();
        
        try {
            fetchAgent = iAgentService.getByLogin("agentLogin");
            fail("should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }        
    }
}
