package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.util.Critere;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IIndividualService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "individualService";

    Long create(Individual individual, final HomeFolder homeFolder, Address address, 
            boolean assignLogin)
        throws CvqException;

    void modify(final Individual individual)
        throws CvqException;

    void addRole(final Long ownerId, final RoleEnum role, final Long homeFolderId, 
            final Long individualId)
        throws CvqException;
    
    void removeRole(final Long ownerId, final RoleEnum role, final Long homeFolderId, 
            final Long individualId)
        throws CvqException;
    
    List<Individual> get(final Set<Critere> criteriaSet, final String orderedBy, 
            final boolean searchAmongArchived)
        throws CvqException;

    Individual getById(final Long id)
        throws CvqException;

    Individual getByLogin(final String login)
        throws CvqException;

    Individual getByCertificate(final String certificate)
        throws CvqException;

    /**
     * Get an individual by its Liberty Alliance federation key.
     */
    Individual getByFederationKey(final String federationKey)
        throws CvqException;

    /**
     * Return the list of {@link Individual individuals} who have the given role (if one 
     * provided) or any role (if none provided) on the given home folder.
     */
    List<Individual> getByHomeFolderRole(final Long homeFolderId, final RoleEnum role);
    
    /**
     * Return the list of {@link Individual individuals} who have the given role (if one 
     * provided) or any role (if none provided) on the given subject.
     */
    List<Individual> getBySubjectRole(final Long subjectId, final RoleEnum role);
    
    /**
     * delegated to {@link fr.cg95.cvq.authentication.IAuthenticationService}.
     */
    String encryptPassword(final String clearPassword)
        throws CvqException;

    /**
     * Generate and assign a login to the given individual.
     * 
     * The generated login is of the form "firstName.lastNameXX" where XX is a generated number
     * if the login "firstName.lastName" is already used.
     * 
     * @return the generated login.
     */
    String assignLogin(Individual individual)
        throws CvqException;

    void updateIndividualState(Individual individual, ActorState newState) throws CvqException;
}
