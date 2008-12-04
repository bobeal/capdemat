package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrTitleType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrTitleType MISTER = new DhrTitleType("Mister");
    public static final DhrTitleType MADAM = new DhrTitleType("Madam");
    public static final DhrTitleType MISS = new DhrTitleType("Miss");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrTitleType(String value) {
       super(value);
    }


    public DhrTitleType() {}



    public static DhrTitleType[] allDhrTitleTypes = {
        MISTER,
        MADAM,
        MISS
    };


    public static DhrTitleType getDefaultDhrTitleType() {
        return null;
    }


    public static DhrTitleType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrTitleType();

        if (enumAsString.equals(MISTER.toString()))
            return MISTER;
        else if (enumAsString.equals(MADAM.toString()))
            return MADAM;
        else if (enumAsString.equals(MISS.toString()))
            return MISS;

        return getDefaultDhrTitleType();
    }
}
