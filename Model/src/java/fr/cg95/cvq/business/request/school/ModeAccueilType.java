package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ModeAccueilType {

    COLLECTIF("Collectif"),
    FAMILIAL("Familial");


    /**
     * only for backward use ModeAccueilType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ModeAccueilType[] allModeAccueilTypes = ModeAccueilType.values();

    private String legacyLabel;

    private ModeAccueilType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ModeAccueilType getDefaultModeAccueilType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ModeAccueilType.something
     * not the value of the name attribut.
     */
    public static ModeAccueilType forString(final String enumAsString) {
        for (ModeAccueilType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultModeAccueilType();
    }
}
