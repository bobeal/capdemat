package fr.cg95.cvq.bo.social;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.social.*;

public class RemoteSupportRequestRecord extends RequestRecord {

	private String subjectAdultLastName;
	private String trustee;
	private Calendar subjectAdultBirthDate;
	private String subjectAdultHomePhone;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private boolean seniorAssitanceBeneficiary;
	private String contactName;
	private String contact;
	private String trusteePhone;
	private String contactPhone;
	private String subjectAdultSex;
	private java.math.BigInteger floor;
	private String dwelling;
	private boolean emergency;
	private String contactFirstName;
	private String trusteeFirstName;
	private boolean taxable;
	private String subjectAdultFirstName2;
	private String trusteeName;
	private String subjectAdultFirstName;
	private java.math.BigInteger appartmentNumber;

	public RemoteSupportRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		RemoteSupportRequestRecord clonedRecord = (RemoteSupportRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RemoteSupportRequest)) {
            RemoteSupportRequest request = (RemoteSupportRequest)xmlRequest; 

			this.subjectAdultLastName = ((Adult)request.getSubject()).getLastName();
			if (request.getTrustee() != null)
                this.trustee = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest.class.getName(), 
                        "Trustee", request.getTrustee().toString());
			if (((Adult)request.getSubject()).getBirthDate() != null) {
				this.subjectAdultBirthDate = Calendar.getInstance(); 
	            this.subjectAdultBirthDate.setTime(((Adult)request.getSubject()).getBirthDate());
			}
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
            if ((request.getSeniorAssitanceBeneficiary() != null))
			this.seniorAssitanceBeneficiary = request.getSeniorAssitanceBeneficiary();
			this.contactName = request.getContactName();
			if (request.getContact() != null)
                this.contact = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest.class.getName(), 
                        "Contact", request.getContact().toString());
			this.trusteePhone = request.getTrusteePhone();
			this.contactPhone = request.getContactPhone();
			this.floor = request.getFloor();
			if (request.getDwelling() != null)
                this.dwelling = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest.class.getName(), 
                        "Dwelling", request.getDwelling().toString());
            if ((request.getEmergency() != null))
			this.emergency = request.getEmergency();
			this.contactFirstName = request.getContactFirstName();
			this.trusteeFirstName = request.getTrusteeFirstName();
            if ((request.getTaxable() != null))
			this.taxable = request.getTaxable();
			this.subjectAdultFirstName2 = ((Adult)request.getSubject()).getFirstName2();
			this.trusteeName = request.getTrusteeName();
			this.subjectAdultFirstName = ((Adult)request.getSubject()).getFirstName();
			this.appartmentNumber = request.getAppartmentNumber();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RemoteSupportRequest)) {
            RemoteSupportRequest request = (RemoteSupportRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof RemoteSupportRequest)) {
            RemoteSupportRequest request = (RemoteSupportRequest)xmlRequest; 

			if (this.trustee != null)
                request.setTrustee(
                    TrusteeType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest.class.getName(), 
                            "Trustee", this.trustee)
                    )
                );
            if ((request.getSeniorAssitanceBeneficiary() != null))
			request.setSeniorAssitanceBeneficiary(this.seniorAssitanceBeneficiary);
			request.setContactName(this.contactName);
			if (this.contact != null)
                request.setContact(
                    RsrContactType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest.class.getName(), 
                            "Contact", this.contact)
                    )
                );
			request.setTrusteePhone(this.trusteePhone);
			request.setContactPhone(this.contactPhone);
			request.setFloor(this.floor);
			if (this.dwelling != null)
                request.setDwelling(
                    RsrDwellingType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RemoteSupportRequestDocument.RemoteSupportRequest.class.getName(), 
                            "Dwelling", this.dwelling)
                    )
                );
            if ((request.getEmergency() != null))
			request.setEmergency(this.emergency);
			request.setContactFirstName(this.contactFirstName);
			request.setTrusteeFirstName(this.trusteeFirstName);
            if ((request.getTaxable() != null))
			request.setTaxable(this.taxable);
			request.setTrusteeName(this.trusteeName);
			request.setAppartmentNumber(this.appartmentNumber);
        }
    }
    
	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}

	public void setTrustee(String trustee) {
		this.trustee = trustee;
	}
	
	public String getTrustee() {
		return this.trustee;
	}

	public void setSubjectAdultBirthDate(Calendar subjectAdultBirthDate) {
		this.subjectAdultBirthDate = subjectAdultBirthDate;
	}
	
	public Calendar getSubjectAdultBirthDate() {
		return this.subjectAdultBirthDate;
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

	public void setSeniorAssitanceBeneficiary(boolean seniorAssitanceBeneficiary) {
		this.seniorAssitanceBeneficiary = seniorAssitanceBeneficiary;
	}
	
	public boolean getSeniorAssitanceBeneficiary() {
		return this.seniorAssitanceBeneficiary;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactName() {
		return this.contactName;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getContact() {
		return this.contact;
	}

	public void setTrusteePhone(String trusteePhone) {
		this.trusteePhone = trusteePhone;
	}
	
	public String getTrusteePhone() {
		return this.trusteePhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setSubjectAdultSex(String subjectAdultSex) {
		this.subjectAdultSex = subjectAdultSex;
	}
	
	public String getSubjectAdultSex() {
		return this.subjectAdultSex;
	}

	public void setFloor(java.math.BigInteger floor) {
		this.floor = floor;
	}
	
	public java.math.BigInteger getFloor() {
		return this.floor;
	}

	public void setDwelling(String dwelling) {
		this.dwelling = dwelling;
	}
	
	public String getDwelling() {
		return this.dwelling;
	}

	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}
	
	public boolean getEmergency() {
		return this.emergency;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	
	public String getContactFirstName() {
		return this.contactFirstName;
	}

	public void setTrusteeFirstName(String trusteeFirstName) {
		this.trusteeFirstName = trusteeFirstName;
	}
	
	public String getTrusteeFirstName() {
		return this.trusteeFirstName;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	
	public boolean getTaxable() {
		return this.taxable;
	}

	public void setSubjectAdultFirstName2(String subjectAdultFirstName2) {
		this.subjectAdultFirstName2 = subjectAdultFirstName2;
	}
	
	public String getSubjectAdultFirstName2() {
		return this.subjectAdultFirstName2;
	}

	public void setTrusteeName(String trusteeName) {
		this.trusteeName = trusteeName;
	}
	
	public String getTrusteeName() {
		return this.trusteeName;
	}

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}

	public void setAppartmentNumber(java.math.BigInteger appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}
	
	public java.math.BigInteger getAppartmentNumber() {
		return this.appartmentNumber;
	}

}

