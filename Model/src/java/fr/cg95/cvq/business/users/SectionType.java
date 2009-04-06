package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class SectionType extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

    public static final SectionType BEFORE_FIRST_SECTION = new SectionType("BeforeFirstSection");
	public static final SectionType FIRST_SECTION = new SectionType("FirstSection");
    public static final SectionType SECOND_SECTION = new SectionType("SecondSection");
    public static final SectionType THIRD_SECTION = new SectionType("ThirdSection");
    public static final SectionType CP = new SectionType("CP");
    public static final SectionType CE1 = new SectionType("CE1");
    public static final SectionType CE2 = new SectionType("CE2");
    public static final SectionType CM1 = new SectionType("CM1");
    public static final SectionType CM2 = new SectionType("CM2");
    public static final SectionType CLISS = new SectionType("CLISS");
    public static final SectionType UNKNOWN = new SectionType("Unknown");

    public SectionType() {}

    private SectionType(String name) {
        super(name);
    }

    /**
     * A vector of all possible {@link SectionType sections}.
     */
    public static final SectionType[] allSectionTypes = {
        BEFORE_FIRST_SECTION,
        FIRST_SECTION,
        SECOND_SECTION,
        THIRD_SECTION,
        CP,
        CE1,
        CE2,
        CM1,
        CM2,
        CLISS,
        UNKNOWN
    };

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
        else if (enumAsString.equals(CP.toString()))
            return CP;
        else if (enumAsString.equals(CE1.toString()))
            return CE1;
        else if (enumAsString.equals(CE2.toString()))
            return CE2;
        else if (enumAsString.equals(CM1.toString()))
            return CM1;
        else if (enumAsString.equals(CM2.toString()))
            return CM2;
        else if (enumAsString.equals(CLISS.toString()))
            return CLISS;

        return UNKNOWN;
    }
}
