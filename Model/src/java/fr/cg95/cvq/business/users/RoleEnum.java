package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public final class RoleEnum extends PersistentStringEnum{

    public static final RoleEnum HOME_FOLDER_RESPONSIBLE = new RoleEnum("HomeFolderResponsible");
    public static final RoleEnum CLR_MOTHER = new RoleEnum("ClrMother");
    public static final RoleEnum CLR_FATHER = new RoleEnum("ClrFather");
    public static final RoleEnum CLR_TUTOR = new RoleEnum("ClrTutor");
    public static final RoleEnum TUTOR = new RoleEnum("Tutor");
    
    private static final long serialVersionUID = 1L;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RoleEnum(final String role) {
        super(role);
    }
    
    public RoleEnum() {
    }
    
    public static RoleEnum forString(String role) {
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
