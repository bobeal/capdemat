package fr.cg95.cvq.business.request.babyhood;

/**
 * Generated class file, do not edit !
 */
public enum SdccrrChoixSituationActuelle {

    PLEIN("Plein"),
    PARTIEL("Partiel"),
    INTERIM("Interim"),
    ETUDIANT("Etudiant"),
    STAGE("Stage"),
    RECHERCHE("Recherche"),
    PARENT("Parent"),
    LIBRE("Libre"),
    CONGE("Conge"),
    RETRAITE("Retraite"),
    AUTRE("Autre");


    /**
     * only for backward use SdccrrChoixSituationActuelle.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SdccrrChoixSituationActuelle[] allSdccrrChoixSituationActuelles = SdccrrChoixSituationActuelle.values();

    private String legacyLabel;

    private SdccrrChoixSituationActuelle(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SdccrrChoixSituationActuelle getDefaultSdccrrChoixSituationActuelle() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SdccrrChoixSituationActuelle.something
     * not the value of the name attribut.
     */
    public static SdccrrChoixSituationActuelle forString(final String enumAsString) {
        for (SdccrrChoixSituationActuelle value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSdccrrChoixSituationActuelle();
    }
}
