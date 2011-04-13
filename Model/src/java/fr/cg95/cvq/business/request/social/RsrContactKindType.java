package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum RsrContactKindType {

    REQUESTER("Requester"),
    OTHER("Other");


    /**
     * only for backward use RsrContactKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static RsrContactKindType[] allRsrContactKindTypes = RsrContactKindType.values();

    private String legacyLabel;

    private RsrContactKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static RsrContactKindType getDefaultRsrContactKindType() {
        return REQUESTER;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of RsrContactKindType.something
     * not the value of the name attribut.
     */
    public static RsrContactKindType forString(final String enumAsString) {
        for (RsrContactKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRsrContactKindType();
    }
}
