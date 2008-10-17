package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DhrRequesterHasSpouse extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrRequesterHasSpouse TRUE = new DhrRequesterHasSpouse("True");
    public static final DhrRequesterHasSpouse FALSE = new DhrRequesterHasSpouse("False");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrRequesterHasSpouse(String value) {
       super(value);
    }


    public DhrRequesterHasSpouse() {}



    public static DhrRequesterHasSpouse getDefaultDhrRequesterHasSpouse() {
        return null;
    }


    public static DhrRequesterHasSpouse forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrRequesterHasSpouse();

        if (enumAsString.equals(TRUE.toString()))
            return TRUE;
        else if (enumAsString.equals(FALSE.toString()))
            return FALSE;

        return getDefaultDhrRequesterHasSpouse();
    }
}
