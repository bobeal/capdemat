package fr.cg95.cvq.service.users;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.schema.ximport.HomeFolderImportDocument;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;

/**
 * Service related to the management of home folders.
 *
 * @author bor@zenexity.fr
 */
public interface IHomeFolderService {

    /** the notification type to use when a password is reset via secret question/answer */
    public static enum PasswordResetNotificationType {
        /** the adult has an email address it will be sent to*/
        ADULT_EMAIL,
        /** the adult has no email address but the VO Card Request category has one */
        CATEGORY_EMAIL,
        /** none have an address, the password will be output in the success message */
        INLINE;
    }

    HomeFolder create(Adult adult, boolean temporary)
        throws CvqException;

    void modify(@IsHomeFolder final HomeFolder homeFolder)
        throws CvqException;

    void delete(@IsHomeFolder HomeFolder homeFolder)
        throws CvqException, CvqObjectNotFoundException;

    void delete(@IsHomeFolder final Long id)
    	throws CvqException, CvqObjectNotFoundException;

    void addAdult(@IsHomeFolder HomeFolder homeFolder, @IsIndividual Adult adult, boolean assignLogin)
        throws CvqException;

    void addChild(@IsHomeFolder HomeFolder homeFolder, @IsIndividual Child child);

    void deleteIndividual(@IsHomeFolder final Long homeFolderId, final Long individualId)
        throws CvqException, CvqObjectNotFoundException;
    
    List<HomeFolder> getAll(boolean filterArchived, boolean filterTemporary)
        throws CvqException;

    HomeFolder getById(@IsHomeFolder final Long id)
        throws CvqException, CvqObjectNotFoundException;

    List<Child> getChildren(@IsHomeFolder final Long homeFolderId)
        throws CvqException;

    List<Adult> getAdults(@IsHomeFolder final Long homeFolderId);
    
    List<Individual> getIndividuals(@IsHomeFolder final Long homeFolderId)
        throws CvqException;
    
    /**
     * Get a list of individuals who have a role in the home folder but are not part of it.
     */
    List<Individual> getExternalIndividuals(@IsHomeFolder final Long homeFolderId)
        throws CvqException;

    void link(@IsIndividual Individual owner, @IsHomeFolder HomeFolder target, Collection<RoleType> types);

    void unlink(@IsIndividual Individual owner, @IsHomeFolder HomeFolder target);

    void link(@IsIndividual Individual owner, @IsIndividual Individual target, Collection<RoleType> roleTypes);

    void unlink(@IsIndividual Individual owner, @IsIndividual Individual target);

    boolean hasHomeFolderRole(@IsIndividual final Long ownerId, 
            @IsHomeFolder final Long homeFolderId, final RoleType role)
        throws CvqException;

    /**
     * Get the adult that has the 
     * {@link RoleType#HOME_FOLDER_RESPONSIBLE home folder responsible role} on the
     * given home folder.
     */
    Adult getHomeFolderResponsible(@IsHomeFolder final Long homeFolderId)
        throws CvqException;
    
    List<Individual> getByHomeFolderRole(@IsHomeFolder final Long homeFolderId, 
            RoleType role);
    
    List<Individual> listByHomeFolderRoles(@IsHomeFolder final Long homeFolderId, 
            RoleType[] roles);

    List<Individual> getBySubjectRole(@IsIndividual Long subjectId, RoleType role);

    List<Individual> getBySubjectRoles(@IsIndividual Long subjectId, RoleType[] roles);

    /**
     * Validate an home folder and its associated individuals.
     */
    void validate(@IsHomeFolder final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Invalidate an home folder and its associated individuals.
     */
    void invalidate(@IsHomeFolder final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Disable an home folder and its associated individuals and requests.
     */
    void archive(@IsHomeFolder final Long id)
        throws CvqException, CvqObjectNotFoundException;

    /**
     * Send the new password by email to the home folder's responsible,
     * or to the category address if the responsible has no email address,
     * or does nothing if none have an address.
     *
     * @return the notification type used to send the new password
     */
    PasswordResetNotificationType notifyPasswordReset(Adult adult, String password, String categoryAddress)
        throws CvqException;

    void importHomeFolders(HomeFolderImportDocument doc)
        throws CvqException, IOException;
}
