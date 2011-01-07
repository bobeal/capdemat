package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public class MeansOfContactEnum extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final MeansOfContactEnum MAIL = new MeansOfContactEnum("Mail");
    public static final MeansOfContactEnum EMAIL = new MeansOfContactEnum("Email");
    public static final MeansOfContactEnum HOME_PHONE = new MeansOfContactEnum("HomePhone");
    public static final MeansOfContactEnum OFFICE_PHONE = new MeansOfContactEnum("OfficePhone");
    public static final MeansOfContactEnum MOBILE_PHONE = new MeansOfContactEnum("MobilePhone");
    public static final MeansOfContactEnum SMS = new MeansOfContactEnum("Sms");
    public static final MeansOfContactEnum LOCAL_AUTHORITY_OFFICE = new MeansOfContactEnum("LocalAuthorityOffice");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MeansOfContactEnum(String meansOfContact) {
        super(meansOfContact);
    }

    public MeansOfContactEnum() {}

    public static final MeansOfContactEnum[] allMeansOfContactEnums = {
        MAIL,
        EMAIL,
        HOME_PHONE,
        OFFICE_PHONE,
        MOBILE_PHONE,
        SMS,
        LOCAL_AUTHORITY_OFFICE
    };

    public static MeansOfContactEnum forString(String enumAsString) {
        for (MeansOfContactEnum moce : allMeansOfContactEnums) {
            if (moce.toString().equals(enumAsString))
                return moce;
        }
        return null;
    }
}
