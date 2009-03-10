package fr.cg95.cvq.service.request.condition;

import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Check if condition triggered value is equal to mark value
 */
public class EqualityChecker implements IConditionChecker {
    private String mark;
    
    public EqualityChecker(String mark) {
        this.mark = mark;
    }
    
    public boolean test(String value) {
        return mark.equals(value);
    }
}