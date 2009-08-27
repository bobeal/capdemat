package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author bor@zenexity.fr
 *
 */
public interface ISchoolService {

    Long create(final School school);

    void modify(final School school);

    List<School> getAll();

    School getByName(final String schoolName);

    School getById(final Long id)
        throws CvqObjectNotFoundException;
}
