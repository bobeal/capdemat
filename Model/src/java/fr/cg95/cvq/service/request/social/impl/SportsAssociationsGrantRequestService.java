package fr.cg95.cvq.service.request.social.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.SagrActiviteAssociation;
import fr.cg95.cvq.business.request.social.SportsAssociationsGrantRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class SportsAssociationsGrantRequestService extends RequestService {

    @Override
    public void init() {
        SportsAssociationsGrantRequest.conditions.put("estAdresseCorrespondantPrincipal", new EqualityChecker("false"));
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
        for (SagrActiviteAssociation as : sagr.getActiviteAssociation()) {
            as.setTotalLicencieActivite(as.getNombreLicencieMajeurActivite() + as.getNombreLicencieMineurActivite());
        }
    }

}
