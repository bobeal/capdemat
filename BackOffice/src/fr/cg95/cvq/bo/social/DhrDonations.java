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

public class DhrDonations extends RequestRecord {

	private String donationsDonationAssetPlace;
	private String donationsDonationBeneficiaryName;
	private Calendar donationsDonationDate;
  	private String donationsDonationNotaryAddressAdditionalDeliveryInformation;
	private String donationsDonationNotaryAddressAdditionalGeographicalInformation;
	private String donationsDonationNotaryAddressStreetNumber;
	private String donationsDonationNotaryAddressStreetName;
	private String donationsDonationNotaryAddressPlaceNameOrService;
	private String donationsDonationNotaryAddressPostalCode;
	private String donationsDonationNotaryAddressCity;
	private String donationsDonationNotaryFirstName;
	private String donationsDonationAsset;
	private java.math.BigInteger donationsDonationValue;
	private String donationsDonationBeneficiaryFirstName;
	private String donationsDonationNotaryName;

	public DhrDonations() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DhrDonations clonedRecord = (DhrDonations)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(DhrDonation request) {
    	if (request != null) {

			this.donationsDonationAssetPlace = request.getDonationAssetPlace();
			this.donationsDonationBeneficiaryName = request.getDonationBeneficiaryName();
			if (request.getDonationDate() != null) {
				this.donationsDonationDate = Calendar.getInstance(); 
	            this.donationsDonationDate.setTime(request.getDonationDate());
			}
			if (request.getDonationNotaryAddress() != null) {
				this.donationsDonationNotaryAddressAdditionalDeliveryInformation = request.getDonationNotaryAddress().getAdditionalDeliveryInformation();
				this.donationsDonationNotaryAddressAdditionalGeographicalInformation = request.getDonationNotaryAddress().getAdditionalGeographicalInformation();
				this.donationsDonationNotaryAddressStreetNumber = request.getDonationNotaryAddress().getStreetNumber();
				this.donationsDonationNotaryAddressStreetName = request.getDonationNotaryAddress().getStreetName();
				this.donationsDonationNotaryAddressPlaceNameOrService = request.getDonationNotaryAddress().getPlaceNameOrService();
				this.donationsDonationNotaryAddressPostalCode = request.getDonationNotaryAddress().getPostalCode();
				this.donationsDonationNotaryAddressCity = request.getDonationNotaryAddress().getCity();
			}
			this.donationsDonationNotaryFirstName = request.getDonationNotaryFirstName();
			if (request.getDonationAsset() != null)
                this.donationsDonationAsset = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DhrDonationType.class.getName(), 
                        "DonationAsset", request.getDonationAsset().toString());
			this.donationsDonationValue = request.getDonationValue();
			this.donationsDonationBeneficiaryFirstName = request.getDonationBeneficiaryFirstName();
			this.donationsDonationNotaryName = request.getDonationNotaryName();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 

        }
    }
    
	public void setDonationsDonationAssetPlace(String donationsDonationAssetPlace) {
		this.donationsDonationAssetPlace = donationsDonationAssetPlace;
	}
	
	public String getDonationsDonationAssetPlace() {
		return this.donationsDonationAssetPlace;
	}

	public void setDonationsDonationBeneficiaryName(String donationsDonationBeneficiaryName) {
		this.donationsDonationBeneficiaryName = donationsDonationBeneficiaryName;
	}
	
	public String getDonationsDonationBeneficiaryName() {
		return this.donationsDonationBeneficiaryName;
	}

	public void setDonationsDonationDate(Calendar donationsDonationDate) {
		this.donationsDonationDate = donationsDonationDate;
	}
	
	public Calendar getDonationsDonationDate() {
		return this.donationsDonationDate;
	}

	public void setDonationsDonationNotaryAddressAdditionalDeliveryInformation(String donationsDonationNotaryAddressAdditionalDeliveryInformation) {
		this.donationsDonationNotaryAddressAdditionalDeliveryInformation = donationsDonationNotaryAddressAdditionalDeliveryInformation;
	}
	
	public String getDonationsDonationNotaryAddressAdditionalDeliveryInformation() {
		return this.donationsDonationNotaryAddressAdditionalDeliveryInformation;
	}

	public void setDonationsDonationNotaryAddressAdditionalGeographicalInformation(String donationsDonationNotaryAddressAdditionalGeographicalInformation) {
		this.donationsDonationNotaryAddressAdditionalGeographicalInformation = donationsDonationNotaryAddressAdditionalGeographicalInformation;
	}
	
	public String getDonationsDonationNotaryAddressAdditionalGeographicalInformation() {
		return this.donationsDonationNotaryAddressAdditionalGeographicalInformation;
	}

	public void setDonationsDonationNotaryAddressStreetNumber(String donationsDonationNotaryAddressStreetNumber) {
		this.donationsDonationNotaryAddressStreetNumber = donationsDonationNotaryAddressStreetNumber;
	}
	
	public String getDonationsDonationNotaryAddressStreetNumber() {
		return this.donationsDonationNotaryAddressStreetNumber;
	}

	public void setDonationsDonationNotaryAddressStreetName(String donationsDonationNotaryAddressStreetName) {
		this.donationsDonationNotaryAddressStreetName = donationsDonationNotaryAddressStreetName;
	}
	
	public String getDonationsDonationNotaryAddressStreetName() {
		return this.donationsDonationNotaryAddressStreetName;
	}

	public void setDonationsDonationNotaryAddressPlaceNameOrService(String donationsDonationNotaryAddressPlaceNameOrService) {
		this.donationsDonationNotaryAddressPlaceNameOrService = donationsDonationNotaryAddressPlaceNameOrService;
	}
	
	public String getDonationsDonationNotaryAddressPlaceNameOrService() {
		return this.donationsDonationNotaryAddressPlaceNameOrService;
	}

	public void setDonationsDonationNotaryAddressPostalCode(String donationsDonationNotaryAddressPostalCode) {
		this.donationsDonationNotaryAddressPostalCode = donationsDonationNotaryAddressPostalCode;
	}
	
	public String getDonationsDonationNotaryAddressPostalCode() {
		return this.donationsDonationNotaryAddressPostalCode;
	}

	public void setDonationsDonationNotaryAddressCity(String donationsDonationNotaryAddressCity) {
		this.donationsDonationNotaryAddressCity = donationsDonationNotaryAddressCity;
	}
	
	public String getDonationsDonationNotaryAddressCity() {
		return this.donationsDonationNotaryAddressCity;
	}

	public void setDonationsDonationNotaryFirstName(String donationsDonationNotaryFirstName) {
		this.donationsDonationNotaryFirstName = donationsDonationNotaryFirstName;
	}
	
	public String getDonationsDonationNotaryFirstName() {
		return this.donationsDonationNotaryFirstName;
	}

	public void setDonationsDonationAsset(String donationsDonationAsset) {
		this.donationsDonationAsset = donationsDonationAsset;
	}
	
	public String getDonationsDonationAsset() {
		return this.donationsDonationAsset;
	}

	public void setDonationsDonationValue(java.math.BigInteger donationsDonationValue) {
		this.donationsDonationValue = donationsDonationValue;
	}
	
	public java.math.BigInteger getDonationsDonationValue() {
		return this.donationsDonationValue;
	}

	public void setDonationsDonationBeneficiaryFirstName(String donationsDonationBeneficiaryFirstName) {
		this.donationsDonationBeneficiaryFirstName = donationsDonationBeneficiaryFirstName;
	}
	
	public String getDonationsDonationBeneficiaryFirstName() {
		return this.donationsDonationBeneficiaryFirstName;
	}

	public void setDonationsDonationNotaryName(String donationsDonationNotaryName) {
		this.donationsDonationNotaryName = donationsDonationNotaryName;
	}
	
	public String getDonationsDonationNotaryName() {
		return this.donationsDonationNotaryName;
	}

}

