package fr.cg95.cvq.fo.urban;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.service.urbanism.ISewerConnectionRequestService;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.urbanism.ScrRequesterQualityType;
import fr.cg95.cvq.xml.urbanism.SewerConnectionRequestDocument;
import fr.cg95.cvq.xml.urbanism.SewerConnectionRequestDocument.SewerConnectionRequest;

public class SewerConnectionPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ISewerConnectionRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        SewerConnectionRequest scr = SewerConnectionRequest.Factory.newInstance();
        scr.setRequesterQuality(ScrRequesterQualityType.OWNER);

        // Owner address is not required, so not created by the system, we'll have to add it manualy
        scr.addNewOwnerAddress();
        
        return scr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {
        SewerConnectionRequestDocument.SewerConnectionRequest xmlRequest = (SewerConnectionRequestDocument.SewerConnectionRequest) xmlRequestData;

        SewerConnectionRequestDocument document = SewerConnectionRequestDocument.Factory.newInstance();
        document.setSewerConnectionRequest(xmlRequest);

        ISewerConnectionRequestService service = (ISewerConnectionRequestService) BusinessManager.getAc()
                .getBean(ISewerConnectionRequestService.SERVICE_NAME);

        return service.create(document.getDomNode());
    }

}
