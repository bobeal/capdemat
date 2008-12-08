package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarTitleType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarTitleType MISS = new HarTitleType("Miss");
    public static final HarTitleType MADAM = new HarTitleType("Madam");
    public static final HarTitleType MISTER = new HarTitleType("Mister");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarTitleType(String value) {
       super(value);
    }


    public HarTitleType() {}



    public static HarTitleType[] allHarTitleTypes = {
        MISS,
        MADAM,
        MISTER
    };


    public static HarTitleType getDefaultHarTitleType() {
        return null;
    }


    public static HarTitleType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarTitleType();

        if (enumAsString.equals(MISS.toString()))
            return MISS;
        else if (enumAsString.equals(MADAM.toString()))
            return MADAM;
        else if (enumAsString.equals(MISTER.toString()))
            return MISTER;

        return getDefaultHarTitleType();
    }
}
