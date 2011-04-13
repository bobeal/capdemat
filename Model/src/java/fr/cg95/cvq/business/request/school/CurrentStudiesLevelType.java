package fr.cg95.cvq.business.request.school;

/**
 * Generated class file, do not edit !
 */
public enum CurrentStudiesLevelType {

    FIRST_YEAR("firstYear"),
    SECOND_YEAR("secondYear"),
    THIRD_YEAR("thirdYear");


    /**
     * only for backward use CurrentStudiesLevelType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static CurrentStudiesLevelType[] allCurrentStudiesLevelTypes = CurrentStudiesLevelType.values();

    private String legacyLabel;

    private CurrentStudiesLevelType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static CurrentStudiesLevelType getDefaultCurrentStudiesLevelType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of CurrentStudiesLevelType.something
     * not the value of the name attribut.
     */
    public static CurrentStudiesLevelType forString(final String enumAsString) {
        for (CurrentStudiesLevelType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultCurrentStudiesLevelType();
    }
}
