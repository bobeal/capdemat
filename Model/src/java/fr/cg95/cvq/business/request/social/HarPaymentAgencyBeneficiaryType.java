package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarPaymentAgencyBeneficiaryType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarPaymentAgencyBeneficiaryType C_A_F = new HarPaymentAgencyBeneficiaryType("CAF");
    public static final HarPaymentAgencyBeneficiaryType M_S_A = new HarPaymentAgencyBeneficiaryType("MSA");
    public static final HarPaymentAgencyBeneficiaryType OTHER = new HarPaymentAgencyBeneficiaryType("Other");
    public static final HarPaymentAgencyBeneficiaryType NO_MEMBER_SHIP = new HarPaymentAgencyBeneficiaryType("NoMemberShip");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarPaymentAgencyBeneficiaryType(String value) {
       super(value);
    }


    public HarPaymentAgencyBeneficiaryType() {}



    public static HarPaymentAgencyBeneficiaryType[] allHarPaymentAgencyBeneficiaryTypes = {
        C_A_F,
        M_S_A,
        OTHER,
        NO_MEMBER_SHIP
    };


    public static HarPaymentAgencyBeneficiaryType getDefaultHarPaymentAgencyBeneficiaryType() {
        return null;
    }


    public static HarPaymentAgencyBeneficiaryType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarPaymentAgencyBeneficiaryType();

        if (enumAsString.equals(C_A_F.toString()))
            return C_A_F;
        else if (enumAsString.equals(M_S_A.toString()))
            return M_S_A;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHarPaymentAgencyBeneficiaryType();
    }
}
