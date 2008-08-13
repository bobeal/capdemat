package fr.cg95.cvq.bo.social;

import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.social.IHandicapAllowanceRequestService;

public class HandicapAllowancePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IHandicapAllowanceRequestService.SERVICE_NAME;
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
