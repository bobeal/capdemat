package fr.cg95.cvq.business.request.election;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ElectoralChoiceEuropeanType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ElectoralChoiceEuropeanType MUNICIPAL_ELECTORAL = new ElectoralChoiceEuropeanType("MunicipalElectoral");
  
    public static final ElectoralChoiceEuropeanType EUROPEAN_ELECTORAL = new ElectoralChoiceEuropeanType("EuropeanElectoral");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ElectoralChoiceEuropeanType(String value) {
        super(value);
    }

    public ElectoralChoiceEuropeanType() {}

    public static ElectoralChoiceEuropeanType[] allElectoralChoiceEuropeanTypes = {
        MUNICIPAL_ELECTORAL,
        EUROPEAN_ELECTORAL
    };

    public static ElectoralChoiceEuropeanType getDefaultElectoralChoiceEuropeanType() {
        return null;
    }

    public static ElectoralChoiceEuropeanType forString(final String enumAsString) {
        for (ElectoralChoiceEuropeanType value : allElectoralChoiceEuropeanTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultElectoralChoiceEuropeanType();
    }
}
