package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrNationalityType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrNationalityType FRENCH = new DhrNationalityType("French");
    public static final DhrNationalityType E_U = new DhrNationalityType("EU");
    public static final DhrNationalityType NON_E_U = new DhrNationalityType("NonEU");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrNationalityType(String value) {
       super(value);
    }


    public DhrNationalityType() {}



    public static DhrNationalityType[] allDhrNationalityTypes = {
        FRENCH,
        E_U,
        NON_E_U
    };


    public static DhrNationalityType getDefaultDhrNationalityType() {
        return null;
    }


    public static DhrNationalityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrNationalityType();

        if (enumAsString.equals(FRENCH.toString()))
            return FRENCH;
        else if (enumAsString.equals(E_U.toString()))
            return E_U;
        else if (enumAsString.equals(NON_E_U.toString()))
            return NON_E_U;

        return getDefaultDhrNationalityType();
    }
}
