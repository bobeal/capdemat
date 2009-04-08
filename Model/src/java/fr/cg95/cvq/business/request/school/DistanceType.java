package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DistanceType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

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
        LESS_THAN30KMS,
        BETWEEN30AND250KMS,
        MORE_THAN250KMS_AND_ABROAD
    };


    public static DistanceType getDefaultDistanceType() {
        return null;
    }


    public static DistanceType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDistanceType();

        if (enumAsString.equals(LESS_THAN30KMS.toString()))
            return LESS_THAN30KMS;
        else if (enumAsString.equals(BETWEEN30AND250KMS.toString()))
            return BETWEEN30AND250KMS;
        else if (enumAsString.equals(MORE_THAN250KMS_AND_ABROAD.toString()))
            return MORE_THAN250KMS_AND_ABROAD;

        return getDefaultDistanceType();
    }
}
