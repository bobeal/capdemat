class HomeController {

	def defaultAction = 'home'

    def home = {
       if (session.currentCredentialBean.hasSiteAgentRole())
           redirect(controller:'backofficeRequest',action:'taskBoard')
       else if (session.currentCredentialBean.hasSiteAdminRole())
           redirect(controller:'backofficeLocalAuthority')
    }
}
