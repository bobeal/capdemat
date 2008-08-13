package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import org.apache.log4j.Logger;

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

    static Logger logger = Logger.getLogger(HistoryEntryDAO.class);

    public HistoryEntryDAO() {
        super();
    }

    public List listByRequestId(Long hfmrId) {
       return HibernateUtil.getSession()
            .createQuery("from HistoryEntry as he where he.requestId = :requestId")
            .setLong("requestId", hfmrId.longValue())
            .list();
    }

    public void deleteEntries(final Long requestId) {
        int objectsDeleted = HibernateUtil.getSession()
              .createQuery("delete from HistoryEntry he where he.requestId = :requestId")
              .setLong("requestId", requestId)
              .executeUpdate();
        logger.debug("deleteEntries() Deleted " + objectsDeleted + " entries from request "
              + requestId);
    }
}
