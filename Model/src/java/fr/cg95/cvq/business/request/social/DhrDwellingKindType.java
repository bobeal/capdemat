package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrDwellingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrDwellingKindType PLACE_OF_RESIDENCE = new DhrDwellingKindType("placeOfResidence");
    public static final DhrDwellingKindType RETIREMENT_HOME = new DhrDwellingKindType("retirementHome");
    public static final DhrDwellingKindType OTHER = new DhrDwellingKindType("other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrDwellingKindType(String value) {
       super(value);
    }


    public DhrDwellingKindType() {}



    public static DhrDwellingKindType[] allDhrDwellingKindTypes = {
        PLACE_OF_RESIDENCE,
        RETIREMENT_HOME,
        OTHER
    };


    public static DhrDwellingKindType getDefaultDhrDwellingKindType() {
        return null;
    }


    public static DhrDwellingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrDwellingKindType();

        if (enumAsString.equals(PLACE_OF_RESIDENCE.toString()))
            return PLACE_OF_RESIDENCE;
        else if (enumAsString.equals(RETIREMENT_HOME.toString()))
            return RETIREMENT_HOME;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultDhrDwellingKindType();
    }
}
