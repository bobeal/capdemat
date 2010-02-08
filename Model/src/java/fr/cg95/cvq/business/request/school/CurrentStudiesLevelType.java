package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class CurrentStudiesLevelType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final CurrentStudiesLevelType FIRST_YEAR = new CurrentStudiesLevelType("firstYear");
  
    public static final CurrentStudiesLevelType SECOND_YEAR = new CurrentStudiesLevelType("secondYear");
  
    public static final CurrentStudiesLevelType THIRD_YEAR = new CurrentStudiesLevelType("thirdYear");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CurrentStudiesLevelType(String value) {
        super(value);
    }

    public CurrentStudiesLevelType() {}

    public static CurrentStudiesLevelType[] allCurrentStudiesLevelTypes = {
        FIRST_YEAR,
        SECOND_YEAR,
        THIRD_YEAR
    };

    public static CurrentStudiesLevelType getDefaultCurrentStudiesLevelType() {
        return null;
    }

    public static CurrentStudiesLevelType forString(final String enumAsString) {
        for (CurrentStudiesLevelType value : allCurrentStudiesLevelTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultCurrentStudiesLevelType();
    }
}
