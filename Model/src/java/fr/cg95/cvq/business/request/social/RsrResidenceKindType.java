package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RsrResidenceKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrResidenceKindType FLAT = new RsrResidenceKindType("flat");
    public static final RsrResidenceKindType HOUSE = new RsrResidenceKindType("house");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrResidenceKindType(String value) {
       super(value);
    }


    public RsrResidenceKindType() {}



    public static RsrResidenceKindType[] allRsrResidenceKindTypes = {
        FLAT,
        HOUSE
    };


    public static RsrResidenceKindType getDefaultRsrResidenceKindType() {
        return null;
    }


    public static RsrResidenceKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrResidenceKindType();

        if (enumAsString.equals(FLAT.toString()))
            return FLAT;
        else if (enumAsString.equals(HOUSE.toString()))
            return HOUSE;

        return getDefaultRsrResidenceKindType();
    }
}
