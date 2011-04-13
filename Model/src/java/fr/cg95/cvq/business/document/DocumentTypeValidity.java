package fr.cg95.cvq.business.document;

/**
 * Utility class used to represent the default validity duration of a
 * {@link fr.cg95.cvq.business.document.DocumentType document type}.
 *
 * @author bor@zenexity.fr
 */
public enum DocumentTypeValidity {

    /** a document type which does not have an end validity date */
    UNLIMITED("Unlimited"),
    /** a document type whose end validity date is expressed in years */
    YEAR("Year"),
    /** a document type whose end validity date is expressed in months */
    MONTH("Month"),
    /** a document type which is valid 'till the end of the current year */
    END_YEAR("End Year"),
    /** a document type which is valid 'till the end of the current school year */
    END_SCHOOL_YEAR("End School Year");

    private String name;

    private DocumentTypeValidity(String name) {
        this.name = name;
    }

    /**
     * A vector of all possible {@link DocumentTypeValidity DocumentTypeValidity}.
     * only for backward use DocumentTypeValidity.values() instead
     * @deprecated only for backward
     */
    public static final DocumentTypeValidity[] allDocumentTypeValidity = DocumentTypeValidity.values();

    @Override
    public String toString() {
        return name;
    }
}
