package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarProfessionalStatusEnvironmentType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarProfessionalStatusEnvironmentType ORDINARY = new HarProfessionalStatusEnvironmentType("ordinary");
    public static final HarProfessionalStatusEnvironmentType ADAPTED = new HarProfessionalStatusEnvironmentType("adapted");
    public static final HarProfessionalStatusEnvironmentType PROTECTED = new HarProfessionalStatusEnvironmentType("protected");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarProfessionalStatusEnvironmentType(String value) {
       super(value);
    }


    public HarProfessionalStatusEnvironmentType() {}



    public static HarProfessionalStatusEnvironmentType[] allHarProfessionalStatusEnvironmentTypes = {
        ORDINARY,
        ADAPTED,
        PROTECTED
    };


    public static HarProfessionalStatusEnvironmentType getDefaultHarProfessionalStatusEnvironmentType() {
        return null;
    }


    public static HarProfessionalStatusEnvironmentType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarProfessionalStatusEnvironmentType();

        if (enumAsString.equals(ORDINARY.toString()))
            return ORDINARY;
        else if (enumAsString.equals(ADAPTED.toString()))
            return ADAPTED;
        else if (enumAsString.equals(PROTECTED.toString()))
            return PROTECTED;

        return getDefaultHarProfessionalStatusEnvironmentType();
    }
}
