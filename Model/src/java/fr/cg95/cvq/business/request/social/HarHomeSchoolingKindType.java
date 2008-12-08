package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarHomeSchoolingKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarHomeSchoolingKindType ALONE = new HarHomeSchoolingKindType("Alone");
    public static final HarHomeSchoolingKindType ACCOMPANIED = new HarHomeSchoolingKindType("Accompanied");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarHomeSchoolingKindType(String value) {
       super(value);
    }


    public HarHomeSchoolingKindType() {}



    public static HarHomeSchoolingKindType[] allHarHomeSchoolingKindTypes = {
        ALONE,
        ACCOMPANIED
    };


    public static HarHomeSchoolingKindType getDefaultHarHomeSchoolingKindType() {
        return null;
    }


    public static HarHomeSchoolingKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarHomeSchoolingKindType();

        if (enumAsString.equals(ALONE.toString()))
            return ALONE;
        else if (enumAsString.equals(ACCOMPANIED.toString()))
            return ACCOMPANIED;

        return getDefaultHarHomeSchoolingKindType();
    }
}
