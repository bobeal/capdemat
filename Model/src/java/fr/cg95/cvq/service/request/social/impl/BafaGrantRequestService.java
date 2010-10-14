package fr.cg95.cvq.service.request.social.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.BafaGrantRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 *
 */
public class BafaGrantRequestService extends RequestService {

    @Override
    public void init() {
        BafaGrantRequest.conditions.put("isSubjectAccountHolder", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof BafaGrantRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new BafaGrantRequest();
    }

    @Override
    public void onRequestValidated(Request request) throws CvqException {
        BafaGrantRequest bgr = (BafaGrantRequest) request;
        Individual subject = (Individual) genericDAO.findById(Individual.class, bgr.getSubjectId());
        subject.setAdress(bgr.getSubjectAddress());
        subject.setBirthCity(bgr.getSubjectBirthCity());
        subject.setBirthDate(bgr.getSubjectBirthDate());
        if (subject instanceof Adult) {
            ((Adult)subject).setEmail(bgr.getSubjectEmail());
        }
    }
}
