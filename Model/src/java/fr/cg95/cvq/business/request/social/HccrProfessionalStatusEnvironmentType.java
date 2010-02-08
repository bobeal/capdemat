package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrProfessionalStatusEnvironmentType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrProfessionalStatusEnvironmentType ORDINARY = new HccrProfessionalStatusEnvironmentType("Ordinary");
  
    public static final HccrProfessionalStatusEnvironmentType ADAPTED = new HccrProfessionalStatusEnvironmentType("Adapted");
  
    public static final HccrProfessionalStatusEnvironmentType PROTECTED = new HccrProfessionalStatusEnvironmentType("Protected");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrProfessionalStatusEnvironmentType(String value) {
        super(value);
    }

    public HccrProfessionalStatusEnvironmentType() {}

    public static HccrProfessionalStatusEnvironmentType[] allHccrProfessionalStatusEnvironmentTypes = {
        ORDINARY,
        ADAPTED,
        PROTECTED
    };

    public static HccrProfessionalStatusEnvironmentType getDefaultHccrProfessionalStatusEnvironmentType() {
        return null;
    }

    public static HccrProfessionalStatusEnvironmentType forString(final String enumAsString) {
        for (HccrProfessionalStatusEnvironmentType value : allHccrProfessionalStatusEnvironmentTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrProfessionalStatusEnvironmentType();
    }
}
