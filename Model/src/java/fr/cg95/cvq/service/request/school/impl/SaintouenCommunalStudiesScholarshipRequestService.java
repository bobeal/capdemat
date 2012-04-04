package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType;
import fr.cg95.cvq.business.request.school.SaintouenCommunalStudiesScholarshipRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType;

public class SaintouenCommunalStudiesScholarshipRequestService extends RequestService {

    @Override
    public void init(){
        SaintouenCommunalStudiesScholarshipRequest.conditions.put("isSubjectAccountHolder", new EqualityChecker("true"));
        SaintouenCommunalStudiesScholarshipRequest.conditions.put("isOtherSituation", new EqualityChecker(SaintOuenSituationLogementType.OTHER_SITUATION.name()));
        SaintouenCommunalStudiesScholarshipRequest.conditions.put("saintOuenIsInOtherStudies", new EqualityChecker(SaintOuenCurrentStudiesType.OTHER_STUDIES.name()));
    }
    @Override
    public boolean accept(Request request) {
        // TODO Auto-generated method stub
        return request instanceof SaintouenCommunalStudiesScholarshipRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        // TODO Auto-generated method stub
        return new SaintouenCommunalStudiesScholarshipRequest();
    }
    
}