import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.users.IIndividualService

class InstructionService {
    
    IAgentService agentService
    IIndividualService individualService
    
    def getActionPosterDetails(posterId) {
    
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
    

}
