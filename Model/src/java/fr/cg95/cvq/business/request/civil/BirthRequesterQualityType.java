package fr.cg95.cvq.business.request.civil;

/**
 * Generated class file, do not edit !
 */
public enum BirthRequesterQualityType {

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
     * only for backward use BirthRequesterQualityType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static BirthRequesterQualityType[] allBirthRequesterQualityTypes = BirthRequesterQualityType.values();

    private String legacyLabel;

    private BirthRequesterQualityType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static BirthRequesterQualityType getDefaultBirthRequesterQualityType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of BirthRequesterQualityType.something
     * not the value of the name attribut.
     */
    public static BirthRequesterQualityType forString(final String enumAsString) {
        for (BirthRequesterQualityType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultBirthRequesterQualityType();
    }
}
