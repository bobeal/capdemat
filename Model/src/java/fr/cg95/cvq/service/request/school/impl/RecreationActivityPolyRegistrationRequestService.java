package fr.cg95.cvq.service.request.school.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.RecreationActivityPolyRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class RecreationActivityPolyRegistrationRequestService extends RequestService {

    private static Logger logger = Logger.getLogger(RecreationActivityPolyRegistrationRequestService.class);
    @Override
    public void onRequestValidated(final Request request)
        throws CvqModelException {
        // check recreation center association has been done before validating request
        RecreationActivityPolyRegistrationRequest raprr = (RecreationActivityPolyRegistrationRequest) request;
        if(raprr.getRecreationPolyCenter() == null)
            throw new CvqModelException("rarr.property.recreationCenter.validationError");        
    }
    
    @Override
    public boolean accept(Request request) {
        return request instanceof RecreationActivityPolyRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        RecreationActivityPolyRegistrationRequest raprr = new  RecreationActivityPolyRegistrationRequest();
        if (SecurityContext.getCurrentEcitizen() != null)
            raprr.setUrgencyPolyPhone(SecurityContext.getCurrentEcitizen().getOfficePhone());
        return raprr;
    }

}
