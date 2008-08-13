package fr.cg95.cvq.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.security.IPolicyDelegate;

/**
 *
 * @author bor@zenexity.fr
 */
public class GenericDAO implements IGenericDAO {

    protected IPolicyDelegate cvqPolicy;
    	
    public GenericDAO() {
    }

    public Object findById(final Class clazz, final Long id) 
        throws CvqObjectNotFoundException, CvqPermissionException {

        return findById(clazz, id, null);
    }

    public Object findById(final Class clazz, final Long id, 
            final PrivilegeDescriptor privilegeDescriptor) 
        throws CvqObjectNotFoundException, CvqPermissionException {

        Object object = null;
        try {
            object = HibernateUtil.getSession().load(clazz, id);
        } catch (ObjectNotFoundException onfe) {
            throw new CvqObjectNotFoundException("Object of class " + clazz.getName()
                    + " with id " + id + " not found");
        } catch (ObjectDeletedException ode) {
            // happens during unit tests
            throw new CvqObjectNotFoundException("Object of class " + clazz.getName()
                    + " with id " + id + " has been deleted");
        }
        if (privilegeDescriptor != null)
            cvqPolicy.check(object, privilegeDescriptor);
        
        return object;
    }

    public Long create(final Object object) throws CvqPermissionException {
        Long generatedId = (Long) HibernateUtil.getSession().save(object);
        return generatedId;
    }

    public void update(final Object object) throws CvqPermissionException {
        HibernateUtil.getSession().update(object);
    }

    public Object saveOrUpdate(final Object object) throws CvqPermissionException {
        return HibernateUtil.getSession().merge(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        HibernateUtil.getSession().delete(object);
    }

    public void setCvqPolicy(IPolicyDelegate policyDelegate) {
        this.cvqPolicy = policyDelegate;
    }
}
