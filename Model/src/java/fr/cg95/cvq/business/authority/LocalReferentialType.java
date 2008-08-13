package fr.cg95.cvq.business.authority;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
    private Map labelsMap;

    /**
     * Set of {@link LocalReferentialEntry}
     */
    private Set entries;

    private boolean entriesSupportPriority;
    private boolean entriesSupportPrecision;
    private boolean entriesSupportQuota;
    private boolean entriesSupportMultiple;

    public final String getDataName() {
        return dataName;
    }
    public final void setDataName(String dataName) {
        this.dataName = dataName;
    }
    public final Set getEntries() {
        return entries;
    }
    public final void setEntries(Set entries) {
        this.entries = entries;
    }

    public final void addEntry(final LocalReferentialEntry lre) {
        if (entries == null)
            entries = new LinkedHashSet();
        entries.add(lre);
    }

    public LocalReferentialEntry getEntryByKey(final String key) {
        if (entries == null)
            return null;
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            LocalReferentialEntry lre = (LocalReferentialEntry) it.next();
            if (lre.getKey().equals(key))
                return lre;
        }

        return null;
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
    public final boolean getEntriesSupportQuota() {
        return entriesSupportQuota;
    }
    public final void setEntriesSupportQuota(boolean entriesSupportQuota) {
        this.entriesSupportQuota = entriesSupportQuota;
    }

    public final boolean getEntriesSupportMultiple() {
        return entriesSupportMultiple;
    }

    public final void setEntriesSupportMultiple(boolean entriesSupportMultiple) {
        this.entriesSupportMultiple = entriesSupportMultiple;
    }

    public final Map getLabelsMap() {
        return labelsMap;
    }

    public final void setLabelsMap(Map labelsMap) {
        this.labelsMap = labelsMap;
    }

    public final void addLabel(final String lang, final String value) {
        if (labelsMap == null)
            labelsMap = new LinkedHashMap();
        labelsMap.put(lang, value);
    }

    public final String getRequest() {
        return request;
    }

    public final void setRequest(String request) {
        this.request = request;
    }
}
