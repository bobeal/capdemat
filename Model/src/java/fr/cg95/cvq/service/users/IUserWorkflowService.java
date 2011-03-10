package fr.cg95.cvq.service.users;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserWorkflowService {

    UserState[] getPossibleTransitions(UserState state);

    boolean isValidTransition(UserState from, UserState to);

    UserState[] getStatesBefore(UserState state);

    UserState[] getStatesWithProperty(String propertyName);

    void changeState(@IsUser HomeFolder homeFolder, UserState state)
        throws CvqModelException, CvqInvalidTransitionException;

    void changeState(@IsUser Individual individual, UserState state)
        throws CvqModelException, CvqInvalidTransitionException;
}
