import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class LoginController {

    def defaultAction = "logout"

    def logout = {
       	session.currentUser = null
        session.currentCredentialBean = null
       	if (CH.config.cas_mocking == "true")
       		response.sendRedirect('/BackOfficeNG/cas.gsp')
       	else
       		redirect(url:CH.config.cas_logout_url)
       	return false
    }
}
