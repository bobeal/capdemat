package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RsrMaritalStatusType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrMaritalStatusType ALONE = new RsrMaritalStatusType("Alone");
    public static final RsrMaritalStatusType COUPLE = new RsrMaritalStatusType("Couple");
    public static final RsrMaritalStatusType FAMILY = new RsrMaritalStatusType("Family");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrMaritalStatusType(String value) {
       super(value);
    }


    public RsrMaritalStatusType() {}



    public static RsrMaritalStatusType[] allRsrMaritalStatusTypes = {
        ALONE,
        COUPLE,
        FAMILY
    };


    public static RsrMaritalStatusType getDefaultRsrMaritalStatusType() {
        return null;
    }


    public static RsrMaritalStatusType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrMaritalStatusType();

        if (enumAsString.equals(ALONE.toString()))
            return ALONE;
        else if (enumAsString.equals(COUPLE.toString()))
            return COUPLE;
        else if (enumAsString.equals(FAMILY.toString()))
            return FAMILY;

        return getDefaultRsrMaritalStatusType();
    }
}
