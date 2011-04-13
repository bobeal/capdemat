package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrDwellingKindType {

    PLACE_OF_RESIDENCE("placeOfResidence"),
    RETIREMENT_HOME("retirementHome"),
    OTHER("other");


    /**
     * only for backward use DhrDwellingKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrDwellingKindType[] allDhrDwellingKindTypes = DhrDwellingKindType.values();

    private String legacyLabel;

    private DhrDwellingKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrDwellingKindType getDefaultDhrDwellingKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrDwellingKindType.something
     * not the value of the name attribut.
     */
    public static DhrDwellingKindType forString(final String enumAsString) {
        for (DhrDwellingKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrDwellingKindType();
    }
}
