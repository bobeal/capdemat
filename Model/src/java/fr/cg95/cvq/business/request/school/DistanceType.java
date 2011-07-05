package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DistanceType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DistanceType UNDETERMINED = new DistanceType("undetermined");
  
    public static final DistanceType LESS_THAN30KMS = new DistanceType("lessThan30kms");
  
    public static final DistanceType BETWEEN30AND250KMS = new DistanceType("between30and250kms");
  
    public static final DistanceType MORE_THAN250KMS_AND_ABROAD = new DistanceType("moreThan250kmsAndAbroad");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DistanceType(String value) {
        super(value);
    }

    public DistanceType() {}

    public static DistanceType[] allDistanceTypes = {
        UNDETERMINED,
        LESS_THAN30KMS,
        BETWEEN30AND250KMS,
        MORE_THAN250KMS_AND_ABROAD
    };

    public static DistanceType getDefaultDistanceType() {
        return UNDETERMINED;
    }

    public static DistanceType forString(final String enumAsString) {
        for (DistanceType value : allDistanceTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDistanceType();
    }
}
