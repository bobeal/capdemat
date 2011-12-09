package fr.cg95.cvq.service.request.social.impl;

import java.math.BigDecimal;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.SagrActiviteAssociation;
import fr.cg95.cvq.business.request.social.SagrFederationSportiveType;
import fr.cg95.cvq.business.request.social.SagrRoleAssociationType;
import fr.cg95.cvq.business.request.social.SagrSportPratiqueType;
import fr.cg95.cvq.business.request.social.SportsAssociationsGrantRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class SportsAssociationsGrantRequestService extends RequestService {

    @Override
    public void init() {
        SportsAssociationsGrantRequest.conditions.put("estAdresseCorrespondantPrincipal", new EqualityChecker("false"));
        SportsAssociationsGrantRequest.conditions.put("roleDemandeur", new EqualityChecker(SagrRoleAssociationType.PRESIDENT.name()));
        SportsAssociationsGrantRequest.conditions.put("sagrActiviteAssociation.sportPratique", new EqualityChecker(SagrSportPratiqueType.AUTRE.name()));
        SportsAssociationsGrantRequest.conditions.put("sagrActiviteAssociation.federationSportive", new EqualityChecker(SagrFederationSportiveType.AUTRE.name()));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof SportsAssociationsGrantRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SportsAssociationsGrantRequest();
    }

    @Override
    public void onRequestIssued(Request request) {
        SportsAssociationsGrantRequest sagr = (SportsAssociationsGrantRequest) request;
        BigDecimal totalSubvention = BigDecimal.ZERO;
        for (SagrActiviteAssociation as : sagr.getSagrActiviteAssociation()) {
            as.setTotalLicencieActivite(as.getNombreLicencieMajeurActivite() + as.getNombreLicencieMineurActivite());
            totalSubvention = totalSubvention.add(as.getSommeSolliciteeActivite());
        }
        sagr.setSubventionSolliciteConseilGeneral(totalSubvention);
    }

}
