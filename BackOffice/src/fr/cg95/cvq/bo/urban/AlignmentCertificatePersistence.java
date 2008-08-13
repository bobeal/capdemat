package fr.cg95.cvq.bo.urban;

import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.urbanism.IAlignmentCertificateRequestService;

public class AlignmentCertificatePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IAlignmentCertificateRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
    }
    
    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }
    
}
