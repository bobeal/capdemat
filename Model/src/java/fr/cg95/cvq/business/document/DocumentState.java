package fr.cg95.cvq.business.document;

/**
 * @author bor@zenexity.fr
 */
public enum DocumentState {

    DRAFT("Draft"),
    PENDING("Pending"),
    VALIDATED("Validated"),
    CHECKED("Checked"),
    REFUSED("Refused"),
    OUTDATED("Outdated");

    private String name;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DocumentState(String state) {
        this.name = state;
    }

    /**
     * only for retro-compatibility use DocumentState.values() instead
     * @deprecated only for retro-compatibility
     */
    public static final DocumentState[] allDocumentStates = DocumentState.values();

    public static DocumentState forString(String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return DRAFT;

        if (enumAsString.equals(DRAFT.toString()))
            return DRAFT;
        else if (enumAsString.equals(PENDING.toString()))
            return PENDING;
        else if (enumAsString.equals(VALIDATED.toString()))
            return VALIDATED;
        else if (enumAsString.equals(CHECKED.toString()))
            return CHECKED;
        else if (enumAsString.equals(REFUSED.toString()))
            return REFUSED;
        else if (enumAsString.equals(OUTDATED.toString()))
            return OUTDATED;

        return PENDING;
    }

    @Override
    public String toString() {
        return name;
    }
}
