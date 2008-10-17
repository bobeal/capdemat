package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class HarFamilyDependentActualSituationType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarFamilyDependentActualSituationType SCHOOLING = new HarFamilyDependentActualSituationType("Schooling");
    public static final HarFamilyDependentActualSituationType LEARNING = new HarFamilyDependentActualSituationType("Learning");
    public static final HarFamilyDependentActualSituationType MEDICO_SOCIAL = new HarFamilyDependentActualSituationType("MedicoSocial");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarFamilyDependentActualSituationType(String value) {
       super(value);
    }


    public HarFamilyDependentActualSituationType() {}



    public static HarFamilyDependentActualSituationType getDefaultHarFamilyDependentActualSituationType() {
        return null;
    }


    public static HarFamilyDependentActualSituationType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarFamilyDependentActualSituationType();

        if (enumAsString.equals(SCHOOLING.toString()))
            return SCHOOLING;
        else if (enumAsString.equals(LEARNING.toString()))
            return LEARNING;
        else if (enumAsString.equals(MEDICO_SOCIAL.toString()))
            return MEDICO_SOCIAL;

        return getDefaultHarFamilyDependentActualSituationType();
    }
}
