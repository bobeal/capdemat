package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarHomeIntervenantKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarHomeIntervenantKindType CARER = new HcarHomeIntervenantKindType("Carer");
    public static final HcarHomeIntervenantKindType HOME_HELP = new HcarHomeIntervenantKindType("HomeHelp");
    public static final HcarHomeIntervenantKindType OTHER = new HcarHomeIntervenantKindType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarHomeIntervenantKindType(String value) {
       super(value);
    }


    public HcarHomeIntervenantKindType() {}



    public static HcarHomeIntervenantKindType[] allHcarHomeIntervenantKindTypes = {
        CARER,
        HOME_HELP,
        OTHER
    };


    public static HcarHomeIntervenantKindType getDefaultHcarHomeIntervenantKindType() {
        return null;
    }


    public static HcarHomeIntervenantKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarHomeIntervenantKindType();

        if (enumAsString.equals(CARER.toString()))
            return CARER;
        else if (enumAsString.equals(HOME_HELP.toString()))
            return HOME_HELP;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHcarHomeIntervenantKindType();
    }
}
