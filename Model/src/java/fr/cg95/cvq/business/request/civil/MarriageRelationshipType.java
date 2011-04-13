package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum MarriageRelationshipType {

    HUSBAND("Husband"),
    WIFE("Wife");


    /**
     * only for backward use MarriageRelationshipType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static MarriageRelationshipType[] allMarriageRelationshipTypes = MarriageRelationshipType.values();

    private String legacyLabel;

    private MarriageRelationshipType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static MarriageRelationshipType getDefaultMarriageRelationshipType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of MarriageRelationshipType.something
     * not the value of the name attribut.
     */
    public static MarriageRelationshipType forString(final String enumAsString) {
        for (MarriageRelationshipType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageRelationshipType();
    }
}
