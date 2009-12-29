package fr.cg95.cvq.service.request;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

public interface IRequestDocumentService {

    /**
     * Add a set of documents to a request.
     *
     * @param requestId the request to which documents have to be linked
     * @param documentsId a set of documents id that must have been created with
     *        the creation method provided by the
     *        {@link fr.cg95.cvq.service.document.IDocumentService} service
     */
    void addDocuments(@IsRequest final Long requestId, final Set<Long> documentsId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Add a single document to a request.
     *
     * @param requestId the request to which the document has to linked
     * @param documentId a document that must have been created with the creation
     *  method provided by the {@link fr.cg95.cvq.service.document.IDocumentService} service
     */
    void addDocument(@IsRequest final Long requestId, final Long documentId)
        throws CvqException, CvqObjectNotFoundException;
    
    /**
     * Add a single document to a request.
     * Enable adding document to not persisted request
     *
     * @param request to which the document has to linked
     * @param documentId a document that must have been created with the creation
     *  method provided by the {@link fr.cg95.cvq.service.document.IDocumentService} service
     */
    void addDocument(@IsRequest Request request, final Long documentId)
        throws CvqException, CvqObjectNotFoundException;
    
    void addDocuments(@IsRequest Request request, List<Document> documents) throws CvqException;

    /**
     * Remove link betwenn a document and a request.
     *
     * @param request to which the document is linked
     * @param documentId 
     */
    void removeDocument(@IsRequest Request request, final Long documentId)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Get references of documents associated to a request.
     *
     * As they are not automatically loaded from DB, they have to be explicitely
     * asked for.
     */
    Set<RequestDocument> getAssociatedDocuments(@IsRequest final Long requestId) throws CvqException;
    
    Set<RequestDocument> getAssociatedDocuments(@IsRequest Request request) throws CvqException;
}
