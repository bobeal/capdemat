package fr.cg95.cvq.service.request;

import java.util.List;

import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 * @author rdj@zenexity.fr
 */
public interface IDisplayGroupService {

    DisplayGroup addRequestType(final Long displayGroupId, final Long requestTypeId)
        throws CvqException;

    DisplayGroup removeRequestType(final Long displayGroupId, final Long requestTypeId)
        throws CvqException;

    Long create(final DisplayGroup displayGroup) throws CvqModelException;

    void modify(final DisplayGroup displayGroup) throws CvqModelException;

    void delete(final Long id) throws CvqObjectNotFoundException;

    List<DisplayGroup> getAll();

    DisplayGroup getById(final Long id) throws CvqObjectNotFoundException;
}
