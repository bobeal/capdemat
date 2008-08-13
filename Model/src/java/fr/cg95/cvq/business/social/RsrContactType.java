package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class RsrContactType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrContactType REQUESTER = new RsrContactType("Requester");
    public static final RsrContactType OTHER = new RsrContactType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrContactType(String value) {
       super(value);
    }


    public RsrContactType() {}



    public static RsrContactType getDefaultRsrContactType() {
        return null;
    }


    public static RsrContactType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrContactType();

        if (enumAsString.equals(REQUESTER.toString()))
            return REQUESTER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultRsrContactType();
    }
}
