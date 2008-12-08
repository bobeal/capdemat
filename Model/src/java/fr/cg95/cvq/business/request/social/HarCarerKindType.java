package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarCarerKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarCarerKindType CARER = new HarCarerKindType("Carer");
    public static final HarCarerKindType HOME_HELP = new HarCarerKindType("HomeHelp");
    public static final HarCarerKindType OTHER = new HarCarerKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarCarerKindType(String value) {
       super(value);
    }


    public HarCarerKindType() {}



    public static HarCarerKindType[] allHarCarerKindTypes = {
        CARER,
        HOME_HELP,
        OTHER
    };


    public static HarCarerKindType getDefaultHarCarerKindType() {
        return null;
    }


    public static HarCarerKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarCarerKindType();

        if (enumAsString.equals(CARER.toString()))
            return CARER;
        else if (enumAsString.equals(HOME_HELP.toString()))
            return HOME_HELP;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarCarerKindType();
    }
}
