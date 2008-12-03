package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RsrDwellingType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RsrDwellingType APPARTMENT = new RsrDwellingType("Appartment");
    public static final RsrDwellingType HOUSE = new RsrDwellingType("House");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrDwellingType(String value) {
       super(value);
    }


    public RsrDwellingType() {}



    public static RsrDwellingType[] allRsrDwellingTypes = {
        APPARTMENT,
        HOUSE
    };


    public static RsrDwellingType getDefaultRsrDwellingType() {
        return null;
    }


    public static RsrDwellingType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRsrDwellingType();

        if (enumAsString.equals(APPARTMENT.toString()))
            return APPARTMENT;
        else if (enumAsString.equals(HOUSE.toString()))
            return HOUSE;

        return getDefaultRsrDwellingType();
    }
}
