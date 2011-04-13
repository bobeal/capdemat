package fr.cg95.cvq.business.users;

public enum RoleType {

    HOME_FOLDER_RESPONSIBLE("HomeFolderResponsible"),
    CLR_MOTHER("ClrMother"),
    CLR_FATHER("ClrFather"),
    CLR_TUTOR("ClrTutor"),
    TUTOR("Tutor");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RoleType(final String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }

    /**
     * @deprecated only for backward, use values() instead
     */
    public static final RoleType[] allRoleTypes = RoleType.values();

    public static final RoleType[] childRoleTypes = { CLR_MOTHER, CLR_FATHER, CLR_TUTOR };

    public static final RoleType[] adultRoleTypes = { TUTOR };

    public static final RoleType[] homeFolderRoleTypes = { HOME_FOLDER_RESPONSIBLE, TUTOR };

    public static RoleType forString(String role) {
        if (role == null || role.length() == 0)
            return null;

        if (role.equals(HOME_FOLDER_RESPONSIBLE.toString()))
            return HOME_FOLDER_RESPONSIBLE;
        else if (role.equals(CLR_MOTHER.toString()))
            return CLR_MOTHER;
        else if (role.equals(CLR_FATHER.toString()))
            return CLR_FATHER;
        else if (role.equals(CLR_TUTOR.toString()))
            return CLR_TUTOR;
        else if (role.equals(TUTOR.toString()))
            return TUTOR;

        return null;
    }

    @Override
    public String toString() {
        return legacyLabel;
    }
}
