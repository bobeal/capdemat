package fr.capwebct.modules.payment.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.dao.IContractDAO;

public class ContractDAO extends GenericHibernateDAO<Contract, Long> 
    implements IContractDAO {

    public Contract findByExternalAndContractId(String externalFamilyAccountId,
            long externalApplicationId, String externalIndividualId,
            String contractId) throws DataAccessException {
    
        Criteria crit = getSession().createCriteria(Contract.class);

        if (externalIndividualId != null)
            crit.createCriteria("externalIndividual")
                .add(Restrictions.eq("externalIndividualId", externalIndividualId));
        if ((externalFamilyAccountId != null && !externalFamilyAccountId.equals(""))
                || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (externalFamilyAccountId != null && !externalFamilyAccountId.equals(""))
                efaCriteria.add(Restrictions.ilike("externalFamilyAccountId", 
                        externalFamilyAccountId, MatchMode.ANYWHERE));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
        }
        if (contractId != null && !contractId.equals(""))
            crit.add(Restrictions.eq("contractId", contractId));
        
        return (Contract) crit.uniqueResult();
    }

	public List<Contract> findByExternalId(String externalFamilyAccountId,
			    long externalApplicationId, String externalIndividualId)
            throws DataAccessException {
		
        Criteria crit = getSession().createCriteria(Contract.class);
        
		if (externalIndividualId != null)
            crit.createCriteria("externalIndividual")
                .add(Restrictions.eq("externalIndividualId", externalIndividualId));
        if ((externalFamilyAccountId != null && !externalFamilyAccountId.equals(""))
                || externalApplicationId != 0) {
            Criteria efaCriteria = crit.createCriteria("externalFamilyAccount");
            if (externalFamilyAccountId != null && !externalFamilyAccountId.equals(""))
                efaCriteria.add(Restrictions.ilike("externalFamilyAccountId", 
                        externalFamilyAccountId, MatchMode.ANYWHERE));
            if (externalApplicationId != 0) {
                Criteria extAppCriteria = efaCriteria.createCriteria("externalApplication");
                extAppCriteria.add(Restrictions.eq("id", externalApplicationId));
            }
        }

		return crit.list();
	}

    public List<Contract> search(String contractId, String contractLabel, 
                String externalIndividualId, String efaId, long externalApplicationId) 
            throws DataAccessException {
        
        try {
            Criteria crit = getSession().createCriteria(Contract.class);
            
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
            if (externalIndividualId != null && !externalIndividualId.equals(""))
                crit.createCriteria("externalIndividual")
                    .add(Restrictions.ilike("externalIndividualId", externalIndividualId, 
                            MatchMode.ANYWHERE));
            if (contractId != null && !contractId.equals(""))
                crit.add(Restrictions.ilike("contractId", contractId, MatchMode.ANYWHERE));
            if (contractLabel != null && !contractLabel.equals(""))
                crit.add(Restrictions.ilike("contractLabel", contractLabel, MatchMode.ANYWHERE));

            return crit.list();
        } catch (HibernateException exception) {
            throw SessionFactoryUtils.convertHibernateAccessException(exception);
        }
    }
}
