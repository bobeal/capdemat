package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarProfessionalStatusKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarProfessionalStatusKindType EMPLOYEE = new HcarProfessionalStatusKindType("Employee");
    public static final HcarProfessionalStatusKindType UNEMPLOYED = new HcarProfessionalStatusKindType("Unemployed");
    public static final HcarProfessionalStatusKindType JOBLESS = new HcarProfessionalStatusKindType("Jobless");
    public static final HcarProfessionalStatusKindType STUDENT = new HcarProfessionalStatusKindType("Student");
    public static final HcarProfessionalStatusKindType RETIRED = new HcarProfessionalStatusKindType("Retired");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarProfessionalStatusKindType(String value) {
       super(value);
    }


    public HcarProfessionalStatusKindType() {}



    public static HcarProfessionalStatusKindType[] allHcarProfessionalStatusKindTypes = {
        EMPLOYEE,
        UNEMPLOYED,
        JOBLESS,
        STUDENT,
        RETIRED
    };


    public static HcarProfessionalStatusKindType getDefaultHcarProfessionalStatusKindType() {
        return null;
    }


    public static HcarProfessionalStatusKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarProfessionalStatusKindType();

        if (enumAsString.equals(EMPLOYEE.toString()))
            return EMPLOYEE;
        else if (enumAsString.equals(UNEMPLOYED.toString()))
            return UNEMPLOYED;
        else if (enumAsString.equals(JOBLESS.toString()))
            return JOBLESS;
        else if (enumAsString.equals(STUDENT.toString()))
            return STUDENT;
        else if (enumAsString.equals(RETIRED.toString()))
            return RETIRED;

        return getDefaultHcarProfessionalStatusKindType();
    }
}
