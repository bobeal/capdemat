package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarFamilyDependentActualSituationType {

    SCHOOLING("Schooling"),
    LEARNING("Learning"),
    MEDICO_SOCIAL("MedicoSocial");


    /**
     * only for backward use HcarFamilyDependentActualSituationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarFamilyDependentActualSituationType[] allHcarFamilyDependentActualSituationTypes = HcarFamilyDependentActualSituationType.values();

    private String legacyLabel;

    private HcarFamilyDependentActualSituationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarFamilyDependentActualSituationType getDefaultHcarFamilyDependentActualSituationType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarFamilyDependentActualSituationType.something
     * not the value of the name attribut.
     */
    public static HcarFamilyDependentActualSituationType forString(final String enumAsString) {
        for (HcarFamilyDependentActualSituationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarFamilyDependentActualSituationType();
    }
}
