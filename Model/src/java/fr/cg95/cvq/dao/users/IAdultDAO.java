package fr.cg95.cvq.dao.users;

import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.users.Adult;

/**
 * @author bor@zenexity.fr
 */
public interface IAdultDAO extends IIndividualDAO {

    /**
     * Return the list of {@link Adult} objects belonging to a given home folder.
     */
    List<Adult> listAdultsByHomeFolder(final Long homeFolderId);

    List<Adult> matchAdults (Map<String, String> parameters);
}
