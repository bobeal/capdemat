import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.users.IIndividualService
import grails.converters.JSON

/**
 * Provides facilities for performance testing 
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */

public class PerformanceController {
    
    def performanceService
    IIndividualService individualService
    
    def beforeInterceptor = {}
    
    def index = {
        redirect(action:'test')
        return false
    }
    
    def test = {
        params.each{println it}
        render('rafik.dj|bbbbbbbb')
    }
    
    def randomSubject = {
        def individuals = []
        Adult a =  individualService.getAdultById(Long.parseLong(params.subjectId))
        a.homeFolder.individuals.each{if(!a.id.equals(it.id) && it instanceof Adult) individuals.add(it.id)}
        render("subjectId=${individuals.get((new Random()).nextInt(individuals.size()))}")
    }
    
    def createHomeFolder = {
        def hf = performanceService.createHomeFolder(SecurityContext.getCurrentSite().getName())
//        performanceService.createDrafts((HomeFolder)hf.homeFolder)
        
        render("${hf.adult1.login}|${hf.password}|subjectId=${hf.adult1.id}")
    }
    
    def removeDrafts = {
        render (performanceService.removeDrafts(params.login)) as JSON
    }
}