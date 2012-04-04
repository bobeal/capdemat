package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum SaintOuenCurrentStudiesType {

    LICENCE("licence"),
    LICENCE_PRO("licencePro"),
    MASTER("master"),
    BTS("bts"),
    DUT("dut"),
    OTHER_STUDIES("otherStudies");


    /**
     * only for backward use SaintOuenCurrentStudiesType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SaintOuenCurrentStudiesType[] allSaintOuenCurrentStudiesTypes = SaintOuenCurrentStudiesType.values();

    private String legacyLabel;

    private SaintOuenCurrentStudiesType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SaintOuenCurrentStudiesType getDefaultSaintOuenCurrentStudiesType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SaintOuenCurrentStudiesType.something
     * not the value of the name attribut.
     */
    public static SaintOuenCurrentStudiesType forString(final String enumAsString) {
        for (SaintOuenCurrentStudiesType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSaintOuenCurrentStudiesType();
    }
}
