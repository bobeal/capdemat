import java.util.Hashtable

import fr.cg95.cvq.business.authority.Agent
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.request.ICategoryService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext

class BackofficeRequestController {

    IAgentService agentService
    ICategoryService categoryService
    IRequestSearchService requestSearchService
    IRequestStatisticsService requestStatisticsService
    
    def translationService
    def requestAdaptorService
    
    def defaultAction = 'initSearch'
    // keys supported in advanced search screen : match with keys defined in Request.java
    def supportedKeys = ['requesterLastName', 'subjectLastName', 'id', 'homeFolderId',
                         'creationDateFrom', 'creationDateTo']
    def longKeys = ['id', 'homeFolderId']
    def dateKeys = ['creationDateFrom', 'creationDateTo']
    def defaultSortBy = 'creationDate'
    def resultsPerPage = 15
    def beforeInterceptor = {
        session["currentMenu"] = "requests"
    }
    
    
    /**
     * Called when first entering the search screen
     */
    def initSearch = {
        if(session['filterBy'] || session['sortBy']) {
            redirect(action:search,params:['filterBy':session['filterBy']])
        }
        else {
        render(view:'search', 
            model:['inSearch':false, 'sortBy':defaultSortBy,
                   'filters':[:]].plus(initSearchReferential()))
        }
    }

    /**
     * Called (synchronously) when performing a search
     */
    def search = {
       
        // deal with search criteria
        Set<Critere> criteria = new HashSet<Critere>()
        criteria.add(new Critere(Request.SEARCH_BY_STATE, RequestState.DRAFT,
            Critere.NEQUALS))
        params.each { key,value ->
            if (supportedKeys.contains(key) && value != "") {
                Critere critere = new Critere()
                critere.attribut = key
                critere.comparatif = Critere.EQUALS
                if (longKeys.contains(key)) {
                    critere.value = LongUtils.stringToLong(value)
                } else if (dateKeys.contains(key)) {
                    critere.value = DateUtils.stringToDate(value)
                    if (key == 'creationDateFrom') {
                        critere.attribut = 'creationDate'
                        critere.comparatif = Critere.GTE
                    } else {
                        critere.attribut = 'creationDate'
                        critere.comparatif = Critere.LTE
                    }
                } else {
                    critere.comparatif = Critere.STARTSWITH
                    critere.value = value
                }
                criteria.add(critere)
            }
        }
        
        // deal with dynamic filters
        def hasStateFilter = false
        def parsedFilters = SearchUtils.parseFilters(params.filterBy)
        parsedFilters.filters.each { key, value ->
            Critere critere = new Critere()
            critere.attribut = key.replaceAll('Filter','')
            critere.comparatif = Critere.EQUALS
            if (key == 'stateFilter') {
                critere.value = value
                hasStateFilter = true
            }
            else if (key == 'qualityFilter') {
                critere.attribut = 'qualityType'
                critere.value = "qualityType"+value
            } else
                critere.value = Long.valueOf(value)
            criteria.add(critere)
        }
        if (!hasStateFilter) {
            Critere critere = new Critere()
            critere.attribut = Request.SEARCH_BY_STATE
            critere.comparatif = Critere.NEQUALS
            critere.value = RequestState.ARCHIVED
            criteria.add(critere)
        }
        
        // deal with dynamic sorts
        def sortBy = defaultSortBy
        if(params.sortBy)
            sortBy = params.sortBy
        else if(session['sortBy'])
            sortBy = session['sortBy']
        
        def sortDir = params.dir ? params.dir : 'desc'
        
        // deal with pagination settings
        def results = params.results == null ? resultsPerPage : Integer.valueOf(params.results)
        def recordOffset = 
            (params.recordOffset == "" || params.recordOffset == null) ? 0 : Integer.valueOf(params.recordOffset)        
            
        // now, perform the search request
        def requests =
            requestSearchService.get(criteria, sortBy, sortDir, results, recordOffset, false)
        def recordsList = []
        requests.each {
            def record = requestAdaptorService.prepareRecordForSummaryView(it)
            recordsList.add(record)
        }
        
        session['filterBy'] = parsedFilters.filterBy
        session['sortBy'] = sortBy
        
        render(view:'search', 
            model:['records':recordsList,
                   'recordsReturned':requests.size(),
                   'totalRecords':requestSearchService.getCount(criteria),
                   'filters':parsedFilters.filters,
                   'filterBy':parsedFilters.filterBy,
                   'recordOffset':recordOffset,
                   'sortBy':sortBy,
                   'dir':sortDir,
                   'inSearch':true,
                   'results':results].plus(initSearchReferential()))
    }

    def initSearchReferential() {
        def subMenuEntries = ["request.search"]
        if (categoryService.hasManagerProfile(SecurityContext.currentAgent))
            subMenuEntries.add("requestType.list")

        return ['allStates':RequestState.allRequestStates.findAll { it != RequestState.DRAFT },
                'allAgents':agentService.getAll(),
                'allCategories':categoryService.getAll(),
                'allRequestTypes':requestAdaptorService.translateAndSortRequestTypes(),
                'subMenuEntries' : subMenuEntries]
    }

    def listTasks = {
        def recordsList = []
        requestSearchService.listTasks(params.qoS, defaultSortBy, 0).each {
            def record = requestAdaptorService.prepareRecordForSummaryView(it)
            recordsList.add(record)
        }

        session['filterBy'] = [:]
        session['sortBy'] = defaultSortBy

        // TODO deal with pagination
        render(view : 'search', model:['records' : recordsList,
                   'recordsReturned' : recordsList.size(),
                   'totalRecords' : recordsList.size(),
                   'filters' : [:],
                   'filterBy' : [:],
                   'recordOffset' : 0,
                   'sortBy' : defaultSortBy,
                   'inSearch' : true,
                   'results' : 100
                   ].plus(initSearchReferential()))
    }
}
