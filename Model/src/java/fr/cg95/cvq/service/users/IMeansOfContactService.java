package fr.cg95.cvq.service.users;

import java.util.List;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author rdj@zenexity.fr
 */
public interface IMeansOfContactService {

    MeansOfContact getMeansOfContactByType(MeansOfContactEnum type);

    /**
     * Get all available Means Of Contact
     */
    List<MeansOfContact> getAvailableMeansOfContact();

    /**
     * Get all enabled Means Of Contact, in local authority
     */
    List<MeansOfContact> getEnabledMeansOfContact();

    /**
     * Get all enabled Means of Contact, for a particular adult.
     *
     * a means of contact is enabled for an adult if :
     * <ul>
     *   <li>it's enabled in local authority</li>
     *   <li>and adult has filled matching field of the Means of Contact</li>
     * </ul>
     * Example: An adult might be notified by email, if Means of Contact Email is enabled
     * and if he has provided his email (when creating home folder) .
     */
    List<MeansOfContact> getAdultEnabledMeansOfContact(Adult adult);

    /**
     * Same as getAdultEnabledMeansOfContact for the current ecitizen
     */
    List<MeansOfContact> getCurrentEcitizenEnabledMeansOfContact();

    boolean isAvailable(MeansOfContactEnum type, Adult adult);

    /**
     * Enable a Means of Contact for a local authority
     */
    void enableMeansOfContact(MeansOfContact meansOfContact);

    /**
     * Disable a Means of Contact for a local authority.
     * 
     * Expected business error code is :
     * <dl>
     *   <dt>meansOfContact.message.mustHaveOneEnabled</dt>
     *   <dd>MeansOfContact can't be disabled. It is the unique enabled</dd>
     * <dl>
     */
    void disableMeansOfContact(MeansOfContact meansOfContact)
        throws CvqModelException;

    /**
     * @see #disableMeansOfContact(MeansOfContact)
     */
    void disableMeansOfContact(Long mocId)
        throws CvqModelException, CvqObjectNotFoundException;

    MeansOfContact getById(Long id) throws CvqObjectNotFoundException;
}
