package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum RsrRequestInformationRequestKindType {

    INDIVIDUAL("Individual"),
    COUPLE("Couple");


    /**
     * only for backward use RsrRequestInformationRequestKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static RsrRequestInformationRequestKindType[] allRsrRequestInformationRequestKindTypes = RsrRequestInformationRequestKindType.values();

    private String legacyLabel;

    private RsrRequestInformationRequestKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static RsrRequestInformationRequestKindType getDefaultRsrRequestInformationRequestKindType() {
        return INDIVIDUAL;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of RsrRequestInformationRequestKindType.something
     * not the value of the name attribut.
     */
    public static RsrRequestInformationRequestKindType forString(final String enumAsString) {
        for (RsrRequestInformationRequestKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRsrRequestInformationRequestKindType();
    }
}
