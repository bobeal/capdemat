package fr.cg95.cvq.dao.request.hibernate;

import java.util.List;

import org.hibernate.Query;

import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.dao.request.ICategoryDAO;
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

    @SuppressWarnings("unchecked")
    public List<Category> listByAgent(final Long agentId, final CategoryProfile categoryProfile) {
        StringBuffer sb = new StringBuffer();
        sb.append("from Category category ")
            .append("join category.categoriesRoles categoriesRoles where categoriesRoles.agentId = :agentId ");

        if (categoryProfile != null)
            sb.append("and categoriesRoles.profile = '").append(categoryProfile.toString())
                .append("'");

        Query query = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong("agentId", agentId);

        return query.list();
    }
}
