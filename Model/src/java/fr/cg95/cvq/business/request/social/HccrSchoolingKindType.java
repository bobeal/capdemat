package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrSchoolingKindType {

    FULL_TIME("FullTime"),
    PART_TIME("PartTime");


    /**
     * only for backward use HccrSchoolingKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrSchoolingKindType[] allHccrSchoolingKindTypes = HccrSchoolingKindType.values();

    private String legacyLabel;

    private HccrSchoolingKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrSchoolingKindType getDefaultHccrSchoolingKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrSchoolingKindType.something
     * not the value of the name attribut.
     */
    public static HccrSchoolingKindType forString(final String enumAsString) {
        for (HccrSchoolingKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrSchoolingKindType();
    }
}
