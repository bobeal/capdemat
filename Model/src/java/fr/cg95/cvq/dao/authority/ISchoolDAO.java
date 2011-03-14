package fr.cg95.cvq.dao.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface ISchoolDAO extends IGenericDAO {

    /**
     * Look up a school by name.
     */
    School findByName(final String name);

    /**
     * Return the list of all known schools.
     */
    List<School> listAll();

    /**
     * @return The active schools
     */
    List<School> getActive();
}
