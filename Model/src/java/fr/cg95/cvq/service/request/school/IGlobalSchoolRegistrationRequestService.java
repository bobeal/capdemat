package fr.cg95.cvq.service.request.school;

import java.util.Map;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;

public interface IGlobalSchoolRegistrationRequestService extends IRequestService {

    public Map<String, Map<String, String>> getSchools(Long childId) throws CvqObjectNotFoundException;

}
