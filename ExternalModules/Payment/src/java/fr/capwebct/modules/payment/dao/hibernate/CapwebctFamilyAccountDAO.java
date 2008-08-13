package fr.capwebct.modules.payment.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.dao.ICapwebctFamilyAccountDAO;

public class CapwebctFamilyAccountDAO extends GenericHibernateDAO<CapwebctFamilyAccount,Long> 
    implements ICapwebctFamilyAccountDAO {

	public List<CapwebctFamilyAccount> search(long capwebctFamilyAccountId, 
            String capwebctIndividualLastName, final int results, final int startIndex,
            final String sort, final String dir) throws DataAccessException {
        
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("from CapwebctFamilyAccount cfa ")
                .append("where 1 = 1 ");
            
            if (capwebctFamilyAccountId != 0) {
                sb.append("and cfa.capwebctFamilyAccountId = ? ");
                objectList.add(capwebctFamilyAccountId);
                typeList.add(Hibernate.LONG);
            }
            
            if (capwebctIndividualLastName != null && !capwebctIndividualLastName.equals("")) {
                sb.append("and cfa.responsibleFullName like ? ");
                objectList.add(capwebctIndividualLastName + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (sort != null) {
                if (sort.equals("cfaId"))
                    sb.append("order by cfa.capwebctFamilyAccountId ");
                else if (sort.equals("cfaResponsible"))
                    sb.append("order by cfa.responsibleFullName ");
            } else {
                sb.append("order by cfa.capwebctFamilyAccountId ");
            }
            
            if (dir != null && dir.equals("desc"))
                sb.append(" desc");

            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);
            query.setFirstResult(startIndex);
            query.setMaxResults(results);

            return query.list();

        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
	}
	
    public Long countForSearch(long capwebctFamilyAccountId, String capwebctIndividualLastName) 
        throws DataAccessException {
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("select count(cfa) from CapwebctFamilyAccount cfa ")
                .append("where 1 = 1 ");
            
            if (capwebctFamilyAccountId != 0) {
                sb.append("and cfa.capwebctFamilyAccountId = ? ");
                objectList.add(capwebctFamilyAccountId);
                typeList.add(Hibernate.LONG);
            }
            
            if (capwebctIndividualLastName != null && !capwebctIndividualLastName.equals("")) {
                sb.append("and cfa.responsibleFullName like ? ");
                objectList.add(capwebctIndividualLastName + "%");
                typeList.add(Hibernate.STRING);
            }

            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);

            return (Long) query.iterate().next();

        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

    public Long getCountForStateAndExternalApplication(final String state,
            final long externalApplicationId, final String cfaResponsible) 
        throws DataAccessException {
        
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("select count(cfa) from CapwebctFamilyAccount cfa ")
                .append("join cfa.associationsSummary association ");
            
            sb.append("where association.state = ? ");
            objectList.add(state);
            typeList.add(Hibernate.STRING);

            sb.append("and association.externalApplicationId = ? ");
            objectList.add(externalApplicationId);
            typeList.add(Hibernate.LONG);

            if (cfaResponsible != null && !cfaResponsible.equals("")) {
                sb.append("and lower(cfa.responsibleFullName) like lower(?) ");
                objectList.add("%" + cfaResponsible + "%");
                typeList.add(Hibernate.STRING);
            }
            
            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);

            return (Long) query.iterate().next();

        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

    public List<CapwebctFamilyAccount> getForStateAndExternalApplication(final String state, 
            long externalApplicationId, String cfaResponsible, final int maxResults,
            final int startIndex, final String sort, final String dir) 
            throws DataAccessException {
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("from CapwebctFamilyAccount cfa ")
                .append("join cfa.associationsSummary association ");
            
            sb.append("where association.state = ? ");
            objectList.add(state);
            typeList.add(Hibernate.STRING);

            sb.append("and association.externalApplicationId = ? ");
            objectList.add(externalApplicationId);
            typeList.add(Hibernate.LONG);

            if (cfaResponsible != null && !cfaResponsible.equals("")) {
                sb.append("and lower(cfa.responsibleFullName) like lower(?) ");
                objectList.add("%" + cfaResponsible + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (sort != null) {
                if (sort.equals("cfaId"))
                    sb.append("order by cfa.capwebctFamilyAccountId ");
                else if (sort.equals("cfaResponsible"))
                    sb.append("order by cfa.responsibleFullName ");
            } else {
                sb.append("order by cfa.capwebctFamilyAccountId ");
            }
            
            if (dir != null && dir.equals("desc"))
                sb.append(" desc");

            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);
            query.setFirstResult(startIndex);
            query.setMaxResults(maxResults);

            return query.list();

        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

    public CapwebctFamilyAccount getByCfaId(long cfaId) throws DataAccessException {
        try {
            Criteria crit = getSession().createCriteria(CapwebctFamilyAccount.class);
            crit.add(Restrictions.eq("capwebctFamilyAccountId", cfaId));
            
            return (CapwebctFamilyAccount) crit.uniqueResult();
        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }
}
