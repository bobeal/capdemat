import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.document.ContentType
import fr.cg95.cvq.business.document.DocumentState
import fr.cg95.cvq.business.document.DocumentBinary
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.document.IDocumentTypeService

import java.util.Hashtable
import javax.servlet.http.HttpServletResponse
import grails.converters.JSON

class FrontofficeDocumentController {
    
    IDocumentService documentService
    IDocumentTypeService documentTypeService
    
    InstructionService instructionService
    DocumentAdaptorService documentAdaptorService
    
    Adult currentEcitizen
    int maxRows = 10
    
    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }

    def details = {
        def result = [:], prevPage = null, nextPage = null, index = 0
        Document document = documentService.getById(params.long('id'))
       
        if (params.isRequestCreation)
            result.isRequestCreation = true
        
        result.page = params.pn ? Integer.parseInt(params.pn) : 0
        result.actions = this.getActions(document)
        result.sessionUuid = params.sessionUuid
        
        def pages =  document.datas
        prevPage = result.page > 0 ? result.page - 1 : null
        nextPage = result.page < (pages.size() - 1) ? result.page + 1 : null
                
        def extension = ""
        if (!pages.isEmpty()) {
            extension = pages[0].contentType.extension
        }
        
        def messageLink = message(code:"document.message.showImage")
        if(pages[0].getContentType() == ContentType.PDF)
            messageLink = message(code: "document.message.downloadDocument")
        
        result.doc = [
            "id": document.id,
            "name": document.documentType.name,
            "title" : message(code: CapdematUtils.adaptDocumentTypeName(document.documentType.name)),
            "state": document.state,
            "depositType": document.depositType,
            "depositOrigin": document.depositOrigin,
            'depositor' : instructionService.getActionPosterDetails(document.depositId),
            "creationDate" : document.creationDate,
            "validationDate": document.validationDate,
            "endValidityDate": document.endValidityDate,
            "ecitizenNote": document.ecitizenNote,
            "agentNote": document.agentNote,
            'certified' : document.certified,
            'preview' : pages.get(result.page).getPreview(),
            'messageLink': messageLink,
            'numberOfPages': pages.size(),
            'extension': extension,
            'nextPage' : nextPage,
            'prevPage' : prevPage,
            'pagesTitle': StringUtils.firstCase(message(code:'property.page'),'')
        ]
        return result
    }
    
    def index = {
        def state = [:]
        
        if (params.ps) state = JSON.parse(params.ps)
        if (params.df != null) state.df = params.df;
        if (params.nf != null) state.nf = params.nf;
        if (params.sf != null) state.sf = params.sf;
        
        return ([
            'state': state,
            'documents' : this.getDocuments(state,params),
            'pageState' : (new JSON(state)).toString(),
            'individuals' : this.getIndividuals(),
            'states': DocumentState.allDocumentStates.findAll{DocumentState.DRAFT != it}.collect{it.toString().toLowerCase()},
            'types' : this.getTypes(),
            'maxRows': maxRows
        ])
    }
    
    def binary = {
        Document document = documentService.getById(params.long('id'))
        DocumentBinary binary = document.datas.get(params.pn ? Integer.valueOf(params.pn) : 0)
        if (binary.contentType.equals(ContentType.PDF))
            response.contentType = "application/pdf"
        else
            response.contentType = "image/png"
        response.outputStream << binary.data
    }
    
    def preview = {
            Document document = documentService.getById(params.long('id'))
            DocumentBinary binary = document.datas.get(params.pn ? Integer.valueOf(params.pn) : 0)
            if (binary.preview == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND)
            }
            response.contentType = "image/png"
            response.outputStream << binary.preview
    }
    
    def protected getActions(document) {
        def actions = []
        document.actions.each {
            actions.add(documentAdaptorService.adaptDocumentAction(it))
        }
        
        return actions
    }
    
    def protected getDocuments(state,params) {
        def result = []
        def criterias = new Hashtable<String,Object>();
        int offset = !params?.offset ? 0 : Integer.parseInt(params.offset)
                
        if (state?.df) criterias.put("documentType.id",Long.valueOf(state.df))
        if (state?.sf) criterias.put("state",DocumentState.forString(StringUtils.firstCase(state.sf,'')))
        if (state?.nf == currentEcitizen.homeFolder.id.toString()) 
            criterias.put('homeFolderId',Long.valueOf(state.nf))
        else if (state?.nf)
            criterias.put('individualId',Long.valueOf(state.nf))
        
        documentService.search(criterias,maxRows,offset).each {
            result.add([
                'id' : it.id,
                'creationDate' : it.creationDate,
                'certified' : it.certified,
                'endValidityDate' : it.endValidityDate,
                'state' : it.state.toString(),
                'subject' : instructionService.getActionPosterDetails(it.individualId),
                'depositType' : it.depositType,
                'depositOrigin' : it.depositOrigin,
                'depositor' : instructionService.getActionPosterDetails(it.depositId),
                'title' : message(code: CapdematUtils.adaptDocumentTypeName(it.documentType.name))
            ]);
        }
        
        return [
            'all' : result,
            'count' : documentService.searchCount(criterias)
        ]
    }
    
    def protected getTypes() {
        def result = []
        this.documentTypeService.allDocumentTypes.each{
            result.add([
                id: it.id,
                name: message(code:CapdematUtils.adaptDocumentTypeName(it.name))
            ])
        }
        return result.sort {it.name}
    }
    
    def protected getIndividuals() {
        def individuals = []
        
        currentEcitizen.homeFolder.individuals.each{
            individuals.add([
                id : it.id,
                fullName : instructionService.getActionPosterDetails(it.id)
            ])
        }
        individuals = individuals.sort {it.fullName}
        individuals.add([
            id:currentEcitizen.homeFolder.id,
            fullName:message(code:'document.property.commonDocuments')
        ])
        return individuals
    }

    protected List getOrderedDocumentPages(document) {
        def result = []
        documentService.getAllPages(document.id).each{result.add(it.pageNumber)}
        return result.sort()
    }
}
