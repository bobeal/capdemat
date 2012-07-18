package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum SaintOuenCurrentStudiesLevelType {

    FIRST_YEAR("firstYear"),
    SECOND_YEAR("secondYear"),
    THIRD_YEAR("thirdYear"),
    FOURTH_YEAR("fourthYear"),
    FIRTH_YEAR("firthYear");


    /**
     * only for backward use SaintOuenCurrentStudiesLevelType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SaintOuenCurrentStudiesLevelType[] allSaintOuenCurrentStudiesLevelTypes = SaintOuenCurrentStudiesLevelType.values();

    private String legacyLabel;

    private SaintOuenCurrentStudiesLevelType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SaintOuenCurrentStudiesLevelType getDefaultSaintOuenCurrentStudiesLevelType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SaintOuenCurrentStudiesLevelType.something
     * not the value of the name attribut.
     */
    public static SaintOuenCurrentStudiesLevelType forString(final String enumAsString) {
        for (SaintOuenCurrentStudiesLevelType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSaintOuenCurrentStudiesLevelType();
    }
}
