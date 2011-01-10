package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.HomeEmergencyRegistrationRequest;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 *
 * @author vsi@zenexity.fr
 */
public final class HomeEmergencyRegistrationRequestService extends RequestService {

    @Override
    public boolean accept(final Request request) {
        return request instanceof HomeEmergencyRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        HomeEmergencyRegistrationRequest herr = new HomeEmergencyRegistrationRequest();
        if (SecurityContext.getCurrentEcitizen() != null) {
            if (SecurityContext.getCurrentEcitizen().getMobilePhone() != null)
                herr.setTelephone(SecurityContext.getCurrentEcitizen().getMobilePhone());
            else if (SecurityContext.getCurrentEcitizen().getHomePhone() != null)
                herr.setTelephone(SecurityContext.getCurrentEcitizen().getHomePhone());
            else
                herr.setTelephone(SecurityContext.getCurrentEcitizen().getOfficePhone());
        }
        return herr;
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {}
}
