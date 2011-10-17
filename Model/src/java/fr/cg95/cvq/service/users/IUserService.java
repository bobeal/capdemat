package fr.cg95.cvq.service.users;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserService {

    boolean hasHomeFolderRole(@IsUser Long ownerId, @IsUser Long homeFolderId, RoleType role);

    /**
     * @param adult The {@link Adult} to validate
     * @param login Whether this {@link Adult} must be a login account
     *              (then we need to validate question/answer and password)
     * @return The list of invalid fields
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    List<String> validate(Adult adult, boolean login)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<String> validate(Individual individual)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    /**
     * @return Whether or not a home folder can be created without starting a request.
     */
     Boolean homeFolderIndependentCreationEnabled();

    /**
     * Enable home folder creation without starting a request.
     */
    void enableHomeFolderIndependentCreation();

    /**
     * Disable home folder creation without starting a request.
     */
    void disableHomeFolderIndependentCreation();
}
