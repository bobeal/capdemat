package fr.cg95.cvq.service.authority;

/**
 * An interface to be implemented by services interested in local authorities lifecycle.
 *
 * @author bor@zenexity.fr
 */
public interface ILocalAuthorityLifecycleAware {

    void addLocalAuthority(String localAuthorityName);
    void removeLocalAuthority(String localAuthorityName);
}
