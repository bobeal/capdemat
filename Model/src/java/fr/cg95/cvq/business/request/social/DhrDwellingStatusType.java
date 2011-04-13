package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrDwellingStatusType {

    OWNER("owner"),
    TENANT("tenant");


    /**
     * only for backward use DhrDwellingStatusType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrDwellingStatusType[] allDhrDwellingStatusTypes = DhrDwellingStatusType.values();

    private String legacyLabel;

    private DhrDwellingStatusType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrDwellingStatusType getDefaultDhrDwellingStatusType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrDwellingStatusType.something
     * not the value of the name attribut.
     */
    public static DhrDwellingStatusType forString(final String enumAsString) {
        for (DhrDwellingStatusType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrDwellingStatusType();
    }
}
