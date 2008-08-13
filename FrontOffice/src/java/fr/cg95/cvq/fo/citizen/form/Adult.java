package fr.cg95.cvq.fo.citizen.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.ecitizen.*;
import fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest;

public class Adult extends IStageForm {

	private String adultCfbn;
	private String adultBirthPlaceCity;
	private boolean showAccMan;
	private String adultFamilyStatus;
	private String adultBirthPlacePostalCode;
	private String adultBirthPlaceCountry;
	private String adultTitle;
	private String adultFirstName2;
	private String adultOfficePhone;
	private String adultMobilePhone;
	private Calendar adultBirthDate;
	private String adultMaidenName;
	private String adultFirstName3;
	private boolean accountManager;
	private String adultEmail;
	private long adultId;
	private String adultLastName;
	private String adultFirstName;
	private String adultHomePhone;
  	private String adultAddressAdditionalDeliveryInformation;
	private String adultAddressAdditionalGeographicalInformation;
	private String adultAddressStreetNumber;
	private String adultAddressStreetName;
	private String adultAddressPlaceNameOrService;
	private String adultAddressPostalCode;
	private String adultAddressCity;
	private String adultProfession;
	private String adultNameOfUse;

	public Adult() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("address")) {
		}
		if (state.equals("adult")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof VoCardRequest)) {
			VoCardRequest request = (VoCardRequest)xmlbRequest;
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof VoCardRequest)) {
			VoCardRequest request = (VoCardRequest)xmlbRequest;
		}
	}
	
	public boolean isComplete() {
		if (this.checkAdultFamilyStatus() &&
			((this.adultFamilyStatus == null) || (this.adultFamilyStatus.length() == 0)))
			return false;
		if (this.checkAdultTitle() &&
			((this.adultTitle == null) || (this.adultTitle.length() == 0)))
			return false;
		if (this.checkAdultEmail() &&
			((this.adultEmail == null) || (this.adultEmail.length() == 0)))
			return false;
		if (this.checkAdultLastName() &&
			((this.adultLastName == null) || (this.adultLastName.length() == 0)))
			return false;
		if (this.checkAdultFirstName() &&
			((this.adultFirstName == null) || (this.adultFirstName.length() == 0)))
			return false;
  		if (this.checkAdultAddressStreetName() &&
			((this.adultAddressStreetName == null) || (this.adultAddressStreetName.length() == 0)))
			return false;
		if (this.checkAdultAddressPostalCode() &&
			((this.adultAddressPostalCode == null) || (this.adultAddressPostalCode.length() == 0)))
			return false;
		if (this.checkAdultAddressCity() &&
			((this.adultAddressCity == null) || (this.adultAddressCity.length() == 0)))
			return false;
		return true;
	}
	
	public void setAdultCfbn(String adultCfbn) {
		this.adultCfbn = adultCfbn;
	}
	
	public String getAdultCfbn() {
		return this.adultCfbn;
	}
	
	public boolean checkAdultCfbn() {
		return true;
	}

	public void setAdultBirthPlaceCity(String adultBirthPlaceCity) {
		this.adultBirthPlaceCity = adultBirthPlaceCity;
	}
	
	public String getAdultBirthPlaceCity() {
		return this.adultBirthPlaceCity;
	}
	
	public boolean checkAdultBirthPlaceCity() {
		return true;
	}

	public void setShowAccMan(boolean showAccMan) {
		this.showAccMan = showAccMan;
	}
	
	public boolean getShowAccMan() {
		return this.showAccMan;
	}
	
	public boolean checkShowAccMan() {
		return true;
	}

	public void setAdultFamilyStatus(String adultFamilyStatus) {
		this.adultFamilyStatus = adultFamilyStatus;
	}
	
	public String getAdultFamilyStatus() {
		return this.adultFamilyStatus;
	}
	
	public boolean checkAdultFamilyStatus() {
		return true;
	}

	public void setAdultBirthPlacePostalCode(String adultBirthPlacePostalCode) {
		this.adultBirthPlacePostalCode = adultBirthPlacePostalCode;
	}
	
	public String getAdultBirthPlacePostalCode() {
		return this.adultBirthPlacePostalCode;
	}
	
	public boolean checkAdultBirthPlacePostalCode() {
		return true;
	}

	public void setAdultBirthPlaceCountry(String adultBirthPlaceCountry) {
		this.adultBirthPlaceCountry = adultBirthPlaceCountry;
	}
	
	public String getAdultBirthPlaceCountry() {
		return this.adultBirthPlaceCountry;
	}
	
	public boolean checkAdultBirthPlaceCountry() {
		return true;
	}

	public void setAdultTitle(String adultTitle) {
		this.adultTitle = adultTitle;
	}
	
	public String getAdultTitle() {
		return this.adultTitle;
	}
	
	public boolean checkAdultTitle() {
		return true;
	}

	public void setAdultFirstName2(String adultFirstName2) {
		this.adultFirstName2 = adultFirstName2;
	}
	
	public String getAdultFirstName2() {
		return this.adultFirstName2;
	}
	
	public boolean checkAdultFirstName2() {
		return true;
	}

	public void setAdultOfficePhone(String adultOfficePhone) {
		this.adultOfficePhone = adultOfficePhone;
	}
	
	public String getAdultOfficePhone() {
		return this.adultOfficePhone;
	}
	
	public boolean checkAdultOfficePhone() {
		return true;
	}

	public void setAdultMobilePhone(String adultMobilePhone) {
		this.adultMobilePhone = adultMobilePhone;
	}
	
	public String getAdultMobilePhone() {
		return this.adultMobilePhone;
	}
	
	public boolean checkAdultMobilePhone() {
		return true;
	}

	public void setAdultBirthDate(Calendar adultBirthDate) {
		this.adultBirthDate = adultBirthDate;
	}
	
	public Calendar getAdultBirthDate() {
		return this.adultBirthDate;
	}
	
	public boolean checkAdultBirthDate() {
		return true;
	}

	public void setAdultMaidenName(String adultMaidenName) {
		this.adultMaidenName = adultMaidenName;
	}
	
	public String getAdultMaidenName() {
		return this.adultMaidenName;
	}
	
	public boolean checkAdultMaidenName() {
		return true;
	}

	public void setAdultFirstName3(String adultFirstName3) {
		this.adultFirstName3 = adultFirstName3;
	}
	
	public String getAdultFirstName3() {
		return this.adultFirstName3;
	}
	
	public boolean checkAdultFirstName3() {
		return true;
	}

	public void setAccountManager(boolean accountManager) {
		this.accountManager = accountManager;
	}
	
	public boolean getAccountManager() {
		return this.accountManager;
	}
	
	public boolean checkAccountManager() {
		return true;
	}

	public void setAdultEmail(String adultEmail) {
		this.adultEmail = adultEmail;
	}
	
	public String getAdultEmail() {
		return this.adultEmail;
	}
	
	public boolean checkAdultEmail() {
		return true;
	}

	public void setAdultId(long adultId) {
		this.adultId = adultId;
	}
	
	public long getAdultId() {
		return this.adultId;
	}
	
	public boolean checkAdultId() {
		return true;
	}

	public void setAdultLastName(String adultLastName) {
		this.adultLastName = adultLastName;
	}
	
	public String getAdultLastName() {
		return this.adultLastName;
	}
	
	public boolean checkAdultLastName() {
		return true;
	}

	public void setAdultFirstName(String adultFirstName) {
		this.adultFirstName = adultFirstName;
	}
	
	public String getAdultFirstName() {
		return this.adultFirstName;
	}
	
	public boolean checkAdultFirstName() {
		return true;
	}

	public void setAdultHomePhone(String adultHomePhone) {
		this.adultHomePhone = adultHomePhone;
	}
	
	public String getAdultHomePhone() {
		return this.adultHomePhone;
	}
	
	public boolean checkAdultHomePhone() {
		return true;
	}

  	public void setAdultAddressAdditionalDeliveryInformation(String adultAddressAdditionalDeliveryInformation) {
		this.adultAddressAdditionalDeliveryInformation = adultAddressAdditionalDeliveryInformation;
	}
	
	public String getAdultAddressAdditionalDeliveryInformation() {
		return this.adultAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkAdultAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setAdultAddressAdditionalGeographicalInformation(String adultAddressAdditionalGeographicalInformation) {
		this.adultAddressAdditionalGeographicalInformation = adultAddressAdditionalGeographicalInformation;
	}
	
	public String getAdultAddressAdditionalGeographicalInformation() {
		return this.adultAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkAdultAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setAdultAddressStreetNumber(String adultAddressStreetNumber) {
		this.adultAddressStreetNumber = adultAddressStreetNumber;
	}
	
	public String getAdultAddressStreetNumber() {
		return this.adultAddressStreetNumber;
	}
	
	public boolean checkAdultAddressStreetNumber() {
		return true;
	}

	public void setAdultAddressStreetName(String adultAddressStreetName) {
		this.adultAddressStreetName = adultAddressStreetName;
	}
	
	public String getAdultAddressStreetName() {
		return this.adultAddressStreetName;
	}
	
	public boolean checkAdultAddressStreetName() {
		return true;
	}

	public void setAdultAddressPlaceNameOrService(String adultAddressPlaceNameOrService) {
		this.adultAddressPlaceNameOrService = adultAddressPlaceNameOrService;
	}
	
	public String getAdultAddressPlaceNameOrService() {
		return this.adultAddressPlaceNameOrService;
	}
	
	public boolean checkAdultAddressPlaceNameOrService() {
		return true;
	}

	public void setAdultAddressPostalCode(String adultAddressPostalCode) {
		this.adultAddressPostalCode = adultAddressPostalCode;
	}
	
	public String getAdultAddressPostalCode() {
		return this.adultAddressPostalCode;
	}
	
	public boolean checkAdultAddressPostalCode() {
		return true;
	}

	public void setAdultAddressCity(String adultAddressCity) {
		this.adultAddressCity = adultAddressCity;
	}
	
	public String getAdultAddressCity() {
		return this.adultAddressCity;
	}
	
	public boolean checkAdultAddressCity() {
		return true;
	}

	public void setAdultProfession(String adultProfession) {
		this.adultProfession = adultProfession;
	}
	
	public String getAdultProfession() {
		return this.adultProfession;
	}
	
	public boolean checkAdultProfession() {
		return true;
	}

	public void setAdultNameOfUse(String adultNameOfUse) {
		this.adultNameOfUse = adultNameOfUse;
	}
	
	public String getAdultNameOfUse() {
		return this.adultNameOfUse;
	}
	
	public boolean checkAdultNameOfUse() {
		return true;
	}

}
