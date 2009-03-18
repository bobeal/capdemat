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

class PaymentController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    Adult ecitizen
    
    def beforeInterceptor = {
        this.ecitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = {
        def result = [:]
        
        result.invoces = this.invoces
        result.depositAccounts = this.depositAccounts
        result.ticketingContracts = this.ticketingContracts
        
        return result
    }
    
    protected List getTicketingContracts() {
        def result = []
        def contracts = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_TICKETING_ACCOUNTS)
        
        for(ExternalTicketingContractItem item : contracts) {
            result.add([
                id : item.id,
                label: item.label,
                amount: item.amount, 
                reference: item.externalItemId,
                subjectId : item.subjectId,
                unitPrice : item.unitPrice,
                minBuy : item.minBuy,
                maxBuy : item.maxBuy,
                quantity : item.quantity,
                oldQuantity: item.oldQuantity,
                creationDate : item.creationDate
            ])
        }
        return result
    }
    
    protected List getDepositAccounts() {
        def result = []
        def accounts = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS)
        
        for(ExternalDepositAccountItem item : accounts) {
            for(ExternalDepositAccountItemDetail detail : item.accountDetails) {
                result.add([
                    id : item.id,
                    label : item.label,
                    amount : item.amount,
                    reference : item.externalItemId,
                    oldValue : item.oldValue, 
                    oldValueDate: item.oldValueDate,
                    date : detail.date,
                    holderName : detail.holderName,
                    holderSurname : detail.holderSurname,
                    value: detail.value,
                    paymentType: detail.paymentType,
                    paymentId: detail.paymentId,
                    bankReference: detail.bankReference,
                ])
            }
        }
        return result
    }
    
    protected List getInvoces() {
        def result = []
        def invoces = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_INVOICES)
        
        for(ExternalInvoiceItem item : invoces) {
            if(!item.isPaid()) {
                for(ExternalInvoiceItemDetail detail : item.invoiceDetails) {
                    result.add([
                        id : item.id,
                        amount : item.amount,
                        label : item.label,
                        labelDetail : detail.label,
                        reference : item.externalItemId,
                        issueDate : item.issueDate,
                        expirationDate: item.expirationDate,
                        subjectName : detail.subjectName,
                        subjectSurname : detail.subjectSurname,
                        unitPrice : detail.unitPrice,
                        quantity : detail.quantity, 
                        value: detail.value
                    ])
                }
            }
        }
        return result
    }
}
