import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.payment.ExternalAccountItem
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItemDetail
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItemDetail
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.payment.PurchaseItem
import fr.cg95.cvq.business.users.payment.PaymentMode
import fr.cg95.cvq.business.users.payment.Payment
import fr.cg95.cvq.business.users.payment.PaymentState
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService

import org.apache.commons.lang.StringUtils

import grails.converters.JSON

class PaymentController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IPaymentService paymentService
    Adult ecitizen
    
    def maxRows = 10
    def errorMessage = ''
    def state = [:]

    def beforeInterceptor = {
        this.errorMessage = message(code:'message.invalidFormat')
        this.ecitizen = SecurityContext.getCurrentEcitizen();
        
        if (params.ps) state = JSON.parse(params.ps)
        if (params.st != null) state.st = params.st;
        
        if(['addToCart','removeCartItem'].contains(actionName)) {
            if(!['invoices','depositAccounts','ticketingContracts'].contains(params.type))
                throw new Exception("NotAuthorizedPaymentType")
        }
    }
    
    def afterInterceptor = { result ->
        if(['index','history'].contains(actionName.toString())) {
            result.state = state
            result.pageState = (new JSON(state)).toString()
            
            result.errorMessage = flash?.invalid?.message ? flash.invalid.message : this.errorMessage
        }
    }
    
    def index = {
        def result = [:]
        result.invoices = this.invoices
        result.depositAccounts = this.depositAccounts
        result.ticketingContracts = this.ticketingContracts
        result.invalid = flash.invalid
        
        result.cart = [invoices:[],depositAccounts:[],ticketingContracts:[]]
        for(PurchaseItem item: session.payment?.purchaseItems) {
            if(item instanceof ExternalInvoiceItem) 
                result.cart.invoices.add(item)
            else if(item instanceof ExternalDepositAccountItem)
                result.cart.depositAccounts.add(item)
            else if(item instanceof ExternalTicketingContractItem)
                result.cart.ticketingContracts.add(item)
        }
        
        return result
    }
    
    def history = {
        def result = [:]
        
        result.paymentStates = PaymentState.allPaymentStates.collect{it.toString().toLowerCase()}
        result.payments = this.paymentsHistory
        result.state = state
        result.maxRows = maxRows
        
        return result
    }
    
    def status = {
        session.payment = null
    }
    
    def addToCart = {
        ExternalAccountItem item = 
            (ExternalAccountItem) session[params.type].find {it.externalItemId.equals(params.externalItemId)}
        
        if(validate(item)) {
            if(item instanceof ExternalTicketingContractItem) {
                item.quantity = Integer.valueOf(params.quantity)
            } else if (item instanceof ExternalDepositAccountItem) {
                String key = params.amount.replace(',','.')
                BigDecimal value = new BigDecimal(key)
                value = value.multiply(BigDecimal.valueOf(100L))
                item.amount = value.toDouble()
            }
            
            if(!session.payment || !(session.payment instanceof Payment)) {
                session.payment = paymentService.createPaymentContainer(item,PaymentMode.INTERNET)
            } else { 
                def olditem = session.payment.purchaseItems.find{
                    item.externalItemId.equals(it.externalItemId) && item.class.equals(it.class)
                }
                if(olditem) paymentService.removePurchaseItemFromPayment(session.payment,olditem)
                paymentService.addPurchaseItemToPayment(session.payment,item)
            }
            
            redirect(action:'index')
            return false
            
        } else {
            flash.invalid = [:]
            flash.invalid.id = params.externalItemId
            flash.invalid.value = item instanceof ExternalDepositAccountItem ? params.amount : params.quantity
            flash.invalid.type = params.type
            
            redirect(url:createLink(action:'index')+"/#${params.type}_${params.externalItemId}")
            return false
        }
    }
    
    def removeCartItem = {
        PurchaseItem item = session.payment?.purchaseItems?.find {
            it.externalItemId.equals(params.externalItemId) && 
                this.buildPurchaseItemMap(it).type.equals(params.type) 
        }
        paymentService.removePurchaseItemFromPayment((Payment)session.payment,item) 
        
        if(session.payment?.purchaseItems) {
            redirect(action:'cartDetails')
        } else {
            session.payment = null
            redirect(action:'index')
        }
        return false
    }
    
    def cartDetails = {
        def result = [items:[],paymentUrl:'']
        if(!session.payment) {
            redirect(action:'index')
            return false
        }
        
        for(PurchaseItem item : session.payment.purchaseItems) 
            result.items.add(this.buildPurchaseItemMap(item))
        
        ((Payment)session.payment).addPaymentSpecificData('scheme',request.scheme)
        ((Payment)session.payment).addPaymentSpecificData('domainName',request.serverName)
        ((Payment)session.payment).addPaymentSpecificData('port',request.serverPort.toString())
        
        result.paymentUrl = paymentService.initPayment((Payment)session.payment).toString()
        return result
    }
    
    def details = {
        def result = [items:[]]
        def list = params?.type == 'invoice' ? session.invoices : session.depositAccounts
        def item = list.find {it.externalItemId == params.externalItemId}
        if(!item) {
            redirect(controller:'frontofficePayment')
            return false
        }
        
        if(params.type == "invoice") {
            for(ExternalInvoiceItemDetail detail : item.invoiceDetails) {
                def entry = [:]
                entry.label = detail.label
                entry.subjectName = detail.subjectName+' '+detail.subjectSurname
                entry.unitPrice = detail.unitPrice
                entry.quantity = detail.quantity
                entry.value = detail.value
                result.items.add(entry)
            }
        } else if(params.type == "deposit") {
            for(ExternalDepositAccountItemDetail detail : item.accountDetails) {
                def entry = [:]
                entry.date = detail.date
                entry.holderName = detail.holderName+' '+detail.holderSurname
                entry.value = detail.value
                entry.paymentType = detail.paymentType
                entry.paymentId = detail.paymentId
                entry.bankReference = detail.bankReference
                result.items.add(entry)
            }
        }
        return result
    }
    
    def pay = {
        redirect(url:params.callbackUrl)
        return false
    }

    protected Map getPaymentsHistory() {
        def result = [:] 
        def paymentState = state.st ? PaymentState.forString(StringUtils.capitalize(state.st)) : null
        def offset = params.offset ? Integer.valueOf(params.offset) : 0
        result.all = paymentService.extendedGet(null, null, null, null, paymentState, null, null, 
            null, this.ecitizen.homeFolder.id, null, 'initializationDate', 'desc', maxRows, offset)
        result.count = paymentService.getPaymentCount(null, null, null, null, paymentState, 
            null, null, null, this.ecitizen.homeFolder.id, null)

        return result
    }

    protected List getTicketingContracts() {
        session.ticketingContracts = []
        def result = []
        def contracts = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_TICKETING_ACCOUNTS)
        
        for(ExternalTicketingContractItem item : contracts) {
            session.ticketingContracts.add(item)
            result.add(this.buildTicketMap(item))
        }
        return result.sort{it.externalItemId}
    }
    
    protected List getDepositAccounts() {
        session.depositAccounts = []
        def result = []
        def accounts = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS)
        
        for(ExternalDepositAccountItem item : accounts) {
            homeFolderService.loadExternalDepositAccountDetails(item) 
            session.depositAccounts.add(item)
            result.add(this.buildDepositMap(item))
        }
        
        return result.sort{it.externalItemId}
    }
    
    protected List getInvoices() {
        session.invoices = []
        def result = []
        def invoices = homeFolderService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_INVOICES)
        
        for(ExternalInvoiceItem item : invoices) {
            if(!item.isPaid()) {
                homeFolderService.loadExternalInvoiceDetails(item)
                session.invoices.add(item)
                result.add(this.buildInvoiceMap(item))
            }
        }
        return result.sort{it.externalItemId}
    }
    
    protected Map buildPurchaseItemMap(PurchaseItem item) {
        if(item instanceof ExternalDepositAccountItem) 
            return (this.buildDepositMap((ExternalDepositAccountItem)item))
        else if(item instanceof ExternalInvoiceItem)
            return (this.buildInvoiceMap((ExternalInvoiceItem)item))
        else if(item instanceof ExternalTicketingContractItem)
            return (this.buildTicketMap((ExternalTicketingContractItem)item))
        
        return null
    }
    
    protected Map buildDepositMap(ExternalDepositAccountItem item) {
        def entry = [:]
        entry.id = item.id
        entry.label = item.label
        entry.amount = item.amount
        entry.externalItemId = item.externalItemId
        entry.oldValue = item.oldValue
        entry.oldValueDate = item.oldValueDate
        entry.hasDetails = item.accountDetails
        entry.type = 'depositAccounts'
        return entry
    }
    
    protected Map buildTicketMap(ExternalTicketingContractItem item) {
        Individual individual = individualService.getById(item.subjectId)
        def entry = [
            id : item.id,
            label: item.label,
            amount: item.amount, 
            externalItemId: item.externalItemId,
            subjectId : item.subjectId,
            subjectName : "${individual.firstName} ${individual.lastName}",
            unitPrice : item.unitPrice,
            minBuy : item.minBuy,
            maxBuy : item.maxBuy,
            quantity : item.quantity,
            oldQuantity: item.oldQuantity,
            creationDate : item.creationDate,
            type : 'ticketingContracts'
        ]
        return entry;
    }
    
    protected Map buildInvoiceMap(ExternalInvoiceItem item) {
        def entry = [:]
        entry.id = item.id
        entry.amount = item.amount
        entry.label = item.label
        entry.externalItemId = item.externalItemId
        entry.issueDate = item.issueDate
        entry.expirationDate = item.expirationDate
        entry.hasDetails = item.invoiceDetails
        entry.isInCart = session.payment?.purchaseItems?.find {
            it.externalItemId.equals(entry.externalItemId) && it instanceof ExternalInvoiceItem 
        }
        entry.type = 'invoices' 
        return entry;
    }
    
    protected Boolean validate(PurchaseItem item) {
        try {
            if(item instanceof ExternalTicketingContractItem)
                return validateQuantity(params.quantity,((ExternalTicketingContractItem)item).minBuy,
                    ((ExternalTicketingContractItem)item).maxBuy)
            else if(item instanceof ExternalDepositAccountItem)
                return validateMoney(params.amount.replace(',','.'),1)
            else
                return true
        } catch (Exception e) {
            return false
        }
    }
    
    protected Boolean validateMoney(String val, Number min) {
        def factor = val != '', dec = new BigDecimal(val)
        factor = (val =~ /\d+(\.\d{1,2})?/).matches() && factor
        factor = dec >= min && factor
        
        return factor
    }
    
    protected Boolean validateQuantity(String val, Number min, Number max) {
        def factor = val != '', dec = new BigDecimal(val)
        factor = (val =~ /\d+/).matches() && factor 
        factor = dec >= min && dec <= max && factor
        
        return factor
    }
}
