package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum RendezVousType {

    PHYSIQUE("Physique"),
    TELEPHONIQUE("Telephonique");


    /**
     * only for backward use RendezVousType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static RendezVousType[] allRendezVousTypes = RendezVousType.values();

    private String legacyLabel;

    private RendezVousType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static RendezVousType getDefaultRendezVousType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of RendezVousType.something
     * not the value of the name attribut.
     */
    public static RendezVousType forString(final String enumAsString) {
        for (RendezVousType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRendezVousType();
    }
}
