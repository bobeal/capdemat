package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum DeathCertificateFormatType {

    FULL_COPY("FullCopy"),
    MULTILINGUAL_EXTRACT("MultilingualExtract");


    /**
     * only for backward use DeathCertificateFormatType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DeathCertificateFormatType[] allDeathCertificateFormatTypes = DeathCertificateFormatType.values();

    private String legacyLabel;

    private DeathCertificateFormatType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DeathCertificateFormatType getDefaultDeathCertificateFormatType() {
        return FULL_COPY;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DeathCertificateFormatType.something
     * not the value of the name attribut.
     */
    public static DeathCertificateFormatType forString(final String enumAsString) {
        for (DeathCertificateFormatType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDeathCertificateFormatType();
    }
}
