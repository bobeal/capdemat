package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rdj@zenexity.fr
 */
public class ElementCommon {
    
    private Step step;
    private ConditionListener conditionListener;
    private List<Condition> triggeredConditions = new ArrayList<Condition>();
    private String jsRegexp;
    private Autofill autofill;

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public ConditionListener getConditionListener() {
        return conditionListener;
    }

    public void setConditionListener(ConditionListener conditionListener) {
        this.conditionListener = conditionListener;
    }

    public List<Condition> getTriggeredConditions() {
        return triggeredConditions;
    }

    public String getJsRegexp() {
        return jsRegexp;
    }

    public void setJsRegexp(String jsRegexp) {
        this.jsRegexp = jsRegexp;
    }

    public Autofill getAutofill() {
        return autofill;
    }

    public void setAutofill(Autofill autofill) {
        this.autofill = autofill;
    }
}
