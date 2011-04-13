package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.QoS;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.security.annotation.IsUser;
import fr.cg95.cvq.service.request.IAutofillTriggerService;
import fr.cg95.cvq.util.Critere;

public interface IUserSearchService extends IAutofillTriggerService {

    List<Individual> get(Set<Critere> criterias, Map<String,String> sortParams, Integer max, Integer offset);

    Integer getCount(Set<Critere> criterias);

    @Override
    Individual getById(@IsUser Long id);

    Adult getAdultById(@IsUser Long id);

    Child getChildById(@IsUser Long id);

    Adult getByLogin(@IsUser String login);

    Individual getByFederationKey(String federationKey);

    List<Individual> listTasks(QoS qoS, int max);

    Long countTasks(QoS qoS);

    Adult getHomeFolderResponsible(@IsUser Long homeFolderId);

    List<Individual> listByHomeFolderRole(@IsUser Long homeFolderId, RoleType role);

    List<Individual> listByHomeFolderRoles(@IsUser Long homeFolderId, RoleType[] roles);

    List<Individual> listBySubjectRole(@IsUser Long subjectId, RoleType role);

    List<Individual> listBySubjectRoles(@IsUser Long subjectId, RoleType[] roles);

    List<HomeFolder> getAll(boolean filterArchived, boolean filterTemporary);

    HomeFolder getHomeFolderById(@IsUser Long id);

    List<Child> getChildren(@IsUser Long homeFolderId, UserState... states);

    List<Adult> getAdults(@IsUser Long homeFolderId, UserState... states);

    List<Individual> getIndividuals(@IsUser Long homeFolderId);

    /**
     * Get a list of individuals who have a role in the home folder but are not part of it.
     */
    List<Individual> getExternalIndividuals(@IsUser Long homeFolderId);
}
