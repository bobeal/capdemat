package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarProfessionalStatusEnvironmentType {

    ORDINARY("Ordinary"),
    ADAPTED("Adapted"),
    PROTECTED("Protected");


    /**
     * only for backward use HcarProfessionalStatusEnvironmentType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarProfessionalStatusEnvironmentType[] allHcarProfessionalStatusEnvironmentTypes = HcarProfessionalStatusEnvironmentType.values();

    private String legacyLabel;

    private HcarProfessionalStatusEnvironmentType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarProfessionalStatusEnvironmentType getDefaultHcarProfessionalStatusEnvironmentType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarProfessionalStatusEnvironmentType.something
     * not the value of the name attribut.
     */
    public static HcarProfessionalStatusEnvironmentType forString(final String enumAsString) {
        for (HcarProfessionalStatusEnvironmentType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarProfessionalStatusEnvironmentType();
    }
}
