import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.security.annotation.ContextType

public class SecurityService {
    protected Map permissions
    protected Map defaultPoints = [:]
    
    public Map defineAccessPoint(ContextType context,String controller,String action) {
        this.initPermissionsMap()
        if(!context) context = ContextType.UNAUTH_ECITIZEN
        
        def current = [action:action,controller:controller], factor = false
        def permission = this.permissions[context.value()]
        
        if(!(permission instanceof Map) && (controller =~ permission).matches()) { 
            return current
        } else if (permission instanceof Map && permission[controller]) {
            def list = permission[controller]
            if(!(list instanceof List)) list = [list]
            
            for(String regex : list) factor = (action =~ regex).matches() || factor
            
            if(factor) return current
            else return (Map) defaultPoints[context.value()]
            
        } else {
            return (Map) defaultPoints[context.value()]
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
    
    protected void initPermissionsMap() {
        if(this.permissions) return
        
        defaultPoints[ContextType.AGENT.value()] = [controller:'frontofficeRequestType',action:'index']
        defaultPoints[ContextType.UNAUTH_ECITIZEN.value()] = [ controller:'frontofficeHome',action:'login']
        
        this.permissions = [:]
        this.permissions[ContextType.ECITIZEN.value()] = /.*/
        this.permissions[ContextType.AGENT.value()] = [
            'frontofficeRequestCreation' : /.*/,
            'frontofficeRequestType' : /.*/,
            'frontofficeDocument' : [/details/,/binary/],
            'frontofficeHome' : /logout/
        ]
        this.permissions[ContextType.UNAUTH_ECITIZEN.value()] = [
            'frontofficeVOCardRequestCreation' : /.*/,
            'frontofficeRequestCreation' : /.*/,
            'frontofficeHomeFolder' : /resetPassword/,
            'frontofficeHome' : [/loginAgent/,/login/,/test/],
            'frontofficeDocument' : [/details/,/binary/]
        ]
    }
}
