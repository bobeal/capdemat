package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
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



    public static MarriageCertificateMotiveType getDefaultMarriageCertificateMotiveType() {
        return null;
    }


    public static MarriageCertificateMotiveType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultMarriageCertificateMotiveType();

        if (enumAsString.equals(NOTARY_ACT.toString()))
            return NOTARY_ACT;
        else if (enumAsString.equals(FRENCH_NATIONALITY_CERTIFICATE.toString()))
            return FRENCH_NATIONALITY_CERTIFICATE;
        else if (enumAsString.equals(MARITAL_REGIME_CHANGE.toString()))
            return MARITAL_REGIME_CHANGE;
        else if (enumAsString.equals(FRENCH_NATIONALITY_ACQUISITION_DECLARATION.toString()))
            return FRENCH_NATIONALITY_ACQUISITION_DECLARATION;
        else if (enumAsString.equals(DIVORCE_SEPARATION.toString()))
            return DIVORCE_SEPARATION;
        else if (enumAsString.equals(PASSPORT.toString()))
            return PASSPORT;
        else if (enumAsString.equals(PENSION.toString()))
            return PENSION;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultMarriageCertificateMotiveType();
    }
}
