package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Query;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.dao.authority.ICategoryDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;

/**
 * Hibernate implementation of the {@link ICategoryDAO category DAO interface}.
 * 
 * @author bor@zenexity.fr
 */
public class CategoryDAO extends GenericDAO implements ICategoryDAO {

    @SuppressWarnings("unchecked")
    public List<Category> listAll() {
        return (List<Category>)HibernateUtil.getSession()
            .createQuery("from Category as category order by category.name asc")
            .list();
    }

    public Category findByName(final String name) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Category category where category.name = :name ")
            .setString("name", name);
        return (Category) query.uniqueResult(); 
    }
}
