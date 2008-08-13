package fr.cg95.cvq.service.urbanism.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.urbanism.AlignmentCertificateRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.urbanism.IAlignmentCertificateRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument;

/**
 * Implementation of the alignment certificate request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class AlignmentCertificateRequestService
    extends RequestService implements IAlignmentCertificateRequestService {

    static Logger logger = Logger.getLogger(AlignmentCertificateRequestService.class);

    public Long create(final Node acrNode) throws CvqException {

    	AlignmentCertificateRequestDocument acrDocument = null;
		try {
			acrDocument = AlignmentCertificateRequestDocument.Factory.parse(acrNode);
		} catch (XmlException xe) {
			logger.error("create() Error while parsing received data");
			xe.printStackTrace();
		}

		AlignmentCertificateRequest acr = AlignmentCertificateRequest.xmlToModel(acrDocument);
		HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(acr);

		initializeCommonAttributes(acr);

        Long requestId = super.create(acr);
        if (homeFolder != null) {
        	homeFolder.setBoundToRequest(Boolean.valueOf(true));
        	homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
	}

    public boolean accept(Request request) {
        return request instanceof AlignmentCertificateRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new AlignmentCertificateRequest();
    }
}
