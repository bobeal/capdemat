package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestEvent;
import fr.cg95.cvq.business.request.RequestEvent.EVENT_TYPE;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 *
 */
public class StudyGrantRequestService extends RequestService {

    @Override
    public void init() {
        StudyGrantRequest.conditions.put("abroadInternship", new EqualityChecker("true"));
        StudyGrantRequest.conditions.put("currentStudiesDiploma",
            new EqualityChecker("otherStudies"));
        StudyGrantRequest.conditions.put("taxHouseholdCity", new EqualityChecker("573"));
        StudyGrantRequest.conditions.put("currentSchoolName", new EqualityChecker("autre"));
        StudyGrantRequest.conditions.put("isSubjectAccountHolder", new EqualityChecker("true"));
    }

    public boolean accept(Request request) {
        return request instanceof StudyGrantRequest;
    }

    public Request getSkeletonRequest() {
        return new StudyGrantRequest();
    }

    @Override
    public void onRequestValidated(Request request) throws CvqException {
        StudyGrantRequest sgr = (StudyGrantRequest) request;
        Individual subject = (Individual) genericDAO.findById(Individual.class, sgr.getSubjectId());
        subject.setBirthDate(sgr.getSubjectBirthDate());
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {
        if (e instanceof RequestEvent) {
            RequestEvent event = (RequestEvent)e;
            if (EVENT_TYPE.REQUEST_CLONED.equals(event.getEvent()) && accept(event.getRequest())) {
                StudyGrantRequest request = (StudyGrantRequest) event.getRequest();
                request.setAccountHolderEdemandeId(null);
                request.setEdemandeId(null);
            }
        }
    }
}
