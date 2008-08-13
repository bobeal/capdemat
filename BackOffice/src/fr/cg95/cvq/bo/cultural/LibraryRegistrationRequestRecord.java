package fr.cg95.cvq.bo.cultural;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.leisure.culture.*;

public class LibraryRegistrationRequestRecord extends RequestRecord {

	private Calendar subjectIndividualBirthDate;
	private String subjectIndividualFirstName2;
	private String subjectIndividualLastName;
	private String registrationNumber;
  	private String subjectIndividualAddressAdditionalDeliveryInformation;
	private String subjectIndividualAddressAdditionalGeographicalInformation;
	private String subjectIndividualAddressStreetNumber;
	private String subjectIndividualAddressStreetName;
	private String subjectIndividualAddressPlaceNameOrService;
	private String subjectIndividualAddressPostalCode;
	private String subjectIndividualAddressCity;
	private boolean rulesAndRegulationsAcceptance;
	private String subjectIndividualFirstName;
	private Short subscriptionPrice;
	private String subjectIndividualFirstName3;
	private boolean[] subscription;
   	private List subscriptionList;
	private String subjectIndividualSex;
	private boolean parentalAuthorization;

	public LibraryRegistrationRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		LibraryRegistrationRequestRecord clonedRecord = (LibraryRegistrationRequestRecord)super.clone();
		clonedRecord.subscription = (boolean[])this.subscription.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof LibraryRegistrationRequest)) {
            LibraryRegistrationRequest request = (LibraryRegistrationRequest)xmlRequest; 

			if (((Individual)request.getSubject()).getBirthDate() != null) {
				this.subjectIndividualBirthDate = Calendar.getInstance(); 
	            this.subjectIndividualBirthDate.setTime(((Individual)request.getSubject()).getBirthDate());
			}
			this.subjectIndividualFirstName2 = ((Individual)request.getSubject()).getFirstName2();
			this.subjectIndividualLastName = ((Individual)request.getSubject()).getLastName();
			this.registrationNumber = request.getRegistrationNumber();
			if (((Individual)request.getSubject()).getAdress() != null) {
				this.subjectIndividualAddressAdditionalDeliveryInformation = ((Individual)request.getSubject()).getAdress().getAdditionalDeliveryInformation();
				this.subjectIndividualAddressAdditionalGeographicalInformation = ((Individual)request.getSubject()).getAdress().getAdditionalGeographicalInformation();
				this.subjectIndividualAddressStreetNumber = ((Individual)request.getSubject()).getAdress().getStreetNumber();
				this.subjectIndividualAddressStreetName = ((Individual)request.getSubject()).getAdress().getStreetName();
				this.subjectIndividualAddressPlaceNameOrService = ((Individual)request.getSubject()).getAdress().getPlaceNameOrService();
				this.subjectIndividualAddressPostalCode = ((Individual)request.getSubject()).getAdress().getPostalCode();
				this.subjectIndividualAddressCity = ((Individual)request.getSubject()).getAdress().getCity();
			}
            if ((request.getRulesAndRegulationsAcceptance() != null))
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
			this.subjectIndividualFirstName = ((Individual)request.getSubject()).getFirstName();
			this.subscriptionPrice = request.getSubscriptionPrice();
			this.subjectIndividualFirstName3 = ((Individual)request.getSubject()).getFirstName3();
            this.setSubscription(this.getList("Subscription"), request.getSubscription());
            if ((request.getParentalAuthorization() != null))
			this.parentalAuthorization = request.getParentalAuthorization();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof LibraryRegistrationRequest)) {
            LibraryRegistrationRequest request = (LibraryRegistrationRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof LibraryRegistrationRequest)) {
            LibraryRegistrationRequest request = (LibraryRegistrationRequest)xmlRequest; 

			request.setRegistrationNumber(this.registrationNumber);
            if ((request.getRulesAndRegulationsAcceptance() != null))
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
			request.setSubscriptionPrice(this.subscriptionPrice);
			request.setSubscription(this.getSubscriptionKeys());
            if ((request.getParentalAuthorization() != null))
			request.setParentalAuthorization(this.parentalAuthorization);
        }
    }
    
	public void setSubjectIndividualBirthDate(Calendar subjectIndividualBirthDate) {
		this.subjectIndividualBirthDate = subjectIndividualBirthDate;
	}
	
	public Calendar getSubjectIndividualBirthDate() {
		return this.subjectIndividualBirthDate;
	}

	public void setSubjectIndividualFirstName2(String subjectIndividualFirstName2) {
		this.subjectIndividualFirstName2 = subjectIndividualFirstName2;
	}
	
	public String getSubjectIndividualFirstName2() {
		return this.subjectIndividualFirstName2;
	}

	public void setSubjectIndividualLastName(String subjectIndividualLastName) {
		this.subjectIndividualLastName = subjectIndividualLastName;
	}
	
	public String getSubjectIndividualLastName() {
		return this.subjectIndividualLastName;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setSubjectIndividualAddressAdditionalDeliveryInformation(String subjectIndividualAddressAdditionalDeliveryInformation) {
		this.subjectIndividualAddressAdditionalDeliveryInformation = subjectIndividualAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalDeliveryInformation() {
		return this.subjectIndividualAddressAdditionalDeliveryInformation;
	}

	public void setSubjectIndividualAddressAdditionalGeographicalInformation(String subjectIndividualAddressAdditionalGeographicalInformation) {
		this.subjectIndividualAddressAdditionalGeographicalInformation = subjectIndividualAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalGeographicalInformation() {
		return this.subjectIndividualAddressAdditionalGeographicalInformation;
	}

	public void setSubjectIndividualAddressStreetNumber(String subjectIndividualAddressStreetNumber) {
		this.subjectIndividualAddressStreetNumber = subjectIndividualAddressStreetNumber;
	}
	
	public String getSubjectIndividualAddressStreetNumber() {
		return this.subjectIndividualAddressStreetNumber;
	}

	public void setSubjectIndividualAddressStreetName(String subjectIndividualAddressStreetName) {
		this.subjectIndividualAddressStreetName = subjectIndividualAddressStreetName;
	}
	
	public String getSubjectIndividualAddressStreetName() {
		return this.subjectIndividualAddressStreetName;
	}

	public void setSubjectIndividualAddressPlaceNameOrService(String subjectIndividualAddressPlaceNameOrService) {
		this.subjectIndividualAddressPlaceNameOrService = subjectIndividualAddressPlaceNameOrService;
	}
	
	public String getSubjectIndividualAddressPlaceNameOrService() {
		return this.subjectIndividualAddressPlaceNameOrService;
	}

	public void setSubjectIndividualAddressPostalCode(String subjectIndividualAddressPostalCode) {
		this.subjectIndividualAddressPostalCode = subjectIndividualAddressPostalCode;
	}
	
	public String getSubjectIndividualAddressPostalCode() {
		return this.subjectIndividualAddressPostalCode;
	}

	public void setSubjectIndividualAddressCity(String subjectIndividualAddressCity) {
		this.subjectIndividualAddressCity = subjectIndividualAddressCity;
	}
	
	public String getSubjectIndividualAddressCity() {
		return this.subjectIndividualAddressCity;
	}

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}

	public void setSubjectIndividualFirstName(String subjectIndividualFirstName) {
		this.subjectIndividualFirstName = subjectIndividualFirstName;
	}
	
	public String getSubjectIndividualFirstName() {
		return this.subjectIndividualFirstName;
	}

	public void setSubscriptionPrice(Short subscriptionPrice) {
		this.subscriptionPrice = subscriptionPrice;
	}
	
	public Short getSubscriptionPrice() {
		return this.subscriptionPrice;
	}

	public void setSubjectIndividualFirstName3(String subjectIndividualFirstName3) {
		this.subjectIndividualFirstName3 = subjectIndividualFirstName3;
	}
	
	public String getSubjectIndividualFirstName3() {
		return this.subjectIndividualFirstName3;
	}

	public void setSubscription(List referential, Set values) {
		if (referential != null) {
			this.subscription = new boolean[referential.size()];
			this.subscriptionList = referential;
			
			if (values != null) {
				for (int i = 0; i < subscription.length; i++) {
					String key = ((ReferentialData)subscriptionList.get(i)).getKey();
					subscription[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getSubscriptionList() {
		return this.subscriptionList;
	}
	
	public Set getSubscriptionKeys() {
		return getRefDataSet(subscription, subscriptionList);
	}

	public String[] getSubscription() {
		Vector values = new Vector();
		
		for (int i = 0; i < subscription.length; i++) {
			if (subscription[i]) {
				values.add(((ReferentialData)subscriptionList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setSubscription(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < subscription.length; i++) {
			subscription[i] = values.indexOf("<" + ((ReferentialData)subscriptionList.get(i)).getValue() + ">") != -1;
		}
	}
	public void setSubjectIndividualSex(String subjectIndividualSex) {
		this.subjectIndividualSex = subjectIndividualSex;
	}
	
	public String getSubjectIndividualSex() {
		return this.subjectIndividualSex;
	}

	public void setParentalAuthorization(boolean parentalAuthorization) {
		this.parentalAuthorization = parentalAuthorization;
	}
	
	public boolean getParentalAuthorization() {
		return this.parentalAuthorization;
	}

}

