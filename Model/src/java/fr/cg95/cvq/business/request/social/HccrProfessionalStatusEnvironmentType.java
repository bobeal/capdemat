package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrProfessionalStatusEnvironmentType {

    ORDINARY("Ordinary"),
    ADAPTED("Adapted"),
    PROTECTED("Protected");


    /**
     * only for backward use HccrProfessionalStatusEnvironmentType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrProfessionalStatusEnvironmentType[] allHccrProfessionalStatusEnvironmentTypes = HccrProfessionalStatusEnvironmentType.values();

    private String legacyLabel;

    private HccrProfessionalStatusEnvironmentType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrProfessionalStatusEnvironmentType getDefaultHccrProfessionalStatusEnvironmentType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrProfessionalStatusEnvironmentType.something
     * not the value of the name attribut.
     */
    public static HccrProfessionalStatusEnvironmentType forString(final String enumAsString) {
        for (HccrProfessionalStatusEnvironmentType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrProfessionalStatusEnvironmentType();
    }
}
