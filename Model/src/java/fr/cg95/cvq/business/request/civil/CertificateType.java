package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class CertificateType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final CertificateType BIRTH = new CertificateType("Birth");
    public static final CertificateType MARRIAGE = new CertificateType("Marriage");
    public static final CertificateType DEATH = new CertificateType("Death");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CertificateType(String value) {
       super(value);
    }


    public CertificateType() {}



    public static CertificateType getDefaultCertificateType() {
        return null;
    }


    public static CertificateType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultCertificateType();

        if (enumAsString.equals(BIRTH.toString()))
            return BIRTH;
        else if (enumAsString.equals(MARRIAGE.toString()))
            return MARRIAGE;
        else if (enumAsString.equals(DEATH.toString()))
            return DEATH;

        return getDefaultCertificateType();
    }
}
