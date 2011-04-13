package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrSocialSecurityMemberShipKindType {

    INSURED("Insured"),
    CLAIMANT("Claimant"),
    NO_MEMBER_SHIP("NoMemberShip");


    /**
     * only for backward use HccrSocialSecurityMemberShipKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrSocialSecurityMemberShipKindType[] allHccrSocialSecurityMemberShipKindTypes = HccrSocialSecurityMemberShipKindType.values();

    private String legacyLabel;

    private HccrSocialSecurityMemberShipKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrSocialSecurityMemberShipKindType getDefaultHccrSocialSecurityMemberShipKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrSocialSecurityMemberShipKindType.something
     * not the value of the name attribut.
     */
    public static HccrSocialSecurityMemberShipKindType forString(final String enumAsString) {
        for (HccrSocialSecurityMemberShipKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrSocialSecurityMemberShipKindType();
    }
}
