package fr.cg95.cvq.fo.citizen.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.ecitizen.*;
import fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest;

public class Responsible extends IStageForm {

	private String childLegalResponsibleLegalResponsibleNameOfUse;
	private String childLegalResponsibleRole;
	private String childLegalResponsibleLegalResponsibleEmail;
	private String childLegalResponsibleLegalResponsibleMobilePhone;
	private String childLegalResponsibleLegalResponsibleBirthPlaceCity;
	private String childLegalResponsibleLegalResponsibleTitle;
	private String childLegalResponsibleLegalResponsibleHomePhone;
	private String childLegalResponsibleLegalResponsibleMaidenName;
	private String childLegalResponsibleLegalResponsibleBirthPlacePostalCode;
	private String childLegalResponsibleLegalResponsibleFirstName2;
	private String childLegalResponsibleLegalResponsibleProfession;
  	private String childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation;
	private String childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation;
	private String childLegalResponsibleLegalResponsibleAddressStreetNumber;
	private String childLegalResponsibleLegalResponsibleAddressStreetName;
	private String childLegalResponsibleLegalResponsibleAddressPlaceNameOrService;
	private String childLegalResponsibleLegalResponsibleAddressPostalCode;
	private String childLegalResponsibleLegalResponsibleAddressCity;
	private String childLegalResponsibleLegalResponsibleFamilyStatus;
	private String childLegalResponsibleLegalResponsibleBirthPlaceCountry;
	private long childLegalResponsibleLegalResponsibleId;
	private String childLegalResponsibleLegalResponsibleFirstName3;
	private String childLegalResponsibleLegalResponsibleLastName;
	private String childLegalResponsibleLegalResponsibleFirstName;
	private Calendar childLegalResponsibleLegalResponsibleBirthDate;
	private String childLegalResponsibleLegalResponsibleCfbn;
	private String childLegalResponsibleLegalResponsibleOfficePhone;

	public Responsible() {
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
		if (this.checkChildLegalResponsibleRole() &&
			((this.childLegalResponsibleRole == null) || (this.childLegalResponsibleRole.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleEmail() &&
			((this.childLegalResponsibleLegalResponsibleEmail == null) || (this.childLegalResponsibleLegalResponsibleEmail.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleTitle() &&
			((this.childLegalResponsibleLegalResponsibleTitle == null) || (this.childLegalResponsibleLegalResponsibleTitle.length() == 0)))
			return false;
  		if (this.checkChildLegalResponsibleLegalResponsibleAddressStreetName() &&
			((this.childLegalResponsibleLegalResponsibleAddressStreetName == null) || (this.childLegalResponsibleLegalResponsibleAddressStreetName.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleAddressPostalCode() &&
			((this.childLegalResponsibleLegalResponsibleAddressPostalCode == null) || (this.childLegalResponsibleLegalResponsibleAddressPostalCode.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleAddressCity() &&
			((this.childLegalResponsibleLegalResponsibleAddressCity == null) || (this.childLegalResponsibleLegalResponsibleAddressCity.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleFamilyStatus() &&
			((this.childLegalResponsibleLegalResponsibleFamilyStatus == null) || (this.childLegalResponsibleLegalResponsibleFamilyStatus.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleLastName() &&
			((this.childLegalResponsibleLegalResponsibleLastName == null) || (this.childLegalResponsibleLegalResponsibleLastName.length() == 0)))
			return false;
		if (this.checkChildLegalResponsibleLegalResponsibleFirstName() &&
			((this.childLegalResponsibleLegalResponsibleFirstName == null) || (this.childLegalResponsibleLegalResponsibleFirstName.length() == 0)))
			return false;
		return true;
	}
	
	public void setChildLegalResponsibleLegalResponsibleNameOfUse(String childLegalResponsibleLegalResponsibleNameOfUse) {
		this.childLegalResponsibleLegalResponsibleNameOfUse = childLegalResponsibleLegalResponsibleNameOfUse;
	}
	
	public String getChildLegalResponsibleLegalResponsibleNameOfUse() {
		return this.childLegalResponsibleLegalResponsibleNameOfUse;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleNameOfUse() {
		return true;
	}

	public void setChildLegalResponsibleRole(String childLegalResponsibleRole) {
		this.childLegalResponsibleRole = childLegalResponsibleRole;
	}
	
	public String getChildLegalResponsibleRole() {
		return this.childLegalResponsibleRole;
	}
	
	public boolean checkChildLegalResponsibleRole() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleEmail(String childLegalResponsibleLegalResponsibleEmail) {
		this.childLegalResponsibleLegalResponsibleEmail = childLegalResponsibleLegalResponsibleEmail;
	}
	
	public String getChildLegalResponsibleLegalResponsibleEmail() {
		return this.childLegalResponsibleLegalResponsibleEmail;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleEmail() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleMobilePhone(String childLegalResponsibleLegalResponsibleMobilePhone) {
		this.childLegalResponsibleLegalResponsibleMobilePhone = childLegalResponsibleLegalResponsibleMobilePhone;
	}
	
	public String getChildLegalResponsibleLegalResponsibleMobilePhone() {
		return this.childLegalResponsibleLegalResponsibleMobilePhone;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleMobilePhone() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleBirthPlaceCity(String childLegalResponsibleLegalResponsibleBirthPlaceCity) {
		this.childLegalResponsibleLegalResponsibleBirthPlaceCity = childLegalResponsibleLegalResponsibleBirthPlaceCity;
	}
	
	public String getChildLegalResponsibleLegalResponsibleBirthPlaceCity() {
		return this.childLegalResponsibleLegalResponsibleBirthPlaceCity;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleBirthPlaceCity() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleTitle(String childLegalResponsibleLegalResponsibleTitle) {
		this.childLegalResponsibleLegalResponsibleTitle = childLegalResponsibleLegalResponsibleTitle;
	}
	
	public String getChildLegalResponsibleLegalResponsibleTitle() {
		return this.childLegalResponsibleLegalResponsibleTitle;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleTitle() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleHomePhone(String childLegalResponsibleLegalResponsibleHomePhone) {
		this.childLegalResponsibleLegalResponsibleHomePhone = childLegalResponsibleLegalResponsibleHomePhone;
	}
	
	public String getChildLegalResponsibleLegalResponsibleHomePhone() {
		return this.childLegalResponsibleLegalResponsibleHomePhone;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleHomePhone() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleMaidenName(String childLegalResponsibleLegalResponsibleMaidenName) {
		this.childLegalResponsibleLegalResponsibleMaidenName = childLegalResponsibleLegalResponsibleMaidenName;
	}
	
	public String getChildLegalResponsibleLegalResponsibleMaidenName() {
		return this.childLegalResponsibleLegalResponsibleMaidenName;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleMaidenName() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleBirthPlacePostalCode(String childLegalResponsibleLegalResponsibleBirthPlacePostalCode) {
		this.childLegalResponsibleLegalResponsibleBirthPlacePostalCode = childLegalResponsibleLegalResponsibleBirthPlacePostalCode;
	}
	
	public String getChildLegalResponsibleLegalResponsibleBirthPlacePostalCode() {
		return this.childLegalResponsibleLegalResponsibleBirthPlacePostalCode;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleBirthPlacePostalCode() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleFirstName2(String childLegalResponsibleLegalResponsibleFirstName2) {
		this.childLegalResponsibleLegalResponsibleFirstName2 = childLegalResponsibleLegalResponsibleFirstName2;
	}
	
	public String getChildLegalResponsibleLegalResponsibleFirstName2() {
		return this.childLegalResponsibleLegalResponsibleFirstName2;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleFirstName2() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleProfession(String childLegalResponsibleLegalResponsibleProfession) {
		this.childLegalResponsibleLegalResponsibleProfession = childLegalResponsibleLegalResponsibleProfession;
	}
	
	public String getChildLegalResponsibleLegalResponsibleProfession() {
		return this.childLegalResponsibleLegalResponsibleProfession;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleProfession() {
		return true;
	}

  	public void setChildLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation(String childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation) {
		this.childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation = childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation() {
		return this.childLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation(String childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation) {
		this.childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation = childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation() {
		return this.childLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleAddressStreetNumber(String childLegalResponsibleLegalResponsibleAddressStreetNumber) {
		this.childLegalResponsibleLegalResponsibleAddressStreetNumber = childLegalResponsibleLegalResponsibleAddressStreetNumber;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressStreetNumber() {
		return this.childLegalResponsibleLegalResponsibleAddressStreetNumber;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressStreetNumber() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleAddressStreetName(String childLegalResponsibleLegalResponsibleAddressStreetName) {
		this.childLegalResponsibleLegalResponsibleAddressStreetName = childLegalResponsibleLegalResponsibleAddressStreetName;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressStreetName() {
		return this.childLegalResponsibleLegalResponsibleAddressStreetName;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressStreetName() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleAddressPlaceNameOrService(String childLegalResponsibleLegalResponsibleAddressPlaceNameOrService) {
		this.childLegalResponsibleLegalResponsibleAddressPlaceNameOrService = childLegalResponsibleLegalResponsibleAddressPlaceNameOrService;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressPlaceNameOrService() {
		return this.childLegalResponsibleLegalResponsibleAddressPlaceNameOrService;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressPlaceNameOrService() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleAddressPostalCode(String childLegalResponsibleLegalResponsibleAddressPostalCode) {
		this.childLegalResponsibleLegalResponsibleAddressPostalCode = childLegalResponsibleLegalResponsibleAddressPostalCode;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressPostalCode() {
		return this.childLegalResponsibleLegalResponsibleAddressPostalCode;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressPostalCode() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleAddressCity(String childLegalResponsibleLegalResponsibleAddressCity) {
		this.childLegalResponsibleLegalResponsibleAddressCity = childLegalResponsibleLegalResponsibleAddressCity;
	}
	
	public String getChildLegalResponsibleLegalResponsibleAddressCity() {
		return this.childLegalResponsibleLegalResponsibleAddressCity;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleAddressCity() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleFamilyStatus(String childLegalResponsibleLegalResponsibleFamilyStatus) {
		this.childLegalResponsibleLegalResponsibleFamilyStatus = childLegalResponsibleLegalResponsibleFamilyStatus;
	}
	
	public String getChildLegalResponsibleLegalResponsibleFamilyStatus() {
		return this.childLegalResponsibleLegalResponsibleFamilyStatus;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleFamilyStatus() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleBirthPlaceCountry(String childLegalResponsibleLegalResponsibleBirthPlaceCountry) {
		this.childLegalResponsibleLegalResponsibleBirthPlaceCountry = childLegalResponsibleLegalResponsibleBirthPlaceCountry;
	}
	
	public String getChildLegalResponsibleLegalResponsibleBirthPlaceCountry() {
		return this.childLegalResponsibleLegalResponsibleBirthPlaceCountry;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleBirthPlaceCountry() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleId(long childLegalResponsibleLegalResponsibleId) {
		this.childLegalResponsibleLegalResponsibleId = childLegalResponsibleLegalResponsibleId;
	}
	
	public long getChildLegalResponsibleLegalResponsibleId() {
		return this.childLegalResponsibleLegalResponsibleId;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleId() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleFirstName3(String childLegalResponsibleLegalResponsibleFirstName3) {
		this.childLegalResponsibleLegalResponsibleFirstName3 = childLegalResponsibleLegalResponsibleFirstName3;
	}
	
	public String getChildLegalResponsibleLegalResponsibleFirstName3() {
		return this.childLegalResponsibleLegalResponsibleFirstName3;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleFirstName3() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleLastName(String childLegalResponsibleLegalResponsibleLastName) {
		this.childLegalResponsibleLegalResponsibleLastName = childLegalResponsibleLegalResponsibleLastName;
	}
	
	public String getChildLegalResponsibleLegalResponsibleLastName() {
		return this.childLegalResponsibleLegalResponsibleLastName;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleLastName() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleFirstName(String childLegalResponsibleLegalResponsibleFirstName) {
		this.childLegalResponsibleLegalResponsibleFirstName = childLegalResponsibleLegalResponsibleFirstName;
	}
	
	public String getChildLegalResponsibleLegalResponsibleFirstName() {
		return this.childLegalResponsibleLegalResponsibleFirstName;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleFirstName() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleBirthDate(Calendar childLegalResponsibleLegalResponsibleBirthDate) {
		this.childLegalResponsibleLegalResponsibleBirthDate = childLegalResponsibleLegalResponsibleBirthDate;
	}
	
	public Calendar getChildLegalResponsibleLegalResponsibleBirthDate() {
		return this.childLegalResponsibleLegalResponsibleBirthDate;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleBirthDate() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleCfbn(String childLegalResponsibleLegalResponsibleCfbn) {
		this.childLegalResponsibleLegalResponsibleCfbn = childLegalResponsibleLegalResponsibleCfbn;
	}
	
	public String getChildLegalResponsibleLegalResponsibleCfbn() {
		return this.childLegalResponsibleLegalResponsibleCfbn;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleCfbn() {
		return true;
	}

	public void setChildLegalResponsibleLegalResponsibleOfficePhone(String childLegalResponsibleLegalResponsibleOfficePhone) {
		this.childLegalResponsibleLegalResponsibleOfficePhone = childLegalResponsibleLegalResponsibleOfficePhone;
	}
	
	public String getChildLegalResponsibleLegalResponsibleOfficePhone() {
		return this.childLegalResponsibleLegalResponsibleOfficePhone;
	}
	
	public boolean checkChildLegalResponsibleLegalResponsibleOfficePhone() {
		return true;
	}

}
