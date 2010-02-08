package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrProfessionalStatusKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrProfessionalStatusKindType EMPLOYEE = new HccrProfessionalStatusKindType("Employee");
  
    public static final HccrProfessionalStatusKindType UNEMPLOYED = new HccrProfessionalStatusKindType("Unemployed");
  
    public static final HccrProfessionalStatusKindType JOBLESS = new HccrProfessionalStatusKindType("Jobless");
  
    public static final HccrProfessionalStatusKindType STUDENT = new HccrProfessionalStatusKindType("Student");
  
    public static final HccrProfessionalStatusKindType RETIRED = new HccrProfessionalStatusKindType("Retired");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrProfessionalStatusKindType(String value) {
        super(value);
    }

    public HccrProfessionalStatusKindType() {}

    public static HccrProfessionalStatusKindType[] allHccrProfessionalStatusKindTypes = {
        EMPLOYEE,
        UNEMPLOYED,
        JOBLESS,
        STUDENT,
        RETIRED
    };

    public static HccrProfessionalStatusKindType getDefaultHccrProfessionalStatusKindType() {
        return null;
    }

    public static HccrProfessionalStatusKindType forString(final String enumAsString) {
        for (HccrProfessionalStatusKindType value : allHccrProfessionalStatusKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrProfessionalStatusKindType();
    }
}
