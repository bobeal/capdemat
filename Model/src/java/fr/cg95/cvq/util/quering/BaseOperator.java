package fr.cg95.cvq.util.quering;

public enum BaseOperator {
    
    IN("IN"), 
    NOT_IN("NOT IN"),
    EQUALS("="), 
    IEQUALS("i="), 
    NEQUALS("!="), 
    LIKE("LIKE"), 
    STARTSWITH("STARTSWITH"), 
    GT(">"), 
    LT("<"), 
    GTE(">="),
    LTE("<=");

    private final String value;
    BaseOperator(String value) { this.value = value; }
    public String value() { return value; }    
}