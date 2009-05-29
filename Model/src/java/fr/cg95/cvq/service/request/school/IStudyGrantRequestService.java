package fr.cg95.cvq.service.request.school;

import java.util.List;

import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.service.request.IRequestService;

/**
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 */
public interface IStudyGrantRequestService extends IRequestService {

    public final String SERVICE_NAME = "studyGrantRequestService";

    /**
     * Get the requests that are sendable to the external service
     */
    public List<StudyGrantRequest> getSendableRequests(String externalServiceLabel);
}
