package fr.capwebct.capdemat.plugins.externalservices.edemande.job;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;

/*
 * Job dedicated to Edemande integration.
 * Checks all study grant requests and tries to send those which aren't acknowledged
 */
public class EdemandeCommunicationJob implements BeanFactoryAware {

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestService requestService;
    private IExternalProviderService edemandeService;
    private IExternalService externalService;
    private ListableBeanFactory beanFactory;

    public void init() {
        requestService = (IRequestService)beanFactory.getBean("defaultRequestService");
    }

    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "sendRequests", null);
    }

    public void sendRequests() {
        List<Request> requests = requestService.getSendableRequests(edemandeService.getLabel());
        for (Request request : requests) {
            try {
                externalService.sendRequest(request);
            } catch (CvqException e) {
                // TODO
            }
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setEdemandeService(IExternalProviderService edemandeService) {
        this.edemandeService = edemandeService;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }

    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        this.beanFactory = (ListableBeanFactory) arg0;
    }
}
