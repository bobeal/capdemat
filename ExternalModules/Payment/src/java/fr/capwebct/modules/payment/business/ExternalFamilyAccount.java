package fr.capwebct.modules.payment.business;

import java.util.HashSet;
import java.util.Set;

public class ExternalFamilyAccount {

	private long id;
	
	private CapwebctFamilyAccount capwebctFamilyAccount;
    
	private String externalFamilyAccountId;
    private ExternalApplication externalApplication;
    private String address;
	private Set<ExternalIndividual> individuals;

    private Set<Invoice> invoices;
    private Set<Account> accounts;
    private Set<Contract> contracts;
    
	public ExternalFamilyAccount() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CapwebctFamilyAccount getCapwebctFamilyAccount() {
		return capwebctFamilyAccount;
	}

	public void setCapwebctFamilyAccount(CapwebctFamilyAccount capwebctFamilyAccount) {
		this.capwebctFamilyAccount = capwebctFamilyAccount;
	}
	
	public String getExternalFamilyAccountId() {
		return externalFamilyAccountId;
	}

	public void setExternalFamilyAccountId(String externalFamilyAccountId) {
		this.externalFamilyAccountId = externalFamilyAccountId;
	}

    public ExternalApplication getExternalApplication() {
        return externalApplication;
    }

    public void setExternalApplication(ExternalApplication externalApplication) {
        this.externalApplication = externalApplication;
    }

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExternalFamilyAccountResponsible() {
        String responsible = "";

        if (individuals == null)
            return responsible;
        
        for (ExternalIndividual individual : individuals) {
            if (individual.isResponsible()) {
                if (individual.getLastName() != null && individual.getLastName().length() > 0) {
                    responsible = individual.getLastName();
                }
                if (individual.getFirstName() != null && individual.getFirstName().length() > 0)
                    responsible += " " + individual.getFirstName();
                // There is only one responsible per account
                break;
            }
        }
        
        return responsible;
    }

    public Set<ExternalIndividual> getIndividuals() {
		return individuals;
	}

	public void setIndividuals(Set<ExternalIndividual> individuals) {
		this.individuals = individuals;
	}
	
	public void addIndividual(ExternalIndividual individual) {
		if (individuals == null )
			individuals = new HashSet<ExternalIndividual>();
		if (individual != null)
			individuals.add(individual);
	}
	
    public boolean removeIndividual(ExternalIndividual individual) {
        if (individual == null || individuals == null)
            return false;
        return individuals.remove(individual);
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void addInvoice(Invoice invoice) {
        if (invoices == null)
            invoices = new HashSet<Invoice>();
        if (invoice != null)
            invoices.add(invoice);
    }
    
    public boolean removeInvoice(Invoice invoice) {
        if (invoice == null || invoices == null)
            return false;
        else
            return invoices.remove(invoice);
    }
    
    public Set<Account> getAccounts() {
        return accounts;
    }
    
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        if (accounts == null)
            accounts = new HashSet<Account>();
        if (account != null) 
            accounts.add(account);
    }
    
    public boolean removeAccount(Account account) {
        if (account == null || accounts == null)
            return false;
        else
            return accounts.remove(account);
    }
    
    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public boolean hasContracts() {
        return (contracts != null && contracts.size() > 0);
    }
    
    public void addContract(Contract contract) {
        if (contracts == null)
            contracts = new HashSet<Contract>();
        if (contract != null)
            contracts.add(contract);
    }
    
    public boolean removeContract(Contract contract) {
        if (contract == null || contracts == null)
            return false;
        else
            return contracts.remove(contract);
    }

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof ExternalFamilyAccount))
			return false;
		ExternalFamilyAccount efa = (ExternalFamilyAccount) object;
        return (this.externalApplication.getLabel().equals(efa.getExternalApplication().getLabel())
                && (this.externalFamilyAccountId.equals(efa.getExternalFamilyAccountId())));
	}

	@Override
	public int hashCode() {
		return (new Long(this.id)).hashCode();
	}
}
