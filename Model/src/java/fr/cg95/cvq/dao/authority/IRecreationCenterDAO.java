package fr.cg95.cvq.dao.authority;

import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.dao.IGenericDAO;

import java.util.List;

/**
 * @author bor@zenexity.fr
 */
public interface IRecreationCenterDAO extends IGenericDAO {

    /**
     * Look up a recreation center by name.
     */
    RecreationCenter findByName(final String name);

    /**
     * Return the list of all known recreation centers.
     */
    List<RecreationCenter> listAll();

    /**
     * @return The list of the actives recreation centers.
     */
    List<RecreationCenter> getActives();
}
