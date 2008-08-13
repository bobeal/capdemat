package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class MarriageCertificateFormatType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final MarriageCertificateFormatType FULL_COPY = new MarriageCertificateFormatType("FullCopy");
    public static final MarriageCertificateFormatType EXTRACT_WITH_RELATIONSHIP = new MarriageCertificateFormatType("ExtractWithRelationship");
    public static final MarriageCertificateFormatType EXTRACT_WITHOUT_RELATIONSHIP = new MarriageCertificateFormatType("ExtractWithoutRelationship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MarriageCertificateFormatType(String value) {
       super(value);
    }


    public MarriageCertificateFormatType() {}



    public static MarriageCertificateFormatType getDefaultMarriageCertificateFormatType() {
        return null;
    }


    public static MarriageCertificateFormatType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultMarriageCertificateFormatType();

        if (enumAsString.equals(FULL_COPY.toString()))
            return FULL_COPY;
        else if (enumAsString.equals(EXTRACT_WITH_RELATIONSHIP.toString()))
            return EXTRACT_WITH_RELATIONSHIP;
        else if (enumAsString.equals(EXTRACT_WITHOUT_RELATIONSHIP.toString()))
            return EXTRACT_WITHOUT_RELATIONSHIP;

        return getDefaultMarriageCertificateFormatType();
    }
}
