package fr.cg95.cvq.dao.users.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IIndividualDAO;
import fr.cg95.cvq.util.Critere;

/**
 * The "Individual" service Hibernate implementation. This class is responsible
 * for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class IndividualDAO extends GenericDAO implements IIndividualDAO {

    private static Logger logger = Logger.getLogger(IndividualDAO.class);

    public Individual findByLogin(final String login) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Individual.class);
        crit.add(Critere.compose("login", login, Critere.EQUALS));
        return (Individual) crit.uniqueResult();
    }

    public Individual findByPublicKey(final String publicKey) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Individual.class);
        crit.add(Critere.compose("publicKey", publicKey, Critere.EQUALS));
        return (Individual) crit.uniqueResult();
    }

    public Individual findByFederationKey(final String federationKey) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Individual.class);
        crit.add(Critere.compose("federationKey", federationKey, Critere.EQUALS));
        return (Individual) crit.uniqueResult();
    }

    public Individual findByCertificate(final String certificate) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Individual.class);
        crit.createCriteria("card").add(
                Critere.compose("certificate", certificate, Critere.EQUALS));
        return (Individual) crit.uniqueResult();
    }

    public List<Individual> search(final Set<Critere> criteria, final String orderedBy, 
            final ActorState[] excludedStates) {

        StringBuffer sb = new StringBuffer();
        sb.append("from Individual as individual").append(" where 1 = 1 ");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        // go through all the criteria and create the query
        for (Critere searchCrit : criteria) {
            if (searchCrit.getAttribut().equals(Individual.SEARCH_BY_LASTNAME)) {
                sb.append(" and lower(individual.lastName) " + searchCrit.getSqlComparatif() + " lower(?)");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
            } else if (searchCrit.getAttribut().equals(Individual.SEARCH_BY_FIRSTNAME)) {
                sb.append(" and lower(individual.firstName) " + searchCrit.getSqlComparatif() + " lower(?)");
                objectList.add(searchCrit.getSqlStringValue());
                typeList.add(Hibernate.STRING);
            } else if (searchCrit.getAttribut().equals(Individual.SEARCH_BY_BIRTHDATE)) {
                sb.append(" and individual.birthDate " + searchCrit.getSqlComparatif() + " ?");
                objectList.add(searchCrit.getDateValue());
                typeList.add(Hibernate.DATE);
            } else if (searchCrit.getAttribut().equals(Individual.SEARCH_BY_HOME_FOLDER_ID)) {
                sb.append(" and individual.homeFolder.id " + searchCrit.getSqlComparatif() + " ?");
                objectList.add(searchCrit.getLongValue());
                typeList.add(Hibernate.LONG);
            } else {
                logger.warn("Unknown search criteria for Individual object");
            }
        }

        if (excludedStates != null && excludedStates.length > 0) {
            for (int i = 0; i < excludedStates.length; i++) {
                sb.append(" and individual.homeFolder.state != ?");
                objectList.add(excludedStates[i].toString());
                typeList.add(Hibernate.STRING);
            }
        }

        if (orderedBy != null) {
            if (orderedBy.equals(Individual.ORDER_BY_LASTNAME))
                sb.append(" order by individual.lastName");
            else
                sb.append(" order by individual.id");
        } else {
            // default sort order
            sb.append(" order by individual.id");
        }

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);
        return HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list();
    }

    public List<Individual> listByHomeFolder(Long homeFolderId) {
        StringBuffer sb = new StringBuffer();
        sb.append("from Individual as individual")
            .append(" where individual.homeFolder = ?");
        return HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong(0, homeFolderId.longValue())
            .list();
    }

    public List<String> getSimilarLogins(final String baseLogin) {

        StringBuffer sb = new StringBuffer().append("select individual.login ")
            .append(" from Individual as individual").append(" where individual.login like ?");

        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setString(0, baseLogin + "%");
        return query.list();
    }

    @Override
    public List<Individual> listByHomeFolderRole(Long homeFolderId, RoleEnum role) {

        StringBuffer sb = new StringBuffer();
        sb.append("select individual from Individual as individual")
            .append(" join individual.individualRoles individualRole ")
            .append(" where individualRole.homeFolderId = ?");
        if (role != null)
            sb.append(" and individualRole.role = ?");
        
        Query query = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong(0, homeFolderId);
        if (role != null)
            query.setString(1, role.toString());
        
        return query.list();
    }

    @Override
    public List<Individual> listBySubjectRole(Long subjectId, RoleEnum role) {
        StringBuffer sb = new StringBuffer();
        sb.append("select individual from Individual as individual")
            .append(" join individual.individualRoles individualRole ")
            .append(" where individualRole.individualId = ?");
        if (role != null)
            sb.append(" and individualRole.role = ?");
        
        Query query = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong(0, subjectId);
        if (role != null)
            query.setString(1, role.toString());
        
        return query.list();
    }

    @Override
    public List<Individual> listBySubjectRoles(Long subjectId, RoleEnum[] roles) {
        StringBuffer sb = new StringBuffer();
        sb.append("select individual from Individual as individual")
            .append(" join individual.individualRoles individualRole ")
            .append(" where individualRole.individualId = ?");

        sb.append(" and (");
        for (int i = 0; i < roles.length; i++) {
            sb.append(" individualRole.role = ? ");
            if (i < roles.length - 1)
                sb.append(" or ");
        }
        sb.append(")");
        
        Query query = HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong(0, subjectId);
        
        for (int i = 0; i < roles.length; i++) {
            query.setString(i + 1, roles[i].toString());
        }

        return query.list();
    }
}
