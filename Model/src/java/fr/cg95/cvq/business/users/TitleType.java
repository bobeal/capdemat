package fr.cg95.cvq.business.users;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class TitleType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final TitleType MISTER = new TitleType("Mister");
    public static final TitleType MADAM = new TitleType("Madam");
    public static final TitleType MISS = new TitleType("Miss");
    public static final TitleType AGENCY = new TitleType("Agency");
    public static final TitleType UNKNOWN = new TitleType("Unknown");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private TitleType(String type) {
        super(type);
    }

    public TitleType() {
    }

    public static final TitleType[] allTitleTypes = { MISTER, MADAM, MISS, AGENCY, UNKNOWN };

    public static TitleType getDefaultTitleType() {
        return UNKNOWN;
    }
    
    public static TitleType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return UNKNOWN;

        if (enumAsString.equals(MISTER.toString()))
            return MISTER;
        else if (enumAsString.equals(MADAM.toString()))
            return MADAM;
        else if (enumAsString.equals(MISS.toString()))
            return MISS;
        else if (enumAsString.equals(AGENCY.toString()))
            return AGENCY;

        return UNKNOWN;
    }
}
