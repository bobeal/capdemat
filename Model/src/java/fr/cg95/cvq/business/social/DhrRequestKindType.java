package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DhrRequestKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrRequestKindType INDIVIDUAL = new DhrRequestKindType("Individual");
    public static final DhrRequestKindType COUPLE = new DhrRequestKindType("Couple");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrRequestKindType(String value) {
       super(value);
    }


    public DhrRequestKindType() {}



    public static DhrRequestKindType getDefaultDhrRequestKindType() {
        return null;
    }


    public static DhrRequestKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrRequestKindType();

        if (enumAsString.equals(INDIVIDUAL.toString()))
            return INDIVIDUAL;
        else if (enumAsString.equals(COUPLE.toString()))
            return COUPLE;

        return getDefaultDhrRequestKindType();
    }
}
