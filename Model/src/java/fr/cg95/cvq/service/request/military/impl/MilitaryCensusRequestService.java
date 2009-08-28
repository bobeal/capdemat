package fr.cg95.cvq.service.request.military.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.military.MilitaryCensusRequest;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.military.IMilitaryCensusRequestService;

public class MilitaryCensusRequestService extends RequestService 
        implements IMilitaryCensusRequestService {

    @Override
    public Long create(Request request)
        throws CvqException, CvqObjectNotFoundException {

        // subject may have changed during this request (birth-related informations)
        Long subjectId = request.getSubjectId();
        Child child = individualService.getChildById(subjectId);
        
        // TODO XSD MIGRATION
//        child.setBirthCity(subject.getBirthCity());
//        child.setBirthPostalCode(subject.getBirthPostalCode());

        performBusinessChecks(request, SecurityContext.getCurrentEcitizen(), null);

        // TODO : migrate to new address scheme
        
//      child.getAdress().setAdress(subject.getAdress().getAdress());
//      child.getAdress().setCity(subject.getAdress().getCity());
//      child.getAdress().setPostalCode(subject.getAdress().getPostalCode());
//      genericDAO.update(child);

        return finalizeAndPersist(request);
    }

    @Override
    public boolean accept(Request request) {
        return (request instanceof MilitaryCensusRequest);
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new MilitaryCensusRequest();
    }

    @Override
    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("prefectPupil", new EqualityChecker("true"));
    }
}
