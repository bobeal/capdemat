package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrHomeSchoolingKindType {

    ALONE("Alone"),
    ACCOMPANIED("Accompanied");


    /**
     * only for backward use HccrHomeSchoolingKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrHomeSchoolingKindType[] allHccrHomeSchoolingKindTypes = HccrHomeSchoolingKindType.values();

    private String legacyLabel;

    private HccrHomeSchoolingKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrHomeSchoolingKindType getDefaultHccrHomeSchoolingKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrHomeSchoolingKindType.something
     * not the value of the name attribut.
     */
    public static HccrHomeSchoolingKindType forString(final String enumAsString) {
        for (HccrHomeSchoolingKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrHomeSchoolingKindType();
    }
}
