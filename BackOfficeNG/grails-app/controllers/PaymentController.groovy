import fr.cg95.cvq.business.users.payment.PaymentState
import fr.cg95.cvq.payment.IPaymentService

import grails.converters.JSON

class PaymentController {

    IPaymentService paymentService
    def translationService
    def defaultAction = "search"
    
    def beforeInterceptor = {
        session["currentMenu"] = "payment"
    }

    def search = {
        def mode = params.mode == null ? 'simple' : params.mode
        [allStates:PaymentState.allPaymentStates,
         allBrokers:paymentService.getAllBrokers(null),
         mode:mode]
    }

    def loadPayments = {
        log.debug "loading payments ..."
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
                'initializationDate':DateUtils.formatDate(it.initializationDate),
                'commitDate':it.commitDate == null ? "" : DateUtils.formatDate(it.commitDate),
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
