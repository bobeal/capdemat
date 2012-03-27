package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjerTypeEtablissementScolaireType {

    COLLEGE("College"),
    LYCEE("Lycee"),
    AUTRE("Autre");


    /**
     * only for backward use ScjerTypeEtablissementScolaireType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjerTypeEtablissementScolaireType[] allScjerTypeEtablissementScolaireTypes = ScjerTypeEtablissementScolaireType.values();

    private String legacyLabel;

    private ScjerTypeEtablissementScolaireType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjerTypeEtablissementScolaireType getDefaultScjerTypeEtablissementScolaireType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjerTypeEtablissementScolaireType.something
     * not the value of the name attribut.
     */
    public static ScjerTypeEtablissementScolaireType forString(final String enumAsString) {
        for (ScjerTypeEtablissementScolaireType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjerTypeEtablissementScolaireType();
    }
}
