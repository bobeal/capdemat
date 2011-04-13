package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrDwellingKindType {

    PLACE_OF_RESIDENCE("PlaceOfResidence"),
    THIRD_PARTY_PLACE_OF_RESIDENCE("ThirdPartyPlaceOfResidence"),
    OTHER("Other");


    /**
     * only for backward use HccrDwellingKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrDwellingKindType[] allHccrDwellingKindTypes = HccrDwellingKindType.values();

    private String legacyLabel;

    private HccrDwellingKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrDwellingKindType getDefaultHccrDwellingKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrDwellingKindType.something
     * not the value of the name attribut.
     */
    public static HccrDwellingKindType forString(final String enumAsString) {
        for (HccrDwellingKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrDwellingKindType();
    }
}
