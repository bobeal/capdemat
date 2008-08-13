package fr.cg95.cvq.fo.technical.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.technical.*;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument.TechnicalInterventionRequest;

public class Subject extends IStageForm {

	private String subjectAdultHomePhone;
	private String subjectAdultEmail;
	private String subjectAdultMobilePhone;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String subjectAdultLastName;
	private String subjectAdultFirstName;

	public Subject() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("subject")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			this.subjectAdultHomePhone = request.getSubject().getAdult().getHomePhone();
			this.subjectAdultEmail = request.getSubject().getAdult().getEmail();
			this.subjectAdultMobilePhone = request.getSubject().getAdult().getMobilePhone();
  			this.subjectAdultAddressAdditionalDeliveryInformation = request.getSubject().getAdult().getAddress().getAdditionalDeliveryInformation();
			this.subjectAdultAddressAdditionalGeographicalInformation = request.getSubject().getAdult().getAddress().getAdditionalGeographicalInformation();
			this.subjectAdultAddressStreetNumber = request.getSubject().getAdult().getAddress().getStreetNumber();
			this.subjectAdultAddressStreetName = request.getSubject().getAdult().getAddress().getStreetName();
			this.subjectAdultAddressPlaceNameOrService = request.getSubject().getAdult().getAddress().getPlaceNameOrService();
			this.subjectAdultAddressPostalCode = request.getSubject().getAdult().getAddress().getPostalCode();
			this.subjectAdultAddressCity = request.getSubject().getAdult().getAddress().getCity();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			request.getSubject().getAdult().setHomePhone(this.subjectAdultHomePhone);
			request.getSubject().getAdult().setEmail(this.subjectAdultEmail);
			request.getSubject().getAdult().setMobilePhone(this.subjectAdultMobilePhone);
  			request.getSubject().getAdult().getAddress().setAdditionalDeliveryInformation(this.subjectAdultAddressAdditionalDeliveryInformation);
			request.getSubject().getAdult().getAddress().setAdditionalGeographicalInformation(this.subjectAdultAddressAdditionalGeographicalInformation);
			request.getSubject().getAdult().getAddress().setStreetNumber(this.subjectAdultAddressStreetNumber);
			request.getSubject().getAdult().getAddress().setStreetName(this.subjectAdultAddressStreetName);
			request.getSubject().getAdult().getAddress().setPlaceNameOrService(this.subjectAdultAddressPlaceNameOrService);
			request.getSubject().getAdult().getAddress().setPostalCode(this.subjectAdultAddressPostalCode);
			request.getSubject().getAdult().getAddress().setCity(this.subjectAdultAddressCity);
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectAdultHomePhone() &&
			((this.subjectAdultHomePhone == null) || (this.subjectAdultHomePhone.length() == 0)))
			return false;
		if (this.checkSubjectAdultEmail() &&
			((this.subjectAdultEmail == null) || (this.subjectAdultEmail.length() == 0)))
			return false;
  		if (this.checkSubjectAdultAddressStreetName() &&
			((this.subjectAdultAddressStreetName == null) || (this.subjectAdultAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectAdultAddressPostalCode() &&
			((this.subjectAdultAddressPostalCode == null) || (this.subjectAdultAddressPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectAdultAddressCity() &&
			((this.subjectAdultAddressCity == null) || (this.subjectAdultAddressCity.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
			return false;
		return true;
	}
	
	public void setSubjectAdultHomePhone(String subjectAdultHomePhone) {
		this.subjectAdultHomePhone = subjectAdultHomePhone;
	}
	
	public String getSubjectAdultHomePhone() {
		return this.subjectAdultHomePhone;
	}
	
	public boolean checkSubjectAdultHomePhone() {
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

	public void setSubjectAdultMobilePhone(String subjectAdultMobilePhone) {
		this.subjectAdultMobilePhone = subjectAdultMobilePhone;
	}
	
	public String getSubjectAdultMobilePhone() {
		return this.subjectAdultMobilePhone;
	}
	
	public boolean checkSubjectAdultMobilePhone() {
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

	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}
	
	public boolean checkSubjectAdultLastName() {
		return true;
	}

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}
	
	public boolean checkSubjectAdultFirstName() {
		return true;
	}

}
