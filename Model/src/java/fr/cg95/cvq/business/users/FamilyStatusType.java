package fr.cg95.cvq.business.users;

/**
 * @author bor@zenexity.fr
 */
public enum FamilyStatusType {


    SINGLE("Single"),
    DIVORCED("Divorced"),
    WIDOW("Widow"),
    MARRIED("Married"),
    COMMON_LAW_MARRIAGE("CommonLawMarriage"),
    SEPARATED("Separated"),
    PACS("PACS"),
    OTHER("Other");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private FamilyStatusType(String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }


    /**
     * @deprecated only for backward, use FamilyStatusType.values() instead
     */
    public static final FamilyStatusType[] allFamilyStatusTypes = FamilyStatusType.values();

    public static FamilyStatusType getDefaultFamilyStatusType() {
        return OTHER;
    }

    public static FamilyStatusType forString(String legacyLabel) {
        if (legacyLabel == null || legacyLabel.equals(""))
            return OTHER;

        if (legacyLabel.equals(SINGLE.getLegacyLabel()))
            return SINGLE;
        else if (legacyLabel.equals(DIVORCED.getLegacyLabel()))
            return DIVORCED;
        else if (legacyLabel.equals(WIDOW.getLegacyLabel()))
            return WIDOW;
        else if (legacyLabel.equals(MARRIED.getLegacyLabel()))
            return MARRIED;
        else if (legacyLabel.equals(COMMON_LAW_MARRIAGE.getLegacyLabel()))
            return COMMON_LAW_MARRIAGE;
        else if (legacyLabel.equals(SEPARATED.getLegacyLabel()))
            return SEPARATED;
        else if (legacyLabel.equals(PACS.getLegacyLabel()))
            return PACS;
        else if (legacyLabel.equals(OTHER.getLegacyLabel()))
            return OTHER;

        return OTHER;
    }

    public static FamilyStatusType forLegacyLabel(String legacyLabel) {
        if (legacyLabel == null || legacyLabel.equals(""))
            return OTHER;

        if (legacyLabel.equals(SINGLE.getLegacyLabel()))
            return SINGLE;
        else if (legacyLabel.equals(DIVORCED.getLegacyLabel()))
            return DIVORCED;
        else if (legacyLabel.equals(WIDOW.getLegacyLabel()))
            return WIDOW;
        else if (legacyLabel.equals(MARRIED.getLegacyLabel()))
            return MARRIED;
        else if (legacyLabel.equals(COMMON_LAW_MARRIAGE.getLegacyLabel()))
            return COMMON_LAW_MARRIAGE;
        else if (legacyLabel.equals(SEPARATED.getLegacyLabel()))
            return SEPARATED;
        else if (legacyLabel.equals(PACS.getLegacyLabel()))
            return PACS;
        else if (legacyLabel.equals(OTHER.getLegacyLabel()))
            return OTHER;

        return OTHER;
    }
}
