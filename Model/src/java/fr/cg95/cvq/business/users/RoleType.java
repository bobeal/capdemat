package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class RoleType extends PersistentStringEnum{

    public static final RoleType HOME_FOLDER_RESPONSIBLE = new RoleType("HomeFolderResponsible");
    public static final RoleType CLR_MOTHER = new RoleType("ClrMother");
    public static final RoleType CLR_FATHER = new RoleType("ClrFather");
    public static final RoleType CLR_TUTOR = new RoleType("ClrTutor");
    public static final RoleType TUTOR = new RoleType("Tutor");
    
    private static final long serialVersionUID = 1L;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RoleType(final String role) {
        super(role);
    }
    
    public RoleType() {
    }

    public static final RoleType[] allRoleTypes = { HOME_FOLDER_RESPONSIBLE, CLR_MOTHER,
        CLR_FATHER, CLR_TUTOR, TUTOR };
    
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
}
