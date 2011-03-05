package fr.cg95.cvq.external.endpoint;

import org.springframework.oxm.Marshaller;

import fr.capwebct.capdemat.GetDocumentListRequestDocument;
import fr.capwebct.capdemat.GetDocumentListResponseDocument;
import fr.capwebct.capdemat.GetDocumentListRequestDocument.GetDocumentListRequest;
import fr.capwebct.capdemat.GetDocumentListResponseDocument.GetDocumentListResponse;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.service.request.IRequestDocumentService;

public class DocumentListServiceEndpoint extends SecuredServiceEndpoint {

    private IRequestDocumentService requestDocumentService;

    private final String noPermissions = "Access denied! No permissions granted";
    private final String notFound = "Request not found";

    public DocumentListServiceEndpoint(Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected Object invokeInternal(Object request) throws Exception {

        GetDocumentListRequest getDocumentListRequest =
            ((GetDocumentListRequestDocument)request).getGetDocumentListRequest();

        try {
            GetDocumentListResponseDocument getDocumentListResponseDocument = 
                requestDocumentService.getAssociatedFullDocuments(getDocumentListRequest.getRequestId());

            return getDocumentListResponseDocument.getGetDocumentListResponse();

        } catch (CvqObjectNotFoundException confe) {
            GetDocumentListResponseDocument getDocumentListResponseDocument =
                GetDocumentListResponseDocument.Factory.newInstance();
            GetDocumentListResponse getDocumentListResponse =
                getDocumentListResponseDocument.addNewGetDocumentListResponse();
              getDocumentListResponse.setError(notFound);

              return getDocumentListResponse;
        } catch (PermissionException pe) {
          GetDocumentListResponseDocument getDocumentListResponseDocument =
              GetDocumentListResponseDocument.Factory.newInstance();
          GetDocumentListResponse getDocumentListResponse =
              getDocumentListResponseDocument.addNewGetDocumentListResponse();
            getDocumentListResponse.setError(noPermissions);

            return getDocumentListResponse;
        }
    }

    public void setRequestDocumentService(IRequestDocumentService requestDocumentService) {
        this.requestDocumentService = requestDocumentService;
    }
}
