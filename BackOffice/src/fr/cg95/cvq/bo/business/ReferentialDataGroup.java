package fr.cg95.cvq.bo.business;

import fr.cg95.cvq.business.authority.LocalReferentialType;

public class ReferentialDataGroup {

    private LocalReferentialType data = null;
	private String name = "";
	private String label = "";

	public ReferentialDataGroup() {
		super();
	}

	public ReferentialDataGroup(LocalReferentialType data, String name, String label) {
	    this.data = data;
        this.name = name;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public LocalReferentialType getData() {
        return data;
    }

    public void setData(LocalReferentialType data) {
        this.data = data;
    }

}
