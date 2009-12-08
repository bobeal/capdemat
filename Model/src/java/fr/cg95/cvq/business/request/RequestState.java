package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class RequestState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestState PENDING = new RequestState("Pending");
    public static final RequestState COMPLETE = new RequestState("Complete");
    public static final RequestState UNCOMPLETE = new RequestState("Uncomplete");
    public static final RequestState VALIDATED = new RequestState("Validated");
    public static final RequestState NOTIFIED = new RequestState("Notified");
    public static final RequestState CLOSED = new RequestState("Closed");
    public static final RequestState REJECTED = new RequestState("Rejected");
    public static final RequestState CANCELLED = new RequestState("Cancelled");
    public static final RequestState ARCHIVED = new RequestState("Archived");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestState(String state) {
        super(state);
    }

    /**
     * Should be private but Hibernate requires a public default constructor.
     */
    public RequestState() {}

    public static final RequestState[] allRequestStates = {
        PENDING, COMPLETE, UNCOMPLETE, VALIDATED, NOTIFIED, CLOSED, REJECTED, CANCELLED, ARCHIVED
    };
  
    public static RequestState forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return PENDING;
        if (enumAsString.equals(PENDING.toString()))
            return PENDING;
        else if (enumAsString.equals(COMPLETE.toString()))
            return COMPLETE;
        else if (enumAsString.equals(UNCOMPLETE.toString()))
            return UNCOMPLETE;
        else if (enumAsString.equals(VALIDATED.toString()))
            return VALIDATED;
        else if (enumAsString.equals(NOTIFIED.toString()))
            return NOTIFIED;
        else if (enumAsString.equals(CLOSED.toString()))
            return CLOSED;
        else if (enumAsString.equals(REJECTED.toString()))
            return REJECTED;
        else if (enumAsString.equals(CANCELLED.toString()))
            return CANCELLED;
        else if (enumAsString.equals(ARCHIVED.toString()))
            return ARCHIVED;

        return PENDING;
    }

    public boolean equals(RequestState requestState) {
        if (requestState == null)
            return false;

        return toString().equals(requestState.toString());
    }
}
