import fr.cg95.cvq.business.document.DocumentTypeimport fr.cg95.cvq.business.document.DocumentStateimport java.lang.Objectimport java.lang.Stringimport java.util.Hashtableimport fr.cg95.cvq.business.users.Adult
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
        def requests = [:]        def individuals = []        
        if (params.ps) state = JSON.parse(params.ps)                currentEcitizen.homeFolder.individuals.each{            individuals.add([                id : it.id,                fullName : "${it?.firstName} ${it?.lastName}"            ])        }
                
        return ([
            'state': state,            'documents' : this.getDocuments(state,params),
            'pageState' : (new JSON(state)).toString(),            'individuals' : individuals,            'states': DocumentState.allDocumentStates.collect{it.toString().toLowerCase()},
        ]);
    }
    
    def protected getDocuments = {state,params ->
        def criterias = new Hashtable<String,Object>();        
        
        return [
            'all' : this.documentService.search(criterias),            'count' : this.documentService.searchCount(criterias)
        ]
    }
}
