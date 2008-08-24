package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * State of data associated to a request.
 * 
 * @author bor@zenexity.fr
 */
public final class DataState extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	public static final DataState PENDING = new DataState("Pending");
    public static final DataState VALID = new DataState("Valid");
    public static final DataState INVALID = new DataState("Invalid");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DataState(String state) {
        super(state);
    }

    public DataState() {}

    public static DataState forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return PENDING;

        if (enumAsString.equals(PENDING.toString()))
            return PENDING;
        else if (enumAsString.equals(VALID.toString()))
            return VALID;
        else if (enumAsString.equals(INVALID.toString()))
            return INVALID;

        return PENDING;
    }

    public boolean equals(DataState dataState) {
        if (dataState == null)
            return false;

        return toString().equals(dataState.toString());
    }
    
}
