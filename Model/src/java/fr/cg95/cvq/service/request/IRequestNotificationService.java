package fr.cg95.cvq.service.request;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.annotation.IsRequest;

/**
 *
 * @author bor@zenexity.fr
 */
public interface IRequestNotificationService {

    void notifyRequestValidation(@IsRequest final Long requestId, final byte[] pdfData)
        throws CvqException;
}
