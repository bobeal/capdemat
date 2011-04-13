package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrAssetKindType {

    REAL_ESTATE("RealEstate"),
    OTHER("Other");


    /**
     * only for backward use DhrAssetKindType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrAssetKindType[] allDhrAssetKindTypes = DhrAssetKindType.values();

    private String legacyLabel;

    private DhrAssetKindType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrAssetKindType getDefaultDhrAssetKindType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrAssetKindType.something
     * not the value of the name attribut.
     */
    public static DhrAssetKindType forString(final String enumAsString) {
        for (DhrAssetKindType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrAssetKindType();
    }
}
