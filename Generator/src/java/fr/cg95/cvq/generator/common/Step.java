package fr.cg95.cvq.generator.common;

/**
 * @author rdj@zenexity.fr
 */
public class Step {

    private int index;
    private String name;
    private String ref;
    
    public Step (String index, String name, String ref) {
        try { 
            this.index = Integer.valueOf(index).intValue();
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Step() - Step index {"+ index +"} is not an integer");
        }
        this.name = name;
        this.ref = ref;
    }
    
    public Step (int index, String name, String ref) {
        this.index = index;
        this.name = name;
        this.ref = ref;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRef() {
        return ref;
    }
    
    public void setRef(String ref) {
        this.ref = ref;
    }
}
