package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarLegalAccessKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarLegalAccessKindType SAFEGUARDING_JUSTICE = new HcarLegalAccessKindType("safeguardingJustice");
    public static final HcarLegalAccessKindType GUARDIANSHIP = new HcarLegalAccessKindType("guardianship");
    public static final HcarLegalAccessKindType CURATORSHIP = new HcarLegalAccessKindType("curatorship");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarLegalAccessKindType(String value) {
       super(value);
    }


    public HcarLegalAccessKindType() {}



    public static HcarLegalAccessKindType[] allHcarLegalAccessKindTypes = {
        SAFEGUARDING_JUSTICE,
        GUARDIANSHIP,
        CURATORSHIP
    };


    public static HcarLegalAccessKindType getDefaultHcarLegalAccessKindType() {
        return null;
    }


    public static HcarLegalAccessKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarLegalAccessKindType();

        if (enumAsString.equals(SAFEGUARDING_JUSTICE.toString()))
            return SAFEGUARDING_JUSTICE;
        else if (enumAsString.equals(GUARDIANSHIP.toString()))
            return GUARDIANSHIP;
        else if (enumAsString.equals(CURATORSHIP.toString()))
            return CURATORSHIP;

        return getDefaultHcarLegalAccessKindType();
    }
}
