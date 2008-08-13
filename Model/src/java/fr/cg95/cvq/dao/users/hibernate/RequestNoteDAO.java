package fr.cg95.cvq.dao.users.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.RequestNote;
import fr.cg95.cvq.business.users.RequestNoteType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IRequestNoteDAO;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * The "RequestNote" service Hibernate implementation. This class is responsible
 * for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class RequestNoteDAO extends GenericDAO implements IRequestNoteDAO {

    public RequestNoteDAO() {
        super();
    }

    public RequestNote findByRequestAndType(final Long requestId, final RequestNoteType rnt) 
        throws CvqPermissionException {

        // check user has read access on associated request
        Request request = null;
        request = (Request) HibernateUtil.getSession().load(Request.class, requestId);

        cvqPolicy.check(request, PrivilegeDescriptor.READ);

        Criteria crit = HibernateUtil.getSession().createCriteria(RequestNote.class);
        crit.createCriteria("request").add(Critere.compose("id", requestId, Critere.EQUALS));
        crit.add(Critere.compose("type", rnt, Critere.EQUALS));

        crit.addOrder(Order.asc("id"));
        return (RequestNote) crit.uniqueResult();
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof RequestNote)
            cvqPolicy.check((RequestNote) object, PrivilegeDescriptor.WRITE);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof RequestNote)
            cvqPolicy.check((RequestNote) object, PrivilegeDescriptor.WRITE);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof RequestNote)
            cvqPolicy.check((RequestNote) object, PrivilegeDescriptor.WRITE);

        super.delete(object);
    }
}
