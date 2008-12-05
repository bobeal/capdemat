import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.util.Critere

class HomeController {

    def ecitizenService
    def instructionService
    
    IRequestService defaultRequestService
    ILocalAuthorityRegistry localAuthorityRegistry
    IPaymentService paymentService
    IDocumentService documentService
    
    Adult currentEcitizen
    
    def defaultAction = "index"
    
    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = {
        def result = [:];
        result.dashBoard = [:];
                            
        File infoFile = localAuthorityRegistry.getCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
            'information.html',false);
        
        if(infoFile.exists()) result.commonInfo = infoFile.text;
        
        result.dashBoard.requests = this.getTopFiveRequests();
        result.dashBoard.requests = ecitizenService.prepareRecords(result.dashBoard.requests);
        
        result.dashBoard.payments = preparePayments(this.getTopFivePayments());
        result.dashBoard.documents = prepareDocuments(this.getTopFiveDocuments());
        return result;
    }
    
    def preparePayments = { payments ->
        payments.all.each{
            payments.records.add([
                'id' : it.id,
                'initializationDate' : it.initializationDate,
                'state' : it.state.toString(),
                'bankReference' : it.bankReference,
                'amount' : it.euroAmount,
                'paymentMode' : message(code:"payment.mode."+it.paymentMode.toString())
            ]);
        }
        
        return payments;
    }
    
    def prepareDocuments = { docs ->
        docs.all.each{
            def current = it;
            docs.records.add([
                'id' : current.id,
                'creationDate' : current.creationDate,
                'endValidityDate' : current.endValidityDate,
                'state' : current.state.toString(),
                'subject' : instructionService.getActionPosterDetails(it.individualId),
                'title' : message(code:CapdematUtils.adaptDocumentTypeName(current.documentType.name))
            ]);
        }
        return docs;
    }
    
    def login = {
      return ['login': true, 'groups': CapdematUtils.requestGroup()]
    }

    def protected getTopFiveRequests = {
        
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        
        critere.comparatif = Critere.EQUALS;
        critere.attribut = Request.SEARCH_BY_HOME_FOLDER_ID;
        critere.value = this.currentEcitizen.homeFolder.id
        criteriaSet.add(critere)
        
        return [
            'all' : defaultRequestService.get(criteriaSet, 'creationDate', 'desc', 5, 0),
            'count' : defaultRequestService.getCount(criteriaSet),
            'records' : []
        ]
    }
    
    def protected getTopFivePayments = {
        return [
            'all' : paymentService.extendedGet(null, null, null, null, null, null, null, null, 
                this.currentEcitizen.homeFolder.id, null, 'initializationDate', 'desc', 5, 0),
            'count' : paymentService.getPaymentCount(null, null, null, null, null, null, null, 
                null, this.currentEcitizen.homeFolder.id, null),
            'records' : []
        ]
        
    }
    
    def protected getTopFiveDocuments = {
        return [
            'all': documentService.getHomeFolderDocuments(this.currentEcitizen.homeFolder.id, 5),
            'records' : []
        ]
    }
}
