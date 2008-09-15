package fr.cg95.cvq.bo.school;

import java.util.Set;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;

public class SchoolCanteenPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ISchoolCanteenRegistrationRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("FoodDiet", BusinessManager.getReferentialList("FoodDiet"));
        requestRecord.setList("CanteenAttendingDays", BusinessManager.getReferentialList("CanteenAttendingDays"));
        requestRecord.setList("schools", BusinessManager.getSchools());
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
        SchoolCanteenRegistrationRequestRecord record = (SchoolCanteenRegistrationRequestRecord) requestRecord;

        HomeFolder family = request.getRequester().getHomeFolder();
        SchoolRegistrationRequest schoolRegistration = 
            getSchoolRequestForChild(family, record.getSubject().getId());
        if (schoolRegistration != null) {
            if (schoolRegistration.getSchool() != null) {
                record.setSchoolName(schoolRegistration.getSchool().getName());
                record.setSection(BusinessDictionary.getSection(schoolRegistration.getSection()));
            } else {
                record.setSchoolName(schoolRegistration.getCurrentSchoolName());
                record.setSection(BusinessDictionary.getSection(schoolRegistration.getSection()));
            }
        }
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
        SchoolCanteenRegistrationRequest registration = (SchoolCanteenRegistrationRequest) request;
        SchoolCanteenRegistrationRequestRecord record = (SchoolCanteenRegistrationRequestRecord) requestRecord;

        registration.setSchool(BusinessManager.getSchool(record.getSchoolName()));
        registration.setSection(BusinessDictionary.getSection(record.getSection()));
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

    private static SchoolRegistrationRequest getSchoolRequestForChild(HomeFolder family, Long childId) {
        ISchoolRegistrationRequestService schoolService =
            (ISchoolRegistrationRequestService) BusinessManager.getAc()
                .getBean(ISchoolRegistrationRequestService.SERVICE_NAME);
        Set childSchoolRequest;
        try {
            childSchoolRequest = schoolService.getBySubjectIdAndRequestLabel(childId, schoolService.getLabel(), false);
        } catch (CvqObjectNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (CvqException e) {
            e.printStackTrace();
            return null;
        }
        if (childSchoolRequest != null && !childSchoolRequest.isEmpty())
            return (SchoolRegistrationRequest) childSchoolRequest.iterator().next();

        return null;
    }

}
