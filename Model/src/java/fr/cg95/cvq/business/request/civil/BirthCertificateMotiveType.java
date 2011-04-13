package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum BirthCertificateMotiveType {

    NOTARY_ACT("NotaryAct"),
    NATIONAL_IDENTITY_CARD("NationalIdentityCard"),
    FRENCH_NATIONALITY_CERTIFICATE("FrenchNationalityCertificate"),
    MARRIAGE("Marriage"),
    PACS("Pacs"),
    PASSPORT("Passport"),
    PENSION("Pension"),
    LEGAL_PROCEEDINGS("LegalProceedings"),
    OTHER("Other");


    /**
     * only for backward use BirthCertificateMotiveType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static BirthCertificateMotiveType[] allBirthCertificateMotiveTypes = BirthCertificateMotiveType.values();

    private String legacyLabel;

    private BirthCertificateMotiveType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static BirthCertificateMotiveType getDefaultBirthCertificateMotiveType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of BirthCertificateMotiveType.something
     * not the value of the name attribut.
     */
    public static BirthCertificateMotiveType forString(final String enumAsString) {
        for (BirthCertificateMotiveType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultBirthCertificateMotiveType();
    }
}
