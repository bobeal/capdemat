package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrPaymentAgencyBeneficiaryType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrPaymentAgencyBeneficiaryType C_A_F = new HccrPaymentAgencyBeneficiaryType("CAF");
  
    public static final HccrPaymentAgencyBeneficiaryType M_S_A = new HccrPaymentAgencyBeneficiaryType("MSA");
  
    public static final HccrPaymentAgencyBeneficiaryType OTHER = new HccrPaymentAgencyBeneficiaryType("Other");
  
    public static final HccrPaymentAgencyBeneficiaryType NO_MEMBER_SHIP = new HccrPaymentAgencyBeneficiaryType("NoMemberShip");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrPaymentAgencyBeneficiaryType(String value) {
        super(value);
    }

    public HccrPaymentAgencyBeneficiaryType() {}

    public static HccrPaymentAgencyBeneficiaryType[] allHccrPaymentAgencyBeneficiaryTypes = {
        C_A_F,
        M_S_A,
        OTHER,
        NO_MEMBER_SHIP
    };

    public static HccrPaymentAgencyBeneficiaryType getDefaultHccrPaymentAgencyBeneficiaryType() {
        return null;
    }

    public static HccrPaymentAgencyBeneficiaryType forString(final String enumAsString) {
        for (HccrPaymentAgencyBeneficiaryType value : allHccrPaymentAgencyBeneficiaryTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrPaymentAgencyBeneficiaryType();
    }
}
