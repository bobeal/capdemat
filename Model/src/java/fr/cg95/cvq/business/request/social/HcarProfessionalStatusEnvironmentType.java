package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarProfessionalStatusEnvironmentType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarProfessionalStatusEnvironmentType ORDINARY = new HcarProfessionalStatusEnvironmentType("Ordinary");
  
    public static final HcarProfessionalStatusEnvironmentType ADAPTED = new HcarProfessionalStatusEnvironmentType("Adapted");
  
    public static final HcarProfessionalStatusEnvironmentType PROTECTED = new HcarProfessionalStatusEnvironmentType("Protected");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarProfessionalStatusEnvironmentType(String value) {
        super(value);
    }

    public HcarProfessionalStatusEnvironmentType() {}

    public static HcarProfessionalStatusEnvironmentType[] allHcarProfessionalStatusEnvironmentTypes = {
        ORDINARY,
        ADAPTED,
        PROTECTED
    };

    public static HcarProfessionalStatusEnvironmentType getDefaultHcarProfessionalStatusEnvironmentType() {
        return null;
    }

    public static HcarProfessionalStatusEnvironmentType forString(final String enumAsString) {
        for (HcarProfessionalStatusEnvironmentType value : allHcarProfessionalStatusEnvironmentTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarProfessionalStatusEnvironmentType();
    }
}
