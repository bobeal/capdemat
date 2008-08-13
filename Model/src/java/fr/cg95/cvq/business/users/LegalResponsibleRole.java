package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class LegalResponsibleRole extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final LegalResponsibleRole MOTHER = new LegalResponsibleRole("Mother");
    public static final LegalResponsibleRole FATHER = new LegalResponsibleRole("Father");
    public static final LegalResponsibleRole TUTOR = new LegalResponsibleRole("Tutor");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private LegalResponsibleRole(String role) {
        super(role);
    }

    public LegalResponsibleRole() {
    }

    public static final LegalResponsibleRole[] allLegalResponsibleRoleTypes = { 
        MOTHER, FATHER, TUTOR 
    };

    public static LegalResponsibleRole forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return TUTOR;

        if (enumAsString.equals(MOTHER.toString()))
            return MOTHER;
        else if (enumAsString.equals(FATHER.toString()))
            return FATHER;

        return TUTOR;
    }
}
