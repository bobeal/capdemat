package fr.cg95.cvq.service.users;

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 *
 */
public interface IChildService extends IIndividualService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "childService";

    void delete(final Child child, boolean deletingHomeFolder)
        throws CvqException;

    /**
     * Get a child by its badge number.
     *
     * @deprecated badge number is not an information managed by CVQ
     */
    Child getByBadgeNumber(String badgeNumber)
        throws CvqException;

    /**
     * Get a child by id.
     */
    Child getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;
}
