package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum AncrRequesterQualityType {

    OWNER("Owner"),
    TENANT("Tenant"),
    CABINET("Cabinet");


    /**
     * only for backward use AncrRequesterQualityType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static AncrRequesterQualityType[] allAncrRequesterQualityTypes = AncrRequesterQualityType.values();

    private String legacyLabel;

    private AncrRequesterQualityType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static AncrRequesterQualityType getDefaultAncrRequesterQualityType() {
        return OWNER;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of AncrRequesterQualityType.something
     * not the value of the name attribut.
     */
    public static AncrRequesterQualityType forString(final String enumAsString) {
        for (AncrRequesterQualityType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAncrRequesterQualityType();
    }
}
