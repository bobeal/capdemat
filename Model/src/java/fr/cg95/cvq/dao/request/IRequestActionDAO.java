package fr.cg95.cvq.dao.request;

import java.util.List;

import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestActionDAO extends IGenericDAO {

    /**
     * Look up a request action by request id and associated resulting state.
     */
	RequestAction findByRequestIdAndResultingState(final Long requestId,
    		 final RequestState requestState);

	boolean hasAction(final Long requestId, final String actionLabel);
	
	/**
	 * Get the last action for the given action label and request. 
	 */
	RequestAction findLastAction(final Long requestId, final String actionLabel);
	
    /**
     * Return the list of actions related to a given request.
     */
    List<RequestAction> listByRequest(final Long requestId);
}
