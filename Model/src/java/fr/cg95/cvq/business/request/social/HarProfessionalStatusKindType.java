package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarProfessionalStatusKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarProfessionalStatusKindType EMPLOYEE = new HarProfessionalStatusKindType("employee");
    public static final HarProfessionalStatusKindType UNEMPLOYED = new HarProfessionalStatusKindType("unemployed");
    public static final HarProfessionalStatusKindType JOBLESS = new HarProfessionalStatusKindType("jobless");
    public static final HarProfessionalStatusKindType STUDENT = new HarProfessionalStatusKindType("student");
    public static final HarProfessionalStatusKindType RETIRED = new HarProfessionalStatusKindType("retired");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarProfessionalStatusKindType(String value) {
       super(value);
    }


    public HarProfessionalStatusKindType() {}



    public static HarProfessionalStatusKindType[] allHarProfessionalStatusKindTypes = {
        EMPLOYEE,
        UNEMPLOYED,
        JOBLESS,
        STUDENT,
        RETIRED
    };


    public static HarProfessionalStatusKindType getDefaultHarProfessionalStatusKindType() {
        return null;
    }


    public static HarProfessionalStatusKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarProfessionalStatusKindType();

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

        return getDefaultHarProfessionalStatusKindType();
    }
}
