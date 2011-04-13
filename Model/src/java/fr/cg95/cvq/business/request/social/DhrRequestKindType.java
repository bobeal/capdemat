package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrRequestKindType {

    INDIVIDUAL("Individual"),
    COUPLE("Couple");


    /**
     * only for backward use DhrRequestKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrRequestKindType[] allDhrRequestKindTypes = DhrRequestKindType.values();

    private String legacyLabel;

    private DhrRequestKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrRequestKindType getDefaultDhrRequestKindType() {
        return INDIVIDUAL;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrRequestKindType.something
     * not the value of the name attribut.
     */
    public static DhrRequestKindType forString(final String enumAsString) {
        for (DhrRequestKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrRequestKindType();
    }
}
