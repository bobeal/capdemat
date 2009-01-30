import fr.cg95.cvq.business.users.payment.PaymentState
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

import grails.converters.JSON
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.business.authority.LocalAuthority

class PaymentController {

    IPaymentService paymentService
    ILocalAuthorityRegistry localAuthorityRegistry
    
    def translationService
    def defaultAction = "search"
    
    def beforeInterceptor = { session["currentMenu"] = "payment" }

    def search = {
        def mode = params.mode == null ? 'simple' : params.mode
        [allStates:PaymentState.allPaymentStates,
         allBrokers:paymentService.getAllBrokers(null), mode:mode]
    }

    def configure = {
        def name = "paymentlackmessage.html"
        File file = localAuthorityRegistry.getCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.HTML_RESOURCE_TYPE,name,false)
            
        if(!file.exists()) {
            localAuthorityRegistry.saveLocalAuthorityResource(
                    ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
                    name,"".getBytes());
            file = localAuthorityRegistry.getCurrentLocalAuthorityResource(
                    ILocalAuthorityRegistry.HTML_RESOURCE_TYPE,name,false)
        }
        
        if(request.post) {
            def String content = (params.editor == null ? "" : params.editor.toString())
            localAuthorityRegistry.saveLocalAuthorityResource(
                    ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
                    name,content.getBytes());

            render([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } else {
            render(view:'configure',model:[editorContent:file.getText()])
        }
    }
    
    def setupDrafts = {
        def entity = [:]
        
        if(request.get) {
            LocalAuthority localAuthority = SecurityContext.getCurrentSite()
            entity.draftLiveDuration = localAuthority.draftLiveDuration
            entity.draftNotificationBeforeDelete = localAuthority.draftNotificationBeforeDelete
        } else {
            localAuthorityRegistry.updateDraftSettings(
                Integer.parseInt(params.draftLiveDuration),
                Integer.parseInt(params.draftNotificationBeforeDelete)
            )
            entity.draftLiveDuration = params.draftLiveDuration
            entity.draftNotificationBeforeDelete = params.draftNotificationBeforeDelete
            entity.posted = ['state':'success','message':message(code:"message.updateDone")]
        }
        return ["entity":entity]
    }

    def loadPayments = {
        def initDateFrom = (params.initDateFrom == null) ? null : DateUtils.stringToDate(params.initDateFrom)
        def initDateTo = (params.initDateTo == null) ? null : DateUtils.stringToDate(params.initDateTo)
        def paymentState = (params.paymentState == null) ? null : PaymentState.forString(params.paymentState)
        def homeFolderId = (params.homeFolderId == null) ? null : Long.valueOf(params.homeFolderId)
       
        def payments = paymentService.extendedGet(
                initDateFrom,initDateTo,initDateFrom,initDateTo,
                paymentState,params.cvqReference,params.bankReference,params.broker,
                homeFolderId,params.requesterLastName,
                params.sort, params.dir,10,0)
        def totalPaymentsCount = paymentService.getPaymentCount(initDateFrom,initDateTo,
            initDateFrom,initDateTo,paymentState,params.cvqReference,
            params.bankReference,params.broker,homeFolderId,params.requesterLastName)
        def recordsList = []
        payments.each {
            def record = [
                'id':it.id,
                'broker':it.broker,
                'cvqReference':it.cvqReference,
                'bankReference':it.bankReference,
                'requesterLastName':it.requester.lastName + " " + it.requester.firstName,
                'homeFolderId':it.homeFolder.id,
                'initializationDate':it.initializationDate,
                'commitDate':it.commitDate,
                'paymentState':it.state.toString(),
                'amount':it.getEuroAmount() + " &euro;",
                'paymentMode':it.paymentMode.toString()
            ]		
			recordsList.add(record)
        }
        render(template:'searchResults', model:[
                                                    'recordsReturned':payments.size(),
                                                    'totalRecords':totalPaymentsCount,
                                                    'startIndex':0,
                                                    'sort':params.sort,
                                                    'dir':params.dir,
                                                    'records':recordsList])        
    }
}
