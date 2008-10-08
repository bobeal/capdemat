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

	private String realAssetsRealAssetCadastre;
	private String donationsDonationAssetPlace;
	private String donationsDonationBeneficiaryName;
	private String savingsPaybookNumber;
  	private String donationsDonationNotaryAddressAdditionalDeliveryInformation;
	private String donationsDonationNotaryAddressAdditionalGeographicalInformation;
	private String donationsDonationNotaryAddressStreetNumber;
	private String donationsDonationNotaryAddressStreetName;
	private String donationsDonationNotaryAddressPlaceNameOrService;
	private String donationsDonationNotaryAddressPostalCode;
	private String donationsDonationNotaryAddressCity;
	private String donationsDonationAsset;
  	private String realAssetsRealAssetAddressAdditionalDeliveryInformation;
	private String realAssetsRealAssetAddressAdditionalGeographicalInformation;
	private String realAssetsRealAssetAddressStreetNumber;
	private String realAssetsRealAssetAddressStreetName;
	private String realAssetsRealAssetAddressPlaceNameOrService;
	private String realAssetsRealAssetAddressPostalCode;
	private String realAssetsRealAssetAddressCity;
	private java.math.BigInteger realAssetsRealAssetNetFloorArea;
	private java.math.BigInteger realAssetsRealAssetValue;
	private Calendar donationsDonationDate;
	private String donationsDonationNotaryFirstName;
	private java.math.BigInteger savingsPaybookAmount;
	private java.math.BigInteger donationsDonationValue;
	private String donationsDonationBeneficiaryFirstName;
	private String donationsDonationNotaryName;

	public Patrimony() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("assets")) {
		}
		if (state.equals("displaydonation")) {
		}
		if (state.equals("displaysavings")) {
		}
		if (state.equals("displayassets")) {
		}
		if (state.equals("savings")) {
		}
		if (state.equals("donation")) {
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
  		if (this.checkDonationsDonationNotaryAddressStreetName() &&
			((this.donationsDonationNotaryAddressStreetName == null) || (this.donationsDonationNotaryAddressStreetName.length() == 0)))
			return false;
		if (this.checkDonationsDonationNotaryAddressPostalCode() &&
			((this.donationsDonationNotaryAddressPostalCode == null) || (this.donationsDonationNotaryAddressPostalCode.length() == 0)))
			return false;
		if (this.checkDonationsDonationNotaryAddressCity() &&
			((this.donationsDonationNotaryAddressCity == null) || (this.donationsDonationNotaryAddressCity.length() == 0)))
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
		return true;
	}
	
	public void setRealAssetsRealAssetCadastre(String realAssetsRealAssetCadastre) {
		this.realAssetsRealAssetCadastre = realAssetsRealAssetCadastre;
	}
	
	public String getRealAssetsRealAssetCadastre() {
		return this.realAssetsRealAssetCadastre;
	}
	
	public boolean checkRealAssetsRealAssetCadastre() {
		return true;
	}

	public void setDonationsDonationAssetPlace(String donationsDonationAssetPlace) {
		this.donationsDonationAssetPlace = donationsDonationAssetPlace;
	}
	
	public String getDonationsDonationAssetPlace() {
		return this.donationsDonationAssetPlace;
	}
	
	public boolean checkDonationsDonationAssetPlace() {
		return true;
	}

	public void setDonationsDonationBeneficiaryName(String donationsDonationBeneficiaryName) {
		this.donationsDonationBeneficiaryName = donationsDonationBeneficiaryName;
	}
	
	public String getDonationsDonationBeneficiaryName() {
		return this.donationsDonationBeneficiaryName;
	}
	
	public boolean checkDonationsDonationBeneficiaryName() {
		return true;
	}

	public void setSavingsPaybookNumber(String savingsPaybookNumber) {
		this.savingsPaybookNumber = savingsPaybookNumber;
	}
	
	public String getSavingsPaybookNumber() {
		return this.savingsPaybookNumber;
	}
	
	public boolean checkSavingsPaybookNumber() {
		return true;
	}

  	public void setDonationsDonationNotaryAddressAdditionalDeliveryInformation(String donationsDonationNotaryAddressAdditionalDeliveryInformation) {
		this.donationsDonationNotaryAddressAdditionalDeliveryInformation = donationsDonationNotaryAddressAdditionalDeliveryInformation;
	}
	
	public String getDonationsDonationNotaryAddressAdditionalDeliveryInformation() {
		return this.donationsDonationNotaryAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkDonationsDonationNotaryAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setDonationsDonationNotaryAddressAdditionalGeographicalInformation(String donationsDonationNotaryAddressAdditionalGeographicalInformation) {
		this.donationsDonationNotaryAddressAdditionalGeographicalInformation = donationsDonationNotaryAddressAdditionalGeographicalInformation;
	}
	
	public String getDonationsDonationNotaryAddressAdditionalGeographicalInformation() {
		return this.donationsDonationNotaryAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkDonationsDonationNotaryAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setDonationsDonationNotaryAddressStreetNumber(String donationsDonationNotaryAddressStreetNumber) {
		this.donationsDonationNotaryAddressStreetNumber = donationsDonationNotaryAddressStreetNumber;
	}
	
	public String getDonationsDonationNotaryAddressStreetNumber() {
		return this.donationsDonationNotaryAddressStreetNumber;
	}
	
	public boolean checkDonationsDonationNotaryAddressStreetNumber() {
		return true;
	}

	public void setDonationsDonationNotaryAddressStreetName(String donationsDonationNotaryAddressStreetName) {
		this.donationsDonationNotaryAddressStreetName = donationsDonationNotaryAddressStreetName;
	}
	
	public String getDonationsDonationNotaryAddressStreetName() {
		return this.donationsDonationNotaryAddressStreetName;
	}
	
	public boolean checkDonationsDonationNotaryAddressStreetName() {
		return true;
	}

	public void setDonationsDonationNotaryAddressPlaceNameOrService(String donationsDonationNotaryAddressPlaceNameOrService) {
		this.donationsDonationNotaryAddressPlaceNameOrService = donationsDonationNotaryAddressPlaceNameOrService;
	}
	
	public String getDonationsDonationNotaryAddressPlaceNameOrService() {
		return this.donationsDonationNotaryAddressPlaceNameOrService;
	}
	
	public boolean checkDonationsDonationNotaryAddressPlaceNameOrService() {
		return true;
	}

	public void setDonationsDonationNotaryAddressPostalCode(String donationsDonationNotaryAddressPostalCode) {
		this.donationsDonationNotaryAddressPostalCode = donationsDonationNotaryAddressPostalCode;
	}
	
	public String getDonationsDonationNotaryAddressPostalCode() {
		return this.donationsDonationNotaryAddressPostalCode;
	}
	
	public boolean checkDonationsDonationNotaryAddressPostalCode() {
		return true;
	}

	public void setDonationsDonationNotaryAddressCity(String donationsDonationNotaryAddressCity) {
		this.donationsDonationNotaryAddressCity = donationsDonationNotaryAddressCity;
	}
	
	public String getDonationsDonationNotaryAddressCity() {
		return this.donationsDonationNotaryAddressCity;
	}
	
	public boolean checkDonationsDonationNotaryAddressCity() {
		return true;
	}

	public void setDonationsDonationAsset(String donationsDonationAsset) {
		this.donationsDonationAsset = donationsDonationAsset;
	}
	
	public String getDonationsDonationAsset() {
		return this.donationsDonationAsset;
	}
	
	public boolean checkDonationsDonationAsset() {
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

	public void setDonationsDonationDate(Calendar donationsDonationDate) {
		this.donationsDonationDate = donationsDonationDate;
	}
	
	public Calendar getDonationsDonationDate() {
		return this.donationsDonationDate;
	}
	
	public boolean checkDonationsDonationDate() {
		return true;
	}

	public void setDonationsDonationNotaryFirstName(String donationsDonationNotaryFirstName) {
		this.donationsDonationNotaryFirstName = donationsDonationNotaryFirstName;
	}
	
	public String getDonationsDonationNotaryFirstName() {
		return this.donationsDonationNotaryFirstName;
	}
	
	public boolean checkDonationsDonationNotaryFirstName() {
		return true;
	}

	public void setSavingsPaybookAmount(java.math.BigInteger savingsPaybookAmount) {
		this.savingsPaybookAmount = savingsPaybookAmount;
	}
	
	public java.math.BigInteger getSavingsPaybookAmount() {
		return this.savingsPaybookAmount;
	}
	
	public boolean checkSavingsPaybookAmount() {
		return true;
	}

	public void setDonationsDonationValue(java.math.BigInteger donationsDonationValue) {
		this.donationsDonationValue = donationsDonationValue;
	}
	
	public java.math.BigInteger getDonationsDonationValue() {
		return this.donationsDonationValue;
	}
	
	public boolean checkDonationsDonationValue() {
		return true;
	}

	public void setDonationsDonationBeneficiaryFirstName(String donationsDonationBeneficiaryFirstName) {
		this.donationsDonationBeneficiaryFirstName = donationsDonationBeneficiaryFirstName;
	}
	
	public String getDonationsDonationBeneficiaryFirstName() {
		return this.donationsDonationBeneficiaryFirstName;
	}
	
	public boolean checkDonationsDonationBeneficiaryFirstName() {
		return true;
	}

	public void setDonationsDonationNotaryName(String donationsDonationNotaryName) {
		this.donationsDonationNotaryName = donationsDonationNotaryName;
	}
	
	public String getDonationsDonationNotaryName() {
		return this.donationsDonationNotaryName;
	}
	
	public boolean checkDonationsDonationNotaryName() {
		return true;
	}

}
