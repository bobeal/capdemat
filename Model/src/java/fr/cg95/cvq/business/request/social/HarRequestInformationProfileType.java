package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarRequestInformationProfileType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarRequestInformationProfileType ADULT = new HarRequestInformationProfileType("Adult");
    public static final HarRequestInformationProfileType LESS_THAN20 = new HarRequestInformationProfileType("LessThan20");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarRequestInformationProfileType(String value) {
       super(value);
    }


    public HarRequestInformationProfileType() {}



    public static HarRequestInformationProfileType getDefaultHarRequestInformationProfileType() {
        return null;
    }


    public static HarRequestInformationProfileType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarRequestInformationProfileType();

        if (enumAsString.equals(ADULT.toString()))
            return ADULT;
        else if (enumAsString.equals(LESS_THAN20.toString()))
            return LESS_THAN20;

        return getDefaultHarRequestInformationProfileType();
    }
}
