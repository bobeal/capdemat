package fr.cg95.cvq.util.quering.criterias;

import java.util.List;

import fr.cg95.cvq.util.quering.BaseOperator;
import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.LogicOperator;

public interface ISearchCriteria {
    
    public abstract BaseOperator getOperator();
    
    public abstract void setOperator(BaseOperator operator);
    
    public abstract String getName();
    
    public abstract Object getType();
    
    public abstract Object getValue();
    
    public abstract void setName(String name);
    
    public abstract void setType(Object type);
    
    public abstract void setValue(Object value);
    
    public abstract String formatClause(List<IParameter> params);
    
    public Class<?> getEntityType();
    
    public void setEntityType(Class<?> entityType);
    
    public LogicOperator getCriteriaLogicOperator();

    public void setCriteriaLogicOperator(LogicOperator criteriaLogicOperator);
    
}