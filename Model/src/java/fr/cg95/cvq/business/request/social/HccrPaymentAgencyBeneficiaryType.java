package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
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
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHccrPaymentAgencyBeneficiaryType();

        if (enumAsString.equals(C_A_F.toString()))
            return C_A_F;
        else if (enumAsString.equals(M_S_A.toString()))
            return M_S_A;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHccrPaymentAgencyBeneficiaryType();
    }
}
