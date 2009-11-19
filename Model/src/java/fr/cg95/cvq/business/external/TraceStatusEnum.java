package fr.cg95.cvq.business.external;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author Victor Bartel
 *
 */
public final class TraceStatusEnum extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final TraceStatusEnum SENT = new TraceStatusEnum("Sent");
    public static final TraceStatusEnum IN_PROGRESS = new TraceStatusEnum("InProgress");
    public static final TraceStatusEnum NOT_SENT = new TraceStatusEnum("NotSent");
    public static final TraceStatusEnum ACKNOWLEDGED = new TraceStatusEnum("Acknowledged");
    public static final TraceStatusEnum ERROR = new TraceStatusEnum("Error");
    public static final TraceStatusEnum ACCEPTED = new TraceStatusEnum("Accepted");
    public static final TraceStatusEnum REJECTED = new TraceStatusEnum("Rejected");
    
    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private TraceStatusEnum(final String state) {
        super(state);
    }

    public TraceStatusEnum() {}

    public static final TraceStatusEnum[] allTraceStatuses = {
        IN_PROGRESS,
        NOT_SENT,
        SENT,
        ACKNOWLEDGED,
        ACCEPTED,
        REJECTED,
        ERROR
    };

    public static TraceStatusEnum forString(final String enumAsString) {
        for (TraceStatusEnum t : allTraceStatuses)
            if (t.name.equals(enumAsString)) return t;
        return null;
    }
}