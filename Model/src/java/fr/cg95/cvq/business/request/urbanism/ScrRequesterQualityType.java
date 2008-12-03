package fr.cg95.cvq.business.request.urbanism;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.urbanism.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class ScrRequesterQualityType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final ScrRequesterQualityType OWNER = new ScrRequesterQualityType("Owner");
    public static final ScrRequesterQualityType TENANT = new ScrRequesterQualityType("Tenant");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ScrRequesterQualityType(String value) {
       super(value);
    }


    public ScrRequesterQualityType() {}



    public static ScrRequesterQualityType[] allScrRequesterQualityTypes = {
        OWNER,
        TENANT
    };


    public static ScrRequesterQualityType getDefaultScrRequesterQualityType() {
        return null;
    }


    public static ScrRequesterQualityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultScrRequesterQualityType();

        if (enumAsString.equals(OWNER.toString()))
            return OWNER;
        else if (enumAsString.equals(TENANT.toString()))
            return TENANT;

        return getDefaultScrRequesterQualityType();
    }
}
