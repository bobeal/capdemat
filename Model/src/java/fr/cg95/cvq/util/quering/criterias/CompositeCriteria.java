package fr.cg95.cvq.util.quering.criterias;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.LogicOperator;

public class CompositeCriteria extends SimpleCriteria {

    public CompositeCriteria() {
        super();
    }

    public CompositeCriteria(Object value, LogicOperator criteriaLogicOperator) {
        this.value = value;
        this.criteriaLogicOperator = criteriaLogicOperator;
    }

    public CompositeCriteria(Object value) {
        this.value = value;
    }

    
    @Override
    @SuppressWarnings("unchecked")
    public String formatClause(List<IParameter> params) {
        String result = "";
        Set<ISearchCriteria> childCriterias = 
            new HashSet<ISearchCriteria>((Collection<ISearchCriteria>) this.value);
        
        for(ISearchCriteria criteria : childCriterias) {
            if(result.length() > 0) 
                result += criteria.getCriteriaLogicOperator().value();
            if(criteria.getEntityType() == null) criteria.setEntityType(this.entityType);
            result += String.format(" ( %1$s ) ", criteria.formatClause(params));
        }
        
        return String.format(" (%1$s) ", result);
    }
}
