package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class RequestState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestState DRAFT = new RequestState("Draft");
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
        DRAFT, PENDING, COMPLETE, UNCOMPLETE, VALIDATED, NOTIFIED, CLOSED, REJECTED, CANCELLED, ARCHIVED
    };
  
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
}
