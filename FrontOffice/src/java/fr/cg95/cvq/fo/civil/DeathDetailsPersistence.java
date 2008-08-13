package fr.cg95.cvq.fo.civil;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.civil.IDeathDetailsRequestService;
import fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument;
import fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest;
import fr.cg95.cvq.xml.common.RequestType;

public class DeathDetailsPersistence extends IPersistence {

	public String getServiceName(String definitionName) {
		return IDeathDetailsRequestService.SERVICE_NAME;
	}
	
	 public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
	        DeathDetailsRequest ddr = DeathDetailsRequest.Factory.newInstance();

	        String stateCode = getPostalCode().substring(0,2);
	        
	        ddr.setDeathCity(getCityName());
	        ddr.setDeathPostalCode(stateCode);
	        
	        ddr.setCopies(BigInteger.valueOf(1));
	        
	        return ddr;
	    }

	    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
	            throws Exception {

	        DeathDetailsRequestDocument.DeathDetailsRequest xmlRequest = 
	            (DeathDetailsRequestDocument.DeathDetailsRequest)xmlRequestData;
	        
	        DeathDetailsRequestDocument document = DeathDetailsRequestDocument.Factory.newInstance();
	        document.setDeathDetailsRequest(xmlRequest);

	        IDeathDetailsRequestService service = 
	            (IDeathDetailsRequestService)BusinessManager.getAc().getBean(IDeathDetailsRequestService.SERVICE_NAME);

	        return service.create(document.getDomNode());
	    }

	    private String getCityName() {
            return SecurityContext.getCurrentConfigurationBean().getDisplayTitle();
	    }
	    
	    private String getPostalCode() {
	        return SecurityContext.getCurrentSite().getPostalCode();
	    }

}
