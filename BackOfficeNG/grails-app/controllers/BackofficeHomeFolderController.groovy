import com.google.gson.JsonObject
import grails.converters.JSON
import java.io.IOException
import java.util.ArrayList
import java.util.Collections

import fr.cg95.cvq.schema.ximport.HomeFolderImportDocument
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.service.users.IUserWorkflowService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.business.users.*
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.service.users.IMeansOfContactService
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService
import fr.cg95.cvq.business.payment.Payment

import org.apache.xmlbeans.XmlError
import org.apache.xmlbeans.XmlException
import org.apache.xmlbeans.XmlOptions

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap

class BackofficeHomeFolderController {

    IHomeFolderService homeFolderService
    IExternalHomeFolderService externalHomeFolderService
    IIndividualService individualService
    IUserWorkflowService userWorkflowService
    IRequestSearchService requestSearchService
    IPaymentService paymentService
    IMeansOfContactService meansOfContactService
    
    def instructionService
    def translationService
    def homeFolderAdaptorService
    def requestAdaptorService
    def individualAdaptorService

    def defaultAction = 'search'
    def defaultMax = 15

    def beforeInterceptor = {
        session["currentMenu"] = "users"
    }

    def help = {}
    
    def search = {
        def state = [:], records = [], count = 0
        if (params.pageState) state = JSON.parse(params.pageState)
        
        if(!request.get) {
            records = this.doSearch(state)
            count = individualService.getCount(this.prepareCriterias(state))
        }
        
        return ([
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
        def result = [responsibles:[:],adults:[],children:[]]
        HomeFolder homeFolder = this.homeFolderService.getById(Long.parseLong(params.id))
        Adult adult = homeFolderService.getHomeFolderResponsible(homeFolder.id)
        
        result.homeFolder = homeFolder
        result.homeFolderResponsible = adult
        result.adults = this.homeFolderService.getAdults(Long.parseLong(params.id)).findAll { it.id != adult.id }
        result.children = this.homeFolderService.getChildren(Long.parseLong(params.id))
        result.homeFolderState = homeFolder.state.toString().toLowerCase()
        result.homeFolderStatus = homeFolder.enabled ? 'enable' : 'disable'
        result.responsableLogin = adult.login
        
        for(Child child : result.children)
            result.responsibles.put(child.id, homeFolderService.listBySubjectRoles(child.id, RoleType.childRoleTypes))

        result.identifierMappings =
            externalHomeFolderService.getHomeFolderMappings(homeFolder.id).collect { [
                "externalServiceLabel" : it.externalServiceLabel,
                "homeFolderId" : it.homeFolderId,
                "externalId" : it.externalId,
                "individualMappings" : it.individualsMappings.collect { [
                    "individual" : individualService.getById(it.individualId),
                    "externalId" : it.externalId
                ] }
            ] }
        return result
    }

    def adult = { 
        def adult = !params.id ? new Adult() : individualService.getAdultById(Long.valueOf(params.id))
        def mode = params.mode 
        def template = !params.id ? 'adult' : params.template
        if (request.post) {
            bind(adult)
            mode = 'static'
            if (!adult.id) {
                def homeFolder = homeFolderService.getById(Long.valueOf(params.homeFolderId))
                individualService.create(adult, homeFolder, homeFolder.address, false)
            }
        }
        render(template: mode + '/' + template, model:['adult': adult])
    }

    def child = {
        def child = !params.id ? new Child() : individualService.getChildById(Long.valueOf(params.id))
        def mode = params.mode
        def template = !params.id ? 'child' : params.template
        if (request.post) {
            bind(child)
            mode = 'static'
            if (child.id) {
                homeFolderService.removeRolesOnSubject(child.homeFolder.id, child.id)
                params.roles.each {
                    if (it.value instanceof GrailsParameterMap && it.value.owner != '' && it.value.type != '') {
                        homeFolderService.addRole(individualService.getById(Long.valueOf(it.value.owner)),
                            child, child.homeFolder.id, RoleType.forString(it.value.type))
                    }
                }
            } else {
                def homeFolder = homeFolderService.getById(Long.valueOf(params.homeFolderId))
                individualService.create(child, homeFolder, homeFolder.address, false)
            }
        }
        def models = ['child': child]
        if (child.id) {
            models['adults'] = homeFolderService.getAdults(child.homeFolder.id)
            models['roleOwners'] = homeFolderService.listBySubjectRoles(child.id, RoleType.childRoleTypes)
        }
        render(template: mode + '/' + template, model: models)
    }

    def homeFolder = {
        def homeFolder = homeFolderService.getById(Long.valueOf(params.id))
        def mode = params.mode
        if (request.post) {
            bind(homeFolder)
            mode = 'static'
        }
        render(template: mode + '/' + params.template, model:['homeFolder': homeFolder])
    }

    def state = {
        def user
        try {
            user = individualService.getById(params.long("id"))
        } catch (CvqObjectNotFoundException) {
            user = homeFolderService.getById(params.long("id"))
        }
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            userWorkflowService.changeState(user, UserState.forString(params.state))
        }
        render(template : mode + "/state", model : [
            "user" : user, "states" : userWorkflowService.getPossibleTransitions(user.state)])
    }

    def address = {
        def adult = individualService.getAdultById(params.long("id"))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            def temp = new Address()
            bind(temp)
            individualAdaptorService.historize(
                adult, adult.address, temp, "address",
                ["additionalDeliveryInformation", "additionalGeographicalInformation", "city",
                    "cityInseeCode", "countryName", "placeNameOrService", "postalCode",
                    "streetMatriculation", "streetName", "streetNumber", "streetRivoliCode"])
        }
        render(template : mode + "/address", model : ["user" : adult])
    }

    def contact = {
        def adult = individualService.getAdultById(params.long("id"))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            def temp = new Adult()
            bind(temp)
            individualAdaptorService.historize(
                adult, adult, temp, "contact", ["email", "homePhone", "mobilePhone", "officePhone"])
        }
        render(template : mode + "/contact", model : ["adult" : adult])
    }

    def identity = {
        def individual = individualService.getById(params.long("id"))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            def temp = new Adult()
            bind(temp)
            individualAdaptorService.historize(
                individual, individual, temp, "contact",
                individual instanceof Adult ?
                    ["title", "familyStatus", "lastName", "maidenName", "nameOfUse", "firstName", "firstName2", "firstName3", "profession"] :
                    ["lastName", "firstName", "firstName2", "firstName3", "birthDate", "birthPostalCode", "birthCity", "birthCountry"])
        }
        render(template : mode + "/" + individual.class.simpleName.toLowerCase() + "Identity",
            model : ["individual" : individual])
    }

    def responsibles = {
        def child = individualService.getChildById(Long.valueOf(params.id))
        def mode = request.get ? params.mode : "static"
        if (request.post) {
            child.homeFolder.individuals.each {
                homeFolderService.unlink(it, child)
            }
            params.roles.each {
                if (it.value instanceof GrailsParameterMap && it.value.owner != '' && it.value.type != '') {
                    homeFolderService.link(individualService.getById(Long.valueOf(it.value.owner)),
                        child, [RoleType.forString(it.value.type)] as List)
                }
            }
        }
        def model = [
            "child" : child,
            "adults" : homeFolderService.getAdults(child.homeFolder.id),
            "roleOwners" : homeFolderService.listBySubjectRoles(child.id, RoleType.childRoleTypes)
        ]
        render(template : mode + "/responsibles", model : model)
    }

    def actions = {
        def list = new ArrayList(homeFolderService.getById(Long.valueOf(params.id)).actions)
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
        return ["subMenuEntries" : ["homeFolder.meansOfContact", "homeFolder.importHomeFolders"]]
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
                "subMenuEntries" : ["homeFolder.meansOfContact", "homeFolder.importHomeFolders"],
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
            homeFolderService.importHomeFolders(doc)
            render (new JSON([status : "ok", success_msg :
                message(code : "homeFolder.import.message.started",
                    args : [SecurityContext.currentSite.adminEmail])]).toString())
            return false
        }
    }

    protected List doSearch(state) {
        def result = []
        def individuals = individualService.get(this.prepareCriterias(state),
            this.prepareSort(state),this.defaultMax,
            params.currentOffset ? Integer.parseInt(params.currentOffset) : 0)
        
        for(Individual indv : individuals) {
            def entry = [
                'id' : indv.id,
                "state" : indv.state,
                'lastName' : indv.lastName,
                'firstName' : indv.firstName,
                'homeFolderId' : indv.homeFolder?.id,
                "homeFolderState" : indv.homeFolder?.state,
                'streetName' : indv.address.streetName,
                'streetNumber' : indv.address.streetNumber,
                'postalCode': indv.address.postalCode,
                'city' : indv.address.city,
                'birthDate': indv instanceof Child ? indv.birthDate : null,
                'birthCity': indv instanceof Child ? indv.birthCity : null
            ]
            if(!result.contains(entry)) result.add(entry)
        }
        
        return result
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
}
