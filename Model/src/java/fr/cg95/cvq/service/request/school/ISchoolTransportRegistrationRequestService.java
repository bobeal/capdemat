package fr.cg95.cvq.service.request.school;

import java.util.Map;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;

public interface ISchoolTransportRegistrationRequestService extends IRequestService {

    public Map<String, String> transportLines(Long childId) throws CvqObjectNotFoundException;

    public Map<String, String> stops(Long childId, String lineId) throws CvqObjectNotFoundException;
}
