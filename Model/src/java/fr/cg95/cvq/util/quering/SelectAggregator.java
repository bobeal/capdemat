package fr.cg95.cvq.util.quering;

public class SelectAggregator implements ISelectArgument {
    
    protected String value;
    
    public SelectAggregator(String value) {
        super();
        this.value = value;
    }

    public String formatClause() {
        return String.format(" %1$s, ", this.value);
    }
    
    public Class<?> getClazz() {
        return null;
    }
    
    public void setClazz(Class<?> clazz) {
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
    
}
