package fr.cg95.cvq.bo.civil;

import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.civil.MarriageDetailsRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.civil.IMarriageDetailsRequestService;

public class MarriageDetailsPersistence extends IPersistence {

	public String getServiceName(String definitionName) {
		return IMarriageDetailsRequestService.SERVICE_NAME;
	}

    public void initRequest(RequestRecord requestRecord) {
    }
    
	public void loadRequest(Request request, RequestRecord requestRecord) {
		MarriageDetailsRequest registration = (MarriageDetailsRequest) request;

		MarriageDetailsRequestRecord record = (MarriageDetailsRequestRecord) requestRecord;

		if ((registration.getFatherLastName() == null) || (registration.getFatherLastName().length() == 0))
			record.setRelationship("");
	}

	public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
	}

	public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
	}

}
