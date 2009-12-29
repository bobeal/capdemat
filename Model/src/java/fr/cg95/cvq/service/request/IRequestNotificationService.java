package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestNote;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestNotificationService {

    void notifyRequestCreation(Request request, byte[] pdfData) 
        throws CvqException;
    
    void notifyRequestValidation(@IsRequest final Long requestId, final byte[] pdfData)
        throws CvqException;

    void notifyAgentNote(@IsRequest final Long requestId, final RequestNote note)
        throws CvqException;
}
