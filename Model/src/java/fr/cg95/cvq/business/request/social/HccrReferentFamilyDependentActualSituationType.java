package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrReferentFamilyDependentActualSituationType {

    SCHOOLING("Schooling"),
    LEARNING("Learning"),
    MEDICO_SOCIAL("MedicoSocial");


    /**
     * only for backward use HccrReferentFamilyDependentActualSituationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrReferentFamilyDependentActualSituationType[] allHccrReferentFamilyDependentActualSituationTypes = HccrReferentFamilyDependentActualSituationType.values();

    private String legacyLabel;

    private HccrReferentFamilyDependentActualSituationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrReferentFamilyDependentActualSituationType getDefaultHccrReferentFamilyDependentActualSituationType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrReferentFamilyDependentActualSituationType.something
     * not the value of the name attribut.
     */
    public static HccrReferentFamilyDependentActualSituationType forString(final String enumAsString) {
        for (HccrReferentFamilyDependentActualSituationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrReferentFamilyDependentActualSituationType();
    }
}
