package fr.cg95.cvq.service.request.condition;

import java.util.List;

/**
 * Check if condition triggered value is equal to one mark value of a list
 */
public class EqualityListChecker implements IConditionChecker {
    private List<String> marks;
    
    public EqualityListChecker(List<String> marks) {
        this.marks = marks;
    }
    
    public boolean test(String value) {
        for (String mark : marks)
            if (mark.equals(value)) return true;
        return false;
    }
}
