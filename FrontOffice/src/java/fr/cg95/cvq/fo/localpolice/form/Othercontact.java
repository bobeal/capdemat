package fr.cg95.cvq.fo.localpolice.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.localpolice.*;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class Othercontact extends IStageForm {

  	private String otherContactAddressAdditionalDeliveryInformation;
	private String otherContactAddressAdditionalGeographicalInformation;
	private String otherContactAddressStreetNumber;
	private String otherContactAddressStreetName;
	private String otherContactAddressPlaceNameOrService;
	private String otherContactAddressPostalCode;
	private String otherContactAddressCity;
	private String otherContactFirstName;
	private String otherContactPhone;
	private String otherContactLastName;

	public Othercontact() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("othercontact")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
  			this.otherContactAddressAdditionalDeliveryInformation = request.getOtherContactAddress().getAdditionalDeliveryInformation();
			this.otherContactAddressAdditionalGeographicalInformation = request.getOtherContactAddress().getAdditionalGeographicalInformation();
			this.otherContactAddressStreetNumber = request.getOtherContactAddress().getStreetNumber();
			this.otherContactAddressStreetName = request.getOtherContactAddress().getStreetName();
			this.otherContactAddressPlaceNameOrService = request.getOtherContactAddress().getPlaceNameOrService();
			this.otherContactAddressPostalCode = request.getOtherContactAddress().getPostalCode();
			this.otherContactAddressCity = request.getOtherContactAddress().getCity();
			this.otherContactFirstName = request.getOtherContactFirstName();
			this.otherContactPhone = request.getOtherContactPhone();
			this.otherContactLastName = request.getOtherContactLastName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
  			request.getOtherContactAddress().setAdditionalDeliveryInformation(this.otherContactAddressAdditionalDeliveryInformation);
			request.getOtherContactAddress().setAdditionalGeographicalInformation(this.otherContactAddressAdditionalGeographicalInformation);
			request.getOtherContactAddress().setStreetNumber(this.otherContactAddressStreetNumber);
			request.getOtherContactAddress().setStreetName(this.otherContactAddressStreetName);
			request.getOtherContactAddress().setPlaceNameOrService(this.otherContactAddressPlaceNameOrService);
			request.getOtherContactAddress().setPostalCode(this.otherContactAddressPostalCode);
			request.getOtherContactAddress().setCity(this.otherContactAddressCity);
			request.setOtherContactFirstName(this.otherContactFirstName);
			request.setOtherContactPhone(this.otherContactPhone);
			request.setOtherContactLastName(this.otherContactLastName);
		}
	}
	
	public boolean isComplete() {
  		if (this.checkOtherContactAddressStreetName() &&
			((this.otherContactAddressStreetName == null) || (this.otherContactAddressStreetName.length() == 0)))
			return false;
		if (this.checkOtherContactAddressPostalCode() &&
			((this.otherContactAddressPostalCode == null) || (this.otherContactAddressPostalCode.length() == 0)))
			return false;
		if (this.checkOtherContactAddressCity() &&
			((this.otherContactAddressCity == null) || (this.otherContactAddressCity.length() == 0)))
			return false;
		if (this.checkOtherContactFirstName() &&
			((this.otherContactFirstName == null) || (this.otherContactFirstName.length() == 0)))
			return false;
		if (this.checkOtherContactPhone() &&
			((this.otherContactPhone == null) || (this.otherContactPhone.length() == 0)))
			return false;
		if (this.checkOtherContactLastName() &&
			((this.otherContactLastName == null) || (this.otherContactLastName.length() == 0)))
			return false;
		return true;
	}
	
  	public void setOtherContactAddressAdditionalDeliveryInformation(String otherContactAddressAdditionalDeliveryInformation) {
		this.otherContactAddressAdditionalDeliveryInformation = otherContactAddressAdditionalDeliveryInformation;
	}
	
	public String getOtherContactAddressAdditionalDeliveryInformation() {
		return this.otherContactAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkOtherContactAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setOtherContactAddressAdditionalGeographicalInformation(String otherContactAddressAdditionalGeographicalInformation) {
		this.otherContactAddressAdditionalGeographicalInformation = otherContactAddressAdditionalGeographicalInformation;
	}
	
	public String getOtherContactAddressAdditionalGeographicalInformation() {
		return this.otherContactAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkOtherContactAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setOtherContactAddressStreetNumber(String otherContactAddressStreetNumber) {
		this.otherContactAddressStreetNumber = otherContactAddressStreetNumber;
	}
	
	public String getOtherContactAddressStreetNumber() {
		return this.otherContactAddressStreetNumber;
	}
	
	public boolean checkOtherContactAddressStreetNumber() {
		return true;
	}

	public void setOtherContactAddressStreetName(String otherContactAddressStreetName) {
		this.otherContactAddressStreetName = otherContactAddressStreetName;
	}
	
	public String getOtherContactAddressStreetName() {
		return this.otherContactAddressStreetName;
	}
	
	public boolean checkOtherContactAddressStreetName() {
		return true;
	}

	public void setOtherContactAddressPlaceNameOrService(String otherContactAddressPlaceNameOrService) {
		this.otherContactAddressPlaceNameOrService = otherContactAddressPlaceNameOrService;
	}
	
	public String getOtherContactAddressPlaceNameOrService() {
		return this.otherContactAddressPlaceNameOrService;
	}
	
	public boolean checkOtherContactAddressPlaceNameOrService() {
		return true;
	}

	public void setOtherContactAddressPostalCode(String otherContactAddressPostalCode) {
		this.otherContactAddressPostalCode = otherContactAddressPostalCode;
	}
	
	public String getOtherContactAddressPostalCode() {
		return this.otherContactAddressPostalCode;
	}
	
	public boolean checkOtherContactAddressPostalCode() {
		return true;
	}

	public void setOtherContactAddressCity(String otherContactAddressCity) {
		this.otherContactAddressCity = otherContactAddressCity;
	}
	
	public String getOtherContactAddressCity() {
		return this.otherContactAddressCity;
	}
	
	public boolean checkOtherContactAddressCity() {
		return true;
	}

	public void setOtherContactFirstName(String otherContactFirstName) {
		this.otherContactFirstName = otherContactFirstName;
	}
	
	public String getOtherContactFirstName() {
		return this.otherContactFirstName;
	}
	
	public boolean checkOtherContactFirstName() {
		return true;
	}

	public void setOtherContactPhone(String otherContactPhone) {
		this.otherContactPhone = otherContactPhone;
	}
	
	public String getOtherContactPhone() {
		return this.otherContactPhone;
	}
	
	public boolean checkOtherContactPhone() {
		return true;
	}

	public void setOtherContactLastName(String otherContactLastName) {
		this.otherContactLastName = otherContactLastName;
	}
	
	public String getOtherContactLastName() {
		return this.otherContactLastName;
	}
	
	public boolean checkOtherContactLastName() {
		return true;
	}

}
