package fr.cg95.cvq.fo.technical.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.technical.*;
import fr.cg95.cvq.xml.technical.TechnicalInterventionRequestDocument.TechnicalInterventionRequest;

public class Validation extends IStageForm {

	private String interventionType;
  	private String interventionPlaceAdditionalDeliveryInformation;
	private String interventionPlaceAdditionalGeographicalInformation;
	private String interventionPlaceStreetNumber;
	private String interventionPlaceStreetName;
	private String interventionPlacePlaceNameOrService;
	private String interventionPlacePostalCode;
	private String interventionPlaceCity;
	private String subjectAdultEmail;
	private String subjectAdultMobilePhone;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String interventionDescription;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			this.interventionType = loadForm(this.interventionType,(Collection)session.getAttribute("InterventionType"),request.getInterventionTypeArray());
  			this.interventionPlaceAdditionalDeliveryInformation = request.getInterventionPlace().getAdditionalDeliveryInformation();
			this.interventionPlaceAdditionalGeographicalInformation = request.getInterventionPlace().getAdditionalGeographicalInformation();
			this.interventionPlaceStreetNumber = request.getInterventionPlace().getStreetNumber();
			this.interventionPlaceStreetName = request.getInterventionPlace().getStreetName();
			this.interventionPlacePlaceNameOrService = request.getInterventionPlace().getPlaceNameOrService();
			this.interventionPlacePostalCode = request.getInterventionPlace().getPostalCode();
			this.interventionPlaceCity = request.getInterventionPlace().getCity();
			this.subjectAdultEmail = request.getSubject().getAdult().getEmail();
			this.subjectAdultMobilePhone = request.getSubject().getAdult().getMobilePhone();
  			this.subjectAdultAddressAdditionalDeliveryInformation = request.getSubject().getAdult().getAddress().getAdditionalDeliveryInformation();
			this.subjectAdultAddressAdditionalGeographicalInformation = request.getSubject().getAdult().getAddress().getAdditionalGeographicalInformation();
			this.subjectAdultAddressStreetNumber = request.getSubject().getAdult().getAddress().getStreetNumber();
			this.subjectAdultAddressStreetName = request.getSubject().getAdult().getAddress().getStreetName();
			this.subjectAdultAddressPlaceNameOrService = request.getSubject().getAdult().getAddress().getPlaceNameOrService();
			this.subjectAdultAddressPostalCode = request.getSubject().getAdult().getAddress().getPostalCode();
			this.subjectAdultAddressCity = request.getSubject().getAdult().getAddress().getCity();
			this.interventionDescription = request.getInterventionDescription();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof TechnicalInterventionRequest)) {
			TechnicalInterventionRequest request = (TechnicalInterventionRequest)xmlbRequest;
			request.setInterventionTypeArray(saveForm(this.interventionType,(Collection)session.getAttribute("InterventionType")));
  			request.getInterventionPlace().setAdditionalDeliveryInformation(this.interventionPlaceAdditionalDeliveryInformation);
			request.getInterventionPlace().setAdditionalGeographicalInformation(this.interventionPlaceAdditionalGeographicalInformation);
			request.getInterventionPlace().setStreetNumber(this.interventionPlaceStreetNumber);
			request.getInterventionPlace().setStreetName(this.interventionPlaceStreetName);
			request.getInterventionPlace().setPlaceNameOrService(this.interventionPlacePlaceNameOrService);
			request.getInterventionPlace().setPostalCode(this.interventionPlacePostalCode);
			request.getInterventionPlace().setCity(this.interventionPlaceCity);
			request.getSubject().getAdult().setEmail(this.subjectAdultEmail);
			request.getSubject().getAdult().setMobilePhone(this.subjectAdultMobilePhone);
  			request.getSubject().getAdult().getAddress().setAdditionalDeliveryInformation(this.subjectAdultAddressAdditionalDeliveryInformation);
			request.getSubject().getAdult().getAddress().setAdditionalGeographicalInformation(this.subjectAdultAddressAdditionalGeographicalInformation);
			request.getSubject().getAdult().getAddress().setStreetNumber(this.subjectAdultAddressStreetNumber);
			request.getSubject().getAdult().getAddress().setStreetName(this.subjectAdultAddressStreetName);
			request.getSubject().getAdult().getAddress().setPlaceNameOrService(this.subjectAdultAddressPlaceNameOrService);
			request.getSubject().getAdult().getAddress().setPostalCode(this.subjectAdultAddressPostalCode);
			request.getSubject().getAdult().getAddress().setCity(this.subjectAdultAddressCity);
			request.setInterventionDescription(this.interventionDescription);
		}
	}
	
	public boolean isComplete() {
		if (this.checkInterventionType() &&
			((this.interventionType == null) || (this.interventionType.length() == 0)))
			return false;
  		if (this.checkInterventionPlaceStreetName() &&
			((this.interventionPlaceStreetName == null) || (this.interventionPlaceStreetName.length() == 0)))
			return false;
		if (this.checkInterventionPlacePostalCode() &&
			((this.interventionPlacePostalCode == null) || (this.interventionPlacePostalCode.length() == 0)))
			return false;
		if (this.checkInterventionPlaceCity() &&
			((this.interventionPlaceCity == null) || (this.interventionPlaceCity.length() == 0)))
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
		if (this.checkInterventionDescription() &&
			((this.interventionDescription == null) || (this.interventionDescription.length() == 0)))
			return false;
		return true;
	}
	
	public void setInterventionType(String interventionType) {
		this.interventionType = interventionType;
	}
	
	public String getInterventionType() {
		return this.interventionType;
	}
	
	public boolean checkInterventionType() {
		return true;
	}

  	public void setInterventionPlaceAdditionalDeliveryInformation(String interventionPlaceAdditionalDeliveryInformation) {
		this.interventionPlaceAdditionalDeliveryInformation = interventionPlaceAdditionalDeliveryInformation;
	}
	
	public String getInterventionPlaceAdditionalDeliveryInformation() {
		return this.interventionPlaceAdditionalDeliveryInformation;
	}
	
	public boolean checkInterventionPlaceAdditionalDeliveryInformation() {
		return true;
	}

	public void setInterventionPlaceAdditionalGeographicalInformation(String interventionPlaceAdditionalGeographicalInformation) {
		this.interventionPlaceAdditionalGeographicalInformation = interventionPlaceAdditionalGeographicalInformation;
	}
	
	public String getInterventionPlaceAdditionalGeographicalInformation() {
		return this.interventionPlaceAdditionalGeographicalInformation;
	}
	
	public boolean checkInterventionPlaceAdditionalGeographicalInformation() {
		return true;
	}

	public void setInterventionPlaceStreetNumber(String interventionPlaceStreetNumber) {
		this.interventionPlaceStreetNumber = interventionPlaceStreetNumber;
	}
	
	public String getInterventionPlaceStreetNumber() {
		return this.interventionPlaceStreetNumber;
	}
	
	public boolean checkInterventionPlaceStreetNumber() {
		return true;
	}

	public void setInterventionPlaceStreetName(String interventionPlaceStreetName) {
		this.interventionPlaceStreetName = interventionPlaceStreetName;
	}
	
	public String getInterventionPlaceStreetName() {
		return this.interventionPlaceStreetName;
	}
	
	public boolean checkInterventionPlaceStreetName() {
		return true;
	}

	public void setInterventionPlacePlaceNameOrService(String interventionPlacePlaceNameOrService) {
		this.interventionPlacePlaceNameOrService = interventionPlacePlaceNameOrService;
	}
	
	public String getInterventionPlacePlaceNameOrService() {
		return this.interventionPlacePlaceNameOrService;
	}
	
	public boolean checkInterventionPlacePlaceNameOrService() {
		return true;
	}

	public void setInterventionPlacePostalCode(String interventionPlacePostalCode) {
		this.interventionPlacePostalCode = interventionPlacePostalCode;
	}
	
	public String getInterventionPlacePostalCode() {
		return this.interventionPlacePostalCode;
	}
	
	public boolean checkInterventionPlacePostalCode() {
		return true;
	}

	public void setInterventionPlaceCity(String interventionPlaceCity) {
		this.interventionPlaceCity = interventionPlaceCity;
	}
	
	public String getInterventionPlaceCity() {
		return this.interventionPlaceCity;
	}
	
	public boolean checkInterventionPlaceCity() {
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

	public void setInterventionDescription(String interventionDescription) {
		this.interventionDescription = interventionDescription;
	}
	
	public String getInterventionDescription() {
		return this.interventionDescription;
	}
	
	public boolean checkInterventionDescription() {
		return true;
	}

}
