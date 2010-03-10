package fr.cg95.cvq.business;

import org.springframework.context.ApplicationEvent;

public abstract class CapDematEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public CapDematEvent(Object source) {
        super(source);
    }
}
