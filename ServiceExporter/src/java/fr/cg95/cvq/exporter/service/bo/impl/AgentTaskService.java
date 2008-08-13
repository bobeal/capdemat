package fr.cg95.cvq.exporter.service.bo.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exporter.service.bo.IAgentTaskService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;

/**
 * @author bor@zenexity.fr
 */
public class AgentTaskService implements IAgentTaskService {

    static Logger logger = Logger.getLogger(AgentTaskService.class);

    protected IAgentService agentService;

    public AgentTaskService() {
    }

    public Map getCurrentAgentTasks()
        throws CvqException {

        Agent agent = SecurityContext.getCurrentAgent();
        logger.debug("getCurrentAgentTasks() Got agent : " + agent.getLogin());

        return agentService.getAgentTasks(agent.getLogin());
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }
}
