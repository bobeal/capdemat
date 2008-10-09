package fr.cg95.cvq.util.quering;

public interface IParameter {
    
    public abstract String getName();
    
    public abstract Object getValue();
    
    public abstract Object getType();
    
    public abstract void setName(String name);
    
    public abstract void setValue(Object value);
    
    public abstract void setType(Object type);
    
}