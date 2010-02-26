import grails.converters.JSON
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.ActorState
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.business.users.Child
import fr.cg95.cvq.business.users.RoleType
import fr.cg95.cvq.service.request.IRequestSearchService
import fr.cg95.cvq.service.payment.IPaymentService
import fr.cg95.cvq.business.users.HomeFolder
import fr.cg95.cvq.business.payment.Payment
import fr.cg95.cvq.business.users.Adult

class BackofficeHomeFolderController {

    IHomeFolderService homeFolderService
    IIndividualService individualService
    IRequestSearchService requestSearchService
    IPaymentService paymentService
    
    def instructionService
    def translationService
    def requestAdaptorService

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
            'offset' : params.currentOffset ? params.currentOffset : 0 
        ]);
    }
    
    def details = {
        def result = [responsibles:[:],adults:[],children:[]]
        HomeFolder homeFolder = this.homeFolderService.getById(Long.parseLong(params.id))
        Adult adult = homeFolderService.getHomeFolderResponsible(homeFolder.id)
        
        result.adults = this.homeFolderService.getAdults(Long.parseLong(params.id))
        result.children = this.homeFolderService.getChildren(Long.parseLong(params.id))
        result.homeFolderState = homeFolder.state.toString().toLowerCase()
        result.homeFolderStatus = homeFolder.enabled ? 'enable' : 'disable'
        result.responsableLogin = adult.login
        
        for(Child child : result.children)
            result.responsibles.put(child.id, homeFolderService.getBySubjectRoles(child.id,
                [RoleType.CLR_FATHER,RoleType.CLR_MOTHER,RoleType.CLR_TUTOR] as RoleType[]))
        
        return result
    }
    
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
    
    protected List doSearch(state) {
        def result = []
        def individuals = individualService.get(this.prepareCriterias(state),
            this.prepareSort(state),this.defaultMax,
            params.currentOffset ? Integer.parseInt(params.currentOffset) : 0)
        
        for(Individual indv : individuals) {
            def entry = [
                'id' : indv.id,
                'state' : indv.homeFolder?.state,
                'status' : indv.homeFolder?.enabled,
                'lastName' : indv.lastName,
                'firstName' : indv.firstName,
                'homeFolderId' : indv.homeFolder?.id,
                'streetName' : indv.adress.streetName,
                'streetNumber' : indv.adress.streetNumber,
                'postalCode': indv.adress.postalCode,
                'city' : indv.adress.city,
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
        mapper.homeFolderStatus = Critere.EQUALS
        mapper.isHomeFolderResponsible = Critere.EQUALS
        
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
        
        for(ActorState state : ActorState.allActorStates) {
            result.add([
                'name':state.toString(),
                'i18nKey': message(code:"actor.state.${state.toString().toLowerCase()}")
            ])
        }
        return result;
    }
}
