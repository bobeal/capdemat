package fr.cg95.cvq.bo.school;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;

public class SchoolRegistrationPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ISchoolRegistrationRequestService.SERVICE_NAME;
    }

    public String[] getRequestReportFields() {
        return new String[] {"schoolName", "section"};
    }

    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("schools", BusinessManager.getSchools());
    }

    public void loadRequest(Request demand, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
        SchoolRegistrationRequest registration = (SchoolRegistrationRequest) request;
        SchoolRegistrationRequestRecord record = (SchoolRegistrationRequestRecord) requestRecord;

        registration.setSchool(BusinessManager.getSchool(record.getSchoolName()));
        registration.setSection(BusinessDictionary.getSection(record.getSection()));

        // Check the current section has a value set
        if (registration.getCurrentSection() == null)
            registration.setCurrentSection(BusinessDictionary.getSection(record.getCurrentSection()));

    }
    
    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
