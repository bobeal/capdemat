package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarHomeIntervenantKindType {

    CARER("Carer"),
    HOME_HELP("HomeHelp"),
    OTHER("Other");


    /**
     * only for backward use HcarHomeIntervenantKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarHomeIntervenantKindType[] allHcarHomeIntervenantKindTypes = HcarHomeIntervenantKindType.values();

    private String legacyLabel;

    private HcarHomeIntervenantKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarHomeIntervenantKindType getDefaultHcarHomeIntervenantKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarHomeIntervenantKindType.something
     * not the value of the name attribut.
     */
    public static HcarHomeIntervenantKindType forString(final String enumAsString) {
        for (HcarHomeIntervenantKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarHomeIntervenantKindType();
    }
}
