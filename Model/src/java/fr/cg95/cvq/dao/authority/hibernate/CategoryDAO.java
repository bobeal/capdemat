package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Query;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.dao.authority.ICategoryDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;

/**
 * Hibernate implementation of the {@link ICategoryDAO category DAO interface}.
 * 
 * @author bor@zenexity.fr
 */
public class CategoryDAO extends GenericDAO implements ICategoryDAO {

    public CategoryDAO() {
        super();
    }

    public List listAll() throws CvqPermissionException {

        StringBuffer sb = new StringBuffer();
        sb.append("from Category as category")
            .append(" order by category.name asc ");

        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }

    public Category findByName(final String name) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Category category where category.name = :name ")
            .setString("name", name);
    
        return (Category) query.uniqueResult(); 
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof Category)
            cvqPolicy.check((Category) object, PrivilegeDescriptor.ADMIN);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof Category)
            cvqPolicy.check((Category) object, PrivilegeDescriptor.ADMIN);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof Category)
            cvqPolicy.check((Category) object, PrivilegeDescriptor.ADMIN);

        super.delete(object);
    }
}
