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
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
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

    void link(@IsUser Individual owner, @IsUser HomeFolder target, Collection<RoleType> types);

    void unlink(@IsUser Individual owner, @IsUser HomeFolder target);

    void link(@IsUser Individual owner, @IsUser Individual target, Collection<RoleType> roleTypes);

    void unlink(@IsUser Individual owner, @IsUser Individual target);

    void changeState(@IsUser HomeFolder homeFolder, UserState state)
        throws CvqModelException, CvqInvalidTransitionException;

    void changeState(@IsUser Individual individual, UserState state)
        throws CvqModelException, CvqInvalidTransitionException;

    void delete(@IsUser HomeFolder homeFolder);

    void delete(@IsUser Long id)
        throws CvqObjectNotFoundException;

    void delete(@IsUser Individual individual);

    void importHomeFolders(HomeFolderImportDocument doc)
        throws CvqException, IOException;
}
