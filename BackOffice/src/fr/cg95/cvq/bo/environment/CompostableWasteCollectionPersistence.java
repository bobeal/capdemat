package fr.cg95.cvq.bo.environment;

import org.apache.log4j.Logger;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.environment.ICompostableWasteCollectionRequestService;

public class CompostableWasteCollectionPersistence extends IPersistence {

    static Logger logger = Logger.getLogger(CompostableWasteCollectionPersistence.class);
    
    public String getServiceName(String definitionName) {
        return ICompostableWasteCollectionRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        requestRecord.setList("CompostableWasteType", BusinessManager.getReferentialList("CompostableWasteType"));
    }
    
    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }
}
