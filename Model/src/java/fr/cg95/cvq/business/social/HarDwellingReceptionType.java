package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class HarDwellingReceptionType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarDwellingReceptionType INTERNSHIP = new HarDwellingReceptionType("Internship");
    public static final HarDwellingReceptionType CLERKSHIP = new HarDwellingReceptionType("Clerkship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarDwellingReceptionType(String value) {
       super(value);
    }


    public HarDwellingReceptionType() {}



    public static HarDwellingReceptionType getDefaultHarDwellingReceptionType() {
        return null;
    }


    public static HarDwellingReceptionType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarDwellingReceptionType();

        if (enumAsString.equals(INTERNSHIP.toString()))
            return INTERNSHIP;
        else if (enumAsString.equals(CLERKSHIP.toString()))
            return CLERKSHIP;

        return getDefaultHarDwellingReceptionType();
    }
}
