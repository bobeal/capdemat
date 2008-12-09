import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.users.IIndividualService

class InstructionService {
    
    IAgentService agentService
    IIndividualService individualService
    IDocumentService documentService
    
    def getActionPosterDetails = { posterId ->
    
        if (posterId == null || posterId.equals(""))
            return ''
            
        if (posterId == -1)
            return 'Système'

        def poster
        try {
            poster = this.agentService.getById(Long.valueOf(posterId))
        }catch (CvqObjectNotFoundException) {}
        
        if (!poster) {
            try {
                poster = this.individualService.getById(Long.valueOf(posterId))
            }catch (CvqObjectNotFoundException) {}
        }
        
        if (poster) return "${poster?.firstName} ${poster?.lastName}"
        else return null
    }
    
    def getOrderedDocumentPages = { Document d ->
        def result = []
        documentService.getAllPages(d.id).each{result.add(it.pageNumber)}
        return result.sort();
    }
    
}
