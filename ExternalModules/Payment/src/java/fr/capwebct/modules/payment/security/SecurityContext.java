package fr.capwebct.modules.payment.security;

import fr.capwebct.modules.payment.business.Agent;
import fr.capwebct.modules.payment.exception.CpmObjectNotFoundException;
import fr.capwebct.modules.payment.service.IAgentService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;


/**
 * A manager for the notions of "current everything" that
 * pertain to security. Here we store the current
 * {@link fr.capwebct.modules.payment.business.Agent}.
 *
 * @author bor@zenexity.fr
 */
public class SecurityContext {

    private static Log logger = LogFactory.getLog(SecurityContext.class);

    private static IAgentService agentService;

    private static List<String> administratorGroups;
    private static List<String> agentGroups;

    private static ThreadLocal<Agent> currentContextThreadLocal = 
        new ThreadLocal<Agent>();
    
    /**
     * Return whether one of the group in the given list permits access to the Back Office.
     */
    public static boolean isAuthorizedGroup(List<String> groupList) {
        for (String group : groupList) {
            if (administratorGroups.contains(group) || agentGroups.contains(group))
                return true;
        }

        return false;
    }

    /**
     * Return whether at least one of the provided group is within the list of administrator
     * groups. 
     */
    public static boolean isOfAnAdminGroup(List<String> groupList) {
        
        if (administratorGroups != null && administratorGroups.size() > 0) {
            for (String group : groupList) {
                if (administratorGroups.contains(group)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    /**
     * Return whether at least one of the provided group is within the list of agent
     * groups.
     */
    public static boolean isOfAnAgentGroup(List<String> groupList) {
        
        if (agentGroups != null && agentGroups.size() > 0) {
            for (String group : groupList) {
                if (agentGroups.contains(group)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public static List<String> getAdministratorGroups() {
        return administratorGroups;
    }
    
    public static List<String> getAgentGroups() {
        return agentGroups;
    }
    

    /**
     * Return the user we are talking to (from the WWW session), or
     * null if we are not in a WWW or other user-driven context.
     *
     * @throws CvqException if security context is not initialized or if no agent is set in it
     *  or if it is not in the {@link #BACK_OFFICE_CONTEXT back office context}.
     */
    public static Agent getCurrentAgent() throws CpmSecurityException {
		Agent agent = currentContextThreadLocal.get();
		if (agent == null)
            throw new CpmSecurityException("No user yet in security context");

        return agent;
    }

    /**
     * Set the current agent. Can only be called after the current
     * local authority is set with {@link #setCurrentSite}.
     */
    public static void setCurrentAgent(Agent agent) {

        logger.debug("setCurrentAgent() agent = " + agent);

        currentContextThreadLocal.set(agent);
    }

    /**
     * @see #setCurrentAgent(Agent)
     */
    public static void setCurrentAgent(String agentLogin)
        throws CpmObjectNotFoundException {

        logger.debug("setCurrentAgent() agent = " + agentLogin);
        Agent agent = agentService.getAgentByLogin(agentLogin);
        if (agent == null)
            throw new CpmObjectNotFoundException("Agent not found !");
        setCurrentAgent(agent);
    }

    /**
     * Return the login of the current agent.
     *
     * @throws CpmSecurityException if security context is not initialized
     */
    public static String getCurrentAgentLogin() throws CpmSecurityException {

        Agent agent = currentContextThreadLocal.get();
        if (agent == null)
            throw new CpmSecurityException("No agent in security context");

        return agent.getLogin();
    }

    /**
     * Reset the current security context. To be called at the end of the transaction.
     */
    public static void resetCurrentAgent() {
        logger.debug("resetCurrentAgent()");
        currentContextThreadLocal.set(null);
    }

    public void setAgentService(IAgentService iAgentService) {
        agentService = iAgentService;
    }

	public void setAdministratorGroups(List<String> administratorGroupsToSet) {
		administratorGroups = administratorGroupsToSet;
	}

	public void setAgentGroups(List<String> agentGroupsToSet) {
		agentGroups = agentGroupsToSet;
	}
}
