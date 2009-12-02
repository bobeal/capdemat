package fr.cg95.cvq.service.users;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;

/**
 * Service dedicated to various pdf files generation.
 *
 * @author bor@zenexity.fr
 */
public interface ICertificateService {

    byte[] generate(Request request) throws CvqException;

}
