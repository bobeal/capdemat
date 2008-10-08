package fr.cg95.cvq.dao.external.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.ISelectArgument;
import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;

/**
 * @author vba@zenexity.fr
 *
 */
public final class ExternalServiceTraceDAO extends GenericDAO implements IExternalServiceTraceDAO {
    
    
    public <T> int delete(Set<ISearchCriteria> searchCriterias, Class<T> clazz) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("delete from %2$s as %1$s ",
                clazz.getSimpleName().toLowerCase(),
                clazz.getSimpleName()));
        
        Query query = this.prepareStatement(searchCriterias, sb, clazz);

        return query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public <T,R> Set<R> get(Set<ISelectArgument> arguments, Set<ISearchCriteria> searchCriterias, Class<T> clazz) {
        
        Set<R> result = new HashSet<R>();
        StringBuffer sb = new StringBuffer();
        if(searchCriterias == null) searchCriterias = new HashSet<ISearchCriteria>();
        
        if(arguments != null && arguments.size() > 0) 
            sb.append(this.prepareSelectArguments(arguments,searchCriterias,clazz));
        else 
            sb.append(this.prepareSimpleSelect(
                this.prepareExplicitJoins(searchCriterias, clazz),
                clazz));
        
        if(searchCriterias == null) searchCriterias = new HashSet<ISearchCriteria>();
        Query query = this.prepareStatement(searchCriterias, sb, clazz);
        query.setFirstResult(0);
        result = new LinkedHashSet<R>(query.list());
        
        return result;
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
    
    protected Query prepareStatement(Set<ISearchCriteria> criterias, StringBuffer sb, Class<?> clazz) {
        
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
        
        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        for (IParameter parameter : params) {
            query.setParameter(
                    parameter.getName(), 
                    parameter.getValue(), 
                    (Type)parameter.getType());
        }
        return query;
    }
}
