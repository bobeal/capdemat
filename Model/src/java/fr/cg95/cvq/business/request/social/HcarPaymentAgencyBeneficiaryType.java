package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarPaymentAgencyBeneficiaryType {

    C_A_F("CAF"),
    M_S_A("MSA"),
    OTHER("Other"),
    NO_MEMBER_SHIP("NoMemberShip");


    /**
     * only for backward use HcarPaymentAgencyBeneficiaryType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarPaymentAgencyBeneficiaryType[] allHcarPaymentAgencyBeneficiaryTypes = HcarPaymentAgencyBeneficiaryType.values();

    private String legacyLabel;

    private HcarPaymentAgencyBeneficiaryType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarPaymentAgencyBeneficiaryType getDefaultHcarPaymentAgencyBeneficiaryType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarPaymentAgencyBeneficiaryType.something
     * not the value of the name attribut.
     */
    public static HcarPaymentAgencyBeneficiaryType forString(final String enumAsString) {
        for (HcarPaymentAgencyBeneficiaryType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarPaymentAgencyBeneficiaryType();
    }
}
