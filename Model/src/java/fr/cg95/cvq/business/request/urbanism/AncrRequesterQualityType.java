package fr.cg95.cvq.business.request.urbanism;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.urbanism.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class AncrRequesterQualityType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final AncrRequesterQualityType OWNER = new AncrRequesterQualityType("Owner");
    public static final AncrRequesterQualityType TENANT = new AncrRequesterQualityType("Tenant");
    public static final AncrRequesterQualityType CABINET = new AncrRequesterQualityType("Cabinet");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private AncrRequesterQualityType(String value) {
       super(value);
    }


    public AncrRequesterQualityType() {}



    public static AncrRequesterQualityType[] allAncrRequesterQualityTypes = {
        OWNER,
        TENANT,
        CABINET
    };


    public static AncrRequesterQualityType getDefaultAncrRequesterQualityType() {
        return OWNER;
    }


    public static AncrRequesterQualityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultAncrRequesterQualityType();

        if (enumAsString.equals(OWNER.toString()))
            return OWNER;
        else if (enumAsString.equals(TENANT.toString()))
            return TENANT;
        else if (enumAsString.equals(CABINET.toString()))
            return CABINET;

        return getDefaultAncrRequesterQualityType();
    }
}
