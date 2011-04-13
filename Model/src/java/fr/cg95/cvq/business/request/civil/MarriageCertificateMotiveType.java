package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum MarriageCertificateMotiveType {

    NOTARY_ACT("NotaryAct"),
    FRENCH_NATIONALITY_CERTIFICATE("FrenchNationalityCertificate"),
    MARITAL_REGIME_CHANGE("MaritalRegimeChange"),
    FRENCH_NATIONALITY_ACQUISITION_DECLARATION("FrenchNationalityAcquisitionDeclaration"),
    DIVORCE_SEPARATION("DivorceSeparation"),
    PASSPORT("Passport"),
    PENSION("Pension"),
    OTHER("Other");


    /**
     * only for backward use MarriageCertificateMotiveType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static MarriageCertificateMotiveType[] allMarriageCertificateMotiveTypes = MarriageCertificateMotiveType.values();

    private String legacyLabel;

    private MarriageCertificateMotiveType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static MarriageCertificateMotiveType getDefaultMarriageCertificateMotiveType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of MarriageCertificateMotiveType.something
     * not the value of the name attribut.
     */
    public static MarriageCertificateMotiveType forString(final String enumAsString) {
        for (MarriageCertificateMotiveType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageCertificateMotiveType();
    }
}
