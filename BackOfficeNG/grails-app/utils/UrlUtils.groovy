import grails.util.GrailsUtil;

import org.codehaus.groovy.grails.commons.GrailsApplication;
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib
import org.springframework.web.context.request.RequestContextHolder as RCH

class UrlUtils {

    static def g = new ApplicationTagLib()

    public static toFullUrl(controller, action, params) {
        def fullUrl = null
        def currentRequest = RCH.currentRequestAttributes().getCurrentRequest()
        if (GrailsUtil.getEnvironment().equals(GrailsApplication.ENV_PRODUCTION))
            fullUrl = "https://${currentRequest.serverName}"
        else
            fullUrl = "http://${currentRequest.serverName}:${currentRequest.serverPort}"

        fullUrl += g.createLink(controller:controller, action:action, params: params)

        return fullUrl
    }
}
