package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum SerrrTypeInscriptionType {

    VOLONTAIRE("Volontaire"),
    DECISION_JUDICIAIRE("DecisionJudiciaire"),
    OFFICE("Office");


    /**
     * only for backward use SerrrTypeInscriptionType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SerrrTypeInscriptionType[] allSerrrTypeInscriptionTypes = SerrrTypeInscriptionType.values();

    private String legacyLabel;

    private SerrrTypeInscriptionType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SerrrTypeInscriptionType getDefaultSerrrTypeInscriptionType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SerrrTypeInscriptionType.something
     * not the value of the name attribut.
     */
    public static SerrrTypeInscriptionType forString(final String enumAsString) {
        for (SerrrTypeInscriptionType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSerrrTypeInscriptionType();
    }
}
