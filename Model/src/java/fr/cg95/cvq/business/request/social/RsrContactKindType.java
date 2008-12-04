package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RsrContactKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrContactKindType REQUESTER = new RsrContactKindType("requester");
    public static final RsrContactKindType OTHER = new RsrContactKindType("other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrContactKindType(String value) {
       super(value);
    }


    public RsrContactKindType() {}



    public static RsrContactKindType[] allRsrContactKindTypes = {
        REQUESTER,
        OTHER
    };


    public static RsrContactKindType getDefaultRsrContactKindType() {
        return null;
    }


    public static RsrContactKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrContactKindType();

        if (enumAsString.equals(REQUESTER.toString()))
            return REQUESTER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultRsrContactKindType();
    }
}
