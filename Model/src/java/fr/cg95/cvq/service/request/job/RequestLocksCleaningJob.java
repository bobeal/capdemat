package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestLockService;

/**
 * Remove obsolete request locks from memory and db
 * 
 * @author jsb@zenexity.fr
 *
 */
public class RequestLocksCleaningJob {

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestLockService requestLockService;

    public void launchJob() {
        localAuthorityRegistry.browseAndCallback(this, "cleanRequestLocks", null);
    }

    public void cleanRequestLocks() {
        requestLockService.cleanRequestLocks();
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestLockService(IRequestLockService requestLockService) {
        this.requestLockService = requestLockService;
    }
}
