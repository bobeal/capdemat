package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum SerrrNationaliteType {

    FRANCAISE("Francaise"),
    RESSORTISSANT_U_E("RessortissantUE");


    /**
     * only for backward use SerrrNationaliteType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SerrrNationaliteType[] allSerrrNationaliteTypes = SerrrNationaliteType.values();

    private String legacyLabel;

    private SerrrNationaliteType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SerrrNationaliteType getDefaultSerrrNationaliteType() {
        return FRANCAISE;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SerrrNationaliteType.something
     * not the value of the name attribut.
     */
    public static SerrrNationaliteType forString(final String enumAsString) {
        for (SerrrNationaliteType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSerrrNationaliteType();
    }
}
