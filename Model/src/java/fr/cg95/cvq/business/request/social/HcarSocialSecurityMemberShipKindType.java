package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
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
        for (HcarSocialSecurityMemberShipKindType value : allHcarSocialSecurityMemberShipKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarSocialSecurityMemberShipKindType();
    }
}
