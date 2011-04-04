package fr.cg95.cvq.service.users;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserService {

    boolean hasHomeFolderRole(@IsUser Long ownerId, @IsUser Long homeFolderId, RoleType role)
        throws CvqObjectNotFoundException;

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

    List<String> validate(Adult adult)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;

    List<String> validate(Child child)
        throws ClassNotFoundException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException;
}
