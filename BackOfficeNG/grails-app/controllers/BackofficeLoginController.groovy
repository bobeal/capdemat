import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import fr.cg95.cvq.util.web.filter.CASFilter

class BackofficeLoginController {

    def defaultAction = "logout"

    def logout = {
        session.currentUser = null
        session.currentCredentialBean = null
        session.removeAttribute(CASFilter.CAS_FILTER_USER)
        session.removeAttribute(CASFilter.CAS_FILTER_RECEIPT)

        if (CH.config.cas_mocking == "true")
            response.sendRedirect('/CapDemat/cas.gsp')
        else
            redirect(url:CH.config.cas_logout_url)
        return false
    }
}
