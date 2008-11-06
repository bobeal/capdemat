import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.exception.*
import fr.cg95.cvq.service.authority.*
import fr.cg95.cvq.service.users.*

class InstructionService {
    IAgentService agentService
    IAdultService adultService
    
    def getActionPosterDetails = { posterId ->
        def poster
        try {
            poster = this.agentService.getById(Long.valueOf(posterId));
        }catch (CvqObjectNotFoundException) {}
        
        if(!poster){
            try {
                poster = this.adultService.getById(Long.valueOf(posterId));
            }catch (CvqObjectNotFoundException) {}
        }
        
        if(poster) return "${poster?.firstName} ${poster?.lastName}"
        else return 'Système'
    }
}
