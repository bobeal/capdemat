package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum MarriageRequesterQualityType {

    REQUESTER("Requester"),
    SPOUSE("Spouse"),
    PARENT("Parent"),
    GRAND_PARENT("GrandParent"),
    CHILD("Child"),
    LEGAL_REPRESENTANT("LegalRepresentant"),
    AGENT("Agent"),
    HEIR_FAMILY("HeirFamily"),
    HEIR("Heir"),
    AUTHORIZED("Authorized"),
    LAWYER_NOTARY("LawyerNotary"),
    OTHER("Other");


    /**
     * only for backward use MarriageRequesterQualityType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static MarriageRequesterQualityType[] allMarriageRequesterQualityTypes = MarriageRequesterQualityType.values();

    private String legacyLabel;

    private MarriageRequesterQualityType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static MarriageRequesterQualityType getDefaultMarriageRequesterQualityType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of MarriageRequesterQualityType.something
     * not the value of the name attribut.
     */
    public static MarriageRequesterQualityType forString(final String enumAsString) {
        for (MarriageRequesterQualityType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageRequesterQualityType();
    }
}
