import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.security.SecurityContext

class ActivityController {
    
    IRequestService defaultRequestService
    
    Adult ecitizen
    
    def afterInterceptor = { result ->
        result.year = Calendar.instance.get(Calendar.YEAR)
        result.month = (Calendar.instance.get(Calendar.MONTH) + 1)
    }
    
    def beforeInterceptor = {
        this.ecitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def details = {
        def result = [:]
        
        if(!session.activities) {
            redirect(action:'index')
            return false
        }
        
        result.individual = params.id.decodeURL()
        return result
    }
    
    def index = { 
        def result = [:]
        
        if(params.yf && params.mf) {
            def dates = this.buildDate(params.mf,params.yf)
            result.activities = this.getActivities(dates.from.time,dates.to.time)
        }
        else result.activities = this.activities
        
        session.activities = result.activities
        
        return result
    }
    
    protected Map getActivities() {
        def dates = this.buildDate(
            (Calendar.instance.get(Calendar.MONTH) + 1).toString(),
            Calendar.instance.get(Calendar.YEAR).toString()
        )
        return this.getActivities(dates.from.time,dates.to.time)
    }
    
    protected Map getActivities(Date from, Date to) {
        def result = [:]
        
        for(Request r : defaultRequestService.getByHomeFolderId(ecitizen.homeFolder.id)) {
            def name = "${r.subjectFirstName} ${r.subjectLastName}"
            if(!result[name]) result[name] = [:]
            
            def map = defaultRequestService.getConsumptionsByRequest(r.id,from,to)
            if(map && map.keySet().size() > 0) {
                for(Date date : map.keySet()) {
                    def label = r.requestType.label
                    
                    if(!result[name][label]) result[name][label] = [:]
                    if(!result[name][label]["${map.get(date)}".toString()])
                        result[name][label]["${map.get(date)}".toString()] = []
                    
                    result.get(name.toString()).get(label.toString()).get(map.get(date)).add(date)
//                    if(!result[name][map.get(date)]) result[name][map.get(date)] = []
//                    if(map.get(date) == 'Gard Matin et Soir')
//                        println "$name - ${map.get(date)} (${result[name][map.get(date)].size()}) - ${result[name][map.get(date)]}"
//                    result[name][map.get(date)].add(date)
                }
            }
            if(result[name].size() == 0) result.remove(name.toString())
        }
        return result;
    }
    
    protected Map buildDate (String month,String year) {
        def result = [
            from : new GregorianCalendar(),
            to: new GregorianCalendar()
        ]
        
        result.from.set( Calendar.ERA, GregorianCalendar.AD )
        result.from.set( Calendar.YEAR, Integer.valueOf(year) )
        result.from.set( Calendar.MONTH, Integer.valueOf(month) - 1 )
        result.from.set( Calendar.DATE, 1 )
        
        result.to.set( Calendar.ERA, GregorianCalendar.AD )
        result.to.set( Calendar.YEAR, Integer.valueOf(year) )
        result.to.set( Calendar.MONTH, Integer.valueOf(month) - 1 )
        result.to.set( Calendar.DATE, result.from.getActualMaximum(Calendar.DAY_OF_MONTH) )
        
        return result;
    }
    
}
