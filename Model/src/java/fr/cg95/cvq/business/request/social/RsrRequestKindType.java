package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RsrRequestKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrRequestKindType INDIVIDUAL = new RsrRequestKindType("Individual");
    public static final RsrRequestKindType COUPLE = new RsrRequestKindType("Couple");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrRequestKindType(String value) {
       super(value);
    }


    public RsrRequestKindType() {}



    public static RsrRequestKindType[] allRsrRequestKindTypes = {
        INDIVIDUAL,
        COUPLE
    };


    public static RsrRequestKindType getDefaultRsrRequestKindType() {
        return INDIVIDUAL;
    }


    public static RsrRequestKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrRequestKindType();

        if (enumAsString.equals(INDIVIDUAL.toString()))
            return INDIVIDUAL;
        else if (enumAsString.equals(COUPLE.toString()))
            return COUPLE;

        return getDefaultRsrRequestKindType();
    }
}
