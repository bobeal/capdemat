import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.security.annotation.ContextType

public class SecurityService {

    /**
     * Define allowed controller/action pairs according to application
     * and user context (agent, unauthenticated ecitizen, ...).
     */
    private permissions = [
        (ContextType.ADMIN) : [
            (SecurityContext.BACK_OFFICE_CONTEXT) : [
                "backofficeAgent" : /.*/,
                "backofficeCategory" : /.*/,
                "backofficeLocalAuthority" : /.*/,
                "backofficeLogin" : /.*/,
                "backofficePayment" : /.*/
            ]
        ],
        (ContextType.AGENT) : [
            (SecurityContext.BACK_OFFICE_CONTEXT) : [
                "backofficeDocumentInstruction" : /.*/,
                "backofficeHomeFolder" : /.*/,
                "backofficeLogin" : /.*/,
                "backofficeRequest" : /.*/,
                "backofficeRequestInstruction" : /.*/,
                "backofficeRequestType" : /.*/,
                "backofficeStatistic" : /.*/
            ],
            (SecurityContext.FRONT_OFFICE_CONTEXT) : [
                "frontofficeRequestCreation" : /.*/,
                "frontofficeRequestType" : /.*/,
                "frontofficeDocument" : [/details/,/binary/],
                "frontofficeHome" : [/loginAgent/,/logout/]
            ]
        ],
        (ContextType.ECITIZEN) : [
            (SecurityContext.FRONT_OFFICE_CONTEXT) : /.*/
        ],
        (ContextType.UNAUTH_ECITIZEN) : [
            (SecurityContext.FRONT_OFFICE_CONTEXT) : [
                "frontofficeRequestCreation" : /.*/,
                "frontofficeHomeFolder" : /resetPassword/,
                "frontofficeHome" : [/loginAgent/, /login/, /test/],
                "frontofficeDocument" : [/details/, /binary/]
            ]
        ]
    ]

    /**
     * Define default entry point (controller/action)
     * according to application and user context.
     */
    private defaultPoints = [
        (ContextType.ADMIN) :
            [controller : "backofficeCategory", action : "list"],
        (ContextType.AGENT) : [
            (SecurityContext.BACK_OFFICE_CONTEXT) :
                [controller : "backofficeRequest", action : "taskBoard"],
            (SecurityContext.FRONT_OFFICE_CONTEXT) :
                [controller : "frontofficeRequestType", action : "index"]
        ],
        (ContextType.ECITIZEN) :
            [controller : "frontofficeHome", action : "index"],
        (ContextType.UNAUTH_ECITIZEN) :
            [controller : "frontofficeHome", action : "login"]
    ]

    /**
     * According to application and user context,
     * check whether requested controller and action are authorized.
     *
     * Return given controller and action if they are authorized,
     * default entry point otherwise.
     */
    public Map defineAccessPoint(ContextType contextType,
        String securityContext, String controller, String action) {
        if(!contextType) contextType = ContextType.UNAUTH_ECITIZEN
        if (!securityContext)
            securityContext = SecurityContext.FRONT_OFFICE_CONTEXT
        def current = [action : action, controller : controller]
        def contextPermissions = permissions[contextType][securityContext]
        if (contextPermissions == null) {
            return defaultPoints[contextType]
        }
        if (!(contextPermissions instanceof Map)
            && (controller =~ contextPermissions).matches()) {
            return current
        }
        def authorized = false
        if (contextPermissions[controller]) {
            def controllerPermissions = contextPermissions[controller]
            if (!(controllerPermissions instanceof List))
                controllerPermissions = [controllerPermissions]
            for(String regex : controllerPermissions) {
                if ((action =~ regex).matches()) {
                    authorized = true
                    break
                }
            }
        }
        if (authorized) return current
        else {
            def contextDefaultPoints = defaultPoints[contextType][securityContext]
            if (contextDefaultPoints == null)
                return defaultPoints[contextType]
            return contextDefaultPoints
        }
    }

    public void setEcitizenSessionInformation(ecitizenLogin,session) {
        session.currentEcitizen = ecitizenLogin
        session.frontContext = ContextType.ECITIZEN
        
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT)
        SecurityContext.setCurrentEcitizen(ecitizenLogin)
        
        def adult = SecurityContext.currentEcitizen
        session.currentEcitizenName = adult.firstName + " " + adult.lastName
    }
}
