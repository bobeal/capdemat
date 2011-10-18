package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum SagrRoleAssociationType {

    PRESIDENT("President"),
    TRESORIER("Tresorier"),
    SECRETAIRE("Secretaire");


    /**
     * only for backward use SagrRoleAssociationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SagrRoleAssociationType[] allSagrRoleAssociationTypes = SagrRoleAssociationType.values();

    private String legacyLabel;

    private SagrRoleAssociationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SagrRoleAssociationType getDefaultSagrRoleAssociationType() {
        return PRESIDENT;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SagrRoleAssociationType.something
     * not the value of the name attribut.
     */
    public static SagrRoleAssociationType forString(final String enumAsString) {
        for (SagrRoleAssociationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSagrRoleAssociationType();
    }
}
