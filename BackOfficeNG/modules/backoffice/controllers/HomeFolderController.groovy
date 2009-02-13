import grails.converters.JSON
import fr.cg95.cvq.service.users.IHomeFolderService

class HomeFolderController {
    
    IHomeFolderService homeFolderService
    
    def defaultAction = "index"
    def beforeInterceptor = {}
    def idex = {}
    
    def search = {
        def state = [:]
        if (params.pageState) state = JSON.parse(params.pageState);
        
        if(request.get) {
            
        } else {
            
        }
        
        return ([
            'state': state,
            'pageState' : (new JSON(state)).toString().encodeAsHTML()
        ]);
    }
}
