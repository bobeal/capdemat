package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ScjerTypeInscriptionType {

    PREMIERE_FOIS("PremiereFois"),
    RENOUVELLEMENT("Renouvellement");


    /**
     * only for backward use ScjerTypeInscriptionType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ScjerTypeInscriptionType[] allScjerTypeInscriptionTypes = ScjerTypeInscriptionType.values();

    private String legacyLabel;

    private ScjerTypeInscriptionType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ScjerTypeInscriptionType getDefaultScjerTypeInscriptionType() {
        return PREMIERE_FOIS;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ScjerTypeInscriptionType.something
     * not the value of the name attribut.
     */
    public static ScjerTypeInscriptionType forString(final String enumAsString) {
        for (ScjerTypeInscriptionType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultScjerTypeInscriptionType();
    }
}
