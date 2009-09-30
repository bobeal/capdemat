package fr.cg95.cvq.service.request.job;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.IRequestWorkflowService;
import fr.cg95.cvq.util.Critere;

/**
 * A job that do automatic states changes for requests tied to seasons.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestSeasonsJob implements BeanFactoryAware {

    private static Logger logger = Logger.getLogger(RequestSeasonsJob.class);
    
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestWorkflowService requestWorkflowService;
    private IRequestTypeService requestTypeService;
    private IRequestService requestService;
    private BeanFactory beanFactory;

    public void init() {
        this.requestService =
            (IRequestService)beanFactory.getBean("defaultRequestService");
    }

    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "checkRequestsSeasons", null);
    }

    public void checkRequestsSeasons()
        throws CvqException {
    
        List<RequestType> requestTypes = requestTypeService.getAllRequestTypes();
        for (RequestType requestType : requestTypes) {
            if (requestType.getSeasons() == null || requestType.getSeasons().isEmpty()) {
                logger.debug("checkRequestsSeasons() no seasons defined for request type " 
                        + requestType.getLabel());
                continue;
            }
                
            logger.debug("checkRequestsSeasons() looking at seasons for request type " 
                    + requestType.getLabel());
            Set<RequestSeason> requestSeasons = requestType.getSeasons();
            for (RequestSeason requestSeason : requestSeasons) {
                logger.debug("checkRequestsSeasons() looking at season " 
                        + requestSeason.getLabel());
                Set<Critere> criterias = new HashSet<Critere>(2);
                Critere stateCriteria =
                    new Critere(Request.SEARCH_BY_STATE, RequestState.NOTIFIED,
                        Critere.EQUALS);
                criterias.add(stateCriteria);
                Critere seasonCriteria =
                    new Critere(Request.SEARCH_BY_SEASON_ID,
                        requestSeason.getId(), Critere.EQUALS);
                criterias.add(seasonCriteria);
                if (requestSeason.getEffectStart().isBeforeNow()
                        && requestSeason.getEffectEnd().isAfterNow()) {
                    List<Request> requests = 
                        requestService.get(criterias, null, null, 0, 0);
                    for (Request request : requests) {
                        requestWorkflowService.updateRequestState(request.getId(),
                            RequestState.ACTIVE, null);
                    }
                } else if (requestSeason.getEffectEnd().isBeforeNow()) {
                    stateCriteria.setValue(RequestState.ACTIVE);
                    List<Request> requests = 
                        requestService.get(criterias, null, null, 0, 0);
                    for (Request request : requests) {
                        requestWorkflowService.updateRequestState(request.getId(),
                            RequestState.EXPIRED, null);
                    }
                }
            }
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public void setRequestWorkflowService(IRequestWorkflowService requestWorkflowService) {
        this.requestWorkflowService = requestWorkflowService;
    }

    public void setRequestTypeService(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
