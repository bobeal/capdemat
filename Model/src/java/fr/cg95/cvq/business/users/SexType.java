package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class SexType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final SexType MALE = new SexType("Male");
    public static final SexType FEMALE = new SexType("Female");
    public static final SexType UNKNOWN = new SexType("Unknown");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private SexType(String type) {
        super(type);
    }

    public SexType() {
    }

    public static final SexType[] allSexTypes = { MALE, FEMALE, UNKNOWN };

    public static SexType getDefaultSexType() {
        return UNKNOWN;
    }

    public static SexType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return UNKNOWN;

        if (enumAsString.equals(MALE.toString()))
            return MALE;
        else if (enumAsString.equals(FEMALE.toString()))
            return FEMALE;

        return UNKNOWN;
    }
}
