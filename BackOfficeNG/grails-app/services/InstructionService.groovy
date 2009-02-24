import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestServiceRegistry
import fr.cg95.cvq.business.users.HomeFolder

class InstructionService {
    
    IAgentService agentService
    IIndividualService individualService
    IRequestService defaultRequestService
    IRequestServiceRegistry requestServiceRegistry
    
    
    def getActionPosterDetails = { posterId ->
    
        if (posterId == null || posterId.equals(""))
            return ''
        else if (posterId == -1)
            return 'Système'

        def poster
        try {
            poster = this.agentService.getById(Long.valueOf(posterId))
        } catch (CvqObjectNotFoundException) {}
        
        if (!poster) {
            try {
                poster = this.individualService.getById(Long.valueOf(posterId))
            } catch (CvqObjectNotFoundException) {}
        }

        if (poster) return "${poster.firstName} ${poster.lastName}"
        else return null
    }
    
    public Map getDisplayGroups(Boolean loggedContext, HomeFolder homeFolder) {
        def result = [:]
        
        for(DisplayGroup dg : this.defaultRequestService.getAllDisplayGroups()) {
            if(!result.keySet().contains(dg.name))
                result[dg.name] = ['label':dg.label,'requests':[]]
            
            for(RequestType rt : dg.requestTypes) {
                def messages = [], factor = true
                IRequestService service = requestServiceRegistry.getRequestService(rt.label);
                
                factor = eval(factor && (service.supportUnregisteredCreation() || loggedContext),
                    'requestType.message.onlyRegisteredUsers',messages)
                factor = eval(factor && (service.isRegistrationOpen(rt.id)),
                    'requestType.message.registrationClosed',messages)
                
                if(homeFolder && service.subjectPolicy != IRequestService.SUBJECT_POLICY_NONE) {
                    factor = eval(factor && (service.getAuthorizedSubjects(homeFolder.id)?.size() > 0),
                        'requestType.message.noAuthorizedSubjects',messages)
                }
                
                if(rt.active) {
                    result[dg.name].requests.add([
                        'label':rt.label,'enabled':
                        factor,'message':messages?.size() > 0 ? messages.get(0) : null
                    ])
                }
            }
            
            result[dg.name].requests = result[dg.name].requests.sort{it -> it.label}
        }
        
        return result
    }
    
    protected Boolean eval(Boolean exp, String message, List coll) {
        if(!exp) coll.add(message)
        return exp
    }
}
