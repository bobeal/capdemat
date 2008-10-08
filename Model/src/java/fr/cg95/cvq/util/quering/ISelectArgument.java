package fr.cg95.cvq.util.quering;

public interface ISelectArgument {
    
    public abstract String formatClause();
    
    public abstract Class<?> getClazz();
    
    public abstract void setClazz(Class<?> clazz);
    
}