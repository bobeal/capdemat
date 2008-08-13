package fr.cg95.cvq.bo.leisure;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.leisure.ISmsNotificationRequestService;

public class SmsNotificationPersistence extends IPersistence {

    public SmsNotificationPersistence() {
        super();
    }

    public String getServiceName(String definitionName) {
        return ISmsNotificationRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("Interests",BusinessManager.getReferentialList("Interests"));
    }
    
    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }
    
//    public void saveRequest(RequestRecord requestRecord) throws CvqException {
//        if (BusinessManager.getAc() != null) {
//            ISmsNotificationRequestService service = (ISmsNotificationRequestService) BusinessManager
//                    .getAc().getBean(ISmsNotificationRequestService.SERVICE_NAME);
//
//            try {
//                SmsNotificationRequest registration = (SmsNotificationRequest) service
//                        .getById(requestRecord.getId());
//
//                SmsNotificationRequestRecord record = (SmsNotificationRequestRecord) requestRecord;
//                Adult subject = (Adult) registration.getSubject();
//                subject.setMobilePhone(record.getSubjectAdultMobilePhone());
//
//                service.modify(registration);
//
//            } catch (CvqObjectNotFoundException e) {
//                throw e;
//            } catch (CvqException e) {
//                throw e;
//            }
//        }
//    }
    
}
