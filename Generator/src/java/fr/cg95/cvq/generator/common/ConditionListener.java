package fr.cg95.cvq.generator.common;

import fr.cg95.cvq.generator.common.Condition.RoleType;

public class ConditionListener {

    private Condition condition;

    private ElementCommon listener;

    private RoleType role;

    private boolean required = false;

    public ConditionListener(Condition condition, ElementCommon listener, RoleType role, boolean required) {
        this.condition = condition;
        this.listener = listener;
        this.role = role;
        this.required = required;
    }

    public boolean listenAMultiTrigger() {
        return condition.getTrigger().getTriggeredConditions().size() > 1;
    }

    public ElementCommon getListener() {
        return listener;
    }

    public boolean isRequired() {
        return required;
    }

    public RoleType getRole() {
        return role;
    }

    public Condition getCondition() {
        return condition;
    }
}
