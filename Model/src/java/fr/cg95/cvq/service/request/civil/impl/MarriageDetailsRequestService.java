package fr.cg95.cvq.service.request.civil.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType;
import fr.cg95.cvq.business.request.civil.MarriageDetailsRequest;
import fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the {@link IMarriageDetailsRequestService marriage details request service}.
 * 
 * @author bor@zenexity.fr
 */
public final class MarriageDetailsRequestService extends RequestService {

    @Override
    public void init() {
        MarriageDetailsRequest.conditions.put("requesterQuality", new EqualityChecker(MarriageRequesterQualityType.OTHER.name()));
        MarriageDetailsRequest.conditions.put("format",
            new EqualityListChecker(Arrays.asList(MarriageCertificateFormatType.FULL_COPY.name(),MarriageCertificateFormatType.EXTRACT_WITH_RELATIONSHIP.name())));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof MarriageDetailsRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        MarriageDetailsRequest request = new MarriageDetailsRequest();
        //FIXME see Birth
        if (SecurityContext.getCurrentSite() != null) {
            request.setMarriageCity(SecurityContext.getCurrentSite().getDisplayTitle());
            request.setMarriagePostalCode(SecurityContext.getCurrentSite().getPostalCode().substring(0,2));
        }
        return request;
    }
}
