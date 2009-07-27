package fr.cg95.cvq.service.authority;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.util.Critere;

/**
 * Service related to the management of agents.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IAgentService {

    String SEARCH_BY_CATEGORY_ID = "categoryId";
    String SEARCH_BY_LOGIN = "login";

    Long create(Agent agent)
        throws CvqException;
    
    void modify(Agent agent)
        throws CvqException;
    
    void delete(final String agentLogin)
        throws CvqException;
    
    List<Agent> getAll()
        throws CvqException;
    
    List<Agent> get(final Set<Critere> criteriaSet)
        throws CvqException;

    /**
     * Get an agent by id.
     */
    Agent getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get an agent by login.
     *
     * The agent's login is returned by the CAS server after the
     * successful authentication of an agent. So you can use this
     * method to get a "real" agent object if needed.
     */
    Agent getByLogin(final String login)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Return whether an agent with the given id exists.
     */
    boolean exists(final Long id)
        throws CvqException;

    void modifyProfiles(Agent agent, final List<String> newGroups, 
            final List<String> administratorGroups,
            final List<String> agentGroups)
        throws CvqException;
    
    void updateUserProfiles(String username, List<String> groups, 
            Map<String, String> informations) throws CvqException;
    
    public void addCategoryRole(final Long agentId, final  Long categoryId, 
            final CategoryProfile categoryProfile ) throws CvqException;
    
    /**
     * Modify or add agent's categoryRole
     */
    public void modifyCategoryRole(final Long agentId, final  Long categoryId, 
            final CategoryProfile categoryProfile ) throws CvqException;
    
    public void removeCategoryRole(final Long agentId, final  Long categoryId) throws CvqException;
    
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
    void modifyPreference(String key, Hashtable<String,String> preference) 
        throws CvqException;
}
