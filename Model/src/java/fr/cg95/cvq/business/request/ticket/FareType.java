package fr.cg95.cvq.business.request.ticket;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public class FareType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final FareType PLEIN = new FareType("Plein","Plein");
    public static final FareType REDUIT = new FareType("Reduit", "Réduit");

    public static final FareType[] allFareTypes = { PLEIN, REDUIT };

    private String label;

    private FareType(String type, String label) {
        super(type);
        this.label = label;
    }

    public FareType() { /* Empty constructor for Hibernate */ }

    public String getLabel(){
        return label;
    }

    public static FareType forString(String enumAsString) {
        for (FareType type : allFareTypes) {
            if (type.toString().equals(enumAsString)) return type;
        }
        return null;
    }

    public static FareType forLabel(String enumAsLabel) {
        for (FareType type : allFareTypes) {
            if (type.label.equals(enumAsLabel)) return type;
        }
        return null;
    }
}

