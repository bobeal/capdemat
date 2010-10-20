package fr.cg95.cvq.business.request.external;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author Victor Bartel
 *
 */
public final class RequestExternalActionState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestExternalActionState SENT = new RequestExternalActionState("Sent");
    public static final RequestExternalActionState IN_PROGRESS = new RequestExternalActionState("InProgress");
    public static final RequestExternalActionState NOT_SENT = new RequestExternalActionState("NotSent");
    public static final RequestExternalActionState ACKNOWLEDGED = new RequestExternalActionState("Acknowledged");
    public static final RequestExternalActionState ERROR = new RequestExternalActionState("Error");
    public static final RequestExternalActionState ACCEPTED = new RequestExternalActionState("Accepted");
    public static final RequestExternalActionState REJECTED = new RequestExternalActionState("Rejected");
    
    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestExternalActionState(final String state) {
        super(state);
    }

    public RequestExternalActionState() {}

    public static final RequestExternalActionState[] allTraceStatuses = {
        IN_PROGRESS,
        NOT_SENT,
        SENT,
        ACKNOWLEDGED,
        ACCEPTED,
        REJECTED,
        ERROR
    };

    public static RequestExternalActionState forString(final String enumAsString) {
        for (RequestExternalActionState t : allTraceStatuses)
            if (t.name.equals(enumAsString)) return t;
        return null;
    }
}