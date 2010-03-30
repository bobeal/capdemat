import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.translation.ITranslationService

class InstructionService {
    
    IAgentService agentService
    IIndividualService individualService
    ITranslationService translationService
    
    def getActionPosterDetails(posterId, withNature = false) {
        def displayName
        def nature
        if (posterId == null || posterId.equals("")) {
            displayName = ""
            nature = ""
        } else if (posterId == -1) {
            nature = "system"
            displayName = translationService.translate(nature)
        } else {
            def poster
            try {
                poster = this.agentService.getById(Long.valueOf(posterId))
                nature = "agent"
            } catch (CvqObjectNotFoundException) {}
            if (!poster) {
                try {
                    poster = this.individualService.getById(Long.valueOf(posterId))
                    nature = "eCitizen"
                } catch (CvqObjectNotFoundException) {}
            }
            if (poster) displayName = "${poster.firstName} ${poster.lastName}"
            else displayName = null
        }
        if (withNature) return ["displayName" : displayName, "nature" : nature]
        else return displayName
    }
}
