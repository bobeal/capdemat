package fr.cg95.cvq.service.request.school.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IStudyGrantRequestService;

/**
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 *
 */
public class StudyGrantRequestService extends RequestService implements IStudyGrantRequestService {
    
    public boolean accept(Request request) {
        return request instanceof StudyGrantRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new StudyGrantRequest();
    }

    public Long create(Request request) throws CvqException {
        return super.create(request);
    }

    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("abroadInternship", new EqualityChecker("true"));
        filledConditions.put("currentStudies", new EqualityListChecker(Arrays.asList("otherStudies")));
    }

    public List<StudyGrantRequest> getSendableRequests(String externalServiceLabel) {
        Set<RequestState> set = new HashSet<RequestState>(1);
        set.add(RequestState.VALIDATED);
        List<Request> validatedRequests = requestDAO.listByStatesAndType(set, label);
        List<StudyGrantRequest> result = new ArrayList<StudyGrantRequest>();
        ExternalServiceTrace lastTrace;
        for (Request request : validatedRequests) {
            lastTrace = externalService.getLastTrace(request.getId(), externalServiceLabel);
            if (lastTrace == null || !lastTrace.getStatus().equals(TraceStatusEnum.ACKNOWLEDGED)) {
                result.add((StudyGrantRequest)request);
            }
        }
        return result;
    }
}
