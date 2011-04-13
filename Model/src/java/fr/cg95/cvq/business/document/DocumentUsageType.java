package fr.cg95.cvq.business.document;

/**
 * @author bor@zenexity.fr
 */
public enum DocumentUsageType {

    SINGLE_USE("Single Use"),
    REUSABLE("Reusable");

    private String name;

    private DocumentUsageType(String name) {
        this.name = name;
    }

    /**
     * A vector of all possible {@link DocumentUsageType  document usages types}.
     * @deprecated only for backward, use DocumentUsageType.values() instead
     */
    public static final DocumentUsageType[] allDocumentUsageType = DocumentUsageType.values();

    @Override
    public String toString() {
        return name;
    }
}
