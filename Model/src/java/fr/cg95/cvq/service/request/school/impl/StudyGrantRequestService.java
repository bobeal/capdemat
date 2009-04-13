package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
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
}
