package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrProfessionalStatusKindType {

    EMPLOYEE("Employee"),
    UNEMPLOYED("Unemployed"),
    JOBLESS("Jobless"),
    STUDENT("Student"),
    RETIRED("Retired");


    /**
     * only for backward use HccrProfessionalStatusKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrProfessionalStatusKindType[] allHccrProfessionalStatusKindTypes = HccrProfessionalStatusKindType.values();

    private String legacyLabel;

    private HccrProfessionalStatusKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrProfessionalStatusKindType getDefaultHccrProfessionalStatusKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrProfessionalStatusKindType.something
     * not the value of the name attribut.
     */
    public static HccrProfessionalStatusKindType forString(final String enumAsString) {
        for (HccrProfessionalStatusKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrProfessionalStatusKindType();
    }
}
