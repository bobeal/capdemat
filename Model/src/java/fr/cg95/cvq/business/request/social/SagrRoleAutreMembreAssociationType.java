package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum SagrRoleAutreMembreAssociationType {

    TRESORIER("Tresorier"),
    SECRETAIRE("Secretaire");


    /**
     * only for backward use SagrRoleAutreMembreAssociationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SagrRoleAutreMembreAssociationType[] allSagrRoleAutreMembreAssociationTypes = SagrRoleAutreMembreAssociationType.values();

    private String legacyLabel;

    private SagrRoleAutreMembreAssociationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SagrRoleAutreMembreAssociationType getDefaultSagrRoleAutreMembreAssociationType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SagrRoleAutreMembreAssociationType.something
     * not the value of the name attribut.
     */
    public static SagrRoleAutreMembreAssociationType forString(final String enumAsString) {
        for (SagrRoleAutreMembreAssociationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSagrRoleAutreMembreAssociationType();
    }
}
