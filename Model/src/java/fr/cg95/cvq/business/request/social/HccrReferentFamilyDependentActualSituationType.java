package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrReferentFamilyDependentActualSituationType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrReferentFamilyDependentActualSituationType SCHOOLING = new HccrReferentFamilyDependentActualSituationType("Schooling");
  
    public static final HccrReferentFamilyDependentActualSituationType LEARNING = new HccrReferentFamilyDependentActualSituationType("Learning");
  
    public static final HccrReferentFamilyDependentActualSituationType MEDICO_SOCIAL = new HccrReferentFamilyDependentActualSituationType("MedicoSocial");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrReferentFamilyDependentActualSituationType(String value) {
        super(value);
    }

    public HccrReferentFamilyDependentActualSituationType() {}

    public static HccrReferentFamilyDependentActualSituationType[] allHccrReferentFamilyDependentActualSituationTypes = {
        SCHOOLING,
        LEARNING,
        MEDICO_SOCIAL
    };

    public static HccrReferentFamilyDependentActualSituationType getDefaultHccrReferentFamilyDependentActualSituationType() {
        return null;
    }

    public static HccrReferentFamilyDependentActualSituationType forString(final String enumAsString) {
        for (HccrReferentFamilyDependentActualSituationType value : allHccrReferentFamilyDependentActualSituationTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrReferentFamilyDependentActualSituationType();
    }
}
