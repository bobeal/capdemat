package fr.cg95.cvq.business.users;

public enum MeansOfContactEnum {

    MAIL("Mail"),
    EMAIL("Email"),
    HOME_PHONE("HomePhone"),
    OFFICE_PHONE("OfficePhone"),
    MOBILE_PHONE("MobilePhone"),
    SMS("Sms"),
    LOCAL_AUTHORITY_OFFICE("LocalAuthorityOffice");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MeansOfContactEnum(String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }

    /**
     * @deprecated only for backward, use MeansOfContactEnum.values() instead
     */
    public static final MeansOfContactEnum[] allMeansOfContactEnums = MeansOfContactEnum.values();

    public static MeansOfContactEnum forString(String enumAsString) {
        for (MeansOfContactEnum moce : values()) {
            if (moce.toString().equals(enumAsString))
                return moce;
        }
        return null;
    }
}
