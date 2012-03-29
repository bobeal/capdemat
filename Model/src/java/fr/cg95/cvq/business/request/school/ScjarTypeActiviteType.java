package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjarTypeActiviteType {

    ACCUEIL("Accueil"),
    ATELIER("Atelier"),
    PROJET("Projet");


    /**
     * only for backward use ScjarTypeActiviteType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjarTypeActiviteType[] allScjarTypeActiviteTypes = ScjarTypeActiviteType.values();

    private String legacyLabel;

    private ScjarTypeActiviteType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjarTypeActiviteType getDefaultScjarTypeActiviteType() {
        return ACCUEIL;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjarTypeActiviteType.something
     * not the value of the name attribut.
     */
    public static ScjarTypeActiviteType forString(final String enumAsString) {
        for (ScjarTypeActiviteType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjarTypeActiviteType();
    }
}
