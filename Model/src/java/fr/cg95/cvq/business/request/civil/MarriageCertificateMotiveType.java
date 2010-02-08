package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class MarriageCertificateMotiveType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final MarriageCertificateMotiveType NOTARY_ACT = new MarriageCertificateMotiveType("NotaryAct");
  
    public static final MarriageCertificateMotiveType FRENCH_NATIONALITY_CERTIFICATE = new MarriageCertificateMotiveType("FrenchNationalityCertificate");
  
    public static final MarriageCertificateMotiveType MARITAL_REGIME_CHANGE = new MarriageCertificateMotiveType("MaritalRegimeChange");
  
    public static final MarriageCertificateMotiveType FRENCH_NATIONALITY_ACQUISITION_DECLARATION = new MarriageCertificateMotiveType("FrenchNationalityAcquisitionDeclaration");
  
    public static final MarriageCertificateMotiveType DIVORCE_SEPARATION = new MarriageCertificateMotiveType("DivorceSeparation");
  
    public static final MarriageCertificateMotiveType PASSPORT = new MarriageCertificateMotiveType("Passport");
  
    public static final MarriageCertificateMotiveType PENSION = new MarriageCertificateMotiveType("Pension");
  
    public static final MarriageCertificateMotiveType OTHER = new MarriageCertificateMotiveType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MarriageCertificateMotiveType(String value) {
        super(value);
    }

    public MarriageCertificateMotiveType() {}

    public static MarriageCertificateMotiveType[] allMarriageCertificateMotiveTypes = {
        NOTARY_ACT,
        FRENCH_NATIONALITY_CERTIFICATE,
        MARITAL_REGIME_CHANGE,
        FRENCH_NATIONALITY_ACQUISITION_DECLARATION,
        DIVORCE_SEPARATION,
        PASSPORT,
        PENSION,
        OTHER
    };

    public static MarriageCertificateMotiveType getDefaultMarriageCertificateMotiveType() {
        return null;
    }

    public static MarriageCertificateMotiveType forString(final String enumAsString) {
        for (MarriageCertificateMotiveType value : allMarriageCertificateMotiveTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageCertificateMotiveType();
    }
}
