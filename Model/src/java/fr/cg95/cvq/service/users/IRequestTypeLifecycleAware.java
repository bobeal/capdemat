package fr.cg95.cvq.service.users;

public interface IRequestTypeLifecycleAware {

    void addRequestTypeService(IRequestService service);
    void removeRequestType(String requestTypeLabel);
}
