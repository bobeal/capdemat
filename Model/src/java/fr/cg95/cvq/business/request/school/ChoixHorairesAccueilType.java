package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ChoixHorairesAccueilType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ChoixHorairesAccueilType INDIFFERENT = new ChoixHorairesAccueilType("Indifferent");
  
    public static final ChoixHorairesAccueilType REGULIER = new ChoixHorairesAccueilType("Regulier");
  
    public static final ChoixHorairesAccueilType IRREGULIER = new ChoixHorairesAccueilType("Irregulier");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ChoixHorairesAccueilType(String value) {
        super(value);
    }

    public ChoixHorairesAccueilType() {}

    public static ChoixHorairesAccueilType[] allChoixHorairesAccueilTypes = {
        INDIFFERENT,
        REGULIER,
        IRREGULIER
    };

    public static ChoixHorairesAccueilType getDefaultChoixHorairesAccueilType() {
        return null;
    }

    public static ChoixHorairesAccueilType forString(final String enumAsString) {
        for (ChoixHorairesAccueilType value : allChoixHorairesAccueilTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChoixHorairesAccueilType();
    }
}
