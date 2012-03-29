package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjarEtudiantTypeEtablissementType {

    LYCEE("Lycee"),
    FAC("Fac"),
    BTS("Bts"),
    AUTRE("Autre");


    /**
     * only for backward use ScjarEtudiantTypeEtablissementType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjarEtudiantTypeEtablissementType[] allScjarEtudiantTypeEtablissementTypes = ScjarEtudiantTypeEtablissementType.values();

    private String legacyLabel;

    private ScjarEtudiantTypeEtablissementType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjarEtudiantTypeEtablissementType getDefaultScjarEtudiantTypeEtablissementType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjarEtudiantTypeEtablissementType.something
     * not the value of the name attribut.
     */
    public static ScjarEtudiantTypeEtablissementType forString(final String enumAsString) {
        for (ScjarEtudiantTypeEtablissementType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjarEtudiantTypeEtablissementType();
    }
}
