package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum BirthCertificateFormatType {

    FULL_COPY("FullCopy"),
    EXTRACT_WITH_RELATIONSHIP("ExtractWithRelationship"),
    EXTRACT_WITHOUT_RELATIONSHIP("ExtractWithoutRelationship"),
    MULTILINGUAL_EXTRACT("MultilingualExtract");


    /**
     * only for backward use BirthCertificateFormatType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static BirthCertificateFormatType[] allBirthCertificateFormatTypes = BirthCertificateFormatType.values();

    private String legacyLabel;

    private BirthCertificateFormatType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static BirthCertificateFormatType getDefaultBirthCertificateFormatType() {
        return FULL_COPY;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of BirthCertificateFormatType.something
     * not the value of the name attribut.
     */
    public static BirthCertificateFormatType forString(final String enumAsString) {
        for (BirthCertificateFormatType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultBirthCertificateFormatType();
    }
}
