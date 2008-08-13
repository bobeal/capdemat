package fr.cg95.cvq.business.authority;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Utility class used to represent the default validity duration of a
 * {@link fr.cg95.cvq.business.authority.DocumentType document type}.
 *
 * @author bor@zenexity.fr
 */
public final class DocumentTypeValidity extends PersistentStringEnum {

	private static final long serialVersionUID = 1L;

	/** a document type which does not have an end validity date */
    public static final DocumentTypeValidity UNLIMITED =
        new DocumentTypeValidity("Unlimited");
    /** a document type whose end validity date is expressed in years */
    public static final DocumentTypeValidity YEAR =
        new DocumentTypeValidity("Year");
    /** a document type whose end validity date is expressed in months */
    public static final DocumentTypeValidity MONTH =
        new DocumentTypeValidity("Month");
    /** a document type which is valid 'till the end of the current year */
    public static final DocumentTypeValidity END_YEAR =
        new DocumentTypeValidity("End Year");
    /** a document type which is valid 'till the end of the current school year */
    public static final DocumentTypeValidity END_SCHOOL_YEAR =
        new DocumentTypeValidity("End School Year");

    public DocumentTypeValidity() {}

    private DocumentTypeValidity(String name) {
        super(name);
    }

    /**
     * A vector of all possible {@link DocumentTypeValidity DocumentTypeValidity}.
     */
    public static final DocumentTypeValidity[] allDocumentTypeValidity = {
        UNLIMITED,
        YEAR,
        MONTH,
        END_YEAR,
        END_SCHOOL_YEAR
    };
}
