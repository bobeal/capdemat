package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarProfessionalStatusKindType {

    EMPLOYEE("Employee"),
    UNEMPLOYED("Unemployed"),
    JOBLESS("Jobless"),
    STUDENT("Student"),
    RETIRED("Retired");


    /**
     * only for backward use HcarProfessionalStatusKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarProfessionalStatusKindType[] allHcarProfessionalStatusKindTypes = HcarProfessionalStatusKindType.values();

    private String legacyLabel;

    private HcarProfessionalStatusKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarProfessionalStatusKindType getDefaultHcarProfessionalStatusKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarProfessionalStatusKindType.something
     * not the value of the name attribut.
     */
    public static HcarProfessionalStatusKindType forString(final String enumAsString) {
        for (HcarProfessionalStatusKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarProfessionalStatusKindType();
    }
}
