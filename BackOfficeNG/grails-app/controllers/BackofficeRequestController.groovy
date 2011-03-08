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

import grails.converters.JSON

class BackofficeRequestController {

    IAgentService agentService
    ICategoryService categoryService
    IRequestSearchService requestSearchService
    IRequestStatisticsService requestStatisticsService
    
    def translationService
    def instructionService
    def requestAdaptorService
    
    def defaultAction = 'initSearch'
    def static subMenuEntries = [
        "request.search",
        "requestType.list"
    ]

    // keys supported in advanced search screen : match with keys defined in Request.java
    def supportedKeys = ['requesterLastName', 'subjectLastName', 'id', 'homeFolderId',
                         'creationDateFrom', 'creationDateTo']
    def longKeys = ['id', 'homeFolderId']
    def dateKeys = ['creationDateFrom', 'creationDateTo']
    def defaultSortBy = 'creationDate'
    def resultsPerPage = 15
    // default number of tasks to show per type
    def tasksShowNb = 5 
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
                   'inSearch':true].plus(initSearchReferential()))
    }

    /**
     * Called when asking for the agent's task board
     */
    def taskBoard = {
        def state = [:]
        def pageState = ""
        def method = request.getMethod().toLowerCase()
        
        state['displayForm'] = agentService.getPreferenceByKey('display')?.displayForm?.split(",")
        if(state['displayForm'] == null)
            state['displayForm'] = ['Late','Alert','New','Last','Validated']
        else 
            state['displayForm'] = state['displayForm'] as List

        if(method == 'get') {
            state['defaultDisplay'] = state['displayForm']
            def categoryIdFilter = ''
            def requestTypeIdFilter = ''
            if(session['filterBy']) {
                def allFilters = SearchUtils.parseFilters(session['filterBy']).filters
                categoryIdFilter = allFilters['categoryIdFilter']
                requestTypeIdFilter = allFilters['requestTypeIdFilter']
            }
            state['filters'] = ['categoryIdFilter':categoryIdFilter,'requestTypeIdFilter':requestTypeIdFilter]
        } else { 
            state = JSON.parse(params.pageState);
            session['filterBy'] = SearchUtils.formatFilters(state.filters)
        }
        
        if(state.modifyDisplay == true) {
            Hashtable<String, String> hash = new Hashtable<String, String>()
            hash.put('displayForm', state.displayForm?.join(",").replace('\"',''))
            agentService.modifyPreference('display',hash)
            state.modifyDisplay = null
            state['defaultDisplay'] = state['displayForm']
            state['message'] = message(code:'message.updateDone')
        }
        
        pageState = (new JSON(state)).toString()
        session['currentMenu'] = 'taskBoard'
        
        def requestMap = [:]
        
        if(state?.displayForm?.contains('Late'))
            requestMap.redRequests = filterRequests('SEARCH_BY_QUALITY_TYPE',Request.QUALITY_TYPE_RED,state)
        if(state?.displayForm?.contains('Alert'))
            requestMap.orangeRequests = filterRequests('SEARCH_BY_QUALITY_TYPE',Request.QUALITY_TYPE_ORANGE,state)
        if(state?.displayForm?.contains('New'))
            requestMap.pendingRequests = filterRequests('SEARCH_BY_STATE',RequestState.PENDING,state)
        if(state?.displayForm?.contains('Validated'))
            requestMap.validatedRequests = filterRequests('SEARCH_BY_STATE',RequestState.VALIDATED,state)
        if(state?.displayForm?.contains('Last'))
            requestMap.lastRequests = filterRequests('SEARCH_BY_LAST_INTERVENING_USER_ID',
                    SecurityContext.currentUserId,state)

        
        
        render (view:'taskBoard', model:['requestMap':requestMap,
                                         'state' : state,
                                         'currentUserId' : SecurityContext.currentUserId,
                                         'pageState' : pageState.encodeAsHTML(),
                                         'allCategories':categoryService.getAll(),
                                         'allRequestTypes':requestAdaptorService.translateAndSortRequestTypes()])
    }
    
    def initSearchReferential() {
        return ['allStates':RequestState.allRequestStates.findAll { it != RequestState.DRAFT },
                'allAgents':agentService.getAll(),
                'allCategories':categoryService.getAll(),
                'allRequestTypes':requestAdaptorService.translateAndSortRequestTypes(),
                'subMenuEntries' : subMenuEntries]
    }
    
    protected filterRequests = {attr,val,state ->
        Set criteriaSet = new HashSet<Critere>()
        Critere critere = new Critere()
        
        critere.comparatif = Critere.EQUALS
        critere.attribut = Request."${attr}"
        critere.value = val
        criteriaSet.add(critere)
        
        if(state?.filters?.categoryIdFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_CATEGORY_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.filters.categoryIdFilter
            criteriaSet.add(critere)
        }
        if(state?.filters?.requestTypeIdFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_REQUEST_TYPE_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.filters.requestTypeIdFilter
            criteriaSet.add(critere)
        }
        if (attr != RequestState.ARCHIVED) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_STATE
            critere.comparatif = Critere.NEQUALS
            critere.value = RequestState.ARCHIVED
            criteriaSet.add(critere)
        }
        return [
            'all' : requestSearchService.get(criteriaSet, null, null, tasksShowNb, 0, false),
            'count' : requestSearchService.getCount(criteriaSet)
        ]
    }
}
