package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.service.request.IRequestService;

/**
 * Permits to mamage drafts
 * 
 * Created by vba@zenexity.fr
 * Date: 15.01.2009
 * Time: 14:32:47
 */

public class DraftManagementJob {
    
    private IRequestService requestService;
    private Integer liveDuration;

    public void launchJob() {
        
    }

    public IRequestService getRequestService() {
        return requestService;
    }

    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    public Integer getLiveDuration() {
        return liveDuration;
    }

    public void setLiveDuration(Integer liveDuration) {
        this.liveDuration = liveDuration;
    }
}
