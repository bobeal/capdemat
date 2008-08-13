package fr.cg95.cvq.service.civil.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.civil.DeathDetailsRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.civil.IDeathDetailsRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument;

/**
 * Implementation of the death details request service.
 * 
 * @author sanjay.goojrah@businessdecision.com
 */
public final class DeathDetailsRequestService extends RequestService 
    implements IDeathDetailsRequestService {
    
	static Logger logger = Logger.getLogger(DeathDetailsRequestService.class);

	public Long create(final Node pdrNode)
	    throws CvqException {

		DeathDetailsRequestDocument ddrDocument = null;
		try {
			ddrDocument = DeathDetailsRequestDocument.Factory.parse(pdrNode);
		} catch (XmlException xe) {
			logger.error("create() Error while parsing received date");
			xe.printStackTrace();
		}

		DeathDetailsRequest ddr = DeathDetailsRequest.xmlToModel(ddrDocument);
		HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(ddr);

		initializeCommonAttributes(ddr);

		Long requestId = super.create(ddr);
		if (homeFolder != null) {
			homeFolder.setBoundToRequest(Boolean.valueOf(true));
			homeFolder.setOriginRequestId(requestId);
		}

		return requestId;
	}

	public boolean accept(Request request) {
		return request instanceof DeathDetailsRequest;
	}

	public Request getSkeletonRequest() throws CvqException {
        return new DeathDetailsRequest();
    }
}
