package fr.cg95.cvq.dao.document;

import java.util.List;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IDocumentDAO extends IGenericDAO {

    /**
     * Return the documents who belong to the given home folder with the specified type.
     */
    List<Document> listProvidedDocuments(final Long docTypeId, final Long homeFolderId, 
            final Long individualId);

    /**
     * Return the {@link Document documents} belonging to a given home folder.
     */
    List<Document> listByHomeFolder(final Long homeFolderId);
    
    /**
     * Return the {@link Document documents} belonging to a given home folder.
     * 
     * @param homeFolderId
     * @param max
     * @return
     */
    List<Document> listByHomeFolder(final Long homeFolderId, int max);

    /**
     * Return the {@link Document documents} belonging to the given individual.
     */
    List<Document> listByIndividual(final Long individualId);

    /**
     * Return the documents which are in the given state.
     */
    List<Document> listByState(final DocumentState documentState);
}
