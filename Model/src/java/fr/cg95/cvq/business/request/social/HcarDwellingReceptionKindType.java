package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarDwellingReceptionKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarDwellingReceptionKindType INTERNSHIP = new HcarDwellingReceptionKindType("Internship");
    public static final HcarDwellingReceptionKindType CLERKSHIP = new HcarDwellingReceptionKindType("Clerkship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarDwellingReceptionKindType(String value) {
       super(value);
    }


    public HcarDwellingReceptionKindType() {}



    public static HcarDwellingReceptionKindType[] allHcarDwellingReceptionKindTypes = {
        INTERNSHIP,
        CLERKSHIP
    };


    public static HcarDwellingReceptionKindType getDefaultHcarDwellingReceptionKindType() {
        return null;
    }


    public static HcarDwellingReceptionKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarDwellingReceptionKindType();

        if (enumAsString.equals(INTERNSHIP.toString()))
            return INTERNSHIP;
        else if (enumAsString.equals(CLERKSHIP.toString()))
            return CLERKSHIP;

        return getDefaultHcarDwellingReceptionKindType();
    }
}
