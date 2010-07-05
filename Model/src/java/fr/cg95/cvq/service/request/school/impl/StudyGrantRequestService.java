package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IStudyGrantRequestService;

/**
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 *
 */
public class StudyGrantRequestService extends RequestService implements IStudyGrantRequestService {

    private IRequestDAO requestDAO;

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
    
    public void setEdemandeId(Long requestId, String edemandeId)
        throws CvqException {
        StudyGrantRequest request = 
            (StudyGrantRequest) requestDAO.findById(Request.class, requestId);
        request.setEdemandeId(edemandeId);
    }

    public void setAccountHolderEdemandeId(@IsRequest final Long requestId, final String accountHolderEdemandeId)
        throws CvqException {
        StudyGrantRequest request = 
            (StudyGrantRequest) requestDAO.findById(Request.class, requestId);
        request.setAccountHolderEdemandeId(accountHolderEdemandeId);
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }
}
