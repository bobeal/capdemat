package fr.cg95.cvq.dao.request;

import fr.cg95.cvq.business.request.RequestActionType;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author jsb@zenexity.fr
 */
public interface IRequestActionDAO extends IGenericDAO {

    boolean hasAction(final Long requestId, final RequestActionType type);
}
