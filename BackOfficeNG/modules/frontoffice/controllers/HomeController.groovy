import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.users.payment.Payment
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqDisabledAccountException
import fr.cg95.cvq.exception.CvqUnknownUserException
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.security.annotation.ContextType
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.util.quering.sort.SortDirection

class HomeController {

    def requestAdaptorService
    def instructionService
    def requestTypeAdaptorService
    def securityService
    
    IRequestService defaultRequestService
    IRequestActionService requestActionService
    ILocalAuthorityRegistry localAuthorityRegistry
    IHomeFolderService homeFolderService
    IPaymentService paymentService
    IDocumentService documentService
    IAuthenticationService authenticationService
    
    Adult currentEcitizen

    def resultsPerList = 5
    def defaultAction = 'index'
    
    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen()
    }
    
    def test = {
    	['result':'ok']
    }
    
    def index = {
        def result = [:]
        result.dashBoard = [:]
                            
        File infoFile = localAuthorityRegistry.getCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
            'information.html',false)
        
        if(infoFile.exists()) result.commonInfo = infoFile.text
        
        result.dashBoard.lastRequests = requestAdaptorService.prepareRecords(this.getTopFiveRequests())
        result.dashBoard.lastRequests.records.each {
            it.lastAgentNote = requestAdaptorService.prepareNote(
                defaultRequestService.getLastAgentNote(it.id, null))
        }
        result.dashBoard.incompleteRequests = requestAdaptorService
            .prepareRecords(getLastIncompleteRequests())
        result.dashBoard.incompleteRequests.records.each {
            it.lastAgentNote = requestAdaptorService.prepareNote(
                    defaultRequestService.getLastAgentNote(it.id, null))
        }
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
            catch (CvqUnknownUserException e) {error='account.error.unknownUser'}
            catch (CvqAuthenticationFailedException e) {error='account.error.authenticationFailed'}
            catch (CvqDisabledAccountException e) {error='account.error.disabledAccount'}
            
            if(result && result instanceof HomeFolder) {
            	securityService.setEcitizenSessionInformation(params.login, session)
                
                if (params.requestTypeLabel == null) {
                    redirect(controller:'frontofficeHome')
                    return false
                } else {
                    redirect(uri:'/frontoffice/requestCreation?label=' + params.requestTypeLabel)
                    return false
                }
            }
        }
        if (params.requestTypeLabel == null) {
            return ['isLogin': true, 'error': message(code:error),
                    'groups': requestTypeAdaptorService.getDisplayGroups(false,null)]
        } else {
            flash.loginError = message(code:error)
            redirect(uri:'/frontoffice/requestCreation?label=' + params.requestTypeLabel)
            return false
        }
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

    def protected getLastIncompleteRequests() {
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        critere.comparatif = Critere.EQUALS;
        critere.attribut = Request.SEARCH_BY_HOME_FOLDER_ID;
        critere.value = currentEcitizen.homeFolder.id
        criteriaSet.add(critere)
        critere.attribut = Request.SEARCH_BY_STATE
        critere.value = RequestState.UNCOMPLETE
        criteriaSet.add(critere)
        return [
            'all' : defaultRequestService.get(criteriaSet, Request.SEARCH_BY_CREATION_DATE,
                , SortDirection.DESC.value(), -1, 0),
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
