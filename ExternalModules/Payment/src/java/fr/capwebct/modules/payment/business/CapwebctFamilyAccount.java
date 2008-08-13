package fr.capwebct.modules.payment.business;

import java.util.HashSet;
import java.util.Set;

public class CapwebctFamilyAccount {

	private long id;
    
	private long capwebctFamilyAccountId;
    private String address;
    private String responsibleFullName;

    private Set<CapwebctIndividual> individuals;
	
    private Set<CapwebctAssociationSummary> associationsSummary;
	
	public long getCapwebctFamilyAccountId() {
		return capwebctFamilyAccountId;
	}

	public void setCapwebctFamilyAccountId(long capwebctFamilyAccountId) {
		this.capwebctFamilyAccountId = capwebctFamilyAccountId;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResponsibleFullName() {
        return responsibleFullName;
    }

    public void setResponsibleFullName(String responsibleFullName) {
        this.responsibleFullName = responsibleFullName;
    }

	public boolean contains(long capwebctIndividualId) {
	    
        for (CapwebctIndividual individual : individuals) {
            if (individual.getCapwebctIndividualId() == capwebctIndividualId)
                return true;
        }

        return false;
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<CapwebctIndividual> getIndividuals() {
		return individuals;
	}

	public void setIndividuals(Set<CapwebctIndividual> individuals) {
		this.individuals = individuals;
	}

	public void addIndividual(CapwebctIndividual individual) {
		if (individuals == null )
			individuals = new HashSet<CapwebctIndividual>();
		if (individual != null)
			individuals.add(individual);
	}
	
	public boolean removeIndividual(CapwebctIndividual individual){
		if (individual == null)
			return false;
		return individuals.remove(individual);
	}
	
    public Set<CapwebctAssociationSummary> getAssociationsSummary() {
        return associationsSummary;
    }

    public void setAssociationsSummary(Set<CapwebctAssociationSummary> associationsSummary) {
        this.associationsSummary = associationsSummary;
    }

    @Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof CapwebctFamilyAccount))
			return false;
		CapwebctFamilyAccount capwebctFamilyAccount = (CapwebctFamilyAccount) object;
		return this.id == capwebctFamilyAccount.id;
	}

	@Override
	public int hashCode() {
		return (new Long(this.id)).hashCode();
	}
}
