package fr.cg95.cvq.fo.social.handicapallowance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Subject extends IStageForm {

	private String subjectIndividualLastName;
  	private String subjectIndividualAddressAdditionalDeliveryInformation;
	private String subjectIndividualAddressAdditionalGeographicalInformation;
	private String subjectIndividualAddressStreetNumber;
	private String subjectIndividualAddressStreetName;
	private String subjectIndividualAddressPlaceNameOrService;
	private String subjectIndividualAddressPostalCode;
	private String subjectIndividualAddressCity;
	private String subjectIndividualFirstName;

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
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.subjectIndividualLastName = request.getSubject().getIndividual().getLastName();
  			this.subjectIndividualAddressAdditionalDeliveryInformation = request.getSubject().getIndividual().getAddress().getAdditionalDeliveryInformation();
			this.subjectIndividualAddressAdditionalGeographicalInformation = request.getSubject().getIndividual().getAddress().getAdditionalGeographicalInformation();
			this.subjectIndividualAddressStreetNumber = request.getSubject().getIndividual().getAddress().getStreetNumber();
			this.subjectIndividualAddressStreetName = request.getSubject().getIndividual().getAddress().getStreetName();
			this.subjectIndividualAddressPlaceNameOrService = request.getSubject().getIndividual().getAddress().getPlaceNameOrService();
			this.subjectIndividualAddressPostalCode = request.getSubject().getIndividual().getAddress().getPostalCode();
			this.subjectIndividualAddressCity = request.getSubject().getIndividual().getAddress().getCity();
			this.subjectIndividualFirstName = request.getSubject().getIndividual().getFirstName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.getSubject().getIndividual().setLastName(this.subjectIndividualLastName);
  			request.getSubject().getIndividual().getAddress().setAdditionalDeliveryInformation(this.subjectIndividualAddressAdditionalDeliveryInformation);
			request.getSubject().getIndividual().getAddress().setAdditionalGeographicalInformation(this.subjectIndividualAddressAdditionalGeographicalInformation);
			request.getSubject().getIndividual().getAddress().setStreetNumber(this.subjectIndividualAddressStreetNumber);
			request.getSubject().getIndividual().getAddress().setStreetName(this.subjectIndividualAddressStreetName);
			request.getSubject().getIndividual().getAddress().setPlaceNameOrService(this.subjectIndividualAddressPlaceNameOrService);
			request.getSubject().getIndividual().getAddress().setPostalCode(this.subjectIndividualAddressPostalCode);
			request.getSubject().getIndividual().getAddress().setCity(this.subjectIndividualAddressCity);
			request.getSubject().getIndividual().setFirstName(this.subjectIndividualFirstName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectIndividualLastName() &&
			((this.subjectIndividualLastName == null) || (this.subjectIndividualLastName.length() == 0)))
			return false;
  		if (this.checkSubjectIndividualAddressStreetName() &&
			((this.subjectIndividualAddressStreetName == null) || (this.subjectIndividualAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectIndividualAddressPostalCode() &&
			((this.subjectIndividualAddressPostalCode == null) || (this.subjectIndividualAddressPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectIndividualAddressCity() &&
			((this.subjectIndividualAddressCity == null) || (this.subjectIndividualAddressCity.length() == 0)))
			return false;
		if (this.checkSubjectIndividualFirstName() &&
			((this.subjectIndividualFirstName == null) || (this.subjectIndividualFirstName.length() == 0)))
			return false;
		return true;
	}
	
	public void setSubjectIndividualLastName(String subjectIndividualLastName) {
		this.subjectIndividualLastName = subjectIndividualLastName;
	}
	
	public String getSubjectIndividualLastName() {
		return this.subjectIndividualLastName;
	}
	
	public boolean checkSubjectIndividualLastName() {
		return true;
	}

  	public void setSubjectIndividualAddressAdditionalDeliveryInformation(String subjectIndividualAddressAdditionalDeliveryInformation) {
		this.subjectIndividualAddressAdditionalDeliveryInformation = subjectIndividualAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalDeliveryInformation() {
		return this.subjectIndividualAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkSubjectIndividualAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setSubjectIndividualAddressAdditionalGeographicalInformation(String subjectIndividualAddressAdditionalGeographicalInformation) {
		this.subjectIndividualAddressAdditionalGeographicalInformation = subjectIndividualAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalGeographicalInformation() {
		return this.subjectIndividualAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkSubjectIndividualAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setSubjectIndividualAddressStreetNumber(String subjectIndividualAddressStreetNumber) {
		this.subjectIndividualAddressStreetNumber = subjectIndividualAddressStreetNumber;
	}
	
	public String getSubjectIndividualAddressStreetNumber() {
		return this.subjectIndividualAddressStreetNumber;
	}
	
	public boolean checkSubjectIndividualAddressStreetNumber() {
		return true;
	}

	public void setSubjectIndividualAddressStreetName(String subjectIndividualAddressStreetName) {
		this.subjectIndividualAddressStreetName = subjectIndividualAddressStreetName;
	}
	
	public String getSubjectIndividualAddressStreetName() {
		return this.subjectIndividualAddressStreetName;
	}
	
	public boolean checkSubjectIndividualAddressStreetName() {
		return true;
	}

	public void setSubjectIndividualAddressPlaceNameOrService(String subjectIndividualAddressPlaceNameOrService) {
		this.subjectIndividualAddressPlaceNameOrService = subjectIndividualAddressPlaceNameOrService;
	}
	
	public String getSubjectIndividualAddressPlaceNameOrService() {
		return this.subjectIndividualAddressPlaceNameOrService;
	}
	
	public boolean checkSubjectIndividualAddressPlaceNameOrService() {
		return true;
	}

	public void setSubjectIndividualAddressPostalCode(String subjectIndividualAddressPostalCode) {
		this.subjectIndividualAddressPostalCode = subjectIndividualAddressPostalCode;
	}
	
	public String getSubjectIndividualAddressPostalCode() {
		return this.subjectIndividualAddressPostalCode;
	}
	
	public boolean checkSubjectIndividualAddressPostalCode() {
		return true;
	}

	public void setSubjectIndividualAddressCity(String subjectIndividualAddressCity) {
		this.subjectIndividualAddressCity = subjectIndividualAddressCity;
	}
	
	public String getSubjectIndividualAddressCity() {
		return this.subjectIndividualAddressCity;
	}
	
	public boolean checkSubjectIndividualAddressCity() {
		return true;
	}

	public void setSubjectIndividualFirstName(String subjectIndividualFirstName) {
		this.subjectIndividualFirstName = subjectIndividualFirstName;
	}
	
	public String getSubjectIndividualFirstName() {
		return this.subjectIndividualFirstName;
	}
	
	public boolean checkSubjectIndividualFirstName() {
		return true;
	}

}
