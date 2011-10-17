package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.security.annotation.IsUser;

/**
 * Manage home folder documents.
 *
 * A document wish list can be configured in BO with manager rights. Then users can fill this list with their documents
 * to make them available to the agents.
 */
public interface IHomeFolderDocumentService {

    /**
     * Link a single document to a home folder.
     * @param homeFolderId
     * @param documentId a document that must have been created with
     * {@link IDocumentService#create(Document)}
     */
    void link(@IsUser final Long homeFolderId, final Long documentId);

    /**
     * Link a single document to a home folder.
     * @param homeFolder
     * @param documentId a document that must have been created with
     * {@link IDocumentService#create(Document)}
     */
    void link(@IsUser final HomeFolder homeFolder, final Long documentId);

    /**
     * Remove link between a home folder and a document.
     * @param homeFolderId
     * @param documentId
     */
    void unlink(@IsUser final Long homeFolderId, final Long documentId);

    /**
     * Remove link between a home folder and a document.
     * @param homeFolder
     * @param documentId
     */
    void unlink(@IsUser final HomeFolder homeFolder, final Long documentId);

    /**
     * Return the list of documents linked to the home folder, filtered with the document type.
     * @param homeFolderId
     * @param documentType
     */
    public List<Document> documentsLinkedToHomeFolder(
            @IsUser final Long homeFolderId,
            DocumentType documentType);

    /**
     * Add the document type to the set of wished document types at home folder time.
     * @param documentTypeId
     */
    public void wish(Long documentTypeId);

    /**
     * Remove the document type to the set of wished document types at home folder time.
     * @param documentTypeId
     */
    public void unwish(Long documentTypeId);

    /**
     * Return the list of wished document types at home folder creation time.
     */
    public Set<DocumentType> wishedDocumentTypes();
}
