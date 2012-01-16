package fr.cg95.cvq.business.request.babyhood;

/**
 * Generated class file, do not edit !
 */
public enum SdccrrChoixHorairesAccueilType {

    INDIFFERENT("Indifferent"),
    REGULIER("Regulier"),
    IRREGULIER("Irregulier");


    /**
     * only for backward use SdccrrChoixHorairesAccueilType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SdccrrChoixHorairesAccueilType[] allSdccrrChoixHorairesAccueilTypes = SdccrrChoixHorairesAccueilType.values();

    private String legacyLabel;

    private SdccrrChoixHorairesAccueilType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SdccrrChoixHorairesAccueilType getDefaultSdccrrChoixHorairesAccueilType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SdccrrChoixHorairesAccueilType.something
     * not the value of the name attribut.
     */
    public static SdccrrChoixHorairesAccueilType forString(final String enumAsString) {
        for (SdccrrChoixHorairesAccueilType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSdccrrChoixHorairesAccueilType();
    }
}
