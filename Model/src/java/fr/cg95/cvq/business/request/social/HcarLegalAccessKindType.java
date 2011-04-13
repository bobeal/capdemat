package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarLegalAccessKindType {

    SAFEGUARDING_JUSTICE("safeguardingJustice"),
    GUARDIANSHIP("guardianship"),
    CURATORSHIP("curatorship");


    /**
     * only for backward use HcarLegalAccessKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarLegalAccessKindType[] allHcarLegalAccessKindTypes = HcarLegalAccessKindType.values();

    private String legacyLabel;

    private HcarLegalAccessKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarLegalAccessKindType getDefaultHcarLegalAccessKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarLegalAccessKindType.something
     * not the value of the name attribut.
     */
    public static HcarLegalAccessKindType forString(final String enumAsString) {
        for (HcarLegalAccessKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarLegalAccessKindType();
    }
}
