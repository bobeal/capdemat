package fr.cg95.cvq.dao.users;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.users.Document;
import fr.cg95.cvq.business.users.DocumentState;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentDAO extends IGenericDAO {

    /**
     * Look up an {@link Document} given a set of search criteria.
     */
    List search(final Set criteria);

    /**
     * Return the list of all known {@link Document documents}.
     */
    List listAll();

    /**
     * Return the {@link Document documents} who belong to the given 
     * home folder with the specified type.
     */
    List listProvidedDocuments(final Long docTypeId, final Long homeFolderId, 
            final Long individualId);

    /**
     * Return the {@link Document documents} belonging to a given home folder.
     */
    List listByHomeFolder(final Long homeFolderId);

    /**
     * Return the {@link Document documents} belonging to the given individual.
     */
    List listByIndividual(final Long individualId);

    /**
     * Return the {@link Document documents} belonging to the given request.
     */
    List listByRequest(final Long requestId);

    /**
     * Return the {@link Document documents} which are in the given state.
     */
    List listByState(final DocumentState documentState);
}
