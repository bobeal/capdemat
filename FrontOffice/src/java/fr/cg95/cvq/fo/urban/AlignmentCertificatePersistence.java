package fr.cg95.cvq.fo.urban;

import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.service.urbanism.IAlignmentCertificateRequestService;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.urbanism.AcrRequesterQualityType;
import fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument;
import fr.cg95.cvq.xml.urbanism.AlignmentCertificateRequestDocument.AlignmentCertificateRequest;

public class AlignmentCertificatePersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IAlignmentCertificateRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        AlignmentCertificateRequest acr = AlignmentCertificateRequest.Factory.newInstance();
        acr.setRequesterQuality(AcrRequesterQualityType.OWNER);

        // Owner address is not required, so not created by the system, we'll have to add it manualy
        acr.addNewOwnerAddress();

        return acr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {

        AlignmentCertificateRequestDocument.AlignmentCertificateRequest xmlRequest = (AlignmentCertificateRequestDocument.AlignmentCertificateRequest) xmlRequestData;

        AlignmentCertificateRequestDocument document = AlignmentCertificateRequestDocument.Factory
                .newInstance();
        document.setAlignmentCertificateRequest(xmlRequest);

        IAlignmentCertificateRequestService service = (IAlignmentCertificateRequestService) BusinessManager
                .getAc().getBean(IAlignmentCertificateRequestService.SERVICE_NAME);

        return service.create(document.getDomNode());
    }

}
