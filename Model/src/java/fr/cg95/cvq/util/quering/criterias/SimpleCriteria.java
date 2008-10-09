package fr.cg95.cvq.util.quering.criterias;

import java.util.List;
import java.util.UUID;

import org.hibernate.type.Type;

import fr.cg95.cvq.util.quering.BaseOperator;
import fr.cg95.cvq.util.quering.IParameter;
import fr.cg95.cvq.util.quering.LogicOperator;
import fr.cg95.cvq.util.quering.QueryParameter;
import fr.cg95.cvq.util.quering.helpers.HibernateHelper;

public class SimpleCriteria implements ISearchCriteria {
    
    protected String name;
    protected BaseOperator operator;
    protected LogicOperator criteriaLogicOperator; 

    protected Object type;
    protected Object value;
    protected Class<?> entityType;
    
    public String formatClause(List<IParameter> params) {
        String fieldName = this.getFieldName(params);
        params.add(new QueryParameter(fieldName,this.value,this.prepareType()));
        
        return String.format(" %1$s.%2$s %3$s :%4$s ",
                this.entityType.getSimpleName().toLowerCase(), 
                this.getName(), 
                this.getOperator().value(),
                fieldName);
    }
    
    protected String getFieldName(List<IParameter> params) {
        if(name == "" || !this.paramExists(this.name, params))
            return this.generateParamName(name).replace(".", "_");;
        return name.replace(".", "_");
    }
    
    protected boolean paramExists(String name, List<IParameter> params) {
        for(IParameter param : params) {
            if(param.getName() == name) return true;
        }
        return false;
    }
    
    protected String generateParamName(String name) {
       return name +"_"+ UUID.randomUUID().toString().substring(0, 7);
    }
    
    protected Object prepareType() {
        if (type != null && type instanceof Type)
            return this.type;
        else
            return HibernateHelper.mapType(value);
    }
    
    public SimpleCriteria(String name, BaseOperator operator, Object value) {
        super();
        this.name = name;
        this.operator = operator;
        this.value = value;
    }

    public SimpleCriteria(Class<?> entityType, String name, BaseOperator operator, Object value) {
        super();
        this.entityType = entityType;
        this.name = name;
        this.operator = operator;
        this.value = value;
    }

    public SimpleCriteria(Class<?> entityType, String name, BaseOperator operator, Object type,
            Object value) {
        super();
        this.entityType = entityType;
        this.name = name;
        this.operator = operator;
        this.type = type;
        this.value = value;
    }

    public SimpleCriteria(String name, BaseOperator operator, Object value,
            LogicOperator criteriaLogicOperator) {
        super();
        this.name = name;
        this.operator = operator;
        this.value = value;
        this.criteriaLogicOperator = criteriaLogicOperator;
    }

    public SimpleCriteria() {
        super();
    }

    public Class<?> getEntityType() {
        return this.entityType;
    }
    public void setEntityType(Class<?> entityType) {
        this.entityType = entityType;
    }
    public BaseOperator getOperator() {
        return this.operator;
    }
    public void setOperator(BaseOperator operator) {
        this.operator = operator;
    }
    public String getName() {
        return this.name;
    }
    public Object getType() {
        return this.type;
    }
    public Object getValue() {
        return this.value;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(Object type) {
        this.type = type;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public LogicOperator getCriteriaLogicOperator() {
        if(this.criteriaLogicOperator == null) return LogicOperator.AND;
        else return this.criteriaLogicOperator;
    }

    public void setCriteriaLogicOperator(LogicOperator criteriaLogicOperator) {
        this.criteriaLogicOperator = criteriaLogicOperator;
    }
}
