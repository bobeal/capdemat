package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SaintouenCapJeunesseEnfantRequest;
import fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class SaintouenCapJeunesseEnfantRequestService extends RequestService {

    @Override
    public void init() {
        SaintouenCapJeunesseEnfantRequest.conditions.put("typeEtablissementScolaireFrenquente",
                new EqualityListChecker(Arrays.asList("estEtablissementFrequenteCollege="+ScjerTypeEtablissementScolaireType.COLLEGE.name(),
                                                      "estEtablissementFrequenteLycee="+ScjerTypeEtablissementScolaireType.LYCEE.name(),
                                                      "estEtablissementFrequenteAutre="+ScjerTypeEtablissementScolaireType.AUTRE.name())));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof SaintouenCapJeunesseEnfantRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SaintouenCapJeunesseEnfantRequest();
    }

}
