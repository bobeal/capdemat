package fr.cg95.cvq.bo.technical;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.technical.ITechnicalInterventionRequestService;

public class TechnicalInterventionPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ITechnicalInterventionRequestService.SERVICE_NAME;
    }
    
    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("InterventionType", BusinessManager.getReferentialList("InterventionType"));
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
