package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarDwellingKindType {

    PLACE_OF_RESIDENCE("PlaceOfResidence"),
    THIRD_PARTY_PLACE_OF_RESIDENCE("ThirdPartyPlaceOfResidence"),
    OTHER("Other");


    /**
     * only for backward use HcarDwellingKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarDwellingKindType[] allHcarDwellingKindTypes = HcarDwellingKindType.values();

    private String legacyLabel;

    private HcarDwellingKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarDwellingKindType getDefaultHcarDwellingKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarDwellingKindType.something
     * not the value of the name attribut.
     */
    public static HcarDwellingKindType forString(final String enumAsString) {
        for (HcarDwellingKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarDwellingKindType();
    }
}
