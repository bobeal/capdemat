package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarSocialSecurityMemberShipKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarSocialSecurityMemberShipKindType INSURED = new HcarSocialSecurityMemberShipKindType("Insured");
    public static final HcarSocialSecurityMemberShipKindType CLAIMANT = new HcarSocialSecurityMemberShipKindType("Claimant");
    public static final HcarSocialSecurityMemberShipKindType NO_MEMBER_SHIP = new HcarSocialSecurityMemberShipKindType("NoMemberShip");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarSocialSecurityMemberShipKindType(String value) {
       super(value);
    }


    public HcarSocialSecurityMemberShipKindType() {}



    public static HcarSocialSecurityMemberShipKindType[] allHcarSocialSecurityMemberShipKindTypes = {
        INSURED,
        CLAIMANT,
        NO_MEMBER_SHIP
    };


    public static HcarSocialSecurityMemberShipKindType getDefaultHcarSocialSecurityMemberShipKindType() {
        return null;
    }


    public static HcarSocialSecurityMemberShipKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarSocialSecurityMemberShipKindType();

        if (enumAsString.equals(INSURED.toString()))
            return INSURED;
        else if (enumAsString.equals(CLAIMANT.toString()))
            return CLAIMANT;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHcarSocialSecurityMemberShipKindType();
    }
}
