package fr.cg95.cvq.permission;

import fr.cg95.cvq.exception.CvqException;

/**
 * PermissionException - nothing more to say :-)
 * 
 * @fixme add API to designate the user that caused the exception.
 * 
 * @author dom@idealx.com
 * @author bor@zenexity.fr
 * 
 * @deprecated
 */
public class CvqPermissionException extends CvqException {

    private static final long serialVersionUID = 1L;

    private Object o;
    private PrivilegeDescriptor p;
    private String message;

    public CvqPermissionException(Class c, Object o, PrivilegeDescriptor p) {
        super("");
        this.o = o;
        this.p = p;
        // Compute message early, so that the exception is still useable
        // after the transaction is rollbacked (e.g. in unit tests)
        this.message = "permission check at level " + p.toString() + " failed for object <"
                + o.toString() + ">" + " in " + c;
    }

    public CvqPermissionException(String service, PrivilegeDescriptor p) {
        super("");
        this.p = p;
        this.message = "permission check at level " + p.toString() + " failed for service <"
        + service + ">";
    }
    
    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return o;
    }
    
    public PrivilegeDescriptor getPrivilegeDescriptor() {
        return p;
    }
}
