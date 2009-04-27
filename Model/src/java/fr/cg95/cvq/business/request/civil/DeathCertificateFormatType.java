package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DeathCertificateFormatType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DeathCertificateFormatType FULL_COPY = new DeathCertificateFormatType("FullCopy");
    public static final DeathCertificateFormatType MULTILINGUAL_EXTRACT = new DeathCertificateFormatType("MultilingualExtract");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DeathCertificateFormatType(String value) {
       super(value);
    }


    public DeathCertificateFormatType() {}



    public static DeathCertificateFormatType[] allDeathCertificateFormatTypes = {
        FULL_COPY,
        MULTILINGUAL_EXTRACT
    };


    public static DeathCertificateFormatType getDefaultDeathCertificateFormatType() {
        return FULL_COPY;
    }


    public static DeathCertificateFormatType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDeathCertificateFormatType();

        if (enumAsString.equals(FULL_COPY.toString()))
            return FULL_COPY;
        else if (enumAsString.equals(MULTILINGUAL_EXTRACT.toString()))
            return MULTILINGUAL_EXTRACT;

        return getDefaultDeathCertificateFormatType();
    }
}
