import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItemDetail
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.business.users.Individual
import grails.converters.JSON

class PaymentController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IPaymentService paymentService
    Adult ecitizen
    
    def maxRows = 10
    def state = null
    
    def beforeInterceptor = {
        this.ecitizen = SecurityContext.getCurrentEcitizen();
        if (params.ps) state = JSON.parse(params.ps)
    }
    
    def afterInterceptor = [action:this.&invokeAfter, only:['index','history']]
    
    def invokeAfter(result) {
        if (state) result.pageState = (new JSON(state)).toString()
    }
    
    def index = {
        def result = [:]
        
        result.invoices = this.invoices
        result.depositAccounts = this.depositAccounts
        result.ticketingContracts = this.ticketingContracts
        
        return result
    }
    
    def history = {
        def result = [:]
        
        result.payments = this.paymentsHistory
        result.state = state
        result.maxRows = maxRows
        
        return result
    }

    protected Map getPaymentsHistory() {
        def result = [:]
        def offset = params.offset ? Integer.valueOf(params.offset) : 0
        result.all = paymentService.extendedGet(null, null, null, null, null, null, null, null,
            this.ecitizen.homeFolder.id, null, 'initializationDate', 'desc', maxRows, offset)
        result.count = paymentService.getPaymentCount(null, null, null, null, null, null, null,
            null, this.ecitizen.homeFolder.id, null)

        return result
    }

    protected List getTicketingContracts() {
        def result = []
        def contracts = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_TICKETING_ACCOUNTS)
        
        for(ExternalTicketingContractItem item : contracts) {
            Individual individual = individualService.getById(item.subjectId)
            result.add([
                id : item.id,
                label: item.label,
                amount: item.amount, 
                reference: item.externalItemId,
                subjectId : item.subjectId,
                subjectName : "${individual.firstName} ${individual.lastName}",
                unitPrice : item.unitPrice,
                minBuy : item.minBuy,
                maxBuy : item.maxBuy,
                quantity : item.quantity,
                oldQuantity: item.oldQuantity,
                creationDate : item.creationDate
            ])
//            println result[result.size()-1]
        }
        return result.sort{it.label}
    }
    
    protected List getDepositAccounts() {
        def result = []
        def accounts = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS)
        
        for(ExternalDepositAccountItem item : accounts) {
            if(item?.accountDetails) {
                for(ExternalDepositAccountItemDetail detail : item.accountDetails) {
                    def entry = this.buildDepositAccountEntry(item)
                    entry.date = detail.date
                    entry.holderName = detail.holderName+' '+detail.holderSurname
                    entry.value = detail.value
                    entry.paymentType = detail.paymentType
                    entry.paymentId = detail.paymentId
                    entry.bankReference = detail.bankReference
                    result.add(entry)
                }
            } else {
                def entry = this.buildDepositAccountEntry(item)
                entry.noDetails = true
                result.add(entry)
            }
        }
        
        return result
    }
    
    protected List getInvoices() {
        def result = []
        def invoces = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_INVOICES)
        
        for(ExternalInvoiceItem item : invoces) {
            if(!item.isPaid() && item.invoiceDetails) {
                for(ExternalInvoiceItemDetail detail : item.invoiceDetails) {
                    def entry = this.buildInvoiceEntry(item)
                    entry.labelDetail = detail.label
                    entry.subjectName = detail.subjectName+' '+detail.subjectSurname
                    entry.unitPrice = detail.unitPrice
                    entry.quantity = detail.quantity
                    entry.value = detail.value
                    result.add(entry)
                }
            } else if(!item.isPaid()) {
                def entry = this.buildInvoiceEntry(item)
                entry.noDetails = true
                result.add(entry)
            }
        }
        return result
    }
    
    protected Map buildDepositAccountEntry(ExternalDepositAccountItem item) {
        def entry = [:]
        entry.id = item.id
        entry.label = item.label
        entry.amount = item.amount
        entry.reference = item.externalItemId
        entry.oldValue = item.oldValue
        entry.oldValueDate = item.oldValueDate
        return entry
    }
    
    protected Map buildInvoiceEntry(ExternalInvoiceItem item) {
        def entry = [:]
        
        entry.id = item.id
        entry.amount = item.amount
        entry.label = item.label
        entry.reference = item.externalItemId
        entry.issueDate = item.issueDate
        entry.expirationDate = item.expirationDate
        
        return entry
    }
}
