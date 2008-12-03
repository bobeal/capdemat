package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DeathCertificateMotiveType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DeathCertificateMotiveType NOTARY_ACT = new DeathCertificateMotiveType("NotaryAct");
    public static final DeathCertificateMotiveType MARRIAGE = new DeathCertificateMotiveType("Marriage");
    public static final DeathCertificateMotiveType PASSPORT = new DeathCertificateMotiveType("Passport");
    public static final DeathCertificateMotiveType PENSION = new DeathCertificateMotiveType("Pension");
    public static final DeathCertificateMotiveType OTHER = new DeathCertificateMotiveType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DeathCertificateMotiveType(String value) {
       super(value);
    }


    public DeathCertificateMotiveType() {}



    public static DeathCertificateMotiveType[] allDeathCertificateMotiveTypes = {
        NOTARY_ACT,
        MARRIAGE,
        PASSPORT,
        PENSION,
        OTHER
    };


    public static DeathCertificateMotiveType getDefaultDeathCertificateMotiveType() {
        return null;
    }


    public static DeathCertificateMotiveType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDeathCertificateMotiveType();

        if (enumAsString.equals(NOTARY_ACT.toString()))
            return NOTARY_ACT;
        else if (enumAsString.equals(MARRIAGE.toString()))
            return MARRIAGE;
        else if (enumAsString.equals(PASSPORT.toString()))
            return PASSPORT;
        else if (enumAsString.equals(PENSION.toString()))
            return PENSION;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultDeathCertificateMotiveType();
    }
}
