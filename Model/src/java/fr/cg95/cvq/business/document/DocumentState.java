package fr.cg95.cvq.business.document;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/** 
 * @author bor@zenexity.fr
 */
public final class DocumentState extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final DocumentState DRAFT = new DocumentState("Draft");
    public static final DocumentState PENDING = new DocumentState("Pending");
    public static final DocumentState VALIDATED = new DocumentState("Validated");
    public static final DocumentState CHECKED = new DocumentState("Checked");
    public static final DocumentState REFUSED = new DocumentState("Refused");
    public static final DocumentState OUTDATED = new DocumentState("Outdated");

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DocumentState(String state) {
        super(state);
    }

    public DocumentState() {}
    
    public static final DocumentState[] allDocumentStates = 
            { DRAFT, PENDING, VALIDATED, CHECKED, REFUSED, OUTDATED };
    
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
}
