package fr.cg95.cvq.exporter.service.endpoint;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.DocumentType;
import fr.capwebct.capdemat.GetDocumentListRequestDocument;
import fr.capwebct.capdemat.GetDocumentListResponseDocument;
import fr.capwebct.capdemat.GetDocumentListRequestDocument.GetDocumentListRequest;
import fr.capwebct.capdemat.GetDocumentListResponseDocument.GetDocumentListResponse;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestDocument;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestExternalService;
import fr.cg95.cvq.service.request.IRequestSearchService;

public class DocumentListServiceEndpoint extends SecuredServiceEndpoint {

    private IRequestSearchService requestSearchService;
    private IDocumentService documentService;
    private IRequestExternalService requestExternalService;
    
    private final String noPermissions = "Access denied! No permissions granted"; 
    
    public DocumentListServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object request) throws Exception {
       
        GetDocumentListResponseDocument getDocumentListResponseDocument =
            GetDocumentListResponseDocument.Factory.newInstance();
        
        GetDocumentListResponse getDocumentListResponse = 
            getDocumentListResponseDocument.addNewGetDocumentListResponse();
        
        Collection<String> authorizedRequestTypesLabels =
            requestExternalService.getRequestTypesForExternalService(SecurityContext.getCurrentExternalService());
        
        
        // Switch to admin context to be able to call services without permission exceptions
        String currentExternalService = SecurityContext.getCurrentExternalService();
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
      
        GetDocumentListRequest getDocumentListRequest =
            ((GetDocumentListRequestDocument)request).getGetDocumentListRequest();
        
        try {
            Request requestToReturn = 
                requestSearchService.getById(getDocumentListRequest.getRequestId(), false);

            // Check external service permissions wrt configured request types labels
            String requestTypeLabel = requestToReturn.getRequestType().getLabel();
            if (requestTypeLabel == null || authorizedRequestTypesLabels == null || 
                    !authorizedRequestTypesLabels.contains(requestTypeLabel)) {
                getDocumentListResponse.setError(noPermissions);
                return getDocumentListResponse;
            }
            
            // Check if the request contains documents
            if (requestToReturn.getDocuments().isEmpty()) {
                return getDocumentListResponse;
            }
            
            for (RequestDocument rd : requestToReturn.getDocuments()) {
                Document doc = documentService.getById(rd.getDocumentId());
                DocumentType documentType = getDocumentListResponse.addNewDocument();
                documentType.setDocumentId(doc.getId());
                documentType.setType(doc.getDocumentType().getName());
                documentType.setState(doc.getState().toString());
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(doc.getEndValidityDate());
                documentType.setEndValidityDate(calendar);
                if (doc.getValidationDate() != null) {
                    calendar.setTime(doc.getValidationDate());
                    documentType.setValidationDate(calendar);
                }
            }
            
        } catch (PermissionException pe) {
            getDocumentListResponse.setError(noPermissions);
            return getDocumentListResponse;
        }
        
        // Reset to original context
        SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentExternalService(currentExternalService);
        
        return getDocumentListResponse;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }
    
    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }
    
    public void setRequestExternalService(IRequestExternalService requestExternalService) {
        this.requestExternalService = requestExternalService;
    }
}
