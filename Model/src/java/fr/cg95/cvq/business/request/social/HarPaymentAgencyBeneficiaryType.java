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

    public static final HarPaymentAgencyBeneficiaryType INSURED = new HarPaymentAgencyBeneficiaryType("Insured");
    public static final HarPaymentAgencyBeneficiaryType CLAIMANT = new HarPaymentAgencyBeneficiaryType("Claimant");
    public static final HarPaymentAgencyBeneficiaryType NO_MEMBER_SHIP = new HarPaymentAgencyBeneficiaryType("NoMemberShip");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarPaymentAgencyBeneficiaryType(String value) {
       super(value);
    }


    public HarPaymentAgencyBeneficiaryType() {}



    public static HarPaymentAgencyBeneficiaryType[] allHarPaymentAgencyBeneficiaryTypes = {
        INSURED,
        CLAIMANT,
        NO_MEMBER_SHIP
    };


    public static HarPaymentAgencyBeneficiaryType getDefaultHarPaymentAgencyBeneficiaryType() {
        return null;
    }


    public static HarPaymentAgencyBeneficiaryType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarPaymentAgencyBeneficiaryType();

        if (enumAsString.equals(INSURED.toString()))
            return INSURED;
        else if (enumAsString.equals(CLAIMANT.toString()))
            return CLAIMANT;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHarPaymentAgencyBeneficiaryType();
    }
}
