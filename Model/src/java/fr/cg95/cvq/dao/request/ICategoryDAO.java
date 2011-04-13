package fr.cg95.cvq.dao.request;

import java.util.List;

import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.dao.jpa.IJpaTemplate;

/**
 * @author bor@zenexity.fr
 */
public interface ICategoryDAO extends IJpaTemplate<Category,Long> {

    /**
     * Return the list of all known categories.
     */
    List<Category> listAll();

    /**
     * Return the list of category for which agent has a role.
     */
    List<Category> listByAgent(final Long agentId, final CategoryProfile categoryProfile);

    /**
     * Get a category by name.
     */
    Category findByName(final String name);
}
