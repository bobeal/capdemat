package fr.cg95.cvq.service.authority;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * Service related to the management of agents.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IAgentService {

    Long create(Agent agent)
        throws CvqException;
    
    void modify(Agent agent);
    
    void delete(final String agentLogin);
    
    List<Agent> getAll();
    
    /**
     * Get an agent by id.
     */
    Agent getById(final Long id)
        throws CvqObjectNotFoundException;

    /**
     * Get an agent by login.
     *
     * The agent's login is returned by the CAS server after the
     * successful authentication of an agent. So you can use this
     * method to get a "real" agent object if needed.
     */
    Agent getByLogin(final String login)
        throws CvqObjectNotFoundException;

    /**
     * Return whether an agent with the given id exists.
     */
    boolean exists(final Long id);

    void modifyProfiles(Agent agent, final List<String> newGroups, 
        final List<String> administratorGroups,
        final List<String> agentGroups);
    
    void updateUserProfiles(String username, List<String> groups, 
        Map<String, String> informations) throws CvqException;

    /**
     * Retrieve current agent's preferences by key.
     * 
     * @return Cutoff of agent preferences
     */
    Hashtable<String, String> getPreferenceByKey(String key);
    
    /**
     * Modify current agent preferences for the given key.
     * 
     * @param preference cutoff to replace
     */
    void modifyPreference(String key, Hashtable<String,String> preference);
}
