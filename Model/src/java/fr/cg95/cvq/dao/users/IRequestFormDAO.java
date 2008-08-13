package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.business.authority.RequestForm;
import fr.cg95.cvq.business.authority.RequestFormType;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestFormDAO extends IGenericDAO {

    /**
     * Look up a request form by form type and request label.
     */
    RequestForm findByTypeAndRequest(final RequestFormType requestFormType, 
            final String requestLabel);
    
    /**
     * Look up a request form list by form type and request type id.
     */
    List<RequestForm> findByTypeAndRequestTypeId(final RequestFormType requestFormType,
            final long requestTypeId);
}
