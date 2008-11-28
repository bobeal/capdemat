package fr.cg95.cvq.util.quering.sort;

public interface ISortCriteria {
    
    public abstract String formatClause();
    
    public abstract String getName();
    
    public abstract Class<?> getClazz();
    
    public abstract SortDirection getDirection();
    
    public abstract void setName(String name);
    
    public abstract void setClazz(Class<?> clazz);
    
    public abstract void setDirection(SortDirection direction);
    
}