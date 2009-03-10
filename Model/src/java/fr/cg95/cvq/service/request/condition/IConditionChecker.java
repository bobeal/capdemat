package fr.cg95.cvq.service.request.condition;

/** 
 * Implements IConditionChecker to describe custom business condition policy
 * Custom business implementation might be enclosed as inner class of related request service
 */
public interface IConditionChecker {
    boolean test(String value);
}