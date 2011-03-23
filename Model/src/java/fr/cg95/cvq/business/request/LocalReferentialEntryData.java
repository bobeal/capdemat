package fr.cg95.cvq.business.request;

/**
 * Simple logic-less and read-only class holding the content of a local
 * referential type entry
 * @author julien
 */
public class LocalReferentialEntryData {
    /// Entry unique key
    protected String key;
    /// Human readable label for this entry
    protected String label;
    /// (Optional) Additionnal message
    protected String message;

    public final String getKey() {
        return key;
    }
    
    public String getLabel() {
        return label;
    }

    public String getMessage() {
        return message;
    }
}
