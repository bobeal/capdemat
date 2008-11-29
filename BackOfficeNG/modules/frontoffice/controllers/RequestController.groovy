import java.util.ArrayList;
import java.util.Hashtable;

import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.security.SecurityContext;

import grails.converters.*

class RequestController {
    
    def ecitizenService
    IRequestService defaultRequestService
    
    def translationService
    
    def defaultAction = "index"
    
    def beforeInterceptor = {}
    
    def index = {
        def state = [:]
        def requests = [:]
        Adult adult = SecurityContext.getCurrentEcitizen()
        
        if (params.ps) state = JSON.parse(params.ps);
        if (params.typeFilter != null) state.typeFilter = params.typeFilter;
        if (params.stateFilter != null) state.stateFilter = params.stateFilter;
        if (params.indvFilter != null) state.indvFilter = params.indvFilter;
        
        requests = filterRequests("SEARCH_BY_HOME_FOLDER_ID",adult.homeFolder.id,state,params)
        requests = ecitizenService.prepareRecords(requests)
        
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
            allRequestTypesTranslated.add([id:it.id,
                                           label:translationService.getEncodedRequestTypeLabelTranslation(it.label).decodeHTML()])
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
            critere.attribut = Request.SEARCH_BY_REQUEST_TYPE_ID
            critere.comparatif = critere.EQUALS
            critere.value = state.typeFilter
            criteriaSet.add(critere)
        }
        def max = 10;
        def offset = 0;
        
        if(params?.max) max = Integer.valueOf(params.max);
        if(params?.offset)offset = Integer.valueOf(params.offset);
        
        return [
            'all' : defaultRequestService.get(criteriaSet, null, null, max, offset),
            'count' : defaultRequestService.getCount(criteriaSet),
            'records' : []
        ]
    }
}
