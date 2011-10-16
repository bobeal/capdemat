package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LtswrAlternateTraffic {

    INFO("info"),
    MANUAL("manual"),
    AUTO("auto");


    /**
     * only for backward use LtswrAlternateTraffic.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LtswrAlternateTraffic[] allLtswrAlternateTraffics = LtswrAlternateTraffic.values();

    private String legacyLabel;

    private LtswrAlternateTraffic(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LtswrAlternateTraffic getDefaultLtswrAlternateTraffic() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LtswrAlternateTraffic.something
     * not the value of the name attribut.
     */
    public static LtswrAlternateTraffic forString(final String enumAsString) {
        for (LtswrAlternateTraffic value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLtswrAlternateTraffic();
    }
}
