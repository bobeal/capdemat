import java.util.ArrayList;
import java.util.Hashtable;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestStatisticsService
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext;

import grails.converters.*

class RequestController {
    InstructionService instructionService
    EcitizenService ecitizenService
    IAgentService agentService
    IHomeFolderService homeFolderService
    ICategoryService categoryService
    IRequestService defaultRequestService
    IRequestStatisticsService requestStatisticsService
    
    def translationService
    
    def defaultAction = "index"
    
    
    def beforeInterceptor = {}
    
    
    def index = {
        def state = [:];
        def pageState = "";
        def requests = [:];
        def method = request.getMethod().toLowerCase();
        Adult adult = SecurityContext.getCurrentEcitizen();
        //println individuals
        
        if(params?.ps) state = JSON.parse(params.ps);
        if(params.typeFilter != null) state.typeFilter = params.typeFilter;
        if(params.stateFilter != null)state.stateFilter = params.stateFilter;
        if(params.indvFilter != null) state.indvFilter = params.indvFilter;
        
        requests = filterRequests("SEARCH_BY_HOME_FOLDER_ID",adult.homeFolder.id,state,params);
        requests = ecitizenService.prepareRecords(requests);
        
        return ([
            'state': state,
            'pageState' : (new JSON(state)).toString(),
            'individuals': adult.homeFolder.individuals.each{ it.id },
            'allRequestTypes' : translatedAndSortRequestTypes(),
            'requests': requests,
            'requestStates' : RequestState.allRequestStates.collect{ it.toString().toLowerCase()}
        ]);
    }
    
    
    protected translatedAndSortRequestTypes() {
        def allRequestTypes = defaultRequestService.getAllRequestTypes()
        def allRequestTypesTranslated =  []
        allRequestTypes.each {
            allRequestTypesTranslated.add([id:it.id, label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML()])
        }
        return allRequestTypesTranslated.sort{it.label}
    }
    
    protected filterRequests = {attr,val,state,params ->
        Set criteriaSet = new HashSet<Critere>()
        Critere critere = new Critere()
        
        critere.comparatif = Critere.EQUALS
        critere.attribut = Request."${attr}"
        critere.value = val
        criteriaSet.add(critere)
        
        if(state?.stateFilter) {
            critere = new Critere()
            critere.attribut = Request.SEARCH_BY_STATE
            critere.comparatif = critere.EQUALS
            critere.value = StringUtils.firstCase(state.stateFilter,'')
            criteriaSet.add(critere)
        }
        if(state?.typeFilter) {
            critere = new Critere()
            critere.attribut = "requestType"
            critere.comparatif = critere.EQUALS
            critere.value = state.typeFilter
            criteriaSet.add(critere)
        }
        def max = 10;
        def offset = 0;
        
        if(params?.max) max = Integer.valueOf(params.max);
        if(params?.offset)offset = Integer.valueOf(params.offset);
        
        //println "\n\n\n\n\n\n\n$max\n\n\n\n\n\n\n"
        return [
            'all' : defaultRequestService.extendedGet(criteriaSet, null, null, max, offset),
            'count' : defaultRequestService.getCount(criteriaSet),
            'records' : []
        ]
    }
}
