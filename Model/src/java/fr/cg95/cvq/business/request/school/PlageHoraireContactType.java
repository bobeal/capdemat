package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class PlageHoraireContactType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final PlageHoraireContactType MATIN = new PlageHoraireContactType("Matin");
  
    public static final PlageHoraireContactType APREM = new PlageHoraireContactType("Aprem");
  
    public static final PlageHoraireContactType SOIR = new PlageHoraireContactType("Soir");
  
    public static final PlageHoraireContactType INDIFFERENT = new PlageHoraireContactType("Indifferent");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private PlageHoraireContactType(String value) {
        super(value);
    }

    public PlageHoraireContactType() {}

    public static PlageHoraireContactType[] allPlageHoraireContactTypes = {
        MATIN,
        APREM,
        SOIR,
        INDIFFERENT
    };

    public static PlageHoraireContactType getDefaultPlageHoraireContactType() {
        return null;
    }

    public static PlageHoraireContactType forString(final String enumAsString) {
        for (PlageHoraireContactType value : allPlageHoraireContactTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultPlageHoraireContactType();
    }
}
