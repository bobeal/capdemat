package fr.cg95.cvq.util.quering.sort;

public class SortCriteria implements ISortCriteria {
    protected String name;
    protected Class<?> clazz;
    protected SortDirection direction;
    
    public String formatClause() {
        return String.format(" %1$s.%2$s %3$s, ", 
                this.getClazz().getSimpleName().toLowerCase(),
                this.getName(),
                this.getDirection().value());
    }
    
    public SortCriteria(String name) {
        super();
        this.name = name;
        this.direction = SortDirection.DESC;
    }
    
    public SortCriteria(Class<?> clazz, String name) {
        super();
        this.clazz = clazz;
        this.name = name;
        this.direction = SortDirection.DESC;
    }
    
    public SortCriteria(Class<?> clazz, String name, SortDirection direction) {
        super();
        this.clazz = clazz;
        this.name = name;
        this.direction = direction;
    }
    
    public String getName() {
        return this.name;
    }
    public Class<?> getClazz() {
        return this.clazz;
    }
    public SortDirection getDirection() {
        return this.direction;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }
}
