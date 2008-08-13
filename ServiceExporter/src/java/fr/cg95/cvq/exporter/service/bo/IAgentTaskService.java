package fr.cg95.cvq.exporter.service.bo;

import java.util.Map;

import fr.cg95.cvq.exception.CvqException;

/**
 * @author bor@zenexity.fr
 */
public interface IAgentTaskService {

    /**
     * Get tasks count related to the currently connected agent.
     */
    Map getCurrentAgentTasks()
        throws CvqException;
}
