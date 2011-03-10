package fr.cg95.cvq.service.users;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.QoS;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.IsUser;
import fr.cg95.cvq.service.request.IAutofillTriggerService;
import fr.cg95.cvq.util.Critere;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public interface IIndividualService extends IAutofillTriggerService {

    Long create(@IsUser Adult adult, boolean assignLogin)
        throws CvqException;

    Long create(@IsUser Child child);

    void modify(@IsUser Individual individual, JsonObject atom)
        throws CvqException;

    List<Individual> get(final Set<Critere> criteriaSet, final String orderedBy,
        final boolean searchAmongArchived);

    List<Individual> get(Set<Critere> criterias, Map<String,String> sortParams,
        Integer max, Integer offset);

    Integer getCount(Set<Critere> criterias);

    Individual getById(@IsUser final Long id)
        throws CvqObjectNotFoundException;

    Adult getAdultById(@IsUser final Long id)
        throws CvqObjectNotFoundException;
    
    Child getChildById(@IsUser final Long id)
        throws CvqObjectNotFoundException;

    Adult getByLogin(@IsUser final String login);

    /**
     * Get an individual by its Liberty Alliance federation key.
     */
    Individual getByFederationKey(final String federationKey);

    void modifyPassword(@IsUser final Adult adult, final String oldPassword, final String newPassword)
        throws CvqException, CvqBadPasswordException;

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

    List<String> validate(Adult adult)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<String> validate(Child child)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<Individual> listTasks(QoS qoS, int max);

    Long countTasks(QoS qoS);
}
