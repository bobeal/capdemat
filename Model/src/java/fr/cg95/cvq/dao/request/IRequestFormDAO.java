package fr.cg95.cvq.dao.request;

import java.util.List;

import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.dao.jpa.IJpaTemplate;

/**
 * @author bor@zenexity.fr
 */
public interface IRequestFormDAO extends IJpaTemplate<RequestForm,Long> {

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
