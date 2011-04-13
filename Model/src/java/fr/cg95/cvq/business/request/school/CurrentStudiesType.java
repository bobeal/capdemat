package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum CurrentStudiesType {

    LICENCE("licence"),
    LICENCE_PRO("licencePro"),
    MASTER("master"),
    BTS("bts"),
    DUT("dut"),
    OTHER_STUDIES("otherStudies");


    /**
     * only for backward use CurrentStudiesType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static CurrentStudiesType[] allCurrentStudiesTypes = CurrentStudiesType.values();

    private String legacyLabel;

    private CurrentStudiesType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static CurrentStudiesType getDefaultCurrentStudiesType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of CurrentStudiesType.something
     * not the value of the name attribut.
     */
    public static CurrentStudiesType forString(final String enumAsString) {
        for (CurrentStudiesType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultCurrentStudiesType();
    }
}
