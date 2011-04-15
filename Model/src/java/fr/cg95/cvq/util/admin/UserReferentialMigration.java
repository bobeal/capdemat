package fr.cg95.cvq.util.admin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UserAction;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.util.JSONUtils;
import fr.cg95.cvq.util.UserUtils;

public class UserReferentialMigration {

    private LocalAuthorityRegistry localAuthorityRegistry;

    private IRequestSearchService requestSearchService;

    private IUserSearchService userSearchService;

    private Map<Long, UserState> homeFolderStates = new HashMap<Long, UserState>();

    private Comparator<UserAction> comparator = new Comparator<UserAction>() {
        @Override
        public int compare(UserAction o1, UserAction o2) {
            return o1.getDate().compareTo(o2.getDate());
        }
    };

    public static void main(final String[] args) {
        ClassPathXmlApplicationContext context = SpringApplicationContextLoader.loadContext(null);
        UserReferentialMigration userReferentialMigration = new UserReferentialMigration();
        userReferentialMigration.localAuthorityRegistry = (LocalAuthorityRegistry)context.getBean("localAuthorityRegistry");
        userReferentialMigration.requestSearchService = (IRequestSearchService)context.getBean("requestSearchService");
        userReferentialMigration.userSearchService = (IUserSearchService)context.getBean("userSearchService");
        userReferentialMigration.localAuthorityRegistry.browseAndCallback(userReferentialMigration, "migrate", new Object[0]);
        System.exit(0);
    }

    public void migrate()
        throws CvqException {
        for (RequestAction requestAction : (List<RequestAction>)
            HibernateUtil.getSession().createSQLQuery(
                "select * from request_action where request_id in (select id from request where specific_data_class='fr.cg95.cvq.business.request.ecitizen.VoCardRequestData' or specific_data_class='fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequestData') order by date asc")
            .addEntity(RequestAction.class).list()) {
            Long requestId = ((BigInteger)HibernateUtil.getSession().createSQLQuery(
                "select request_id from request_action where id = :id")
                .setLong("id", requestAction.getId()).uniqueResult()).longValue();
            Request request = requestSearchService.getById(requestId, true);
            HomeFolder homeFolder = userSearchService.getHomeFolderById(request.getHomeFolderId());
            if (RequestActionType.CREATION.equals(requestAction.getType())) {
                UserAction.Type type = request instanceof VoCardRequest ? UserAction.Type.CREATION : UserAction.Type.MODIFICATION;
                add(homeFolder, new UserAction(type, homeFolder.getId()), requestAction);
                for (Individual individual : homeFolder.getIndividuals()) {
                    add(homeFolder, new UserAction(type, individual.getId()), requestAction);
                }
            } else if (RequestActionType.STATE_CHANGE.equals(requestAction.getType())) {
                UserState state = convert(requestAction.getResultingState(), request instanceof HomeFolderModificationRequest);
                if (state == null || state.equals(homeFolderStates.get(homeFolder.getId())))
                    continue;
                homeFolderStates.put(homeFolder.getId(), state);
                JsonObject payload = new JsonObject();
                payload.addProperty("state", state.toString());
                add(homeFolder, new UserAction(UserAction.Type.STATE_CHANGE, homeFolder.getId(), payload), requestAction);
                for (Individual individual : homeFolder.getIndividuals()) {
                    add(homeFolder, new UserAction(UserAction.Type.STATE_CHANGE, individual.getId(), payload), requestAction);
                }
            }
        }
        for (HomeFolder homeFolder : userSearchService.getAll(false, false)) {
            List<UserAction> actions = homeFolder.getActions();
            if (actions.isEmpty() || !UserAction.Type.CREATION.equals(actions.get(0).getType())) {
                RequestAction fake = new RequestAction();
                fake.setAgentId(-1L);
                Date responsibleCreation = userSearchService.getHomeFolderResponsible(homeFolder.getId()).getCreationDate();
                Date firstAction = actions.isEmpty() ? null : actions.get(0).getDate();
                Date homeFolderCreation =
                    firstAction != null && responsibleCreation.compareTo(firstAction) > 0 ? firstAction
                        : responsibleCreation;
                fake.setDate(homeFolderCreation);
                add(homeFolder, new UserAction(UserAction.Type.CREATION, homeFolder.getId()), fake);
                for (Individual individual : homeFolder.getIndividuals()) {
                    add(homeFolder, new UserAction(UserAction.Type.CREATION, individual.getId()), fake);
                }
            }
        }
    }

    private void add(HomeFolder homeFolder, UserAction userAction, RequestAction requestAction) {
        userAction.setUserId(requestAction.getAgentId());
        JsonObject payload = JSONUtils.deserialize(userAction.getData());
        payload.get("user").getAsJsonObject().addProperty("id", requestAction.getAgentId());
        payload.get("user").getAsJsonObject().addProperty("name", UserUtils.getDisplayName(requestAction.getAgentId()));
        userAction.setData(new Gson().toJson(payload));
        userAction.setDate(requestAction.getDate());
        List<UserAction> actions = new ArrayList<UserAction>(homeFolder.getActions());
        actions.add(userAction);
        Collections.sort(actions, comparator);
        homeFolder.setActions(actions);
    }

    private UserState convert(RequestState state, boolean modification) {
        if (RequestState.ARCHIVED.equals(state)) {
            return UserState.ARCHIVED;
        } else if (RequestState.CANCELLED.equals(state)) {
            return UserState.INVALID;
        } else if (RequestState.CLOSED.equals(state)) {
            return null;
        } else if (RequestState.COMPLETE.equals(state)) {
            return null;
        } else if (RequestState.DRAFT.equals(state)) {
            return null;
        } else if (RequestState.NOTIFIED.equals(state)) {
            return UserState.VALID;
        } else if (RequestState.PENDING.equals(state)) {
            return modification ? UserState.MODIFIED : null;
        } else if (RequestState.REJECTED.equals(state)) {
            return UserState.INVALID;
        } else if (RequestState.UNCOMPLETE.equals(state)) {
            return UserState.INVALID;
        } else if (RequestState.VALIDATED.equals(state)) {
            return UserState.VALID;
        }
        return null;
    }
}
