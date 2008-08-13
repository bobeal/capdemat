package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;
import fr.cg95.cvq.business.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.RequestAction;
import fr.cg95.cvq.business.users.RequestState;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IRequestActionDAO;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * The "RequestAction" service Hibernate implementation. This class is
 * responsible for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class RequestActionDAO extends GenericDAO implements IRequestActionDAO {

    public RequestActionDAO() {
        super();
    }

    /**
     * TODO : it can happen that a request has two entries for a given resulting
     * state
     */
    public RequestAction findByRequestIdAndResultingState(final Long requestId,
            final RequestState requestState) {

        // checking access to request is sufficient
        // FIXME : catch exception and return a empty array list ?
        // Request request =
        // (Request) getHibernateTemplate().load(Request.class, requestId);

        // security = SecurityPolicy.get(request);
        // security.check(PrivilegeDescriptor.READ);

        Criteria crit = HibernateUtil.getSession().createCriteria(RequestAction.class);
        crit.createCriteria("request").add(Critere.compose("id", requestId, Critere.EQUALS));
        crit.add(Critere.compose("resultingState", requestState, Critere.EQUALS));
        return (RequestAction) crit.uniqueResult();
    }

    public boolean hasAction(final Long requestId, final String actionLabel) {

        Criteria crit = HibernateUtil.getSession().createCriteria(RequestAction.class);
        crit.createCriteria("request").add(Restrictions.eq("id", requestId));
        crit.add(Restrictions.eq("label", actionLabel));
        List resultList = crit.list();

        if (resultList == null || resultList.size() == 0)
            return false;
        else
            return true;
    }

    public List listByRequest(final Long requestId) throws CvqPermissionException {

        // checking access to request is sufficient
        // FIXME : catch exception and return a empty array list ?
        Request request = null;
        request = (Request) HibernateUtil.getSession().load(Request.class, requestId);
        cvqPolicy.check(request, PrivilegeDescriptor.READ);

        Criteria crit = HibernateUtil.getSession().createCriteria(RequestAction.class);
        crit.createCriteria("request").add(Critere.compose("id", requestId, Critere.EQUALS));
        crit.addOrder(Order.asc("date"));
        return crit.list();
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (!(object instanceof RequestAction))
            return super.create(object);

        RequestAction requestAction = (RequestAction) object;
        Request request = requestAction.getRequest();
        // only authorize creation of VO card requests
        // to unauthenticated users
        if (!(request instanceof VoCardRequest && request.getState().equals(RequestState.PENDING))) {
            cvqPolicy.check(requestAction, PrivilegeDescriptor.WRITE);
        }

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof RequestAction)
            cvqPolicy.check((RequestAction) object, PrivilegeDescriptor.WRITE);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof RequestAction)
            cvqPolicy.check((RequestAction) object, PrivilegeDescriptor.WRITE);

        super.delete(object);
    }
}
