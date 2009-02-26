package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarProfessionalStatusEnvironmentType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarProfessionalStatusEnvironmentType ORDINARY = new HcarProfessionalStatusEnvironmentType("Ordinary");
    public static final HcarProfessionalStatusEnvironmentType ADAPTED = new HcarProfessionalStatusEnvironmentType("Adapted");
    public static final HcarProfessionalStatusEnvironmentType PROTECTED = new HcarProfessionalStatusEnvironmentType("Protected");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarProfessionalStatusEnvironmentType(String value) {
       super(value);
    }


    public HcarProfessionalStatusEnvironmentType() {}



    public static HcarProfessionalStatusEnvironmentType[] allHcarProfessionalStatusEnvironmentTypes = {
        ORDINARY,
        ADAPTED,
        PROTECTED
    };


    public static HcarProfessionalStatusEnvironmentType getDefaultHcarProfessionalStatusEnvironmentType() {
        return null;
    }


    public static HcarProfessionalStatusEnvironmentType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarProfessionalStatusEnvironmentType();

        if (enumAsString.equals(ORDINARY.toString()))
            return ORDINARY;
        else if (enumAsString.equals(ADAPTED.toString()))
            return ADAPTED;
        else if (enumAsString.equals(PROTECTED.toString()))
            return PROTECTED;

        return getDefaultHcarProfessionalStatusEnvironmentType();
    }
}
