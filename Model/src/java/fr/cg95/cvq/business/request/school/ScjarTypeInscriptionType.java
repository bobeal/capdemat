package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjarTypeInscriptionType {

    PREMIERE_FOIS("PremiereFois"),
    RENOUVELLEMENT("Renouvellement");


    /**
     * only for backward use ScjarTypeInscriptionType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjarTypeInscriptionType[] allScjarTypeInscriptionTypes = ScjarTypeInscriptionType.values();

    private String legacyLabel;

    private ScjarTypeInscriptionType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjarTypeInscriptionType getDefaultScjarTypeInscriptionType() {
        return PREMIERE_FOIS;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjarTypeInscriptionType.something
     * not the value of the name attribut.
     */
    public static ScjarTypeInscriptionType forString(final String enumAsString) {
        for (ScjarTypeInscriptionType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjarTypeInscriptionType();
    }
}
