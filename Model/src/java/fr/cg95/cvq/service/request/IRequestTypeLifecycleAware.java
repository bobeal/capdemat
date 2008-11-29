package fr.cg95.cvq.service.request;

/**
 * This is the interface to be implemented by services wishing to be notified
 * of requests services lifecycle events. 
 *
 * @author bor@zenexity.fr
 */
public interface IRequestTypeLifecycleAware {

    void addRequestTypeService(IRequestService service);
    void removeRequestType(String requestTypeLabel);
}
