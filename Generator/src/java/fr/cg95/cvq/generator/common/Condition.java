package fr.cg95.cvq.generator.common;

/**
 * @author rdj@zenexity.fr
 */
public class Condition {

    private String name;
    private String type;
    
    public Condition(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
