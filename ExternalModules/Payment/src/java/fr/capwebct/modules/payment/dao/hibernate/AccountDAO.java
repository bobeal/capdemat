package fr.capwebct.modules.payment.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.dao.IAccountDAO;

public class AccountDAO extends GenericHibernateDAO<Account, Long> implements IAccountDAO {

    public List<Account> search(String accountId, String accountLabel, Date accountDateStart,
                Date accountDateEnd, String efaId, long externalApplicationId) 
            throws DataAccessException {
        
        Criteria crit = getSession().createCriteria(Account.class);

        if (accountId != null)
            crit.add(Restrictions.like("accountId", accountId, MatchMode.ANYWHERE));
        if (accountLabel != null)
            crit.add(Restrictions.ilike("accountLabel", accountLabel, 
                    MatchMode.ANYWHERE));
        if (accountDateStart != null)
            crit.add(Restrictions.ge("accountDate", accountDateStart));
        if (accountDateEnd != null)
            crit.add(Restrictions.le("accountDate", accountDateEnd));
        if ((efaId != null && !efaId.equals(""))
                || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (efaId != null && !efaId.equals(""))
                efaCriteria.add(Restrictions.ilike("externalFamilyAccountId", efaId, 
                        MatchMode.ANYWHERE));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
        }

        return crit.list();
    }

    public List<Account> findByExternalId(String externalFamilyAccountId,
            long externalApplicationId) throws DataAccessException {
        
        Criteria crit = getSession().createCriteria(Account.class);
        
        if (externalFamilyAccountId != null || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (externalFamilyAccountId != null)
                efaCriteria.add(Restrictions.eq("externalFamilyAccountId", externalFamilyAccountId));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
            return crit.list();
        } else {
            return null;
        }
    }

    public Account findByExternalAndAccountId(String externalFamilyAccountId,
            long externalApplicationId, String accountId) throws DataAccessException {

        Criteria crit = getSession().createCriteria(Account.class);
        
        if (accountId != null)
            crit.add(Restrictions.eq("accountId", accountId));
        if (externalFamilyAccountId != null || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (externalFamilyAccountId != null)
                efaCriteria.add(Restrictions.eq("externalFamilyAccountId", externalFamilyAccountId));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
        }

        return (Account) crit.uniqueResult();
    }
}
