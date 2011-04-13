package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum ScrRequesterQualityType {

    OWNER("Owner"),
    TENANT("Tenant");


    /**
     * only for backward use ScrRequesterQualityType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScrRequesterQualityType[] allScrRequesterQualityTypes = ScrRequesterQualityType.values();

    private String legacyLabel;

    private ScrRequesterQualityType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScrRequesterQualityType getDefaultScrRequesterQualityType() {
        return OWNER;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScrRequesterQualityType.something
     * not the value of the name attribut.
     */
    public static ScrRequesterQualityType forString(final String enumAsString) {
        for (ScrRequesterQualityType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScrRequesterQualityType();
    }
}
