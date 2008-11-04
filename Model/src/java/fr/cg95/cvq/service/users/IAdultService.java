package fr.cg95.cvq.service.users;

import java.util.List;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 */
public interface IAdultService extends IIndividualService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "adultService";

    // TODO : move to authentication service
    void modifyPassword(final Adult adult, final String oldPassword, final String newPassword)
        throws CvqException, CvqBadPasswordException;

    void delete(final Adult adult, boolean deletingHomeFolder)
        throws CvqException;

    /**
     * Get an adult by id.
     */
    Adult getById(final Long id)
        throws CvqException, CvqObjectNotFoundException;
    
    List<Child> getClrs(final Long adultId)
        throws CvqException;
}
