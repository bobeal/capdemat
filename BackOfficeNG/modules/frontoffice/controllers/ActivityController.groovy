import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.security.SecurityContext

class ActivityController {
    
    IRequestService defaultRequestService
    
    Adult ecitizen
    
    def afterInterceptor = { result ->
        
    }
    
    def beforeInterceptor = {
        this.ecitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = { 
        def result = [:]
        println this.activities
        return result
    }
    
    protected Map getActivities() {
        def now = new Date(), from = now - 30, to = now + 30
        return this.getActivities(now,to)
    }
    
    protected Map getActivities(Date from, Date to) {
        def result = [:], individuals = this.ecitizen.homeFolder.individuals
        for(Individual individual : individuals) {
            def name = "${individual.firstName} ${individual.lastName}" 
            result["${individual.firstName} ${individual.lastName}"] = [:]
            
            for(Request r : defaultRequestService.getBySubjectId(individual.id)) {
                def map = defaultRequestService.getConsumptionsByRequest(r.id,from,to)
                if(map && map.keySet().size() > 0) {
                    for(Date date : map.keySet()) {
                        if(!result[name][map.get(date)]) result[name][map.get(date)] = []
                        result[name][map.get(date)].add(date)
                    }
                }
            }
            if(result[name].size() == 0) result.remove(name.toString())
        }
        return result;
    }
    
}
