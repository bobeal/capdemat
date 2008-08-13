package fr.cg95.cvq.bo.cultural;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.AdultRecord;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.leisure.culture.LibraryRegistrationRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.leisure.culture.ILibraryRegistrationRequestService;

public class LibraryRegistrationPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ILibraryRegistrationRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("Subscription", BusinessManager.getReferentialList("Subscription"));
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
        LibraryRegistrationRequestRecord record = (LibraryRegistrationRequestRecord) requestRecord;
        
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
        LibraryRegistrationRequest registration = (LibraryRegistrationRequest) request;
        LibraryRegistrationRequestRecord record = (LibraryRegistrationRequestRecord) requestRecord;
        
        registration.setRegistrationNumber(record.getRegistrationNumber());
        registration.setSubscriptionPrice(record.getSubscriptionPrice());
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
