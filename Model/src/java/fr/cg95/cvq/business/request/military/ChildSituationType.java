package fr.cg95.cvq.business.request.military;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
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

    public static ChildSituationType[] allChildSituationTypes = {
        COLLEGE,
        HIGHSCHOOL,
        STUDENT,
        EMPLOYEE,
        APPRENTICE,
        OTHER,
        UNKNOWN
    };

    public static ChildSituationType getDefaultChildSituationType() {
        return null;
    }

    public static ChildSituationType forString(final String enumAsString) {
        for (ChildSituationType value : allChildSituationTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChildSituationType();
    }
}
