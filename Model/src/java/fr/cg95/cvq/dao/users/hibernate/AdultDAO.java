package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IAdultDAO;

/**
 * The "Adult" service Hibernate implementation. This class is responsible for
 * data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class AdultDAO extends IndividualDAO implements IAdultDAO {

    public AdultDAO() {
        super();
    }
    
    public List listAdultsByHomeFolder(final Long homeFolderId) {
        StringBuffer sb = new StringBuffer(100);
        sb.append("select adult from Adult as adult")
            .append(" join adult.homeFolder homeFolder")
            .append(" where homeFolder.id = ?");
        return HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong(0, homeFolderId.longValue())
            .list();
    }
}
