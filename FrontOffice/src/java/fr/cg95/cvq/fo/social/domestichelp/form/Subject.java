package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Subject extends IStageForm {

	private Calendar subjectAdultBirthDate;
	private String socialSecurityNumber;
	private String requesterSpouseSpouseNationality;
	private String requesterSpouseSpouseInformationMaidenName;
	private String requesterSpouseSpouseInformationLastName;
	private String requesterSituationTutor;
	private Calendar requesterSpouseSpouseInformationBirthDate;
	private String requesterSpouseSpouseEmployer;
	private Calendar requesterSpouseSpouseFranceArrivalDate;
  	private String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	private String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	private String requesterSpouseSpouseEmployerAddressStreetNumber;
	private String requesterSpouseSpouseEmployerAddressStreetName;
	private String requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	private String requesterSpouseSpouseEmployerAddressPostalCode;
	private String requesterSpouseSpouseEmployerAddressCity;
	private String subjectAdultFirstName;
	private boolean requesterSituationTutorPresence;
	private String requesterSpouseSpousePensionPlan;
	private String subjectAdultMaidenName;
	private boolean requesterSpouseSpousePensionner;
	private String subjectAdultLastName;
	private String socialSecurityKeyNumber;
	private String requesterSpouseSpouseSocialSecurityKeyNumber;
	private Calendar franceArrivalDate;
	private String requesterPensionPlan;
	private String nationality;
	private String requesterSituationTutorName;
  	private String requesterSituationTutorAddressAdditionalDeliveryInformation;
	private String requesterSituationTutorAddressAdditionalGeographicalInformation;
	private String requesterSituationTutorAddressStreetNumber;
	private String requesterSituationTutorAddressStreetName;
	private String requesterSituationTutorAddressPlaceNameOrService;
	private String requesterSituationTutorAddressPostalCode;
	private String requesterSituationTutorAddressCity;
	private String subjectAdultBirthPlaceCity;
	private String requesterSpouseSpouseInformationFirstName;
	private String requesterSpouseSpouseOccupation;
	private String requesterSpouseSpouseInformationBirthPlaceCity;
	private String requesterSpouseSpouseSocialSecurityNumber;
	private String requesterSituationTutorFirstName;

	public Subject() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displaytutor")) {
		}
		if (state.equals("spouse")) {
		}
		if (state.equals("subject")) {
		}
		if (state.equals("tutor")) {
		}
		if (state.equals("displayspouse")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			this.socialSecurityNumber = request.getSocialSecurityNumber();
			if (request.getRequesterSpouse().getSpouseNationality() != null)
			this.requesterSpouseSpouseNationality = request.getRequesterSpouse().getSpouseNationality().toString();
			this.requesterSpouseSpouseInformationMaidenName = request.getRequesterSpouse().getSpouseInformation().getMaidenName();
			this.requesterSpouseSpouseInformationLastName = request.getRequesterSpouse().getSpouseInformation().getLastName();
			if (request.getRequesterSituation().getTutor() != null)
			this.requesterSituationTutor = request.getRequesterSituation().getTutor().toString();
			this.requesterSpouseSpouseInformationBirthDate = request.getRequesterSpouse().getSpouseInformation().getBirthDate();
			this.requesterSpouseSpouseEmployer = request.getRequesterSpouse().getSpouseEmployer();
			this.requesterSpouseSpouseFranceArrivalDate = request.getRequesterSpouse().getSpouseFranceArrivalDate();
  			this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalDeliveryInformation();
			this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalGeographicalInformation();
			this.requesterSpouseSpouseEmployerAddressStreetNumber = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetNumber();
			this.requesterSpouseSpouseEmployerAddressStreetName = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetName();
			this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = request.getRequesterSpouse().getSpouseEmployerAddress().getPlaceNameOrService();
			this.requesterSpouseSpouseEmployerAddressPostalCode = request.getRequesterSpouse().getSpouseEmployerAddress().getPostalCode();
			this.requesterSpouseSpouseEmployerAddressCity = request.getRequesterSpouse().getSpouseEmployerAddress().getCity();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
			this.requesterSituationTutorPresence = request.getRequesterSituation().getTutorPresence();
			if (request.getRequesterSpouse().getSpousePensionPlan() != null)
			this.requesterSpouseSpousePensionPlan = request.getRequesterSpouse().getSpousePensionPlan().toString();
			this.subjectAdultMaidenName = request.getSubject().getAdult().getMaidenName();
			this.requesterSpouseSpousePensionner = request.getRequesterSpouse().getSpousePensionner();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.socialSecurityKeyNumber = request.getSocialSecurityKeyNumber();
			this.requesterSpouseSpouseSocialSecurityKeyNumber = request.getRequesterSpouse().getSpouseSocialSecurityKeyNumber();
			this.franceArrivalDate = request.getFranceArrivalDate();
			if (request.getRequesterPensionPlan() != null)
			this.requesterPensionPlan = request.getRequesterPensionPlan().toString();
			if (request.getNationality() != null)
			this.nationality = request.getNationality().toString();
			this.requesterSituationTutorName = request.getRequesterSituation().getTutorName();
  			this.requesterSituationTutorAddressAdditionalDeliveryInformation = request.getRequesterSituation().getTutorAddress().getAdditionalDeliveryInformation();
			this.requesterSituationTutorAddressAdditionalGeographicalInformation = request.getRequesterSituation().getTutorAddress().getAdditionalGeographicalInformation();
			this.requesterSituationTutorAddressStreetNumber = request.getRequesterSituation().getTutorAddress().getStreetNumber();
			this.requesterSituationTutorAddressStreetName = request.getRequesterSituation().getTutorAddress().getStreetName();
			this.requesterSituationTutorAddressPlaceNameOrService = request.getRequesterSituation().getTutorAddress().getPlaceNameOrService();
			this.requesterSituationTutorAddressPostalCode = request.getRequesterSituation().getTutorAddress().getPostalCode();
			this.requesterSituationTutorAddressCity = request.getRequesterSituation().getTutorAddress().getCity();
			this.subjectAdultBirthPlaceCity = request.getSubject().getAdult().getBirthPlace().getCity();
			this.requesterSpouseSpouseInformationFirstName = request.getRequesterSpouse().getSpouseInformation().getFirstName();
			this.requesterSpouseSpouseOccupation = request.getRequesterSpouse().getSpouseOccupation();
			this.requesterSpouseSpouseInformationBirthPlaceCity = request.getRequesterSpouse().getSpouseInformation().getBirthPlace().getCity();
			this.requesterSpouseSpouseSocialSecurityNumber = request.getRequesterSpouse().getSpouseSocialSecurityNumber();
			this.requesterSituationTutorFirstName = request.getRequesterSituation().getTutorFirstName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.setSocialSecurityNumber(this.socialSecurityNumber);
			request.getRequesterSpouse().setSpouseNationality(NationalityType.Enum.forString(this.requesterSpouseSpouseNationality));
			request.getRequesterSpouse().getSpouseInformation().setMaidenName(this.requesterSpouseSpouseInformationMaidenName);
			request.getRequesterSpouse().getSpouseInformation().setLastName(this.requesterSpouseSpouseInformationLastName);
			request.getRequesterSituation().setTutor(DhrTutorType.Enum.forString(this.requesterSituationTutor));
			request.getRequesterSpouse().getSpouseInformation().setBirthDate(this.requesterSpouseSpouseInformationBirthDate);
			request.getRequesterSpouse().setSpouseEmployer(this.requesterSpouseSpouseEmployer);
			request.getRequesterSpouse().setSpouseFranceArrivalDate(this.requesterSpouseSpouseFranceArrivalDate);
  			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalDeliveryInformation(this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalGeographicalInformation(this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetNumber(this.requesterSpouseSpouseEmployerAddressStreetNumber);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetName(this.requesterSpouseSpouseEmployerAddressStreetName);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPlaceNameOrService(this.requesterSpouseSpouseEmployerAddressPlaceNameOrService);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPostalCode(this.requesterSpouseSpouseEmployerAddressPostalCode);
			request.getRequesterSpouse().getSpouseEmployerAddress().setCity(this.requesterSpouseSpouseEmployerAddressCity);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
			request.getRequesterSituation().setTutorPresence(this.requesterSituationTutorPresence);
			request.getRequesterSpouse().setSpousePensionPlan(DhrPensionPlanType.Enum.forString(this.requesterSpouseSpousePensionPlan));
			request.getSubject().getAdult().setMaidenName(this.subjectAdultMaidenName);
			request.getRequesterSpouse().setSpousePensionner(this.requesterSpouseSpousePensionner);
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.setSocialSecurityKeyNumber(this.socialSecurityKeyNumber);
			request.getRequesterSpouse().setSpouseSocialSecurityKeyNumber(this.requesterSpouseSpouseSocialSecurityKeyNumber);
			request.setFranceArrivalDate(this.franceArrivalDate);
			request.setRequesterPensionPlan(DhrPensionPlanType.Enum.forString(this.requesterPensionPlan));
			request.setNationality(NationalityType.Enum.forString(this.nationality));
			request.getRequesterSituation().setTutorName(this.requesterSituationTutorName);
  			request.getRequesterSituation().getTutorAddress().setAdditionalDeliveryInformation(this.requesterSituationTutorAddressAdditionalDeliveryInformation);
			request.getRequesterSituation().getTutorAddress().setAdditionalGeographicalInformation(this.requesterSituationTutorAddressAdditionalGeographicalInformation);
			request.getRequesterSituation().getTutorAddress().setStreetNumber(this.requesterSituationTutorAddressStreetNumber);
			request.getRequesterSituation().getTutorAddress().setStreetName(this.requesterSituationTutorAddressStreetName);
			request.getRequesterSituation().getTutorAddress().setPlaceNameOrService(this.requesterSituationTutorAddressPlaceNameOrService);
			request.getRequesterSituation().getTutorAddress().setPostalCode(this.requesterSituationTutorAddressPostalCode);
			request.getRequesterSituation().getTutorAddress().setCity(this.requesterSituationTutorAddressCity);
			request.getSubject().getAdult().getBirthPlace().setCity(this.subjectAdultBirthPlaceCity);
			request.getRequesterSpouse().getSpouseInformation().setFirstName(this.requesterSpouseSpouseInformationFirstName);
			request.getRequesterSpouse().setSpouseOccupation(this.requesterSpouseSpouseOccupation);
			request.getRequesterSpouse().getSpouseInformation().getBirthPlace().setCity(this.requesterSpouseSpouseInformationBirthPlaceCity);
			request.getRequesterSpouse().setSpouseSocialSecurityNumber(this.requesterSpouseSpouseSocialSecurityNumber);
			request.getRequesterSituation().setTutorFirstName(this.requesterSituationTutorFirstName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSocialSecurityNumber() &&
			((this.socialSecurityNumber == null) || (this.socialSecurityNumber.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseNationality() &&
			((this.requesterSpouseSpouseNationality == null) || (this.requesterSpouseSpouseNationality.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationLastName() &&
			((this.requesterSpouseSpouseInformationLastName == null) || (this.requesterSpouseSpouseInformationLastName.length() == 0)))
			return false;
  		if (this.checkRequesterSpouseSpouseEmployerAddressStreetName() &&
			((this.requesterSpouseSpouseEmployerAddressStreetName == null) || (this.requesterSpouseSpouseEmployerAddressStreetName.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseEmployerAddressPostalCode() &&
			((this.requesterSpouseSpouseEmployerAddressPostalCode == null) || (this.requesterSpouseSpouseEmployerAddressPostalCode.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseEmployerAddressCity() &&
			((this.requesterSpouseSpouseEmployerAddressCity == null) || (this.requesterSpouseSpouseEmployerAddressCity.length() == 0)))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpousePensionPlan() &&
			((this.requesterSpouseSpousePensionPlan == null) || (this.requesterSpouseSpousePensionPlan.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
			return false;
		if (this.checkSocialSecurityKeyNumber() &&
			((this.socialSecurityKeyNumber == null) || (this.socialSecurityKeyNumber.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseSocialSecurityKeyNumber() &&
			((this.requesterSpouseSpouseSocialSecurityKeyNumber == null) || (this.requesterSpouseSpouseSocialSecurityKeyNumber.length() == 0)))
			return false;
		if (this.checkNationality() &&
			((this.nationality == null) || (this.nationality.length() == 0)))
			return false;
  		if (this.checkRequesterSituationTutorAddressStreetName() &&
			((this.requesterSituationTutorAddressStreetName == null) || (this.requesterSituationTutorAddressStreetName.length() == 0)))
			return false;
		if (this.checkRequesterSituationTutorAddressPostalCode() &&
			((this.requesterSituationTutorAddressPostalCode == null) || (this.requesterSituationTutorAddressPostalCode.length() == 0)))
			return false;
		if (this.checkRequesterSituationTutorAddressCity() &&
			((this.requesterSituationTutorAddressCity == null) || (this.requesterSituationTutorAddressCity.length() == 0)))
			return false;
		if (this.checkSubjectAdultBirthPlaceCity() &&
			((this.subjectAdultBirthPlaceCity == null) || (this.subjectAdultBirthPlaceCity.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationFirstName() &&
			((this.requesterSpouseSpouseInformationFirstName == null) || (this.requesterSpouseSpouseInformationFirstName.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationBirthPlaceCity() &&
			((this.requesterSpouseSpouseInformationBirthPlaceCity == null) || (this.requesterSpouseSpouseInformationBirthPlaceCity.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseSocialSecurityNumber() &&
			((this.requesterSpouseSpouseSocialSecurityNumber == null) || (this.requesterSpouseSpouseSocialSecurityNumber.length() == 0)))
			return false;
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

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}
	
	public boolean checkSocialSecurityNumber() {
		return true;
	}

	public void setRequesterSpouseSpouseNationality(String requesterSpouseSpouseNationality) {
		this.requesterSpouseSpouseNationality = requesterSpouseSpouseNationality;
	}
	
	public String getRequesterSpouseSpouseNationality() {
		return this.requesterSpouseSpouseNationality;
	}
	
	public boolean checkRequesterSpouseSpouseNationality() {
		return true;
	}

	public void setRequesterSpouseSpouseInformationMaidenName(String requesterSpouseSpouseInformationMaidenName) {
		this.requesterSpouseSpouseInformationMaidenName = requesterSpouseSpouseInformationMaidenName;
	}
	
	public String getRequesterSpouseSpouseInformationMaidenName() {
		return this.requesterSpouseSpouseInformationMaidenName;
	}
	
	public boolean checkRequesterSpouseSpouseInformationMaidenName() {
		return true;
	}

	public void setRequesterSpouseSpouseInformationLastName(String requesterSpouseSpouseInformationLastName) {
		this.requesterSpouseSpouseInformationLastName = requesterSpouseSpouseInformationLastName;
	}
	
	public String getRequesterSpouseSpouseInformationLastName() {
		return this.requesterSpouseSpouseInformationLastName;
	}
	
	public boolean checkRequesterSpouseSpouseInformationLastName() {
		return true;
	}

	public void setRequesterSituationTutor(String requesterSituationTutor) {
		this.requesterSituationTutor = requesterSituationTutor;
	}
	
	public String getRequesterSituationTutor() {
		return this.requesterSituationTutor;
	}
	
	public boolean checkRequesterSituationTutor() {
		return true;
	}

	public void setRequesterSpouseSpouseInformationBirthDate(Calendar requesterSpouseSpouseInformationBirthDate) {
		this.requesterSpouseSpouseInformationBirthDate = requesterSpouseSpouseInformationBirthDate;
	}
	
	public Calendar getRequesterSpouseSpouseInformationBirthDate() {
		return this.requesterSpouseSpouseInformationBirthDate;
	}
	
	public boolean checkRequesterSpouseSpouseInformationBirthDate() {
		return true;
	}

	public void setRequesterSpouseSpouseEmployer(String requesterSpouseSpouseEmployer) {
		this.requesterSpouseSpouseEmployer = requesterSpouseSpouseEmployer;
	}
	
	public String getRequesterSpouseSpouseEmployer() {
		return this.requesterSpouseSpouseEmployer;
	}
	
	public boolean checkRequesterSpouseSpouseEmployer() {
		return !requesterSpouseSpousePensionner;
	}

	public void setRequesterSpouseSpouseFranceArrivalDate(Calendar requesterSpouseSpouseFranceArrivalDate) {
		this.requesterSpouseSpouseFranceArrivalDate = requesterSpouseSpouseFranceArrivalDate;
	}
	
	public Calendar getRequesterSpouseSpouseFranceArrivalDate() {
		return this.requesterSpouseSpouseFranceArrivalDate;
	}
	
	public boolean checkRequesterSpouseSpouseFranceArrivalDate() {
		return !requesterSpouseSpouseNationality.equals("French");
	}

  	public void setRequesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation(String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation) {
		this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation() {
		return this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setRequesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation(String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation) {
		this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation() {
		return this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setRequesterSpouseSpouseEmployerAddressStreetNumber(String requesterSpouseSpouseEmployerAddressStreetNumber) {
		this.requesterSpouseSpouseEmployerAddressStreetNumber = requesterSpouseSpouseEmployerAddressStreetNumber;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressStreetNumber() {
		return this.requesterSpouseSpouseEmployerAddressStreetNumber;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressStreetNumber() {
		return true;
	}

	public void setRequesterSpouseSpouseEmployerAddressStreetName(String requesterSpouseSpouseEmployerAddressStreetName) {
		this.requesterSpouseSpouseEmployerAddressStreetName = requesterSpouseSpouseEmployerAddressStreetName;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressStreetName() {
		return this.requesterSpouseSpouseEmployerAddressStreetName;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressStreetName() {
		return !requesterSpouseSpousePensionner;
	}

	public void setRequesterSpouseSpouseEmployerAddressPlaceNameOrService(String requesterSpouseSpouseEmployerAddressPlaceNameOrService) {
		this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressPlaceNameOrService() {
		return this.requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressPlaceNameOrService() {
		return true;
	}

	public void setRequesterSpouseSpouseEmployerAddressPostalCode(String requesterSpouseSpouseEmployerAddressPostalCode) {
		this.requesterSpouseSpouseEmployerAddressPostalCode = requesterSpouseSpouseEmployerAddressPostalCode;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressPostalCode() {
		return this.requesterSpouseSpouseEmployerAddressPostalCode;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressPostalCode() {
		return !requesterSpouseSpousePensionner;
	}

	public void setRequesterSpouseSpouseEmployerAddressCity(String requesterSpouseSpouseEmployerAddressCity) {
		this.requesterSpouseSpouseEmployerAddressCity = requesterSpouseSpouseEmployerAddressCity;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressCity() {
		return this.requesterSpouseSpouseEmployerAddressCity;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressCity() {
		return !requesterSpouseSpousePensionner;
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

	public void setRequesterSituationTutorPresence(boolean requesterSituationTutorPresence) {
		this.requesterSituationTutorPresence = requesterSituationTutorPresence;
	}
	
	public boolean getRequesterSituationTutorPresence() {
		return this.requesterSituationTutorPresence;
	}
	
	public boolean checkRequesterSituationTutorPresence() {
		return true;
	}

	public void setRequesterSpouseSpousePensionPlan(String requesterSpouseSpousePensionPlan) {
		this.requesterSpouseSpousePensionPlan = requesterSpouseSpousePensionPlan;
	}
	
	public String getRequesterSpouseSpousePensionPlan() {
		return this.requesterSpouseSpousePensionPlan;
	}
	
	public boolean checkRequesterSpouseSpousePensionPlan() {
		return requesterSpouseSpousePensionner;
	}

	public void setSubjectAdultMaidenName(String subjectAdultMaidenName) {
		this.subjectAdultMaidenName = subjectAdultMaidenName;
	}
	
	public String getSubjectAdultMaidenName() {
		return this.subjectAdultMaidenName;
	}
	
	public boolean checkSubjectAdultMaidenName() {
		return true;
	}

	public void setRequesterSpouseSpousePensionner(boolean requesterSpouseSpousePensionner) {
		this.requesterSpouseSpousePensionner = requesterSpouseSpousePensionner;
	}
	
	public boolean getRequesterSpouseSpousePensionner() {
		return this.requesterSpouseSpousePensionner;
	}
	
	public boolean checkRequesterSpouseSpousePensionner() {
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

	public void setSocialSecurityKeyNumber(String socialSecurityKeyNumber) {
		this.socialSecurityKeyNumber = socialSecurityKeyNumber;
	}
	
	public String getSocialSecurityKeyNumber() {
		return this.socialSecurityKeyNumber;
	}
	
	public boolean checkSocialSecurityKeyNumber() {
		return true;
	}

	public void setRequesterSpouseSpouseSocialSecurityKeyNumber(String requesterSpouseSpouseSocialSecurityKeyNumber) {
		this.requesterSpouseSpouseSocialSecurityKeyNumber = requesterSpouseSpouseSocialSecurityKeyNumber;
	}
	
	public String getRequesterSpouseSpouseSocialSecurityKeyNumber() {
		return this.requesterSpouseSpouseSocialSecurityKeyNumber;
	}
	
	public boolean checkRequesterSpouseSpouseSocialSecurityKeyNumber() {
		return true;
	}

	public void setFranceArrivalDate(Calendar franceArrivalDate) {
		this.franceArrivalDate = franceArrivalDate;
	}
	
	public Calendar getFranceArrivalDate() {
		return this.franceArrivalDate;
	}
	
	public boolean checkFranceArrivalDate() {
		return !nationality.equals("French");
	}

	public void setRequesterPensionPlan(String requesterPensionPlan) {
		this.requesterPensionPlan = requesterPensionPlan;
	}
	
	public String getRequesterPensionPlan() {
		return this.requesterPensionPlan;
	}
	
	public boolean checkRequesterPensionPlan() {
		return true;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	public boolean checkNationality() {
		return true;
	}

	public void setRequesterSituationTutorName(String requesterSituationTutorName) {
		this.requesterSituationTutorName = requesterSituationTutorName;
	}
	
	public String getRequesterSituationTutorName() {
		return this.requesterSituationTutorName;
	}
	
	public boolean checkRequesterSituationTutorName() {
		return true;
	}

  	public void setRequesterSituationTutorAddressAdditionalDeliveryInformation(String requesterSituationTutorAddressAdditionalDeliveryInformation) {
		this.requesterSituationTutorAddressAdditionalDeliveryInformation = requesterSituationTutorAddressAdditionalDeliveryInformation;
	}
	
	public String getRequesterSituationTutorAddressAdditionalDeliveryInformation() {
		return this.requesterSituationTutorAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkRequesterSituationTutorAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setRequesterSituationTutorAddressAdditionalGeographicalInformation(String requesterSituationTutorAddressAdditionalGeographicalInformation) {
		this.requesterSituationTutorAddressAdditionalGeographicalInformation = requesterSituationTutorAddressAdditionalGeographicalInformation;
	}
	
	public String getRequesterSituationTutorAddressAdditionalGeographicalInformation() {
		return this.requesterSituationTutorAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkRequesterSituationTutorAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setRequesterSituationTutorAddressStreetNumber(String requesterSituationTutorAddressStreetNumber) {
		this.requesterSituationTutorAddressStreetNumber = requesterSituationTutorAddressStreetNumber;
	}
	
	public String getRequesterSituationTutorAddressStreetNumber() {
		return this.requesterSituationTutorAddressStreetNumber;
	}
	
	public boolean checkRequesterSituationTutorAddressStreetNumber() {
		return true;
	}

	public void setRequesterSituationTutorAddressStreetName(String requesterSituationTutorAddressStreetName) {
		this.requesterSituationTutorAddressStreetName = requesterSituationTutorAddressStreetName;
	}
	
	public String getRequesterSituationTutorAddressStreetName() {
		return this.requesterSituationTutorAddressStreetName;
	}
	
	public boolean checkRequesterSituationTutorAddressStreetName() {
		return true;
	}

	public void setRequesterSituationTutorAddressPlaceNameOrService(String requesterSituationTutorAddressPlaceNameOrService) {
		this.requesterSituationTutorAddressPlaceNameOrService = requesterSituationTutorAddressPlaceNameOrService;
	}
	
	public String getRequesterSituationTutorAddressPlaceNameOrService() {
		return this.requesterSituationTutorAddressPlaceNameOrService;
	}
	
	public boolean checkRequesterSituationTutorAddressPlaceNameOrService() {
		return true;
	}

	public void setRequesterSituationTutorAddressPostalCode(String requesterSituationTutorAddressPostalCode) {
		this.requesterSituationTutorAddressPostalCode = requesterSituationTutorAddressPostalCode;
	}
	
	public String getRequesterSituationTutorAddressPostalCode() {
		return this.requesterSituationTutorAddressPostalCode;
	}
	
	public boolean checkRequesterSituationTutorAddressPostalCode() {
		return true;
	}

	public void setRequesterSituationTutorAddressCity(String requesterSituationTutorAddressCity) {
		this.requesterSituationTutorAddressCity = requesterSituationTutorAddressCity;
	}
	
	public String getRequesterSituationTutorAddressCity() {
		return this.requesterSituationTutorAddressCity;
	}
	
	public boolean checkRequesterSituationTutorAddressCity() {
		return true;
	}

	public void setSubjectAdultBirthPlaceCity(String subjectAdultBirthPlaceCity) {
		this.subjectAdultBirthPlaceCity = subjectAdultBirthPlaceCity;
	}
	
	public String getSubjectAdultBirthPlaceCity() {
		return this.subjectAdultBirthPlaceCity;
	}
	
	public boolean checkSubjectAdultBirthPlaceCity() {
		return true;
	}

	public void setRequesterSpouseSpouseInformationFirstName(String requesterSpouseSpouseInformationFirstName) {
		this.requesterSpouseSpouseInformationFirstName = requesterSpouseSpouseInformationFirstName;
	}
	
	public String getRequesterSpouseSpouseInformationFirstName() {
		return this.requesterSpouseSpouseInformationFirstName;
	}
	
	public boolean checkRequesterSpouseSpouseInformationFirstName() {
		return true;
	}

	public void setRequesterSpouseSpouseOccupation(String requesterSpouseSpouseOccupation) {
		this.requesterSpouseSpouseOccupation = requesterSpouseSpouseOccupation;
	}
	
	public String getRequesterSpouseSpouseOccupation() {
		return this.requesterSpouseSpouseOccupation;
	}
	
	public boolean checkRequesterSpouseSpouseOccupation() {
		return !requesterSpouseSpousePensionner;
	}

	public void setRequesterSpouseSpouseInformationBirthPlaceCity(String requesterSpouseSpouseInformationBirthPlaceCity) {
		this.requesterSpouseSpouseInformationBirthPlaceCity = requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public String getRequesterSpouseSpouseInformationBirthPlaceCity() {
		return this.requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public boolean checkRequesterSpouseSpouseInformationBirthPlaceCity() {
		return true;
	}

	public void setRequesterSpouseSpouseSocialSecurityNumber(String requesterSpouseSpouseSocialSecurityNumber) {
		this.requesterSpouseSpouseSocialSecurityNumber = requesterSpouseSpouseSocialSecurityNumber;
	}
	
	public String getRequesterSpouseSpouseSocialSecurityNumber() {
		return this.requesterSpouseSpouseSocialSecurityNumber;
	}
	
	public boolean checkRequesterSpouseSpouseSocialSecurityNumber() {
		return true;
	}

	public void setRequesterSituationTutorFirstName(String requesterSituationTutorFirstName) {
		this.requesterSituationTutorFirstName = requesterSituationTutorFirstName;
	}
	
	public String getRequesterSituationTutorFirstName() {
		return this.requesterSituationTutorFirstName;
	}
	
	public boolean checkRequesterSituationTutorFirstName() {
		return true;
	}

}
