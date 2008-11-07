package fr.cg95.cvq.dao.document;

import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentBinaryDAO extends IGenericDAO {

    /**
     * Look up a {@link DocumentBinary} by page and document.
     *
     * @return the sole {@link DocumentBinary} object or null if none is found
     */
    DocumentBinary findByDocumentAndPageId(final Long documentId,
            final Integer pageNumber);

    /**
     * Return the page number of the {@link DocumentBinary} object.
     */
    Integer getPage(final Long documentBinaryId);

    /**
     * Return whether the given page exists for the given document.
     */
    boolean hasPage(final Long documentId, final Integer pageNumber);

    /**
     * Return the next free page number available for the document.
     */
    Long getNextPageNumber(final Long documentId);

    /**
     * Return the number of pages this document has.
     */
    Long getPagesNumber(final Long documentId);
}
