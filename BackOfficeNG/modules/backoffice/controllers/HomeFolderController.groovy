import grails.converters.JSON
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.ActorState
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.business.users.Child
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.payment.IPaymentService
import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.users.payment.Payment

class HomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IRequestService defaultRequestService
    IPaymentService paymentService
    
    def instructionService
    def translationService
    def defaultAction = 'search'
    def defaultMax = 15
    
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
            'offset' : params?.currentOffset ? params.currentOffset : 0 
        ]);
    }
    
    def details = {
        def result = [responsibles:[:],adults:[],children:[]]
        HomeFolder folder = this.homeFolderService.getById(Long.parseLong(params.id))
        
        result.adults = this.homeFolderService.getAdults(Long.parseLong(params.id))
        result.children = this.homeFolderService.getChildren(Long.parseLong(params.id))
        result.homeFolderState = folder.state.toString().toLowerCase()
        result.homeFolderStatus = folder.enabled ? 'enable' : 'disable'
        
        for(Child child : result.children)
            result.responsibles.put(child.id, homeFolderService.getBySubjectRoles(child.id,
                [RoleType.CLR_FATHER,RoleType.CLR_MOTHER,RoleType.CLR_TUTOR] as RoleType[]))
        
        return result
    }
    
    def requests = {
        def result = [requests:[]]
        //def request = defaultRequestService.getById(Long.valueOf(params.id))
        def homeFolderRequests = defaultRequestService.getByHomeFolderId(Long.valueOf(params.id));
        def homeFolder = homeFolderService.getById(Long.valueOf(params.id))

        homeFolderRequests.each {
          def quality = 'green'
          if (it.redAlert) quality = 'red'
          else if (it.orangeAlert) quality = 'orange'
          def record = [
              'id':it.id,
              'label':translationService.getEncodedRequestTypeLabelTranslation(it.requestType.label),
              'creationDate':it.creationDate,
              'requesterLastName':it.requesterLastName + " " + it.requesterFirstName,
              'subjectLastName':it.subjectId ? it.subjectLastName + " " + it.subjectFirstName : "",
              'homeFolderId':it.homeFolderId,
              'state':it.state.toString(),
              'lastModificationDate':it.lastModificationDate,
              'lastInterveningAgentId': instructionService.getActionPosterDetails(it.lastInterveningAgentId),
              'permanent':!homeFolder.boundToRequest,
              'quality':quality
          ]
          result.requests.add(record)
        }
        return result
        //render(template:'homeFolderRequests', model: ['records': records])
    }
    
    def payments = {
        def result = [payments:[]]
        HomeFolder homefolder = this.homeFolderService.getById(Long.parseLong(params.id))
        
        for(Payment payment : this.paymentService.getByHomeFolder(homefolder)) {
            result.payments.add([
                'id' : payment.id,
                'initializationDate' : payment.initializationDate,
                'state' : payment.state.toString(),
                'bankReference' : payment.bankReference,
                'amount' : payment.euroAmount,
                'paymentMode' : message(code:"payment.mode."+payment.paymentMode.toString())
            ])
        }
        
        return result
    }
    
    protected List doSearch(state) {
        def result = []
        def found = individualService.get(this.prepareCriterias(state),
            this.prepareSort(state),this.defaultMax,
            params?.currentOffset ? Integer.parseInt(params.currentOffset) : 0)
        
        for(Individual human : found) {
            def entry = [
                'id' : human.id,
                'state' : human.state,
                'lastName' : human.lastName,
                'firstName' : human.firstName,
                'homeFolderId' : human?.homeFolder?.id,
                'streetName' : human.adress.streetName,
                'streetNumber' : human.adress.streetNumber,
                'postalCode': human.adress.postalCode,
                'city' : human.adress.city,
                'bornOn': human instanceof Child ? human.birthDate : null,
                'bornIn': human instanceof Child ? human.birthCity : null
                
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
        mapper.homeFolderStatus = Critere.EQUALS
        mapper.isHomeFolderResponsible = Critere.EQUALS
        
        Set<Critere> criterias = new LinkedHashSet<Critere>()
        
        for(String key : state.keySet()){
            if(mapper.keySet().contains(key) && state?."$key") {
                Critere criteria = new Critere()
                criteria.setAttribut(key)
                criteria.setComparatif(mapper[key].toString())
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
        
        for(ActorState state : ActorState.allActorStates) {
            result.add([
                'name':state.toString(),
                'i18nKey': message(code:"actor.state.${state.toString().toLowerCase()}")
            ])
        }
        return result;
    }
}
