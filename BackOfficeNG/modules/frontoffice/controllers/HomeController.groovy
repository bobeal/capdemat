import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.users.payment.Payment
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqDisabledAccountException
import fr.cg95.cvq.exception.CvqUnknownUserException
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.security.annotation.ContextType

class HomeController {

    def requestAdaptorService
    def instructionService
    def requestTypeAdaptorService
    
    IRequestService defaultRequestService
    IRequestActionService requestActionService
    ILocalAuthorityRegistry localAuthorityRegistry
    IHomeFolderService homeFolderService
    IPaymentService paymentService
    IDocumentService documentService
    IAuthenticationService authenticationService
    
    Adult currentEcitizen

    def resultsPerList = 5
    def defaultAction = "index" 
    
    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen()
    }
    
    def index = {
        def result = [:]
        result.dashBoard = [:]
                            
        File infoFile = localAuthorityRegistry.getCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
            'information.html',false)
        
        if(infoFile.exists()) result.commonInfo = infoFile.text
        
        result.dashBoard.requests = requestAdaptorService.prepareRecords(this.getTopFiveRequests())
        result.dashBoard.drafts =
            requestAdaptorService.prepareRecords(this.getTopFiveRequests(draft:true))
        result.dashBoard.drafts.records.each {
            if (requestActionService.hasAction(it.id,
                IRequestActionService.DRAFT_DELETE_NOTIFICATION)) {
                it.displayDraftWarning = true
                it.draftExpirationDate = it.creationDate +
                    SecurityContext.currentSite.draftLiveDuration
            }
        }

        result.dashBoard.payments = preparePayments(this.getTopFivePayments())
        result.dashBoard.documents = prepareDocuments(this.getTopFiveDocuments())
        return result
    }
    
    def login = {
        def error = '', result = null
        if(request.post) {
            try { result = authenticationService.authenticate(params.login,params.password) } 
            catch (CvqUnknownUserException e) {error='error.unknownUser'}
            catch (CvqAuthenticationFailedException e) {error='error.authenticationFailed'}
            catch (CvqDisabledAccountException e) {error='error.disabledAccount'}
            
            if(result && result instanceof HomeFolder) {
                session.currentEcitizen = params.login
                session.frontContext = ContextType.ECITIZEN
                
                SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT)
                SecurityContext.setCurrentEcitizen(session.currentEcitizen)
                
                redirect(controller:'frontofficeHome')
                return false
            }
        }
        return [
            'isLogin': true,
            'error': message(code:error),
            'groups': requestTypeAdaptorService.getDisplayGroups(false,null)
        ]
    }
    
    def logout = {
        session.frontContext = null
        session.currentEcitizen = null
        redirect(controller:'frontofficeHome')
    }
    
    def loginAgent = {
        if(session.currentUser) {
            session.currentEcitizen = params.login
            SecurityContext.setCurrentEcitizen(params.login)
            session.frontContext = ContextType.AGENT
            
            redirect(controller:'frontofficeRequestType')
            return false            
        } else {
            redirect(controller:'frontofficeHome')
            return false
        }
    }
    
    def protected preparePayments(payments) {
        payments.all.each {
            payments.records.add([
                'id' : it.id,
                'initializationDate' : it.initializationDate,
                'state' : it.state.toString(),
                'bankReference' : it.bankReference,
                'amount' : it.euroAmount,
                'paymentMode' : message(code:"payment.mode."+it.paymentMode.toString())
            ])
        }
        
        return payments
    }
    
    def protected prepareDocuments(docs) {
        docs.all.each { doc ->
            docs.records.add([
                'id' : doc.id,
                'creationDate' : doc.creationDate,
                'endValidityDate' : doc.endValidityDate,
                'state' : doc.state.toString(),
                'subject' : instructionService.getActionPosterDetails(doc.individualId),
                'title' : message(code:CapdematUtils.adaptDocumentTypeName(doc.documentType.name))
            ])
        }

        return docs
    }
    
    
    def protected getTopFiveRequests(draft=false) {
        
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        
        critere.comparatif = Critere.EQUALS;
        critere.attribut = Request.SEARCH_BY_HOME_FOLDER_ID;
        critere.value = currentEcitizen.homeFolder.id
        criteriaSet.add(critere)
        
        if(draft) {
            critere.comparatif = Critere.EQUALS;
            critere.attribut = Request.DRAFT;
            critere.value = true
            criteriaSet.add(critere)
        }
        
        return [
            'all' : defaultRequestService.get(criteriaSet, 'creationDate', 'desc', 
                draft ? -1 : resultsPerList, 0),
            'count' : defaultRequestService.getCount(criteriaSet),
            'records' : []
        ]
    }
    
    def protected getTopFivePayments() {
        
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        
        critere.comparatif = Critere.EQUALS;
        critere.attribut = Payment.SEARCH_BY_HOME_FOLDER_ID;
        critere.value = currentEcitizen.homeFolder.id
        criteriaSet.add(critere)

        return [
            'all' : paymentService.get(criteriaSet, 'initializationDate', 'desc', 
                resultsPerList, 0),
            'count' : paymentService.getCount(criteriaSet),
            'records' : []
        ]
        
    }
    
    def protected getTopFiveDocuments() {
        return [
            'all': documentService.getHomeFolderDocuments(this.currentEcitizen.homeFolder.id, 
                resultsPerList),
            'records' : []
        ]
    }
}
