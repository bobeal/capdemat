package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
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



    public static BirthCertificateMotiveType getDefaultBirthCertificateMotiveType() {
        return null;
    }


    public static BirthCertificateMotiveType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultBirthCertificateMotiveType();

        if (enumAsString.equals(NOTARY_ACT.toString()))
            return NOTARY_ACT;
        else if (enumAsString.equals(NATIONAL_IDENTITY_CARD.toString()))
            return NATIONAL_IDENTITY_CARD;
        else if (enumAsString.equals(FRENCH_NATIONALITY_CERTIFICATE.toString()))
            return FRENCH_NATIONALITY_CERTIFICATE;
        else if (enumAsString.equals(MARRIAGE.toString()))
            return MARRIAGE;
        else if (enumAsString.equals(PACS.toString()))
            return PACS;
        else if (enumAsString.equals(PASSPORT.toString()))
            return PASSPORT;
        else if (enumAsString.equals(PENSION.toString()))
            return PENSION;
        else if (enumAsString.equals(LEGAL_PROCEEDINGS.toString()))
            return LEGAL_PROCEEDINGS;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultBirthCertificateMotiveType();
    }
}
