package fr.cg95.cvq.dao.external;

import java.util.Set;

import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.quering.CriteriasDescriptor;
import fr.cg95.cvq.util.quering.ISelectArgument;
import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;
import fr.cg95.cvq.util.quering.sort.ISortCriteria;

/**
 * TODO GENERIC DAO Global generic method to place to above level
 * 
 * @author Victor Bartel
 */
public interface IExternalServiceTraceDAO extends IGenericDAO {
    
    
    
    /*********************************************************************
     * 
     *                    GENERIC MANIPULATION METHODS
     * 
     * ********************************************************************/
    
    /**
     * Generic method that retrieves an entity collection from the data storage.
     * Where T - processing type and R - return type.
     * If select field set contains only one entry (e.g. Id : Long),
     * the return value will be Set<Long>, otherwise the return value 
     * will be transformed to the set of object arrays (Object[])
     * 
     * FIXED : what is the link between T and R ?
     */
    <T,R> Set<R> get(Set<ISearchCriteria> searchCriterias, Class<T> clazz);
    
    /**
     * Generic method that retrieves an entity collection from the data storage.
     * Where T - processing type and R - return type.
     * If select field set contains only one entry (e.g. Id : Long),
     * the return value will be Set<Long>, otherwise the return value 
     * will be transformed to the set of object arrays (Object[])
     * 
     * FIXED : what if more than one SelectField ? ?
     */
    <T,R> Set<R> get(Set<ISelectArgument> fields, Set<ISearchCriteria> searchCriterias, Class<T> clazz);
    
    <T,R> Set<R> get(Set<ISelectArgument> arguments, 
            Set<ISearchCriteria> searchCriterias,
            Set<ISortCriteria> sorts,
            Integer max,
            Integer offset,
            Class<T> clazz);
    
    <T,R> Set<R> get(CriteriasDescriptor descriptor, Class<T> clazz);
    
    /**
     * Generic method that deletes storage entries using specific
     * HQL statement syntax
     * 
     * @param searchCriterias search criterias 
     * @param clazz generic class exemplar
     * @return deleted rows count
     */
    <T> int delete(Set<ISearchCriteria> searchCriterias, Class<T> clazz);
}
