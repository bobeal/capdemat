package fr.cg95.cvq.generator.common;

/**
 * @author jsb
 */
public class Autofill {

    public enum AutofillType {
        TRIGGER, LISTENER;
    }

    private AutofillType type;
    private String name;
    private String field;

    public Autofill(AutofillType type, String name, String field) {
        this.type = type;
        this.name = name;
        this.field = field;
    }

    public AutofillType getType() {
        return type;
    }

    public String getTypeAsString() {
        return type.name().toLowerCase();
    }

    public void setType(AutofillType type) {
        this.type = type;
    }
    
    public void setType(String type) {
        this.type = AutofillType.valueOf(type.toUpperCase());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
