package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarPaymentAgencyBeneficiaryType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarPaymentAgencyBeneficiaryType C_A_F = new HcarPaymentAgencyBeneficiaryType("CAF");
  
    public static final HcarPaymentAgencyBeneficiaryType M_S_A = new HcarPaymentAgencyBeneficiaryType("MSA");
  
    public static final HcarPaymentAgencyBeneficiaryType OTHER = new HcarPaymentAgencyBeneficiaryType("Other");
  
    public static final HcarPaymentAgencyBeneficiaryType NO_MEMBER_SHIP = new HcarPaymentAgencyBeneficiaryType("NoMemberShip");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarPaymentAgencyBeneficiaryType(String value) {
        super(value);
    }

    public HcarPaymentAgencyBeneficiaryType() {}

    public static HcarPaymentAgencyBeneficiaryType[] allHcarPaymentAgencyBeneficiaryTypes = {
        C_A_F,
        M_S_A,
        OTHER,
        NO_MEMBER_SHIP
    };

    public static HcarPaymentAgencyBeneficiaryType getDefaultHcarPaymentAgencyBeneficiaryType() {
        return null;
    }

    public static HcarPaymentAgencyBeneficiaryType forString(final String enumAsString) {
        for (HcarPaymentAgencyBeneficiaryType value : allHcarPaymentAgencyBeneficiaryTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarPaymentAgencyBeneficiaryType();
    }
}
