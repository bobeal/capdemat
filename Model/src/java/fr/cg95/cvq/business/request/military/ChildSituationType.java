package fr.cg95.cvq.business.request.military;

/**
 * Generated class file, do not edit !
 */
public enum ChildSituationType {

    COLLEGE("College"),
    HIGHSCHOOL("Highschool"),
    STUDENT("Student"),
    EMPLOYEE("Employee"),
    APPRENTICE("Apprentice"),
    OTHER("Other"),
    UNKNOWN("Unknown");


    /**
     * only for backward use ChildSituationType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ChildSituationType[] allChildSituationTypes = ChildSituationType.values();

    private String legacyLabel;

    private ChildSituationType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ChildSituationType getDefaultChildSituationType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ChildSituationType.something
     * not the value of the name attribut.
     */
    public static ChildSituationType forString(final String enumAsString) {
        for (ChildSituationType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChildSituationType();
    }
}
