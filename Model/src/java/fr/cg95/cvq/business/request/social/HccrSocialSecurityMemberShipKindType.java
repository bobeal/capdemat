package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HccrSocialSecurityMemberShipKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HccrSocialSecurityMemberShipKindType INSURED = new HccrSocialSecurityMemberShipKindType("Insured");
    public static final HccrSocialSecurityMemberShipKindType CLAIMANT = new HccrSocialSecurityMemberShipKindType("Claimant");
    public static final HccrSocialSecurityMemberShipKindType NO_MEMBER_SHIP = new HccrSocialSecurityMemberShipKindType("NoMemberShip");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrSocialSecurityMemberShipKindType(String value) {
       super(value);
    }


    public HccrSocialSecurityMemberShipKindType() {}



    public static HccrSocialSecurityMemberShipKindType[] allHccrSocialSecurityMemberShipKindTypes = {
        INSURED,
        CLAIMANT,
        NO_MEMBER_SHIP
    };


    public static HccrSocialSecurityMemberShipKindType getDefaultHccrSocialSecurityMemberShipKindType() {
        return null;
    }


    public static HccrSocialSecurityMemberShipKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHccrSocialSecurityMemberShipKindType();

        if (enumAsString.equals(INSURED.toString()))
            return INSURED;
        else if (enumAsString.equals(CLAIMANT.toString()))
            return CLAIMANT;
        else if (enumAsString.equals(NO_MEMBER_SHIP.toString()))
            return NO_MEMBER_SHIP;

        return getDefaultHccrSocialSecurityMemberShipKindType();
    }
}
