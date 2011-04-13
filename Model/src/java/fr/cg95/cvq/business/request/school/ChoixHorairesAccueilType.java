package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum ChoixHorairesAccueilType {

    INDIFFERENT("Indifferent"),
    REGULIER("Regulier"),
    IRREGULIER("Irregulier");


    /**
     * only for backward use ChoixHorairesAccueilType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ChoixHorairesAccueilType[] allChoixHorairesAccueilTypes = ChoixHorairesAccueilType.values();

    private String legacyLabel;

    private ChoixHorairesAccueilType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ChoixHorairesAccueilType getDefaultChoixHorairesAccueilType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ChoixHorairesAccueilType.something
     * not the value of the name attribut.
     */
    public static ChoixHorairesAccueilType forString(final String enumAsString) {
        for (ChoixHorairesAccueilType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChoixHorairesAccueilType();
    }
}
