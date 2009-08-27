package fr.cg95.cvq.dao.external.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.quering.CriteriasDescriptor;
import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.ISelectArgument;
import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;
import fr.cg95.cvq.util.quering.sort.ISortCriteria;

/**
 * @author vba@zenexity.fr
 *
 */
public final class ExternalServiceTraceDAO extends GenericDAO implements IExternalServiceTraceDAO {

    @SuppressWarnings("unchecked")
    public List<ExternalServiceTrace> get(Set<Critere> criteriaSet, String sort,
        String dir) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(ExternalServiceTrace.class);
        for (Critere critere : criteriaSet) {
            criteria.add(critere.compose());
        }
        if (sort == null || sort.trim().isEmpty())
            sort = ExternalServiceTrace.SEARCH_BY_DATE;
        if ("desc".equals(dir)) criteria.addOrder(Order.desc(sort));
        else criteria.addOrder(Order.asc(sort));
        return (List<ExternalServiceTrace>)criteria.list();
    }

    public <T> int delete(Set<ISearchCriteria> searchCriterias, Class<T> clazz) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("delete from %2$s as %1$s ",
                clazz.getSimpleName().toLowerCase(),
                clazz.getSimpleName()));
        
        Query query = this.prepareStatement(searchCriterias, sb, clazz);

        return query.executeUpdate();
    }
    
    /*********************************************************************
     * 
     *                    GENERIC MANIPULATION METHODS
     * 
     * ********************************************************************/

    @SuppressWarnings("unchecked")
    public <T,R> Set<R> get(Set<ISelectArgument> arguments, 
            Set<ISearchCriteria> searchCriterias,
            Set<ISortCriteria> sorts,
            Integer max,
            Integer offset,
            Class<T> clazz) {
        
        Set<R> result = new HashSet<R>();
        StringBuffer sb = new StringBuffer();
        if(searchCriterias == null) searchCriterias = new HashSet<ISearchCriteria>();
        
        if(arguments != null && arguments.size() > 0) 
            sb.append(this.prepareSelectArguments(arguments,searchCriterias,clazz));
        else 
            sb.append(this.prepareSimpleSelect(
                this.prepareExplicitJoins(searchCriterias, clazz),
                clazz));
        
        Query query = this.prepareStatement(searchCriterias,sorts,max,offset, sb, clazz);
        query.setFirstResult(0);
        result = new LinkedHashSet<R>(query.list());
        
        return result;
    }
    
    public <T,R> Set<R> get(CriteriasDescriptor descriptor, Class<T> clazz) {
        return this.<T,R>get(descriptor.getSelects(), 
            descriptor.getSearches(),
            descriptor.getSorts() ,
            descriptor.getMax(),
            descriptor.getOffset(),
            clazz);
    }
    
    public <T,R> Set<R> get(Set<ISelectArgument> arguments, Set<ISearchCriteria> searchCriterias, Class<T> clazz) {
        return this.<T,R>get(arguments,searchCriterias,null,null,null,clazz);
    }
    
    public <T,R> Set<R> get(Set<ISearchCriteria> searchCriterias, Class<T> clazz) {
        return this.<T,R>get(null,searchCriterias,clazz);
    }
    
    protected String prepareSelectArguments(Set<ISelectArgument> arguments, 
            Set<ISearchCriteria> searchCriterias, Class<?> clazz) {
        StringBuffer result = new StringBuffer();
        
        if(arguments.size() > 0) {
            String select = "";
            for(ISelectArgument argument : arguments) {
                if(argument.getClazz() == null) argument.setClazz(clazz);
                select += argument.formatClause();
            }
            if(select.contains(",")) select = select.substring(0, select.length()-2);
            select = String.format("select %1$s %2$s ",select,
                    this.prepareExplicitJoins(searchCriterias, clazz));
            
            result.append(select);
        } 
        else result.append(this.prepareSimpleSelect(
                this.prepareExplicitJoins(searchCriterias, clazz),
                clazz));
        
        return result.toString();
    }
    
    protected String prepareSorts(Set<ISortCriteria> sorts,Class<?> clazz) {
        StringBuffer result = new StringBuffer();
        
        if(sorts.size() > 0) {
            String orderBy = "";
            for(ISortCriteria sort : sorts) {
                if(sort.getClazz() == null) sort.setClazz(clazz);
                orderBy += sort.formatClause();
            }
            if(orderBy.contains(","))orderBy = orderBy.substring(0, orderBy.length()-2);
            orderBy = String.format(" order by %1$s", orderBy);
            result.append(orderBy);
        }
        
        return result.toString();
    }
    
    protected String prepareExplicitJoins(Set<ISearchCriteria> searchCriterias, Class<?> clazz) {
        String result = String.format(
                "from %1$s as %2$s, ", 
                clazz.getSimpleName(), 
                clazz.getSimpleName().toLowerCase());
        
        for(ISearchCriteria criteria : searchCriterias) {
            if(criteria.getEntityType() != null ) {
                String name = criteria.getEntityType().getSimpleName();
                if(!result.contains(String.format(" %1$s ", name)))
                    result += String.format(" %1$s as %2$s, ", name, name.toLowerCase());
            }
        }
        
        return result.substring(0,result.length()-2);
    }
    
    protected String prepareSimpleSelect(String fromStatement, Class<?> clazz) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("select %1$s %2$s ", 
                clazz.getSimpleName().toLowerCase(),
                fromStatement));
        return sb.toString();
    }
    
    protected Query prepareStatement(Set<ISearchCriteria> criterias,
            StringBuffer sb, Class<?> clazz) {
        return this.prepareStatement(criterias,null,null,null,sb,clazz);
    }
    
    protected Query prepareStatement(Set<ISearchCriteria> criterias,
            Set<ISortCriteria> sorts,
            Integer max, Integer offset,
            StringBuffer sb, Class<?> clazz) {
        
        List<IParameter> params = new ArrayList<IParameter>();
        
        for(ISearchCriteria criteria : criterias) {
            if(criteria.getValue() != null) {
                String sentence = String.format(" %1$s ",criteria.getCriteriaLogicOperator().value()); 
                if(! sb.toString().contains(" where ")) sentence = " where ";
                if(criteria.getEntityType() == null) criteria.setEntityType(clazz);
                
                String condition = sentence + criteria.formatClause(params);
                sb.append(condition);
            }
        }
        if(sorts != null) sb.append(this.prepareSorts(sorts, clazz));
        
        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        if(max != null) {
            query.setMaxResults(max);
            query.setFirstResult(offset != null ? offset : 0);
        }
        
        for (IParameter parameter : params) {
            query.setParameter(
                    parameter.getName(), 
                    parameter.getValue(), 
                    (Type)parameter.getType());
        }
        return query;
    }
    
}
