package fr.cg95.cvq.bo.school;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.IRecreationCenterService;
import fr.cg95.cvq.service.school.IRecreationActivityRegistrationRequestService;

public class RecreationActivityPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IRecreationActivityRegistrationRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("RecreationActivity", BusinessManager.getReferentialList("RecreationActivity"));
        requestRecord.setList("recreationcenters", BusinessManager.getRecreationcenters());
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
        RecreationActivityRegistrationRequest registration = (RecreationActivityRegistrationRequest) request;
        RecreationActivityRegistrationRequestRecord record = (RecreationActivityRegistrationRequestRecord) requestRecord;

        IRecreationCenterService service = (IRecreationCenterService) BusinessManager.getAc().getBean(
                IRecreationCenterService.SERVICE_NAME);

        RecreationCenter recreationCenter = service.getByName(record.getRecreationCenterName());
        registration.setRecreationCenter(recreationCenter);
    }
    
    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
