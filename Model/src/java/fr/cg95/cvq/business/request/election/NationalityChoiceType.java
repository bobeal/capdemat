package fr.cg95.cvq.business.request.election;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class NationalityChoiceType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final NationalityChoiceType FRENCH_NATIONALITY = new NationalityChoiceType("FrenchNationality");
  
    public static final NationalityChoiceType EUROPEAN_NATIONALITY = new NationalityChoiceType("EuropeanNationality");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private NationalityChoiceType(String value) {
        super(value);
    }

    public NationalityChoiceType() {}

    public static NationalityChoiceType[] allNationalityChoiceTypes = {
        FRENCH_NATIONALITY,
        EUROPEAN_NATIONALITY
    };

    public static NationalityChoiceType getDefaultNationalityChoiceType() {
        return FRENCH_NATIONALITY;
    }

    public static NationalityChoiceType forString(final String enumAsString) {
        for (NationalityChoiceType value : allNationalityChoiceTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultNationalityChoiceType();
    }
}
