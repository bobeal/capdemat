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

public class DhrRealAssets extends RequestRecord {

  	private String realAssetsRealAssetAddressAdditionalDeliveryInformation;
	private String realAssetsRealAssetAddressAdditionalGeographicalInformation;
	private String realAssetsRealAssetAddressStreetNumber;
	private String realAssetsRealAssetAddressStreetName;
	private String realAssetsRealAssetAddressPlaceNameOrService;
	private String realAssetsRealAssetAddressPostalCode;
	private String realAssetsRealAssetAddressCity;
	private java.math.BigInteger realAssetsRealAssetValue;
	private String realAssetsRealAssetCadastre;
	private java.math.BigInteger realAssetsRealAssetNetFloorArea;

	public DhrRealAssets() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DhrRealAssets clonedRecord = (DhrRealAssets)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(DhrRealAsset request) {
    	if (request != null) {

			if (request.getRealAssetAddress() != null) {
				this.realAssetsRealAssetAddressAdditionalDeliveryInformation = request.getRealAssetAddress().getAdditionalDeliveryInformation();
				this.realAssetsRealAssetAddressAdditionalGeographicalInformation = request.getRealAssetAddress().getAdditionalGeographicalInformation();
				this.realAssetsRealAssetAddressStreetNumber = request.getRealAssetAddress().getStreetNumber();
				this.realAssetsRealAssetAddressStreetName = request.getRealAssetAddress().getStreetName();
				this.realAssetsRealAssetAddressPlaceNameOrService = request.getRealAssetAddress().getPlaceNameOrService();
				this.realAssetsRealAssetAddressPostalCode = request.getRealAssetAddress().getPostalCode();
				this.realAssetsRealAssetAddressCity = request.getRealAssetAddress().getCity();
			}
			this.realAssetsRealAssetValue = request.getRealAssetValue();
			this.realAssetsRealAssetCadastre = request.getRealAssetCadastre();
			this.realAssetsRealAssetNetFloorArea = request.getRealAssetNetFloorArea();
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
    
	public void setRealAssetsRealAssetAddressAdditionalDeliveryInformation(String realAssetsRealAssetAddressAdditionalDeliveryInformation) {
		this.realAssetsRealAssetAddressAdditionalDeliveryInformation = realAssetsRealAssetAddressAdditionalDeliveryInformation;
	}
	
	public String getRealAssetsRealAssetAddressAdditionalDeliveryInformation() {
		return this.realAssetsRealAssetAddressAdditionalDeliveryInformation;
	}

	public void setRealAssetsRealAssetAddressAdditionalGeographicalInformation(String realAssetsRealAssetAddressAdditionalGeographicalInformation) {
		this.realAssetsRealAssetAddressAdditionalGeographicalInformation = realAssetsRealAssetAddressAdditionalGeographicalInformation;
	}
	
	public String getRealAssetsRealAssetAddressAdditionalGeographicalInformation() {
		return this.realAssetsRealAssetAddressAdditionalGeographicalInformation;
	}

	public void setRealAssetsRealAssetAddressStreetNumber(String realAssetsRealAssetAddressStreetNumber) {
		this.realAssetsRealAssetAddressStreetNumber = realAssetsRealAssetAddressStreetNumber;
	}
	
	public String getRealAssetsRealAssetAddressStreetNumber() {
		return this.realAssetsRealAssetAddressStreetNumber;
	}

	public void setRealAssetsRealAssetAddressStreetName(String realAssetsRealAssetAddressStreetName) {
		this.realAssetsRealAssetAddressStreetName = realAssetsRealAssetAddressStreetName;
	}
	
	public String getRealAssetsRealAssetAddressStreetName() {
		return this.realAssetsRealAssetAddressStreetName;
	}

	public void setRealAssetsRealAssetAddressPlaceNameOrService(String realAssetsRealAssetAddressPlaceNameOrService) {
		this.realAssetsRealAssetAddressPlaceNameOrService = realAssetsRealAssetAddressPlaceNameOrService;
	}
	
	public String getRealAssetsRealAssetAddressPlaceNameOrService() {
		return this.realAssetsRealAssetAddressPlaceNameOrService;
	}

	public void setRealAssetsRealAssetAddressPostalCode(String realAssetsRealAssetAddressPostalCode) {
		this.realAssetsRealAssetAddressPostalCode = realAssetsRealAssetAddressPostalCode;
	}
	
	public String getRealAssetsRealAssetAddressPostalCode() {
		return this.realAssetsRealAssetAddressPostalCode;
	}

	public void setRealAssetsRealAssetAddressCity(String realAssetsRealAssetAddressCity) {
		this.realAssetsRealAssetAddressCity = realAssetsRealAssetAddressCity;
	}
	
	public String getRealAssetsRealAssetAddressCity() {
		return this.realAssetsRealAssetAddressCity;
	}

	public void setRealAssetsRealAssetValue(java.math.BigInteger realAssetsRealAssetValue) {
		this.realAssetsRealAssetValue = realAssetsRealAssetValue;
	}
	
	public java.math.BigInteger getRealAssetsRealAssetValue() {
		return this.realAssetsRealAssetValue;
	}

	public void setRealAssetsRealAssetCadastre(String realAssetsRealAssetCadastre) {
		this.realAssetsRealAssetCadastre = realAssetsRealAssetCadastre;
	}
	
	public String getRealAssetsRealAssetCadastre() {
		return this.realAssetsRealAssetCadastre;
	}

	public void setRealAssetsRealAssetNetFloorArea(java.math.BigInteger realAssetsRealAssetNetFloorArea) {
		this.realAssetsRealAssetNetFloorArea = realAssetsRealAssetNetFloorArea;
	}
	
	public java.math.BigInteger getRealAssetsRealAssetNetFloorArea() {
		return this.realAssetsRealAssetNetFloorArea;
	}

}

