package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum DeathCertificateMotiveType {

    NOTARY_ACT("NotaryAct"),
    MARRIAGE("Marriage"),
    PASSPORT("Passport"),
    PENSION("Pension"),
    OTHER("Other");


    /**
     * only for backward use DeathCertificateMotiveType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DeathCertificateMotiveType[] allDeathCertificateMotiveTypes = DeathCertificateMotiveType.values();

    private String legacyLabel;

    private DeathCertificateMotiveType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DeathCertificateMotiveType getDefaultDeathCertificateMotiveType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DeathCertificateMotiveType.something
     * not the value of the name attribut.
     */
    public static DeathCertificateMotiveType forString(final String enumAsString) {
        for (DeathCertificateMotiveType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDeathCertificateMotiveType();
    }
}
