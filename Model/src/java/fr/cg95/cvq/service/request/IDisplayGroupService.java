package fr.cg95.cvq.service.request;

import java.util.List;

import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.exception.CvqModelException;

/**
 * @author rdj@zenexity.fr
 */
public interface IDisplayGroupService {

    DisplayGroup addRequestType(final Long displayGroupId, final Long requestTypeId);

    DisplayGroup removeRequestType(final Long displayGroupId, final Long requestTypeId);

    Long create(final DisplayGroup displayGroup) throws CvqModelException;

    void modify(final DisplayGroup displayGroup) throws CvqModelException;

    void delete(final Long id);

    List<DisplayGroup> getAll();

    DisplayGroup getById(final Long id);
}
