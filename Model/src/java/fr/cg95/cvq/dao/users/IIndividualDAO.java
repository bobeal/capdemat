package fr.cg95.cvq.dao.users;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Map;

import fr.cg95.cvq.business.QoS;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.util.Critere;

/**
 * @author bor@zenexity.fr
 */
public interface IIndividualDAO extends IGenericDAO {

    /**
     * Look up an Individual by its Liberty Alliance federation key.
     *
     * @return the sole individual if found or none else
     */
    Individual findByFederationKey(final String federationKey);

    /**
     * Return the list of {@link Individual individuals} belonging to the given home folder.
     */
    List<Individual> listByHomeFolder(final Long homeFolderId);

    /**
     * Return the list of {@link Individual individuals} who have the given role (if one 
     * provided) or any role (if none provided) on the given home folder.
     */
    List<Individual> listByHomeFolderRole(final Long homeFolderId, final RoleType role);
    
    List<Individual> listByHomeFolderRoles(final Long homeFolderId, final RoleType[] roles, 
            boolean onlyExternals);
    
    /**
     * Return the list of {@link Individual individuals} who have the given role (if one 
     * provided) or any role (if none provided) on the given subject.
     */
    List<Individual> listBySubjectRole(final Long subjectId, final RoleType role);
    
    /**
     * Return the list of {@link Individual individuals} who have the given roles 
     * on the given subject.
     * 
     * @param onlyExternals whether returned inviduals are restricted to individuals not belonging
     *        to the home folder.
     */
    List<Individual> listBySubjectRoles(final Long subjectId, final RoleType[] roles, 
            boolean onlyExternals);
    
    /**
     * Return the list of individual logins that start with the given
     * base login.
     */
    List<String> getSimilarLogins(final String baseLogin);

    /**
     * Produces individuals search using criterias and sort/offset params.
     * 
     * @param criterias Search criterias set
     * @param sortParams Sort params set
     * @param max Max row to retrive
     * @param offset Retriving offset
     * @return List of individuals
     */
    List<Individual> search(Set<Critere> criterias, Map<String,String> sortParams,
            Integer max, Integer offset);

    /**
     * Gets individuals count using criterias and sort/offset params.
     * 
     * @param criterias Search criterias set
     * @return Individuals count
     */
    Integer searchCount(Set<Critere> criterias);

    boolean hasSimilarIndividuals(String firstName, String lastName, String email,
        String phone, String streetNumber, String streetName, String postalCode, String city);

    List<Individual> listTasks(QoS qoS, int max);

    Long countTasks(QoS qoS);

    /**
     * Returns {@link Individual individuals} in state {@link UserState New}, {@link UserState Modified} or
     * {@link UserState Invalid} whose the last modification date is past the maximum delay.
     */
    List<Individual> searchTasks(Date date);
}
