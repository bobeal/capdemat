package fr.cg95.cvq.fo.election.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.election.*;
import fr.cg95.cvq.xml.election.ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest;

public class Validation extends IStageForm {

  	private String subjectAddressOutsideCityAdditionalDeliveryInformation;
	private String subjectAddressOutsideCityAdditionalGeographicalInformation;
	private String subjectAddressOutsideCityStreetNumber;
	private String subjectAddressOutsideCityStreetName;
	private String subjectAddressOutsideCityPlaceNameOrService;
	private String subjectAddressOutsideCityPostalCode;
	private String subjectAddressOutsideCityCity;
	private Calendar subjectAdultBirthDate;
	private String subjectAdultFirstName3;
	private String subjectAdultSex;
	private String subjectOldCity;
	private String motive;
  	private String subjectAdultAddressAdditionalDeliveryInformation;
	private String subjectAdultAddressAdditionalGeographicalInformation;
	private String subjectAdultAddressStreetNumber;
	private String subjectAdultAddressStreetName;
	private String subjectAdultAddressPlaceNameOrService;
	private String subjectAdultAddressPostalCode;
	private String subjectAdultAddressCity;
	private String subjectAdultLastName;
	private String subjectNationality;
	private String subjectAdultFirstName2;
	private String subjectAdultFirstName;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
		if (state.equals("summarycontributor")) {
		}
		if (state.equals("summaryreason")) {
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
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			this.subjectAdultFirstName3 = request.getSubject().getAdult().getFirstName3();
			if (request.getSubject().getAdult().getSex() != null)
			this.subjectAdultSex = request.getSubject().getAdult().getSex().toString();
			this.subjectOldCity = request.getSubjectOldCity();
			if (request.getMotive() != null)
			this.motive = request.getMotive().toString();
  			this.subjectAdultAddressAdditionalDeliveryInformation = request.getSubject().getAdult().getAddress().getAdditionalDeliveryInformation();
			this.subjectAdultAddressAdditionalGeographicalInformation = request.getSubject().getAdult().getAddress().getAdditionalGeographicalInformation();
			this.subjectAdultAddressStreetNumber = request.getSubject().getAdult().getAddress().getStreetNumber();
			this.subjectAdultAddressStreetName = request.getSubject().getAdult().getAddress().getStreetName();
			this.subjectAdultAddressPlaceNameOrService = request.getSubject().getAdult().getAddress().getPlaceNameOrService();
			this.subjectAdultAddressPostalCode = request.getSubject().getAdult().getAddress().getPostalCode();
			this.subjectAdultAddressCity = request.getSubject().getAdult().getAddress().getCity();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.subjectNationality = request.getSubjectNationality();
			this.subjectAdultFirstName2 = request.getSubject().getAdult().getFirstName2();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
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
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.getSubject().getAdult().setFirstName3(this.subjectAdultFirstName3);
			request.getSubject().getAdult().setSex(SexType.Enum.forString(this.subjectAdultSex));
			request.setSubjectOldCity(this.subjectOldCity);
			request.setMotive(ElectoralMotiveType.Enum.forString(this.motive));
  			request.getSubject().getAdult().getAddress().setAdditionalDeliveryInformation(this.subjectAdultAddressAdditionalDeliveryInformation);
			request.getSubject().getAdult().getAddress().setAdditionalGeographicalInformation(this.subjectAdultAddressAdditionalGeographicalInformation);
			request.getSubject().getAdult().getAddress().setStreetNumber(this.subjectAdultAddressStreetNumber);
			request.getSubject().getAdult().getAddress().setStreetName(this.subjectAdultAddressStreetName);
			request.getSubject().getAdult().getAddress().setPlaceNameOrService(this.subjectAdultAddressPlaceNameOrService);
			request.getSubject().getAdult().getAddress().setPostalCode(this.subjectAdultAddressPostalCode);
			request.getSubject().getAdult().getAddress().setCity(this.subjectAdultAddressCity);
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.setSubjectNationality(this.subjectNationality);
			request.getSubject().getAdult().setFirstName2(this.subjectAdultFirstName2);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
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
		if (this.checkSubjectNationality() &&
			((this.subjectNationality == null) || (this.subjectNationality.length() == 0)))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
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
		return true;
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
		return true;
	}

	public void setSubjectAddressOutsideCityCity(String subjectAddressOutsideCityCity) {
		this.subjectAddressOutsideCityCity = subjectAddressOutsideCityCity;
	}
	
	public String getSubjectAddressOutsideCityCity() {
		return this.subjectAddressOutsideCityCity;
	}
	
	public boolean checkSubjectAddressOutsideCityCity() {
		return true;
	}

	public void setSubjectAdultBirthDate(Calendar subjectAdultBirthDate) {
		this.subjectAdultBirthDate = subjectAdultBirthDate;
	}
	
	public Calendar getSubjectAdultBirthDate() {
		return this.subjectAdultBirthDate;
	}
	
	public boolean checkSubjectAdultBirthDate() {
		return true;
	}

	public void setSubjectAdultFirstName3(String subjectAdultFirstName3) {
		this.subjectAdultFirstName3 = subjectAdultFirstName3;
	}
	
	public String getSubjectAdultFirstName3() {
		return this.subjectAdultFirstName3;
	}
	
	public boolean checkSubjectAdultFirstName3() {
		return true;
	}

	public void setSubjectAdultSex(String subjectAdultSex) {
		this.subjectAdultSex = subjectAdultSex;
	}
	
	public String getSubjectAdultSex() {
		return this.subjectAdultSex;
	}
	
	public boolean checkSubjectAdultSex() {
		return true;
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

	public void setSubjectNationality(String subjectNationality) {
		this.subjectNationality = subjectNationality;
	}
	
	public String getSubjectNationality() {
		return this.subjectNationality;
	}
	
	public boolean checkSubjectNationality() {
		return true;
	}

	public void setSubjectAdultFirstName2(String subjectAdultFirstName2) {
		this.subjectAdultFirstName2 = subjectAdultFirstName2;
	}
	
	public String getSubjectAdultFirstName2() {
		return this.subjectAdultFirstName2;
	}
	
	public boolean checkSubjectAdultFirstName2() {
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
