package fr.cg95.cvq.service.request.job;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;

/**
 * A job that do automatic states changes for requests tied to seasons.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestSeasonsJob {

    private static Logger logger = Logger.getLogger(RequestSeasonsJob.class);
    
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestService requestService;
    private IRequestDAO requestDAO;
    
    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "checkRequestsSeasons", null);
    }

    public void checkRequestsSeasons()
        throws CvqException {
    
        List<RequestType> requestTypes = requestService.getAllRequestTypes();
        for (RequestType requestType : requestTypes) {
            if (requestType.getSeasons() == null || requestType.getSeasons().isEmpty()) {
                logger.debug("checkRequestsSeasons() no seasons defined for request type " 
                        + requestType.getLabel());
                continue;
            }
                
            logger.debug("checkRequestsSeasons() looking at seasons for request type " 
                    + requestType.getLabel());
            Date now = new Date();
            Set<RequestSeason> requestSeasons = requestType.getSeasons();
            for (RequestSeason requestSeason : requestSeasons) {
                logger.debug("checkRequestsSeasons() looking at season " 
                        + requestSeason.getLabel());
                if (requestSeason.getEffectStart().before(now)
                        && requestSeason.getEffectEnd().after(now)) {
                    List<Request> requests = 
                        requestDAO.listByStateAndSeason(RequestState.NOTIFIED, 
                                requestSeason.getUuid());
                    for (Request request : requests) {
                        requestService.activate(request);
                    }
                } else if (requestSeason.getEffectEnd().before(now)) {
                    List<Request> requests = 
                        requestDAO.listByStateAndSeason(RequestState.ACTIVE, 
                                requestSeason.getUuid());
                    for (Request request : requests) {
                        requestService.expire(request);
                    }
                }
            }
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }
}
