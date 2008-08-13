package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import fr.cg95.cvq.business.authority.RequestType;
import fr.cg95.cvq.dao.authority.IRequestTypeDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
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

    public List listAll() {
        // no meaning in restricting read access to document types
        StringBuffer sb = new StringBuffer();
        sb.append("from RequestType as requestType");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }

    public List listByCategory(final Long serviceId) {
        // no meaning in restricting read access to document types
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestType.class);
        crit.createCriteria("category").add(Critere.compose("id", serviceId, Critere.EQUALS));
        return crit.list();
    }

    public RequestType findByName(final String requestTypeName) {
        // no meaning in restricting read access to document types
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
