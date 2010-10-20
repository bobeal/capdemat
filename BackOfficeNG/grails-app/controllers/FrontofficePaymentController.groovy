import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.payment.ExternalAccountItem
import fr.cg95.cvq.business.payment.ExternalInvoiceItem
import fr.cg95.cvq.business.payment.ExternalInvoiceItemDetail
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem
import fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.payment.PurchaseItem
import fr.cg95.cvq.business.payment.PaymentMode
import fr.cg95.cvq.business.payment.Payment
import fr.cg95.cvq.business.payment.PaymentState
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.service.payment.external.IPaymentExternalService
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere

import org.apache.commons.lang.StringUtils

import grails.converters.JSON

class FrontofficePaymentController {

    IPaymentExternalService paymentExternalService
    IIndividualService individualService
    IPaymentService paymentService
    ILocalAuthorityRegistry localAuthorityRegistry
    Adult ecitizen
    
    def maxRows = 10
    def state = [:]

    def beforeInterceptor = {
        if (params.action != "history" && !localAuthorityRegistry.isPaymentEnabled()) {
            render(view : "index", model : ["displayedMessage" : localAuthorityRegistry.getLocalAuthorityResourceFile(
                Type.HTML, "paymentlackmessage", false)?.getText()])
        }
        this.ecitizen = SecurityContext.getCurrentEcitizen();
        
        if (params.ps) state = JSON.parse(params.ps)
        if (params.st != null) state.st = params.st;
        
        if(['addToCart','removeCartItem'].contains(actionName)) {
            if(!['invoices','depositAccounts','ticketingContracts'].contains(params.type))
                throw new Exception("NotAuthorizedPaymentType")
        }
    }
    
    def afterInterceptor = { result ->
        if(['index','history'].contains(actionName)) {
            result.state = state
            result.pageState = (new JSON(state)).toString()
        }

        if(['index','details','cartDetails'].contains(actionName)) { 
            result.cart = this.buildCart()
            result.actionName = actionName
        }
    }
    
    def index = {
        def result = [:]
        result.invoices = this.invoices
        result.depositAccounts = this.depositAccounts
        result.ticketingContracts = this.ticketingContracts
        result.invalid = flash.invalid
        
        return result
    }
    
    def history = {
        def result = [:]
        
        result.paymentStates = PaymentState.allPaymentStates.collect{it.toString().toLowerCase()}
        result.paymentsHistory = this.paymentsHistory
        if (SecurityContext.currentSite.displayInProgressPayments)
            result.inProgressPayments = this.inProgressPayments
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
        
        return result
    }
    
    def details = {
        def result = [items:[],cart:[]]
        def list = params.type == 'invoice' ? session.invoices : session.depositAccounts
        def item = list.find {it.externalItemId == params.externalItemId}
        if(!item) {
            redirect(controller:'frontofficePayment')
            return false
        }
        
        if(params.type == "invoice") {
            for(ExternalInvoiceItemDetail detail : item.invoiceDetails) {
                def entry = [:]
                entry.label = detail.label
                entry.subjectName = detail.subjectName + ' ' + detail.subjectSurname
                entry.unitPrice = detail.unitPrice
                entry.quantity = detail.quantity
                entry.value = detail.value
                result.items.add(entry)
            }
        } else if(params.type == "deposit") {
            for(ExternalDepositAccountItemDetail detail : item.accountDetails) {
                def entry = [:]
                entry.date = detail.date
                entry.holderName = detail.holderName + ' ' + detail.holderSurname
                entry.value = detail.value
                entry.paymentType = detail.paymentType
                entry.paymentId = detail.paymentId
                entry.bankReference = detail.bankReference
                result.items.add(entry)
            }
		
            result.items = result.items.sort({ it.date}).reverse()
        }
        
        return result
    }
    
    def pay = {
        if (!session.payment) {
            redirect(action:'index')
            return false
        }
        
        def payment = session.payment
        payment.addPaymentSpecificData('scheme',request.scheme)
        payment.addPaymentSpecificData('domainName',request.serverName)
        payment.addPaymentSpecificData('port',request.serverPort.toString())

        def paymentUrl = paymentService.initPayment(payment).toString()

        redirect(url:paymentUrl)
        return false
    }

    protected Map getPaymentsHistory() {
        def result = [:] 
        def paymentState = state.st ? PaymentState.forString(StringUtils.capitalize(state.st)) : null
        def offset = params.offset ? Integer.valueOf(params.offset) : 0

        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        critere.comparatif = Critere.NEQUALS
        critere.attribut = Payment.SEARCH_BY_PAYMENT_STATE
        critere.value = PaymentState.INITIALIZED.toString()
        criteriaSet.add(critere)

        result.all = paymentService.get(criteriaSet, 'initializationDate', 'desc', maxRows, offset)
        result.count = paymentService.getCount(criteriaSet)
        return result
    }

    protected Map getInProgressPayments() {
        def result = [:]
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        critere.comparatif = Critere.EQUALS
        critere.attribut = Payment.SEARCH_BY_PAYMENT_STATE
        critere.value = PaymentState.INITIALIZED.toString()
        criteriaSet.add(critere)
        result.all = paymentService.get(criteriaSet, 'initializationDate', 'desc', 0, 0)
        return result
    }

    protected List getTicketingContracts() {
        session.ticketingContracts = []
        def result = []
        def contracts = paymentExternalService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_TICKETING_ACCOUNTS)
        
        for(ExternalTicketingContractItem item : contracts) {
            session.ticketingContracts.add(item)
            result.add(this.buildTicketMap(item))
        }
        return result.sort{it.externalItemId}
    }
    
    protected List getDepositAccounts() {
        session.depositAccounts = []
        def result = []
        def accounts = paymentExternalService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS)
        
        for(ExternalDepositAccountItem item : accounts) {
            paymentExternalService.loadDepositAccountDetails(item) 
            session.depositAccounts.add(item)
            result.add(this.buildDepositMap(item))
        }
        
        return result.sort{it.externalItemId}
    }
    
    protected List getInvoices() {
        session.invoices = []
        def result = []
        def invoices = paymentExternalService.getExternalAccounts(ecitizen.homeFolder.id, IPaymentService.EXTERNAL_INVOICES)
        
        for(ExternalInvoiceItem item : invoices) {
            if(!item.getIsPaid()) {
                paymentExternalService.loadInvoiceDetails(item)
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
    
    protected Map buildCart() {
        def cart = [invoices:[],depositAccounts:[],ticketingContracts:[]]
        if(session?.payment?.purchaseItems) {
            for(PurchaseItem item: session?.payment?.purchaseItems) {
                if(item instanceof ExternalInvoiceItem) 
                    cart.invoices.add(item)
                else if(item instanceof ExternalDepositAccountItem)
                    cart.depositAccounts.add(item)
                else if(item instanceof ExternalTicketingContractItem)
                    cart.ticketingContracts.add(item)
            }
        }
        return cart
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
        entry.totalValue = item.totalValue
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
