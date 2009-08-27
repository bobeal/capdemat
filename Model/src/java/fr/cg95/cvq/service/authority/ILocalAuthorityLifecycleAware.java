package fr.cg95.cvq.service.authority;

/**
 * An interface to be implemented by services interested in local authorities lifecycle.
 *
 * @author bor@zenexity.fr
 */
public interface ILocalAuthorityLifecycleAware {

    /**
     * When calling this method, security context has been set to the specified
     * local authority, so DO NOT use ILocalAuthorityRegistry.callback,
     * you might break further caller operations.
     */
    void addLocalAuthority(String localAuthorityName);
    void removeLocalAuthority(String localAuthorityName);
}
