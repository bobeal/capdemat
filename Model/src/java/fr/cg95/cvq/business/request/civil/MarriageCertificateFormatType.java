package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum MarriageCertificateFormatType {

    FULL_COPY("FullCopy"),
    EXTRACT_WITH_RELATIONSHIP("ExtractWithRelationship"),
    EXTRACT_WITHOUT_RELATIONSHIP("ExtractWithoutRelationship"),
    MULTILINGUAL_EXTRACT("MultilingualExtract");


    /**
     * only for backward use MarriageCertificateFormatType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static MarriageCertificateFormatType[] allMarriageCertificateFormatTypes = MarriageCertificateFormatType.values();

    private String legacyLabel;

    private MarriageCertificateFormatType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static MarriageCertificateFormatType getDefaultMarriageCertificateFormatType() {
        return FULL_COPY;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of MarriageCertificateFormatType.something
     * not the value of the name attribut.
     */
    public static MarriageCertificateFormatType forString(final String enumAsString) {
        for (MarriageCertificateFormatType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageCertificateFormatType();
    }
}
