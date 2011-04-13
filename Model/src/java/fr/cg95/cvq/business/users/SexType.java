package fr.cg95.cvq.business.users;

/**
 * @author bor@zenexity.fr
 */
public enum SexType {

    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    private SexType(String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }

    /**
     * @deprecated only for backward, use values instead
     */
    public static final SexType[] allSexTypes = SexType.values();

    public static SexType getDefaultSexType() {
        return UNKNOWN;
    }

    public static SexType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return UNKNOWN;

        if (enumAsString.equals(MALE.toString()))
            return MALE;
        else if (enumAsString.equals(FEMALE.toString()))
            return FEMALE;

        return UNKNOWN;
    }

    @Override
    public String toString() {
        return legacyLabel;
    }
}
