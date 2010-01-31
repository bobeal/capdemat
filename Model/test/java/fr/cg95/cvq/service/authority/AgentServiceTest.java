package fr.cg95.cvq.service.authority;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * The tests for the agent service
 *
 * @author bor@zenexity.fr
 */
public class AgentServiceTest extends ServiceTestCase {
   
    public void testCreate()
        throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        
        Agent agent = new Agent();
        agent.setFirstName("agentFirstName");
        agent.setLastName("agentLastName");
        agent.setLogin("agentLogin");
        iAgentService.create(agent);
        
        Agent fetchAgent = iAgentService.getByLogin("agentLogin");
        assertEquals(agent, fetchAgent);
        assertEquals("agentFirstName", fetchAgent.getFirstName());
        assertEquals("agentLastName", fetchAgent.getLastName());
        assertEquals("agentLogin", fetchAgent.getLogin());
        
        rollbackTransaction();
    }
}
