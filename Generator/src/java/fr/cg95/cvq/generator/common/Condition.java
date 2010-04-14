package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rdj@zenexity.fr
 * @author jsb@zenexity.fr
 */
public class Condition {

    public enum RoleType {
        trigger, filled, unfilled;
    }

    private String name;

    private ElementCommon trigger;

    private List<ConditionListener> listeners;

    public Condition(String name) {
        this.name = name;
        listeners = new ArrayList<ConditionListener>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementCommon getTrigger() {
        return trigger;
    }

    public void setTrigger(ElementCommon trigger) {
        this.trigger = trigger;
    }

    public List<ConditionListener> getListeners() {
        return listeners;
    }
}
