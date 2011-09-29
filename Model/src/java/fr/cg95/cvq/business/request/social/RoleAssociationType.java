package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum RoleAssociationType {

    PRESIDENT("President"),
    VICE_PRESIDENT("VicePresident"),
    TRESORIER("Tresorier"),
    SECRETAIRE("Secretaire");


    /**
     * only for backward use RoleAssociationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static RoleAssociationType[] allRoleAssociationTypes = RoleAssociationType.values();

    private String legacyLabel;

    private RoleAssociationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static RoleAssociationType getDefaultRoleAssociationType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of RoleAssociationType.something
     * not the value of the name attribut.
     */
    public static RoleAssociationType forString(final String enumAsString) {
        for (RoleAssociationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRoleAssociationType();
    }
}
