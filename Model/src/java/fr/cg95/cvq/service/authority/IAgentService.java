package fr.cg95.cvq.service.authority;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * Service related to the management of agents.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IAgentService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "agentService";

    String TASKS_PENDING = "cvq.tasks.pending";
    String TASKS_OPEN = "cvq.tasks.opened";
    String TASKS_VALIDATED = "cvq.tasks.validated";
    
    Long create(Agent agent)
    		throws CvqException;
    
    void modify(Agent agent)
    		throws CvqException;
    
    Set<Agent> getAll()
        throws CvqException;
   
    /**
     * Return a map of tasks belonging to given agent.
     * 
     * The map keys are one of {@link #TASKS_OPEN}, {@link #TASKS_PENDING} 
     * or {@link #TASKS_VALIDATED}.
     */
    Map<String, Long> getAgentTasks(final String agentLogin)
        throws CvqException;

    /**
     * Modify rights associated to an agent.
     *
     * @param agentId id of agent for which we want to modify rights
     * @param categorysProfiles a map whose key is the category id
     *                         and value the profile
     *
     * @see fr.cg95.cvq.business.authority.CategoryProfile
     */
    void modifyRights(final Long agentId, final Map categoriesProfiles)
        throws CvqException, CvqObjectNotFoundException;

    void modifyProfiles(Agent agent, final List newGroups, final List administratorGroups,
            final List agentGroups, final LocalAuthority localAuthority)
        throws CvqException;
    
    /**
     * Get an agent by id.
     */
    Agent getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Return whether an agent with the given id exists.
     */
    boolean exists(final Long id)
        throws CvqException;
    
    /**
     * Get an agent by login.
     *
     * The agent's login is returned by the CAS server after the
     * successful authentication of an agent. So you can use this
     * method to get a "real" agent object if needed.
     */
    Agent getByLogin(final String login)
        throws CvqException, CvqObjectNotFoundException;
}
