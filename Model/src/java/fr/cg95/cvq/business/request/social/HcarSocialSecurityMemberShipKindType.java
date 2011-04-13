package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarSocialSecurityMemberShipKindType {

    INSURED("Insured"),
    CLAIMANT("Claimant"),
    NO_MEMBER_SHIP("NoMemberShip");


    /**
     * only for backward use HcarSocialSecurityMemberShipKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarSocialSecurityMemberShipKindType[] allHcarSocialSecurityMemberShipKindTypes = HcarSocialSecurityMemberShipKindType.values();

    private String legacyLabel;

    private HcarSocialSecurityMemberShipKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarSocialSecurityMemberShipKindType getDefaultHcarSocialSecurityMemberShipKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarSocialSecurityMemberShipKindType.something
     * not the value of the name attribut.
     */
    public static HcarSocialSecurityMemberShipKindType forString(final String enumAsString) {
        for (HcarSocialSecurityMemberShipKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarSocialSecurityMemberShipKindType();
    }
}
