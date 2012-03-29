package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjarSituationActuelleType {

    ETUDIANT("Etudiant"),
    SALARIE("Salarie"),
    SANS_EMPLOI("SansEmploi");


    /**
     * only for backward use ScjarSituationActuelleType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjarSituationActuelleType[] allScjarSituationActuelleTypes = ScjarSituationActuelleType.values();

    private String legacyLabel;

    private ScjarSituationActuelleType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjarSituationActuelleType getDefaultScjarSituationActuelleType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjarSituationActuelleType.something
     * not the value of the name attribut.
     */
    public static ScjarSituationActuelleType forString(final String enumAsString) {
        for (ScjarSituationActuelleType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjarSituationActuelleType();
    }
}
