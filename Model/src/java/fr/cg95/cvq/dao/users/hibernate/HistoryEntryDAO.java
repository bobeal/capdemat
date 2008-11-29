package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import fr.cg95.cvq.business.users.HistoryEntry;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IHistoryEntryDAO;

/**
 * DAO for {@link HistoryEntry} objects.
 * 
 * @author bor@zenexity.fr
 */
public class HistoryEntryDAO extends GenericDAO implements IHistoryEntryDAO {

    public List<HistoryEntry> listByRequestId(Long requestId) {
       return HibernateUtil.getSession()
            .createQuery("from HistoryEntry as he where he.requestId = :requestId")
            .setLong("requestId", requestId)
            .list();
    }

    public int deleteEntries(final Long requestId) {
        return HibernateUtil.getSession()
              .createQuery("delete from HistoryEntry he where he.requestId = :requestId")
              .setLong("requestId", requestId)
              .executeUpdate();
    }
}
