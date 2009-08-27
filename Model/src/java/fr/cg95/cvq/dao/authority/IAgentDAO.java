package fr.cg95.cvq.dao.authority;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 */
public interface IAgentDAO extends IGenericDAO {

    /**
     * Return whether there exists an agent with the given id.
     */
    boolean exists(final Long id);

    /**
     * Look up an agent by login.
     */
    Agent findByLogin(final String login);

    /**
     * Look up an agent given a set of search criteria.
     */
    List<Agent> search(final Set<Critere> criteria);

    /**
     * Return the list of all known agents.
     */
    List<Agent> listAll();
}
