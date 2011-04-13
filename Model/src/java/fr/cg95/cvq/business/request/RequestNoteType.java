package fr.cg95.cvq.business.request;

/**
 * @author bor@zenexity.fr
 */
public enum RequestNoteType {

    INTERNAL("Internal"),
    PUBLIC("Public");

    private static final long serialVersionUID = 1L;
    private String name;

    /**
     * @deprecated only for backward, use values() instead
     */
    public static final RequestNoteType[] allRequestNoteTypes = RequestNoteType.values();

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RequestNoteType(String type) {
        this.name = type;
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

    @Override
    public String toString() {
        return name;
    }
}
