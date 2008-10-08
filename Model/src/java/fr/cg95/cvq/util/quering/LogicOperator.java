package fr.cg95.cvq.util.quering;

public enum LogicOperator {
    AND("AND"), 
    OR("OR");

    private final String value;
    LogicOperator(String value) { this.value = value; }
    public String value() { return value; } 
}
