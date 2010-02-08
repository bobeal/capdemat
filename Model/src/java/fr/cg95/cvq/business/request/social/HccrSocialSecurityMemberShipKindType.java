package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
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
        for (HccrSocialSecurityMemberShipKindType value : allHccrSocialSecurityMemberShipKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrSocialSecurityMemberShipKindType();
    }
}
