package fr.cg95.cvq.service.request.school;

import java.util.Map;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;

public interface IHolidayCampRegistrationRequestService extends IRequestService {

    public Map<String, String> getHolidayCamps(Long childId) throws CvqObjectNotFoundException;

}
