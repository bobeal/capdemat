package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrGuardianMeasureType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrGuardianMeasureType SAFEGUARDING_JUSTICE = new DhrGuardianMeasureType("safeguardingJustice");
    public static final DhrGuardianMeasureType GUARDIANSHIP = new DhrGuardianMeasureType("guardianship");
    public static final DhrGuardianMeasureType CURATORSHIP = new DhrGuardianMeasureType("curatorship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrGuardianMeasureType(String value) {
       super(value);
    }


    public DhrGuardianMeasureType() {}



    public static DhrGuardianMeasureType[] allDhrGuardianMeasureTypes = {
        SAFEGUARDING_JUSTICE,
        GUARDIANSHIP,
        CURATORSHIP
    };


    public static DhrGuardianMeasureType getDefaultDhrGuardianMeasureType() {
        return null;
    }


    public static DhrGuardianMeasureType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrGuardianMeasureType();

        if (enumAsString.equals(SAFEGUARDING_JUSTICE.toString()))
            return SAFEGUARDING_JUSTICE;
        else if (enumAsString.equals(GUARDIANSHIP.toString()))
            return GUARDIANSHIP;
        else if (enumAsString.equals(CURATORSHIP.toString()))
            return CURATORSHIP;

        return getDefaultDhrGuardianMeasureType();
    }
}
