import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.security.SecurityContext

class HomeFolderController {

    IHomeFolderService homeFolderService
    Adult currentEcitizen;

    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = {
        def result = [:]
        def homeFolderId = currentEcitizen.homeFolder.id
        result.adults = homeFolderService.getAdults(homeFolderId)
        result.children = homeFolderService.getChildren(homeFolderId)
        result.homeFolder = currentEcitizen.homeFolder

        return result
    }
}
