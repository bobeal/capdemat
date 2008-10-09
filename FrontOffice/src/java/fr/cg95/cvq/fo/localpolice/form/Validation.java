package fr.cg95.cvq.fo.localpolice.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.localpolice.*;
import fr.cg95.cvq.xml.localpolice.HolidaySecurityRequestDocument.HolidaySecurityRequest;

public class Validation extends IStageForm {

  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String subjectAdultMobilePhone;
	private String alertPhone;
	private String otherContactLastName;
	private Calendar absenceEndDate;
	private boolean alarm;
	private boolean rulesAndRegulationsAcceptance;
  	private String otherContactAddressAdditionalDeliveryInformation;
	private String otherContactAddressAdditionalGeographicalInformation;
	private String otherContactAddressStreetNumber;
	private String otherContactAddressStreetName;
	private String otherContactAddressPlaceNameOrService;
	private String otherContactAddressPostalCode;
	private String otherContactAddressCity;
	private Calendar absenceStartDate;
	private String otherContactFirstName;
	private String otherContactPhone;
	private String subjectAdultEmail;
	private boolean light;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
  			this.subjectAdultAddressAdditionalDeliveryInformation = request.getSubject().getAdult().getAddress().getAdditionalDeliveryInformation();
			this.subjectAdultAddressAdditionalGeographicalInformation = request.getSubject().getAdult().getAddress().getAdditionalGeographicalInformation();
			this.subjectAdultAddressStreetNumber = request.getSubject().getAdult().getAddress().getStreetNumber();
			this.subjectAdultAddressStreetName = request.getSubject().getAdult().getAddress().getStreetName();
			this.subjectAdultAddressPlaceNameOrService = request.getSubject().getAdult().getAddress().getPlaceNameOrService();
			this.subjectAdultAddressPostalCode = request.getSubject().getAdult().getAddress().getPostalCode();
			this.subjectAdultAddressCity = request.getSubject().getAdult().getAddress().getCity();
			this.subjectAdultMobilePhone = request.getSubject().getAdult().getMobilePhone();
			this.alertPhone = request.getAlertPhone();
			this.otherContactLastName = request.getOtherContactLastName();
			this.absenceEndDate = request.getAbsenceEndDate();
			this.alarm = request.getAlarm();
			this.rulesAndRegulationsAcceptance = request.getRulesAndRegulationsAcceptance();
  			this.otherContactAddressAdditionalDeliveryInformation = request.getOtherContactAddress().getAdditionalDeliveryInformation();
			this.otherContactAddressAdditionalGeographicalInformation = request.getOtherContactAddress().getAdditionalGeographicalInformation();
			this.otherContactAddressStreetNumber = request.getOtherContactAddress().getStreetNumber();
			this.otherContactAddressStreetName = request.getOtherContactAddress().getStreetName();
			this.otherContactAddressPlaceNameOrService = request.getOtherContactAddress().getPlaceNameOrService();
			this.otherContactAddressPostalCode = request.getOtherContactAddress().getPostalCode();
			this.otherContactAddressCity = request.getOtherContactAddress().getCity();
			this.absenceStartDate = request.getAbsenceStartDate();
			this.otherContactFirstName = request.getOtherContactFirstName();
			this.otherContactPhone = request.getOtherContactPhone();
			this.subjectAdultEmail = request.getSubject().getAdult().getEmail();
			this.light = request.getLight();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HolidaySecurityRequest)) {
			HolidaySecurityRequest request = (HolidaySecurityRequest)xmlbRequest;
  			request.getSubject().getAdult().getAddress().setAdditionalDeliveryInformation(this.subjectAdultAddressAdditionalDeliveryInformation);
			request.getSubject().getAdult().getAddress().setAdditionalGeographicalInformation(this.subjectAdultAddressAdditionalGeographicalInformation);
			request.getSubject().getAdult().getAddress().setStreetNumber(this.subjectAdultAddressStreetNumber);
			request.getSubject().getAdult().getAddress().setStreetName(this.subjectAdultAddressStreetName);
			request.getSubject().getAdult().getAddress().setPlaceNameOrService(this.subjectAdultAddressPlaceNameOrService);
			request.getSubject().getAdult().getAddress().setPostalCode(this.subjectAdultAddressPostalCode);
			request.getSubject().getAdult().getAddress().setCity(this.subjectAdultAddressCity);
			request.getSubject().getAdult().setMobilePhone(this.subjectAdultMobilePhone);
			request.setAlertPhone(this.alertPhone);
			request.setOtherContactLastName(this.otherContactLastName);
			request.setAbsenceEndDate(this.absenceEndDate);
			request.setAlarm(this.alarm);
			request.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance);
  			request.getOtherContactAddress().setAdditionalDeliveryInformation(this.otherContactAddressAdditionalDeliveryInformation);
			request.getOtherContactAddress().setAdditionalGeographicalInformation(this.otherContactAddressAdditionalGeographicalInformation);
			request.getOtherContactAddress().setStreetNumber(this.otherContactAddressStreetNumber);
			request.getOtherContactAddress().setStreetName(this.otherContactAddressStreetName);
			request.getOtherContactAddress().setPlaceNameOrService(this.otherContactAddressPlaceNameOrService);
			request.getOtherContactAddress().setPostalCode(this.otherContactAddressPostalCode);
			request.getOtherContactAddress().setCity(this.otherContactAddressCity);
			request.setAbsenceStartDate(this.absenceStartDate);
			request.setOtherContactFirstName(this.otherContactFirstName);
			request.setOtherContactPhone(this.otherContactPhone);
			request.getSubject().getAdult().setEmail(this.subjectAdultEmail);
			request.setLight(this.light);
		}
	}
	
	public boolean isComplete() {
  		if (this.checkSubjectAdultAddressStreetName() &&
			((this.subjectAdultAddressStreetName == null) || (this.subjectAdultAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectAdultAddressPostalCode() &&
			((this.subjectAdultAddressPostalCode == null) || (this.subjectAdultAddressPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectAdultAddressCity() &&
			((this.subjectAdultAddressCity == null) || (this.subjectAdultAddressCity.length() == 0)))
			return false;
		if (this.checkAlertPhone() &&
			((this.alertPhone == null) || (this.alertPhone.length() == 0)))
			return false;
		if (this.checkOtherContactLastName() &&
			((this.otherContactLastName == null) || (this.otherContactLastName.length() == 0)))
			return false;
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
		if (this.checkSubjectAdultEmail() &&
			((this.subjectAdultEmail == null) || (this.subjectAdultEmail.length() == 0)))
			return false;
		return true;
	}
	
  	public void setSubjectAdultAddressAdditionalDeliveryInformation(String subjectAdultAddressAdditionalDeliveryInformation) {
		this.subjectAdultAddressAdditionalDeliveryInformation = subjectAdultAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectAdultAddressAdditionalDeliveryInformation() {
		return this.subjectAdultAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkSubjectAdultAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setSubjectAdultAddressAdditionalGeographicalInformation(String subjectAdultAddressAdditionalGeographicalInformation) {
		this.subjectAdultAddressAdditionalGeographicalInformation = subjectAdultAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectAdultAddressAdditionalGeographicalInformation() {
		return this.subjectAdultAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkSubjectAdultAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setSubjectAdultAddressStreetNumber(String subjectAdultAddressStreetNumber) {
		this.subjectAdultAddressStreetNumber = subjectAdultAddressStreetNumber;
	}
	
	public String getSubjectAdultAddressStreetNumber() {
		return this.subjectAdultAddressStreetNumber;
	}
	
	public boolean checkSubjectAdultAddressStreetNumber() {
		return true;
	}

	public void setSubjectAdultAddressStreetName(String subjectAdultAddressStreetName) {
		this.subjectAdultAddressStreetName = subjectAdultAddressStreetName;
	}
	
	public String getSubjectAdultAddressStreetName() {
		return this.subjectAdultAddressStreetName;
	}
	
	public boolean checkSubjectAdultAddressStreetName() {
		return true;
	}

	public void setSubjectAdultAddressPlaceNameOrService(String subjectAdultAddressPlaceNameOrService) {
		this.subjectAdultAddressPlaceNameOrService = subjectAdultAddressPlaceNameOrService;
	}
	
	public String getSubjectAdultAddressPlaceNameOrService() {
		return this.subjectAdultAddressPlaceNameOrService;
	}
	
	public boolean checkSubjectAdultAddressPlaceNameOrService() {
		return true;
	}

	public void setSubjectAdultAddressPostalCode(String subjectAdultAddressPostalCode) {
		this.subjectAdultAddressPostalCode = subjectAdultAddressPostalCode;
	}
	
	public String getSubjectAdultAddressPostalCode() {
		return this.subjectAdultAddressPostalCode;
	}
	
	public boolean checkSubjectAdultAddressPostalCode() {
		return true;
	}

	public void setSubjectAdultAddressCity(String subjectAdultAddressCity) {
		this.subjectAdultAddressCity = subjectAdultAddressCity;
	}
	
	public String getSubjectAdultAddressCity() {
		return this.subjectAdultAddressCity;
	}
	
	public boolean checkSubjectAdultAddressCity() {
		return true;
	}

	public void setSubjectAdultMobilePhone(String subjectAdultMobilePhone) {
		this.subjectAdultMobilePhone = subjectAdultMobilePhone;
	}
	
	public String getSubjectAdultMobilePhone() {
		return this.subjectAdultMobilePhone;
	}
	
	public boolean checkSubjectAdultMobilePhone() {
		return true;
	}

	public void setAlertPhone(String alertPhone) {
		this.alertPhone = alertPhone;
	}
	
	public String getAlertPhone() {
		return this.alertPhone;
	}
	
	public boolean checkAlertPhone() {
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

	public void setAbsenceEndDate(Calendar absenceEndDate) {
		this.absenceEndDate = absenceEndDate;
	}
	
	public Calendar getAbsenceEndDate() {
		return this.absenceEndDate;
	}
	
	public boolean checkAbsenceEndDate() {
		return true;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	
	public boolean getAlarm() {
		return this.alarm;
	}
	
	public boolean checkAlarm() {
		return true;
	}

	public void setRulesAndRegulationsAcceptance(boolean rulesAndRegulationsAcceptance) {
		this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
	}
	
	public boolean getRulesAndRegulationsAcceptance() {
		return this.rulesAndRegulationsAcceptance;
	}
	
	public boolean checkRulesAndRegulationsAcceptance() {
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

	public void setAbsenceStartDate(Calendar absenceStartDate) {
		this.absenceStartDate = absenceStartDate;
	}
	
	public Calendar getAbsenceStartDate() {
		return this.absenceStartDate;
	}
	
	public boolean checkAbsenceStartDate() {
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

	public void setSubjectAdultEmail(String subjectAdultEmail) {
		this.subjectAdultEmail = subjectAdultEmail;
	}
	
	public String getSubjectAdultEmail() {
		return this.subjectAdultEmail;
	}
	
	public boolean checkSubjectAdultEmail() {
		return true;
	}

	public void setLight(boolean light) {
		this.light = light;
	}
	
	public boolean getLight() {
		return this.light;
	}
	
	public boolean checkLight() {
		return true;
	}

}
