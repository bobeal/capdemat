package fr.cg95.cvq.dao.request.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * The "RequestType" service Hibernate implementation. This class is responsible
 * for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class RequestTypeDAO extends GenericDAO implements IRequestTypeDAO {

    public RequestTypeDAO() {
        super();
    }

    public List<RequestType> listAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("from RequestType as requestType");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }

    public List<RequestType> listByCategory(final Long categoryId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestType.class);
        crit.createCriteria("category").add(Critere.compose("id", categoryId, Critere.EQUALS));
        return crit.list();
    }

    public List<RequestType> listByCategoryAndState(final Long categoryId, final Boolean active) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestType.class);
        if (categoryId != null)
            crit.createCriteria("category").add(Critere.compose("id", categoryId, Critere.EQUALS));
        if (active != null)
            crit.add(Critere.compose("active", active, Critere.EQUALS));
        return crit.list();
    }

    public RequestType findByName(final String requestTypeName) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestType.class);
        crit.add(Critere.compose("label", requestTypeName, Critere.EQUALS));
        return (RequestType) crit.uniqueResult();
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof RequestType)
            cvqPolicy.check((RequestType) object, PrivilegeDescriptor.ADMIN);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof RequestType)
            cvqPolicy.check((RequestType) object, PrivilegeDescriptor.ADMIN);

        super.update(object);
    }
}
