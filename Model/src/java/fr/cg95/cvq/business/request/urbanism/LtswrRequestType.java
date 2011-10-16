package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LtswrRequestType {

    INITIAL("initial"),
    EXTENSION("extension");


    /**
     * only for backward use LtswrRequestType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LtswrRequestType[] allLtswrRequestTypes = LtswrRequestType.values();

    private String legacyLabel;

    private LtswrRequestType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LtswrRequestType getDefaultLtswrRequestType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LtswrRequestType.something
     * not the value of the name attribut.
     */
    public static LtswrRequestType forString(final String enumAsString) {
        for (LtswrRequestType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLtswrRequestType();
    }
}
