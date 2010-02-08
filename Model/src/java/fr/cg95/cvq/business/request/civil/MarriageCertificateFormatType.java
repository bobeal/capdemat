package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class MarriageCertificateFormatType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final MarriageCertificateFormatType FULL_COPY = new MarriageCertificateFormatType("FullCopy");
  
    public static final MarriageCertificateFormatType EXTRACT_WITH_RELATIONSHIP = new MarriageCertificateFormatType("ExtractWithRelationship");
  
    public static final MarriageCertificateFormatType EXTRACT_WITHOUT_RELATIONSHIP = new MarriageCertificateFormatType("ExtractWithoutRelationship");
  
    public static final MarriageCertificateFormatType MULTILINGUAL_EXTRACT = new MarriageCertificateFormatType("MultilingualExtract");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MarriageCertificateFormatType(String value) {
        super(value);
    }

    public MarriageCertificateFormatType() {}

    public static MarriageCertificateFormatType[] allMarriageCertificateFormatTypes = {
        FULL_COPY,
        EXTRACT_WITH_RELATIONSHIP,
        EXTRACT_WITHOUT_RELATIONSHIP,
        MULTILINGUAL_EXTRACT
    };

    public static MarriageCertificateFormatType getDefaultMarriageCertificateFormatType() {
        return FULL_COPY;
    }

    public static MarriageCertificateFormatType forString(final String enumAsString) {
        for (MarriageCertificateFormatType value : allMarriageCertificateFormatTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageCertificateFormatType();
    }
}
