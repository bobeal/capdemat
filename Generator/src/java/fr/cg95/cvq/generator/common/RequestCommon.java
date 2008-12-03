package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rdj@zenexity.fr
 */
public class RequestCommon {
    
    public final static String MODEL_REQUEST_NS = "fr.cg95.cvq.business.request";
    
    private String namespace;
    private List<Step> steps;
    private Set<Condition> conditions;
    
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
        
        if (step.getRef() != null && step.getName() != null)
            throw new RuntimeException("AddStep() - " +
                    "Step can not define both name={"+ step.getName() +"}" +
                    " and ref={"+ step.getRef() + "}");
        
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
    
    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
    
    private Step getStepByName(String name) {
        for (Step s : steps)
            if (s.getName().equals(name))
                return s;   
        return null;
    }
    
    public void addConditionStep(String stepName, String conditionName) {
        Step step = getStepByName(stepName);
        if (step  != null) {
            for (Step s : steps)
                if (s.containsConditionName(conditionName) && !s.getName().equals(stepName))
                    throw new RuntimeException("addConditionStep() - Condition {"+ conditionName +"} " +
                    		"is already associated with Step {"+ s.getName() +"}");
            
            step.addConditionName(conditionName);
        }
    }

    public void addCondition(Condition condition) {
        if (conditions == null)
            conditions = new HashSet<Condition>();
        
        for (Condition c : conditions) {
            if (c.getName().equals(condition.getName()))
                throw new RuntimeException("addCondition() - " +
                		"Condition {"+ condition.getName() +"} already exists");
        }
        conditions.add(condition);
    }
    
    public Set<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Set<Condition> conditions) {
        this.conditions = conditions;
    }
    
    /* Current Elemeent managment */
    public void setCurrentElementStep (Step step) {
        if (currentElementCommon == null)
            currentElementCommon = new ElementCommon();
        
        boolean isStepDefined = false;
        for (Step s : steps) {
            if (s.getName() != null && s.getName().equals(step.getName())) {
                isStepDefined = true;
                break;
            }
        }
        if (! isStepDefined)
            throw new RuntimeException("setCurrentElementStep() - " +
                    "Step {"+ step.getName() +"} do not exists");
        
        currentElementCommon.setStep(step);
    }
    
    public void addCurrentElementCondition (Condition condition) {
        if (currentElementCommon == null)
            currentElementCommon = new ElementCommon();
        
        boolean isConditionDefined = false;
        for (Condition c : conditions) {
            if (c.getName().equals(condition.getName())) {
                isConditionDefined = true;
                break;
            }
        }
        if (! isConditionDefined)
            throw new RuntimeException("setCurrentElementCondition() - Condition "
                    + "{"+ condition.getName() +"} do not exists");
        
        currentElementCommon.addCondition(condition);
    }
    
    public ElementCommon getCurrentElementCommon() {
        return currentElementCommon;
    }

    public void setCurrentElementCommon(ElementCommon currentElementCommon) {
        this.currentElementCommon = currentElementCommon;
    }
    
}
