package fr.cg95.cvq.bo.leisure;

import java.util.ArrayList;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.leisure.music.IMusicSchoolRegistrationRequestService;

public class MusicSchoolPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IMusicSchoolRegistrationRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        LocalReferentialType referentialData = BusinessManager.getReferentialData("Activity");
        requestRecord.setList("Activity", new ArrayList(referentialData.getEntries()));
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
