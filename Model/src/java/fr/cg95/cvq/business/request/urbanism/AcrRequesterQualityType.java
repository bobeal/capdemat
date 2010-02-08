package fr.cg95.cvq.business.request.urbanism;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class AcrRequesterQualityType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final AcrRequesterQualityType OWNER = new AcrRequesterQualityType("Owner");
  
    public static final AcrRequesterQualityType TENANT = new AcrRequesterQualityType("Tenant");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private AcrRequesterQualityType(String value) {
        super(value);
    }

    public AcrRequesterQualityType() {}

    public static AcrRequesterQualityType[] allAcrRequesterQualityTypes = {
        OWNER,
        TENANT
    };

    public static AcrRequesterQualityType getDefaultAcrRequesterQualityType() {
        return OWNER;
    }

    public static AcrRequesterQualityType forString(final String enumAsString) {
        for (AcrRequesterQualityType value : allAcrRequesterQualityTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAcrRequesterQualityType();
    }
}
