package fr.cg95.cvq.service.request.impl;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;

import fr.capwebct.capdemat.DocumentType;
import fr.capwebct.capdemat.GetDocumentListResponseDocument;
import fr.capwebct.capdemat.GetDocumentResponseDocument;
import fr.capwebct.capdemat.GetDocumentListResponseDocument.GetDocumentListResponse;
import fr.capwebct.capdemat.GetDocumentResponseDocument.GetDocumentResponse;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentAction;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestDocumentService;
import fr.cg95.cvq.service.request.IRequestExternalService;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.util.translation.ITranslationService;

public class RequestDocumentService implements IRequestDocumentService {

    private IRequestDAO requestDAO;
    
    private IRequestExternalService requestExternalService;
    private IRequestSearchService requestSearchService;
    private IDocumentService documentService;
    private IExternalService externalService;
    private ITranslationService translationService;
    
    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addDocuments(final Long requestId, final Set<Long> documentsId)
        throws CvqException, CvqObjectNotFoundException {

        Request request = getById(requestId);

        for (Long documentId : documentsId) {
            RequestDocument requestDocument = new RequestDocument();
            requestDocument.setDocumentId(documentId);
            if (request.getDocuments() == null) {
                Set<RequestDocument> documentSet = new HashSet<RequestDocument>();
                documentSet.add(requestDocument);
                request.setDocuments(documentSet);
            } else {
                request.getDocuments().add(requestDocument);
            }
        }

        updateLastModificationInformation(request);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addDocument(final Long requestId, final Long documentId)
        throws CvqException, CvqObjectNotFoundException {

        Request request = getById(requestId);

        RequestDocument requestDocument = new RequestDocument();
        requestDocument.setDocumentId(documentId);
        if (request.getDocuments() == null) {
            Set<RequestDocument> documents = new HashSet<RequestDocument>();
            documents.add(requestDocument);
            request.setDocuments(documents);
        } else {
            request.getDocuments().add(requestDocument);
        }

        updateLastModificationInformation(request);
    }
    
    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addDocument(Request request, final Long documentId)
        throws CvqException, CvqObjectNotFoundException {
        RequestDocument requestDocument = new RequestDocument();
        requestDocument.setDocumentId(documentId);
        if (request.getId() != null)
            request = getById(request.getId());
        if (request.getDocuments() == null) {
            Set<RequestDocument> documents = new HashSet<RequestDocument>();
            documents.add(requestDocument);
            request.setDocuments(documents);
        } else {
            request.getDocuments().add(requestDocument);
        }
 
        // this method is called when adding a document to a request being created
        // in this case, do not update modification information
        if (request.getId() != null)
            updateLastModificationInformation(request);
    }
    
    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void addDocuments(Request request, List<Document> documents)
        throws CvqException {
        
        if (documents == null)
            return;

        for (Document document : documents) {
            document.setSessionUuid(null);
            document.setHomeFolderId(request.getHomeFolderId());
            document.setDepositId(request.getRequesterId());
            for (DocumentAction documentAction : document.getActions()) {
                documentAction.setAgentId(request.getRequesterId());
            }
            addDocument(request, document.getId());
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void removeDocument(Request request, final Long documentId)
        throws CvqException, CvqObjectNotFoundException {
        if (request.getId() != null)
            request = getById(request.getId());
        Iterator<RequestDocument> it = request.getDocuments().iterator();
        while (it.hasNext()) {
            RequestDocument rd = it.next();
            if (rd.getDocumentId().equals(documentId)){
                it.remove();
            }
        }

        // this method is called when adding a document to a request being created
        // in this case, do not update modification information
        if (request.getId() != null)
            updateLastModificationInformation(request);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Set<RequestDocument> getAssociatedDocuments(final Long requestId)
        throws CvqException {

        Request request = getById(requestId);
        return request.getDocuments();
    }
    
    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Set<Document> getAssociatedDocumentsByType(final Long requestId, final Long documentTypeId)
        throws CvqException {
        Request request = getById(requestId);
        if (request.getDocuments() == null)
            return Collections.emptySet();
        Set<Document> result = new HashSet<Document>();
        for (RequestDocument requestDocument : request.getDocuments()) {
            Document document = documentService.getById(requestDocument.getDocumentId());
            if (document.getDocumentType().getId().equals(documentTypeId))
                result.add(document);
        }
        return result;
    }

    @Override
    @Context(types = {ContextType.EXTERNAL_SERVICE}, privilege = ContextPrivilege.READ)
    public GetDocumentListResponseDocument getAssociatedFullDocuments(final Long requestId) 
        throws CvqException, CvqObjectNotFoundException, PermissionException {
        Request request = getById(requestId);

        GetDocumentListResponseDocument getDocumentListResponseDocument =
            GetDocumentListResponseDocument.Factory.newInstance();
        GetDocumentListResponse getDocumentListResponse = 
            getDocumentListResponseDocument.addNewGetDocumentListResponse();

        Collection<String> authorizedRequestTypesLabels =
            requestExternalService.getRequestTypesForExternalService(SecurityContext.getCurrentExternalService());
        
        // Check external service permissions wrt configured request types labels
        String requestTypeLabel = request.getRequestType().getLabel();
        if (requestTypeLabel == null || authorizedRequestTypesLabels == null || 
                !authorizedRequestTypesLabels.contains(requestTypeLabel)) {
            throw new PermissionException(this.getClass(), "getAssociatedFullDocuments", 
                    new ContextType[] {ContextType.EXTERNAL_SERVICE}, ContextPrivilege.READ, 
                    "");
        }

        if (request.getDocuments().isEmpty()) {
            return getDocumentListResponseDocument;
        }
        
        // Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);

        for (RequestDocument rd : request.getDocuments()) {
            Document doc = documentService.getById(rd.getDocumentId());
            DocumentType documentType = getDocumentListResponse.addNewDocument();
            documentType.setDocumentId(doc.getId());
            documentType.setType(doc.getDocumentType().getName());
            documentType.setState(doc.getState().toString());
            Calendar calendar = new GregorianCalendar();
            if (doc.getValidationDate() != null) {
                calendar.setTime(doc.getValidationDate());
                documentType.setValidationDate(calendar);
            }
            if (doc.getEndValidityDate() != null) {
                calendar.setTime(doc.getEndValidityDate());
                documentType.setEndValidityDate(calendar);
            }
        }

        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);
        
        return getDocumentListResponseDocument;
    }

    @Override
    public GetDocumentResponseDocument getAssociatedDocument(Long requestId, Long documentId,
            boolean mergeDocument) throws CvqException, CvqObjectNotFoundException, PermissionException {

        Request request = getById(requestId);

        Collection<String> authorizedRequestTypesLabels =
            requestExternalService.getRequestTypesForExternalService(SecurityContext.getCurrentExternalService());
        
        // Check external service permissions wrt configured request types labels
        String requestTypeLabel = request.getRequestType().getLabel();
        if (requestTypeLabel == null || authorizedRequestTypesLabels == null || 
                !authorizedRequestTypesLabels.contains(requestTypeLabel)) {
            throw new PermissionException(this.getClass(), "getAssociatedFullDocuments", 
                    new ContextType[] {ContextType.EXTERNAL_SERVICE}, ContextPrivilege.READ, "");
        }

        GetDocumentResponseDocument getDocumentResponseDocument =
            GetDocumentResponseDocument.Factory.newInstance();
        
        GetDocumentResponse getDocumentResponse = 
            getDocumentResponseDocument.addNewGetDocumentResponse();

        ExternalServiceTrace est = new ExternalServiceTrace(new Date(), String.valueOf(requestId), null, "capdemat", 
                null, SecurityContext.getCurrentExternalService(), TraceStatusEnum.SENT);

        // Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);

        if (documentId != null) {
            // check the document is really associated to the request
            // someone could try to cheat with us
            boolean isDocumentReallyAssociated = false;
            for (RequestDocument requestDocument : request.getDocuments()) {
                if (requestDocument.getDocumentId().equals(documentId)) {
                    isDocumentReallyAssociated = true;
                    break;
                }
            }
            if (!isDocumentReallyAssociated)
                throw new PermissionException(this.getClass(), "getAssociatedDocument", 
                        new ContextType[] {ContextType.EXTERNAL_SERVICE}, ContextPrivilege.READ, "");

            Document document = documentService.getById(documentId);

            String message = 
                translationService.translate("externalservice.trace.sent.document", 
                        new Object[] { document.getId()}
                );
            est.setMessage(message);
            est.setSubkey("document");

            // Check if the document contains pages
            if (document.getDatas().isEmpty()) {
                externalService.addTrace(est);
                return getDocumentResponseDocument;
            }

            if (mergeDocument) {
                documentService.mergeDocumentBinary(document);
                byte[] encodedDocumentData = Base64.encodeBase64(document.getDatas().get(0).getData());
                getDocumentResponse.addDocumentBinary(encodedDocumentData);
            } else {
                for (int i = 0; i < document.getDatas().size(); i++) {
                    byte[] documentData = document.getDatas().get(i).getData();
                    byte[] encodedDocumentData = Base64.encodeBase64(documentData);
                    getDocumentResponse.addDocumentBinary(encodedDocumentData);
                }
            }

        } else {
            byte[] pdf = requestSearchService.getCertificate(request.getId());
            byte[] encodedPdf = Base64.encodeBase64(pdf);
            getDocumentResponse.addDocumentBinary(encodedPdf);

            String message = translationService.translate("externalservice.trace.sent.summary");
            est.setMessage(message);
            est.setSubkey("summary");
        }

        externalService.addTrace(est);

        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);

        return getDocumentResponseDocument;
    }

    private void updateLastModificationInformation(Request request) {

        // update request's last modification date
        request.setLastModificationDate(new Date());
        request.setLastInterveningUserId(SecurityContext.getCurrentUserId());
        
        requestDAO.update(request);
    }

    private Request getById(final Long requestId) throws CvqObjectNotFoundException {
        return (Request) requestDAO.findById(Request.class, requestId);
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public void setRequestExternalService(IRequestExternalService requestExternalService) {
        this.requestExternalService = requestExternalService;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }
}
