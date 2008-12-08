package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarGenderType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarGenderType MALE = new HarGenderType("male");
    public static final HarGenderType FEMALE = new HarGenderType("female");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarGenderType(String value) {
       super(value);
    }


    public HarGenderType() {}



    public static HarGenderType[] allHarGenderTypes = {
        MALE,
        FEMALE
    };


    public static HarGenderType getDefaultHarGenderType() {
        return null;
    }


    public static HarGenderType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarGenderType();

        if (enumAsString.equals(MALE.toString()))
            return MALE;
        else if (enumAsString.equals(FEMALE.toString()))
            return FEMALE;

        return getDefaultHarGenderType();
    }
}
