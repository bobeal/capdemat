package fr.cg95.cvq.service.school.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.school.SchoolCanteenRegistrationRequestDocument;

/**
 * Implementation of the school canteen registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SchoolCanteenRegistrationRequestService 
    extends RequestService implements ISchoolCanteenRegistrationRequestService {

    private static Logger logger = Logger.getLogger(SchoolCanteenRegistrationRequestService.class);

    protected ISchoolRegistrationRequestService schoolRegistrationRequestService;

    public Long create(final Request request, final Long requesterId)
        throws CvqException, CvqObjectNotFoundException {

        SchoolCanteenRegistrationRequest scrr = (SchoolCanteenRegistrationRequest) request;
        School school = scrr.getSchool();

        initializeCommonAttributes(scrr, requesterId);

        // FIXME : as long as connectivity with Horanet services is not up,
        // school canteen registrations can be done without having an
        // associated school
        if (school == null) {
            logger.warn("create() No school id provided");
            // throw new CvqException("No school provided !");
        } 

        return create(scrr);
    }

    public Long create(Node node) throws CvqException {

        SchoolCanteenRegistrationRequestDocument requestDocument = null;
        try {
            requestDocument = SchoolCanteenRegistrationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        SchoolCanteenRegistrationRequest request = 
            SchoolCanteenRegistrationRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        initializeCommonAttributes(request);

        if (request.getSchool() != null) {
            School school = (School) genericDAO.findById(School.class, request.getSchool().getId());
            request.setSchool(school);
        }
        
        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }
    
    public void validate(final Request request) 
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {
        
        if (!(request instanceof SchoolCanteenRegistrationRequest)) { 
            super.validate(request);
            return;
        }
        
        SchoolCanteenRegistrationRequest scrr = (SchoolCanteenRegistrationRequest) request;
        
        // ensure school information has been filled
        if (scrr.getSchool() == null) {
            logger.error("validate() registration has not been associated to a school !");
            throw new CvqModelException("request.school_canteen_registration.school_required");
        }
        
        super.validate(scrr, true); 
    }
    
    public boolean accept(final Request request) {
        return request instanceof SchoolCanteenRegistrationRequest;
    }

    public void setSchoolRegistrationRequestService(final ISchoolRegistrationRequestService schoolRegistrationRequestService) {
        this.schoolRegistrationRequestService = schoolRegistrationRequestService;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SchoolCanteenRegistrationRequest();
    }
}
