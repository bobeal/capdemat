package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
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
        for (DeathCertificateFormatType value : allDeathCertificateFormatTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDeathCertificateFormatType();
    }
}
