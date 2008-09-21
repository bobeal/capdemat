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
    
    def supportedKeys = ["requesterLastName", "id", "homeFolderId", 
                         "state", "lastInterveningAgentId", "requestType", "categoryId"]
    def longKeys = ["id", "homeFolderId", "requestType", "lastInterveningAgentId", 
                    "categoryId"]
    def defaultSortBy = 'creationDate'
    def resultsPerPage = 15
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
        
    def initSearch = {
    	// TODO : this should be cached 
    	def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  [:]
        allRequestTypes.each {
    		allRequestTypesTranslated[it.id] = translationService.getEncodedRequestTypeLabelTranslation(it.label)
    	}
    	def filters = [:]
        render(view:'search', model:[allStates:RequestState.allRequestStates,
         allAgents:agentService.getAll(),
         allCategories:categoryService.getAll(),
         allRequestTypes:allRequestTypesTranslated,
         mode:'simple',
         'sortBy':defaultSortBy,
         'filters':filters])
    }
    
    def search = {
       
        // deal with search criteria
        Set<Critere> criteria = new HashSet<Critere>()
        params.each { key,value ->
        	if (supportedKeys.contains(key) && value != "") {
        		Critere critere = new Critere()
        		critere.attribut = key
        		critere.comparatif = Critere.EQUALS
        		if (longKeys.contains(key))
        			critere.value = Long.valueOf(value)
        		else
        			critere.value = value
        		criteria.add(critere)
                log.debug "added criteria ${value} to ${key}"
        	}
        }
        
        // deal with dynamic filters
        def filters = [:]
        if (params.filterBy && params.filterBy != '') {
        	params.filterBy?.split('@').each { filter ->
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
        
        def filterBy = ''
       	filters.each { key, value ->
       		Critere critere = new Critere()
       		critere.attribut = key.replaceAll("Filter","")
       		critere.comparatif = Critere.EQUALS
       		critere.value = Long.valueOf(value)
       		criteria.add(critere)
       		log.debug "added criteria ${Long.valueOf(value)} to ${key.replaceAll('Filter','')} (dynamic filter)"
            filterBy += '@' + key + '=' + value
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

        // fill referential
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  [:]
        allRequestTypes.each {
            allRequestTypesTranslated[it.id] = translationService.getEncodedRequestTypeLabelTranslation(it.label)
        }
        def allStates = RequestState.allRequestStates
        def allAgents = agentService.getAll()
        def allCategories = categoryService.getAll()

        render(view:'search', 
        	model:['records':recordsList,
        	       'recordsReturned':requests.size(),
                   'totalRecords':defaultRequestService.getCount(criteria),
                   
                   'filters':filters,                   
                   'filterBy':filterBy,
                   'mode':params.mode,
                   'recordOffset':recordOffset,
                   'sortBy':sortBy,
                   'dir':params.dir,
                   
                   'allStates':allStates,
                   'allAgents':allAgents,
                   'allCategories':allCategories,
                   'allRequestTypes':allRequestTypesTranslated])
    }

    def taskBoard = {
            
            def allRequestTypes = defaultRequestService.getAllRequestTypes()
            def allRequestTypesTranslated =  [:]
            allRequestTypes.each {
                allRequestTypesTranslated[it.id] = translationService.getEncodedRequestTypeLabelTranslation(it.label)
            }

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
            def requestMap = agentService.extendedGetAgentTasks(agentLogin,params.sort, params.dir, 
                    10, 0)
            
            requestMap.put("cvq.tasks.qualityOrange",orangeRequests)
            requestMap.put("cvq.tasks.qualityRed",redRequests)
                 
            render (view:'taskBoard', model:["requestMap":requestMap,
                                           "allCategories":categoryService.getAll(),
                                           "allRequestTypes":allRequestTypesTranslated])
    }
}
