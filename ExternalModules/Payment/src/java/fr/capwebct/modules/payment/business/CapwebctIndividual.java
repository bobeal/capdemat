package fr.capwebct.modules.payment.business;

public class CapwebctIndividual {

	private long id;
    private long capwebctIndividualId;
	private String lastName;
	private String firstName;
	private boolean child;
	private boolean responsible;

	public CapwebctIndividual() {
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

	public long getCapwebctIndividualId() {
        return capwebctIndividualId;
    }

    public void setCapwebctIndividualId(long capwebctIndividualId) {
        this.capwebctIndividualId = capwebctIndividualId;
    }

    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isChild() {
		return child;
	}

	public void setChild(boolean child) {
		this.child = child;
	}

	public boolean isResponsible() {
		return responsible;
	}

	public void setResponsible(boolean responsible) {
		this.responsible = responsible;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof CapwebctIndividual))
			return false;
		CapwebctIndividual capwebctIndividual = (CapwebctIndividual) object;
		return this.capwebctIndividualId == capwebctIndividual.capwebctIndividualId;
	}

	@Override
	public int hashCode() {
		return (new Long(this.id)).hashCode();
	}
}
