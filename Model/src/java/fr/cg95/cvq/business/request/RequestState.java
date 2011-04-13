package fr.cg95.cvq.business.request;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public enum RequestState {

    DRAFT("Draft"),
    PENDING("Pending"),
    COMPLETE("Complete"),
    UNCOMPLETE("Uncomplete"),
    VALIDATED("Validated"),
    NOTIFIED("Notified"),
    CLOSED("Closed"),
    REJECTED("Rejected"),
    CANCELLED("Cancelled"),
    ARCHIVED("Archived");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestState(String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }

    public static final RequestState[] allRequestStates = RequestState.values();

    public static RequestState forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return PENDING;
        for (RequestState rs : allRequestStates)
            if (rs.toString().equals(enumAsString)) return rs;
        return PENDING;
    }

    public boolean equals(RequestState requestState) {
        if (requestState == null)
            return false;

        return toString().equals(requestState.toString());
    }

    @Override
    public String toString() {
        return legacyLabel;
    }
}
