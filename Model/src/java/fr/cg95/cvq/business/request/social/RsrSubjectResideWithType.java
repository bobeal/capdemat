package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class RsrSubjectResideWithType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final RsrSubjectResideWithType ALONE = new RsrSubjectResideWithType("Alone");
  
    public static final RsrSubjectResideWithType COUPLE = new RsrSubjectResideWithType("Couple");
  
    public static final RsrSubjectResideWithType FAMILY = new RsrSubjectResideWithType("Family");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrSubjectResideWithType(String value) {
        super(value);
    }

    public RsrSubjectResideWithType() {}

    public static RsrSubjectResideWithType[] allRsrSubjectResideWithTypes = {
        ALONE,
        COUPLE,
        FAMILY
    };

    public static RsrSubjectResideWithType getDefaultRsrSubjectResideWithType() {
        return ALONE;
    }

    public static RsrSubjectResideWithType forString(final String enumAsString) {
        for (RsrSubjectResideWithType value : allRsrSubjectResideWithTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRsrSubjectResideWithType();
    }
}
