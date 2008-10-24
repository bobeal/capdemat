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
	private String requesterSpouseSpouseNationality;
  	private String requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation;
	private String requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation;
	private String requesterFamilyReferentFamilyReferentAddressStreetNumber;
	private String requesterFamilyReferentFamilyReferentAddressStreetName;
	private String requesterFamilyReferentFamilyReferentAddressPlaceNameOrService;
	private String requesterFamilyReferentFamilyReferentAddressPostalCode;
	private String requesterFamilyReferentFamilyReferentAddressCity;
	private String requesterSpouseSpouseInformationMaidenName;
	private String requesterFamilyReferentFamilyReferentName;
	private String requesterSpouseSpouseInformationLastName;
	private String requesterSituationTutor;
	private String requesterSpouseSpouseComplementaryPensionPlanPrecision;
	private String requesterSpouseSpouseEmployer;
	private Calendar requesterSpouseSpouseInformationBirthDate;
  	private String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	private String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	private String requesterSpouseSpouseEmployerAddressStreetNumber;
	private String requesterSpouseSpouseEmployerAddressStreetName;
	private String requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	private String requesterSpouseSpouseEmployerAddressPostalCode;
	private String requesterSpouseSpouseEmployerAddressCity;
	private String pensionPlanPrecision;
	private Calendar requesterSpouseSpouseFranceArrivalDate;
	private String subjectAdultTitle;
	private boolean requesterFamilyReferentFamilyReferentDesignated;
	private String subjectAdultFirstName;
	private String subjectAdultFamilyStatus;
	private boolean requesterSituationTutorPresence;
	private String requesterSpouseSpouseInformationFamilyStatus;
	private String requesterSpouseSpousePensionPlan;
	private String subjectAdultMaidenName;
	private String requesterRequestKind;
	private String subjectAdultLastName;
	private boolean requesterSpouseSpousePensionner;
	private boolean requesterSpouseSpouseMoreThan15YearsInFrance;
	private Calendar franceArrivalDate;
	private String requesterSpouseSpouseInformationTitle;
	private String requesterFamilyReferentFamilyReferentFirstName;
	private String requesterPensionPlan;
	private String nationality;
	private boolean moreThan15YearsInFrance;
	private String requesterSpouseSpousePensionPlanPrecision;
	private String requesterSituationTutorName;
	private String complementaryPensionPlanPrecision;
  	private String requesterSituationTutorAddressAdditionalDeliveryInformation;
	private String requesterSituationTutorAddressAdditionalGeographicalInformation;
	private String requesterSituationTutorAddressStreetNumber;
	private String requesterSituationTutorAddressStreetName;
	private String requesterSituationTutorAddressPlaceNameOrService;
	private String requesterSituationTutorAddressPostalCode;
	private String requesterSituationTutorAddressCity;
	private String subjectAdultBirthPlaceCity;
	private String requesterSpouseSpouseOccupation;
	private String requesterSpouseSpouseInformationFirstName;
	private String requesterSpouseSpouseInformationBirthPlaceCity;

	public Subject() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("displayrequestkind")) {
		}
		if (state.equals("requestkind")) {
		}
		if (state.equals("referent")) {
		}
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
		if (state.equals("displayreferent")) {
		}
		if (state.equals("display")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			if (request.getRequesterSpouse().getSpouseNationality() != null)
			this.requesterSpouseSpouseNationality = request.getRequesterSpouse().getSpouseNationality().toString();
  			this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation = request.getRequesterFamilyReferent().getFamilyReferentAddress().getAdditionalDeliveryInformation();
			this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation = request.getRequesterFamilyReferent().getFamilyReferentAddress().getAdditionalGeographicalInformation();
			this.requesterFamilyReferentFamilyReferentAddressStreetNumber = request.getRequesterFamilyReferent().getFamilyReferentAddress().getStreetNumber();
			this.requesterFamilyReferentFamilyReferentAddressStreetName = request.getRequesterFamilyReferent().getFamilyReferentAddress().getStreetName();
			this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService = request.getRequesterFamilyReferent().getFamilyReferentAddress().getPlaceNameOrService();
			this.requesterFamilyReferentFamilyReferentAddressPostalCode = request.getRequesterFamilyReferent().getFamilyReferentAddress().getPostalCode();
			this.requesterFamilyReferentFamilyReferentAddressCity = request.getRequesterFamilyReferent().getFamilyReferentAddress().getCity();
			this.requesterSpouseSpouseInformationMaidenName = request.getRequesterSpouse().getSpouseInformation().getMaidenName();
			this.requesterFamilyReferentFamilyReferentName = request.getRequesterFamilyReferent().getFamilyReferentName();
			this.requesterSpouseSpouseInformationLastName = request.getRequesterSpouse().getSpouseInformation().getLastName();
			if (request.getRequesterSituation().getTutor() != null)
			this.requesterSituationTutor = request.getRequesterSituation().getTutor().toString();
			this.requesterSpouseSpouseComplementaryPensionPlanPrecision = request.getRequesterSpouse().getSpouseComplementaryPensionPlanPrecision();
			this.requesterSpouseSpouseEmployer = request.getRequesterSpouse().getSpouseEmployer();
			this.requesterSpouseSpouseInformationBirthDate = request.getRequesterSpouse().getSpouseInformation().getBirthDate();
  			this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalDeliveryInformation();
			this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalGeographicalInformation();
			this.requesterSpouseSpouseEmployerAddressStreetNumber = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetNumber();
			this.requesterSpouseSpouseEmployerAddressStreetName = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetName();
			this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = request.getRequesterSpouse().getSpouseEmployerAddress().getPlaceNameOrService();
			this.requesterSpouseSpouseEmployerAddressPostalCode = request.getRequesterSpouse().getSpouseEmployerAddress().getPostalCode();
			this.requesterSpouseSpouseEmployerAddressCity = request.getRequesterSpouse().getSpouseEmployerAddress().getCity();
			this.pensionPlanPrecision = request.getPensionPlanPrecision();
			this.requesterSpouseSpouseFranceArrivalDate = request.getRequesterSpouse().getSpouseFranceArrivalDate();
			if (request.getSubject().getAdult().getTitle() != null)
			this.subjectAdultTitle = request.getSubject().getAdult().getTitle().toString();
			this.requesterFamilyReferentFamilyReferentDesignated = request.getRequesterFamilyReferent().getFamilyReferentDesignated();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
			if (request.getSubject().getAdult().getFamilyStatus() != null)
			this.subjectAdultFamilyStatus = request.getSubject().getAdult().getFamilyStatus().toString();
			this.requesterSituationTutorPresence = request.getRequesterSituation().getTutorPresence();
			if (request.getRequesterSpouse().getSpouseInformation().getFamilyStatus() != null)
			this.requesterSpouseSpouseInformationFamilyStatus = request.getRequesterSpouse().getSpouseInformation().getFamilyStatus().toString();
			if (request.getRequesterSpouse().getSpousePensionPlan() != null)
			this.requesterSpouseSpousePensionPlan = request.getRequesterSpouse().getSpousePensionPlan().toString();
			this.subjectAdultMaidenName = request.getSubject().getAdult().getMaidenName();
			if (request.getRequesterRequestKind() != null)
			this.requesterRequestKind = request.getRequesterRequestKind().toString();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.requesterSpouseSpousePensionner = request.getRequesterSpouse().getSpousePensionner();
			this.requesterSpouseSpouseMoreThan15YearsInFrance = request.getRequesterSpouse().getSpouseMoreThan15YearsInFrance();
			this.franceArrivalDate = request.getFranceArrivalDate();
			if (request.getRequesterSpouse().getSpouseInformation().getTitle() != null)
			this.requesterSpouseSpouseInformationTitle = request.getRequesterSpouse().getSpouseInformation().getTitle().toString();
			this.requesterFamilyReferentFamilyReferentFirstName = request.getRequesterFamilyReferent().getFamilyReferentFirstName();
			if (request.getRequesterPensionPlan() != null)
			this.requesterPensionPlan = request.getRequesterPensionPlan().toString();
			if (request.getNationality() != null)
			this.nationality = request.getNationality().toString();
			this.moreThan15YearsInFrance = request.getMoreThan15YearsInFrance();
			this.requesterSpouseSpousePensionPlanPrecision = request.getRequesterSpouse().getSpousePensionPlanPrecision();
			this.requesterSituationTutorName = request.getRequesterSituation().getTutorName();
			this.complementaryPensionPlanPrecision = request.getComplementaryPensionPlanPrecision();
  			this.requesterSituationTutorAddressAdditionalDeliveryInformation = request.getRequesterSituation().getTutorAddress().getAdditionalDeliveryInformation();
			this.requesterSituationTutorAddressAdditionalGeographicalInformation = request.getRequesterSituation().getTutorAddress().getAdditionalGeographicalInformation();
			this.requesterSituationTutorAddressStreetNumber = request.getRequesterSituation().getTutorAddress().getStreetNumber();
			this.requesterSituationTutorAddressStreetName = request.getRequesterSituation().getTutorAddress().getStreetName();
			this.requesterSituationTutorAddressPlaceNameOrService = request.getRequesterSituation().getTutorAddress().getPlaceNameOrService();
			this.requesterSituationTutorAddressPostalCode = request.getRequesterSituation().getTutorAddress().getPostalCode();
			this.requesterSituationTutorAddressCity = request.getRequesterSituation().getTutorAddress().getCity();
			this.subjectAdultBirthPlaceCity = request.getSubject().getAdult().getBirthPlace().getCity();
			this.requesterSpouseSpouseOccupation = request.getRequesterSpouse().getSpouseOccupation();
			this.requesterSpouseSpouseInformationFirstName = request.getRequesterSpouse().getSpouseInformation().getFirstName();
			this.requesterSpouseSpouseInformationBirthPlaceCity = request.getRequesterSpouse().getSpouseInformation().getBirthPlace().getCity();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.getRequesterSpouse().setSpouseNationality(NationalityType.Enum.forString(this.requesterSpouseSpouseNationality));
  			request.getRequesterFamilyReferent().getFamilyReferentAddress().setAdditionalDeliveryInformation(this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setAdditionalGeographicalInformation(this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setStreetNumber(this.requesterFamilyReferentFamilyReferentAddressStreetNumber);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setStreetName(this.requesterFamilyReferentFamilyReferentAddressStreetName);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setPlaceNameOrService(this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setPostalCode(this.requesterFamilyReferentFamilyReferentAddressPostalCode);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setCity(this.requesterFamilyReferentFamilyReferentAddressCity);
			request.getRequesterSpouse().getSpouseInformation().setMaidenName(this.requesterSpouseSpouseInformationMaidenName);
			request.getRequesterFamilyReferent().setFamilyReferentName(this.requesterFamilyReferentFamilyReferentName);
			request.getRequesterSpouse().getSpouseInformation().setLastName(this.requesterSpouseSpouseInformationLastName);
			request.getRequesterSituation().setTutor(DhrTutorType.Enum.forString(this.requesterSituationTutor));
			request.getRequesterSpouse().setSpouseComplementaryPensionPlanPrecision(this.requesterSpouseSpouseComplementaryPensionPlanPrecision);
			request.getRequesterSpouse().setSpouseEmployer(this.requesterSpouseSpouseEmployer);
			request.getRequesterSpouse().getSpouseInformation().setBirthDate(this.requesterSpouseSpouseInformationBirthDate);
  			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalDeliveryInformation(this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalGeographicalInformation(this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetNumber(this.requesterSpouseSpouseEmployerAddressStreetNumber);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetName(this.requesterSpouseSpouseEmployerAddressStreetName);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPlaceNameOrService(this.requesterSpouseSpouseEmployerAddressPlaceNameOrService);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPostalCode(this.requesterSpouseSpouseEmployerAddressPostalCode);
			request.getRequesterSpouse().getSpouseEmployerAddress().setCity(this.requesterSpouseSpouseEmployerAddressCity);
			request.setPensionPlanPrecision(this.pensionPlanPrecision);
			request.getRequesterSpouse().setSpouseFranceArrivalDate(this.requesterSpouseSpouseFranceArrivalDate);
			request.getSubject().getAdult().setTitle(TitleType.Enum.forString(this.subjectAdultTitle));
			request.getRequesterFamilyReferent().setFamilyReferentDesignated(this.requesterFamilyReferentFamilyReferentDesignated);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
			request.getSubject().getAdult().setFamilyStatus(FamilyStatusType.Enum.forString(this.subjectAdultFamilyStatus));
			request.getRequesterSituation().setTutorPresence(this.requesterSituationTutorPresence);
			request.getRequesterSpouse().getSpouseInformation().setFamilyStatus(FamilyStatusType.Enum.forString(this.requesterSpouseSpouseInformationFamilyStatus));
			request.getRequesterSpouse().setSpousePensionPlan(DhrPensionPlanType.Enum.forString(this.requesterSpouseSpousePensionPlan));
			request.getSubject().getAdult().setMaidenName(this.subjectAdultMaidenName);
			request.setRequesterRequestKind(DhrRequestKindType.Enum.forString(this.requesterRequestKind));
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.getRequesterSpouse().setSpousePensionner(this.requesterSpouseSpousePensionner);
			request.getRequesterSpouse().setSpouseMoreThan15YearsInFrance(this.requesterSpouseSpouseMoreThan15YearsInFrance);
			request.setFranceArrivalDate(this.franceArrivalDate);
			request.getRequesterSpouse().getSpouseInformation().setTitle(TitleType.Enum.forString(this.requesterSpouseSpouseInformationTitle));
			request.getRequesterFamilyReferent().setFamilyReferentFirstName(this.requesterFamilyReferentFamilyReferentFirstName);
			request.setRequesterPensionPlan(DhrPensionPlanType.Enum.forString(this.requesterPensionPlan));
			request.setNationality(NationalityType.Enum.forString(this.nationality));
			request.setMoreThan15YearsInFrance(this.moreThan15YearsInFrance);
			request.getRequesterSpouse().setSpousePensionPlanPrecision(this.requesterSpouseSpousePensionPlanPrecision);
			request.getRequesterSituation().setTutorName(this.requesterSituationTutorName);
			request.setComplementaryPensionPlanPrecision(this.complementaryPensionPlanPrecision);
  			request.getRequesterSituation().getTutorAddress().setAdditionalDeliveryInformation(this.requesterSituationTutorAddressAdditionalDeliveryInformation);
			request.getRequesterSituation().getTutorAddress().setAdditionalGeographicalInformation(this.requesterSituationTutorAddressAdditionalGeographicalInformation);
			request.getRequesterSituation().getTutorAddress().setStreetNumber(this.requesterSituationTutorAddressStreetNumber);
			request.getRequesterSituation().getTutorAddress().setStreetName(this.requesterSituationTutorAddressStreetName);
			request.getRequesterSituation().getTutorAddress().setPlaceNameOrService(this.requesterSituationTutorAddressPlaceNameOrService);
			request.getRequesterSituation().getTutorAddress().setPostalCode(this.requesterSituationTutorAddressPostalCode);
			request.getRequesterSituation().getTutorAddress().setCity(this.requesterSituationTutorAddressCity);
			request.getSubject().getAdult().getBirthPlace().setCity(this.subjectAdultBirthPlaceCity);
			request.getRequesterSpouse().setSpouseOccupation(this.requesterSpouseSpouseOccupation);
			request.getRequesterSpouse().getSpouseInformation().setFirstName(this.requesterSpouseSpouseInformationFirstName);
			request.getRequesterSpouse().getSpouseInformation().getBirthPlace().setCity(this.requesterSpouseSpouseInformationBirthPlaceCity);
		}
	}
	
	public boolean isComplete() {
		if (this.checkRequesterSpouseSpouseNationality() &&
			((this.requesterSpouseSpouseNationality == null) || (this.requesterSpouseSpouseNationality.length() == 0)))
			return false;
  		if (this.checkRequesterFamilyReferentFamilyReferentAddressStreetName() &&
			((this.requesterFamilyReferentFamilyReferentAddressStreetName == null) || (this.requesterFamilyReferentFamilyReferentAddressStreetName.length() == 0)))
			return false;
		if (this.checkRequesterFamilyReferentFamilyReferentAddressPostalCode() &&
			((this.requesterFamilyReferentFamilyReferentAddressPostalCode == null) || (this.requesterFamilyReferentFamilyReferentAddressPostalCode.length() == 0)))
			return false;
		if (this.checkRequesterFamilyReferentFamilyReferentAddressCity() &&
			((this.requesterFamilyReferentFamilyReferentAddressCity == null) || (this.requesterFamilyReferentFamilyReferentAddressCity.length() == 0)))
			return false;
		if (this.checkRequesterFamilyReferentFamilyReferentName() &&
			((this.requesterFamilyReferentFamilyReferentName == null) || (this.requesterFamilyReferentFamilyReferentName.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationLastName() &&
			((this.requesterSpouseSpouseInformationLastName == null) || (this.requesterSpouseSpouseInformationLastName.length() == 0)))
			return false;
		if (this.checkRequesterSituationTutor() &&
			((this.requesterSituationTutor == null) || (this.requesterSituationTutor.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseEmployer() &&
			((this.requesterSpouseSpouseEmployer == null) || (this.requesterSpouseSpouseEmployer.length() == 0)))
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
		if (this.checkPensionPlanPrecision() &&
			((this.pensionPlanPrecision == null) || (this.pensionPlanPrecision.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseFranceArrivalDate() && (this.requesterSpouseSpouseFranceArrivalDate == null))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
			return false;
		if (this.checkSubjectAdultFamilyStatus() &&
			((this.subjectAdultFamilyStatus == null) || (this.subjectAdultFamilyStatus.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationFamilyStatus() &&
			((this.requesterSpouseSpouseInformationFamilyStatus == null) || (this.requesterSpouseSpouseInformationFamilyStatus.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpousePensionPlan() &&
			((this.requesterSpouseSpousePensionPlan == null) || (this.requesterSpouseSpousePensionPlan.length() == 0)))
			return false;
		if (this.checkRequesterRequestKind() &&
			((this.requesterRequestKind == null) || (this.requesterRequestKind.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
			return false;
		if (this.checkFranceArrivalDate() && (this.franceArrivalDate == null))
			return false;
		if (this.checkRequesterFamilyReferentFamilyReferentFirstName() &&
			((this.requesterFamilyReferentFamilyReferentFirstName == null) || (this.requesterFamilyReferentFamilyReferentFirstName.length() == 0)))
			return false;
		if (this.checkRequesterPensionPlan() &&
			((this.requesterPensionPlan == null) || (this.requesterPensionPlan.length() == 0)))
			return false;
		if (this.checkNationality() &&
			((this.nationality == null) || (this.nationality.length() == 0)))
			return false;
		if (this.checkRequesterSituationTutorName() &&
			((this.requesterSituationTutorName == null) || (this.requesterSituationTutorName.length() == 0)))
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
		if (this.checkRequesterSpouseSpouseOccupation() &&
			((this.requesterSpouseSpouseOccupation == null) || (this.requesterSpouseSpouseOccupation.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationFirstName() &&
			((this.requesterSpouseSpouseInformationFirstName == null) || (this.requesterSpouseSpouseInformationFirstName.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationBirthPlaceCity() &&
			((this.requesterSpouseSpouseInformationBirthPlaceCity == null) || (this.requesterSpouseSpouseInformationBirthPlaceCity.length() == 0)))
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

	public void setRequesterSpouseSpouseNationality(String requesterSpouseSpouseNationality) {
		this.requesterSpouseSpouseNationality = requesterSpouseSpouseNationality;
	}
	
	public String getRequesterSpouseSpouseNationality() {
		return this.requesterSpouseSpouseNationality;
	}
	
	public boolean checkRequesterSpouseSpouseNationality() {
		return true;
	}

  	public void setRequesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation(String requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation) {
		this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation = requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation() {
		return this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation(String requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation) {
		this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation = requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation() {
		return this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressStreetNumber(String requesterFamilyReferentFamilyReferentAddressStreetNumber) {
		this.requesterFamilyReferentFamilyReferentAddressStreetNumber = requesterFamilyReferentFamilyReferentAddressStreetNumber;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressStreetNumber() {
		return this.requesterFamilyReferentFamilyReferentAddressStreetNumber;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressStreetNumber() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressStreetName(String requesterFamilyReferentFamilyReferentAddressStreetName) {
		this.requesterFamilyReferentFamilyReferentAddressStreetName = requesterFamilyReferentFamilyReferentAddressStreetName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressStreetName() {
		return this.requesterFamilyReferentFamilyReferentAddressStreetName;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressStreetName() {
		return requesterFamilyReferentFamilyReferentDesignated;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressPlaceNameOrService(String requesterFamilyReferentFamilyReferentAddressPlaceNameOrService) {
		this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService = requesterFamilyReferentFamilyReferentAddressPlaceNameOrService;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressPlaceNameOrService() {
		return this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressPlaceNameOrService() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressPostalCode(String requesterFamilyReferentFamilyReferentAddressPostalCode) {
		this.requesterFamilyReferentFamilyReferentAddressPostalCode = requesterFamilyReferentFamilyReferentAddressPostalCode;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressPostalCode() {
		return this.requesterFamilyReferentFamilyReferentAddressPostalCode;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressPostalCode() {
		return requesterFamilyReferentFamilyReferentDesignated;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressCity(String requesterFamilyReferentFamilyReferentAddressCity) {
		this.requesterFamilyReferentFamilyReferentAddressCity = requesterFamilyReferentFamilyReferentAddressCity;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressCity() {
		return this.requesterFamilyReferentFamilyReferentAddressCity;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressCity() {
		return requesterFamilyReferentFamilyReferentDesignated;
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

	public void setRequesterFamilyReferentFamilyReferentName(String requesterFamilyReferentFamilyReferentName) {
		this.requesterFamilyReferentFamilyReferentName = requesterFamilyReferentFamilyReferentName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentName() {
		return this.requesterFamilyReferentFamilyReferentName;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentName() {
		return requesterFamilyReferentFamilyReferentDesignated;
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

	public void setRequesterSpouseSpouseComplementaryPensionPlanPrecision(String requesterSpouseSpouseComplementaryPensionPlanPrecision) {
		this.requesterSpouseSpouseComplementaryPensionPlanPrecision = requesterSpouseSpouseComplementaryPensionPlanPrecision;
	}
	
	public String getRequesterSpouseSpouseComplementaryPensionPlanPrecision() {
		return this.requesterSpouseSpouseComplementaryPensionPlanPrecision;
	}
	
	public boolean checkRequesterSpouseSpouseComplementaryPensionPlanPrecision() {
		return requesterSpouseSpousePensionner;
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

	public void setRequesterSpouseSpouseInformationBirthDate(Calendar requesterSpouseSpouseInformationBirthDate) {
		this.requesterSpouseSpouseInformationBirthDate = requesterSpouseSpouseInformationBirthDate;
	}
	
	public Calendar getRequesterSpouseSpouseInformationBirthDate() {
		return this.requesterSpouseSpouseInformationBirthDate;
	}
	
	public boolean checkRequesterSpouseSpouseInformationBirthDate() {
		return true;
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

	public void setPensionPlanPrecision(String pensionPlanPrecision) {
		this.pensionPlanPrecision = pensionPlanPrecision;
	}
	
	public String getPensionPlanPrecision() {
		return this.pensionPlanPrecision;
	}
	
	public boolean checkPensionPlanPrecision() {
		return requesterPensionPlan.equals("Other");
	}

	public void setRequesterSpouseSpouseFranceArrivalDate(Calendar requesterSpouseSpouseFranceArrivalDate) {
		this.requesterSpouseSpouseFranceArrivalDate = requesterSpouseSpouseFranceArrivalDate;
	}
	
	public Calendar getRequesterSpouseSpouseFranceArrivalDate() {
		return this.requesterSpouseSpouseFranceArrivalDate;
	}
	
	public boolean checkRequesterSpouseSpouseFranceArrivalDate() {
		return requesterSpouseSpouseNationality.equals("OutsideEuropeanUnion");
	}

	public void setSubjectAdultTitle(String subjectAdultTitle) {
		this.subjectAdultTitle = subjectAdultTitle;
	}
	
	public String getSubjectAdultTitle() {
		return this.subjectAdultTitle;
	}
	
	public boolean checkSubjectAdultTitle() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentDesignated(boolean requesterFamilyReferentFamilyReferentDesignated) {
		this.requesterFamilyReferentFamilyReferentDesignated = requesterFamilyReferentFamilyReferentDesignated;
	}
	
	public boolean getRequesterFamilyReferentFamilyReferentDesignated() {
		return this.requesterFamilyReferentFamilyReferentDesignated;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentDesignated() {
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

	public void setSubjectAdultFamilyStatus(String subjectAdultFamilyStatus) {
		this.subjectAdultFamilyStatus = subjectAdultFamilyStatus;
	}
	
	public String getSubjectAdultFamilyStatus() {
		return this.subjectAdultFamilyStatus;
	}
	
	public boolean checkSubjectAdultFamilyStatus() {
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

	public void setRequesterSpouseSpouseInformationFamilyStatus(String requesterSpouseSpouseInformationFamilyStatus) {
		this.requesterSpouseSpouseInformationFamilyStatus = requesterSpouseSpouseInformationFamilyStatus;
	}
	
	public String getRequesterSpouseSpouseInformationFamilyStatus() {
		return this.requesterSpouseSpouseInformationFamilyStatus;
	}
	
	public boolean checkRequesterSpouseSpouseInformationFamilyStatus() {
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

	public void setRequesterRequestKind(String requesterRequestKind) {
		this.requesterRequestKind = requesterRequestKind;
	}
	
	public String getRequesterRequestKind() {
		return this.requesterRequestKind;
	}
	
	public boolean checkRequesterRequestKind() {
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

	public void setRequesterSpouseSpousePensionner(boolean requesterSpouseSpousePensionner) {
		this.requesterSpouseSpousePensionner = requesterSpouseSpousePensionner;
	}
	
	public boolean getRequesterSpouseSpousePensionner() {
		return this.requesterSpouseSpousePensionner;
	}
	
	public boolean checkRequesterSpouseSpousePensionner() {
		return true;
	}

	public void setRequesterSpouseSpouseMoreThan15YearsInFrance(boolean requesterSpouseSpouseMoreThan15YearsInFrance) {
		this.requesterSpouseSpouseMoreThan15YearsInFrance = requesterSpouseSpouseMoreThan15YearsInFrance;
	}
	
	public boolean getRequesterSpouseSpouseMoreThan15YearsInFrance() {
		return this.requesterSpouseSpouseMoreThan15YearsInFrance;
	}
	
	public boolean checkRequesterSpouseSpouseMoreThan15YearsInFrance() {
		return requesterSpouseSpouseNationality.equals("OutsideEuropeanUnion");
	}

	public void setFranceArrivalDate(Calendar franceArrivalDate) {
		this.franceArrivalDate = franceArrivalDate;
	}
	
	public Calendar getFranceArrivalDate() {
		return this.franceArrivalDate;
	}
	
	public boolean checkFranceArrivalDate() {
		return nationality.equals("OutsideEuropeanUnion");
	}

	public void setRequesterSpouseSpouseInformationTitle(String requesterSpouseSpouseInformationTitle) {
		this.requesterSpouseSpouseInformationTitle = requesterSpouseSpouseInformationTitle;
	}
	
	public String getRequesterSpouseSpouseInformationTitle() {
		return this.requesterSpouseSpouseInformationTitle;
	}
	
	public boolean checkRequesterSpouseSpouseInformationTitle() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentFirstName(String requesterFamilyReferentFamilyReferentFirstName) {
		this.requesterFamilyReferentFamilyReferentFirstName = requesterFamilyReferentFamilyReferentFirstName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentFirstName() {
		return this.requesterFamilyReferentFamilyReferentFirstName;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentFirstName() {
		return requesterFamilyReferentFamilyReferentDesignated;
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

	public void setMoreThan15YearsInFrance(boolean moreThan15YearsInFrance) {
		this.moreThan15YearsInFrance = moreThan15YearsInFrance;
	}
	
	public boolean getMoreThan15YearsInFrance() {
		return this.moreThan15YearsInFrance;
	}
	
	public boolean checkMoreThan15YearsInFrance() {
		return nationality.equals("OutsideEuropeanUnion");
	}

	public void setRequesterSpouseSpousePensionPlanPrecision(String requesterSpouseSpousePensionPlanPrecision) {
		this.requesterSpouseSpousePensionPlanPrecision = requesterSpouseSpousePensionPlanPrecision;
	}
	
	public String getRequesterSpouseSpousePensionPlanPrecision() {
		return this.requesterSpouseSpousePensionPlanPrecision;
	}
	
	public boolean checkRequesterSpouseSpousePensionPlanPrecision() {
		return requesterSpouseSpousePensionPlan.equals("Other");
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

	public void setComplementaryPensionPlanPrecision(String complementaryPensionPlanPrecision) {
		this.complementaryPensionPlanPrecision = complementaryPensionPlanPrecision;
	}
	
	public String getComplementaryPensionPlanPrecision() {
		return this.complementaryPensionPlanPrecision;
	}
	
	public boolean checkComplementaryPensionPlanPrecision() {
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

	public void setRequesterSpouseSpouseOccupation(String requesterSpouseSpouseOccupation) {
		this.requesterSpouseSpouseOccupation = requesterSpouseSpouseOccupation;
	}
	
	public String getRequesterSpouseSpouseOccupation() {
		return this.requesterSpouseSpouseOccupation;
	}
	
	public boolean checkRequesterSpouseSpouseOccupation() {
		return !requesterSpouseSpousePensionner;
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

	public void setRequesterSpouseSpouseInformationBirthPlaceCity(String requesterSpouseSpouseInformationBirthPlaceCity) {
		this.requesterSpouseSpouseInformationBirthPlaceCity = requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public String getRequesterSpouseSpouseInformationBirthPlaceCity() {
		return this.requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public boolean checkRequesterSpouseSpouseInformationBirthPlaceCity() {
		return true;
	}

}