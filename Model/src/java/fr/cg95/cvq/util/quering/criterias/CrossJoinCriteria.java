package fr.cg95.cvq.util.quering.criterias;

import java.util.List;

import fr.cg95.cvq.util.quering.BaseOperator;
import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.LogicOperator;
import fr.cg95.cvq.util.quering.joins.IJoin;

public class CrossJoinCriteria extends SimpleCriteria implements IJoin {
    
    public CrossJoinCriteria(String name, BaseOperator operator, Object value) {
        super(name, operator, value);
    }
    
    public CrossJoinCriteria(Class<?> entityType, String name, BaseOperator operator, Object type,
            Object value) {
        super(entityType, name, operator, type, value);
    }
    
    public CrossJoinCriteria(String name, BaseOperator operator, Object value,
            LogicOperator criteriaLogicOperator) {
        super(name, operator, value, criteriaLogicOperator);
    }
    
    public CrossJoinCriteria() {
    }

    @Override
    public String formatClause(List<IParameter> params) {
        return String.format(" %1$s.%2$s %3$s %4$s ",
                this.entityType.getSimpleName().toLowerCase(), 
                this.getName(), 
                this.getOperator().value(),
                this.getValue().toString());
    }
    
    public static String prepareOperand(String name, Class<?> clazz) {
        return String.format(" %1$s.%2$s ", 
                clazz.getSimpleName().toLowerCase(),
                name);
    }
}
