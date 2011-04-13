package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum HccrSubjectParentalAuthorityHolderType {

    FATHER("Father"),
    MOTHER("Mother"),
    OTHER("Other");


    /**
     * only for backward use HccrSubjectParentalAuthorityHolderType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static HccrSubjectParentalAuthorityHolderType[] allHccrSubjectParentalAuthorityHolderTypes = HccrSubjectParentalAuthorityHolderType.values();

    private String legacyLabel;

    private HccrSubjectParentalAuthorityHolderType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static HccrSubjectParentalAuthorityHolderType getDefaultHccrSubjectParentalAuthorityHolderType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of HccrSubjectParentalAuthorityHolderType.something
     * not the value of the name attribut.
     */
    public static HccrSubjectParentalAuthorityHolderType forString(final String enumAsString) {
        for (HccrSubjectParentalAuthorityHolderType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrSubjectParentalAuthorityHolderType();
    }
}
