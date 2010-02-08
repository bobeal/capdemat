package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class BirthCertificateFormatType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final BirthCertificateFormatType FULL_COPY = new BirthCertificateFormatType("FullCopy");
  
    public static final BirthCertificateFormatType EXTRACT_WITH_RELATIONSHIP = new BirthCertificateFormatType("ExtractWithRelationship");
  
    public static final BirthCertificateFormatType EXTRACT_WITHOUT_RELATIONSHIP = new BirthCertificateFormatType("ExtractWithoutRelationship");
  
    public static final BirthCertificateFormatType MULTILINGUAL_EXTRACT = new BirthCertificateFormatType("MultilingualExtract");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private BirthCertificateFormatType(String value) {
        super(value);
    }

    public BirthCertificateFormatType() {}

    public static BirthCertificateFormatType[] allBirthCertificateFormatTypes = {
        FULL_COPY,
        EXTRACT_WITH_RELATIONSHIP,
        EXTRACT_WITHOUT_RELATIONSHIP,
        MULTILINGUAL_EXTRACT
    };

    public static BirthCertificateFormatType getDefaultBirthCertificateFormatType() {
        return FULL_COPY;
    }

    public static BirthCertificateFormatType forString(final String enumAsString) {
        for (BirthCertificateFormatType value : allBirthCertificateFormatTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultBirthCertificateFormatType();
    }
}
