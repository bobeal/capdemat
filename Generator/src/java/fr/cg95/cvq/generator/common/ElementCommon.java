package fr.cg95.cvq.generator.common;

public class ElementCommon {
    
    private Step step;
    private Condition condition;
    
    public ElementCommon() {}
    
    public ElementCommon(Step step, Condition condition) {
        this.step = step;
        this.condition = condition;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    
}
