package fr.cg95.cvq.business.request.babyhood;

/**
 * Generated class file, do not edit !
 */
public enum SdccrrRendezVousType {

    PHYSIQUE("Physique"),
    TELEPHONIQUE("Telephonique");


    /**
     * only for backward use SdccrrRendezVousType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SdccrrRendezVousType[] allSdccrrRendezVousTypes = SdccrrRendezVousType.values();

    private String legacyLabel;

    private SdccrrRendezVousType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SdccrrRendezVousType getDefaultSdccrrRendezVousType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SdccrrRendezVousType.something
     * not the value of the name attribut.
     */
    public static SdccrrRendezVousType forString(final String enumAsString) {
        for (SdccrrRendezVousType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSdccrrRendezVousType();
    }
}
