package fr.cg95.cvq.generator.common;

/**
 * @author rdj@zenexity.fr
 */
public class Condition {
    
    public enum ConditionType { 
        TRIGGER, FILLED, UNFILLED;
        
        public static String valuesAsString() {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < values().length; i++) {
                sb.append(values()[i].toString().toLowerCase());
                if (i < values().length -1)
                    sb.append("|");
            }
            return sb.toString();
        }
    }
    
    private String name;
    private String type;
    private boolean required = false;
    
    public Condition(String name, String type, String requiredString) {
        this.name = name;
        this.type = type;
        this.required = new Boolean(requiredString).booleanValue();
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

    public boolean isRequired() {
        return required;
    }
}
