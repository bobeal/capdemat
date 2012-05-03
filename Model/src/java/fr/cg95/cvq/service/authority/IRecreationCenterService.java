package fr.cg95.cvq.service.authority;

import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

import java.util.List;

/**
 * @author bor@zenexity.fr
 */
public interface IRecreationCenterService {

    Long create(final RecreationCenter recreationCenter);

    List<RecreationCenter> getAll();

    List<RecreationCenter> getActives();

    RecreationCenter getById(final Long id)
        throws CvqObjectNotFoundException;

    RecreationCenter getByName(String name);

    void modify(RecreationCenter recreationCenter);
}
