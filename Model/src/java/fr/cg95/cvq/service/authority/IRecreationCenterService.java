package fr.cg95.cvq.service.authority;

import java.util.List;

import fr.cg95.cvq.business.authority.RecreationCenter;

/**
 * @author bor@zenexity.fr
 */
public interface IRecreationCenterService {

    Long create(final RecreationCenter recreationCenter);

    List<RecreationCenter> getAll();

    List<RecreationCenter> getActive();

    RecreationCenter getById(final Long id);

    RecreationCenter getByName(String name);

    void modify(RecreationCenter recreationCenter);
}
