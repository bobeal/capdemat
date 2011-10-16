package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LcrRequesterType {

    LANDLORD("landlord"),
    CONTRACTOR("contractor"),
    COLLECTIVITY("collectivity");


    /**
     * only for backward use LcrRequesterType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LcrRequesterType[] allLcrRequesterTypes = LcrRequesterType.values();

    private String legacyLabel;

    private LcrRequesterType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LcrRequesterType getDefaultLcrRequesterType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LcrRequesterType.something
     * not the value of the name attribut.
     */
    public static LcrRequesterType forString(final String enumAsString) {
        for (LcrRequesterType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLcrRequesterType();
    }
}
