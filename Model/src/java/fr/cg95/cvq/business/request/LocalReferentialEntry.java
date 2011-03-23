package fr.cg95.cvq.business.request;

import java.util.Set;
import java.util.LinkedHashSet;

/**
 * A single entry in a local referential type.
 * Each entry is identified by a key which is unique in the whole tree, and
 * contains a label and an optional message.
 */
public class LocalReferentialEntry extends LocalReferentialEntryData {

    /**
     * Children entries.
     */
    private Set<LocalReferentialEntry> entries = new LinkedHashSet<LocalReferentialEntry>();
    
    /**
     * Parent entry of this entry (automatically set when added to an entry)
     */
    private LocalReferentialEntry parent = null;

    public LocalReferentialEntry getParent() {
        return parent;
    }

    public final Set<LocalReferentialEntry> getEntries() {
        return entries;
    }

    public final void setEntries(Set<LocalReferentialEntry> entries) {
        this.entries = entries;
    }

    public final void addEntry(final LocalReferentialEntry lre) {
        lre.parent = this;
        entries.add(lre);
    }
    
    public final void removeEntry(final LocalReferentialEntry lre) {
        entries.remove(lre);
    }
    
    // FIXME this method should not be public
    public final void setKey(String key) {
        this.key = key;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
