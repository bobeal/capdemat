package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LcrRequestType {

    INITIAL("initial"),
    EXTENSION("extension");


    /**
     * only for backward use LcrRequestType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LcrRequestType[] allLcrRequestTypes = LcrRequestType.values();

    private String legacyLabel;

    private LcrRequestType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LcrRequestType getDefaultLcrRequestType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LcrRequestType.something
     * not the value of the name attribut.
     */
    public static LcrRequestType forString(final String enumAsString) {
        for (LcrRequestType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLcrRequestType();
    }
}
