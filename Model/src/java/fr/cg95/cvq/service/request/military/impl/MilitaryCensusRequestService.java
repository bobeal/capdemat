package fr.cg95.cvq.service.request.military.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.military.MilitaryCensusRequest;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.military.IMilitaryCensusRequestService;
import fr.cg95.cvq.xml.request.military.MilitaryCensusRequestDocument;

public class MilitaryCensusRequestService extends RequestService 
        implements IMilitaryCensusRequestService {

    private static Logger logger = Logger.getLogger(MilitaryCensusRequestService.class);
    
    public boolean accept(Request request) {
        return (request instanceof MilitaryCensusRequest);
    }

    public Long create(Node node) throws CvqException {

        MilitaryCensusRequestDocument mcrDocument = null;
        try {
            mcrDocument = MilitaryCensusRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }
        
        MilitaryCensusRequest mcr = MilitaryCensusRequest.xmlToModel(mcrDocument);

        // TODO REFACTORING
        
        // subject may have changed during this request (birth-related informations)
//        Child subject = (Child) mcr.getSubject();
//        Child child = (Child) genericDAO.findById(Child.class, subject.getId());
//        child.setBirthCity(subject.getBirthCity());
//        child.setBirthPostalCode(subject.getBirthPostalCode());
        
        // TODO : migrate to new address scheme
        
//        child.getAdress().setAdress(subject.getAdress().getAdress());
//        child.getAdress().setCity(subject.getAdress().getCity());
//        child.getAdress().setPostalCode(subject.getAdress().getPostalCode());
//        genericDAO.update(child);
        
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(mcr);
        
        initializeCommonAttributes(mcr);

        Long requestId = super.create(mcr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
    
        return requestId;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new MilitaryCensusRequest();
    }
}
