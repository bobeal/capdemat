import fr.cg95.cvq.security.SecurityContext
import grails.converters.JSON

public class SystemController {
    def securityService

    def error = {
        def exception = request.exception
        def currentSiteDisplayTitle = SecurityContext.currentSite.displayTitle
        def temporary = SecurityContext.currentEcitizen?.homeFolder?.isTemporary()

        log.error "Error intercepted by system controller : ${exception}"
        session.doRollback = true

        if (ExceptionUtils.isModelException(exception) && ExceptionUtils.isXRequestError(request))
            render(["status":"modelException", 
                    "message":exception.message, 
                    "i18nkey":message(code:ExceptionUtils.getModelI18nKey(exception),args:ExceptionUtils.getModelI18nArgs(exception))] as JSON)
        else if (ExceptionUtils.isPermissionException(exception) && ExceptionUtils.isXRequestError(request))
            render(["status":"modelException", 
                    "message":exception.message, 
                    "i18nkey":message(code:'error.permission')] as JSON)
        else if (ExceptionUtils.isOAuth2Exception(exception)) {
            response.status = exception.getCause().getHttpErrorCode()
            render(["error": exception.getCause().getErrorCode(), 
                    "error_description": exception.getCause().getMessage()] as JSON)
        } else if (session.frontContext) {
            def concurrentModificationException = ExceptionUtils.extractConcurrentModificationException(exception)
            if (concurrentModificationException != null) {
                render(view : "concurrentModification", model : [
                    "i18nKey" : concurrentModificationException.i18nKey,
                    "i18nArgs" : concurrentModificationException.i18nArgs])
            } else if (ExceptionUtils.isModelException(exception)) {
                return [
                    "temporary" : temporary,
                    "i18nKey" : ExceptionUtils.getModelI18nKey(exception),
                    "i18nArgs" : ExceptionUtils.getModelI18nArgs(exception)
                ]
            } else if (ExceptionUtils.isPermissionException(exception)) {
                return [
                    "temporary" : temporary,
                    "i18nKey" : message(code:'error.permission'),
                    "i18nArgs" : []
                ]
            } else return ["temporary" : temporary]
        } else
            render(view: "/error", 
                model:['currentSite': currentSiteDisplayTitle,
                       'errorMessage': message(code:ExceptionUtils.getModelI18nKey(exception),args:ExceptionUtils.getModelI18nArgs(exception))])
    }
}
