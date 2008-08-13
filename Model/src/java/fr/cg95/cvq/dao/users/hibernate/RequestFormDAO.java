package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import fr.cg95.cvq.business.authority.RequestForm;
import fr.cg95.cvq.business.authority.RequestFormType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IRequestFormDAO;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;

/**
 * Hibernate implementation of the {@link IRequestFormDAO} interface.
 *
 * @author bor@zenexity.fr
 */
public class RequestFormDAO extends GenericDAO implements IRequestFormDAO {

    public RequestFormDAO() {
        super();
    }

    public RequestForm findByTypeAndRequest(final RequestFormType requestFormType,
            final String requestLabel) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestForm.class);
        crit.add(Critere.compose("type", requestFormType, Critere.EQUALS));
        crit.createCriteria("requestTypes")
            .add(Critere.compose("label", requestLabel, Critere.EQUALS));
        return (RequestForm) crit.uniqueResult();
    }
    
    public List<RequestForm> findByTypeAndRequestTypeId(final RequestFormType requestFormType,
            final long requestTypeId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestForm.class);
        crit.add(Critere.compose("type", requestFormType, Critere.EQUALS));
        crit.createCriteria("requestTypes")
            .add(Critere.compose("id", requestTypeId, Critere.EQUALS));
        return crit.list();
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof RequestForm)
            cvqPolicy.check((RequestForm) object, PrivilegeDescriptor.ADMIN);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof RequestForm)
            cvqPolicy.check((RequestForm) object, PrivilegeDescriptor.ADMIN);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof RequestForm)
            cvqPolicy.check((RequestForm) object, PrivilegeDescriptor.ADMIN);

        super.delete(object);
    }
}
