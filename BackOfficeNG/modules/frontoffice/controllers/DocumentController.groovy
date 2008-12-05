import fr.cg95.cvq.business.users.Individualimport fr.cg95.cvq.service.document.IDocumentTypeServiceimport fr.cg95.cvq.business.document.DocumentTypeimport fr.cg95.cvq.business.document.DocumentStateimport java.lang.Objectimport java.lang.Stringimport java.util.Hashtableimport fr.cg95.cvq.business.users.Adult
import grails.converters.JSON
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.business.document.Document

class DocumentController {
    
    IHomeFolderService homeFolderService
    IDocumentService documentService
    IDocumentTypeService documentTypeService    InstructionService instructionService    
    Adult currentEcitizen
    int maxRows    
    def beforeInterceptor = {
        currentEcitizen = SecurityContext.getCurrentEcitizen()        maxRows = 10
    }    
    def index = {
        def state = [:]
        def requests = [:]        
        if (params.ps) state = JSON.parse(params.ps)        if (params.df != null) state.df = params.df;        if (params.nf != null) state.nf = params.nf;        if (params.sf != null) state.sf = params.sf;
        
        return ([
            'state': state,            'documents' : this.getDocuments(state,params),
            'pageState' : (new JSON(state)).toString(),            'individuals' : this.getIndividuals(),            'states': DocumentState.allDocumentStates.collect{it.toString().toLowerCase()},            'types' : this.getTypes(),            'maxRows': maxRows
        ])
    }
    
    def protected getDocuments = {state,params ->        def result = []
        def criterias = new Hashtable<String,Object>();        int offset = !params?.offset ? 0 : Integer.parseInt(params.offset)                        if(state?.df) criterias.put("documentType.id",Long.valueOf(state.df))        if(state?.sf) criterias.put("state",DocumentState.forString(StringUtils.firstCase(state.sf,'')))        if(state?.nf == currentEcitizen.homeFolder.id.toString())             criterias.put('homeFolderId',Long.valueOf(state.nf))        else if(state?.nf)            criterias.put('individualId',Long.valueOf(state.nf))                this.documentService.search(criterias,maxRows,offset).each{            Individual sbj;            if(it?.individualId != null) sbj = this.individualService.getById(it.individualId)            result.add([                'id' : it.id,                'creationDate' : it.creationDate,                'certified' : it.certified,                'endValidityDate' : it.endValidityDate,                'state' : it.state.toString(),                'subject' : sbj?.firstName,                'name' : it.documentType.name,                'depositType' : it.depositType,                'depositOrigin' : it.depositOrigin,                'depositor' : this.instructionService.getActionPosterDetails(it.depositId),                'title' : message(code: CapdematUtils.adaptDocumentTypeName(it.documentType.name))            ]);        }
        
        return [
            'all' : result,            'count' : this.documentService.searchCount(criterias)
        ]
    }        def protected getTypes = {        def result = []        this.documentTypeService.allDocumentTypes.each{            result.add([                id: it.id,                name: message(code:CapdematUtils.adaptDocumentTypeName(it.name))            ])        }        return result    }        def protected getIndividuals = {        def individuals = []                currentEcitizen.homeFolder.individuals.each{            individuals.add([                id : it.id,                fullName : "${it?.firstName}"            ])        }        individuals.add([            id:currentEcitizen.homeFolder.id,            fullName:message(code:'property.commonDocuments')        ])        return individuals    }
}
