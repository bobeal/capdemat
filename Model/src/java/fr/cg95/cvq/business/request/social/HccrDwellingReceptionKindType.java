package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HccrDwellingReceptionKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HccrDwellingReceptionKindType INTERNSHIP = new HccrDwellingReceptionKindType("Internship");
    public static final HccrDwellingReceptionKindType CLERKSHIP = new HccrDwellingReceptionKindType("Clerkship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrDwellingReceptionKindType(String value) {
       super(value);
    }


    public HccrDwellingReceptionKindType() {}



    public static HccrDwellingReceptionKindType[] allHccrDwellingReceptionKindTypes = {
        INTERNSHIP,
        CLERKSHIP
    };


    public static HccrDwellingReceptionKindType getDefaultHccrDwellingReceptionKindType() {
        return null;
    }


    public static HccrDwellingReceptionKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHccrDwellingReceptionKindType();

        if (enumAsString.equals(INTERNSHIP.toString()))
            return INTERNSHIP;
        else if (enumAsString.equals(CLERKSHIP.toString()))
            return CLERKSHIP;

        return getDefaultHccrDwellingReceptionKindType();
    }
}
