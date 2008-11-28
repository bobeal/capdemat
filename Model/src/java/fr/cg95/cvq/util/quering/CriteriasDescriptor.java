package fr.cg95.cvq.util.quering;

import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.util.quering.criterias.ISearchCriteria;
import fr.cg95.cvq.util.quering.sort.ISortCriteria;

public class CriteriasDescriptor {
    protected Set<ISelectArgument> selects =  new HashSet<ISelectArgument>();
    protected Set<ISearchCriteria> searches = new HashSet<ISearchCriteria>();
    protected Set<ISortCriteria> sorts = new HashSet<ISortCriteria>();
    protected Integer offset;
    protected Integer max;
    
    public CriteriasDescriptor addSearch(ISearchCriteria criteria) {
        this.searches.add(criteria);
        return this;
    }
    
    public CriteriasDescriptor addSelect(ISelectArgument select) {
        this.selects.add(select);
        return this;
    }
    
    public CriteriasDescriptor addSort(ISortCriteria sort) {
        this.sorts.add(sort);
        return this;
    }

    public Set<ISelectArgument> getSelects() {
        return this.selects;
    }

    public Set<ISearchCriteria> getSearches() {
        return this.searches;
    }

    public Set<ISortCriteria> getSorts() {
        return this.sorts;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public Integer getMax() {
        return this.max;
    }

    public CriteriasDescriptor setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public CriteriasDescriptor setMax(Integer max) {
        this.max = max;
        return this;
    }
    
}
