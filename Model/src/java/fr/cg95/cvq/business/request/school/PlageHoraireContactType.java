package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum PlageHoraireContactType {

    MATIN("Matin"),
    APREM("Aprem"),
    SOIR("Soir"),
    INDIFFERENT("Indifferent");


    /**
     * only for backward use PlageHoraireContactType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static PlageHoraireContactType[] allPlageHoraireContactTypes = PlageHoraireContactType.values();

    private String legacyLabel;

    private PlageHoraireContactType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static PlageHoraireContactType getDefaultPlageHoraireContactType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of PlageHoraireContactType.something
     * not the value of the name attribut.
     */
    public static PlageHoraireContactType forString(final String enumAsString) {
        for (PlageHoraireContactType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultPlageHoraireContactType();
    }
}
