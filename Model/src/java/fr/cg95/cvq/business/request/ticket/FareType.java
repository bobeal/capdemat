package fr.cg95.cvq.business.request.ticket;

public enum FareType {

    PLEIN("Plein","Plein"),
    REDUIT("Reduit", "Réduit");

    /**
     * @deprecated only for backward, use FareType.values() instead
     */
    public static final FareType[] allFareTypes = FareType.values();

    private static final long serialVersionUID = 1L;
    private String name;

    private String label;

    private FareType(String type, String label) {
        this.name = type;
        this.label = label;
    }

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
        for (FareType type : values()) {
            if (type.label.equals(enumAsLabel)) return type;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}

