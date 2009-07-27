package fr.capwebct.modules.payment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.dao.IExternalApplicationDAO;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;

public class ExternalApplicationService implements IExternalApplicationService {

    private IExternalApplicationDAO externalApplicationDAO;
    
    private IFamilyAccountService familyAccountService;
    
    public ExternalApplication getById(long id) {
        return externalApplicationDAO.read(ExternalApplication.class, id);
    }

    public List<ExternalApplication> getAll() {
        return externalApplicationDAO.findAll();
    }

    public ExternalApplication create(final String label, final String description,
            final Set<String> brokers) throws CpmBusinessException {

        ExternalApplication externalApplication = new ExternalApplication();
        externalApplication.setLabel(label);
        externalApplication.setDescription(description);
        externalApplication.setBrokers(brokers);
    
        create(externalApplication);
        
        return externalApplication;
    }

    public void create(ExternalApplication externalApplication)  throws CpmBusinessException {

        if (externalApplicationDAO.findByLabel(externalApplication.getLabel()) != null)
            throw new CpmBusinessException("error.label_already_exists");
        
        externalApplicationDAO.create(externalApplication);
        familyAccountService.initializeCfaAssociations(externalApplication.getId());
    }

    public void update(final long id, final String newLabel, final String newDescription,
            final Set<String> newBrokers)  throws CpmBusinessException {

        ExternalApplication extAppByLabel = externalApplicationDAO.findByLabel(newLabel);
        if (extAppByLabel != null && extAppByLabel.getId() != id)
            throw new CpmBusinessException("error.label_already_exists");
        
        ExternalApplication externalApplication = 
            externalApplicationDAO.read(ExternalApplication.class, id);        
        externalApplication.setLabel(newLabel);
        externalApplication.setDescription(newDescription);
        externalApplication.setBrokers(newBrokers);
        externalApplicationDAO.update(externalApplication);
    }

    public void delete(long id) {
        
        ExternalApplication externalApplication = 
            externalApplicationDAO.read(ExternalApplication.class, id);
        
        List<ExternalFamilyAccount> familyAccounts = 
            familyAccountService.getByExternalApplication(id);
        for (ExternalFamilyAccount externalFamilyAccount : familyAccounts) {
            familyAccountService.deleteExternalFamilyAccount(externalFamilyAccount);
        }
        familyAccountService.removeCfaAssociations(id);
        externalApplicationDAO.delete(externalApplication);
    }

    public void addBroker(long externalApplicationId, String broker) {
        ExternalApplication externalApplication = 
            externalApplicationDAO.read(ExternalApplication.class, externalApplicationId);
        externalApplication.addBroker(broker);
        externalApplicationDAO.update(externalApplication);
    }

    public void removeBroker(long externalApplicationId, String broker) {
        // TODO : deal with items that have a reference on brokers
        // TODO : return status ? success/failure ?
        
        ExternalApplication externalApplication = 
            externalApplicationDAO.read(ExternalApplication.class, externalApplicationId);
        externalApplication.getBrokers().remove(broker);
        externalApplicationDAO.update(externalApplication);        
    }
    
	public List<String> getAllBrokers() {
		List<String> brokers = new ArrayList<String>();
		for (ExternalApplication externalApplication : getAll()) {
			Set<String> externalApplicationBrokers = externalApplication.getBrokers();
			for (String broker : externalApplicationBrokers) {
				if (!brokers.contains(broker))
					brokers.add(broker);
			}
		}
		
		return brokers;
	}

    public void setExternalApplicationDAO(IExternalApplicationDAO externalApplicationDAO) {
        this.externalApplicationDAO = externalApplicationDAO;
    }

    public void setFamilyAccountService(IFamilyAccountService familyAccountService) {
        this.familyAccountService = familyAccountService;
    }
}
