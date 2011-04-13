package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum AutorisationType {

    SEUL("Seul"),
    AVEC_FRERE_SOEUR("AvecFrereSoeur"),
    AVEC_TIERS("AvecTiers");


    /**
     * only for backward use AutorisationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static AutorisationType[] allAutorisationTypes = AutorisationType.values();

    private String name;
    private AutorisationType(String name){
        this.name = name;
    }

    public static AutorisationType getDefaultAutorisationType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of AutorisationType.something
     * not the value of the name attribut.
     */
    public static AutorisationType forString(final String enumAsString) {
        for (AutorisationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAutorisationType();
    }
}
