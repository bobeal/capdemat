package fr.cg95.cvq.service.request;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author jsb@zenexity.fr
 *
 */
public interface IAutofillTriggerService {

    /**
     * Retrieve the trigger object whose fields will be used to autofill listeners
     */
    Object getById(final Long id)
        throws CvqObjectNotFoundException;

}
