package fr.cg95.cvq.service.request.school;

import java.util.Map;

import fr.cg95.cvq.service.request.IRequestService;

public interface ISchoolTransportRegistrationRequestService extends IRequestService {

    public Map<String, String> transportLines(String childId);

    public Map<String, String> stops(String childId, String lineId);
}
