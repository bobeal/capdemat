package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Set;
import java.util.Map;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
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

    void modify(Individual individual)
        throws CvqException;

    void delete(Individual individual)
        throws CvqException;
    
    List<Individual> get(final Set<Critere> criteriaSet, final String orderedBy, 
            final boolean searchAmongArchived)
        throws CvqException;
    
    List<Individual> get(Set<Critere> criterias, Map<String,String> sortParams,
                                    Integer max, Integer offset);

    Integer getCount(Set<Critere> criterias);

    Individual getById(final Long id)
        throws CvqObjectNotFoundException;

    Adult getAdultById(final Long id)
        throws CvqObjectNotFoundException;
    
    Child getChildById(final Long id)
        throws CvqObjectNotFoundException;
    
    /**
     * Get a child by its badge number.
     *
     * @deprecated badge number is not an information managed by CapDemat
     *                         (kept for compatibility with Horanet)
     */
    Child getChildByBadgeNumber(final String badgeNumber)
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

    void modifyPassword(final Adult adult, final String oldPassword, final String newPassword)
        throws CvqException, CvqBadPasswordException;

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
