package fr.cg95.cvq.fo.civil;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.civil.IBirthDetailsRequestService;
import fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument;
import fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest;
import fr.cg95.cvq.xml.common.RequestType;

public class BirthDetailsPersistence extends IPersistence {

	public String getServiceName(String definitionName) {
		return IBirthDetailsRequestService.SERVICE_NAME;
	}

	public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
		BirthDetailsRequest bdr = BirthDetailsRequest.Factory.newInstance();

		String stateCode = getPostalCode().substring(0,2);

		bdr.setBirthCity(getCityName());
		bdr.setBirthPostalCode(stateCode);

		bdr.setCopies(BigInteger.valueOf(1));

		return bdr;
	}

	public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData) throws Exception {
		BirthDetailsRequestDocument.BirthDetailsRequest xmlRequest = 
			(BirthDetailsRequestDocument.BirthDetailsRequest)xmlRequestData;

		BirthDetailsRequestDocument document = BirthDetailsRequestDocument.Factory.newInstance();
		document.setBirthDetailsRequest(xmlRequest);

		IBirthDetailsRequestService service = 
			(IBirthDetailsRequestService)BusinessManager.getAc().getBean(IBirthDetailsRequestService.SERVICE_NAME);

		return service.create(document.getDomNode());
	}

	private String getCityName() {
	    return SecurityContext.getCurrentConfigurationBean().getDisplayTitle();
	}

	private String getPostalCode() {
		return SecurityContext.getCurrentSite().getPostalCode();
	}

}
