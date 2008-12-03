package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarRequestInformationKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarRequestInformationKindType FIRST = new HarRequestInformationKindType("First");
    public static final HarRequestInformationKindType RENEWAL = new HarRequestInformationKindType("Renewal");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarRequestInformationKindType(String value) {
       super(value);
    }


    public HarRequestInformationKindType() {}



    public static HarRequestInformationKindType[] allHarRequestInformationKindTypes = {
        FIRST,
        RENEWAL
    };


    public static HarRequestInformationKindType getDefaultHarRequestInformationKindType() {
        return null;
    }


    public static HarRequestInformationKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarRequestInformationKindType();

        if (enumAsString.equals(FIRST.toString()))
            return FIRST;
        else if (enumAsString.equals(RENEWAL.toString()))
            return RENEWAL;

        return getDefaultHarRequestInformationKindType();
    }
}
