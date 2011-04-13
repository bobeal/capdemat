package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ChoixDatePlacement {

    CONNUE("Connue"),
    POSSIBLE("Possible");


    /**
     * only for backward use ChoixDatePlacement.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ChoixDatePlacement[] allChoixDatePlacements = ChoixDatePlacement.values();

    private String legacyLabel;

    private ChoixDatePlacement(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ChoixDatePlacement getDefaultChoixDatePlacement() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ChoixDatePlacement.something
     * not the value of the name attribut.
     */
    public static ChoixDatePlacement forString(final String enumAsString) {
        for (ChoixDatePlacement value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChoixDatePlacement();
    }
}
