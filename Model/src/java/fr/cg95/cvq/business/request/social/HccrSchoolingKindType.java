package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HccrSchoolingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HccrSchoolingKindType FULL_TIME = new HccrSchoolingKindType("FullTime");
    public static final HccrSchoolingKindType PART_TIME = new HccrSchoolingKindType("PartTime");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrSchoolingKindType(String value) {
       super(value);
    }


    public HccrSchoolingKindType() {}



    public static HccrSchoolingKindType[] allHccrSchoolingKindTypes = {
        FULL_TIME,
        PART_TIME
    };


    public static HccrSchoolingKindType getDefaultHccrSchoolingKindType() {
        return null;
    }


    public static HccrSchoolingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHccrSchoolingKindType();

        if (enumAsString.equals(FULL_TIME.toString()))
            return FULL_TIME;
        else if (enumAsString.equals(PART_TIME.toString()))
            return PART_TIME;

        return getDefaultHccrSchoolingKindType();
    }
}
