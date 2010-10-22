package fr.cg95.cvq.exporter.service.endpoint;

import java.util.Collection;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.GetDocumentResponseDocument.GetDocumentResponse;
import fr.capwebct.capdemat.GetDocumentRequestDocument.GetDocumentRequest;
import fr.capwebct.capdemat.GetDocumentRequestDocument;
import fr.capwebct.capdemat.GetDocumentResponseDocument;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestExternalService;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.util.translation.ITranslationService;


public class DocumentServiceEndpoint extends SecuredServiceEndpoint {
    
    private static Logger logger = Logger.getLogger(RequestServiceEndpoint.class);
    
    private IDocumentService documentService;
    private IRequestSearchService requestSearchService;
    private IRequestExternalService requestExternalService;
    private IExternalService externalService;
    private ITranslationService translationService;

    private final String noPermissions = "Access denied! No permissions granted";
    
    public DocumentServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object request) throws Exception {
       
        GetDocumentResponseDocument getDocumentResponseDocument =
            GetDocumentResponseDocument.Factory.newInstance();
        
        GetDocumentResponse getDocumentResponse = 
            getDocumentResponseDocument.addNewGetDocumentResponse();
 
        Collection<String> authorizedRequestTypesLabels =
            requestExternalService.getRequestTypesForExternalService(SecurityContext.getCurrentExternalService());
        
        // Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
      
        GetDocumentRequest getDocumentRequest =
            ((GetDocumentRequestDocument)request).getGetDocumentRequest();
        try {
            Request requestDoc = requestSearchService.getById(getDocumentRequest.getRequestId(), false);
            // Check external service permissions wrt configured request types labels            
            String requestTypeLabel = requestDoc.getRequestType().getLabel();
            if (requestTypeLabel == null || authorizedRequestTypesLabels == null || 
                    !authorizedRequestTypesLabels.contains(requestTypeLabel)) {
                getDocumentResponse.setError(noPermissions);
                return getDocumentResponse;
            }
            // case : we want a specific document
            if (getDocumentRequest.isSetDocumentId()) {
                Document document = documentService.getById(getDocumentRequest.getDocumentId());
                
                // Check if the document contains pages
                if (document.getDatas().isEmpty()) {
                    return getDocumentResponse;
                }
                
    
                if (getDocumentRequest.getMergeDocument()) {
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
                
                String message = 
                    translationService.translate("externalservice.trace.sent.document", 
                            new Object[] {
                            document.getId()}
                    );
                
                ExternalServiceTrace trace = new ExternalServiceTrace();
                trace.setKeyOwner("capdemat");
                trace.setSubkey("document");
                trace.setMessage(message);
                trace.setKey(String.valueOf(requestDoc.getId()));
                trace.setStatus(TraceStatusEnum.SENT);
                
                externalService.addTrace(trace);
            }
            
            // case : we want the pdf
            if (getDocumentRequest.getPdfSummary()) {
                byte[] pdf = requestSearchService.getCertificate(requestDoc.getId());
                byte[] encodedPdf = Base64.encodeBase64(pdf);
                getDocumentResponse.addDocumentBinary(encodedPdf);
                
                String message = translationService.translate("externalservice.trace.sent.summary");
                
                ExternalServiceTrace trace = new ExternalServiceTrace();
                trace.setKeyOwner("capdemat");
                trace.setSubkey("summary");
                trace.setMessage(message);
                trace.setKey(String.valueOf(requestDoc.getId()));
                trace.setStatus(TraceStatusEnum.SENT);
                
                externalService.addTrace(trace);
            }
        } catch (PermissionException pe) {
            getDocumentResponse.setError(noPermissions);
            return getDocumentResponse;
        }
        
        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);
        
        return getDocumentResponse;
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
