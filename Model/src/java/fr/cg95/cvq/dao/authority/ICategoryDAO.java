package fr.cg95.cvq.dao.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface ICategoryDAO extends IGenericDAO {

    /**
     * Return the list of all known categories.
     */
    List<Category> listAll();

    /**
     * Get a category by name.
     */
    Category findByName(final String name);
}
