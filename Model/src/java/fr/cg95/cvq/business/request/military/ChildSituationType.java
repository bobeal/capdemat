package fr.cg95.cvq.business.request.military;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.military.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class ChildSituationType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final ChildSituationType COLLEGE = new ChildSituationType("College");
    public static final ChildSituationType HIGHSCHOOL = new ChildSituationType("Highschool");
    public static final ChildSituationType STUDENT = new ChildSituationType("Student");
    public static final ChildSituationType EMPLOYEE = new ChildSituationType("Employee");
    public static final ChildSituationType APPRENTICE = new ChildSituationType("Apprentice");
    public static final ChildSituationType OTHER = new ChildSituationType("Other");
    public static final ChildSituationType UNKNOWN = new ChildSituationType("Unknown");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ChildSituationType(String value) {
       super(value);
    }


    public ChildSituationType() {}



    public static ChildSituationType getDefaultChildSituationType() {
        return UNKNOWN;
    }


    public static ChildSituationType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultChildSituationType();

        if (enumAsString.equals(COLLEGE.toString()))
            return COLLEGE;
        else if (enumAsString.equals(HIGHSCHOOL.toString()))
            return HIGHSCHOOL;
        else if (enumAsString.equals(STUDENT.toString()))
            return STUDENT;
        else if (enumAsString.equals(EMPLOYEE.toString()))
            return EMPLOYEE;
        else if (enumAsString.equals(APPRENTICE.toString()))
            return APPRENTICE;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;
        else if (enumAsString.equals(UNKNOWN.toString()))
            return UNKNOWN;

        return getDefaultChildSituationType();
    }
}
