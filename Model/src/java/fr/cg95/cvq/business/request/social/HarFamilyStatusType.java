package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarFamilyStatusType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarFamilyStatusType SINGLE = new HarFamilyStatusType("Single");
    public static final HarFamilyStatusType COUPLE = new HarFamilyStatusType("Couple");
    public static final HarFamilyStatusType OTHER = new HarFamilyStatusType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarFamilyStatusType(String value) {
       super(value);
    }


    public HarFamilyStatusType() {}



    public static HarFamilyStatusType[] allHarFamilyStatusTypes = {
        SINGLE,
        COUPLE,
        OTHER
    };


    public static HarFamilyStatusType getDefaultHarFamilyStatusType() {
        return null;
    }


    public static HarFamilyStatusType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarFamilyStatusType();

        if (enumAsString.equals(SINGLE.toString()))
            return SINGLE;
        else if (enumAsString.equals(COUPLE.toString()))
            return COUPLE;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarFamilyStatusType();
    }
}
