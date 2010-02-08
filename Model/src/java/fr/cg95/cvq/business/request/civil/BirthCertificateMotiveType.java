package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class BirthCertificateMotiveType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final BirthCertificateMotiveType NOTARY_ACT = new BirthCertificateMotiveType("NotaryAct");
  
    public static final BirthCertificateMotiveType NATIONAL_IDENTITY_CARD = new BirthCertificateMotiveType("NationalIdentityCard");
  
    public static final BirthCertificateMotiveType FRENCH_NATIONALITY_CERTIFICATE = new BirthCertificateMotiveType("FrenchNationalityCertificate");
  
    public static final BirthCertificateMotiveType MARRIAGE = new BirthCertificateMotiveType("Marriage");
  
    public static final BirthCertificateMotiveType PACS = new BirthCertificateMotiveType("Pacs");
  
    public static final BirthCertificateMotiveType PASSPORT = new BirthCertificateMotiveType("Passport");
  
    public static final BirthCertificateMotiveType PENSION = new BirthCertificateMotiveType("Pension");
  
    public static final BirthCertificateMotiveType LEGAL_PROCEEDINGS = new BirthCertificateMotiveType("LegalProceedings");
  
    public static final BirthCertificateMotiveType OTHER = new BirthCertificateMotiveType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private BirthCertificateMotiveType(String value) {
        super(value);
    }

    public BirthCertificateMotiveType() {}

    public static BirthCertificateMotiveType[] allBirthCertificateMotiveTypes = {
        NOTARY_ACT,
        NATIONAL_IDENTITY_CARD,
        FRENCH_NATIONALITY_CERTIFICATE,
        MARRIAGE,
        PACS,
        PASSPORT,
        PENSION,
        LEGAL_PROCEEDINGS,
        OTHER
    };

    public static BirthCertificateMotiveType getDefaultBirthCertificateMotiveType() {
        return null;
    }

    public static BirthCertificateMotiveType forString(final String enumAsString) {
        for (BirthCertificateMotiveType value : allBirthCertificateMotiveTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultBirthCertificateMotiveType();
    }
}
