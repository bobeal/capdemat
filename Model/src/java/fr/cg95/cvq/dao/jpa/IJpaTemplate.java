package fr.cg95.cvq.dao.jpa;

import java.io.Serializable;
import java.util.List;

import fr.cg95.cvq.dao.hibernate.SimpleQuery;

/**
 * Generic Data Access Object for cases where we don't need specific search parameters.
 *
 * @author bor@zenexity.fr
 */
public interface IJpaTemplate<T, ID extends Serializable> {

    SimpleQuery simpleSelect(final Class<?> clazz);

    SimpleQuery simpleSelect();

    /**
     * @param <T>
     * Create a persistent object in DB.
     */
    T create(final T object);

    /**
     * Save or update a persistent object in DB.
     * 
     * @deprecated only for backward, use create or update instead
     * @param <T> object to save or update
     * @return updated object
     */
    T saveOrUpdate(final T object);

    /**
     * Update a persistent object in DB.
     * @param <T> object
     */
    void update(final T object);

    /**
     * @param <T> object
     * Delete a persistent object from DB.
     */
    void delete(final T object);

    public List<T> findBy(String query, Object... params);

    public T findById(ID id);

    /**
     * 
     * @return list of <T>
     */
    public List<T> findAll();

    /**
     * 
     * @param <T>
     * @return number of element of the type <T>
     */
    public Long count();

}
