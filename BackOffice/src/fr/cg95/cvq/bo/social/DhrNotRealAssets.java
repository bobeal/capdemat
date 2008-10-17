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

public class DhrNotRealAssets extends RequestRecord {

	private Calendar notRealAssetsAssetDate;
	private String notRealAssetsAssetType;
	private String notRealAssetsAssetNotaryName;
	private String notRealAssetsAssetBeneficiaryName;
  	private String notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation;
	private String notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation;
	private String notRealAssetsAssetBeneficiaryAddressStreetNumber;
	private String notRealAssetsAssetBeneficiaryAddressStreetName;
	private String notRealAssetsAssetBeneficiaryAddressPlaceNameOrService;
	private String notRealAssetsAssetBeneficiaryAddressPostalCode;
	private String notRealAssetsAssetBeneficiaryAddressCity;
  	private String notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation;
	private String notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation;
	private String notRealAssetsAssetNotaryAddressStreetNumber;
	private String notRealAssetsAssetNotaryAddressStreetName;
	private String notRealAssetsAssetNotaryAddressPlaceNameOrService;
	private String notRealAssetsAssetNotaryAddressPostalCode;
	private String notRealAssetsAssetNotaryAddressCity;
  	private String notRealAssetsAssetAddressAdditionalDeliveryInformation;
	private String notRealAssetsAssetAddressAdditionalGeographicalInformation;
	private String notRealAssetsAssetAddressStreetNumber;
	private String notRealAssetsAssetAddressStreetName;
	private String notRealAssetsAssetAddressPlaceNameOrService;
	private String notRealAssetsAssetAddressPostalCode;
	private String notRealAssetsAssetAddressCity;
	private java.math.BigInteger notRealAssetsAssetValue;
	private String notRealAssetsAssetBeneficiaryFirstName;
	private String notRealAssetsAssetKind;

	public DhrNotRealAssets() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DhrNotRealAssets clonedRecord = (DhrNotRealAssets)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(DhrNotRealAsset request) {
    	if (request != null) {

			if (request.getAssetDate() != null) {
				this.notRealAssetsAssetDate = Calendar.getInstance(); 
	            this.notRealAssetsAssetDate.setTime(request.getAssetDate());
			}
			if (request.getAssetType() != null)
                this.notRealAssetsAssetType = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DhrNotRealAssetType.class.getName(), 
                        "AssetType", request.getAssetType().toString());
			this.notRealAssetsAssetNotaryName = request.getAssetNotaryName();
			this.notRealAssetsAssetBeneficiaryName = request.getAssetBeneficiaryName();
			if (request.getAssetBeneficiaryAddress() != null) {
				this.notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation = request.getAssetBeneficiaryAddress().getAdditionalDeliveryInformation();
				this.notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation = request.getAssetBeneficiaryAddress().getAdditionalGeographicalInformation();
				this.notRealAssetsAssetBeneficiaryAddressStreetNumber = request.getAssetBeneficiaryAddress().getStreetNumber();
				this.notRealAssetsAssetBeneficiaryAddressStreetName = request.getAssetBeneficiaryAddress().getStreetName();
				this.notRealAssetsAssetBeneficiaryAddressPlaceNameOrService = request.getAssetBeneficiaryAddress().getPlaceNameOrService();
				this.notRealAssetsAssetBeneficiaryAddressPostalCode = request.getAssetBeneficiaryAddress().getPostalCode();
				this.notRealAssetsAssetBeneficiaryAddressCity = request.getAssetBeneficiaryAddress().getCity();
			}
			if (request.getAssetNotaryAddress() != null) {
				this.notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation = request.getAssetNotaryAddress().getAdditionalDeliveryInformation();
				this.notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation = request.getAssetNotaryAddress().getAdditionalGeographicalInformation();
				this.notRealAssetsAssetNotaryAddressStreetNumber = request.getAssetNotaryAddress().getStreetNumber();
				this.notRealAssetsAssetNotaryAddressStreetName = request.getAssetNotaryAddress().getStreetName();
				this.notRealAssetsAssetNotaryAddressPlaceNameOrService = request.getAssetNotaryAddress().getPlaceNameOrService();
				this.notRealAssetsAssetNotaryAddressPostalCode = request.getAssetNotaryAddress().getPostalCode();
				this.notRealAssetsAssetNotaryAddressCity = request.getAssetNotaryAddress().getCity();
			}
			if (request.getAssetAddress() != null) {
				this.notRealAssetsAssetAddressAdditionalDeliveryInformation = request.getAssetAddress().getAdditionalDeliveryInformation();
				this.notRealAssetsAssetAddressAdditionalGeographicalInformation = request.getAssetAddress().getAdditionalGeographicalInformation();
				this.notRealAssetsAssetAddressStreetNumber = request.getAssetAddress().getStreetNumber();
				this.notRealAssetsAssetAddressStreetName = request.getAssetAddress().getStreetName();
				this.notRealAssetsAssetAddressPlaceNameOrService = request.getAssetAddress().getPlaceNameOrService();
				this.notRealAssetsAssetAddressPostalCode = request.getAssetAddress().getPostalCode();
				this.notRealAssetsAssetAddressCity = request.getAssetAddress().getCity();
			}
			this.notRealAssetsAssetValue = request.getAssetValue();
			this.notRealAssetsAssetBeneficiaryFirstName = request.getAssetBeneficiaryFirstName();
			if (request.getAssetKind() != null)
                this.notRealAssetsAssetKind = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DhrNotRealAssetType.class.getName(), 
                        "AssetKind", request.getAssetKind().toString());
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
    
	public void setNotRealAssetsAssetDate(Calendar notRealAssetsAssetDate) {
		this.notRealAssetsAssetDate = notRealAssetsAssetDate;
	}
	
	public Calendar getNotRealAssetsAssetDate() {
		return this.notRealAssetsAssetDate;
	}

	public void setNotRealAssetsAssetType(String notRealAssetsAssetType) {
		this.notRealAssetsAssetType = notRealAssetsAssetType;
	}
	
	public String getNotRealAssetsAssetType() {
		return this.notRealAssetsAssetType;
	}

	public void setNotRealAssetsAssetNotaryName(String notRealAssetsAssetNotaryName) {
		this.notRealAssetsAssetNotaryName = notRealAssetsAssetNotaryName;
	}
	
	public String getNotRealAssetsAssetNotaryName() {
		return this.notRealAssetsAssetNotaryName;
	}

	public void setNotRealAssetsAssetBeneficiaryName(String notRealAssetsAssetBeneficiaryName) {
		this.notRealAssetsAssetBeneficiaryName = notRealAssetsAssetBeneficiaryName;
	}
	
	public String getNotRealAssetsAssetBeneficiaryName() {
		return this.notRealAssetsAssetBeneficiaryName;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation(String notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation) {
		this.notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation = notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation() {
		return this.notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation(String notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation) {
		this.notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation = notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation() {
		return this.notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressStreetNumber(String notRealAssetsAssetBeneficiaryAddressStreetNumber) {
		this.notRealAssetsAssetBeneficiaryAddressStreetNumber = notRealAssetsAssetBeneficiaryAddressStreetNumber;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressStreetNumber() {
		return this.notRealAssetsAssetBeneficiaryAddressStreetNumber;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressStreetName(String notRealAssetsAssetBeneficiaryAddressStreetName) {
		this.notRealAssetsAssetBeneficiaryAddressStreetName = notRealAssetsAssetBeneficiaryAddressStreetName;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressStreetName() {
		return this.notRealAssetsAssetBeneficiaryAddressStreetName;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressPlaceNameOrService(String notRealAssetsAssetBeneficiaryAddressPlaceNameOrService) {
		this.notRealAssetsAssetBeneficiaryAddressPlaceNameOrService = notRealAssetsAssetBeneficiaryAddressPlaceNameOrService;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressPlaceNameOrService() {
		return this.notRealAssetsAssetBeneficiaryAddressPlaceNameOrService;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressPostalCode(String notRealAssetsAssetBeneficiaryAddressPostalCode) {
		this.notRealAssetsAssetBeneficiaryAddressPostalCode = notRealAssetsAssetBeneficiaryAddressPostalCode;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressPostalCode() {
		return this.notRealAssetsAssetBeneficiaryAddressPostalCode;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressCity(String notRealAssetsAssetBeneficiaryAddressCity) {
		this.notRealAssetsAssetBeneficiaryAddressCity = notRealAssetsAssetBeneficiaryAddressCity;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressCity() {
		return this.notRealAssetsAssetBeneficiaryAddressCity;
	}

	public void setNotRealAssetsAssetNotaryAddressAdditionalDeliveryInformation(String notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation) {
		this.notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation = notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation;
	}
	
	public String getNotRealAssetsAssetNotaryAddressAdditionalDeliveryInformation() {
		return this.notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation;
	}

	public void setNotRealAssetsAssetNotaryAddressAdditionalGeographicalInformation(String notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation) {
		this.notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation = notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation;
	}
	
	public String getNotRealAssetsAssetNotaryAddressAdditionalGeographicalInformation() {
		return this.notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation;
	}

	public void setNotRealAssetsAssetNotaryAddressStreetNumber(String notRealAssetsAssetNotaryAddressStreetNumber) {
		this.notRealAssetsAssetNotaryAddressStreetNumber = notRealAssetsAssetNotaryAddressStreetNumber;
	}
	
	public String getNotRealAssetsAssetNotaryAddressStreetNumber() {
		return this.notRealAssetsAssetNotaryAddressStreetNumber;
	}

	public void setNotRealAssetsAssetNotaryAddressStreetName(String notRealAssetsAssetNotaryAddressStreetName) {
		this.notRealAssetsAssetNotaryAddressStreetName = notRealAssetsAssetNotaryAddressStreetName;
	}
	
	public String getNotRealAssetsAssetNotaryAddressStreetName() {
		return this.notRealAssetsAssetNotaryAddressStreetName;
	}

	public void setNotRealAssetsAssetNotaryAddressPlaceNameOrService(String notRealAssetsAssetNotaryAddressPlaceNameOrService) {
		this.notRealAssetsAssetNotaryAddressPlaceNameOrService = notRealAssetsAssetNotaryAddressPlaceNameOrService;
	}
	
	public String getNotRealAssetsAssetNotaryAddressPlaceNameOrService() {
		return this.notRealAssetsAssetNotaryAddressPlaceNameOrService;
	}

	public void setNotRealAssetsAssetNotaryAddressPostalCode(String notRealAssetsAssetNotaryAddressPostalCode) {
		this.notRealAssetsAssetNotaryAddressPostalCode = notRealAssetsAssetNotaryAddressPostalCode;
	}
	
	public String getNotRealAssetsAssetNotaryAddressPostalCode() {
		return this.notRealAssetsAssetNotaryAddressPostalCode;
	}

	public void setNotRealAssetsAssetNotaryAddressCity(String notRealAssetsAssetNotaryAddressCity) {
		this.notRealAssetsAssetNotaryAddressCity = notRealAssetsAssetNotaryAddressCity;
	}
	
	public String getNotRealAssetsAssetNotaryAddressCity() {
		return this.notRealAssetsAssetNotaryAddressCity;
	}

	public void setNotRealAssetsAssetAddressAdditionalDeliveryInformation(String notRealAssetsAssetAddressAdditionalDeliveryInformation) {
		this.notRealAssetsAssetAddressAdditionalDeliveryInformation = notRealAssetsAssetAddressAdditionalDeliveryInformation;
	}
	
	public String getNotRealAssetsAssetAddressAdditionalDeliveryInformation() {
		return this.notRealAssetsAssetAddressAdditionalDeliveryInformation;
	}

	public void setNotRealAssetsAssetAddressAdditionalGeographicalInformation(String notRealAssetsAssetAddressAdditionalGeographicalInformation) {
		this.notRealAssetsAssetAddressAdditionalGeographicalInformation = notRealAssetsAssetAddressAdditionalGeographicalInformation;
	}
	
	public String getNotRealAssetsAssetAddressAdditionalGeographicalInformation() {
		return this.notRealAssetsAssetAddressAdditionalGeographicalInformation;
	}

	public void setNotRealAssetsAssetAddressStreetNumber(String notRealAssetsAssetAddressStreetNumber) {
		this.notRealAssetsAssetAddressStreetNumber = notRealAssetsAssetAddressStreetNumber;
	}
	
	public String getNotRealAssetsAssetAddressStreetNumber() {
		return this.notRealAssetsAssetAddressStreetNumber;
	}

	public void setNotRealAssetsAssetAddressStreetName(String notRealAssetsAssetAddressStreetName) {
		this.notRealAssetsAssetAddressStreetName = notRealAssetsAssetAddressStreetName;
	}
	
	public String getNotRealAssetsAssetAddressStreetName() {
		return this.notRealAssetsAssetAddressStreetName;
	}

	public void setNotRealAssetsAssetAddressPlaceNameOrService(String notRealAssetsAssetAddressPlaceNameOrService) {
		this.notRealAssetsAssetAddressPlaceNameOrService = notRealAssetsAssetAddressPlaceNameOrService;
	}
	
	public String getNotRealAssetsAssetAddressPlaceNameOrService() {
		return this.notRealAssetsAssetAddressPlaceNameOrService;
	}

	public void setNotRealAssetsAssetAddressPostalCode(String notRealAssetsAssetAddressPostalCode) {
		this.notRealAssetsAssetAddressPostalCode = notRealAssetsAssetAddressPostalCode;
	}
	
	public String getNotRealAssetsAssetAddressPostalCode() {
		return this.notRealAssetsAssetAddressPostalCode;
	}

	public void setNotRealAssetsAssetAddressCity(String notRealAssetsAssetAddressCity) {
		this.notRealAssetsAssetAddressCity = notRealAssetsAssetAddressCity;
	}
	
	public String getNotRealAssetsAssetAddressCity() {
		return this.notRealAssetsAssetAddressCity;
	}

	public void setNotRealAssetsAssetValue(java.math.BigInteger notRealAssetsAssetValue) {
		this.notRealAssetsAssetValue = notRealAssetsAssetValue;
	}
	
	public java.math.BigInteger getNotRealAssetsAssetValue() {
		return this.notRealAssetsAssetValue;
	}

	public void setNotRealAssetsAssetBeneficiaryFirstName(String notRealAssetsAssetBeneficiaryFirstName) {
		this.notRealAssetsAssetBeneficiaryFirstName = notRealAssetsAssetBeneficiaryFirstName;
	}
	
	public String getNotRealAssetsAssetBeneficiaryFirstName() {
		return this.notRealAssetsAssetBeneficiaryFirstName;
	}

	public void setNotRealAssetsAssetKind(String notRealAssetsAssetKind) {
		this.notRealAssetsAssetKind = notRealAssetsAssetKind;
	}
	
	public String getNotRealAssetsAssetKind() {
		return this.notRealAssetsAssetKind;
	}

}

