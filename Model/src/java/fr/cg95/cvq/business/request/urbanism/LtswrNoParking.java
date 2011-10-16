package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LtswrNoParking {

    ALLWAY("allway"),
    PROGRESS("progress"),
    RIGHT("right"),
    FRONT("front");


    /**
     * only for backward use LtswrNoParking.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LtswrNoParking[] allLtswrNoParkings = LtswrNoParking.values();

    private String legacyLabel;

    private LtswrNoParking(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LtswrNoParking getDefaultLtswrNoParking() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LtswrNoParking.something
     * not the value of the name attribut.
     */
    public static LtswrNoParking forString(final String enumAsString) {
        for (LtswrNoParking value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLtswrNoParking();
    }
}
