package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
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
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarPaymentAgencyBeneficiaryType();

        if (enumAsString.equals(C_A_F.toString()))
            return C_A_F;
        else if (enumAsString.equals(M_S_A.toString()))
            return M_S_A;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHcarPaymentAgencyBeneficiaryType();
    }
}
