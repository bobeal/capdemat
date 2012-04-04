package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum SaintOuenSituationLogementType {

    TENANT("tenant"),
    FREE_HOUSED("freeHoused"),
    OTHER_SITUATION("otherSituation");


    /**
     * only for backward use SaintOuenSituationLogementType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SaintOuenSituationLogementType[] allSaintOuenSituationLogementTypes = SaintOuenSituationLogementType.values();

    private String legacyLabel;

    private SaintOuenSituationLogementType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SaintOuenSituationLogementType getDefaultSaintOuenSituationLogementType() {
        return TENANT;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SaintOuenSituationLogementType.something
     * not the value of the name attribut.
     */
    public static SaintOuenSituationLogementType forString(final String enumAsString) {
        for (SaintOuenSituationLogementType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSaintOuenSituationLogementType();
    }
}
