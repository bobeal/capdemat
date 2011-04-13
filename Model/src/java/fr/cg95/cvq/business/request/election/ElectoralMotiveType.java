package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum ElectoralMotiveType {

    NEW_CITY_RESIDENT("NewCityResident"),
    DIRECT_CITY_CONTRIBUTION("DirectCityContribution"),
    CIVIL_SERVANT_OBLIGATORY_RESIDENT("CivilServantObligatoryResident"),
    FUTURE_AUTHORIZED_CITIZEN("FutureAuthorizedCitizen");


    /**
     * only for backward use ElectoralMotiveType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ElectoralMotiveType[] allElectoralMotiveTypes = ElectoralMotiveType.values();

    private String legacyLabel;

    private ElectoralMotiveType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ElectoralMotiveType getDefaultElectoralMotiveType() {
        return NEW_CITY_RESIDENT;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ElectoralMotiveType.something
     * not the value of the name attribut.
     */
    public static ElectoralMotiveType forString(final String enumAsString) {
        for (ElectoralMotiveType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultElectoralMotiveType();
    }
}
