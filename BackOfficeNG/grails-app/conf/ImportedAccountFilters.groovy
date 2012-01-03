import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;

class ImportedAccountFilters {

    IAgentService agentService

    def filters = {
        emailCheck(controller: 'frontofficeHomeFolder', action: 'editImportedAccount', invert: true) {
            before = {
                def ecitizen = SecurityContext.getCurrentEcitizen()
                def userId = SecurityContext.getCurrentUserId()
                if (userId != null && ecitizen != null &&
                    SecurityContext.getCurrentConfigurationBean().getDefaultEmail().equals(ecitizen.email)
                    && !agentService.exists(userId)) {
                    redirect(controller: "frontofficeHomeFolder", action: "editImportedAccount")
                    return false
                }
            }
        }
    }
}
