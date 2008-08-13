package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DeathCertificateFormatType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DeathCertificateFormatType FULL_COPY = new DeathCertificateFormatType("FullCopy");
    public static final DeathCertificateFormatType EXTRACT_WITH_RELATIONSHIP = new DeathCertificateFormatType("ExtractWithRelationship");
    public static final DeathCertificateFormatType EXTRACT_WITHOUT_RELATIONSHIP = new DeathCertificateFormatType("ExtractWithoutRelationship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DeathCertificateFormatType(String value) {
       super(value);
    }


    public DeathCertificateFormatType() {}



    public static DeathCertificateFormatType getDefaultDeathCertificateFormatType() {
        return null;
    }


    public static DeathCertificateFormatType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDeathCertificateFormatType();

        if (enumAsString.equals(FULL_COPY.toString()))
            return FULL_COPY;
        else if (enumAsString.equals(EXTRACT_WITH_RELATIONSHIP.toString()))
            return EXTRACT_WITH_RELATIONSHIP;
        else if (enumAsString.equals(EXTRACT_WITHOUT_RELATIONSHIP.toString()))
            return EXTRACT_WITHOUT_RELATIONSHIP;

        return getDefaultDeathCertificateFormatType();
    }
}
