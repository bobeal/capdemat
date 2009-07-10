package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 */
public interface IRecreationCenterService {

    Long create(final RecreationCenter recreationCenter)
        throws CvqException;

    List<RecreationCenter> getAll()
        throws CvqException;

    RecreationCenter getById(final Long id)
        throws CvqObjectNotFoundException;
}
