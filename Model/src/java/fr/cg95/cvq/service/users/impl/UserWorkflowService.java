package fr.cg95.cvq.service.users.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.authority.LocalAuthorityResource;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UserAction;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.business.users.UserWorkflow;
import fr.cg95.cvq.business.users.UsersEvent;
import fr.cg95.cvq.business.users.UsersEvent.EVENT_TYPE;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.users.IUserWorkflowService;
import fr.cg95.cvq.util.translation.ITranslationService;

public class UserWorkflowService implements IUserWorkflowService, ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    private ILocalAuthorityRegistry localAuthorityRegistry;

    private ITranslationService translationService;

    private IHomeFolderDAO homeFolderDAO;

    private Map<String, UserWorkflow> workflows = new HashMap<String, UserWorkflow>();

    @Override
    public UserState[] getPossibleTransitions(UserState state) {
        return getWorkflow().getPossibleTransitions(state);
    }

    @Override
    public boolean isValidTransition(UserState from, UserState to) {
        return getWorkflow().isValidTransition(from, to);
    }

    @Override
    public UserState[] getStatesBefore(UserState state) {
        return getWorkflow().getStatesBefore(state);
    }

    @Override
    public UserState[] getStatesWithProperty(String propertyName) {
        return getWorkflow().getStatesWithProperty(propertyName);
    }

    private UserWorkflow getWorkflow() {
        String name = SecurityContext.getCurrentSite().getName();
        UserWorkflow workflow = workflows.get(name);
        if (workflow == null) {
            File file = localAuthorityRegistry.getLocalAuthorityResourceFileForLocalAuthority(name,
                LocalAuthorityResource.Type.XML, "userWorkflow", false);
            if (file.exists()) {
                workflow = UserWorkflow.load(file);
                workflows.put(name, workflow);
            } else {
                workflow = workflows.get("default");
                if (workflow == null) {
                    file = localAuthorityRegistry.getReferentialResource(
                        LocalAuthorityResource.Type.XML, "userWorkflow");
                    workflow = UserWorkflow.load(file);
                    workflows.put("default", workflow);
                }
            }
        }
        return workflow;
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void changeState(HomeFolder homeFolder, UserState state)
        throws CvqModelException, CvqInvalidTransitionException {
        if (!isValidTransition(homeFolder.getState(), state))
            throw new CvqInvalidTransitionException(
                translationService.translate(
                    "user.state." + homeFolder.getState().toString().toLowerCase()),
                translationService.translate(
                    "user.state." + state.toString().toLowerCase()));
        if (UserState.VALID.equals(state)) {
            for (Individual individual : homeFolder.getIndividuals()) {
                if (!UserState.VALID.equals(individual.getState())
                    && !UserState.ARCHIVED.equals(individual.getState()))
                    throw new CvqModelException("");
            }
        }
        homeFolder.setState(state);
        JsonObject payload = new JsonObject();
        payload.addProperty("state", state.toString());
        homeFolder.getActions().add(
            new UserAction(UserAction.Type.STATE_CHANGE, homeFolder.getId(), payload));
        homeFolderDAO.update(homeFolder);
        if (UserState.ARCHIVED.equals(state)) {
            UsersEvent homeFolderEvent =
                new UsersEvent(this, EVENT_TYPE.HOME_FOLDER_ARCHIVE, homeFolder.getId(), null);
            applicationEventPublisher.publishEvent(homeFolderEvent);
        }
    }

    @Override
    @Context(types = {ContextType.ECITIZEN, ContextType.AGENT}, privilege = ContextPrivilege.WRITE)
    public void changeState(Individual individual, UserState state)
        throws CvqModelException, CvqInvalidTransitionException {
        if (!isValidTransition(individual.getState(), state))
            throw new CvqInvalidTransitionException(
                translationService.translate(
                    "user.state." + individual.getState().toString().toLowerCase()),
                translationService.translate(
                    "user.state." + state.toString().toLowerCase()));
        individual.setState(state);
        JsonObject payload = new JsonObject();
        payload.addProperty("state", state.toString());
        individual.getHomeFolder().getActions().add(
            new UserAction(UserAction.Type.STATE_CHANGE, individual.getId(), payload));
        homeFolderDAO.update(individual.getHomeFolder());
        if (UserState.INVALID.equals(state))
            changeState(individual.getHomeFolder(), UserState.INVALID);
        else if (UserState.VALID.equals(state) || UserState.ARCHIVED.equals(state)) {
            boolean allAtSameState = true;
            for (Individual i : individual.getHomeFolder().getIndividuals()) {
                allAtSameState &= UserState.ARCHIVED.equals(i.getState()) || state.equals(i.getState());
            }
            if (allAtSameState) changeState(individual.getHomeFolder(), state);
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setTranslationService(ITranslationService translationService) {
        this.translationService = translationService;
    }

    public void setHomeFolderDAO(IHomeFolderDAO homeFolderDAO) {
        this.homeFolderDAO = homeFolderDAO;
    }
}
