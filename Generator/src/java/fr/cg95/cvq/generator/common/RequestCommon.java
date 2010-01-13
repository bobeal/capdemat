package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.generator.common.Autofill.AutofillType;

/**
 * @author rdj@zenexity.fr
 */
public class RequestCommon {
    
    public final static String MODEL_REQUEST_NS = "fr.cg95.cvq.business.request";
    
    private String namespace;
    private List<Step> steps;
    
    private ElementCommon currentElementCommon;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void addStep(Step step) {
        if (steps == null)
            steps = new ArrayList<Step>();
        
        int i = 0;
        for (Step s : steps) {
            i++;
            if (s.getName() != null && s.getName().equals(step.getName()))
                throw new RuntimeException("AddStep() - " +
                		"Step {"+ step.getName() +"} already exists");
            if (s.getIndex() == step.getIndex())
                throw new RuntimeException("AddStep() - " +
                		"Step {"+ step.getName() +"} defines index {"+ step.getIndex() +"} that already exists");
            if (steps.size() == i && s.getIndex() + 1 != step.getIndex())
                throw new RuntimeException("AddStep() - " +
                        "Step {"+ step.getName() +"} defines " +
                        "index {" + step.getIndex() +"} that's not follow {" + s.getIndex() + "}");   
        }
        steps.add(step);
    }
    
    private List<Condition> getAllConditions() {
        List<Condition> conditions = new ArrayList<Condition>();
        for (Step s : steps)
                conditions.addAll(s.getConditions());
        return conditions;
    }
    
    public void addConditionToStep(Step step, Condition condition) {
        if(!steps.contains(step))
            return;
        for(Condition c : getAllConditions())
            if(c.getName().equals(condition.getName()))
                throw new RuntimeException("addconditionToStep() - " +
                        "Condition {"+ condition.getName() +"} already exists");
        step.addCondition(condition);
    }

    private List<Autofill> getAutofills() {
        List<Autofill> autofills = new ArrayList<Autofill>();
        for (Step s : steps) {
            for (Widget w : s.getWidgets()) {
                if (w.getAutofill() != null) {
                    autofills.add(w.getAutofill());
                }
            }
        }
        return autofills;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
    
    /* Current Elemeent managment */
    public void setCurrentElementStep (String name) {
        if (currentElementCommon == null)
            currentElementCommon = new ElementCommon();
        
        Step step = getStepByName(name);
        if (step == null)
            throw new RuntimeException("setCurrentElementStep() - " +
                    "Step {"+ name +"} do not exists");
        
        currentElementCommon.setStep(step);
    }
    
    private Step getStepByName(String name) {
        for (Step s : steps)
            if (s.getName().equals(name))
                return s;
        return null;
    }

    public void addCurrentElementCondition (Condition condition) {
        boolean isConditionDefined = false;
        if (currentElementCommon.getStep() != null) {
            for (Condition c : getStepByName(currentElementCommon.getStep().getName()).getConditions()) {
                if (c.getName().equals(condition.getName())) {
                    isConditionDefined = true;
                    break;
                }
            }
        }
        if (! isConditionDefined)
            throw new RuntimeException("setCurrentElementCondition() - Condition "
                    + "{"+ condition.getName() +"} do not exists");
        
        currentElementCommon.addCondition(condition);
    }
    
    public void setCurrentElementAutofill(String name, String type, String field) {
        if (!AutofillType.LISTENER.name().equals(type.toUpperCase())) {
            throw new RuntimeException("setCurrentElementAutofill() - Autofill {" + name + "} type must be listener");
        }
        if (field == null || field.trim().isEmpty()) {
            throw new RuntimeException("setCurrentElementAutofill() - Autofill {" + name + "} must have field attribute");
        }
        boolean isAutofillDefined = false;
        for (Autofill a : getAutofills()) {
            if (a.getName().equals(name)) {
                isAutofillDefined = true;
                break;
            }
        }
        if (!isAutofillDefined) {
            throw new RuntimeException("setCurrentElementAutofill() - Autofill {"+ name +"} does not exist");
        }
        currentElementCommon.setAutofill(new Autofill(AutofillType.LISTENER, name, field));
    }

    public void setWidgetAutofill(Widget widget, String name, String type, String field) {
        if (!AutofillType.TRIGGER.name().equals(type.toUpperCase())) {
            throw new RuntimeException("setWidgetAutofill() - Autofill {" + name + "} type must be trigger for widget " + widget.getName());
        }
        if (field != null) {
            throw new RuntimeException("setWidgetAutofill() - Autofill {" + name + "} trigger declaration must not have a field attribute");
        }
        boolean isAutofillDefined = false;
        for (Autofill a : getAutofills()) {
            if (a.getName().equals(name)) {
                isAutofillDefined = true;
                break;
            }
        }
        if (isAutofillDefined) {
            throw new RuntimeException("setWidgetAutofill() - Autofill {"+ name +"} already exists");
        }
        widget.setAutofill(new Autofill(AutofillType.TRIGGER, name, field));
    }

    public ElementCommon getCurrentElementCommon() {
        return currentElementCommon;
    }

    public void setCurrentElementCommon(ElementCommon currentElementCommon) {
        this.currentElementCommon = currentElementCommon;
    }

}
