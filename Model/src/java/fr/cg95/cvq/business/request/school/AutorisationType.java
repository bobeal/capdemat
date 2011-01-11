package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class AutorisationType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final AutorisationType SEUL = new AutorisationType("Seul");
  
    public static final AutorisationType AVEC_FRERE_SOEUR = new AutorisationType("AvecFrereSoeur");
  
    public static final AutorisationType AVEC_TIERS = new AutorisationType("AvecTiers");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private AutorisationType(String value) {
        super(value);
    }

    public AutorisationType() {}

    public static AutorisationType[] allAutorisationTypes = {
        SEUL,
        AVEC_FRERE_SOEUR,
        AVEC_TIERS
    };

    public static AutorisationType getDefaultAutorisationType() {
        return null;
    }

    public static AutorisationType forString(final String enumAsString) {
        for (AutorisationType value : allAutorisationTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultAutorisationType();
    }
}
