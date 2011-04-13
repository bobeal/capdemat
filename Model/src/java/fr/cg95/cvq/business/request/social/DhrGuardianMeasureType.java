package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrGuardianMeasureType {

    SAFEGUARDING_JUSTICE("safeguardingJustice"),
    GUARDIANSHIP("guardianship"),
    CURATORSHIP("curatorship");


    /**
     * only for backward use DhrGuardianMeasureType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrGuardianMeasureType[] allDhrGuardianMeasureTypes = DhrGuardianMeasureType.values();

    private String legacyLabel;

    private DhrGuardianMeasureType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrGuardianMeasureType getDefaultDhrGuardianMeasureType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrGuardianMeasureType.something
     * not the value of the name attribut.
     */
    public static DhrGuardianMeasureType forString(final String enumAsString) {
        for (DhrGuardianMeasureType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrGuardianMeasureType();
    }
}
