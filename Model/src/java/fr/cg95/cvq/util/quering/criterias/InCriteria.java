package fr.cg95.cvq.util.quering.criterias;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.util.quering.BaseOperator;
import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.LogicOperator;

public class InCriteria extends SimpleCriteria {
    
    public InCriteria(String name, BaseOperator operator, Object value) {
        super(name, operator, prepareValue(value));
    }
    
    public InCriteria(Class<?> entityType, String name, BaseOperator operator, Object type,
            Object value) {
        super(entityType, name, operator, type, prepareValue(value));
    }
    
    public InCriteria(String name, BaseOperator operator, Object value,
            LogicOperator criteriaLogicOperator) {
        super(name, operator, value, criteriaLogicOperator);
    }
    
    public InCriteria() {
    }

    
    @Override
    public String formatClause(List<IParameter> params) {
        if(!(this.value instanceof Set<?>) && entityType == null) return "1";
        String result = String.format(" %1$s.%2$s %3$s (", 
                this.entityType.getSimpleName().toLowerCase(),
                this.name,this.operator.value());
        
        for(Object entry : (Set<?>)this.value)
            result += String.format(" '%1$s',", entry.toString());
        
        if(result.contains(",")) result = result.substring(0, result.length()-1);
        result +=")";
        return result;
    }

    protected static Object prepareValue(Object value) {
        if(value != null) {
            if(value instanceof Set<?> && ((Set<?>)value).size() < 1)
                return null;
        }
        return value;
    }

    @Override
    public void setValue(Object value) {
        super.setValue(prepareValue(value));
    }
    
    
}
