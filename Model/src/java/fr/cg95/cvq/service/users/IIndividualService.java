package fr.cg95.cvq.service.users;

import java.lang.reflect.InvocationTargetException;
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
import fr.cg95.cvq.service.request.IAutofillTriggerService;
import fr.cg95.cvq.util.Critere;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IIndividualService extends IAutofillTriggerService {

    Long create(Adult adult, boolean assignLogin)
        throws CvqException;

    Long create(Child child);

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

    Adult getByLogin(final String login)
        throws CvqException;

    /**
     * Get an individual by its Liberty Alliance federation key.
     */
    Individual getByFederationKey(final String federationKey)
        throws CvqException;

    void modifyPassword(final Adult adult, final String oldPassword, final String newPassword)
        throws CvqException, CvqBadPasswordException;

    void updateIndividualState(Individual individual, ActorState newState) throws CvqException;

    /**
     * @param adult The {@link Adult} to validate
     * @param login Whether this {@link Adult} must be a login account
     *              (then we need to validate question/answer and password)
     * @return The list of invalid fields
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    List<String> validate(Adult adult, boolean login)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<String> validate(Child child)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;
}
