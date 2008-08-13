package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.business.users.Child;

/**
 * @author bor@zenexity.fr
 */
public interface IChildDAO extends IIndividualDAO {

    /**
     * Look up a child by badge number.
     */
    Child findByBadgeNumber(String badgeNumber);	

    /**
     * Return the list of {@link Child children} belonging to a given home folder.
     */
    List listByHomeFolder(final Long homeFolderId);
}
