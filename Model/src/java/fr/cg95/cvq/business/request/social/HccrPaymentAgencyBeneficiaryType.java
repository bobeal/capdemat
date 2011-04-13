package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrPaymentAgencyBeneficiaryType {

    C_A_F("CAF"),
    M_S_A("MSA"),
    OTHER("Other"),
    NO_MEMBER_SHIP("NoMemberShip");


    /**
     * only for backward use HccrPaymentAgencyBeneficiaryType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrPaymentAgencyBeneficiaryType[] allHccrPaymentAgencyBeneficiaryTypes = HccrPaymentAgencyBeneficiaryType.values();

    private String legacyLabel;

    private HccrPaymentAgencyBeneficiaryType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrPaymentAgencyBeneficiaryType getDefaultHccrPaymentAgencyBeneficiaryType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrPaymentAgencyBeneficiaryType.something
     * not the value of the name attribut.
     */
    public static HccrPaymentAgencyBeneficiaryType forString(final String enumAsString) {
        for (HccrPaymentAgencyBeneficiaryType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrPaymentAgencyBeneficiaryType();
    }
}
