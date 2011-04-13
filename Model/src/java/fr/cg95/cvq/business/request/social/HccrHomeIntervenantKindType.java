package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrHomeIntervenantKindType {

    CARER("Carer"),
    HOME_HELP("HomeHelp"),
    OTHER("Other");


    /**
     * only for backward use HccrHomeIntervenantKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrHomeIntervenantKindType[] allHccrHomeIntervenantKindTypes = HccrHomeIntervenantKindType.values();

    private String legacyLabel;

    private HccrHomeIntervenantKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrHomeIntervenantKindType getDefaultHccrHomeIntervenantKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrHomeIntervenantKindType.something
     * not the value of the name attribut.
     */
    public static HccrHomeIntervenantKindType forString(final String enumAsString) {
        for (HccrHomeIntervenantKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrHomeIntervenantKindType();
    }
}
