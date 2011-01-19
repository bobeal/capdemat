import fr.cg95.cvq.service.users.external.IExternalHomeFolderService
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.service.payment.external.IExternalApplicationService
import fr.cg95.cvq.business.payment.ExternalInvoiceItem
import fr.cg95.cvq.external.IExternalProviderService
import fr.cg95.cvq.business.payment.external.ExternalApplication
import fr.cg95.cvq.business.users.external.HomeFolderMapping
import fr.cg95.cvq.business.users.external.MappingState
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.util.Critere

import grails.converters.JSON

class BackofficeExternalApplicationController {

    IExternalHomeFolderService externalHomeFolderService
    IExternalApplicationService externalApplicationService
    IPaymentService paymentService

    def requestAdaptorService

    def defaultAction = 'applications'

    def resultsPerPage = 25

    def beforeInterceptor = {
        session['currentMenu'] = 'payment'
    }

    def afterInterceptor = { model ->
        model['subMenuEntries'] = ['payment.search', 'payment.configure', 'externalApplication.applications']
    }

    def applications = {
        return ['applications': externalApplicationService.allExternalApplications()]
    }

    def editApplication = {
        return ['applications': externalApplicationService.allExternalApplications(),
                'brokers': paymentService.getAllBrokers().keySet(),
                'editMode': 'edit',
                'app': externalApplicationService.getExternalApplicationById(Long.valueOf(params.id))
        ]
    }

    def createApplication = {
        render(view:'editApplication',model:[editMode:"create", brokers:paymentService.getAllBrokers().keySet(),
            applications:externalApplicationService.allExternalApplications()])
    }

    def saveApplication = {
        def application = null
        if (params.id != null && params.id != "") {
            application = externalApplicationService.getExternalApplicationById(Long.valueOf(params.id))
            bindData(application, params)
            externalApplicationService.modifyExternalApplication(application)
        } else {
            application = new ExternalApplication()
            bindData(application, params)
            externalApplicationService.createExternalApplication(application)
        }
        render (['id': application.id, 'status':'success', 'message':message(code:'message.updateDone')] as JSON)
    }

    def deleteApplication = {
        externalApplicationService.deleteExternalApplication(Long.valueOf(params.id))
        render (['status':'success', 'message':message(code:'message.deleteDone')] as JSON)
    }

    def importHomeFolders = {
            def file = request.getFile('csvFile')
            response.contentType = 'text/html; charset=utf-8'
            if (file.empty) {
                render (new JSON(['status':'warning', 'message':message(code:'external.message.application.noImportFile')]).toString())
                return false
            }
            def report
            try {
                report = externalApplicationService.importHomeFolders(Long.valueOf(params.id), file.bytes)
            } catch (CvqException e){
                render (new JSON(['status':'error', 'message':message(code:e.i18nKey)]).toString())
                return false
            }
            def msg = message(code:'external.message.application.homeFoldersImported')
            ['created', 'updated'].each {
                msg += '<br> ' + message(code:'external.message.importReport.' + it, args:[report[it]])
            }
            render (new JSON(['status':'success', 'message':msg]).toString())
            return false
    }

    def homeFolders = {
        def max = Integer.valueOf(15)
        def startIndex = params.startIndex ? Integer.valueOf(params.startIndex) : 0
        if (params.dir == 'next') startIndex += max
        if (params.dir == 'prev') startIndex -= max
        def homeFolders = externalApplicationService.getHomeFolders(Long.valueOf(params.appId), startIndex, max)

        def displayDir = [:]
        displayDir.prev = startIndex > 0 ? true : false
        displayDir.next = homeFolders.size() == max ? true : false

        render(template:'homeFolders', model:[
            'homeFolders': homeFolders,
            'startIndexHomeFolder': startIndex,
            'displayDirHomeFolder': displayDir
            ])
    }

    def matchHomeFolders = {
        fr.cg95.cvq.business.users.Adult.metaClass.rank = { homeFolder ->
            def rank = 0
            rank += delegate.firstName == homeFolder.responsible.firstName ? 1 : 0
            rank += delegate.lastName == homeFolder.responsible.lastName ? 1 : 0
            rank += homeFolder.address.indexOf(delegate.address.streetName) ? 1 : 0
            rank += delegate.email == homeFolder.responsible.email ? 1 : 0
            rank += delegate.homePhone == homeFolder.responsible.homePhone ? 1 : 0
            return rank
        }
        def eh = externalApplicationService.getHomeFolder(Long.valueOf(params.id))
        return [
            'matchedAdults': externalApplicationService.matchAdults(Long.valueOf(params.id)),
            'homeFolder': externalApplicationService.getHomeFolder(Long.valueOf(params.id)),
            'mapping' : externalHomeFolderService.getHomeFolderMapping(IExternalApplicationService.EXTERNAL_APPLICATION_LABEL, eh)
        ]
    }

    def bindHomeFolder = {
        def eh = externalApplicationService.getHomeFolder(Long.valueOf(params.id))
        if (externalHomeFolderService.getHomeFolderMapping(IExternalApplicationService.EXTERNAL_APPLICATION_LABEL, eh) == null) {
            // TODO : manage externalAplication via futur inHouse plugin
            externalHomeFolderService.createHomeFolderMapping(
                new HomeFolderMapping(IExternalApplicationService.EXTERNAL_APPLICATION_LABEL,
                    Long.valueOf(params.localId),  eh.getCompositeIdForMapping())
            )
            eh.mappingState = MappingState.BINDED
            externalApplicationService.modifyHomeFolder(eh)
        }
        render (new JSON(['status': 'success',
            'message': message(code:'external.message.bindHomeFolderSucceed'),
            'mappingState': capdematEnumToFlag(var:eh.mappingState, i18nKeyPrefix:'external.mappingState')
        ]).toString())
    }

    def freeHomeFolder = {
        def eh = externalApplicationService.getHomeFolder(Long.valueOf(params.id))
        if (externalHomeFolderService.getHomeFolderMapping(IExternalApplicationService.EXTERNAL_APPLICATION_LABEL, eh) != null)
            externalHomeFolderService.deleteHomeFolderMapping(IExternalApplicationService.EXTERNAL_APPLICATION_LABEL, eh)
        eh.mappingState = MappingState.FREE
        externalApplicationService.modifyHomeFolder(eh)
        render (new JSON(['status': 'success',
            'message': message(code:'external.message.freeHomeFolderSucceed'),
            'mappingState': capdematEnumToFlag(var:eh.mappingState, i18nKeyPrefix:'external.mappingState')
        ]).toString())
    }

    def ignoreHomeFolder = {
        def eh = externalApplicationService.getHomeFolder(Long.valueOf(params.id))
        eh.mappingState = MappingState.IGNORED
        externalApplicationService.modifyHomeFolder(eh)
        render (new JSON(['status': 'success',
            'message': message(code:'external.message.ignoredHomeFolderSucceed'),
            'mappingState': capdematEnumToFlag(var:eh.mappingState, i18nKeyPrefix:'external.mappingState')
        ]).toString())
    }

    def importPayments = {
        def type = params.type
        def broker = params.broker
        def file = request.getFile('csvFile')
        response.contentType = 'text/html; charset=utf-8'
        if (file.empty) {
            render (new JSON(['status':'warning', 'message':message(code:'external.message.application.noImportFile')]).toString())
            return false
        }
        if (broker.isEmpty()) {
            render (new JSON(['status':'warning', 'message':message(code:'external.message.application.noBroker')]).toString())
            return false
        }
        def report
        try {
            if (type == 'accounts')
                report = externalApplicationService.importDepositAccounts(Long.valueOf(params.id), broker, file.bytes)
            else if (type == 'contracts')
                report = externalApplicationService.importTicketingContracts(Long.valueOf(params.id), broker, file.bytes)
            else if (type == 'invoices')
                report = externalApplicationService.importInvoices(Long.valueOf(params.id), broker, file.bytes)
        } catch (CvqException e){
            render (new JSON(['status':'error', 'message':message(code:e.i18nKey)]).toString())
            return false
        }
        def msg = message(code: 'external.message.application.' + type +'Imported')
        ['created', 'updated','ignored'].each {
            msg += '<br> ' + message(code:'external.message.importReport.' + it, args:[report[it]])
        }
        render (new JSON(['status':'success', 'message':msg]).toString())
        return false
    }

    def importPaymentsDetail = {
        def type = params.type
        def file = request.getFile('csvFile')
        response.contentType = 'text/html; charset=utf-8'
        if (file.empty) {
            render (new JSON(['status':'warning', 'message':message(code:'external.message.application.noImportFile')]).toString())
            return false
        }
        def report
        try {
            if (type == 'accountsDetail')
                report = externalApplicationService.importDepositAccountsDetails(Long.valueOf(params.id), file.bytes)
            else if (type == 'invoicesDetail')
                report = externalApplicationService.importInvoicesDetails(Long.valueOf(params.id), file.bytes)
        } catch (CvqException e){
            render (new JSON(['status':'error', 'message':message(code:e.i18nKey)]).toString())
            return false
        }
        def msg = message(code: 'external.message.application.' + type +'Imported')
        ['created', 'ignored'].each {
            msg += '<br> ' + message(code:'external.message.importReport.' + it, args:[report[it]])
        }
        render (new JSON(['status':'success', 'message':msg]).toString())
        return false
     }

    def searchInvoice = {
        def itemsDefaultSortBy = 'externalInvoiceId'
        def supportedKeys = ["externalInvoiceId", "homeFolderId", "expirationDateBefore","isPaid"]

        Set<Critere> criteria = prepareCriteria(supportedKeys)
        criteria.each {
            if (it.attribut == 'expirationDateBefore') {
                it.attribut = 'expirationDate'
                it.value = DateUtils.stringToDate(it.value)
                it.comparatif = Critere.LTE
            }
            if (it.attribut == 'isPaid') {
                it.value = Boolean.TRUE
            }
        }

        // deal with dynamic filters
        def parsedFilters = prepareFilters(criteria, params.filterBy)

        // deal with dynamic sorts
        def sortBy = params.sortBy ? params.sortBy : itemsDefaultSortBy

        // deal with pagination settings
        def results = params.results == null ? resultsPerPage : Integer.valueOf(params.results)
        def recordOffset = 0
        if (params.paginatorChange.equals("true"))
            recordOffset = Integer.valueOf(params.recordOffset)
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT)
        def invoices = []
        paymentService.getInvoices(criteria, sortBy, null, results, recordOffset).each {
            invoices.add(prepareResult(it))
        }
        render(view:'searchItem', model:[
                             'searchType': 'invoice',
                             'filters':parsedFilters.filters,
                             'filterBy':parsedFilters.filterBy,
                             'recordsReturned': invoices.size(),
                             'totalRecords': paymentService.getInvoicesCount(criteria),
                             'recordOffset': recordOffset,
                             'records': invoices].plus(initSearch()))
    }

    def searchDepositAccount = {
        def itemsDefaultSortBy = 'externalDepositAccountId'
        def supportedKeys = ["externalDepositAccountId", "homeFolderId"]

        // deal with search criteria
        Set<Critere> criteria = prepareCriteria(supportedKeys)

        // deal with dynamic filters
        def parsedFilters = prepareFilters(criteria, params.filterBy)

        // deal with dynamic sorts
        def sortBy = params.sortBy ? params.sortBy : itemsDefaultSortBy

        // deal with pagination settings
        def results = params.results == null ? resultsPerPage : Integer.valueOf(params.results)
        def recordOffset = 0
        if (params.paginatorChange.equals("true"))
            recordOffset = Integer.valueOf(params.recordOffset)

        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT)
        def depositAccounts = []
        paymentService.getDepositAccounts(criteria, sortBy, null, results, recordOffset).each {
            depositAccounts.add(prepareResult(it))
        }
        render(view:'searchItem', model:[
                             'searchType': 'depositAccount',
                             'filters':parsedFilters.filters,
                             'filterBy':parsedFilters.filterBy,
                             'recordsReturned': depositAccounts.size(),
                             'totalRecords': paymentService.getDepositAccountsCount(criteria),
                             'recordOffset': recordOffset,
                             'records': depositAccounts].plus(initSearch()))
    }

    def searchTicketingContract = {
        def itemsDefaultSortBy = 'externalTicketingContract'
        def supportedKeys = ["externalTicketingContractId", "homeFolderId"]

        // deal with search criteria
        Set<Critere> criteria = prepareCriteria(supportedKeys)

        // deal with dynamic filters
        def parsedFilters = prepareFilters(criteria, params.filterBy)

        // deal with dynamic sorts
        def sortBy = params.sortBy ? params.sortBy : itemsDefaultSortBy

        // deal with pagination settings
        def results = params.results == null ? resultsPerPage : Integer.valueOf(params.results)
        def recordOffset = 0
        if (params.paginatorChange.equals("true"))
            recordOffset = Integer.valueOf(params.recordOffset)

        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT)
        def ticketingContracts = []
        paymentService.getTicketingContracts(criteria, sortBy, null, results, recordOffset).each {
            ticketingContracts.add(prepareResult(it))
        }
        render(view:'searchItem', model:[
                             'searchType': 'ticketingContract',
                             'filters':parsedFilters.filters,
                             'filterBy':parsedFilters.filterBy,
                             'recordsReturned': ticketingContracts.size(),
                             'totalRecords': paymentService.getTicketingContractsCount(criteria),
                             'recordOffset': recordOffset,
                             'records': ticketingContracts].plus(initSearch()))
    }

    def searchItem = {
    }

    private initSearch() {
        return [
            'sortBy': params.sortBy,
            'dir': params.dir,
            'inSearch': true
        ].plus(initSearchReferential())
    }
    
    private initSearchReferential() {
        return [
            'allBrokers':paymentService.getAllBrokers(),
            'allExternalApplications':externalApplicationService.allExternalApplications()
        ]
    }

    private prepareCriteria(supportedKeys) {
        Set<Critere> criteria = new HashSet<Critere>()
        params.each { key,value ->
            if (supportedKeys.contains(key) && value != "") {
                Critere critere = new Critere()
                critere.attribut = key
                critere.comparatif = Critere.EQUALS
                critere.value = value.trim()
                criteria.add(critere)
            }
        }
        return criteria
    }

    private prepareFilters(criteria, filters) {
        def parsedFilters = SearchUtils.parseFilters(filters)
        parsedFilters.filters.each { key, value ->
            Critere critere = new Critere()
            critere.attribut = key.replaceAll("Filter","")
            critere.comparatif = Critere.EQUALS
            critere.value = value
            criteria.add(critere)
        }
        return parsedFilters
    }

    private prepareResult(accountItem) {
        def externalApplication = externalApplicationService.getExternalApplicationById(Long.valueOf(accountItem.externalApplicationId))
        def hfm
        if (externalApplication != null)
            hfm = externalHomeFolderService
                .getHomeFolderMapping(accountItem.externalServiceLabel, externalApplication, accountItem.externalHomeFolderId)
        def extendedAccounItem = [
            'item' : accountItem,
            'externalLabel' : externalApplication != null ? externalApplication.label : accountItem.externalServiceLabel,
            'homeFolderId' : externalApplication != null ? hfm?.homeFolderId : null
        ]
        return extendedAccounItem
    }

}
