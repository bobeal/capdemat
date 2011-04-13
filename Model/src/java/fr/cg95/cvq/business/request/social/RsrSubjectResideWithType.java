package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum RsrSubjectResideWithType {

    ALONE("Alone"),
    COUPLE("Couple"),
    FAMILY("Family");


    /**
     * only for backward use RsrSubjectResideWithType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static RsrSubjectResideWithType[] allRsrSubjectResideWithTypes = RsrSubjectResideWithType.values();

    private String legacyLabel;

    private RsrSubjectResideWithType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static RsrSubjectResideWithType getDefaultRsrSubjectResideWithType() {
        return ALONE;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of RsrSubjectResideWithType.something
     * not the value of the name attribut.
     */
    public static RsrSubjectResideWithType forString(final String enumAsString) {
        for (RsrSubjectResideWithType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRsrSubjectResideWithType();
    }
}
