class HomeController {

	def securityService

	def defaultAction = 'home'

    def home = {
       def point = securityService.defineAccessPoint(
               session.currentCredentialBean.hasSiteAdminRole() ?
                   ContextType.ADMIN : ContextType.AGENT,
               SecurityContext.BACK_OFFICE_CONTEXT,
               null, null)
       redirect(controller: point.controller, action: point.action)
    }
}
