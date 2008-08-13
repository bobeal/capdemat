package fr.cg95.cvq.dao.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.DocumentType;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentTypeDAO extends IGenericDAO {

    /**
     * Lookup a document type by type.
     */
    DocumentType findByType(final Integer typeId);

    /**
     * Return the list of all known documents types.
     */
    List listAll();
}
