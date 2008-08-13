package fr.cg95.cvq.fo.civil;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.civil.IMarriageDetailsRequestService;
import fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument;
import fr.cg95.cvq.xml.civil.MarriageDetailsRequestDocument.MarriageDetailsRequest;
import fr.cg95.cvq.xml.common.RequestType;

public class MarriageDetailsPersistence extends IPersistence {

	public String getServiceName(String definitionName) {
		return IMarriageDetailsRequestService.SERVICE_NAME;
	}

	public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
		MarriageDetailsRequest mdr = MarriageDetailsRequest.Factory.newInstance();

		String stateCode = getPostalCode().substring(0,2);

		mdr.setMarriageCity(getCityName());
		mdr.setMarriagePostalCode(stateCode);

		mdr.setCopies(BigInteger.valueOf(1));

		return mdr;
	}

	public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
	throws Exception {

		MarriageDetailsRequestDocument.MarriageDetailsRequest xmlRequest = 
			(MarriageDetailsRequestDocument.MarriageDetailsRequest)xmlRequestData;

		MarriageDetailsRequestDocument document = MarriageDetailsRequestDocument.Factory.newInstance();
		document.setMarriageDetailsRequest(xmlRequest);

		IMarriageDetailsRequestService service = 
			(IMarriageDetailsRequestService)BusinessManager.getAc().getBean(IMarriageDetailsRequestService.SERVICE_NAME);

		return service.create(document.getDomNode());
	}

	private String getCityName() {
        return SecurityContext.getCurrentConfigurationBean().getDisplayTitle();
    }

	private String getPostalCode() {
		return SecurityContext.getCurrentSite().getPostalCode();
	}

}
