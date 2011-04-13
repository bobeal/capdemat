package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum DhrAssetTypeType {

    SHARE("Share"),
    GIFT("Gift"),
    SALE("Sale");


    /**
     * only for backward use DhrAssetTypeType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static DhrAssetTypeType[] allDhrAssetTypeTypes = DhrAssetTypeType.values();

    private String legacyLabel;

    private DhrAssetTypeType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static DhrAssetTypeType getDefaultDhrAssetTypeType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of DhrAssetTypeType.something
     * not the value of the name attribut.
     */
    public static DhrAssetTypeType forString(final String enumAsString) {
        for (DhrAssetTypeType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrAssetTypeType();
    }
}
