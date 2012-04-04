package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum SaprEcoleInscriptionType {

    ECOLE_SAINTOUEN("EcoleSaintouen"),
    COLLEGE("College"),
    ECOLE_PRIVEE("EcolePrivee"),
    ECOLE_HORS_SAINTOUEN("EcoleHorsSaintouen");


    /**
     * only for backward use SaprEcoleInscriptionType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SaprEcoleInscriptionType[] allSaprEcoleInscriptionTypes = SaprEcoleInscriptionType.values();

    private String legacyLabel;

    private SaprEcoleInscriptionType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SaprEcoleInscriptionType getDefaultSaprEcoleInscriptionType() {
        return ECOLE_SAINTOUEN;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SaprEcoleInscriptionType.something
     * not the value of the name attribut.
     */
    public static SaprEcoleInscriptionType forString(final String enumAsString) {
        for (SaprEcoleInscriptionType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSaprEcoleInscriptionType();
    }
}
