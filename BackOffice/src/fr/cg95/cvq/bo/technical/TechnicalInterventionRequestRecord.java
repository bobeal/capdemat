package fr.cg95.cvq.bo.technical;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.technical.*;

public class TechnicalInterventionRequestRecord extends RequestRecord {

	private String subjectAdultLastName;
	private String interventionDescription;
	private String subjectAdultHomePhone;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String subjectAdultMobilePhone;
  	private String interventionPlaceAdditionalDeliveryInformation;
	private String interventionPlaceAdditionalGeographicalInformation;
	private String interventionPlaceStreetNumber;
	private String interventionPlaceStreetName;
	private String interventionPlacePlaceNameOrService;
	private String interventionPlacePostalCode;
	private String interventionPlaceCity;
	private String subjectAdultEmail;
	private String subjectAdultFirstName;
	private boolean[] interventionType;
   	private List interventionTypeList;

	public TechnicalInterventionRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		TechnicalInterventionRequestRecord clonedRecord = (TechnicalInterventionRequestRecord)super.clone();
		clonedRecord.interventionType = (boolean[])this.interventionType.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof TechnicalInterventionRequest)) {
            TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlRequest; 

			this.subjectAdultLastName = ((Adult)request.getSubject()).getLastName();
			this.interventionDescription = request.getInterventionDescription();
			this.subjectAdultHomePhone = ((Adult)request.getSubject()).getHomePhone();
			if (((Adult)request.getSubject()).getAdress() != null) {
				this.subjectAdultAddressAdditionalDeliveryInformation = ((Adult)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectAdultAddressAdditionalGeographicalInformation = ((Adult)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectAdultAddressStreetNumber = ((Adult)request.getSubject()).getAdress().getStreetNumber();
				this.subjectAdultAddressStreetName = ((Adult)request.getSubject()).getAdress().getStreetName();
				this.subjectAdultAddressPlaceNameOrService = ((Adult)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectAdultAddressPostalCode = ((Adult)request.getSubject()).getAdress().getPostalCode();
				this.subjectAdultAddressCity = ((Adult)request.getSubject()).getAdress().getCity();
			}
			this.subjectAdultMobilePhone = ((Adult)request.getSubject()).getMobilePhone();
			if (request.getInterventionPlace() != null) {
				this.interventionPlaceAdditionalDeliveryInformation = request.getInterventionPlace().getAdditionalDeliveryInformation();
				this.interventionPlaceAdditionalGeographicalInformation = request.getInterventionPlace().getAdditionalGeographicalInformation();
				this.interventionPlaceStreetNumber = request.getInterventionPlace().getStreetNumber();
				this.interventionPlaceStreetName = request.getInterventionPlace().getStreetName();
				this.interventionPlacePlaceNameOrService = request.getInterventionPlace().getPlaceNameOrService();
				this.interventionPlacePostalCode = request.getInterventionPlace().getPostalCode();
				this.interventionPlaceCity = request.getInterventionPlace().getCity();
			}
			this.subjectAdultEmail = ((Adult)request.getSubject()).getEmail();
			this.subjectAdultFirstName = ((Adult)request.getSubject()).getFirstName();
            this.setInterventionType(this.getList("InterventionType"), request.getInterventionType());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof TechnicalInterventionRequest)) {
            TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof TechnicalInterventionRequest)) {
            TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlRequest; 

  			if (request.getInterventionPlace() != null) {
				request.getInterventionPlace().setAdditionalDeliveryInformation(this.interventionPlaceAdditionalDeliveryInformation);
				request.getInterventionPlace().setAdditionalGeographicalInformation(this.interventionPlaceAdditionalGeographicalInformation);
				request.getInterventionPlace().setStreetNumber(this.interventionPlaceStreetNumber);
				request.getInterventionPlace().setStreetName(this.interventionPlaceStreetName);
				request.getInterventionPlace().setPlaceNameOrService(this.interventionPlacePlaceNameOrService);
				request.getInterventionPlace().setPostalCode(this.interventionPlacePostalCode);
				request.getInterventionPlace().setCity(this.interventionPlaceCity);
			}
			request.setInterventionType(this.getInterventionTypeKeys());
        }
    }
    
	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}

	public void setInterventionDescription(String interventionDescription) {
		this.interventionDescription = interventionDescription;
	}
	
	public String getInterventionDescription() {
		return this.interventionDescription;
	}

	public void setSubjectAdultHomePhone(String subjectAdultHomePhone) {
		this.subjectAdultHomePhone = subjectAdultHomePhone;
	}
	
	public String getSubjectAdultHomePhone() {
		return this.subjectAdultHomePhone;
	}

	public void setSubjectAdultAddressAdditionalDeliveryInformation(String subjectAdultAddressAdditionalDeliveryInformation) {
		this.subjectAdultAddressAdditionalDeliveryInformation = subjectAdultAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectAdultAddressAdditionalDeliveryInformation() {
		return this.subjectAdultAddressAdditionalDeliveryInformation;
	}

	public void setSubjectAdultAddressAdditionalGeographicalInformation(String subjectAdultAddressAdditionalGeographicalInformation) {
		this.subjectAdultAddressAdditionalGeographicalInformation = subjectAdultAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectAdultAddressAdditionalGeographicalInformation() {
		return this.subjectAdultAddressAdditionalGeographicalInformation;
	}

	public void setSubjectAdultAddressStreetNumber(String subjectAdultAddressStreetNumber) {
		this.subjectAdultAddressStreetNumber = subjectAdultAddressStreetNumber;
	}
	
	public String getSubjectAdultAddressStreetNumber() {
		return this.subjectAdultAddressStreetNumber;
	}

	public void setSubjectAdultAddressStreetName(String subjectAdultAddressStreetName) {
		this.subjectAdultAddressStreetName = subjectAdultAddressStreetName;
	}
	
	public String getSubjectAdultAddressStreetName() {
		return this.subjectAdultAddressStreetName;
	}

	public void setSubjectAdultAddressPlaceNameOrService(String subjectAdultAddressPlaceNameOrService) {
		this.subjectAdultAddressPlaceNameOrService = subjectAdultAddressPlaceNameOrService;
	}
	
	public String getSubjectAdultAddressPlaceNameOrService() {
		return this.subjectAdultAddressPlaceNameOrService;
	}

	public void setSubjectAdultAddressPostalCode(String subjectAdultAddressPostalCode) {
		this.subjectAdultAddressPostalCode = subjectAdultAddressPostalCode;
	}
	
	public String getSubjectAdultAddressPostalCode() {
		return this.subjectAdultAddressPostalCode;
	}

	public void setSubjectAdultAddressCity(String subjectAdultAddressCity) {
		this.subjectAdultAddressCity = subjectAdultAddressCity;
	}
	
	public String getSubjectAdultAddressCity() {
		return this.subjectAdultAddressCity;
	}

	public void setSubjectAdultMobilePhone(String subjectAdultMobilePhone) {
		this.subjectAdultMobilePhone = subjectAdultMobilePhone;
	}
	
	public String getSubjectAdultMobilePhone() {
		return this.subjectAdultMobilePhone;
	}

	public void setInterventionPlaceAdditionalDeliveryInformation(String interventionPlaceAdditionalDeliveryInformation) {
		this.interventionPlaceAdditionalDeliveryInformation = interventionPlaceAdditionalDeliveryInformation;
	}
	
	public String getInterventionPlaceAdditionalDeliveryInformation() {
		return this.interventionPlaceAdditionalDeliveryInformation;
	}

	public void setInterventionPlaceAdditionalGeographicalInformation(String interventionPlaceAdditionalGeographicalInformation) {
		this.interventionPlaceAdditionalGeographicalInformation = interventionPlaceAdditionalGeographicalInformation;
	}
	
	public String getInterventionPlaceAdditionalGeographicalInformation() {
		return this.interventionPlaceAdditionalGeographicalInformation;
	}

	public void setInterventionPlaceStreetNumber(String interventionPlaceStreetNumber) {
		this.interventionPlaceStreetNumber = interventionPlaceStreetNumber;
	}
	
	public String getInterventionPlaceStreetNumber() {
		return this.interventionPlaceStreetNumber;
	}

	public void setInterventionPlaceStreetName(String interventionPlaceStreetName) {
		this.interventionPlaceStreetName = interventionPlaceStreetName;
	}
	
	public String getInterventionPlaceStreetName() {
		return this.interventionPlaceStreetName;
	}

	public void setInterventionPlacePlaceNameOrService(String interventionPlacePlaceNameOrService) {
		this.interventionPlacePlaceNameOrService = interventionPlacePlaceNameOrService;
	}
	
	public String getInterventionPlacePlaceNameOrService() {
		return this.interventionPlacePlaceNameOrService;
	}

	public void setInterventionPlacePostalCode(String interventionPlacePostalCode) {
		this.interventionPlacePostalCode = interventionPlacePostalCode;
	}
	
	public String getInterventionPlacePostalCode() {
		return this.interventionPlacePostalCode;
	}

	public void setInterventionPlaceCity(String interventionPlaceCity) {
		this.interventionPlaceCity = interventionPlaceCity;
	}
	
	public String getInterventionPlaceCity() {
		return this.interventionPlaceCity;
	}

	public void setSubjectAdultEmail(String subjectAdultEmail) {
		this.subjectAdultEmail = subjectAdultEmail;
	}
	
	public String getSubjectAdultEmail() {
		return this.subjectAdultEmail;
	}

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}

	public void setInterventionType(List referential, Set values) {
		if (referential != null) {
			this.interventionType = new boolean[referential.size()];
			this.interventionTypeList = referential;
			
			if (values != null) {
				for (int i = 0; i < interventionType.length; i++) {
					String key = ((ReferentialData)interventionTypeList.get(i)).getKey();
					interventionType[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getInterventionTypeList() {
		return this.interventionTypeList;
	}
	
	public Set getInterventionTypeKeys() {
		return getRefDataSet(interventionType, interventionTypeList);
	}

	public String[] getInterventionType() {
		Vector values = new Vector();
		
		for (int i = 0; i < interventionType.length; i++) {
			if (interventionType[i]) {
				values.add(((ReferentialData)interventionTypeList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setInterventionType(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < interventionType.length; i++) {
			interventionType[i] = values.indexOf("<" + ((ReferentialData)interventionTypeList.get(i)).getValue() + ">") != -1;
		}
	}
}

