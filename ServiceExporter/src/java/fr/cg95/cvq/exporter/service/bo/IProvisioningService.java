package fr.cg95.cvq.exporter.service.bo;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectAlreadyExistsException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.exception.CvqUserAlreadyExistsException;

/**
 * @author bor@zenexity.fr
 */
public interface IProvisioningService {

    /**
     * Create a CVQ agent with the given login and associated groups.
     */
	void createAgent(final String localAuthorityName, final String agentLogin, 
	        final String firstName, final String lastName, final String[] groups)
        throws CvqUserAlreadyExistsException, CvqException;

    /**
     * Modify an existing CVQ agent's login.
     */
    void modifyAgent(final String localAuthorityName, final String oldLogin, final String newLogin, 
            final String firstName, final String lastName, final String[] newGroups)
        throws CvqUnknownUserException, CvqException;

    /**
     * Delete the CVQ agent with the given login.
     */
    void deleteAgent(final String localAuthorityName, final String agentLogin)
        throws CvqUnknownUserException, CvqException;

    /**
     * Return whether agent with given login is known by CVQ application.
     */
    boolean agentExists(final String localAuthorityName, final String agentLogin)
        throws CvqException;
    
    void createSchool(final String localAuthorityName, final String schoolName, 
            final String address)
        throws CvqObjectAlreadyExistsException, CvqException;
    
    void modifySchool(final String localAuthorityName, final String oldSchoolName, 
            final String newSchoolName, final String newAddress)
        throws CvqObjectNotFoundException, CvqException;
    
    void deleteSchool(final String localAuthorityName, final String schoolName)
        throws CvqObjectNotFoundException, CvqException;
    
    void createRecreationCenter(final String localAuthorityName, final String recreationCenterName, 
            final String address)
        throws CvqObjectAlreadyExistsException, CvqException;

    void modifyRecreationCenter(final String localAuthorityName, final String oldRecreationCenterName, 
            final String newRecreationCenterName, final String newAddress)
        throws CvqObjectNotFoundException, CvqException;

    void deleteRecreationCenter(final String localAuthorityName, final String recreationCenterName)
        throws CvqObjectNotFoundException, CvqException;
}
