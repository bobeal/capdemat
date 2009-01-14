import fr.cg95.cvq.business.document.Document
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.exception.CvqUnknownUserException
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqDisabledAccountException
import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.exception.CvqException

class HomeController {

    def requestAdaptorService
    def instructionService
    
    IRequestService defaultRequestService
    ILocalAuthorityRegistry localAuthorityRegistry
    IPaymentService paymentService
    IDocumentService documentService
    IAuthenticationService authenticationService
    
    Adult currentEcitizen
    
    def defaultAction = "index" 
    
    def beforeInterceptor = {
        //this['requestService'] = 'RAFIK';
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = {
        def result = [:];
        result.dashBoard = [:];
                            
        File infoFile = localAuthorityRegistry.getCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
            'information.html',false);
        
        if(infoFile.exists()) result.commonInfo = infoFile.text;
        
        result.dashBoard.requests = requestAdaptorService.prepareRecords(this.getTopFiveRequests());
        result.dashBoard.drafts = requestAdaptorService.prepareRecords(this.getTopFiveRequests(draft:true));
        
        result.dashBoard.payments = preparePayments(this.getTopFivePayments());
        result.dashBoard.documents = prepareDocuments(this.getTopFiveDocuments());
        return result;
    }
    
    def login = {
        def error = '', result
        if(request.post) {
            try { result = authenticationService.authenticate(params.login,params.password) } 
            catch (CvqUnknownUserException e) {error='error.unknownUser'}
            catch (CvqAuthenticationFailedException e) {error='error.authenticationFailed'}
            catch (CvqDisabledAccountException e) {error='error.disabledAccount'}
            
            if(result && result instanceof HomeFolder) { 
                session.currentUser = params.login
                redirect(controller:'frontofficeHome')
            }
        }
        return ['login': true,'error': message(code:error),'groups': CapdematUtils.requestGroup()]
    }
    
    def logout = {
        session.currentUser = null
        redirect(controller:'frontofficeHome')
    }
    
    def protected preparePayments = { payments ->
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
    
    def protected prepareDocuments = { docs ->
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
    
    
    def protected getTopFiveRequests(draft=false) {
        
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        
        critere.comparatif = Critere.EQUALS;
        critere.attribut = Request.SEARCH_BY_HOME_FOLDER_ID;
        critere.value = this.currentEcitizen.homeFolder.id
        criteriaSet.add(critere)
        
        if(draft) {
            critere.comparatif = Critere.EQUALS;
            critere.attribut = Request.DRAFT;
            critere.value = true
            criteriaSet.add(critere)
        }
        
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
