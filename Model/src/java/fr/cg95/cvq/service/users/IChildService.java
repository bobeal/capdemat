package fr.cg95.cvq.service.users;

import java.util.List;

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
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
     * Remove the given adult from the list of the child's legal responsibles.
     * 
     * @throws CvqException if modification unexpectedly failed 
     * @throws CvqObjectNotFoundException if one of childId or adultId has
     *         not been found
     * @throws CvqModelException if child has no longer a legal responsible after
     *         this modification
     */
    void removeLegalResponsible(final Long childId, final Long adultId, boolean deletingHomeFolder)
        throws CvqException, CvqObjectNotFoundException, CvqModelException;
    
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
    
    /**
     * Get a child legal responsible by child id
     */
    List<ChildLegalResponsible> getLegalResponsibles(final Long id)
        throws CvqException, CvqObjectNotFoundException;
}
