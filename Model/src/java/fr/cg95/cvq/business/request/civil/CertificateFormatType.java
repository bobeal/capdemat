package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class CertificateFormatType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final CertificateFormatType FULL_COPY = new CertificateFormatType("FullCopy");
    public static final CertificateFormatType EXTRACT_WITH_RELATIONSHIP = new CertificateFormatType("ExtractWithRelationship");
    public static final CertificateFormatType EXTRACT_WITHOUT_RELATIONSHIP = new CertificateFormatType("ExtractWithoutRelationship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CertificateFormatType(String value) {
       super(value);
    }


    public CertificateFormatType() {}



    public static CertificateFormatType getDefaultCertificateFormatType() {
        return null;
    }


    public static CertificateFormatType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultCertificateFormatType();

        if (enumAsString.equals(FULL_COPY.toString()))
            return FULL_COPY;
        else if (enumAsString.equals(EXTRACT_WITH_RELATIONSHIP.toString()))
            return EXTRACT_WITH_RELATIONSHIP;
        else if (enumAsString.equals(EXTRACT_WITHOUT_RELATIONSHIP.toString()))
            return EXTRACT_WITHOUT_RELATIONSHIP;

        return getDefaultCertificateFormatType();
    }
}
