package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.exception.CvqException;

/**
 * @author bor@zenexity.fr
 *
 */
public interface ISchoolService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "schoolService";

    Long create(final School school)
        throws CvqException;
    
    void modify(final School school)
        throws CvqException;
    
    List<School> getAll()
        throws CvqException;

    School getByName(final String schoolName)
        throws CvqException;
}
