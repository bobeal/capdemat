package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum SerrrTypeElectionType {

    ELECTION_MUNICIPALE("ElectionMunicipale"),
    ELECTION_EUROPEENNE("ElectionEuropeenne");


    /**
     * only for backward use SerrrTypeElectionType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SerrrTypeElectionType[] allSerrrTypeElectionTypes = SerrrTypeElectionType.values();

    private String legacyLabel;

    private SerrrTypeElectionType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SerrrTypeElectionType getDefaultSerrrTypeElectionType() {
        return ELECTION_MUNICIPALE;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SerrrTypeElectionType.something
     * not the value of the name attribut.
     */
    public static SerrrTypeElectionType forString(final String enumAsString) {
        for (SerrrTypeElectionType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSerrrTypeElectionType();
    }
}
