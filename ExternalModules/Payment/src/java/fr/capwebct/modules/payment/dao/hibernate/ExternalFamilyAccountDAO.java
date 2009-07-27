package fr.capwebct.modules.payment.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccountSearchResult;
import fr.capwebct.modules.payment.dao.IExternalFamilyAccountDAO;

public class ExternalFamilyAccountDAO extends GenericHibernateDAO<ExternalFamilyAccount, Long>
		implements IExternalFamilyAccountDAO {

	public List<ExternalFamilyAccountSearchResult> search(String externalFamilyAccountId,
			String externalResponsibleLastName, long externalApplicationId,
			long capwebctFamilyAccountId, String capwebctIndividualLastName, 
            int results, int startIndex, String sort, String dir) throws DataAccessException {
		try {
            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("select efa.externalFamilyAccountId, individual.lastName, individual.firstName, ")
                .append("efa.address, efa.externalApplication.label, ")
                .append("efa.capwebctFamilyAccount.capwebctFamilyAccountId, ")
                .append("efa.capwebctFamilyAccount.responsibleFullName ")
                .append("from ExternalFamilyAccount efa ")
                .append("join efa.individuals individual ")
                .append("where individual.responsible = true ");
            
            if (externalFamilyAccountId != null && !externalFamilyAccountId.equals("")) {
                sb.append("and efa.externalFamilyAccountId = ? ");
                objectList.add(externalFamilyAccountId);
                typeList.add(Hibernate.STRING);
            }
            
            if (externalResponsibleLastName != null && !externalResponsibleLastName.equals("")) {
                sb.append("and individual.lastName like ? ");
                objectList.add(externalResponsibleLastName + "%");
                typeList.add(Hibernate.STRING);                
            }
            
            if (externalApplicationId != 0) {
                sb.append("and efa.externalApplication.id = ? ");
                objectList.add(externalApplicationId);
                typeList.add(Hibernate.LONG);
            }
            
            if (capwebctFamilyAccountId != 0) {
                sb.append("and efa.capwebctFamilyAccount.capwebctFamilyAccountId = ? ");
                objectList.add(capwebctFamilyAccountId);
                typeList.add(Hibernate.LONG);
            }
            
            if (capwebctIndividualLastName != null && !capwebctIndividualLastName.equals("")) {
                sb.append("and efa.capwebctFamilyAccount.responsibleFullName like ? ");
                objectList.add(capwebctIndividualLastName + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (sort != null) {
                if (sort.equals("efaId"))
                    sb.append("order by efa.externalFamilyAccountId ");
                else if (sort.equals("externalResponsible"))
                    sb.append("order by individual.lastName ");
            } else {
                sb.append("order by efa.externalFamilyAccountId ");
            }
            
            if (dir != null && dir.equals("desc "))
                sb.append(" desc ");

            
            Type[] typeTab = typeList.toArray(new Type[0]);
            Object[] objectTab = objectList.toArray(new Object[0]);
            Query query = getSession().createQuery(sb.toString()).setParameters(objectTab, typeTab);
            query.setFirstResult(startIndex);
            query.setMaxResults(results);

            List<ExternalFamilyAccountSearchResult> searchResults =
                new ArrayList<ExternalFamilyAccountSearchResult>();
            Iterator pairs = query.list().iterator();
            while (pairs.hasNext()) {
                Object[] pair = (Object[]) pairs.next();
                ExternalFamilyAccountSearchResult efasr = new ExternalFamilyAccountSearchResult();
                efasr.setEfaId((String) pair[0]);
                efasr.setEfaLastName((String) pair[1]);
                efasr.setEfaFirstName((String) pair[2]);
                efasr.setEfaAddress((String) pair[3]);
                efasr.setExternalApplicationLabel((String) pair[4]);
                efasr.setCfaId((Long) pair[5]);
                efasr.setCfaResponsible((String) pair[6]);
                searchResults.add(efasr);
            }
            
            return searchResults;
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}

    public Long countForSearch(String externalFamilyAccountId, String externalResponsibleLastName, 
            long externalApplicationId, long capwebctFamilyAccountId, 
            String capwebctIndividualLastName) throws DataAccessException {
        try {
            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("select count(efa) ")
                .append("from ExternalFamilyAccount efa ")
                .append("join efa.individuals individual ")
                .append("where individual.responsible = true ");
            
            if (externalFamilyAccountId != null && !externalFamilyAccountId.equals("")) {
                sb.append("and efa.externalFamilyAccountId = ? ");
                objectList.add(externalFamilyAccountId);
                typeList.add(Hibernate.STRING);
            }
            
            if (externalResponsibleLastName != null && !externalResponsibleLastName.equals("")) {
                sb.append("and individual.lastName like ? ");
                objectList.add(externalResponsibleLastName + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (externalApplicationId != 0) {
                sb.append("and efa.externalApplication.id = ? ");
                objectList.add(externalApplicationId);
                typeList.add(Hibernate.LONG);
            }
            
            if (capwebctFamilyAccountId != 0) {
                sb.append("and efa.capwebctFamilyAccount.capwebctFamilyAccountId = ? ");
                objectList.add(capwebctFamilyAccountId);
                typeList.add(Hibernate.LONG);
            }
            
            if (capwebctIndividualLastName != null && !capwebctIndividualLastName.equals("")) {
                sb.append("and efa.capwebctFamilyAccount.responsibleFullName like ? ");
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

    public List<ExternalFamilyAccount> searchForAutocomplete(String externalResponsibleLastName,
            long externalApplicationId) 
        throws DataAccessException {
        
        try {
            Criteria crit = getSession().createCriteria(ExternalFamilyAccount.class);
            
            crit.createCriteria("individuals")
                .add(Restrictions.ilike("lastName", externalResponsibleLastName, MatchMode.START))
                .add(Restrictions.eq("responsible", true)).addOrder(Order.asc("lastName")).addOrder(Order.asc("firstName"));
            
            crit.createCriteria("externalApplication")
                .add(Restrictions.eq("id", externalApplicationId));

            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return crit.list();
        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

	public List<ExternalFamilyAccount> getByCfa(long capwebctFamilyAccountId) 
        throws DataAccessException {
        
        if (capwebctFamilyAccountId == 0)
            return null;

        try {
			Criteria crit = getSession().createCriteria(ExternalFamilyAccount.class);
			crit.createCriteria("capwebctFamilyAccount")
			    .add(Restrictions.eq("capwebctFamilyAccountId", capwebctFamilyAccountId));

			return crit.list();
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}

    public ExternalFamilyAccount getByCfaAndExternalApplication(long cfaId, 
            long externalApplicationId) throws DataAccessException {
        try {
            Criteria crit = getSession().createCriteria(ExternalFamilyAccount.class);
            crit.createCriteria("capwebctFamilyAccount")
                .add(Restrictions.eq("capwebctFamilyAccountId", cfaId));
            crit.createCriteria("externalApplication")
                .add(Restrictions.eq("id", externalApplicationId));

            return (ExternalFamilyAccount) crit.uniqueResult();
        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }


    public List<ExternalFamilyAccount> getByExternalApplication(long externalApplicationId) 
        throws DataAccessException {
        try {
            Criteria crit = getSession().createCriteria(ExternalFamilyAccount.class);
            crit.createCriteria("externalApplication")
                .add(Restrictions.eq("id", externalApplicationId));

            return crit.list();
        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

    public ExternalFamilyAccount getByExternalFamilyAccount(String externalFamilyAccountId, 
            long externalApplicationId) throws DataAccessException {
        try {
            Criteria crit = getSession().createCriteria(ExternalFamilyAccount.class);

            crit.add(Restrictions.eq("externalFamilyAccountId", externalFamilyAccountId));
            if (externalApplicationId != 0)
                crit.createCriteria("externalApplication")
                    .add(Restrictions.eq("id", externalApplicationId));
            return (ExternalFamilyAccount) crit.uniqueResult();
        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }

    public List<ExternalFamilyAccount> getAssociatedAccounts(final long externalApplicationId, 
            String cfaResponsible, final int results, final int startIndex, 
            final String sort, final String dir) 
        throws DataAccessException {
        
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("from ExternalFamilyAccount efa ");
            
            sb.append("where efa.externalApplication.id = ? ");
            objectList.add(externalApplicationId);
            typeList.add(Hibernate.LONG);

            sb.append("and efa.capwebctFamilyAccount is not null ");
            
            if (cfaResponsible != null && !cfaResponsible.equals("")) {
                sb.append("and lower(efa.capwebctFamilyAccount.responsibleFullName) like lower(?) ");
                objectList.add("%" + cfaResponsible + "%");
                typeList.add(Hibernate.STRING);
            }
            
            if (sort != null) {
                if (sort.equals("cfaId"))
                    sb.append("order by efa.capwebctFamilyAccount.capwebctFamilyAccountId ");
                else if (sort.equals("cfaResponsible"))
                    sb.append("order by efa.capwebctFamilyAccount.responsibleFullName ");
            } else {
                sb.append("order by efa.capwebctFamilyAccount.capwebctFamilyAccountId ");
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

    public Long getCountForAssociatedAccounts(long externalApplicationId, String cfaResponsible) 
        throws DataAccessException {
        try {

            List<Type> typeList = new ArrayList<Type>();
            List<Object> objectList = new ArrayList<Object>();

            StringBuffer sb = new StringBuffer();
            sb.append("select count(efa) ")
                .append("from ExternalFamilyAccount efa ");
            
            sb.append("where efa.externalApplication.id = ? ");
            objectList.add(externalApplicationId);
            typeList.add(Hibernate.LONG);

            sb.append("and efa.capwebctFamilyAccount is not null ");
            
            if (cfaResponsible != null && !cfaResponsible.equals("")) {
                sb.append("and lower(efa.capwebctFamilyAccount.responsibleFullName) like lower(?) ");
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
}
