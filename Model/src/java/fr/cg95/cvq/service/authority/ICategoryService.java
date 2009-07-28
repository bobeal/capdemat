package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 */
public interface ICategoryService {

    /**
     * Return agents that have a right (read or write) for the given category.
     */
    List<Agent> getAuthorizedForCategory(final Long categoryId)
        throws CvqException;

    /**
     * Return whether the given agent has at least a {@link CategoryProfile#READ_ONLY} profile
     * on the given category.
     */
    boolean hasProfileOnCategory(final Agent agent, final Long categoryId)
        throws CvqException;
    
    boolean hasWriteProfileOnCategory(Agent agent, Long categoryId) throws CvqException;

    /**
     * Add a request type to the given category.
     */
    Category addRequestType(final Long categoryId, final Long requestTypeId) 
        throws CvqException;
    
    /**
     * Remove a request type from the given category.
     */
    Category removeRequestType(final Long categoryId, final Long requestTypeId) 
        throws CvqException;
    
    /**
     * Create a category.
     * 
     * @throws CvqModelException if a category with the same name already exists
     * @throws CvqException if an unexpected error happens
     */
    Long create(final Category category)
        throws CvqException, CvqModelException;

    void modify(final Category category)
        throws CvqException;

    void delete(final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get the list of all categories that current agent has the right to see.
     * 
     * An administrator can see all categories. An agent can only see categories for which 
     * it has at least a {@link CategoryProfile#READ_ONLY read access}.
     */
    List<Category> getAll()
        throws CvqException;

    /**
     * Return the categories for which the current agent has a
     * {@link CategoryProfile#MANAGER MANAGER profile}.
     */
    List<Category> getManaged();

    Category getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;
}
