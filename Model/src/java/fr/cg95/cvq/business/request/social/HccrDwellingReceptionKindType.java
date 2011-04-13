package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrDwellingReceptionKindType {

    INTERNSHIP("Internship"),
    CLERKSHIP("Clerkship");


    /**
     * only for backward use HccrDwellingReceptionKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrDwellingReceptionKindType[] allHccrDwellingReceptionKindTypes = HccrDwellingReceptionKindType.values();

    private String legacyLabel;

    private HccrDwellingReceptionKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrDwellingReceptionKindType getDefaultHccrDwellingReceptionKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrDwellingReceptionKindType.something
     * not the value of the name attribut.
     */
    public static HccrDwellingReceptionKindType forString(final String enumAsString) {
        for (HccrDwellingReceptionKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrDwellingReceptionKindType();
    }
}
