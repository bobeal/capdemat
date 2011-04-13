package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum AcrRequesterQualityType {

    OWNER("Owner"),
    TENANT("Tenant");


    /**
     * only for backward use AcrRequesterQualityType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static AcrRequesterQualityType[] allAcrRequesterQualityTypes = AcrRequesterQualityType.values();

    private String legacyLabel;

    private AcrRequesterQualityType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static AcrRequesterQualityType getDefaultAcrRequesterQualityType() {
        return OWNER;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of AcrRequesterQualityType.something
     * not the value of the name attribut.
     */
    public static AcrRequesterQualityType forString(final String enumAsString) {
        for (AcrRequesterQualityType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAcrRequesterQualityType();
    }
}
