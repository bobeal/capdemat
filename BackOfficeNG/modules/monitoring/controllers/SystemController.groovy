
class SystemController {
    
    def monitoringService
    
    def index = {
        return ['systemInfo' : monitoringService.getSystemInformation()]
    }
}