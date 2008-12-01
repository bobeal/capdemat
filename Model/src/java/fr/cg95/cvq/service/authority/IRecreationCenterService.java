package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.exception.CvqException;

/**
 * @author bor@zenexity.fr
 */
public interface IRecreationCenterService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "recreationCenterService";
    
    // TODO unused method (but should be)
    Long create(final RecreationCenter recreationCenter)
        throws CvqException;

    List<RecreationCenter> getAll()
        throws CvqException;

    RecreationCenter getByName(final String recreationCenterName)
        throws CvqException;
}
