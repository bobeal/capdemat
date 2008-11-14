import java.util.Hashtable;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext;

import grails.converters.*
import groovy.util.Expando;

class RequestController {

    IAgentService agentService
    ICategoryService categoryService
    IRequestService defaultRequestService
    IRequestStatisticsService requestStatisticsService
    
    def translationService
    
    def defaultAction = "initSearch"
    
    def supportedKeys = ["requesterLastName", "id", "homeFolderId", "creationDateFrom", "creationDateTo"]
    def longKeys = ["id", "homeFolderId"]
    def dateKeys = ["creationDateFrom", "creationDateTo"]
    def defaultSortBy = 'creationDate'
    def resultsPerPage = 15
    // default number of tasks to show per type
    def tasksShowNb = 5 
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
        
    /**
     * Called when first entering the search screen
     */
    def initSearch = {

        render(view:'search', model:['mode':'simple',
                                     'inSearch':false,
                                     'sortBy':defaultSortBy,
                                     'filters':[:]].plus(initSearchReferential()))
    }
    
    /**
     * Called asynchronously when switching from simple to advanced search mode and vice versa
     */
    def loadSearchForm = {
    		def model = ['totalRecords':params.totalRecords,
                         'recordOffset':params.recordOffset,
                         'recordsReturned':params.recordsReturned,
                         'sortBy':params.sortBy,
                         'filterBy':params.filterBy].plus(initSearchReferential())

    		if (params.formType == 'simple') {
    			model['mode'] = 'simple'
    			render(template:'simpleSearchForm', model:model)
    		} else {
    			model['mode'] = 'advanced'
    			render(template:'advancedSearchForm', model:model)
    		}
    }
    
    /**
     * Called (synchronously) when performing a search
     */
    def search = {
       
        // deal with search criteria
        Set<Critere> criteria = new HashSet<Critere>()
        params.each { key,value ->
            if (supportedKeys.contains(key) && value != "") {
                Critere critere = new Critere()
                critere.attribut = key
                critere.comparatif = Critere.EQUALS
                if (longKeys.contains(key)) {
                    critere.value = Long.valueOf(value)
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
                    critere.value = value
                }
                criteria.add(critere)
            }
        }
        
        // deal with dynamic filters
        def parsedFilters = SearchUtils.parseFilters(params.filterBy)
        parsedFilters.filters.each { key, value ->
            Critere critere = new Critere()
            critere.attribut = key.replaceAll("Filter","")
            critere.comparatif = Critere.EQUALS
            if (key == 'stateFilter')
                critere.value = value
            else if(key == 'qualityFilter') {
                println "qualityType${value}"
                critere.attribut = "qualityType"
                critere.value = "qualityType"+value
            }
            else
                critere.value = Long.valueOf(value)
            criteria.add(critere)
        }
        
        // deal with dynamic sorts
        def sortBy = params.sortBy ? params.sortBy : defaultSortBy 
        log.debug "added sort on ${sortBy}"
        
        // deal with pagination settings
        def results = params.results == null ? resultsPerPage : Integer.valueOf(params.results)
        def recordOffset = 
            (params.recordOffset == "" || params.recordOffset == null) ? 0 : Integer.valueOf(params.recordOffset)        
            
        // now, perform the search request
        def requests = defaultRequestService.extendedGet(criteria, sortBy, params.dir, 
                results, recordOffset)
        def recordsList = []
        requests.each {
            def agent = it.lastInterveningAgentId ? agentService.getById(it.lastInterveningAgentId) : null
            def quality = 'green'
            if (it.redAlert)
                quality = 'red'
            else if (it.orangeAlert)
                quality = 'orange'
            def record = [
                'id':it.id,
                'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
                'creationDate':DateUtils.formatDate(it.creationDate),
                'requesterLastName':it.requester.lastName + " " + it.requester.firstName,
                'subjectLastName':it.subject ? it.subject.lastName + " " + it.subject.firstName : "",
                'homeFolderId':it.homeFolder.id,
                'state':it.state.toString(),
                'lastModificationDate':it.lastModificationDate == null ? "" :  DateUtils.formatDate(it.lastModificationDate),
                'lastInterveningAgentId': agent ? agent.lastName + " " + agent.firstName : "",
                'permanent':!it.homeFolder.boundToRequest,
                'quality':quality
            ]
            recordsList.add(record)
        }
        
        render(view:'search', 
            model:['records':recordsList,
                   'recordsReturned':requests.size(),
                   'totalRecords':defaultRequestService.getCount(criteria),
                   'filters':parsedFilters.filters,
                   'filterBy':parsedFilters.filterBy,
                   'mode':params.mode,
                   'recordOffset':recordOffset,
                   'sortBy':sortBy,
                   'dir':params.dir,
                   'inSearch':true].plus(initSearchReferential()))
    }

    /**
     * Called when asking for the agent's task board
     */
    def taskBoard = {
        def state = [:]
        def pageState = ""
        def dynamicFilter = new Expando()
        def method = request.getMethod().toLowerCase()
        Agent agent = SecurityContext.getCurrentAgent()
        
        state['displayForm'] = agentService.getPreferenceByKey('display', agent)?.displayForm?.split(",") as List
        if(state['displayForm'] == null)
            state['displayForm'] = ['Late','Alert','New','Last','Validated'] //.each{it = "display${it}Requests"}
        
        if(method == 'get') {
            state['defaultDisplay'] = state['displayForm']
            state['filters'] = ['categoryFilter':'','requestTypeFilter':'']
        } else { 
            state = JSON.parse(params?.pageState);
        }
        
        if(state?.modifyDisplay == true) {
            Hashtable<String, String> hash = new Hashtable<String, String>()
            hash.put('displayForm', state?.displayForm?.join(",").replace('\"',''))
            agentService.modifyPreference('display',hash, agent)
            state.modifyDisplay = null
            state['defaultDisplay'] = state['displayForm']
            state['message'] = message(code:"message.updateDone")
        }
        
        pageState = (new JSON(state)).toString();
        
        dynamicFilter.getRequests = {attr,val ->
            Set criteriaSet = new HashSet<Critere>()
            Critere critere = new Critere()
            
            critere.comparatif = Critere.EQUALS
            critere.attribut = Request."${attr}"
            critere.value = val
            criteriaSet.add(critere)
            
            if(state?.filters?.categoryFilter) {
                critere = new Critere()
                Category cat = categoryService.getById(Long.valueOf(state?.filters?.categoryFilter))
                critere.attribut = Request.SEARCH_BY_CATEGORY_NAME
                critere.comparatif = critere.EQUALS
                critere.value = cat.name
                criteriaSet.add(critere)
            }
            
            if(state?.filters?.requestTypeFilter) {
                critere = new Critere()
                RequestType type = defaultRequestService.getRequestTypeById(Long.valueOf(state?.filters?.requestTypeFilter))
                critere.attribut = Request.SEARCH_BY_REQUEST_TYPE_LABEL
                critere.comparatif = critere.EQUALS
                critere.value = type.label
                criteriaSet.add(critere)
            }
            return [
                'all' : defaultRequestService.extendedGet(criteriaSet, null, null, tasksShowNb, 0),
                'count' : defaultRequestService.getCount(criteriaSet)
            ]
        }
        session["currentMenu"] = "taskBoard"
        
        def requestMap = [:]
        
        if(state?.displayForm?.contains('Late'))
            requestMap.redRequests = dynamicFilter.getRequests("SEARCH_BY_QUALITY_TYPE",Request.QUALITY_TYPE_RED);
        if(state?.displayForm?.contains('Alert'))
            requestMap.orangeRequests = dynamicFilter.getRequests("SEARCH_BY_QUALITY_TYPE",Request.QUALITY_TYPE_ORANGE);
        if(state?.displayForm?.contains('New'))
            requestMap.pendingRequests = dynamicFilter.getRequests("SEARCH_BY_STATE",RequestState.PENDING);
        if(state?.displayForm?.contains('Validated'))
            requestMap.validatedRequests = dynamicFilter.getRequests("SEARCH_BY_STATE",RequestState.VALIDATED);
        if(state?.displayForm?.contains('Last'))
            requestMap.lastRequests = dynamicFilter.getRequests("SEARCH_BY_LAST_INTERVENING_AGENT_ID",SecurityContext.currentUserId);
        
        render (view:'taskBoard', model:["requestMap":requestMap,
                                         "state" : state,
                                         "userId" : SecurityContext.currentUserId,
                                         "pageState" : pageState.encodeAsHTML(),
                                         "allCategories":categoryService.getAll(),
                                         "allRequestTypes":translatedAndSortRequestTypes()])
    }
    
    def translatedAndSortRequestTypes() {
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([id:it.id, label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML()])
            //allRequestTypesTranslated.add([id:it.id, label:translationService.getEncodedRequestTypeLabelTranslation(it.label)])
        }
        return allRequestTypesTranslated.sort{it.label}
    }
    
    def initSearchReferential() {
    	return ['allStates':RequestState.allRequestStates,
    	        'allAgents':agentService.getAll(),
                'allCategories':categoryService.getAll(),
                'allRequestTypes':translatedAndSortRequestTypes()]
    }
    
    protected saveAgentPreferences = { section, value, agent ->
        agentService.modifyPreference(section,value, agent)
    }
}
