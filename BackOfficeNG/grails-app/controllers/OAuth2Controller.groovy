import fr.cg95.cvq.exception.CvqAuthenticationFailedException
import fr.cg95.cvq.exception.CvqDisabledAccountException
import fr.cg95.cvq.exception.CvqUnknownUserException
import fr.cg95.cvq.oauth2.IAuthorizationServerInfosService;
import fr.cg95.cvq.oauth2.IOAuth2Service
import fr.cg95.cvq.oauth2.model.Token

import grails.converters.JSON

class OAuth2Controller {

    def securityService

    IOAuth2Service oauth2Service
    IAuthorizationServerInfosService authorizationServerInfosService

    def askLogin = {
        if (session?.currentEcitizenId == null) {
            def callback = createLink(controller:'frontofficeHome').toString()
            def url = oauth2Service.authorizationRequestUri(callback)
            if (url != null) {
                redirect(url:url)
                return false
            }
        }
        // TODO add flash error
        redirect(controller:'frontofficeHome')
        return false
    }

    def login = {
        if (params.code != null) {
            Token t = oauth2Service.authorizationCodeGrant(params.code)
            if (t != null) {
                try {
                    securityService.setEcitizenSessionInformation(
                        oauth2Service.authenticate(t.getAccessToken()), session)
                    params.state ? redirect(uri:(params.state - request.contextPath)) : redirect(controller:"frontofficeHome")
                    return false
                } catch (CvqUnknownUserException e) {
                    error = "account.error.authenticationFailed"
                } catch (CvqAuthenticationFailedException e) {
                    error = "account.error.authenticationFailed"
                } catch (CvqDisabledAccountException e) {
                    error = "account.error.disabledAccount"
                }
            }
        }
        // TODO add flash error
        redirect(controller:'frontofficeHome')
        return false
    }

    def logout = {
        securityService.logout(session)
        def callbackUrl = request.getRequestURL().toString().replaceFirst(request.getRequestURI(), "") +
            createLink(controller:'frontofficeHome').toString()
        redirect(url: authorizationServerInfosService.getLogoutUri() + "?callback=" + callbackUrl)
        return false
    }

    def invalidScope = {
        log.info("Insufficient scope : the request requires higher privileges than provided by the access token.");
        response.setStatus(403);
        render([error : "insufficient_scope",
            error_description : "The request requires higher privileges than provided by the access token."] as JSON);
        return false;
    }

}
