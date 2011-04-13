package fr.cg95.cvq.business.users;

public enum SectionType {

    BEFORE_FIRST_SECTION("BeforeFirstSection"),
    FIRST_SECTION("FirstSection"),
    SECOND_SECTION("SecondSection"),
    THIRD_SECTION("ThirdSection"),
    C_P("CP"),
    C_E1("CE1"),
    C_E2("CE2"),
    C_M1("CM1"),
    C_M2("CM2"),
    C_L_I_S_S("CLISS"),
    UNKNOWN("Unknown");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    private SectionType(String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }

    /**
     * A vector of all possible {@link SectionType sections}.
     * @deprecated only for backward, use values() instead
     */
    public static final SectionType[] allSectionTypes = SectionType.values();

    public static SectionType getDefaultSectionType() {
        return UNKNOWN;
    }

    public static SectionType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return UNKNOWN;

        if (enumAsString.equals(BEFORE_FIRST_SECTION.toString()))
            return BEFORE_FIRST_SECTION;
        else if (enumAsString.equals(FIRST_SECTION.toString()))
            return FIRST_SECTION;
        else if (enumAsString.equals(SECOND_SECTION.toString()))
            return SECOND_SECTION;
        else if (enumAsString.equals(THIRD_SECTION.toString()))
            return THIRD_SECTION;
        else if (enumAsString.equals(C_P.toString()))
            return C_P;
        else if (enumAsString.equals(C_E1.toString()))
            return C_E1;
        else if (enumAsString.equals(C_E2.toString()))
            return C_E2;
        else if (enumAsString.equals(C_M1.toString()))
            return C_M1;
        else if (enumAsString.equals(C_M2.toString()))
            return C_M2;
        else if (enumAsString.equals(C_L_I_S_S.toString()))
            return C_L_I_S_S;

        return UNKNOWN;
    }

}
