/**
 * Utility methods to deal with filters and sorters used in search screens.
 * 
 * @author bor
 */
public class SearchUtils{

	/**
	 * Receive a string of the form filter1Name=filter1Value@filter2Name=filter2Value@...
	 * and return a map of parsed filters and a reusable filterBy parameter (without duplicates).
	 */
	public static parseFilters(filterByParam) {
        def filters = [:]
        if (filterByParam && filterByParam != '') {
            filterByParam?.split('@').each { filter ->
                if (filter != "") {
                    def parsedFilter = filter.split('=')
                    if (parsedFilter.size() == 2) {
                        filters[parsedFilter[0]] = parsedFilter[1]
                    } else {
                        filters.remove(parsedFilter[0])
                    }
                }
            }
        }

        return ["filters":filters,"filterBy":formatFilters(filters)]
	}
    
    /**
     * 
     */
    public static formatFilters(filters) {
        def filterBy = ''
        filters.each { key, value ->
            filterBy += '@' + key + '=' + value
        }
        return filterBy
    }
	
}
