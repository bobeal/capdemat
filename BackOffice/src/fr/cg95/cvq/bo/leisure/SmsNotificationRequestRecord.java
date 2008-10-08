package fr.cg95.cvq.bo.leisure;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.leisure.*;

public class SmsNotificationRequestRecord extends RequestRecord {

	private String subjectAdultLastName;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String cleverSmsContactId;
	private boolean subscription;
	private String subjectAdultMobilePhone;
	private boolean[] interests;
   	private List interestsList;
	private String subjectAdultFirstName;

	public SmsNotificationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		SmsNotificationRequestRecord clonedRecord = (SmsNotificationRequestRecord)super.clone();
		clonedRecord.interests = (boolean[])this.interests.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SmsNotificationRequest)) {
            SmsNotificationRequest request = (SmsNotificationRequest)xmlRequest; 

			this.subjectAdultLastName = ((Adult)request.getSubject()).getLastName();
			if (((Adult)request.getSubject()).getAdress() != null) {
				this.subjectAdultAddressAdditionalDeliveryInformation = ((Adult)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectAdultAddressAdditionalGeographicalInformation = ((Adult)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectAdultAddressStreetNumber = ((Adult)request.getSubject()).getAdress().getStreetNumber();
				this.subjectAdultAddressStreetName = ((Adult)request.getSubject()).getAdress().getStreetName();
				this.subjectAdultAddressPlaceNameOrService = ((Adult)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectAdultAddressPostalCode = ((Adult)request.getSubject()).getAdress().getPostalCode();
				this.subjectAdultAddressCity = ((Adult)request.getSubject()).getAdress().getCity();
			}
			this.cleverSmsContactId = request.getCleverSmsContactId();
            if ((request.getSubscription() != null))
			this.subscription = request.getSubscription();
			this.subjectAdultMobilePhone = ((Adult)request.getSubject()).getMobilePhone();
            this.setInterests(this.getList("Interests"), request.getInterests());
			this.subjectAdultFirstName = ((Adult)request.getSubject()).getFirstName();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SmsNotificationRequest)) {
            SmsNotificationRequest request = (SmsNotificationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof SmsNotificationRequest)) {
            SmsNotificationRequest request = (SmsNotificationRequest)xmlRequest; 

        }
    }
    
	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
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

	public void setCleverSmsContactId(String cleverSmsContactId) {
		this.cleverSmsContactId = cleverSmsContactId;
	}
	
	public String getCleverSmsContactId() {
		return this.cleverSmsContactId;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}
	
	public boolean getSubscription() {
		return this.subscription;
	}

	public void setSubjectAdultMobilePhone(String subjectAdultMobilePhone) {
		this.subjectAdultMobilePhone = subjectAdultMobilePhone;
	}
	
	public String getSubjectAdultMobilePhone() {
		return this.subjectAdultMobilePhone;
	}

	public void setInterests(List referential, Set values) {
		if (referential != null) {
			this.interests = new boolean[referential.size()];
			this.interestsList = referential;
			
			if (values != null) {
				for (int i = 0; i < interests.length; i++) {
					String key = ((ReferentialData)interestsList.get(i)).getKey();
					interests[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getInterestsList() {
		return this.interestsList;
	}
	
	public Set getInterestsKeys() {
		return getRefDataSet(interests, interestsList);
	}

	public String[] getInterests() {
		Vector values = new Vector();
		
		for (int i = 0; i < interests.length; i++) {
			if (interests[i]) {
				values.add(((ReferentialData)interestsList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setInterests(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < interests.length; i++) {
			interests[i] = values.indexOf("<" + ((ReferentialData)interestsList.get(i)).getValue() + ">") != -1;
		}
	}
	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}

}

