package fr.cg95.cvq.service.request;

public interface IRequestTypeLifecycleAware {

    void addRequestTypeService(IRequestService service);
    void removeRequestType(String requestTypeLabel);
}
