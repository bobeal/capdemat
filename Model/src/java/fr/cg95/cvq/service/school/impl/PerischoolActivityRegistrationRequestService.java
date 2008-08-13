package fr.cg95.cvq.service.school.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.school.IPerischoolActivityRegistrationRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.school.PerischoolActivityRegistrationRequestDocument;

/**
 * Implementation of the perischool activity registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class PerischoolActivityRegistrationRequestService
    extends RequestService implements IPerischoolActivityRegistrationRequestService {

    private static Logger logger =
        Logger.getLogger(PerischoolActivityRegistrationRequestService.class);

    public Long create(Node node) throws CvqException {

        PerischoolActivityRegistrationRequestDocument requestDocument = null;
        try {
            requestDocument = PerischoolActivityRegistrationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        PerischoolActivityRegistrationRequest request = 
            PerischoolActivityRegistrationRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        initializeCommonAttributes(request);

        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public void validate(final Request request) 
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {
    
        if (!(request instanceof PerischoolActivityRegistrationRequest)) { 
            super.validate(request);
            return;
        }
    
        PerischoolActivityRegistrationRequest parr = (PerischoolActivityRegistrationRequest) request;
    
        // ensure school information has been filled
        if (parr.getSchool() == null) {
            logger.error("validate() registration has not been associated to a school !");
            throw new CvqModelException("request.perischool_activity_registration.school_required");
        }
    
        super.validate(parr, true); 
    }

   public boolean accept(final Request request) {
        return request instanceof PerischoolActivityRegistrationRequest;
    }

    public String getConsumptionsField()
        throws CvqException {
        return "PerischoolActivity";
    }

    public Request getSkeletonRequest() throws CvqException {
        return new PerischoolActivityRegistrationRequest();
    }
}
