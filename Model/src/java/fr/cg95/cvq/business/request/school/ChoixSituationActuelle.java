package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ChoixSituationActuelle {

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
     * only for backward use ChoixSituationActuelle.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ChoixSituationActuelle[] allChoixSituationActuelles = ChoixSituationActuelle.values();

    private String legacyLabel;

    private ChoixSituationActuelle(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ChoixSituationActuelle getDefaultChoixSituationActuelle() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ChoixSituationActuelle.something
     * not the value of the name attribut.
     */
    public static ChoixSituationActuelle forString(final String enumAsString) {
        for (ChoixSituationActuelle value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChoixSituationActuelle();
    }
}
