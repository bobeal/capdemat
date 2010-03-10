package fr.cg95.cvq.business.request;

import fr.cg95.cvq.business.CapDematEvent;

public class RequestAdminEvent extends CapDematEvent {

    private static final long serialVersionUID = 1L;

    private RequestAdminAction action;

    public RequestAdminEvent(Object source, RequestAdminAction action) {
        super(source);
        this.action = action;
    }

    public RequestAdminAction getAction() {
        return action;
    }

    public void setAction(RequestAdminAction action) {
        this.action = action;
    }
}
