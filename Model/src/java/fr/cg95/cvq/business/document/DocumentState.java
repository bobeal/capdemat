package fr.cg95.cvq.business.document;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/** 
 * @author bor@zenexity.fr
 */
public final class DocumentState extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

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
}
