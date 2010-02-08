package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class CurrentStudiesType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final CurrentStudiesType LICENCE = new CurrentStudiesType("licence");
  
    public static final CurrentStudiesType LICENCE_PRO = new CurrentStudiesType("licencePro");
  
    public static final CurrentStudiesType MASTER = new CurrentStudiesType("master");
  
    public static final CurrentStudiesType BTS = new CurrentStudiesType("bts");
  
    public static final CurrentStudiesType DUT = new CurrentStudiesType("dut");
  
    public static final CurrentStudiesType OTHER_STUDIES = new CurrentStudiesType("otherStudies");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private CurrentStudiesType(String value) {
        super(value);
    }

    public CurrentStudiesType() {}

    public static CurrentStudiesType[] allCurrentStudiesTypes = {
        LICENCE,
        LICENCE_PRO,
        MASTER,
        BTS,
        DUT,
        OTHER_STUDIES
    };

    public static CurrentStudiesType getDefaultCurrentStudiesType() {
        return null;
    }

    public static CurrentStudiesType forString(final String enumAsString) {
        for (CurrentStudiesType value : allCurrentStudiesTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultCurrentStudiesType();
    }
}
