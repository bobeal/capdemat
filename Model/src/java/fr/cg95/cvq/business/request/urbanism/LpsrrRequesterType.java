package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LpsrrRequesterType {

    LANDLORD("landlord"),
    CONTRACTOR("contractor");


    /**
     * only for backward use LpsrrRequesterType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LpsrrRequesterType[] allLpsrrRequesterTypes = LpsrrRequesterType.values();

    private String legacyLabel;

    private LpsrrRequesterType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LpsrrRequesterType getDefaultLpsrrRequesterType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LpsrrRequesterType.something
     * not the value of the name attribut.
     */
    public static LpsrrRequesterType forString(final String enumAsString) {
        for (LpsrrRequesterType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLpsrrRequesterType();
    }
}
