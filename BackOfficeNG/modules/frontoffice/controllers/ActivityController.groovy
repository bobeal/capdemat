import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Individual
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.business.request.Request
import fr.cg95.cvq.security.SecurityContext

class ActivityController {
    
    IRequestService defaultRequestService
    
    Adult ecitizen
    
    def afterInterceptor = { result ->
    
    	def calendar = Calendar.instance
    	
        result.year = calendar.get(Calendar.YEAR)
        result.month = calendar.get(Calendar.MONTH) + 1
        
        result.monthsNames = [:]
    	(1..12).each { it ->
    		calendar.set(Calendar.MONTH, it - 1)
    		result.monthsNames[it] = 
    			calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, SecurityContext.currentLocale)
    	}
    }
    
    def beforeInterceptor = {
        this.ecitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = { 
        def result = [:]
        
        if(params.yf && params.mf) {
            def dates = this.buildDate(Integer.valueOf(params.mf),Integer.valueOf(params.yf))
            result.activities = this.getActivities(dates.from.time,dates.to.time)
        }
        else result.activities = this.getActivities()
        
        session.activities = result.activities
        
        return result
    }
    
    def details = {
        def result = [:]
            
        if(!session.activities) {
            redirect(action:'index')
            return false
        }
            
        result.individual = params.name.decodeURL()
        result.label = params.label.decodeURL()
        result.datas = session.activities.get(result.individual.toString()).get(result.label.toString())

        return result
    }

    protected Map getActivities() {
        def dates = this.buildDate(
            Calendar.instance.get(Calendar.MONTH) + 1,
            Calendar.instance.get(Calendar.YEAR)
        )
        
        return this.getActivities(dates.from.time,dates.to.time)
    }
    
    protected Map getActivities(Date from, Date to) {
        def result = [:]
        
        for(Request r : defaultRequestService.getByHomeFolderId(ecitizen.homeFolder.id)) {
            def name = "${r.subjectFirstName} ${r.subjectLastName}"
            if(!result[name]) result[name] = [:]
            
            def map = defaultRequestService.getConsumptionsByRequest(r.id,from,to)
            if(map && !map.keySet().isEmpty()) {
                def label = r.requestType.label

                for(Date date : map.keySet()) { 
                    if(!result[name][label]) result[name][label] = [:]
                    if(!result[name][label]["${map.get(date)}".toString()])
                        result[name][label]["${map.get(date)}".toString()] = []
                    
                    result.get(name.toString()).get(label.toString()).get(map.get(date)).add(date)
                }
            }
            if(result[name].isEmpty()) result.remove(name.toString())
        }
        
        return result
    }
    
    protected Map buildDate(int month, int year) {
        def result = [
            from : new GregorianCalendar(),
            to: new GregorianCalendar()
        ]
        
        result.from.set( Calendar.YEAR, year)
        result.from.set( Calendar.MONTH, month - 1 )
        result.from.set( Calendar.DAY_OF_MONTH, 1 )
        
        result.to.set( Calendar.YEAR, year)
        result.to.set( Calendar.MONTH, month - 1 )
        result.to.set( Calendar.DAY_OF_MONTH, result.from.getActualMaximum(Calendar.DAY_OF_MONTH) )
        
        return result
    }
}
