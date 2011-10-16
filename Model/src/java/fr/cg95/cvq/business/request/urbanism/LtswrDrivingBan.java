package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LtswrDrivingBan {

    ALLWAY("allway"),
    PARTWAY("partway"),
    ONEWAY("oneway");


    /**
     * only for backward use LtswrDrivingBan.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LtswrDrivingBan[] allLtswrDrivingBans = LtswrDrivingBan.values();

    private String legacyLabel;

    private LtswrDrivingBan(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LtswrDrivingBan getDefaultLtswrDrivingBan() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LtswrDrivingBan.something
     * not the value of the name attribut.
     */
    public static LtswrDrivingBan forString(final String enumAsString) {
        for (LtswrDrivingBan value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLtswrDrivingBan();
    }
}
