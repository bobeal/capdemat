package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarLegalAccessRepresentativeKindType {

    FAMILY_MEMBER("FamilyMember"),
    AGENCY("Agency"),
    OTHER("Other");


    /**
     * only for backward use HcarLegalAccessRepresentativeKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarLegalAccessRepresentativeKindType[] allHcarLegalAccessRepresentativeKindTypes = HcarLegalAccessRepresentativeKindType.values();

    private String legacyLabel;

    private HcarLegalAccessRepresentativeKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarLegalAccessRepresentativeKindType getDefaultHcarLegalAccessRepresentativeKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarLegalAccessRepresentativeKindType.something
     * not the value of the name attribut.
     */
    public static HcarLegalAccessRepresentativeKindType forString(final String enumAsString) {
        for (HcarLegalAccessRepresentativeKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarLegalAccessRepresentativeKindType();
    }
}
