import com.google.gson.JsonObject
import grails.converters.JSON
import java.io.IOException
import java.util.ArrayList
import java.util.Collections

import fr.cg95.cvq.schema.ximport.HomeFolderImportDocument
import fr.cg95.cvq.service.users.IUserService
import fr.cg95.cvq.service.users.IUserSearchService
import fr.cg95.cvq.service.users.IUserWorkflowService
import fr.cg95.cvq.service.users.IUserSecurityService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.business.QoS
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.service.users.IMeansOfContactService
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService
import fr.cg95.cvq.business.payment.Payment

import fr.cg95.cvq.exception.CvqValidationException

import org.apache.xmlbeans.XmlError
import org.apache.xmlbeans.XmlException
import org.apache.xmlbeans.XmlOptions

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class BackofficeHomeFolderController {

    IExternalHomeFolderService externalHomeFolderService
    IUserService userService
    IUserSearchService userSearchService
    IUserWorkflowService userWorkflowService
    IRequestSearchService requestSearchService
    IPaymentService paymentService
    IMeansOfContactService meansOfContactService
    IUserSecurityService userSecurityService
    
    def translationService
    def homeFolderAdaptorService
    def requestAdaptorService
    def individualAdaptorService

    def defaultAction = 'search'
    def defaultMax = 15
    def subMenuEntries = ["userSecurity.index", "homeFolder.meansOfContact", "homeFolder.importHomeFolders"]

    def beforeInterceptor = {
        session["currentMenu"] = "users"
    }

    def help = {}
    
    def search = {
        def state = [:], records = [], count = 0
        if (params.pageState) state = JSON.parse(params.pageState)
        
        if(!request.get) {
            records = this.doSearch(state)
            count = userSearchService.getCount(this.prepareCriterias(state))
        }
        
        return ([
            'agentCanWrite': userSecurityService.canWrite(SecurityContext.currentAgent.id),
            'state': state,
            'records': records,
            'count' : count,
            'max': this.defaultMax,
            'homeFolderStates': this.buildHomeFolderStateFilter(),
            'currentSiteName': SecurityContext.currentSite.name,
            'homeFolderStatus' : this.buildHomeFolderStatusFilter(),
            'pageState' : (new JSON(state)).toString().encodeAsHTML(),
            'offset' : params.currentOffset ? params.currentOffset : 0 
        ]);
    }
    
    def details = {
        def homeFolder = userSearchService.getHomeFolderById(Long.parseLong(params.id))
        def adults, children
        if (params.viewArchived != null) {
            adults = userSearchService.getAdults(homeFolder.id, UserState.allUserStates)
            children = userSearchService.getChildren(homeFolder.id, UserState.allUserStates)
        } else {
            adults = userSearchService.getAdults(homeFolder.id)
            children = userSearchService.getChildren(homeFolder.id)
        }

        def result = [:]
        result.homeFolder = homeFolder
        result.homeFolderResponsible = userSearchService.getHomeFolderResponsible(homeFolder.id)
        result.adults = adults.findAll{it.id != result.homeFolderResponsible.id}
        result.children = children
        result.homeFolderState = homeFolder.state.toString().toLowerCase()
        result.homeFolderStatus = homeFolder.enabled ? 'enable' : 'disable'

        result.responsibles = [:]
        for(Child child : result.children)
            result.responsibles.put(child.id, userSearchService.listBySubjectRoles(child.id, RoleType.childRoleTypes))

        result.agentCanWrite = userSecurityService.canWrite(SecurityContext.currentAgent.id)
        return result
    }

    def create = {
        if (request.post) {
            def adult = new Adult()
            DataBindingUtils.initBind(adult, params)
            bind(adult)
            def invalidFields = userService.validate(adult, true)
            if (!invalidFields.isEmpty()) {
                session.doRollback = true
                render (['invalidFields': invalidFields] as JSON)
                return false
            }
            userWorkflowService.create(adult, false)
            render (['id' : adult.homeFolder.id] as JSON)
            return false
        }
        return []
    }

    def adult = { 
        def adult, template
        def mode = params.mode 
        if (!params.id) {
            adult =  new Adult()
            template = 'adult'
            flash.homeFolderId = params.homeFolderId
            if (request.get) {
                def responsible = userSearchService.getHomeFolderResponsible(Long.valueOf(params.homeFolderId))
                adult.address = responsible.address
            }
        } else {
            adult = userSearchService.getAdultById(Long.valueOf(params.id))
            template = params.template ? params.template : 'adult'
        }

        if (request.post && !adult.id) {
            mode = 'static'
            DataBindingUtils.initBind(adult, params)
            bind(adult)
            userWorkflowService.add(
                userSearchService.getHomeFolderById(Long.valueOf(params.homeFolderId)), adult, false)
            def invalidFields = userService.validate(adult)
            if (!invalidFields.isEmpty()) {
                session.doRollback = true
                render (['invalidFields': invalidFields] as JSON)
                return false
            }
            render (['status': 'success', 'type':'adult', 'id': adult.id] as JSON)
            return false
        }
        render(template: mode + '/' + template, model:['adult': adult])
    }

    def child = {
        def child, template, homeFolderId
        def mode = params.mode
        if (!params.id) {
            child =  new Child()
            template = 'child'
            homeFolderId = Long.valueOf(params.homeFolderId)
            flash.homeFolderId = params.homeFolderId
        } else {
            child = userSearchService.getChildById(Long.valueOf(params.id))
            template = params.template ? params.template : 'child'
            homeFolderId = child.homeFolder.id
        }
        if (request.post && !child.id) {
            mode = 'static'
            bind(child)
            userWorkflowService.add(userSearchService.getHomeFolderById(homeFolderId), child)
            params.roles.each {
                if (it.value instanceof GrailsParameterMap && it.value.owner != '' && it.value.type != '') {
                    userWorkflowService.link(
                        userSearchService.getById(Long.valueOf(it.value.owner)),
                        child, [RoleType.forString(it.value.type)])
                }
            }
            def invalidFields = userService.validate(child)
            if (!invalidFields.isEmpty()) {
                session.doRollback = true
                if (invalidFields.contains('legalResponsibles')) {
                    userSearchService.getAdults(child.homeFolder.id).eachWithIndex { adult, index ->
                        invalidFields.add("roles.${index}.type")
                    }
                }
                render (['invalidFields': invalidFields] as JSON)
                return false
            }
            render (['status': 'success', 'type':'child', 'id': child.id] as JSON)
            return false
        }
        def models = ['child': child]
        models['adults'] = userSearchService.getAdults(homeFolderId).findAll{ it.state != UserState.ARCHIVED }
        if (child.id) {
            models['roleOwners'] = userSearchService.listBySubjectRoles(child.id, RoleType.childRoleTypes)
        }
        render(template: mode + '/' + template, model: models)
    }

    def removeIndividual = {
        def user = userSearchService.getById(params.long("id"))
        userWorkflowService.changeState(user, UserState.ARCHIVED)
        render (['status':'success', 'message':message(code:'homeFolder.message.individualRemoveSuccess')] as JSON)
    }

    def state = {
        def user
        try {
            user = userSearchService.getById(params.long("id"))
        } catch (CvqObjectNotFoundException) {
            user = userSearchService.getHomeFolderById(params.long("id"))
        }
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            userWorkflowService.changeState(user, UserState.forString(params.state))
        }
        render(template : mode + "/state", model : [
            "user" : user, "states" : userWorkflowService.getPossibleTransitions(user)])
    }

    def address = {
        def adult = userSearchService.getAdultById(params.long("id"))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            try {
                def temp = new Address()
                bind(temp)
                individualAdaptorService.historize(
                    adult, adult.address, temp, "address",
                    ["additionalDeliveryInformation", "additionalGeographicalInformation", "city",
                        "cityInseeCode", "countryName", "placeNameOrService", "postalCode",
                        "streetMatriculation", "streetName", "streetNumber", "streetRivoliCode"])
            } catch (CvqValidationException e) {
                session.doRollback = true
                def invalidFields = []
                e.invalidFields.each{ invalidFields.add(it = it.replace('address.',''))}
                render (['invalidFields': invalidFields] as JSON)
                return false
            }
        }
        render(template : mode + "/address", model : ["user" : adult])
    }

    def contact = {
        def adult = userSearchService.getAdultById(params.long("id"))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            try {
                def temp = new Adult()
                bind(temp)
                individualAdaptorService.historize(
                    adult, adult, temp, "contact", ["email", "homePhone", "mobilePhone", "officePhone"])
            } catch (CvqValidationException e) {
                session.doRollback = true
                render (['invalidFields': e.invalidFields] as JSON)
                return false
            }
        }
        render(template : mode + "/contact", model : ["adult" : adult])
    }

    def identity = {
        def individual = userSearchService.getById(params.long("id"))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            try {
                def temp = individual instanceof Adult ? new Adult() : new Child()
                bind(temp)
                individualAdaptorService.historize(
                    individual, individual, temp, "identity",
                    individual instanceof Adult ?
                        ["title", "familyStatus", "lastName", "maidenName", "nameOfUse", "firstName", "firstName2", "firstName3", "profession", "cfbn"] :
                        ["born", "lastName", "firstName", "firstName2", "firstName3", "sex", "birthDate", "birthPostalCode", "birthCity", "birthCountry"])
            } catch (CvqValidationException e) {
                session.doRollback = true 
                render (['invalidFields': e.invalidFields] as JSON)
                return false
            }
        }
        render(template : mode + "/" + individual.class.simpleName.toLowerCase() + "Identity",
            model : ["individual" : individual])
    }

    def responsibles = {
        def child = userSearchService.getChildById(Long.valueOf(params.id))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            params.roles.each {
                if (it.value instanceof GrailsParameterMap && it.value.owner != '') {
                    def owner = userSearchService.getById(Long.valueOf(it.value.owner))
                    if (it.value.type == '')
                        userWorkflowService.unlink(owner,child)
                    else
                        userWorkflowService.link(owner,child, [RoleType.forString(it.value.type)])
                }
            }
            if (!userService.validate(child).isEmpty())  {
                session.doRollback = true
                def errors = []
                userSearchService.getAdults(child.homeFolder.id).eachWithIndex { adult, index ->
                    errors.add("roles.${index}.type")
                }
                render (['invalidFields': errors] as JSON)
                return false
            }
        }
        def model = [
            "child" : child,
            "adults" : userSearchService.getAdults(child.homeFolder.id),
            "roleOwners" : mode == 'static' ? 
                userSearchService.listBySubjectRoles(child.id, RoleType.childRoleTypes)
                : homeFolderAdaptorService.roleOwners(child.id)
        ]
        render(template : mode + "/responsibles", model : model)
    }

    def actions = {
        def list = new ArrayList(userSearchService.getHomeFolderById(Long.valueOf(params.id)).actions)
        Collections.reverse(list)
        return ["actions" : homeFolderAdaptorService.prepareActions(list)]
    }

    def mapping = {
        def mapping =
            externalHomeFolderService.getHomeFolderMapping(params.externalServiceLabel,
                Long.valueOf(params.homeFolderId))
        def id = mapping.externalId
        if (params.individualId) {
            mapping.individualsMappings.each {
                if (params.individualId.equals(it.individualId.toString())) {
                    mapping = it
                    return
                }
            }
        }
        if (request.get) {
            def model = [
                "externalServiceLabel" : params.externalServiceLabel,
                "homeFolderId" : params.homeFolderId,
                "individualId" : params.individualId,
                "id" : mapping.externalId
            ]
            render(template : "mapping", model : model)
        } else if (request.post) {
            mapping.externalId = params.id
            render ([status:"ok", success_msg:message(code:"message.updateDone"), "id" : params.id] as JSON)
        }
    }

    // TODO : move in request module
    def requests = {
        def result = [requests:[]]
        def homeFolderRequests =
            requestSearchService.getByHomeFolderId(Long.valueOf(params.id), false);

        homeFolderRequests.each {
          def record = requestAdaptorService.prepareRecordForSummaryView(it)
          result.requests.add(record)
        }
        return result
    }
    
    // TODO : move in payment module
    def payments = {
        def result = [payments:[]]
        
        for (Payment payment : this.paymentService.getByHomeFolder(Long.parseLong(params.id))) {
            result.payments.add([
                'id' : payment.id,
                'initializationDate' : payment.initializationDate,
                'state' : payment.state.toString(),
                'bankReference' : payment.bankReference,
                'amount' : payment.amount,
                'paymentMode' : message(code:"payment.mode."+payment.paymentMode.toString().toLowerCase())
            ])
        }
        
        return result
    }

    def meansOfContact = {
        return ["subMenuEntries" : subMenuEntries]
    }

    def moCs = {
        render(template : "moCs",
               model : ["moCs" : meansOfContactService.availableMeansOfContact])
    }

    def moC = {
        if (request.post) {
            def moc = meansOfContactService.getById(Long.valueOf(params.id))
            if (params.enabled == 'true') meansOfContactService.disableMeansOfContact(moc)
            else if (params.enabled == 'false') meansOfContactService.enableMeansOfContact(moc)
            render ([status : "success", success_msg : message(code : "message.updateDone")] as JSON)
        }
    }

    def importHomeFolders = {
        if (request.get) {
            render(view : "import", model : [
                "subMenuEntries" : subMenuEntries,
                "hasAdminEmail" : SecurityContext.currentSite.adminEmail
            ])
            return false
        } else if (request.post) {
            if (!SecurityContext.currentSite.adminEmail) {
                render (new JSON([status : "error",
                    error_msg : message(code : "homeFolder.import.error.noAdminEmail")]).toString())
                return false
            }
            def file = request.getFile("document")
            def doc
            try {
                doc = HomeFolderImportDocument.Factory.parse(file.inputStream)
                // first validate the data
                List<XmlError> errors = new ArrayList<XmlError>()
                XmlOptions options = new XmlOptions()
                options.setErrorListener(errors)
                doc.validate(options)
                if (!errors.isEmpty()) {
                    log.error "Got validation errors for current file"
                    for (XmlError error : errors) {
                        log.error "Message: ${error.getMessage()}"
                        log.error "Location of invalid XML: ${error.getCursorLocation().xmlText()}"
                    }
                    render (new JSON([status : "error",
                    error_msg : message(code : "homeFolder.import.error.invalidFile")]).toString())
                    return false
                }
            } catch (XmlException e) {
                render (new JSON([status : "error",
                    error_msg : message(code : "homeFolder.import.error.invalidFile")]).toString())
                return false
            } catch (IOException e) {
                render (new JSON([status : "error",
                    error_msg : message(code : "homeFolder.import.error.invalidFile")]).toString())
                return false
            }
            userWorkflowService.importHomeFolders(doc)
            render (new JSON([status : "ok", success_msg :
                message(code : "homeFolder.import.message.started",
                    args : [SecurityContext.currentSite.adminEmail])]).toString())
            return false
        }
    }

    protected List doSearch(state) {
        return userSearchService.get(prepareCriterias(state), prepareSort(state), defaultMax,
            params.currentOffset ? Integer.parseInt(params.currentOffset) : 0)
    }
    
    protected Set<Critere> prepareCriterias(state) {
        def mapper =[:]
        mapper.lastName = Critere.STARTSWITH
        mapper.firstName = Critere.STARTSWITH
        mapper.homeFolderId = Critere.EQUALS
        mapper.homeFolderState = Critere.EQUALS 
        mapper.isHomeFolderResponsible = Critere.EQUALS
        mapper.userState = Critere.EQUALS
        Set<Critere> criterias = new LinkedHashSet<Critere>()
        
        for(String key : state.keySet()){
            if(mapper.keySet().contains(key) && state."$key") {
                Critere criteria = new Critere()
                criteria.setAttribut(key)
                criteria.setComparatif(mapper[key].toString())
                if (key.equals('homeFolderId'))
                    criteria.setValue(LongUtils.stringToLong(state[key]))
                else
                    criteria.setValue(state[key])
                criterias.add(criteria)
            }
        }
        return criterias;
    }
    
    protected Map<String,String> prepareSort(state) {
        if(!state?.orderBy) state.orderBy = 'id'
        Map<String,String> result = new HashMap<String,String>();
        result.put("individual." + state.orderBy,'asc')
        return result
    }
    
    protected List buildHomeFolderStatusFilter() {
        def result = []
        result.add(['name':'true','i18nKey': message(code:'property.active')])
        result.add(['name':'false','i18nKey':message(code:'property.inactive')])
        return result
    }
    
    protected List buildHomeFolderStateFilter() {
        def result = []
        
        for(UserState state : UserState.allUserStates) {
            result.add([
                'name':state.toString(),
                'i18nKey': message(code:"user.state.${state.toString().toLowerCase()}")
            ])
        }
        return result;
    }

    def listTasks = {
        def state = [:]

        // TODO deal with pagination
        render(view : 'search', model: [
            'state': state,
            'records' : userSearchService.listTasks(QoS.forString(params.qoS), 0),
            'count' : userSearchService.countTasks(QoS.forString(params.qoS)),
            'max': 100,
            'homeFolderStates': buildHomeFolderStateFilter(),
            'currentSiteName': SecurityContext.currentSite.name,
            'homeFolderStatus' : buildHomeFolderStatusFilter(),
            'pageState' : (new JSON(state)).toString().encodeAsHTML(),
            'offset' : 0
        ]);
    }
}
