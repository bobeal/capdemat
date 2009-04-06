package fr.cg95.cvq.generator.common;

/**
 * @author rdj@zenexity.fr
 */
public class Widget {
    
    public enum WidgetType { 
        SUBJECT, REQUESTER ;
        
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
    private String into;
    
    public Widget(String name, String into){
        try {
            WidgetType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("Widget() - widget type {"+ name +"} is not one of " +
                    "{"+ WidgetType.valuesAsString() +"}");
        }
        this.name = name;
        this.into = into;
    }

    public String getName() {
        return name;
    }

    public String getInto() {
        return into;
    }
}
