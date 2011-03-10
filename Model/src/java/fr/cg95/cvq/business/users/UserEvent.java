package fr.cg95.cvq.business.users;

import fr.cg95.cvq.business.CapDematEvent;

public class UserEvent extends CapDematEvent {

    private static final long serialVersionUID = 1L;

    private UserAction action;

    public UserEvent(Object source, UserAction action) {
        super(source);
        this.action = action;
    }

    public UserAction getAction() {
        return action;
    }
}
