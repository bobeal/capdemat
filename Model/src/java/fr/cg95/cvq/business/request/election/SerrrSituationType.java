package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum SerrrSituationType {

    PREMIERE_INSCRIPTION("PremiereInscription"),
    DEMENAGEMENT_MEME_COMMUNE("DemenagementMemeCommune"),
    CHANGEMENT_COMMUNE("ChangementCommune");


    /**
     * only for backward use SerrrSituationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SerrrSituationType[] allSerrrSituationTypes = SerrrSituationType.values();

    private String legacyLabel;

    private SerrrSituationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SerrrSituationType getDefaultSerrrSituationType() {
        return PREMIERE_INSCRIPTION;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SerrrSituationType.something
     * not the value of the name attribut.
     */
    public static SerrrSituationType forString(final String enumAsString) {
        for (SerrrSituationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSerrrSituationType();
    }
}
