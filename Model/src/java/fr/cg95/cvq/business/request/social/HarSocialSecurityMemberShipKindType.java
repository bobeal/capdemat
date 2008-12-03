package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarSocialSecurityMemberShipKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarSocialSecurityMemberShipKindType INSURED = new HarSocialSecurityMemberShipKindType("Insured");
    public static final HarSocialSecurityMemberShipKindType CLAIMANT = new HarSocialSecurityMemberShipKindType("Claimant");
    public static final HarSocialSecurityMemberShipKindType NO_MEMBER_SHIP = new HarSocialSecurityMemberShipKindType("NoMemberShip");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarSocialSecurityMemberShipKindType(String value) {
       super(value);
    }


    public HarSocialSecurityMemberShipKindType() {}



    public static HarSocialSecurityMemberShipKindType[] allHarSocialSecurityMemberShipKindTypes = {
        INSURED,
        CLAIMANT,
        NO_MEMBER_SHIP
    };


    public static HarSocialSecurityMemberShipKindType getDefaultHarSocialSecurityMemberShipKindType() {
        return null;
    }


    public static HarSocialSecurityMemberShipKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarSocialSecurityMemberShipKindType();

        if (enumAsString.equals(INSURED.toString()))
            return INSURED;
        else if (enumAsString.equals(CLAIMANT.toString()))
            return CLAIMANT;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHarSocialSecurityMemberShipKindType();
    }
}
