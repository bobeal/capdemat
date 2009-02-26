package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HcarFamilyDependentActualSituationType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HcarFamilyDependentActualSituationType SCHOOLING = new HcarFamilyDependentActualSituationType("Schooling");
    public static final HcarFamilyDependentActualSituationType LEARNING = new HcarFamilyDependentActualSituationType("Learning");
    public static final HcarFamilyDependentActualSituationType MEDICO_SOCIAL = new HcarFamilyDependentActualSituationType("MedicoSocial");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarFamilyDependentActualSituationType(String value) {
       super(value);
    }


    public HcarFamilyDependentActualSituationType() {}



    public static HcarFamilyDependentActualSituationType[] allHcarFamilyDependentActualSituationTypes = {
        SCHOOLING,
        LEARNING,
        MEDICO_SOCIAL
    };


    public static HcarFamilyDependentActualSituationType getDefaultHcarFamilyDependentActualSituationType() {
        return null;
    }


    public static HcarFamilyDependentActualSituationType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHcarFamilyDependentActualSituationType();

        if (enumAsString.equals(SCHOOLING.toString()))
            return SCHOOLING;
        else if (enumAsString.equals(LEARNING.toString()))
            return LEARNING;
        else if (enumAsString.equals(MEDICO_SOCIAL.toString()))
            return MEDICO_SOCIAL;

        return getDefaultHcarFamilyDependentActualSituationType();
    }
}
