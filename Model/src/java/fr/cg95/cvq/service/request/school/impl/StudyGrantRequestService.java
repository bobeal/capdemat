package fr.cg95.cvq.service.request.school.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IStudyGrantRequestService;

/**
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 *
 */
public class StudyGrantRequestService extends RequestService implements IStudyGrantRequestService {

    public final Map<String,IConditionChecker> filledConditions = new HashMap<String,IConditionChecker>();

    public boolean accept(Request request) {
        return request instanceof StudyGrantRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new StudyGrantRequest();
    }

    public Long create(Request request) throws CvqException {
        return super.create(request);
    }

    private void initFilledConditions() {
        filledConditions.put("hasParentsAddress", new EqualityChecker("true"));
        filledConditions.put("hasOtherHelp", new EqualityChecker("true"));
        filledConditions.put("isInLastYear", new EqualityChecker("false"));
        filledConditions.put("currentStudies", new EqualityChecker("sandwichCourses"));
        filledConditions.put("futureSchoolIsAbroad", new EqualityChecker("true"));
    }

    /**
     * TODO - move to abstract RequestService
     */
    public boolean isConditionFilled (Map<String, String> triggers) {
        initFilledConditions();
        boolean test = true;
        for (Entry<String, String> trigger : triggers.entrySet()) {
            if (filledConditions.get(trigger.getKey()) != null 
                && filledConditions.get(trigger.getKey()).test(trigger.getValue()))
                test = test && true;
            else
                return false;
        }
        return test;
    }

}
