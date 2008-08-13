package fr.cg95.cvq.fo.civil;

import java.math.BigInteger;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.civil.IPersonalDetailsRequestService;
import fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument;
import fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument.PersonalDetailsRequest;
import fr.cg95.cvq.xml.common.RequestType;

public class PersonalDetailsPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IPersonalDetailsRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        cvqRequest.setDbRequest(new fr.cg95.cvq.business.civil.PersonalDetailsRequest());

        PersonalDetailsRequest pdr = PersonalDetailsRequest.Factory.newInstance();

        String stateCode = getPostalCode().substring(0, 2);

        pdr.setBirthCity(getCityName());
        pdr.setBirthPostalCode(stateCode);

        pdr.setMarriageCity(getCityName());
        pdr.setMarriagePostalCode(stateCode);

        pdr.setDeathCity(getCityName());
        pdr.setDeathPostalCode(stateCode);

        pdr.setCopies(BigInteger.valueOf(1));

        return pdr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        PersonalDetailsRequestDocument.PersonalDetailsRequest xmlRequest = (PersonalDetailsRequestDocument.PersonalDetailsRequest) xmlRequestData;

        PersonalDetailsRequestDocument document = PersonalDetailsRequestDocument.Factory.newInstance();
        document.setPersonalDetailsRequest(xmlRequest);

        IPersonalDetailsRequestService service = (IPersonalDetailsRequestService) BusinessManager.getAc()
                .getBean(IPersonalDetailsRequestService.SERVICE_NAME);

        return service.create(document.getDomNode());
    }

    private String getCityName() {
        return SecurityContext.getCurrentConfigurationBean().getDisplayTitle();
    }

    private String getPostalCode() {
        return SecurityContext.getCurrentSite().getPostalCode();
    }

}
