package fr.cg95.cvq.dao.request;

import java.util.List;

import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestTypeDAO extends IGenericDAO {

    /**
     * Look up a RequestType by name.
     */
    RequestType findByName(final String name);

    /**
     * Return the list of all known requests types.
     */
    List listAll();

    /**
     * Return the list of requests types handled by a given service.
     */
    List listByCategory(final Long serviceId);
}
