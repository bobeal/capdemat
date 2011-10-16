package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LtswrRequesterType {

    LANDLORD("landlord"),
    CONTRACTOR("contractor"),
    COLLECTIVITY("collectivity");


    /**
     * only for backward use LtswrRequesterType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LtswrRequesterType[] allLtswrRequesterTypes = LtswrRequesterType.values();

    private String legacyLabel;

    private LtswrRequesterType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LtswrRequesterType getDefaultLtswrRequesterType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LtswrRequesterType.something
     * not the value of the name attribut.
     */
    public static LtswrRequesterType forString(final String enumAsString) {
        for (LtswrRequesterType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLtswrRequesterType();
    }
}
