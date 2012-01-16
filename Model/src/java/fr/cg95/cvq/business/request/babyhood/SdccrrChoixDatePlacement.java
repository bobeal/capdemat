package fr.cg95.cvq.business.request.babyhood;

/**
 * Generated class file, do not edit !
 */
public enum SdccrrChoixDatePlacement {

    CONNUE("Connue"),
    POSSIBLE("Possible");


    /**
     * only for backward use SdccrrChoixDatePlacement.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SdccrrChoixDatePlacement[] allSdccrrChoixDatePlacements = SdccrrChoixDatePlacement.values();

    private String legacyLabel;

    private SdccrrChoixDatePlacement(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SdccrrChoixDatePlacement getDefaultSdccrrChoixDatePlacement() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SdccrrChoixDatePlacement.something
     * not the value of the name attribut.
     */
    public static SdccrrChoixDatePlacement forString(final String enumAsString) {
        for (SdccrrChoixDatePlacement value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSdccrrChoixDatePlacement();
    }
}
