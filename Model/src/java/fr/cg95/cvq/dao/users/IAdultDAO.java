package fr.cg95.cvq.dao.users;

import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.UserState;

/**
 * @author bor@zenexity.fr
 */
public interface IAdultDAO extends IIndividualDAO {

    Adult findByLogin(String login);

    /**
     * Return the list of {@link Adult} objects belonging to a given home folder.
     */
    List<Adult> listAdultsByHomeFolder(final Long homeFolderId, UserState... states);

    List<Adult> matchAdults (Map<String, String> parameters);
}
