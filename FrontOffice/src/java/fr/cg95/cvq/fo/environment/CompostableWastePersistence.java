package fr.cg95.cvq.fo.environment;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.service.environment.ICompostableWasteCollectionRequestService;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.environment.CompostableWasteCollectionRequestDocument;
import fr.cg95.cvq.xml.environment.CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest;

public class CompostableWastePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return ICompostableWasteCollectionRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        Collection compostableWaste = BusinessManager.getReferentialList("CompostableWasteType");
        request.getSession().setAttribute("compostablewaste", compostableWaste);

        request.getSession().setAttribute("requiredEmail",new Boolean(true));

        CompostableWasteCollectionRequest cwcr = CompostableWasteCollectionRequest.Factory.newInstance();
        
        return cwcr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {
        
        CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest xmlRequest =
            (CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest)xmlRequestData;
        
        CompostableWasteCollectionRequestDocument document = CompostableWasteCollectionRequestDocument.Factory.newInstance();
        
        document.setCompostableWasteCollectionRequest(xmlRequest);
        
        ICompostableWasteCollectionRequestService service = 
            (ICompostableWasteCollectionRequestService)BusinessManager.getAc().getBean(ICompostableWasteCollectionRequestService.SERVICE_NAME); 

        return service.create(document.getDomNode());
    }

}
