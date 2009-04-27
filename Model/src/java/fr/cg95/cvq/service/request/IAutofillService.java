package fr.cg95.cvq.service.request;

import java.util.Map;

import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author jsb@zenexity.fr
 *
 */
public interface IAutofillService {

    /**
     * @param triggerName
     *     the name of the trigger, used to determine the appropriate service to retrieve the trigger object
     * @param id
     *     the trigger object ID
     * @param keys
     *     A map of HTML element name -> Java field name
     * @return The map of HTML element name -> Java field value
     * @throws CvqObjectNotFoundException
     */
    Map<String, String> getValues(String triggerName, Long id, Map<String, String> keys)
        throws CvqObjectNotFoundException;

}
