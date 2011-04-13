package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrPrincipalPensionPlanType {

    C_N_A_V("CNAV"),
    M_S_A("MSA"),
    C_R_A_M("CRAM"),
    M_G_E_N("MGEN"),
    S_N_C_F("SNCF"),
    OTHER("Other");


    /**
     * only for backward use DhrPrincipalPensionPlanType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrPrincipalPensionPlanType[] allDhrPrincipalPensionPlanTypes = DhrPrincipalPensionPlanType.values();

    private String legacyLabel;

    private DhrPrincipalPensionPlanType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrPrincipalPensionPlanType getDefaultDhrPrincipalPensionPlanType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrPrincipalPensionPlanType.something
     * not the value of the name attribut.
     */
    public static DhrPrincipalPensionPlanType forString(final String enumAsString) {
        for (DhrPrincipalPensionPlanType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrPrincipalPensionPlanType();
    }
}
