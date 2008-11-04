package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import org.hibernate.Query;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IHomeFolderDAO;

/**
 * Implementation of the {@link IHomeFolderDAO} interface.
 * 
 * @author bor@zenexity.fr
 */
public class HomeFolderDAO extends GenericDAO implements IHomeFolderDAO {

    public HomeFolderDAO() {
        super();
    }

    public List<HomeFolder> listAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("from HomeFolder as homeFolder");
        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        
        return query.list();    
    }
}
