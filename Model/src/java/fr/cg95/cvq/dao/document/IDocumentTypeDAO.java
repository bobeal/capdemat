package fr.cg95.cvq.dao.document;

import java.util.List;

import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.dao.jpa.IJpaTemplate;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentTypeDAO extends IJpaTemplate<DocumentType, Long> {

    /**
     * Lookup a document type by type.
     */
    DocumentType findByType(final Integer typeId);

    /**
     * Return the list of all known documents types.
     */
    List<DocumentType> listAll();
}
