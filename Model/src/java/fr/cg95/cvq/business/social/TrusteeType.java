package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class TrusteeType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final TrusteeType REQUESTER = new TrusteeType("Requester");
    public static final TrusteeType OTHER = new TrusteeType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private TrusteeType(String value) {
       super(value);
    }


    public TrusteeType() {}



    public static TrusteeType getDefaultTrusteeType() {
        return null;
    }


    public static TrusteeType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultTrusteeType();

        if (enumAsString.equals(REQUESTER.toString()))
            return REQUESTER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultTrusteeType();
    }
}
