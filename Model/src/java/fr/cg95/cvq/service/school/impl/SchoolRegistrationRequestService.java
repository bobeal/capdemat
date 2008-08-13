package fr.cg95.cvq.service.school.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.authority.SectionType;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.school.SchoolRegistrationRequestDocument;


/**
 * Implementation of the school registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SchoolRegistrationRequestService
    extends RequestService implements ISchoolRegistrationRequestService {

    private static Logger logger = Logger.getLogger(SchoolRegistrationRequestService.class);

    public Long create(Node node) throws CvqException {

        SchoolRegistrationRequestDocument requestDocument = null;
        try {
            requestDocument = SchoolRegistrationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        SchoolRegistrationRequest request = 
            SchoolRegistrationRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        initializeCommonAttributes(request);

        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public void validate(final Long id)
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException {

        // check school association has been done before validating request
        SchoolRegistrationRequest srr = 
            (SchoolRegistrationRequest) requestDAO.findById(SchoolRegistrationRequest.class, id,
                    PrivilegeDescriptor.READ);
        if (srr.getSchool() == null)
            throw new CvqModelException("School registration is not associated to a school");
        if (srr.getSection().equals(SectionType.UNKNOWN))
            throw new CvqModelException("School registration is not associated to a school section");

        // validate the request
        super.validate(id);
    }

    public boolean accept(final Request request) {
        return request instanceof SchoolRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SchoolRegistrationRequest();
    }
}
