import fr.cg95.cvq.business.users.Adult
import grails.converters.JSON
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.business.document.Document

class DocumentController {
    
    IHomeFolderService homeFolderService
    IDocumentService documentService
    
    Adult currentEcitizen
    
    def beforeInterceptor = {
        currentEcitizen = SecurityContext.getCurrentEcitizen()
    }

    def index = {
        def state = [:]
        def requests = [:]
        if (params.ps) state = JSON.parse(params.ps);
        
        
        
        return ([
            'state': state,
            'pageState' : (new JSON(state)).toString(),
        ]);
    }
    
    def protected getDocuments = {attr,val,state,params ->
        
        
        return [
            
        ]
    }
}
