package fr.cg95.cvq.dao.users;

import fr.cg95.cvq.business.users.DocumentBinary;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.permission.CvqPermissionException;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentBinaryDAO extends IGenericDAO {

    /**
     * Look up a {@link DocumentBinary} by page and document
     *
     * @return the sole {@link DocumentBinary} object or null if none is found
     */
    DocumentBinary findByDocumentAndPageId(final Long documentId,
            final Integer pageNumber) throws CvqPermissionException;

    /**
     * Return the page number of the {@link DocumentBinary} object
     */
    Integer getPage(final Long documentBinaryId);

    /**
     * Return whether the given page exists for the given document
     */
    boolean hasPage(final Long documentId, final Integer pageNumber)
        throws CvqPermissionException;

    /**
     * Return the next free page number available for the document
     */
    Long getNextPageNumber(final Long documentId) throws CvqPermissionException;

    /**
     * Return the number of pages this document has
     */
    Long getPagesNumber(final Long documentId) throws CvqPermissionException;
}
