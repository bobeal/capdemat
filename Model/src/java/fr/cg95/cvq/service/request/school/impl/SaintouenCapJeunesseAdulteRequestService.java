package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SaintouenCapJeunesseAdulteRequest;
import fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType;
import fr.cg95.cvq.business.request.school.ScjarSituationActuelleType;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class SaintouenCapJeunesseAdulteRequestService extends RequestService {

    @Override
    public void init() {
        SaintouenCapJeunesseAdulteRequest.conditions.put("situationActuelle",
                new EqualityListChecker(Arrays.asList("estEtudiant="+ScjarSituationActuelleType.ETUDIANT.name(),
                                                      "estSalarie="+ScjarSituationActuelleType.SALARIE.name())));
        SaintouenCapJeunesseAdulteRequest.conditions.put("participeActivite", new EqualityChecker("true"));
        SaintouenCapJeunesseAdulteRequest.conditions.put("etudiantTypeEtablissement", new EqualityChecker(ScjarEtudiantTypeEtablissementType.AUTRE.name()));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof SaintouenCapJeunesseAdulteRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SaintouenCapJeunesseAdulteRequest();
    }

}
