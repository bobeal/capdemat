package fr.cg95.cvq.service.request.school;

import java.util.Map;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;

public interface ILeisureCenterRegistrationRequestService extends IRequestService {

    public Map<String, String> getLeisureCenters(Long requestId, Long childId) throws CvqObjectNotFoundException;

    public Map<String, String> getLeisureCenterTransportLines(Long requestId, Long childId) throws CvqObjectNotFoundException;

    public Map<String, String> getLeisureCenterTransportStops(Long requestId, Long childId, String lineId) throws CvqObjectNotFoundException;

}