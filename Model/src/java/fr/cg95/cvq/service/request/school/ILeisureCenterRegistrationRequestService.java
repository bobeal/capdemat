package fr.cg95.cvq.service.request.school;

import java.util.Map;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;

public interface ILeisureCenterRegistrationRequestService extends IRequestService {

    public Map<String, String> getLeisureCenters(Long childId) throws CvqObjectNotFoundException;

    public Map<String, String> getTransportLines(Long childId) throws CvqObjectNotFoundException;

    public Map<String, String> getTransportStops(Long childId, String lineId) throws CvqObjectNotFoundException;

}