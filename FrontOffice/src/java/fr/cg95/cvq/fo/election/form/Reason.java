package fr.cg95.cvq.fo.election.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.election.*;
import fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest;

public class Reason extends IStageForm {

  	private String subjectAddressOutsideCityAdditionalDeliveryInformation;
	private String subjectAddressOutsideCityAdditionalGeographicalInformation;
	private String subjectAddressOutsideCityStreetNumber;
	private String subjectAddressOutsideCityStreetName;
	private String subjectAddressOutsideCityPlaceNameOrService;
	private String subjectAddressOutsideCityPostalCode;
	private String subjectAddressOutsideCityCity;
	private String subjectOldCity;
	private String motive;

	public Reason() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("reason")) {
		}
		if (state.equals("contributor")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof ElectoralRollRegistrationRequest)) {
			ElectoralRollRegistrationRequest request = (ElectoralRollRegistrationRequest)xmlbRequest;
  			this.subjectAddressOutsideCityAdditionalDeliveryInformation = request.getSubjectAddressOutsideCity().getAdditionalDeliveryInformation();
			this.subjectAddressOutsideCityAdditionalGeographicalInformation = request.getSubjectAddressOutsideCity().getAdditionalGeographicalInformation();
			this.subjectAddressOutsideCityStreetNumber = request.getSubjectAddressOutsideCity().getStreetNumber();
			this.subjectAddressOutsideCityStreetName = request.getSubjectAddressOutsideCity().getStreetName();
			this.subjectAddressOutsideCityPlaceNameOrService = request.getSubjectAddressOutsideCity().getPlaceNameOrService();
			this.subjectAddressOutsideCityPostalCode = request.getSubjectAddressOutsideCity().getPostalCode();
			this.subjectAddressOutsideCityCity = request.getSubjectAddressOutsideCity().getCity();
			this.subjectOldCity = request.getSubjectOldCity();
			if (request.getMotive() != null)
			this.motive = request.getMotive().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof ElectoralRollRegistrationRequest)) {
			ElectoralRollRegistrationRequest request = (ElectoralRollRegistrationRequest)xmlbRequest;
  			request.getSubjectAddressOutsideCity().setAdditionalDeliveryInformation(this.subjectAddressOutsideCityAdditionalDeliveryInformation);
			request.getSubjectAddressOutsideCity().setAdditionalGeographicalInformation(this.subjectAddressOutsideCityAdditionalGeographicalInformation);
			request.getSubjectAddressOutsideCity().setStreetNumber(this.subjectAddressOutsideCityStreetNumber);
			request.getSubjectAddressOutsideCity().setStreetName(this.subjectAddressOutsideCityStreetName);
			request.getSubjectAddressOutsideCity().setPlaceNameOrService(this.subjectAddressOutsideCityPlaceNameOrService);
			request.getSubjectAddressOutsideCity().setPostalCode(this.subjectAddressOutsideCityPostalCode);
			request.getSubjectAddressOutsideCity().setCity(this.subjectAddressOutsideCityCity);
			request.setSubjectOldCity(this.subjectOldCity);
			request.setMotive(ElectoralMotiveType.Enum.forString(this.motive));
		}
	}
	
	public boolean isComplete() {
  		if (this.checkSubjectAddressOutsideCityStreetName() &&
			((this.subjectAddressOutsideCityStreetName == null) || (this.subjectAddressOutsideCityStreetName.length() == 0)))
			return false;
		if (this.checkSubjectAddressOutsideCityPostalCode() &&
			((this.subjectAddressOutsideCityPostalCode == null) || (this.subjectAddressOutsideCityPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectAddressOutsideCityCity() &&
			((this.subjectAddressOutsideCityCity == null) || (this.subjectAddressOutsideCityCity.length() == 0)))
			return false;
		if (this.checkMotive() &&
			((this.motive == null) || (this.motive.length() == 0)))
			return false;
		return true;
	}
	
  	public void setSubjectAddressOutsideCityAdditionalDeliveryInformation(String subjectAddressOutsideCityAdditionalDeliveryInformation) {
		this.subjectAddressOutsideCityAdditionalDeliveryInformation = subjectAddressOutsideCityAdditionalDeliveryInformation;
	}
	
	public String getSubjectAddressOutsideCityAdditionalDeliveryInformation() {
		return this.subjectAddressOutsideCityAdditionalDeliveryInformation;
	}
	
	public boolean checkSubjectAddressOutsideCityAdditionalDeliveryInformation() {
		return true;
	}

	public void setSubjectAddressOutsideCityAdditionalGeographicalInformation(String subjectAddressOutsideCityAdditionalGeographicalInformation) {
		this.subjectAddressOutsideCityAdditionalGeographicalInformation = subjectAddressOutsideCityAdditionalGeographicalInformation;
	}
	
	public String getSubjectAddressOutsideCityAdditionalGeographicalInformation() {
		return this.subjectAddressOutsideCityAdditionalGeographicalInformation;
	}
	
	public boolean checkSubjectAddressOutsideCityAdditionalGeographicalInformation() {
		return true;
	}

	public void setSubjectAddressOutsideCityStreetNumber(String subjectAddressOutsideCityStreetNumber) {
		this.subjectAddressOutsideCityStreetNumber = subjectAddressOutsideCityStreetNumber;
	}
	
	public String getSubjectAddressOutsideCityStreetNumber() {
		return this.subjectAddressOutsideCityStreetNumber;
	}
	
	public boolean checkSubjectAddressOutsideCityStreetNumber() {
		return true;
	}

	public void setSubjectAddressOutsideCityStreetName(String subjectAddressOutsideCityStreetName) {
		this.subjectAddressOutsideCityStreetName = subjectAddressOutsideCityStreetName;
	}
	
	public String getSubjectAddressOutsideCityStreetName() {
		return this.subjectAddressOutsideCityStreetName;
	}
	
	public boolean checkSubjectAddressOutsideCityStreetName() {
		return motive.equals("DirectCityContribution");
	}

	public void setSubjectAddressOutsideCityPlaceNameOrService(String subjectAddressOutsideCityPlaceNameOrService) {
		this.subjectAddressOutsideCityPlaceNameOrService = subjectAddressOutsideCityPlaceNameOrService;
	}
	
	public String getSubjectAddressOutsideCityPlaceNameOrService() {
		return this.subjectAddressOutsideCityPlaceNameOrService;
	}
	
	public boolean checkSubjectAddressOutsideCityPlaceNameOrService() {
		return true;
	}

	public void setSubjectAddressOutsideCityPostalCode(String subjectAddressOutsideCityPostalCode) {
		this.subjectAddressOutsideCityPostalCode = subjectAddressOutsideCityPostalCode;
	}
	
	public String getSubjectAddressOutsideCityPostalCode() {
		return this.subjectAddressOutsideCityPostalCode;
	}
	
	public boolean checkSubjectAddressOutsideCityPostalCode() {
		return motive.equals("DirectCityContribution");
	}

	public void setSubjectAddressOutsideCityCity(String subjectAddressOutsideCityCity) {
		this.subjectAddressOutsideCityCity = subjectAddressOutsideCityCity;
	}
	
	public String getSubjectAddressOutsideCityCity() {
		return this.subjectAddressOutsideCityCity;
	}
	
	public boolean checkSubjectAddressOutsideCityCity() {
		return motive.equals("DirectCityContribution");
	}

	public void setSubjectOldCity(String subjectOldCity) {
		this.subjectOldCity = subjectOldCity;
	}
	
	public String getSubjectOldCity() {
		return this.subjectOldCity;
	}
	
	public boolean checkSubjectOldCity() {
		return true;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}
	
	public boolean checkMotive() {
		return true;
	}

}
