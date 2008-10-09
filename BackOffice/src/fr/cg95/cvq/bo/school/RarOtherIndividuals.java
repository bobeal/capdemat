package fr.cg95.cvq.bo.school;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.school.*;

public class RarOtherIndividuals extends RequestRecord {

	private String otherIndividualOfficePhone;
	private String otherIndividualFirstName;
	private String otherIndividualHomePhone;
	private String otherIndividualAddress;
	private String otherIndividualLastName;
	private String otherIndividualType;

	public RarOtherIndividuals() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		RarOtherIndividuals clonedRecord = (RarOtherIndividuals)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(OtherIndividual request) {
    	if (request != null) {

			this.otherIndividualOfficePhone = request.getOfficePhone();
			this.otherIndividualFirstName = request.getFirstName();
			this.otherIndividualHomePhone = request.getHomePhone();
			this.otherIndividualAddress = request.getAddress();
			this.otherIndividualLastName = request.getLastName();
			if (request.getType() != null)
                this.otherIndividualType = getEnumElementTranslation(
                        fr.cg95.cvq.xml.school.OtherIndividualType.class.getName(), 
                        "Type", request.getType().toString());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RecreationActivityRegistrationRequest)) {
            RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RecreationActivityRegistrationRequest)) {
            RecreationActivityRegistrationRequest request = (RecreationActivityRegistrationRequest)xmlRequest; 

        }
    }
    
	public void setOtherIndividualOfficePhone(String otherIndividualOfficePhone) {
		this.otherIndividualOfficePhone = otherIndividualOfficePhone;
	}
	
	public String getOtherIndividualOfficePhone() {
		return this.otherIndividualOfficePhone;
	}

	public void setOtherIndividualFirstName(String otherIndividualFirstName) {
		this.otherIndividualFirstName = otherIndividualFirstName;
	}
	
	public String getOtherIndividualFirstName() {
		return this.otherIndividualFirstName;
	}

	public void setOtherIndividualHomePhone(String otherIndividualHomePhone) {
		this.otherIndividualHomePhone = otherIndividualHomePhone;
	}
	
	public String getOtherIndividualHomePhone() {
		return this.otherIndividualHomePhone;
	}

	public void setOtherIndividualAddress(String otherIndividualAddress) {
		this.otherIndividualAddress = otherIndividualAddress;
	}
	
	public String getOtherIndividualAddress() {
		return this.otherIndividualAddress;
	}

	public void setOtherIndividualLastName(String otherIndividualLastName) {
		this.otherIndividualLastName = otherIndividualLastName;
	}
	
	public String getOtherIndividualLastName() {
		return this.otherIndividualLastName;
	}

	public void setOtherIndividualType(String otherIndividualType) {
		this.otherIndividualType = otherIndividualType;
	}
	
	public String getOtherIndividualType() {
		return this.otherIndividualType;
	}

}

