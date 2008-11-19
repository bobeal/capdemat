package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.business.users.HistoryEntry;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author bor@zenexity.fr
 */
public interface IHistoryEntryDAO extends IGenericDAO {

    /**
     * Return history entries related to the given request.
     */
    List<HistoryEntry> listByRequestId(Long requestId);

    /**
     * Delete history entries related to the given request.
     */
    int deleteEntries(final Long requestId);
}
