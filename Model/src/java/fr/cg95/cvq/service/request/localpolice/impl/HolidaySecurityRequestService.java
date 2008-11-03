package fr.cg95.cvq.service.request.localpolice.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.localpolice.HolidaySecurityRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.localpolice.IHolidaySecurityRequestService;
import fr.cg95.cvq.xml.request.localpolice.HolidaySecurityRequestDocument;

public class HolidaySecurityRequestService extends RequestService implements
        IHolidaySecurityRequestService {

    static Logger logger = Logger.getLogger(HolidaySecurityRequestService.class);

    public boolean accept(Request request) {
        return request instanceof HolidaySecurityRequest;
    }

    public Long create(Node node) throws CvqException {

        HolidaySecurityRequestDocument rd = null;
        try {
            rd = HolidaySecurityRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        HolidaySecurityRequest hsr = HolidaySecurityRequest.xmlToModel(rd);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(hsr);

        Adult adult = (Adult)hsr.getSubject();

        initializeCommonAttributes(hsr);

        Adult adult2 = (Adult)hsr.getSubject();
        adult2.setMobilePhone(adult.getMobilePhone());
        adult2.setEmail(adult.getEmail());

        Long requestId = super.create(hsr);
        if(homeFolder != null){
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }

        return requestId;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new HolidaySecurityRequest();
    }

}
