import grails.converters.JSON
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.service.users.IIndividualService
import fr.cg95.cvq.util.Critere
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.business.users.ActorState

class HomeFolderController {
    
    IHomeFolderService homeFolderService
    IIndividualService individualService
    
    def defaultAction = "index"
    def defaultMax = 15
    
    def beforeInterceptor = {}
    def idex = {}
    
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
            'actorStates': this.buildActorStateFilter(),
            'homeFolderStates' : this.buildHomeFolderFilter(),
            'pageState' : (new JSON(state)).toString().encodeAsHTML(),
            'offset' : params?.currentOffset ? params.currentOffset : 0 
        ]);
    }
    
    protected List doSearch(state) {
        def result = []
        def found = individualService.get(this.prepareCriterias(state),
            this.prepareSort(state),this.defaultMax,
            params?.currentOffset ? Integer.parseInt(params.currentOffset) : 0)
        
        for(Individual human : found) {
            def entry = [
                'id' : human.id,
                'lastName' : human.lastName,
                'firstName' : human.firstName,
                'homeFolderId' : human?.homeFolder?.id
            ]
            if(!result.contains(entry)) result.add(entry)
        }
        
        return result
    }
    
    protected Set<Critere> prepareCriterias(state) {
        def mapper = ['lastName','homeFolderId','individualId','isHomeFolderResponsible']
        Set<Critere> criterias = new LinkedHashSet<Critere>()
        
        for(String key : state.keySet()){
            if(mapper.contains(key) && state?."$key") {
                Critere criteria = new Critere()
                criteria.setAttribut(key)
                criteria.setComparatif(Critere.EQUALS)
                criteria.setValue(state[key])
                criterias.add(criteria)
            }
        }
        return criterias;
    }
    
    protected Map<String,String> prepareSort(state) {
        if(state?.orderBy) {
            Map<String,String> result = new HashMap<String,String>();
            result.put("individual." + state.orderBy,'asc')
            return result
        } else {
            return null
        }
    }
    
    protected List buildHomeFolderFilter() {
        def result = []
        result.add(['name':'enabled','i18nKey': message(code:'property.enabled')])
        result.add(['name':'disabled','i18nKey':message(code:'property.disabled')])
        return result
    }
    
    protected List buildActorStateFilter() {
        def result = []
        
        for(ActorState state : ActorState.allActorStates) {
            result.add([
                'name':state.toString(),
                'i18nKey': message(code:"individual.actorState.${state.toString()}")
            ])
        }
        return result;
    }
}
