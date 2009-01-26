package fr.cg95.cvq.dao;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;

/**
 * Generic Data Access Object for cases where we don't need specific search parameters.
 *
 * @author bor@zenexity.fr
 */
public interface IGenericDAO {

    /**
     * Look up a persistent object by id.
     */
    Object findById(final Class<?> clazz, final Long id) 
        throws CvqObjectNotFoundException;

    /**
     * Look up a persistent object by id, applying the given security check on it after loading.
     * 
     * @deprecated
     */
    Object findById(final Class clazz, final Long id, final PrivilegeDescriptor privilege)
        throws CvqObjectNotFoundException, CvqPermissionException;
    
    /**
     * Create a persistent object in DB.
     */
    Long create(final Object object) throws CvqPermissionException;

    /**
     * Save or update a persistent object in DB.
     * 
     * @param <T> object to save or update
     * @return updated object
     */
    <T> T saveOrUpdate(final T object);

    /**
     * Update a persistent object in DB.
     */
    void update(final Object object) throws CvqPermissionException;

    /**
     * Delete a persistent object from DB.
     */
    void delete(final Object object) throws CvqPermissionException;
}
