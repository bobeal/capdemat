package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum DistanceType {

    UNDETERMINED("undetermined"),
    LESS_THAN30KMS("lessThan30kms"),
    BETWEEN30AND250KMS("between30and250kms"),
    MORE_THAN250KMS_AND_ABROAD("moreThan250kmsAndAbroad");


    /**
     * only for backward use DistanceType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DistanceType[] allDistanceTypes = DistanceType.values();

    private String legacyLabel;

    private DistanceType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DistanceType getDefaultDistanceType() {
        return UNDETERMINED;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DistanceType.something
     * not the value of the name attribut.
     */
    public static DistanceType forString(final String enumAsString) {
        for (DistanceType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDistanceType();
    }
}
