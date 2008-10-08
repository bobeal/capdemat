package fr.cg95.cvq.util.quering;

/**
 * Defines field that will be selected in HQL query
 * 
 * @author vba@zenexity.fr
 *
 */
public class SelectField implements ISelectArgument {
    protected Class<?> clazz;
    protected String name;

    public SelectField() {
        super();
    }
    public SelectField(Class<?> clazz, String name) {
        super();
        this.clazz = clazz;
        this.name = name;
    }
    
    public SelectField(String name) {
        super();
        this.clazz = null;
        this.name = name;
    }
    
    public String formatClause() {
        return String.format(" %1$s.%2$s, ", 
                this.getClazz().getSimpleName().toLowerCase(),
                this.getName());
    }
    
    public Class<?> getClazz() {
        return this.clazz;
    }
    public String getName() {
        return this.name;
    }
    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
    public void setName(String name) {
        this.name = name;
    }
}
