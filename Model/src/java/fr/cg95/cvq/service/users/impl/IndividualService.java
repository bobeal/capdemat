package fr.cg95.cvq.service.users.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.QoS;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UserAction;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.business.users.UserEvent;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.JSONUtils;
import fr.cg95.cvq.util.ValidationUtils;

/**
 * Implementation of the {@link IIndividualService} service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class IndividualService implements IIndividualService, ApplicationEventPublisherAware {

    static Logger logger = Logger.getLogger(IndividualService.class);

    private ApplicationEventPublisher applicationEventPublisher;

    private static Collection<String> bookedLogin =
        Collections.synchronizedCollection(new ArrayList<String>());

    private IIndividualDAO individualDAO;

    private IAdultDAO adultDAO;

    private IChildDAO childDAO;

    private IAuthenticationService authenticationService;

    @Override
    public List<Individual> get(final Set<Critere> criteriaSet, final String orderedBy,
        final boolean searchAmongArchived) {
        return individualDAO.search(criteriaSet, orderedBy,
            searchAmongArchived ? null : new UserState[] { UserState.ARCHIVED });
    }

    @Override
    public List<Individual> get(Set<Critere> criterias, Map<String,String> sortParams,
                                    Integer max, Integer offset) {
        return this.individualDAO.search(criterias,sortParams,max,offset);
    }

    @Override
    public Integer getCount(Set<Critere> criterias) {
        return this.individualDAO.searchCount(criterias);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Individual getById(final Long id)
        throws CvqObjectNotFoundException {
        return (Individual) individualDAO.findById(Individual.class, id);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Adult getAdultById(final Long id)
        throws CvqObjectNotFoundException {
        return (Adult) adultDAO.findById(Adult.class, id);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Child getChildById(final Long id)
        throws CvqObjectNotFoundException {
        return (Child) childDAO.findById(Child.class, id);
    }

    @Override
    public Adult getByLogin(final String login) {
        return adultDAO.findByLogin(login);
    }

    @Override
    public Individual getByFederationKey(final String federationKey) {
        return individualDAO.findByFederationKey(federationKey);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN}, privilege = ContextPrivilege.WRITE)
    public void modifyPassword(final Adult adult, final String oldPassword, 
            final String newPassword)
        throws CvqException, CvqBadPasswordException {

        // check the old password
        try {
            authenticationService.authenticate(adult.getLogin(), oldPassword);
        } catch (CvqAuthenticationFailedException cafe) {
            logger.warn("modifyPassword() old password does not match for user "
                        + adult.getLogin());
            throw new CvqBadPasswordException("Old password does not match for user "
                                   + adult.getLogin());
        } catch (CvqDisabledAccountException cdae) {
            logger.info("modifyPassword() account is disabled, still authorizing password change");
        }

        // it's ok, set the new one
        authenticationService.resetAdultPassword(adult, newPassword);
    }

    private synchronized String computeNewLogin(Adult adult) {
        String baseLogin =  Normalizer.normalize(
            (adult.getFirstName().trim() + '.' + adult.getLastName().trim())
                .replaceAll("\\s", "-")
                .replaceAll("'", ""),
            Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]","").toLowerCase();
        logger.debug("computeNewLogin() searching from " + baseLogin);
        TreeSet<Integer> indexesSet = new TreeSet<Integer>();
        for (String login : individualDAO.getSimilarLogins(baseLogin)) {
            String index = login.substring(baseLogin.length());
            if (index == null || index.equals(""))
                index = "1";
            try {
                Integer intIndex = Integer.valueOf(index);
                indexesSet.add(intIndex);
            } catch (NumberFormatException nfe) {
                // the tail was not an integer, ignore it
            }
        }

        int finalIndex = 0;
        if (!indexesSet.isEmpty()) {
            finalIndex = indexesSet.last();
        }
        logger.debug("computeNewLogin() got final index " + finalIndex);
        
        String loginFromDb = null;
        if (finalIndex == 0)
            loginFromDb = baseLogin;
        else
            loginFromDb = baseLogin + String.valueOf(++finalIndex);
        logger.debug("computeNewLogin() got new login from DB " + loginFromDb);
        String finalLogin = loginFromDb;
        if (bookedLogin.contains(loginFromDb)) {
            String currentIndex = loginFromDb.substring(baseLogin.length());
            int currIdx = 1;
            if (currentIndex != null && !currentIndex.equals(""))
                currIdx = (Integer.parseInt(currentIndex) > finalIndex ? 
                        Integer.parseInt(currentIndex) : finalIndex);
            String loginToTest = null;
            do {
                currIdx++;
                loginToTest = baseLogin + String.valueOf(currIdx);
            } while (bookedLogin.contains(loginToTest));
            finalLogin = loginToTest;
        }
        bookedLogin.add(finalLogin);
        return finalLogin;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public Long create(Adult adult, boolean assignLogin)
        throws CvqException {
        if (assignLogin) {
            adult.setLogin(computeNewLogin(adult));
        }
        if (adult.getPassword() != null)
            adult.setPassword(authenticationService.encryptPassword(adult.getPassword()));
        return create(adult);
    }


    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public Long create(Child child) {
        return create((Individual)child);
    }

    private Long create(Individual individual) {
        individual.setState(SecurityContext.isFrontOfficeContext() ? UserState.NEW : UserState.VALID);
        individual.setCreationDate(new Date());
        individual.setQoS(SecurityContext.isFrontOfficeContext() ? QoS.GOOD : null);
        individual.setLastModificationDate(new Date());
        Long id = individualDAO.create(individual);
        UserAction action = new UserAction(UserAction.Type.CREATION, id);
        individual.getHomeFolder().getActions().add(action);
        if (SecurityContext.isFrontOfficeContext()
            && !UserState.NEW.equals(individual.getHomeFolder().getState())) {
            individual.getHomeFolder().setState(UserState.MODIFIED);
        }
        individualDAO.update(individual.getHomeFolder());
        applicationEventPublisher.publishEvent(new UserEvent(this, action));
        return id;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void modify(final Individual individual, JsonObject atom)
        throws CvqException {

        if (individual == null)
            throw new CvqException("No adult object provided");
        else if (individual.getId() == null)
            throw new CvqException("Cannot modify a transient individual");
        if (SecurityContext.isFrontOfficeContext()) {
            if (!UserState.NEW.equals(individual.getState())) {
                individual.setState(UserState.MODIFIED);
                individual.setLastModificationDate(new Date());
                individual.setQoS(QoS.GOOD);
            }
            if (!UserState.NEW.equals(individual.getHomeFolder().getState()))
                individual.getHomeFolder().setState(UserState.MODIFIED);
        }
        JsonObject payload = new JsonObject();
        payload.add("atom", atom);
        UserAction action = new UserAction(UserAction.Type.MODIFICATION, individual.getId(), payload);
        // FIXME hack for specific business when changing a user's first or last name
        if ("identity".equals(atom.get("name").getAsString())) {
            JsonObject fields = atom.get("fields").getAsJsonObject();
            if (fields.has("firstName") || fields.has("lastName")) {
                String firstName = fields.has("firstName") ?
                    fields.get("firstName").getAsJsonObject().get("from").getAsString()
                    : individual.getFirstName();
                String lastName = fields.has("lastName") ?
                        fields.get("lastName").getAsJsonObject().get("from").getAsString()
                        : individual.getLastName();
                Gson gson = new Gson();
                payload = JSONUtils.deserialize(action.getData());
                payload.get("target").getAsJsonObject()
                    .addProperty("name", firstName + ' ' + lastName);
                if (individual.getId().equals(payload.get("user").getAsJsonObject().get("id").getAsLong())) {
                    payload.get("user").getAsJsonObject()
                        .addProperty("name", firstName + ' ' + lastName);
                }
                if (individual instanceof Adult) {
                    Adult adult = (Adult)individual;
                    if (!StringUtils.isEmpty(adult.getLogin())) {
                        JsonObject login = new JsonObject();
                        login.addProperty("from", adult.getLogin());
                        adult.setLogin(computeNewLogin(adult));
                        login.addProperty("to", adult.getLogin());
                        payload.get("atom").getAsJsonObject().get("fields").getAsJsonObject()
                            .add("login", login);
                        // hack to refresh security context
                        HibernateUtil.getSession().flush();
                    }
                }
                action.setData(gson.toJson(payload));
            }
        }
        individual.getHomeFolder().getActions().add(action);
        individualDAO.update(individual.getHomeFolder());
        applicationEventPublisher.publishEvent(new UserEvent(this, action));
    }

    public void setIndividualDAO(IIndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }

    public void setAdultDAO(IAdultDAO adultDAO) {
        this.adultDAO = adultDAO;
    }

    public void setChildDAO(IChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    public void setAuthenticationService(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public List<String> validate(Adult adult)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
        NoSuchMethodException {
        return validate(adult, false);
    }

    @Override
    public List<String> validate(Adult adult, boolean login)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Validator validator = new Validator();
        validator.disableAllProfiles();
        validator.enableProfile("default");
        if (login) {
            validator.enableProfile("login");
        }
        Map<String, List<String>> invalidFields = new LinkedHashMap<String, List<String>>();
        for (ConstraintViolation violation : validator.validate(adult)) {
            ValidationUtils.collectInvalidFields(violation, invalidFields, "", "");
        }
        List<String> result = new ArrayList<String>();
        for (String profile : new String[] {"", "login"}) {
            if (invalidFields.get(profile) != null) {
                result.addAll(invalidFields.get(profile));
            }
        }
        return result;
    }

    @Override
    public List<String> validate(Child child)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Validator validator = new Validator();
        validator.disableAllProfiles();
        validator.enableProfile("default");
        Map<String, List<String>> invalidFields = new LinkedHashMap<String, List<String>>();
        for (ConstraintViolation violation : validator.validate(child)) {
            ValidationUtils.collectInvalidFields(violation, invalidFields, "", "");
        }
        return invalidFields.get("") != null ? invalidFields.get("") : Collections.<String>emptyList();
    }


    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public List<Individual> listTasks(QoS qoS, int max) {
        return individualDAO.listTasks(qoS, max);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.READ)
    public Long countTasks(QoS qoS) {
        return individualDAO.countTasks(qoS);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

