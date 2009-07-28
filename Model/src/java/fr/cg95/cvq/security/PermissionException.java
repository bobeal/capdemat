package fr.cg95.cvq.security;

import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;

public class PermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String fullMessage;

    public PermissionException(Class<?> c, String methodName, ContextType type, 
            ContextPrivilege privilege, String message) {
        super("");

        StringBuffer sb = new StringBuffer().append("denied access to ").append(c.getName())
                .append(".").append(methodName).append(" with type ").append(type)
                .append(" and privilege ").append(privilege).append(" for ")
                .append(SecurityContext.getCurrentUserLogin()).append(" (")
                .append(SecurityContext.getCurrentUserId() + ")");

        if (message != null)
            sb.append(" - additional information : ").append(message);
        
        this.fullMessage = sb.toString();
    }
    
    @Override
    public String getMessage() {
        return this.fullMessage;
    }
}
