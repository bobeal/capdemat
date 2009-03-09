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

}
