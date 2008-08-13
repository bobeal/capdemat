package fr.capwebct.modules.payment.service.impl;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.CapwebctAssociationSummary;
import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalFamilyAccountSearchResult;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.dao.ICapwebctFamilyAccountDAO;
import fr.capwebct.modules.payment.dao.IExternalApplicationDAO;
import fr.capwebct.modules.payment.dao.IExternalFamilyAccountDAO;
import fr.capwebct.modules.payment.dao.IObjectDAO;
import fr.capwebct.modules.payment.service.IFamilyAccountService;

public class FamilyAccountService implements IFamilyAccountService {

	private static Log log = LogFactory.getLog(FamilyAccountService.class);

    private IExternalApplicationDAO externalApplicationDAO;
    
    private IObjectDAO objectDAO;
	private IExternalFamilyAccountDAO externalFamilyAccountDAO;
	private ICapwebctFamilyAccountDAO capwebctFamilyAccountDAO;

	public ExternalFamilyAccount createExternalFamilyAccount(String externalFamilyAccountId,
			long externalApplicationId) throws DataAccessException {

		ExternalFamilyAccount externalFamilyAccount = new ExternalFamilyAccount();
		externalFamilyAccount.setExternalFamilyAccountId(externalFamilyAccountId);
        ExternalApplication externalApplication =
            (ExternalApplication) objectDAO.read(ExternalApplication.class, externalApplicationId);
		externalFamilyAccount.setExternalApplication(externalApplication);

		externalFamilyAccountDAO.create(externalFamilyAccount);
		return externalFamilyAccount;
	}

	public ExternalFamilyAccount addExternalIndividual(ExternalFamilyAccount externalFamilyAccount,
			ExternalIndividual individual) throws DataAccessException {

		externalFamilyAccount.addIndividual(individual);
		externalFamilyAccountDAO.create(externalFamilyAccount);
		return externalFamilyAccount;
	}

	public ExternalFamilyAccount removeExternalIndividual(
			ExternalFamilyAccount externalFamilyAccount, ExternalIndividual individual)
			throws DataAccessException {
		
		ExternalFamilyAccount toUpdateAccount = externalFamilyAccountDAO.read(externalFamilyAccount.getId());
		toUpdateAccount.removeIndividual(individual);
		externalFamilyAccountDAO.update(toUpdateAccount);
		return toUpdateAccount;
	}

	public ExternalFamilyAccount bindFamilyAccounts(ExternalFamilyAccount externalFamilyAccount,
			CapwebctFamilyAccount capwebctFamilyAccount) throws DataAccessException {

        externalFamilyAccount.setCapwebctFamilyAccount(capwebctFamilyAccount);
		externalFamilyAccountDAO.create(externalFamilyAccount);
		return externalFamilyAccount;
	}

	public ExternalFamilyAccount bindFamilyAccounts(String externalFamilyAccountId,
			long externalApplicationId, long capwebctFamilyAccountId)
			throws DataAccessException {

        // First, eventually de-associate an EFA associated to this CFA
        ExternalFamilyAccount efa = 
            externalFamilyAccountDAO.getByCfaAndExternalApplication(capwebctFamilyAccountId, 
                    externalApplicationId);
        if (efa != null) {
            // This CapWebCT family account was already associated, remove it
            unbindFamilyAccount(efa.getExternalFamilyAccountId(), externalApplicationId);
        }

        ExternalFamilyAccount externalFamilyAccount = 
            externalFamilyAccountDAO.getByExternalFamilyAccount(externalFamilyAccountId, 
                    externalApplicationId);
        CapwebctFamilyAccount capwebctFamilyAccount = getCfaByCapwebctId(capwebctFamilyAccountId);
        
        if (externalFamilyAccount == null) {
            // FIXME : is this still possible ???
            log.debug("bindFamilyAccounts() creating efa with id " + externalFamilyAccountId 
                    + " for application " + externalApplicationId);
            externalFamilyAccount = new ExternalFamilyAccount();
            externalFamilyAccount.setExternalFamilyAccountId(externalFamilyAccountId);
            ExternalApplication externalApplication =
                (ExternalApplication) objectDAO.read(ExternalApplication.class, externalApplicationId);
            externalFamilyAccount.setExternalApplication(externalApplication);            
            externalFamilyAccount.setCapwebctFamilyAccount(capwebctFamilyAccount);                
            externalFamilyAccountDAO.create(externalFamilyAccount);
        } else if (externalFamilyAccount.getCapwebctFamilyAccount() == null
                || externalFamilyAccount.getCapwebctFamilyAccount().getCapwebctFamilyAccountId() !=
                    capwebctFamilyAccount.getCapwebctFamilyAccountId()) {
            
            log.debug("bindFamilyAccounts() binding was non existent or has changed for efa with id " 
                    + externalFamilyAccountId + " for application " + externalApplicationId);
            externalFamilyAccount.setCapwebctFamilyAccount(capwebctFamilyAccount);
            // reset individuals bindings
            for (ExternalIndividual externalIndividual : externalFamilyAccount.getIndividuals()) {
                externalIndividual.setCapwebctIndividual(null);
            }
            externalFamilyAccountDAO.update(externalFamilyAccount);
            
            setCapwebctAssocationState(capwebctFamilyAccount, externalApplicationId, "associated");
        }
        
		return externalFamilyAccount;
	}

	public ExternalFamilyAccount bindFamilyAccounts(String externalFamilyAccountId,
			long externalApplicationId, long capwebctFamilyAccountId,
			String capwebctFamilyAccountLabel) throws DataAccessException {

		CapwebctFamilyAccount capwebctFamilyAccount = new CapwebctFamilyAccount();
		capwebctFamilyAccount.setCapwebctFamilyAccountId(capwebctFamilyAccountId);

		ExternalFamilyAccount externalFamilyAccount = new ExternalFamilyAccount();
		externalFamilyAccount.setExternalFamilyAccountId(externalFamilyAccountId);
        ExternalApplication externalApplication =
            (ExternalApplication) objectDAO.read(ExternalApplication.class, externalApplicationId);
		externalFamilyAccount.setExternalApplication(externalApplication);
		externalFamilyAccount.setCapwebctFamilyAccount(capwebctFamilyAccount);
        
        externalFamilyAccountDAO.create(externalFamilyAccount);
		return externalFamilyAccount;
	}

	public ExternalIndividual bindIndividuals(ExternalIndividual externalIndividual,
			CapwebctIndividual capwebctIndividual) throws DataAccessException {

		externalIndividual.setCapwebctIndividual(capwebctIndividual);
		objectDAO.create(externalIndividual);
		return externalIndividual;
	}

    public void bindIndividuals(ExternalFamilyAccount efa, String externalIndividualId,
            CapwebctFamilyAccount cfa, long cfaId)
        throws DataAccessException {
        
        // ensure given external family account and CapWebCT family account
        // are well linked
        if (efa.getCapwebctFamilyAccount().getCapwebctFamilyAccountId() !=
            cfa.getCapwebctFamilyAccountId()) {
            log.error("bindIndividuals() external family account " 
                    + efa.getExternalFamilyAccountId() + " is not tied to CapWebCT account "
                    + cfa.getCapwebctFamilyAccountId());
            // TODO : throw a business exception    
            return;
        }

        // ensure given CapWebCT individual id belongs to the given
        // CapWebCT family account
        CapwebctIndividual capwebctIndividual = null;
        for (CapwebctIndividual tempIndividual : cfa.getIndividuals()) {
            if (tempIndividual.getCapwebctIndividualId() == cfaId) {
                capwebctIndividual = tempIndividual;
                break;
            }
        }
        if (capwebctIndividual == null) {
            log.error("bindIndividuals() CapWebCT individual does not belong to account " 
                    + cfa.getCapwebctFamilyAccountId());
            // TODO : throw a business exception
            return;
        }

        // no external individual provided : it's an unlinking operation
        if (externalIndividualId == null || externalIndividualId.equals("")) {
            for (ExternalIndividual tempIndividual : efa.getIndividuals()) {
                if (tempIndividual.getCapwebctIndividual() != null
                        && tempIndividual.getCapwebctIndividual().getCapwebctIndividualId() == cfaId) {
                    tempIndividual.setCapwebctIndividual(null);
                    externalFamilyAccountDAO.update(efa);
                }
            }
            return;
        }
        
        ExternalIndividual externalIndividual = null;
        for (ExternalIndividual tempIndividual : efa.getIndividuals()) {
            if (tempIndividual.getExternalIndividualId().equals(externalIndividualId)) {
                externalIndividual = tempIndividual;
            } else if (tempIndividual.getCapwebctIndividual() != null 
                    && tempIndividual.getCapwebctIndividual().getCapwebctIndividualId() == cfaId) {
                // another external individual was linked to the given CapWebCT individual
                // unlink it
                tempIndividual.setCapwebctIndividual(null);
            }
        }
        if (externalIndividual == null) {
            log.debug("bindIndividuals() creating external individual : " 
                    + externalIndividualId);
            externalIndividual = new ExternalIndividual();
            externalIndividual.setExternalIndividualId(externalIndividualId);
            efa.addIndividual(externalIndividual);
        }
        
        externalIndividual.setCapwebctIndividual(capwebctIndividual);
        externalFamilyAccountDAO.update(efa);
    }

    private void setCapwebctAssocationState(CapwebctFamilyAccount cfa, 
            long externalApplicationId, String newState) {

        CapwebctAssociationSummary cas = null;
        for (CapwebctAssociationSummary currentCas : cfa.getAssociationsSummary()) {
            if (currentCas.getExternalApplicationId() == externalApplicationId) {
                cas = currentCas;
                break;
            }
        }
        if (cas == null) {
            cas = new CapwebctAssociationSummary();
            cas.setExternalApplicationId(externalApplicationId);
            cfa.getAssociationsSummary().add(cas);
        }
        cas.setState(newState);
        capwebctFamilyAccountDAO.update(cfa);
    }
    
    public void unbindFamilyAccount(String externalFamilyAccountId, 
            long externalApplicationId) throws DataAccessException {
        
        ExternalFamilyAccount externalFamilyAccount =
            externalFamilyAccountDAO.getByExternalFamilyAccount(externalFamilyAccountId, 
                    externalApplicationId);
        if (externalFamilyAccount == null)
            return;
        
        setCapwebctAssocationState(externalFamilyAccount.getCapwebctFamilyAccount(), 
                externalApplicationId, "not_associated");

        for (ExternalIndividual externalIndividual : externalFamilyAccount.getIndividuals()) {
            externalIndividual.setCapwebctIndividual(null);
        }
        externalFamilyAccount.setCapwebctFamilyAccount(null);
        externalFamilyAccountDAO.update(externalFamilyAccount);
    }

    public void hideFamilyAccount(long cfaId, long externalApplicationId) 
        throws DataAccessException {

        CapwebctFamilyAccount cfa = getCfaByCapwebctId(cfaId);

        // remove eventual association on external family account
        ExternalFamilyAccount efa = 
            externalFamilyAccountDAO.getByCfaAndExternalApplication(cfaId, externalApplicationId);
        if (efa != null)
            unbindFamilyAccount(efa.getExternalFamilyAccountId(), externalApplicationId);
        
        setCapwebctAssocationState(cfa, externalApplicationId, "no_meaning");
    }

    public ExternalFamilyAccount getExternalFamilyAccount(long id) throws DataAccessException {
		return externalFamilyAccountDAO.read(id);
	}

    public ExternalFamilyAccount getExternalFamilyAccount(String externalFamilyAccountId,
            long externalApplicationId) throws DataAccessException {

        if (externalFamilyAccountId == null || externalApplicationId == 0)
            return null;
        else 
            return externalFamilyAccountDAO.getByExternalFamilyAccount(externalFamilyAccountId, 
                    externalApplicationId);
    }
    
	public List<ExternalFamilyAccount> getAllExternalFamilyAccounts() throws DataAccessException {
		return externalFamilyAccountDAO.findAll(ExternalFamilyAccount.class);
	}

	public List<ExternalFamilyAccount> getByCapWebctFamilyAccountId(long capwebctFamilyAccountId)
			throws DataAccessException {
		return externalFamilyAccountDAO.getByCfa(capwebctFamilyAccountId);
	}

    public List<ExternalFamilyAccount> getByExternalApplication(long externalApplicationId) 
        throws DataAccessException {
        return externalFamilyAccountDAO.getByExternalApplication(externalApplicationId);
    }

    public List<ExternalFamilyAccountSearchResult> searchExternalFamilyAccount(String externalFamilyAccountId,
			String externalResponsibleLastName, long externalApplicationId,
			long capwebctFamilyAccountId, String capwebctIndividualLastName, 
            int results, int startIndex, String sort, String dir) 
            throws DataAccessException {
		return externalFamilyAccountDAO.search(externalFamilyAccountId, externalResponsibleLastName,
				externalApplicationId, capwebctFamilyAccountId, capwebctIndividualLastName,
                results, startIndex, sort, dir);
	}

    public Long getCountForSearchExternalFamilyAccount(String externalFamilyAccountId,
            String externalResponsibleLastName, long externalApplicationId,
            long capwebctFamilyAccountId, String capwebctIndividualLastName)
        throws DataAccessException {
        return externalFamilyAccountDAO.countForSearch(externalFamilyAccountId, externalResponsibleLastName,
                externalApplicationId, capwebctFamilyAccountId, capwebctIndividualLastName);
    }
    
	public List<ExternalFamilyAccount> searchForAutocomplete(final String externalResponsibleLastName,
            long externalApplicationId)
        throws DataAccessException {
        return externalFamilyAccountDAO.searchForAutocomplete(externalResponsibleLastName, 
                externalApplicationId);
    }

	public List<ExternalFamilyAccount> getAssociatedAccounts(final long externalApplicationId, 
            String cfaResponsible, final int results, final int startIndex, 
            final String sort, final String dir)
        throws DataAccessException {
        return externalFamilyAccountDAO.getAssociatedAccounts(externalApplicationId, 
                cfaResponsible, results, startIndex, sort, dir);
    }

	public Long getCountForAssociatedAccounts(final long externalApplicationId, 
            final String cfaResponsible)
        throws DataAccessException {
        return externalFamilyAccountDAO.getCountForAssociatedAccounts(externalApplicationId, 
                cfaResponsible);
	}

    public long[] importCapwebctFamilyAccounts(List<CapwebctFamilyAccount> capWebctFamilyAccounts) {
        
        long[] results = new long[2];

        long createdAccountsNb = 0;
        long modifiedAccountsNb = 0;
        for (CapwebctFamilyAccount capwebctFamilyAccount : capWebctFamilyAccounts) {
            CapwebctFamilyAccount currentAccount = 
                getCfaByCapwebctId(capwebctFamilyAccount.getCapwebctFamilyAccountId());
            if (currentAccount == null) {
                createCapwebctFamilyAccount(capwebctFamilyAccount);
                createdAccountsNb++;
            } else {
                boolean modifiedAccount = false;
                if (!capwebctFamilyAccount.getAddress().equals(currentAccount.getAddress())) {
                    currentAccount.setAddress(capwebctFamilyAccount.getAddress());
                    modifiedAccount = true;
                }
                
                for (CapwebctIndividual capwebctIndividual : capwebctFamilyAccount.getIndividuals()) {
                    if (!currentAccount.contains(capwebctIndividual.getCapwebctIndividualId())) {
                        currentAccount.addIndividual(capwebctIndividual);
                        modifiedAccount = true;
                    }
                }
                 
                if (modifiedAccount) {
                    modifyCapwebctFamilyAccount(currentAccount);
                    modifiedAccountsNb++;
                }
            }
        }
        
        results[0] = createdAccountsNb;
        results[1] = modifiedAccountsNb;
        
        return results;
    }
    
	public CapwebctFamilyAccount createCapwebctFamilyAccount(long cfaId,
			String cfaResponsibleLastName, String cfaResponsibleFirstName) 
        throws DataAccessException {

		CapwebctFamilyAccount capwebctFamilyAccount = new CapwebctFamilyAccount();
		capwebctFamilyAccount.setCapwebctFamilyAccountId(cfaId);

        CapwebctIndividual capwebctIndividual = new CapwebctIndividual();
        capwebctIndividual.setFirstName(cfaResponsibleFirstName);
        capwebctIndividual.setLastName(cfaResponsibleLastName);
        capwebctIndividual.setResponsible(true);
        capwebctFamilyAccount.addIndividual(capwebctIndividual);

		capwebctFamilyAccountDAO.create(capwebctFamilyAccount);

		return capwebctFamilyAccount;
	}

    public CapwebctFamilyAccount createCapwebctFamilyAccount(CapwebctFamilyAccount cfa)
        throws DataAccessException {
        
        List<ExternalApplication> externalApplications = externalApplicationDAO.findAll();
        for (ExternalApplication externalApplication : externalApplications) {
            CapwebctAssociationSummary cas = new CapwebctAssociationSummary();
            cas.setExternalApplicationId(externalApplication.getId());
            cas.setState("not_associated");
            if (cfa.getAssociationsSummary() == null)
                cfa.setAssociationsSummary(new HashSet<CapwebctAssociationSummary>());
            cfa.getAssociationsSummary().add(cas);
        }
        capwebctFamilyAccountDAO.create(cfa);
        return cfa;
    }

    public CapwebctFamilyAccount getCfaById(long id) throws DataAccessException {
		return capwebctFamilyAccountDAO.read(id);
	}

    public CapwebctFamilyAccount getCfaByCapwebctId(long capwebctFamilyAccountId) 
        throws DataAccessException {
        if (capwebctFamilyAccountId != 0)
            return capwebctFamilyAccountDAO.getByCfaId(capwebctFamilyAccountId);
        else
            return null;
    }

	public CapwebctFamilyAccount modifyCapwebctFamilyAccount(
			CapwebctFamilyAccount capwebctFamilyAccount) throws DataAccessException {
		capwebctFamilyAccountDAO.update(capwebctFamilyAccount);
		return capwebctFamilyAccount;
	}

	// TODO tests if CapwebctFamilyAccount has a responsible ?
	public CapwebctFamilyAccount addCapwebctIndividual(CapwebctFamilyAccount capwebctFamilyAccount,
			CapwebctIndividual individual) throws DataAccessException {

		capwebctFamilyAccount.addIndividual(individual);
		capwebctFamilyAccountDAO.create(capwebctFamilyAccount);
		return capwebctFamilyAccount;
	}

	public CapwebctFamilyAccount removeCapwebctIndividual(
			CapwebctFamilyAccount capwebctFamilyAccount, CapwebctIndividual individual)
			throws DataAccessException {

		CapwebctFamilyAccount toUpdateAccount = capwebctFamilyAccountDAO.read(capwebctFamilyAccount.getId());
		toUpdateAccount.removeIndividual(individual);
		capwebctFamilyAccountDAO.update(toUpdateAccount);
		return toUpdateAccount;
	}

    public List<CapwebctFamilyAccount> getForStateAndExternalApplication(final String state,
            final long externalApplicationId, String cfaResponsible, final int results,
            final int startIndex, final String sort, final String dir) 
        throws DataAccessException {
        return capwebctFamilyAccountDAO.getForStateAndExternalApplication(state, 
                externalApplicationId, cfaResponsible, results, startIndex, sort, dir);
    }

    public Long getCountForStateAndExternalApplication(final String state, 
            final long externalApplicationId, String cfaResponsible)
        throws DataAccessException {
        return capwebctFamilyAccountDAO.getCountForStateAndExternalApplication(state, 
                externalApplicationId, cfaResponsible);
    }

    public List<CapwebctFamilyAccount> getAllCapwebctFamilyAccounts() throws DataAccessException {
		return capwebctFamilyAccountDAO.findAll();
	}

	public List<CapwebctFamilyAccount> searchCapwebctFamilyAccount(long capwebctFamilyAccountId,
			String capwebctIndividualLastName, int results, int startIndex, String sort, String dir) 
            throws DataAccessException {

 		return capwebctFamilyAccountDAO.search(capwebctFamilyAccountId, capwebctIndividualLastName,
                results, startIndex, sort, dir);
	}

	public Long getCountForSearchCapwebctFamilyAccount(long capwebctFamilyAccountId,
            String capwebctIndividualLastName) throws DataAccessException {
        return capwebctFamilyAccountDAO.countForSearch(capwebctFamilyAccountId, capwebctIndividualLastName);       
    }

	public void deleteExternalFamilyAccount(ExternalFamilyAccount externalFamilyAccount)
			throws DataAccessException {
	    externalFamilyAccountDAO.delete(externalFamilyAccount);
	}

	public void deleteCapwebctFamilyAccount(CapwebctFamilyAccount capwebctFamilyAccount)
			throws DataAccessException {
		capwebctFamilyAccountDAO.delete(capwebctFamilyAccount);
	}

	public void setExternalFamilyAccountDAO(IExternalFamilyAccountDAO externalFamilyAccountDAO) {
		this.externalFamilyAccountDAO = externalFamilyAccountDAO;
	}

	public void setCapwebctFamilyAccountDAO(ICapwebctFamilyAccountDAO capwebctFamilyAccountDAO) {
		this.capwebctFamilyAccountDAO = capwebctFamilyAccountDAO;
	}

	public void setObjectDAO(IObjectDAO objectDAO) {
		this.objectDAO = objectDAO;
	}

    public void setExternalApplicationDAO(IExternalApplicationDAO externalApplicationDAO) {
        this.externalApplicationDAO = externalApplicationDAO;
    }
}
