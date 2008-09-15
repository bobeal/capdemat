package fr.cg95.cvq.bo.military;

import org.apache.log4j.Logger;

import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.military.IMilitaryCensusRequestService;

public class MilitaryCensusPersistence extends IPersistence {

    static Logger logger = Logger.getLogger(MilitaryCensusPersistence.class);

    public MilitaryCensusPersistence() {
        super();
    }

    public String getServiceName(String definitionName) {
        return IMilitaryCensusRequestService.SERVICE_NAME;
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
