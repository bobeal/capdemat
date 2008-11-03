package fr.cg95.cvq.service.request.leisure.music.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.music.IMusicSchoolRegistrationRequestService;
import fr.cg95.cvq.xml.request.leisure.music.MusicSchoolRegistrationRequestDocument;

/**
 * Implementation of the music school registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class MusicSchoolRegistrationRequestService
    extends RequestService implements IMusicSchoolRegistrationRequestService {

    static Logger logger = Logger.getLogger(MusicSchoolRegistrationRequestService.class);

    public Long create(final Node node) throws CvqException {
        
        MusicSchoolRegistrationRequestDocument msrrDocument = null;
        try {
            msrrDocument = MusicSchoolRegistrationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        MusicSchoolRegistrationRequest msrr = 
            MusicSchoolRegistrationRequest.xmlToModel(msrrDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(msrr);

        initializeCommonAttributes(msrr);
        
        Long requestId = super.create(msrr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }

        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof MusicSchoolRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new MusicSchoolRegistrationRequest();
    }
}
