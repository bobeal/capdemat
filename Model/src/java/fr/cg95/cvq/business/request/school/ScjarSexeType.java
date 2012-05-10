package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjarSexeType {

    MALE("Male"),
    FEMALE("Female");


    /**
     * only for backward use ScjarSexeType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjarSexeType[] allScjarSexeTypes = ScjarSexeType.values();

    private String legacyLabel;

    private ScjarSexeType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjarSexeType getDefaultScjarSexeType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjarSexeType.something
     * not the value of the name attribut.
     */
    public static ScjarSexeType forString(final String enumAsString) {
        for (ScjarSexeType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjarSexeType();
    }
}
