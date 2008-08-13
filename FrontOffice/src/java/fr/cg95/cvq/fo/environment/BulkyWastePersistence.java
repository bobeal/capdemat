package fr.cg95.cvq.fo.environment;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.service.environment.IBulkyWasteCollectionRequestService;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.environment.BulkyWasteCollectionRequestDocument;
import fr.cg95.cvq.xml.environment.BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest;

public class BulkyWastePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IBulkyWasteCollectionRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        Collection bulkyWaste = BusinessManager.getReferentialList("BulkyWasteType");
        request.getSession().setAttribute("bulkywaste", bulkyWaste);

        request.getSession().setAttribute("requiredEmail",new Boolean(true));

        BulkyWasteCollectionRequest bwcr = BulkyWasteCollectionRequest.Factory.newInstance();
        
        return bwcr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {
        
        BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest xmlRequest =
            (BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest)xmlRequestData;
        
        BulkyWasteCollectionRequestDocument document = BulkyWasteCollectionRequestDocument.Factory.newInstance();
        
        document.setBulkyWasteCollectionRequest(xmlRequest);
        
        IBulkyWasteCollectionRequestService service = 
            (IBulkyWasteCollectionRequestService)BusinessManager.getAc().getBean(IBulkyWasteCollectionRequestService.SERVICE_NAME); 

        return service.create(document.getDomNode());
    }

}
