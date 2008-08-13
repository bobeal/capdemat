package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IHistoryEntryDAO extends IGenericDAO {

    /**
     * Return history entries related to the given request
     */
    List listByRequestId(Long hfmrId);

    /**
     * Delete history entries related to the given request
     */
    void deleteEntries(final Long requestId);
}
