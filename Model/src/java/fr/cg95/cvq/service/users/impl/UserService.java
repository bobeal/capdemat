package fr.cg95.cvq.service.users.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.GlobalHomeFolderConfiguration;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.HomeFolderStepState;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.IUserService;
import fr.cg95.cvq.util.ValidationUtils;

public class UserService implements IUserService {

    private IUserSearchService userSearchService;
    private IGenericDAO genericDAO;

    public void setGenericDAO(IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT, ContextType.EXTERNAL_SERVICE}, privilege = ContextPrivilege.READ)
    public boolean hasHomeFolderRole(Long ownerId, Long homeFolderId, RoleType role) {
        for (IndividualRole individualRole : userSearchService.getById(ownerId).getIndividualRoles()) {
            if (individualRole.getRole().equals(role)
                && homeFolderId.equals(individualRole.getHomeFolderId()))
                return true;
        }
        return false;
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
    public List<String> validate(Individual individual)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Validator validator = new Validator();
        validator.disableAllProfiles();
        validator.enableProfile("default");
        Map<String, List<String>> invalidFields = new LinkedHashMap<String, List<String>>();
        for (ConstraintViolation violation : validator.validate(individual)) {
            ValidationUtils.collectInvalidFields(violation, invalidFields, "", "");
        }
        return invalidFields.get("") != null ? invalidFields.get("") : Collections.<String>emptyList();
    }

    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    private GlobalHomeFolderConfiguration getGlobalHomeFolderConfiguration() {
        GlobalHomeFolderConfiguration conf =
            genericDAO.simpleSelect(GlobalHomeFolderConfiguration.class).unique();

        return (conf != null) ? conf : new GlobalHomeFolderConfiguration();
    }

    @Override
    public Boolean homeFolderIndependentCreationEnabled() {
        return getGlobalHomeFolderConfiguration().getIndependentCreation();
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    public void enableHomeFolderIndependentCreation() {
        GlobalHomeFolderConfiguration conf = getGlobalHomeFolderConfiguration();
        conf.setIndependentCreation(true);
        genericDAO.update(conf);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    public void disableHomeFolderIndependentCreation() {
        GlobalHomeFolderConfiguration conf = getGlobalHomeFolderConfiguration();
        conf.setIndependentCreation(false);
        genericDAO.update(conf);
    }

    @Override
    @Context(types = {ContextType.ECITIZEN})
    public void completeHomeFolderFamilyStep(HomeFolder homeFolder) {
        if (homeFolder != null) {
            homeFolder.setFamilyStepState(HomeFolderStepState.COMPLETE);
            genericDAO.update(homeFolder);
        }
    }
}
