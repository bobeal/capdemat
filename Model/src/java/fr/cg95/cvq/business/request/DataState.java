package fr.cg95.cvq.business.request;

/**
 * State of data associated to a request.
 * 
 * @author bor@zenexity.fr
 */
public enum DataState {

    PENDING("Pending"),
    VALID("Valid"),
    INVALID("Invalid");

    private String name;

    private DataState(String state) {
        this.name = state;
    }

    /**
     * only for retro-compatibility use DataState.values() instead
     * @deprecated only for retro-compatibility
     */
    public static final DataState[] allDataStates = DataState.values();

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

    @Override
    public String toString() {
        return name;
    }
}
