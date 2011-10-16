package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum AccountAddressKindType {

    CURRENT("current"),
    FUTURE("future");


    /**
     * only for backward use AccountAddressKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static AccountAddressKindType[] allAccountAddressKindTypes = AccountAddressKindType.values();

    private String legacyLabel;

    private AccountAddressKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static AccountAddressKindType getDefaultAccountAddressKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of AccountAddressKindType.something
     * not the value of the name attribut.
     */
    public static AccountAddressKindType forString(final String enumAsString) {
        for (AccountAddressKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAccountAddressKindType();
    }
}
