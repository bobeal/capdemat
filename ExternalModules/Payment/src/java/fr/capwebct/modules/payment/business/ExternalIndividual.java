package fr.capwebct.modules.payment.business;

public class ExternalIndividual {

	private long id;
	
	private String externalIndividualId;
	private String lastName;
	private String firstName;
    private boolean responsible;
	
	private CapwebctIndividual capwebctIndividual;

	public ExternalIndividual() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExternalIndividualId() {
		return externalIndividualId;
	}

	public void setExternalIndividualId(String externalIndividualId) {
		this.externalIndividualId = externalIndividualId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public CapwebctIndividual getCapwebctIndividual() {
		return capwebctIndividual;
	}

	public void setCapwebctIndividual(CapwebctIndividual capwebctIndividual) {
		this.capwebctIndividual = capwebctIndividual;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof ExternalIndividual))
			return false;
		ExternalIndividual externalIndividual = (ExternalIndividual) object;
        if (this.id == 0 && externalIndividual.id == 0)
            return (this.externalIndividualId.equals(externalIndividual.externalIndividualId));
        else
            return this.id == externalIndividual.id;
	}

	@Override
	public int hashCode() {
		return (new Long(this.id)).hashCode();
	}
}
