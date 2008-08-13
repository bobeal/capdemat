package fr.cg95.cvq.business.authority;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * @author bor@zenexity.fr
 */
public final class DocumentUsageType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final DocumentUsageType SINGLE_USE = new DocumentUsageType("Single Use");
    public static final DocumentUsageType REUSABLE = new DocumentUsageType("Reusable");

    public DocumentUsageType() {
    }

    private DocumentUsageType(String name) {
        super(name);
    }

    /**
     * A vector of all possible {@link DocumentUsageType  document usages types}.
     */
    public static final DocumentUsageType[] allDocumentUsageType = { SINGLE_USE, REUSABLE };
}
