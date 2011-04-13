package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HcarDwellingReceptionKindType {

    INTERNSHIP("Internship"),
    CLERKSHIP("Clerkship");


    /**
     * only for backward use HcarDwellingReceptionKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HcarDwellingReceptionKindType[] allHcarDwellingReceptionKindTypes = HcarDwellingReceptionKindType.values();

    private String legacyLabel;

    private HcarDwellingReceptionKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HcarDwellingReceptionKindType getDefaultHcarDwellingReceptionKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HcarDwellingReceptionKindType.something
     * not the value of the name attribut.
     */
    public static HcarDwellingReceptionKindType forString(final String enumAsString) {
        for (HcarDwellingReceptionKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarDwellingReceptionKindType();
    }
}
