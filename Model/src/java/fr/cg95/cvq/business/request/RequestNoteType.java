package fr.cg95.cvq.business.request;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class RequestNoteType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final RequestNoteType INTERNAL =
        new RequestNoteType("Internal");
    public static final RequestNoteType PUBLIC =
        new RequestNoteType("Public");

    public static final RequestNoteType[] allRequestNoteTypes = {
        PUBLIC,
        INTERNAL
    };

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestNoteType(String type) {
        super(type);
    }

    public RequestNoteType() {
    }

    public static RequestNoteType forString(String enumAsString) {
        if (enumAsString == null || enumAsString.trim().isEmpty())
            return null;
        if (INTERNAL.toString().equals(enumAsString))
            return INTERNAL;
        if (PUBLIC.toString().equals(enumAsString))
            return PUBLIC;
        return null;
    }
}
