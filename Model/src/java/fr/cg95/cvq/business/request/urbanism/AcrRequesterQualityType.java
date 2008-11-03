package fr.cg95.cvq.business.request.urbanism;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.urbanism.*;

/**
 *
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



    public static AcrRequesterQualityType getDefaultAcrRequesterQualityType() {
        return null;
    }


    public static AcrRequesterQualityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultAcrRequesterQualityType();

        if (enumAsString.equals(OWNER.toString()))
            return OWNER;
        else if (enumAsString.equals(TENANT.toString()))
            return TENANT;

        return getDefaultAcrRequesterQualityType();
    }
}
