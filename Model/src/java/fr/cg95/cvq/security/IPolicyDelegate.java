package fr.cg95.cvq.security;

import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;

/**
 * Interface for a policy delegate class, of which an
 * implementation will be passed on to us by code that manages
 * security (typically {@link fr.cg95.cvq.security}.
 */
public interface IPolicyDelegate {

    public void check(Object object, PrivilegeDescriptor privilegeDescriptor)
        throws CvqPermissionException;
}
