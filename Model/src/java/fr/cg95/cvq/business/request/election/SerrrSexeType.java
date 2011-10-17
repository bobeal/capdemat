package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum SerrrSexeType {

    FEMININ("Feminin"),
    MASCULIN("Masculin");


    /**
     * only for backward use SerrrSexeType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SerrrSexeType[] allSerrrSexeTypes = SerrrSexeType.values();

    private String legacyLabel;

    private SerrrSexeType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SerrrSexeType getDefaultSerrrSexeType() {
        return MASCULIN;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SerrrSexeType.something
     * not the value of the name attribut.
     */
    public static SerrrSexeType forString(final String enumAsString) {
        for (SerrrSexeType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSerrrSexeType();
    }
}
