package fr.cg95.cvq.bo.election;

import java.util.List;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.record.AdultRecord;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.election.IElectoralRollRegistrationRequestService;

public class ElectoralRollPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IElectoralRollRegistrationRequestService.SERVICE_NAME;
    }
    
    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("Nationality", (List)BusinessDictionary.getNationalities());
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
        ElectoralRollRegistrationRequestRecord record = (ElectoralRollRegistrationRequestRecord) requestRecord;
        
        IndividualRecord subject = record.getSubject();
        if (subject instanceof AdultRecord) {
            AdultRecord adult = (AdultRecord)subject;
            TitleType title = BusinessDictionary.getTitle(adult.getTitle());
            if (title.equals(TitleType.MISTER))
                record.setSubjectIndividualSex(BusinessDictionary.getSex(SexType.MALE));
            else if (title.equals(TitleType.MADAM) ||
                     title.equals(TitleType.MISS))
                record.setSubjectIndividualSex(BusinessDictionary.getSex(SexType.FEMALE));
             
        } else {
            record.setSubjectIndividualSex(subject.getSex());
        }
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
        ElectoralRollRegistrationRequest registration = (ElectoralRollRegistrationRequest) request;
        ElectoralRollRegistrationRequestRecord record = (ElectoralRollRegistrationRequestRecord) requestRecord;
        
        registration.setElectoralNumber(record.getElectoralNumber());
        registration.setPollingSchoolName(record.getPollingSchoolName());
        registration.setPollingStation(record.getPollingStation());
    }
    
    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
