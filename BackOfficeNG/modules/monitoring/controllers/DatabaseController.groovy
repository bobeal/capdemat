

public class DatabaseController {
    
    def monitoringService
    
    def index = { 
        def authorities = monitoringService.getLocalAuthorities() as List
        def authoritiy = !params?.authorityName ? authorities.get(0) : params.authorityName 
        def stats = monitoringService.getDatabaseInformation(authoritiy);
        //
        //render service.queries
        if(!params?.authorityName)
        return [
            authorities : authorities,
            authoritiy : authoritiy,
            stats : stats
        ]
    }
    
}
