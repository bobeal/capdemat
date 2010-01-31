package fr.cg95.cvq.business.request;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.exception.CvqLocalReferentialException;

/**
 * Define a type of local referential data, eg food diet for a school canteen registration request.
 * 
 * @author bor@zenexity.fr
 */
public class LocalReferentialType {

    /**
     * Request defining this local referential type, null if a common one
     */
    private String request;

    /**
     * Name of data pointed to by this type
     */
    private String dataName;

    /**
     * Map of labels keyed by their two-letters language code
     */
    private Map<String,String> labelsMap;

    /**
     * Set of {@link LocalReferentialEntry}
     */
    private Set<LocalReferentialEntry> entries;
    
    /**
     * Map of all entries indexed by their key
     *  - useful to ensure key uniqueness in entries tree
     *  - useful to ease fetching of a particular entry in the tree
     */
    private Map<String,LocalReferentialEntry> keyEntriesMap ;

    private boolean entriesSupportPriority;
    private boolean entriesSupportPrecision;
    private boolean entriesSupportMultiple;

    public final String getDataName() {
        return dataName;
    }
    
    public final void setDataName(String dataName) {
        this.dataName = dataName;
    }
    
    public final Set<LocalReferentialEntry> getEntries() {
        return entries;
    }
    
    public final void setEntries(Set<LocalReferentialEntry> entries) {
        this.entries = entries;
    }

    public final void addEntry(final LocalReferentialEntry lre, 
            final LocalReferentialEntry parentLre) throws CvqLocalReferentialException {
        if (lre.getKey() == null)
            lre.setKey(generateEntryKey(lre, parentLre));
        putkeyEntry(lre);
        if (parentLre != null)
            parentLre.addEntry(lre);
        else {
            if (entries == null)
                entries = new LinkedHashSet<LocalReferentialEntry>();
            entries.add(lre);
        }
    }
    
    public final void removeEntry(final LocalReferentialEntry lre, 
            final LocalReferentialEntry parentLre) {
        removeKeyEntries(lre.getEntries());
        keyEntriesMap.remove(lre.getKey());
        if (parentLre != null)
            parentLre.removeEntry(lre);
        else {
            if (entries == null)
                return;
            entries.remove(lre);
        }
    }
    
    private void removeKeyEntries(Set<LocalReferentialEntry> entries) {
        if (entries != null) {
            for (LocalReferentialEntry lre : entries) {
                removeKeyEntries(lre.getEntries());
                keyEntriesMap.remove(lre.getKey());
            }
        }
    }
    
    public LocalReferentialEntry getEntryByKey(final String key) {
        if (keyEntriesMap == null)
            return null;
        return keyEntriesMap.get(key);
    }

    public final boolean getEntriesSupportPrecision() {
        return entriesSupportPrecision;
    }
    public final void setEntriesSupportPrecision(boolean entriesSupportPrecision) {
        this.entriesSupportPrecision = entriesSupportPrecision;
    }
    public final boolean getEntriesSupportPriority() {
        return entriesSupportPriority;
    }
    public final void setEntriesSupportPriority(boolean entriesSupportPriority) {
        this.entriesSupportPriority = entriesSupportPriority;
    }

    public final boolean getEntriesSupportMultiple() {
        return entriesSupportMultiple;
    }

    public final void setEntriesSupportMultiple(boolean entriesSupportMultiple) {
        this.entriesSupportMultiple = entriesSupportMultiple;
    }

    public final Map<String,String> getLabelsMap() {
        return labelsMap;
    }

    public final void setLabelsMap(Map<String,String> labelsMap) {
        this.labelsMap = labelsMap;
    }

    public final void addLabel(final String lang, final String value) {
        if (labelsMap == null)
            labelsMap = new LinkedHashMap<String,String>();
        labelsMap.put(lang, value);
    }

    public final String getRequest() {
        return request;
    }

    public final void setRequest(String request) {
        this.request = request;
    }
    
    private void putkeyEntry(LocalReferentialEntry lre) throws CvqLocalReferentialException {
        if (keyEntriesMap == null)
            keyEntriesMap = new HashMap<String, LocalReferentialEntry>();
        
        if (keyEntriesMap.containsKey(lre.getKey()))
            throw new CvqLocalReferentialException("localReferential.error.entryAlreadyExists");
        keyEntriesMap.put(lre.getKey(), lre);
    }
    
    // TODO - How to manage i18n and key generation policy
    private String generateEntryKey(LocalReferentialEntry lre, LocalReferentialEntry parentLre) {
        String suffixKey = Normalizer.normalize(lre.getLabelsMap().get("fr"), Normalizer.Form.NFD).replaceAll("[^\\w\\.]", "-").replace('_', '-');
        return (parentLre != null ? parentLre.getKey() + "-" : "") + suffixKey;
    }
}
