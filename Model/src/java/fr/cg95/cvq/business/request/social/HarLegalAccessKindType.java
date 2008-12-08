package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarLegalAccessKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarLegalAccessKindType SAFEGUARDING_JUSTICE = new HarLegalAccessKindType("safeguardingJustice");
    public static final HarLegalAccessKindType GUARDIANSHIP = new HarLegalAccessKindType("guardianship");
    public static final HarLegalAccessKindType CURATORSHIP = new HarLegalAccessKindType("curatorship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarLegalAccessKindType(String value) {
       super(value);
    }


    public HarLegalAccessKindType() {}



    public static HarLegalAccessKindType[] allHarLegalAccessKindTypes = {
        SAFEGUARDING_JUSTICE,
        GUARDIANSHIP,
        CURATORSHIP
    };


    public static HarLegalAccessKindType getDefaultHarLegalAccessKindType() {
        return null;
    }


    public static HarLegalAccessKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarLegalAccessKindType();

        if (enumAsString.equals(SAFEGUARDING_JUSTICE.toString()))
            return SAFEGUARDING_JUSTICE;
        else if (enumAsString.equals(GUARDIANSHIP.toString()))
            return GUARDIANSHIP;
        else if (enumAsString.equals(CURATORSHIP.toString()))
            return CURATORSHIP;

        return getDefaultHarLegalAccessKindType();
    }
}
