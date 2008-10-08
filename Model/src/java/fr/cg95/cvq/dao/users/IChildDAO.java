package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;

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
    
    /**
     * Return the list of {@link ChildLegalResponsible ChildLegalResponsible} by child id
     */
    List<ChildLegalResponsible> listChildLegalResponsibles(final Long id);
}
