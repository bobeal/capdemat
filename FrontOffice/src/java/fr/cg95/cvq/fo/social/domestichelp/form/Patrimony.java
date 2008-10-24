package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Patrimony extends IStageForm {

	private String notRealAssetsAssetNotaryName;
  	private String notRealAssetsAssetAddressAdditionalDeliveryInformation;
	private String notRealAssetsAssetAddressAdditionalGeographicalInformation;
	private String notRealAssetsAssetAddressStreetNumber;
	private String notRealAssetsAssetAddressStreetName;
	private String notRealAssetsAssetAddressPlaceNameOrService;
	private String notRealAssetsAssetAddressPostalCode;
	private String notRealAssetsAssetAddressCity;
  	private String notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation;
	private String notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation;
	private String notRealAssetsAssetNotaryAddressStreetNumber;
	private String notRealAssetsAssetNotaryAddressStreetName;
	private String notRealAssetsAssetNotaryAddressPlaceNameOrService;
	private String notRealAssetsAssetNotaryAddressPostalCode;
	private String notRealAssetsAssetNotaryAddressCity;
  	private String realAssetsRealAssetAddressAdditionalDeliveryInformation;
	private String realAssetsRealAssetAddressAdditionalGeographicalInformation;
	private String realAssetsRealAssetAddressStreetNumber;
	private String realAssetsRealAssetAddressStreetName;
	private String realAssetsRealAssetAddressPlaceNameOrService;
	private String realAssetsRealAssetAddressPostalCode;
	private String realAssetsRealAssetAddressCity;
	private java.math.BigInteger notRealAssetsAssetValue;
	private java.math.BigInteger realAssetsRealAssetNetFloorArea;
	private java.math.BigInteger realAssetsRealAssetValue;
	private String notRealAssetsAssetBeneficiaryFirstName;
	private String notRealAssetsAssetType;
	private Calendar notRealAssetsAssetDate;
	private String notRealAssetsAssetBeneficiaryName;
  	private String notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation;
	private String notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation;
	private String notRealAssetsAssetBeneficiaryAddressStreetNumber;
	private String notRealAssetsAssetBeneficiaryAddressStreetName;
	private String notRealAssetsAssetBeneficiaryAddressPlaceNameOrService;
	private String notRealAssetsAssetBeneficiaryAddressPostalCode;
	private String notRealAssetsAssetBeneficiaryAddressCity;
	private String notRealAssetsAssetKind;

	public Patrimony() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("assets")) {
		}
		if (state.equals("displayassets")) {
		}
		if (state.equals("notrealasset")) {
		}
		if (state.equals("displaynotrealasset")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
		}
	}
	
	public boolean isComplete() {
		if (this.checkNotRealAssetsAssetNotaryName() &&
			((this.notRealAssetsAssetNotaryName == null) || (this.notRealAssetsAssetNotaryName.length() == 0)))
			return false;
  		if (this.checkNotRealAssetsAssetAddressStreetName() &&
			((this.notRealAssetsAssetAddressStreetName == null) || (this.notRealAssetsAssetAddressStreetName.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetAddressPostalCode() &&
			((this.notRealAssetsAssetAddressPostalCode == null) || (this.notRealAssetsAssetAddressPostalCode.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetAddressCity() &&
			((this.notRealAssetsAssetAddressCity == null) || (this.notRealAssetsAssetAddressCity.length() == 0)))
			return false;
  		if (this.checkNotRealAssetsAssetNotaryAddressStreetName() &&
			((this.notRealAssetsAssetNotaryAddressStreetName == null) || (this.notRealAssetsAssetNotaryAddressStreetName.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetNotaryAddressPostalCode() &&
			((this.notRealAssetsAssetNotaryAddressPostalCode == null) || (this.notRealAssetsAssetNotaryAddressPostalCode.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetNotaryAddressCity() &&
			((this.notRealAssetsAssetNotaryAddressCity == null) || (this.notRealAssetsAssetNotaryAddressCity.length() == 0)))
			return false;
  		if (this.checkRealAssetsRealAssetAddressStreetName() &&
			((this.realAssetsRealAssetAddressStreetName == null) || (this.realAssetsRealAssetAddressStreetName.length() == 0)))
			return false;
		if (this.checkRealAssetsRealAssetAddressPostalCode() &&
			((this.realAssetsRealAssetAddressPostalCode == null) || (this.realAssetsRealAssetAddressPostalCode.length() == 0)))
			return false;
		if (this.checkRealAssetsRealAssetAddressCity() &&
			((this.realAssetsRealAssetAddressCity == null) || (this.realAssetsRealAssetAddressCity.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetValue() && (this.notRealAssetsAssetValue == null))
			return false;
		if (this.checkRealAssetsRealAssetNetFloorArea() && (this.realAssetsRealAssetNetFloorArea == null))
			return false;
		if (this.checkRealAssetsRealAssetValue() && (this.realAssetsRealAssetValue == null))
			return false;
		if (this.checkNotRealAssetsAssetBeneficiaryFirstName() &&
			((this.notRealAssetsAssetBeneficiaryFirstName == null) || (this.notRealAssetsAssetBeneficiaryFirstName.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetType() &&
			((this.notRealAssetsAssetType == null) || (this.notRealAssetsAssetType.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetDate() && (this.notRealAssetsAssetDate == null))
			return false;
		if (this.checkNotRealAssetsAssetBeneficiaryName() &&
			((this.notRealAssetsAssetBeneficiaryName == null) || (this.notRealAssetsAssetBeneficiaryName.length() == 0)))
			return false;
  		if (this.checkNotRealAssetsAssetBeneficiaryAddressStreetName() &&
			((this.notRealAssetsAssetBeneficiaryAddressStreetName == null) || (this.notRealAssetsAssetBeneficiaryAddressStreetName.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetBeneficiaryAddressPostalCode() &&
			((this.notRealAssetsAssetBeneficiaryAddressPostalCode == null) || (this.notRealAssetsAssetBeneficiaryAddressPostalCode.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetBeneficiaryAddressCity() &&
			((this.notRealAssetsAssetBeneficiaryAddressCity == null) || (this.notRealAssetsAssetBeneficiaryAddressCity.length() == 0)))
			return false;
		if (this.checkNotRealAssetsAssetKind() &&
			((this.notRealAssetsAssetKind == null) || (this.notRealAssetsAssetKind.length() == 0)))
			return false;
		return true;
	}
	
	public void setNotRealAssetsAssetNotaryName(String notRealAssetsAssetNotaryName) {
		this.notRealAssetsAssetNotaryName = notRealAssetsAssetNotaryName;
	}
	
	public String getNotRealAssetsAssetNotaryName() {
		return this.notRealAssetsAssetNotaryName;
	}
	
	public boolean checkNotRealAssetsAssetNotaryName() {
		return true;
	}

  	public void setNotRealAssetsAssetAddressAdditionalDeliveryInformation(String notRealAssetsAssetAddressAdditionalDeliveryInformation) {
		this.notRealAssetsAssetAddressAdditionalDeliveryInformation = notRealAssetsAssetAddressAdditionalDeliveryInformation;
	}
	
	public String getNotRealAssetsAssetAddressAdditionalDeliveryInformation() {
		return this.notRealAssetsAssetAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkNotRealAssetsAssetAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setNotRealAssetsAssetAddressAdditionalGeographicalInformation(String notRealAssetsAssetAddressAdditionalGeographicalInformation) {
		this.notRealAssetsAssetAddressAdditionalGeographicalInformation = notRealAssetsAssetAddressAdditionalGeographicalInformation;
	}
	
	public String getNotRealAssetsAssetAddressAdditionalGeographicalInformation() {
		return this.notRealAssetsAssetAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkNotRealAssetsAssetAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setNotRealAssetsAssetAddressStreetNumber(String notRealAssetsAssetAddressStreetNumber) {
		this.notRealAssetsAssetAddressStreetNumber = notRealAssetsAssetAddressStreetNumber;
	}
	
	public String getNotRealAssetsAssetAddressStreetNumber() {
		return this.notRealAssetsAssetAddressStreetNumber;
	}
	
	public boolean checkNotRealAssetsAssetAddressStreetNumber() {
		return true;
	}

	public void setNotRealAssetsAssetAddressStreetName(String notRealAssetsAssetAddressStreetName) {
		this.notRealAssetsAssetAddressStreetName = notRealAssetsAssetAddressStreetName;
	}
	
	public String getNotRealAssetsAssetAddressStreetName() {
		return this.notRealAssetsAssetAddressStreetName;
	}
	
	public boolean checkNotRealAssetsAssetAddressStreetName() {
		return notRealAssetsAssetKind.equals("RealEstate");
	}

	public void setNotRealAssetsAssetAddressPlaceNameOrService(String notRealAssetsAssetAddressPlaceNameOrService) {
		this.notRealAssetsAssetAddressPlaceNameOrService = notRealAssetsAssetAddressPlaceNameOrService;
	}
	
	public String getNotRealAssetsAssetAddressPlaceNameOrService() {
		return this.notRealAssetsAssetAddressPlaceNameOrService;
	}
	
	public boolean checkNotRealAssetsAssetAddressPlaceNameOrService() {
		return true;
	}

	public void setNotRealAssetsAssetAddressPostalCode(String notRealAssetsAssetAddressPostalCode) {
		this.notRealAssetsAssetAddressPostalCode = notRealAssetsAssetAddressPostalCode;
	}
	
	public String getNotRealAssetsAssetAddressPostalCode() {
		return this.notRealAssetsAssetAddressPostalCode;
	}
	
	public boolean checkNotRealAssetsAssetAddressPostalCode() {
		return notRealAssetsAssetKind.equals("RealEstate");
	}

	public void setNotRealAssetsAssetAddressCity(String notRealAssetsAssetAddressCity) {
		this.notRealAssetsAssetAddressCity = notRealAssetsAssetAddressCity;
	}
	
	public String getNotRealAssetsAssetAddressCity() {
		return this.notRealAssetsAssetAddressCity;
	}
	
	public boolean checkNotRealAssetsAssetAddressCity() {
		return notRealAssetsAssetKind.equals("RealEstate");
	}

  	public void setNotRealAssetsAssetNotaryAddressAdditionalDeliveryInformation(String notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation) {
		this.notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation = notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation;
	}
	
	public String getNotRealAssetsAssetNotaryAddressAdditionalDeliveryInformation() {
		return this.notRealAssetsAssetNotaryAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setNotRealAssetsAssetNotaryAddressAdditionalGeographicalInformation(String notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation) {
		this.notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation = notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation;
	}
	
	public String getNotRealAssetsAssetNotaryAddressAdditionalGeographicalInformation() {
		return this.notRealAssetsAssetNotaryAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setNotRealAssetsAssetNotaryAddressStreetNumber(String notRealAssetsAssetNotaryAddressStreetNumber) {
		this.notRealAssetsAssetNotaryAddressStreetNumber = notRealAssetsAssetNotaryAddressStreetNumber;
	}
	
	public String getNotRealAssetsAssetNotaryAddressStreetNumber() {
		return this.notRealAssetsAssetNotaryAddressStreetNumber;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressStreetNumber() {
		return true;
	}

	public void setNotRealAssetsAssetNotaryAddressStreetName(String notRealAssetsAssetNotaryAddressStreetName) {
		this.notRealAssetsAssetNotaryAddressStreetName = notRealAssetsAssetNotaryAddressStreetName;
	}
	
	public String getNotRealAssetsAssetNotaryAddressStreetName() {
		return this.notRealAssetsAssetNotaryAddressStreetName;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressStreetName() {
		return true;
	}

	public void setNotRealAssetsAssetNotaryAddressPlaceNameOrService(String notRealAssetsAssetNotaryAddressPlaceNameOrService) {
		this.notRealAssetsAssetNotaryAddressPlaceNameOrService = notRealAssetsAssetNotaryAddressPlaceNameOrService;
	}
	
	public String getNotRealAssetsAssetNotaryAddressPlaceNameOrService() {
		return this.notRealAssetsAssetNotaryAddressPlaceNameOrService;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressPlaceNameOrService() {
		return true;
	}

	public void setNotRealAssetsAssetNotaryAddressPostalCode(String notRealAssetsAssetNotaryAddressPostalCode) {
		this.notRealAssetsAssetNotaryAddressPostalCode = notRealAssetsAssetNotaryAddressPostalCode;
	}
	
	public String getNotRealAssetsAssetNotaryAddressPostalCode() {
		return this.notRealAssetsAssetNotaryAddressPostalCode;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressPostalCode() {
		return true;
	}

	public void setNotRealAssetsAssetNotaryAddressCity(String notRealAssetsAssetNotaryAddressCity) {
		this.notRealAssetsAssetNotaryAddressCity = notRealAssetsAssetNotaryAddressCity;
	}
	
	public String getNotRealAssetsAssetNotaryAddressCity() {
		return this.notRealAssetsAssetNotaryAddressCity;
	}
	
	public boolean checkNotRealAssetsAssetNotaryAddressCity() {
		return true;
	}

  	public void setRealAssetsRealAssetAddressAdditionalDeliveryInformation(String realAssetsRealAssetAddressAdditionalDeliveryInformation) {
		this.realAssetsRealAssetAddressAdditionalDeliveryInformation = realAssetsRealAssetAddressAdditionalDeliveryInformation;
	}
	
	public String getRealAssetsRealAssetAddressAdditionalDeliveryInformation() {
		return this.realAssetsRealAssetAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkRealAssetsRealAssetAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setRealAssetsRealAssetAddressAdditionalGeographicalInformation(String realAssetsRealAssetAddressAdditionalGeographicalInformation) {
		this.realAssetsRealAssetAddressAdditionalGeographicalInformation = realAssetsRealAssetAddressAdditionalGeographicalInformation;
	}
	
	public String getRealAssetsRealAssetAddressAdditionalGeographicalInformation() {
		return this.realAssetsRealAssetAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkRealAssetsRealAssetAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setRealAssetsRealAssetAddressStreetNumber(String realAssetsRealAssetAddressStreetNumber) {
		this.realAssetsRealAssetAddressStreetNumber = realAssetsRealAssetAddressStreetNumber;
	}
	
	public String getRealAssetsRealAssetAddressStreetNumber() {
		return this.realAssetsRealAssetAddressStreetNumber;
	}
	
	public boolean checkRealAssetsRealAssetAddressStreetNumber() {
		return true;
	}

	public void setRealAssetsRealAssetAddressStreetName(String realAssetsRealAssetAddressStreetName) {
		this.realAssetsRealAssetAddressStreetName = realAssetsRealAssetAddressStreetName;
	}
	
	public String getRealAssetsRealAssetAddressStreetName() {
		return this.realAssetsRealAssetAddressStreetName;
	}
	
	public boolean checkRealAssetsRealAssetAddressStreetName() {
		return true;
	}

	public void setRealAssetsRealAssetAddressPlaceNameOrService(String realAssetsRealAssetAddressPlaceNameOrService) {
		this.realAssetsRealAssetAddressPlaceNameOrService = realAssetsRealAssetAddressPlaceNameOrService;
	}
	
	public String getRealAssetsRealAssetAddressPlaceNameOrService() {
		return this.realAssetsRealAssetAddressPlaceNameOrService;
	}
	
	public boolean checkRealAssetsRealAssetAddressPlaceNameOrService() {
		return true;
	}

	public void setRealAssetsRealAssetAddressPostalCode(String realAssetsRealAssetAddressPostalCode) {
		this.realAssetsRealAssetAddressPostalCode = realAssetsRealAssetAddressPostalCode;
	}
	
	public String getRealAssetsRealAssetAddressPostalCode() {
		return this.realAssetsRealAssetAddressPostalCode;
	}
	
	public boolean checkRealAssetsRealAssetAddressPostalCode() {
		return true;
	}

	public void setRealAssetsRealAssetAddressCity(String realAssetsRealAssetAddressCity) {
		this.realAssetsRealAssetAddressCity = realAssetsRealAssetAddressCity;
	}
	
	public String getRealAssetsRealAssetAddressCity() {
		return this.realAssetsRealAssetAddressCity;
	}
	
	public boolean checkRealAssetsRealAssetAddressCity() {
		return true;
	}

	public void setNotRealAssetsAssetValue(java.math.BigInteger notRealAssetsAssetValue) {
		this.notRealAssetsAssetValue = notRealAssetsAssetValue;
	}
	
	public java.math.BigInteger getNotRealAssetsAssetValue() {
		return this.notRealAssetsAssetValue;
	}
	
	public boolean checkNotRealAssetsAssetValue() {
		return true;
	}

	public void setRealAssetsRealAssetNetFloorArea(java.math.BigInteger realAssetsRealAssetNetFloorArea) {
		this.realAssetsRealAssetNetFloorArea = realAssetsRealAssetNetFloorArea;
	}
	
	public java.math.BigInteger getRealAssetsRealAssetNetFloorArea() {
		return this.realAssetsRealAssetNetFloorArea;
	}
	
	public boolean checkRealAssetsRealAssetNetFloorArea() {
		return true;
	}

	public void setRealAssetsRealAssetValue(java.math.BigInteger realAssetsRealAssetValue) {
		this.realAssetsRealAssetValue = realAssetsRealAssetValue;
	}
	
	public java.math.BigInteger getRealAssetsRealAssetValue() {
		return this.realAssetsRealAssetValue;
	}
	
	public boolean checkRealAssetsRealAssetValue() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryFirstName(String notRealAssetsAssetBeneficiaryFirstName) {
		this.notRealAssetsAssetBeneficiaryFirstName = notRealAssetsAssetBeneficiaryFirstName;
	}
	
	public String getNotRealAssetsAssetBeneficiaryFirstName() {
		return this.notRealAssetsAssetBeneficiaryFirstName;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryFirstName() {
		return true;
	}

	public void setNotRealAssetsAssetType(String notRealAssetsAssetType) {
		this.notRealAssetsAssetType = notRealAssetsAssetType;
	}
	
	public String getNotRealAssetsAssetType() {
		return this.notRealAssetsAssetType;
	}
	
	public boolean checkNotRealAssetsAssetType() {
		return true;
	}

	public void setNotRealAssetsAssetDate(Calendar notRealAssetsAssetDate) {
		this.notRealAssetsAssetDate = notRealAssetsAssetDate;
	}
	
	public Calendar getNotRealAssetsAssetDate() {
		return this.notRealAssetsAssetDate;
	}
	
	public boolean checkNotRealAssetsAssetDate() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryName(String notRealAssetsAssetBeneficiaryName) {
		this.notRealAssetsAssetBeneficiaryName = notRealAssetsAssetBeneficiaryName;
	}
	
	public String getNotRealAssetsAssetBeneficiaryName() {
		return this.notRealAssetsAssetBeneficiaryName;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryName() {
		return true;
	}

  	public void setNotRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation(String notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation) {
		this.notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation = notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation() {
		return this.notRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation(String notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation) {
		this.notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation = notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation() {
		return this.notRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressStreetNumber(String notRealAssetsAssetBeneficiaryAddressStreetNumber) {
		this.notRealAssetsAssetBeneficiaryAddressStreetNumber = notRealAssetsAssetBeneficiaryAddressStreetNumber;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressStreetNumber() {
		return this.notRealAssetsAssetBeneficiaryAddressStreetNumber;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressStreetNumber() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressStreetName(String notRealAssetsAssetBeneficiaryAddressStreetName) {
		this.notRealAssetsAssetBeneficiaryAddressStreetName = notRealAssetsAssetBeneficiaryAddressStreetName;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressStreetName() {
		return this.notRealAssetsAssetBeneficiaryAddressStreetName;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressStreetName() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressPlaceNameOrService(String notRealAssetsAssetBeneficiaryAddressPlaceNameOrService) {
		this.notRealAssetsAssetBeneficiaryAddressPlaceNameOrService = notRealAssetsAssetBeneficiaryAddressPlaceNameOrService;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressPlaceNameOrService() {
		return this.notRealAssetsAssetBeneficiaryAddressPlaceNameOrService;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressPlaceNameOrService() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressPostalCode(String notRealAssetsAssetBeneficiaryAddressPostalCode) {
		this.notRealAssetsAssetBeneficiaryAddressPostalCode = notRealAssetsAssetBeneficiaryAddressPostalCode;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressPostalCode() {
		return this.notRealAssetsAssetBeneficiaryAddressPostalCode;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressPostalCode() {
		return true;
	}

	public void setNotRealAssetsAssetBeneficiaryAddressCity(String notRealAssetsAssetBeneficiaryAddressCity) {
		this.notRealAssetsAssetBeneficiaryAddressCity = notRealAssetsAssetBeneficiaryAddressCity;
	}
	
	public String getNotRealAssetsAssetBeneficiaryAddressCity() {
		return this.notRealAssetsAssetBeneficiaryAddressCity;
	}
	
	public boolean checkNotRealAssetsAssetBeneficiaryAddressCity() {
		return true;
	}

	public void setNotRealAssetsAssetKind(String notRealAssetsAssetKind) {
		this.notRealAssetsAssetKind = notRealAssetsAssetKind;
	}
	
	public String getNotRealAssetsAssetKind() {
		return this.notRealAssetsAssetKind;
	}
	
	public boolean checkNotRealAssetsAssetKind() {
		return true;
	}

}