package fr.cg95.cvq.service.users;

import java.util.Set;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

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

    /**
     * Get documents associated to an individual.
     *
     * As they are not automatically loaded from DB, they have to be explicitely
     * asked for.
     *
     * @return a set of {@link fr.cg95.cvq.business.users.Document} objects
     */
    Set getAssociatedDocuments(final Long individualId)
        throws CvqException, CvqObjectNotFoundException;

    Set get(final Set criteriaSet, final String orderedBy, final boolean onlyIds,
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
