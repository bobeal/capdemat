package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ALevelsType {

    ES("es"),
    L("l"),
    S("s"),
    STG("stg"),
    STI("sti"),
    STL("stl"),
    ST2S("st2s"),
    STAV("stav"),
    TMD("tmd"),
    H("h"),
    P("p");


    /**
     * only for backward use ALevelsType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ALevelsType[] allALevelsTypes = ALevelsType.values();

    private String legacyLabel;

    private ALevelsType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ALevelsType getDefaultALevelsType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ALevelsType.something
     * not the value of the name attribut.
     */
    public static ALevelsType forString(final String enumAsString) {
        for (ALevelsType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultALevelsType();
    }
}
