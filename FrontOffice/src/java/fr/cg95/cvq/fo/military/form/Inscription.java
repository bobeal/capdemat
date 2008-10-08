package fr.cg95.cvq.fo.military.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.military.*;
import fr.cg95.cvq.xml.military.MilitaryCensusRequestDocument.MilitaryCensusRequest;

public class Inscription extends IStageForm {

	private String maidenName;
	private String childTitle;
	private String childBirthCountry;
	private String childConvention;
	private String childPhone;
	private String childOtherCountry;
	private String childMail;
	private String subjectChildLastName;
	private String subjectChildBirthPlaceCity;
	private String childCountry;
  	private String subjectChildAddressAdditionalDeliveryInformation;
	private String subjectChildAddressAdditionalGeographicalInformation;
	private String subjectChildAddressStreetNumber;
	private String subjectChildAddressStreetName;
	private String subjectChildAddressPlaceNameOrService;
	private String subjectChildAddressPostalCode;
	private String subjectChildAddressCity;
	private String subjectChildFirstName;
	private String childResidenceCountry;
	private String subjectChildBirthPlacePostalCode;

	public Inscription() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("nationality")) {
		}
		if (state.equals("*")) {
		}
		if (state.equals("display")) {
		}
		if (state.equals("military")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			this.maidenName = request.getMaidenName();
			if (request.getChildTitle() != null)
			this.childTitle = request.getChildTitle().toString();
			if (request.getChildBirthCountry() != null)
			this.childBirthCountry = request.getChildBirthCountry().toString();
			this.childConvention = request.getChildConvention();
			this.childPhone = request.getChildPhone();
			if (request.getChildOtherCountry() != null)
			this.childOtherCountry = request.getChildOtherCountry().toString();
			this.childMail = request.getChildMail();
			this.subjectChildLastName = request.getSubject().getChild().getLastName();
			this.subjectChildBirthPlaceCity = request.getSubject().getChild().getBirthPlace().getCity();
			if (request.getChildCountry() != null)
			this.childCountry = request.getChildCountry().toString();
  			this.subjectChildAddressAdditionalDeliveryInformation = request.getSubject().getChild().getAddress().getAdditionalDeliveryInformation();
			this.subjectChildAddressAdditionalGeographicalInformation = request.getSubject().getChild().getAddress().getAdditionalGeographicalInformation();
			this.subjectChildAddressStreetNumber = request.getSubject().getChild().getAddress().getStreetNumber();
			this.subjectChildAddressStreetName = request.getSubject().getChild().getAddress().getStreetName();
			this.subjectChildAddressPlaceNameOrService = request.getSubject().getChild().getAddress().getPlaceNameOrService();
			this.subjectChildAddressPostalCode = request.getSubject().getChild().getAddress().getPostalCode();
			this.subjectChildAddressCity = request.getSubject().getChild().getAddress().getCity();
			this.subjectChildFirstName = request.getSubject().getChild().getFirstName();
			if (request.getChildResidenceCountry() != null)
			this.childResidenceCountry = request.getChildResidenceCountry().toString();
			this.subjectChildBirthPlacePostalCode = request.getSubject().getChild().getBirthPlace().getPostalCode();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof MilitaryCensusRequest)) {
			MilitaryCensusRequest request = (MilitaryCensusRequest)xmlbRequest;
			request.setMaidenName(this.maidenName);
			request.setChildTitle(TitleType.Enum.forString(this.childTitle));
			request.setChildBirthCountry(CountryType.Enum.forString(this.childBirthCountry));
			request.setChildConvention(this.childConvention);
			request.setChildPhone(this.childPhone);
			request.setChildOtherCountry(FullNationalityType.Enum.forString(this.childOtherCountry));
			request.setChildMail(this.childMail);
			request.getSubject().getChild().setLastName(this.subjectChildLastName);
			request.getSubject().getChild().getBirthPlace().setCity(this.subjectChildBirthPlaceCity);
			request.setChildCountry(FullNationalityType.Enum.forString(this.childCountry));
  			request.getSubject().getChild().getAddress().setAdditionalDeliveryInformation(this.subjectChildAddressAdditionalDeliveryInformation);
			request.getSubject().getChild().getAddress().setAdditionalGeographicalInformation(this.subjectChildAddressAdditionalGeographicalInformation);
			request.getSubject().getChild().getAddress().setStreetNumber(this.subjectChildAddressStreetNumber);
			request.getSubject().getChild().getAddress().setStreetName(this.subjectChildAddressStreetName);
			request.getSubject().getChild().getAddress().setPlaceNameOrService(this.subjectChildAddressPlaceNameOrService);
			request.getSubject().getChild().getAddress().setPostalCode(this.subjectChildAddressPostalCode);
			request.getSubject().getChild().getAddress().setCity(this.subjectChildAddressCity);
			request.getSubject().getChild().setFirstName(this.subjectChildFirstName);
			request.setChildResidenceCountry(CountryType.Enum.forString(this.childResidenceCountry));
			request.getSubject().getChild().getBirthPlace().setPostalCode(this.subjectChildBirthPlacePostalCode);
		}
	}
	
	public boolean isComplete() {
		if (this.checkChildTitle() &&
			((this.childTitle == null) || (this.childTitle.length() == 0)))
			return false;
		if (this.checkChildBirthCountry() &&
			((this.childBirthCountry == null) || (this.childBirthCountry.length() == 0)))
			return false;
		if (this.checkChildPhone() &&
			((this.childPhone == null) || (this.childPhone.length() == 0)))
			return false;
		if (this.checkSubjectChildLastName() &&
			((this.subjectChildLastName == null) || (this.subjectChildLastName.length() == 0)))
			return false;
		if (this.checkSubjectChildBirthPlaceCity() &&
			((this.subjectChildBirthPlaceCity == null) || (this.subjectChildBirthPlaceCity.length() == 0)))
			return false;
		if (this.checkChildCountry() &&
			((this.childCountry == null) || (this.childCountry.length() == 0)))
			return false;
  		if (this.checkSubjectChildAddressStreetName() &&
			((this.subjectChildAddressStreetName == null) || (this.subjectChildAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectChildAddressPostalCode() &&
			((this.subjectChildAddressPostalCode == null) || (this.subjectChildAddressPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectChildAddressCity() &&
			((this.subjectChildAddressCity == null) || (this.subjectChildAddressCity.length() == 0)))
			return false;
		if (this.checkSubjectChildFirstName() &&
			((this.subjectChildFirstName == null) || (this.subjectChildFirstName.length() == 0)))
			return false;
		if (this.checkSubjectChildBirthPlacePostalCode() &&
			((this.subjectChildBirthPlacePostalCode == null) || (this.subjectChildBirthPlacePostalCode.length() == 0)))
			return false;
		return true;
	}
	
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	
	public String getMaidenName() {
		return this.maidenName;
	}
	
	public boolean checkMaidenName() {
		return true;
	}

	public void setChildTitle(String childTitle) {
		this.childTitle = childTitle;
	}
	
	public String getChildTitle() {
		return this.childTitle;
	}
	
	public boolean checkChildTitle() {
		return true;
	}

	public void setChildBirthCountry(String childBirthCountry) {
		this.childBirthCountry = childBirthCountry;
	}
	
	public String getChildBirthCountry() {
		return this.childBirthCountry;
	}
	
	public boolean checkChildBirthCountry() {
		return true;
	}

	public void setChildConvention(String childConvention) {
		this.childConvention = childConvention;
	}
	
	public String getChildConvention() {
		return this.childConvention;
	}
	
	public boolean checkChildConvention() {
		return true;
	}

	public void setChildPhone(String childPhone) {
		this.childPhone = childPhone;
	}
	
	public String getChildPhone() {
		return this.childPhone;
	}
	
	public boolean checkChildPhone() {
		return true;
	}

	public void setChildOtherCountry(String childOtherCountry) {
		this.childOtherCountry = childOtherCountry;
	}
	
	public String getChildOtherCountry() {
		return this.childOtherCountry;
	}
	
	public boolean checkChildOtherCountry() {
		return true;
	}

	public void setChildMail(String childMail) {
		this.childMail = childMail;
	}
	
	public String getChildMail() {
		return this.childMail;
	}
	
	public boolean checkChildMail() {
		return true;
	}

	public void setSubjectChildLastName(String subjectChildLastName) {
		this.subjectChildLastName = subjectChildLastName;
	}
	
	public String getSubjectChildLastName() {
		return this.subjectChildLastName;
	}
	
	public boolean checkSubjectChildLastName() {
		return true;
	}

	public void setSubjectChildBirthPlaceCity(String subjectChildBirthPlaceCity) {
		this.subjectChildBirthPlaceCity = subjectChildBirthPlaceCity;
	}
	
	public String getSubjectChildBirthPlaceCity() {
		return this.subjectChildBirthPlaceCity;
	}
	
	public boolean checkSubjectChildBirthPlaceCity() {
		return true;
	}

	public void setChildCountry(String childCountry) {
		this.childCountry = childCountry;
	}
	
	public String getChildCountry() {
		return this.childCountry;
	}
	
	public boolean checkChildCountry() {
		return true;
	}

  	public void setSubjectChildAddressAdditionalDeliveryInformation(String subjectChildAddressAdditionalDeliveryInformation) {
		this.subjectChildAddressAdditionalDeliveryInformation = subjectChildAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectChildAddressAdditionalDeliveryInformation() {
		return this.subjectChildAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkSubjectChildAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setSubjectChildAddressAdditionalGeographicalInformation(String subjectChildAddressAdditionalGeographicalInformation) {
		this.subjectChildAddressAdditionalGeographicalInformation = subjectChildAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectChildAddressAdditionalGeographicalInformation() {
		return this.subjectChildAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkSubjectChildAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setSubjectChildAddressStreetNumber(String subjectChildAddressStreetNumber) {
		this.subjectChildAddressStreetNumber = subjectChildAddressStreetNumber;
	}
	
	public String getSubjectChildAddressStreetNumber() {
		return this.subjectChildAddressStreetNumber;
	}
	
	public boolean checkSubjectChildAddressStreetNumber() {
		return true;
	}

	public void setSubjectChildAddressStreetName(String subjectChildAddressStreetName) {
		this.subjectChildAddressStreetName = subjectChildAddressStreetName;
	}
	
	public String getSubjectChildAddressStreetName() {
		return this.subjectChildAddressStreetName;
	}
	
	public boolean checkSubjectChildAddressStreetName() {
		return true;
	}

	public void setSubjectChildAddressPlaceNameOrService(String subjectChildAddressPlaceNameOrService) {
		this.subjectChildAddressPlaceNameOrService = subjectChildAddressPlaceNameOrService;
	}
	
	public String getSubjectChildAddressPlaceNameOrService() {
		return this.subjectChildAddressPlaceNameOrService;
	}
	
	public boolean checkSubjectChildAddressPlaceNameOrService() {
		return true;
	}

	public void setSubjectChildAddressPostalCode(String subjectChildAddressPostalCode) {
		this.subjectChildAddressPostalCode = subjectChildAddressPostalCode;
	}
	
	public String getSubjectChildAddressPostalCode() {
		return this.subjectChildAddressPostalCode;
	}
	
	public boolean checkSubjectChildAddressPostalCode() {
		return true;
	}

	public void setSubjectChildAddressCity(String subjectChildAddressCity) {
		this.subjectChildAddressCity = subjectChildAddressCity;
	}
	
	public String getSubjectChildAddressCity() {
		return this.subjectChildAddressCity;
	}
	
	public boolean checkSubjectChildAddressCity() {
		return true;
	}

	public void setSubjectChildFirstName(String subjectChildFirstName) {
		this.subjectChildFirstName = subjectChildFirstName;
	}
	
	public String getSubjectChildFirstName() {
		return this.subjectChildFirstName;
	}
	
	public boolean checkSubjectChildFirstName() {
		return true;
	}

	public void setChildResidenceCountry(String childResidenceCountry) {
		this.childResidenceCountry = childResidenceCountry;
	}
	
	public String getChildResidenceCountry() {
		return this.childResidenceCountry;
	}
	
	public boolean checkChildResidenceCountry() {
		return true;
	}

	public void setSubjectChildBirthPlacePostalCode(String subjectChildBirthPlacePostalCode) {
		this.subjectChildBirthPlacePostalCode = subjectChildBirthPlacePostalCode;
	}
	
	public String getSubjectChildBirthPlacePostalCode() {
		return this.subjectChildBirthPlacePostalCode;
	}
	
	public boolean checkSubjectChildBirthPlacePostalCode() {
		return true;
	}

}
