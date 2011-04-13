package fr.cg95.cvq.service.users;

import java.io.IOException;
import java.util.Collection;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.exception.CvqBadPasswordException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.schema.ximport.HomeFolderImportDocument;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserWorkflowService {

    UserState[] getPossibleTransitions(UserState state);

    UserState[] getPossibleTransitions(@IsUser Individual individual);

    UserState[] getPossibleTransitions(@IsUser HomeFolder homeFolder);

    boolean isValidTransition(UserState from, UserState to);

    UserState[] getStatesBefore(UserState state);

    UserState[] getStatesWithProperty(String propertyName);

    HomeFolder create(Adult adult, boolean temporary)
        throws CvqException;

    Long add(@IsUser HomeFolder homeFolder, @IsUser Adult adult, boolean assignLogin)
        throws CvqException;

    Long add(@IsUser HomeFolder homeFolder, @IsUser Child child);

    void modify(@IsUser HomeFolder homeFolder);

    void modify(@IsUser Individual individual, JsonObject atom)
        throws CvqException;

    void modifyPassword(@IsUser Adult adult, String oldPassword, String newPassword)
        throws CvqException, CvqBadPasswordException;

    /**
     * Send the new password by email to the home folder's responsible,
     * or to the admin address if the responsible has no email address,
     * or output it in confirmation message if none have an address.
     *
     * @return the confirmation message
     */
    String resetPassword(Adult adult)
        throws CvqException;

    void link(@IsUser Individual owner, @IsUser HomeFolder target, Collection<RoleType> types);

    void unlink(@IsUser Individual owner, @IsUser HomeFolder target);

    void link(@IsUser Individual owner, @IsUser Individual target, Collection<RoleType> roleTypes);

    void unlink(@IsUser Individual owner, @IsUser Individual target);

    void changeState(@IsUser HomeFolder homeFolder, UserState state)
        throws CvqModelException, CvqInvalidTransitionException;

    void changeState(@IsUser Individual individual, UserState state)
        throws CvqModelException, CvqInvalidTransitionException;

    void delete(@IsUser HomeFolder homeFolder);

    void delete(@IsUser Long id);

    void delete(@IsUser Individual individual);

    void importHomeFolders(HomeFolderImportDocument doc)
        throws CvqException, IOException;
    /*
     * Change state of homeFolder and all individual to valid
     * Only possible if current homeFolder state is New or Modify
     */
    void validateHomeFolder(@IsUser HomeFolder homeFolder)
        throws CvqModelException, CvqInvalidTransitionException;
    
}
