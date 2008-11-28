package fr.cg95.cvq.util.quering.sort;

public enum SortDirection {
    ASC("ASC"), 
    DESC("DESC");

    private final String value;
    SortDirection(String value) { this.value = value; }
    public String value() { return value; }
}
