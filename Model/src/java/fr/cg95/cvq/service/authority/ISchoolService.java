package fr.cg95.cvq.service.authority;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

import java.util.List;

/**
 * @author bor@zenexity.fr
 *
 */
public interface ISchoolService {

    Long create(final School school);

    void modify(final School school);

    List<School> getAll();

    List<School> getActives();

    School getByName(final String schoolName);

    School getById(final Long id)
        throws CvqObjectNotFoundException;
}
