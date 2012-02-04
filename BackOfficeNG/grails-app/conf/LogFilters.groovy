class LogFilters {
    def filters = {
        logBefore(controller: '*', action: '*') {
            before = {
                log.info(
                    session.currentEcitizenId
                    + " " + session.currentCredentialBean
                    + " " + request.method.toUpperCase()
                    + " /" + controllerName
                    + "/" + actionName)
            }
        }
    }
}
