package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarDwellingReceptionKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarDwellingReceptionKindType INTERNSHIP = new HarDwellingReceptionKindType("Internship");
    public static final HarDwellingReceptionKindType CLERKSHIP = new HarDwellingReceptionKindType("Clerkship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarDwellingReceptionKindType(String value) {
       super(value);
    }


    public HarDwellingReceptionKindType() {}



    public static HarDwellingReceptionKindType[] allHarDwellingReceptionKindTypes = {
        INTERNSHIP,
        CLERKSHIP
    };


    public static HarDwellingReceptionKindType getDefaultHarDwellingReceptionKindType() {
        return null;
    }


    public static HarDwellingReceptionKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarDwellingReceptionKindType();

        if (enumAsString.equals(INTERNSHIP.toString()))
            return INTERNSHIP;
        else if (enumAsString.equals(CLERKSHIP.toString()))
            return CLERKSHIP;

        return getDefaultHarDwellingReceptionKindType();
    }
}
