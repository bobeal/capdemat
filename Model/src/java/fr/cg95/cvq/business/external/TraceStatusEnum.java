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
    
    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private TraceStatusEnum(final String state) {
        super(state);
    }

    public TraceStatusEnum() {}

    public static TraceStatusEnum forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return SENT;

        if (enumAsString.equals(SENT.toString()))
            return SENT;
        else if (enumAsString.equals(IN_PROGRESS.toString()))
            return IN_PROGRESS;
        else if (enumAsString.equals(NOT_SENT.toString()))
            return NOT_SENT;
        else if (enumAsString.equals(ACKNOWLEDGED.toString()))
            return ACKNOWLEDGED;
        else if (enumAsString.equals(ERROR.toString()))
            return ERROR;

        return SENT;
    }
}