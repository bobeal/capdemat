package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 *
 */
public interface ISchoolService {

    Long create(final School school)
        throws CvqException;
    
    void modify(final School school)
        throws CvqException;
    
    List<School> getAll()
        throws CvqException;

    School getByName(final String schoolName)
        throws CvqException;

    School getById(final Long id)
        throws CvqObjectNotFoundException;
}
