package fr.cg95.cvq.util.quering;

public class QueryParameter implements IParameter {
    
    protected String name;
    protected Object value;
    protected Object type;
    
    public QueryParameter() {
    }
    public QueryParameter(String name, Object value, Object type) {
        super();
        this.name = name;
        this.value = value;
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public Object getValue() {
        return this.value;
    }
    public Object getType() {
        return this.type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public void setType(Object type) {
        this.type = type;
    }
}
