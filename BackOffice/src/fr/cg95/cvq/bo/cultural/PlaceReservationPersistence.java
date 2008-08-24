package fr.cg95.cvq.bo.cultural;

import java.util.ArrayList;
import java.util.Set;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.reservation.IPlaceReservationRequestService;

public class PlaceReservationPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IPlaceReservationRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
        Set referentialData = BusinessManager.getReservationData(requestRecord.getRequestType(), true);
        requestRecord.setList("Place Reservation", new ArrayList(referentialData));
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
    }

}
