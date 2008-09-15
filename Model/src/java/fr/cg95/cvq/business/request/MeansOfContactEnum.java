package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public class MeansOfContactEnum extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final MeansOfContactEnum MAIL = new MeansOfContactEnum("Mail");
    public static final MeansOfContactEnum EMAIL = new MeansOfContactEnum("Email");
    public static final MeansOfContactEnum HOME_PHONE = new MeansOfContactEnum("HomePhone");
    public static final MeansOfContactEnum OFFICE_PHONE = new MeansOfContactEnum("OfficePhone");
    public static final MeansOfContactEnum MOBILE_PHONE = new MeansOfContactEnum("MobilePhone");
    public static final MeansOfContactEnum SMS = new MeansOfContactEnum("Sms");
//    public static final MeansOfContactEnum FAX = new MeansOfContactEnum("Fax");
//    public static final MeansOfContactEnum CAPDEMAT_MESSAGE = new MeansOfContactEnum("CapdematMessage");
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
//        FAX,
//        CAPDEMAT_MESSAGE,
        LOCAL_AUTHORITY_OFFICE
    };
    
    public static MeansOfContactEnum forString(String enumAsString) {
        
        if (enumAsString.equals(MAIL.toString()))
            return MAIL;
        else if (enumAsString.equals(EMAIL.toString()))
            return EMAIL;
        else if (enumAsString.equals(HOME_PHONE.toString()))
            return HOME_PHONE;
        else if (enumAsString.equals(OFFICE_PHONE.toString()))
            return OFFICE_PHONE;
        else if (enumAsString.equals(MOBILE_PHONE.toString()))
            return MOBILE_PHONE;
        else if (enumAsString.equals(SMS.toString()))
            return SMS;
//        else if (enumAsString.equals(FAX.toString()))
//            return FAX;
//        else if (enumAsString.equals(CAPDEMAT_MESSAGE.toString()))
//            return CAPDEMAT_MESSAGE;
        else if (enumAsString.equals(LOCAL_AUTHORITY_OFFICE.toString()))
            return LOCAL_AUTHORITY_OFFICE;

        return null;
    }
}
