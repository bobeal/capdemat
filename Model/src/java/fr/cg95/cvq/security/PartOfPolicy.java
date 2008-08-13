package fr.cg95.cvq.security;

/**
 * The base interface for all per-class pieces of the overall policy
 * (all <code>*Policy</code> classes in this package, except {@link
 * CvqPolicy}). Said CvqPolicy will call appropriate methods in
 * same, according to the requested 
 * {@link fr.cg95.cvq.permission.PrivilegeDescriptor}.
 *
 * @author dom@idealx.com
 * @author bor@zenexity.fr
 */
public interface PartOfPolicy {

    public boolean isReadAllowed(CredentialBean user, ObjectBean object);

    public boolean isWriteAllowed(CredentialBean user, ObjectBean object);

    public boolean isAdminAllowed(CredentialBean user, ObjectBean object);

    public boolean isManageAllowed(CredentialBean user, ObjectBean object);
}
