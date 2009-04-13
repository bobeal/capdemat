import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.service.authority.ILocalReferentialService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.request.IRequestServiceRegistry


public class RequestTypeAdaptorService {
    
    IRequestTypeService requestTypeService
    IRequestServiceRegistry requestServiceRegistry
    ILocalReferentialService localReferentialService

    public Map getDisplayGroups(Boolean loggedContext, HomeFolder homeFolder) {
        def result = [:]
        
        for(DisplayGroup dg : requestTypeService.getAllDisplayGroups()) {
            if(!result.keySet().contains(dg.name))
                result[dg.name] = ['label':dg.label,'requests':[]]
            
            for(RequestType rt : dg.requestTypes) {

            	if (!rt.active)
            		continue
            		
                def messages = [], factor = true
                IRequestService service = requestServiceRegistry.getRequestService(rt.label);
                
                factor = eval(factor && (service.supportUnregisteredCreation() || loggedContext),
                    'requestType.message.onlyRegisteredUsers',messages)
                factor = eval(factor && (requestTypeService.isRegistrationOpen(rt.id)),
                    'requestType.message.registrationClosed',messages)
                
                if(homeFolder && service.subjectPolicy != IRequestService.SUBJECT_POLICY_NONE) {
                    factor = eval(factor && (!service.getAuthorizedSubjects(homeFolder.id)?.isEmpty()),
                        'requestType.message.noAuthorizedSubjects',messages)
                }
                
                result[dg.name].requests.add([
                                              'label':rt.label,
                                              'enabled':factor,
                                              'message':!messages.isEmpty() ? messages.get(0) : null
                                          ])
            }
            
            result[dg.name].requests = result[dg.name].requests.sort{it -> it.label}
        }

        // filter groups with no requests
        def tempMap = result.findAll { k,v ->
        	!v.requests.isEmpty()
        }

		return tempMap
    }

    public Map getLocalReferentialTypes(requestTypeLabel) {
        def result = [:]
        try {
            localReferentialService.getLocalReferentialDataByRequestType(requestTypeLabel).each {
                result.put(StringUtils.firstCase(it.dataName,'Lower'), it)
            }
        } catch (CvqException ce) { /* No localReferentialData found ! */ }

        return result
    }


    protected Boolean eval(Boolean exp, String message, List coll) {
        if(!exp) coll.add(message)
        return exp
    }
}