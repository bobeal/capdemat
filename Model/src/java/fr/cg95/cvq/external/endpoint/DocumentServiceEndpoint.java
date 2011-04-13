package fr.cg95.cvq.external.endpoint;

import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.GetDocumentResponseDocument.GetDocumentResponse;
import fr.capwebct.capdemat.GetDocumentRequestDocument.GetDocumentRequest;
import fr.capwebct.capdemat.GetDocumentRequestDocument;
import fr.capwebct.capdemat.GetDocumentResponseDocument;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.service.request.IRequestDocumentService;

public class DocumentServiceEndpoint extends SecuredServiceEndpoint {

    private IRequestDocumentService requestDocumentService;

    public static final String noPermissions = "Access denied! No permissions granted";
    public static final String notFound = "Request or document not found"; 

    public DocumentServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object request) throws Exception {

        GetDocumentRequest getDocumentRequest =
            ((GetDocumentRequestDocument)request).getGetDocumentRequest();

        try {

            GetDocumentResponseDocument getDocumentResponseDocument = 
                requestDocumentService.getAssociatedDocument(getDocumentRequest.getRequestId(), 
                    getDocumentRequest.isSetDocumentId() ? getDocumentRequest.getDocumentId() : null, 
                    getDocumentRequest.getMergeDocument());
            if (getDocumentResponseDocument != null) {
                return getDocumentResponseDocument.getGetDocumentResponse();
            } else {
                getDocumentResponseDocument =
                    GetDocumentResponseDocument.Factory.newInstance();
                GetDocumentResponse getDocumentResponse =
                    getDocumentResponseDocument.addNewGetDocumentResponse();
                  getDocumentResponse.setError(notFound);

                  return getDocumentResponse;
            }
        } catch (PermissionException pe) {
          GetDocumentResponseDocument getDocumentResponseDocument =
              GetDocumentResponseDocument.Factory.newInstance();
          GetDocumentResponse getDocumentResponse = 
              getDocumentResponseDocument.addNewGetDocumentResponse();
            getDocumentResponse.setError(noPermissions);

            return getDocumentResponse;
        }
    }

    public void setRequestDocumentService(IRequestDocumentService requestDocumentService) {
        this.requestDocumentService = requestDocumentService;
    }
}
