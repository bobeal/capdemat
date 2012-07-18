package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScssrVousVivezAvezType {

    DEUX_PARENTS("DeuxParents"),
    UN_PARENT("UnParent"),
    AUTRES("Autres");


    /**
     * only for backward use ScssrVousVivezAvezType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScssrVousVivezAvezType[] allScssrVousVivezAvezTypes = ScssrVousVivezAvezType.values();

    private String legacyLabel;

    private ScssrVousVivezAvezType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScssrVousVivezAvezType getDefaultScssrVousVivezAvezType() {
        return DEUX_PARENTS;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScssrVousVivezAvezType.something
     * not the value of the name attribut.
     */
    public static ScssrVousVivezAvezType forString(final String enumAsString) {
        for (ScssrVousVivezAvezType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScssrVousVivezAvezType();
    }
}
