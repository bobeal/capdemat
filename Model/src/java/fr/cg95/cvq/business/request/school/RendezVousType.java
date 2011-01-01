package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class RendezVousType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final RendezVousType PHYSIQUE = new RendezVousType("Physique");
  
    public static final RendezVousType TELEPHONIQUE = new RendezVousType("Telephonique");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RendezVousType(String value) {
        super(value);
    }

    public RendezVousType() {}

    public static RendezVousType[] allRendezVousTypes = {
        PHYSIQUE,
        TELEPHONIQUE
    };

    public static RendezVousType getDefaultRendezVousType() {
        return null;
    }

    public static RendezVousType forString(final String enumAsString) {
        for (RendezVousType value : allRendezVousTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRendezVousType();
    }
}
