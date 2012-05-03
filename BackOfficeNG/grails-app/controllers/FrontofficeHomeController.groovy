import java.util.Random;
import java.util.UUID;

import fr.cg95.cvq.authentication.IAuthenticationService
import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.request.DisplayGroup
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.business.request.RequestActionType
import fr.cg95.cvq.business.request.RequestState
import fr.cg95.cvq.business.request.RequestType
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.payment.Payment
import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqDisabledAccountException
import fr.cg95.cvq.exception.CvqUnknownUserException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.security.annotation.ContextType
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.document.IDocumentService
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.service.request.IRequestNoteService
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.request.IRequestActionService
import fr.cg95.cvq.service.request.IRequestTypeService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere

class FrontofficeHomeController {

    def requestAdaptorService
    def instructionService
    def requestTypeAdaptorService
    def securityService
    
    IRequestNoteService requestNoteService
    IRequestSearchService requestSearchService
    IRequestActionService requestActionService
    IRequestTypeService requestTypeService
    ILocalAuthorityRegistry localAuthorityRegistry
    IHomeFolderService homeFolderService
    IPaymentService paymentService
    IDocumentService documentService
    IAuthenticationService authenticationService
    IIndividualService individualService
    
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
                            
        File infoFile = localAuthorityRegistry.getLocalAuthorityResourceFile(
            LocalAuthorityResource.INFORMATION_MESSAGE_FO.id)
        
        if(infoFile.exists()) result.commonInfo = infoFile.text
        
        result.dashBoard.lastRequests = requestAdaptorService.prepareRecords(this.getTopFiveRequests())
        result.dashBoard.lastRequests.records.each {
            it.lastAgentNote = requestAdaptorService.prepareNote(
                requestNoteService.getLastAgentNote(it.id, null))
        }
        result.dashBoard.incompleteRequests = requestAdaptorService
            .prepareRecords(getLastIncompleteRequests())
        result.dashBoard.incompleteRequests.records.each {
            it.lastAgentNote = requestAdaptorService.prepareNote(
                    requestNoteService.getLastAgentNote(it.id, null))
        }
        result.dashBoard.drafts =
            requestAdaptorService.prepareRecords(this.getTopFiveRequests(draft:true))
        def draftLiveDuration = requestTypeService.globalRequestTypeConfiguration.draftLiveDuration
        result.dashBoard.drafts.records.each {
            if (requestActionService.hasAction(it.id,
                RequestActionType.DRAFT_DELETE_NOTIFICATION)) {
                it.displayDraftWarning = true
                it.draftExpirationDate = it.creationDate + draftLiveDuration
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
            
            catch (CvqUnknownUserException e) {error='account.error.authenticationFailed'}
            catch (CvqAuthenticationFailedException e) {error='account.error.authenticationFailed'}
            catch (CvqDisabledAccountException e) {error='account.error.disabledAccount'}
            
            if(result && result instanceof HomeFolder) {
            	securityService.setEcitizenSessionInformation(params.login, session)
                
              

                def str1=authenticationService.encryptPassword(params.password)
                def str2=authenticationService.encryptPassword("bienvenue")
                if(str1.equals(str2))
                  {
                    redirect(controller:"frontofficeHomeFolder",action:"editPassword", params:['fcac':'ok'])
                  } else {               
                
                    if (params.requestTypeLabel == null) {
                        redirect(controller:'frontofficeHome')
                        return false
                    } else {
                        redirect(uri:'/frontoffice/requestCreation?label=' + params.requestTypeLabel)
                        return false
                    }
                  }
            }
        }
        if (params.requestTypeLabel == null) {
            return ['isLogin': true, 'error': message(code:error),
                    'groups': requestTypeAdaptorService.getDisplayGroups(null)]
        } else {
            flash.loginError = message(code:error)
            redirect(uri:'/frontoffice/requestCreation?label=' + params.requestTypeLabel)
            return false
        }
    }
    
    def logout = {
        session.frontContext = null
        session.currentEcitizen = null
        session.currentEcitizenName = null
        redirect(controller:'frontofficeHome')
    }
    
    def loginAgent = {
        if(session.currentUser) {
            session.frontContext = ContextType.AGENT
            if (params.login) {
                session.currentEcitizen = params.login
                SecurityContext.setCurrentEcitizen(params.login)
                if (params.requestTypeLabel)
                    redirect(controller:"frontofficeRequestCreation", params:[label:params.requestTypeLabel])
                else
                    redirect(controller:'frontofficeRequestType')
                return false
            } else {
                redirect(controller:"frontofficeRequestCreation", params:[label:params.requestTypeLabel])
                return false
            }
        } else {
            redirect(controller:'frontofficeHome')
            return false
        }
    }

    def accessibilityPolicy = {
        File file = localAuthorityRegistry.getLocalAuthorityResourceFile(
            LocalAuthorityResource.ACCESSIBILITY_POLICY_FO.id)
        def accessibilityPolicy = ''
        if (file.exists()) accessibilityPolicy = file.text
        return ['accessibilityPolicy':accessibilityPolicy]
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
        critere = new Critere()
        critere.comparatif = draft ? Critere.EQUALS : Critere.NEQUALS
        critere.attribut = Request.SEARCH_BY_STATE
        critere.value = RequestState.DRAFT
        criteriaSet.add(critere)
        
        return [
            'all' : requestSearchService.get(criteriaSet, 'creationDate', 'desc', 
                draft ? -1 : resultsPerList, 0, false),
            'count' : requestSearchService.getCount(criteriaSet),
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
            'all' : requestSearchService.get(criteriaSet,
                Request.SEARCH_BY_CREATION_DATE, "desc", -1, 0, false),
            'count' : requestSearchService.getCount(criteriaSet),
            'records' : []
        ]
    }

    def protected getTopFivePayments() {
        
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere(Payment.SEARCH_BY_HOME_FOLDER_ID, 
        		currentEcitizen.homeFolder.id, Critere.EQUALS);
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
