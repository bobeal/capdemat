package fr.cg95.cvq.service.authority;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.exception.CvqException;

/**
 * A service used to communicate with an external LDAP directory.
 *
 * @author bor@zenexity.fr
 * @deprecated
 */
public interface ILdapService {

    void completeAgentData(Agent agent)
    		throws CvqException;
    
    void synchronizeDatabasesWithDirectory()
    		throws CvqException;
    
    /**
     * Synchronize the contents of the referential elements stored in an LDAP directory 
     * with the CVQ database.
     * Currently deals with scools and recreation centers.
     * Elements removed from the LDAP directory are not removed from the CVQ database
     * but only de-activated. 
     */
    void synchronizeDatabaseWithDirectory()
        throws CvqException;
}
