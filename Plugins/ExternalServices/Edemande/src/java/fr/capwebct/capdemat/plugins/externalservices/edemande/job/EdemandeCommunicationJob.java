package fr.capwebct.capdemat.plugins.externalservices.edemande.job;

import java.util.List;

import fr.cg95.cvq.business.request.school.StudyGrantRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.school.IStudyGrantRequestService;

/*
 * Job dedicated to Edemande integration.
 * Checks all study grant requests and tries to send those which aren't acknowledged
 */
public class EdemandeCommunicationJob {

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IStudyGrantRequestService studyGrantRequestService;
    private IExternalProviderService edemandeService;

    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "sendRequests", null);
    }

    public void sendRequests() {
        List<StudyGrantRequest> requests = studyGrantRequestService.getSendableRequests(edemandeService.getLabel());
        for (StudyGrantRequest request : requests) {
            try {
                String externalId = edemandeService.sendRequest(studyGrantRequestService.fillRequestXml(request));
            } catch (CvqException e) {
                // TODO
            }
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setStudyGrantRequestService(IStudyGrantRequestService studyGrantRequestService) {
        this.studyGrantRequestService = studyGrantRequestService;
    }

    public void setEdemandeService(IExternalProviderService edemandeService) {
        this.edemandeService = edemandeService;
    }
}
