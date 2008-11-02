import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext;

import grails.converters.JSON

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

    def taskBoard = {
            
   	       session["currentMenu"] = "taskBoard"

            Set<Critere> redCriteria = new HashSet<Critere>()
             
            Critere qualityRedCritere = new Critere()
            qualityRedCritere.attribut = "qualityType"
            qualityRedCritere.comparatif = Critere.EQUALS
            qualityRedCritere.value = "qualityTypeRed"
            redCriteria.add(qualityRedCritere)
              
            def redRequests = defaultRequestService.extendedGet(redCriteria, params.sort, params.dir, 
                    10, 0)
            
            Set<Critere> orangeCriteria = new HashSet<Critere>()
             
            Critere qualityOrangeCritere = new Critere()
            qualityOrangeCritere.attribut = "qualityType"
            qualityOrangeCritere.comparatif = Critere.EQUALS
            qualityOrangeCritere.value = "qualityTypeOrange"
            orangeCriteria.add(qualityOrangeCritere)
              
            def orangeRequests = defaultRequestService.extendedGet(orangeCriteria, params.sort, params.dir, 
                    10, 0)
               
            def currentAgent = SecurityContext.getCurrentAgent()
            def agentLogin = currentAgent.getLogin()
            def requestMap = [:]
            def agentTasksMap = 
            	agentService.extendedGetAgentTasks(agentLogin,params.sort, params.dir, 10, 0)
            if (agentTasksMap != null)
            	requestMap.putAll(agentTasksMap)
            
            requestMap.put("cvq.tasks.qualityOrange",orangeRequests)
            requestMap.put("cvq.tasks.qualityRed",redRequests)
                 
            render (view:'taskBoard', model:["requestMap":requestMap,
                                           "allCategories":categoryService.getAll(),
                                           "allRequestTypes":translatedAndSortRequestTypes()])
    }
    
    def translatedAndSortRequestTypes() {
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([id:it.id, label:translationService.getEncodedRequestTypeLabelTranslation(it.label)])
        }
        return allRequestTypesTranslated.sort{it.label}
    }
    
    def initSearchReferential() {
    	return ['allStates':RequestState.allRequestStates,
    	        'allAgents':agentService.getAll(),
                'allCategories':categoryService.getAll(),
                'allRequestTypes':translatedAndSortRequestTypes()]
    }
}
