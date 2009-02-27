package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RsrRequestInformationRequestKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrRequestInformationRequestKindType INDIVIDUAL = new RsrRequestInformationRequestKindType("Individual");
    public static final RsrRequestInformationRequestKindType COUPLE = new RsrRequestInformationRequestKindType("Couple");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrRequestInformationRequestKindType(String value) {
       super(value);
    }


    public RsrRequestInformationRequestKindType() {}



    public static RsrRequestInformationRequestKindType[] allRsrRequestInformationRequestKindTypes = {
        INDIVIDUAL,
        COUPLE
    };


    public static RsrRequestInformationRequestKindType getDefaultRsrRequestInformationRequestKindType() {
        return INDIVIDUAL;
    }


    public static RsrRequestInformationRequestKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrRequestInformationRequestKindType();

        if (enumAsString.equals(INDIVIDUAL.toString()))
            return INDIVIDUAL;
        else if (enumAsString.equals(COUPLE.toString()))
            return COUPLE;

        return getDefaultRsrRequestInformationRequestKindType();
    }
}
