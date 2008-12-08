package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarSchoolingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarSchoolingKindType FULL_TIME = new HarSchoolingKindType("FullTime");
    public static final HarSchoolingKindType PART_TIME = new HarSchoolingKindType("PartTime");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarSchoolingKindType(String value) {
       super(value);
    }


    public HarSchoolingKindType() {}



    public static HarSchoolingKindType[] allHarSchoolingKindTypes = {
        FULL_TIME,
        PART_TIME
    };


    public static HarSchoolingKindType getDefaultHarSchoolingKindType() {
        return null;
    }


    public static HarSchoolingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarSchoolingKindType();

        if (enumAsString.equals(FULL_TIME.toString()))
            return FULL_TIME;
        else if (enumAsString.equals(PART_TIME.toString()))
            return PART_TIME;

        return getDefaultHarSchoolingKindType();
    }
}
