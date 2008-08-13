package fr.cg95.cvq.fo.social.domestichelp.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class Validation extends IStageForm {

	private String requesterSituationTutorFirstName;
	private String socialSecurityNumber;
	private String requesterSpouseSpouseInformationMaidenName;
	private Calendar requesterSpouseSpouseInformationBirthDate;
	private String requesterSituationTutor;
	private String requesterSpouseSpouseInformationFirstName;
	private Calendar currentDwellingCurrentDwellingArrivalDate;
	private String requesterSituationTutorName;
	private java.math.BigInteger requesterSpouseIncomesSpouseAllowances;
	private String subjectAdultFirstName;
	private java.math.BigInteger capitalsSharesAmount;
  	private String requesterSituationTutorAddressAdditionalDeliveryInformation;
	private String requesterSituationTutorAddressAdditionalGeographicalInformation;
	private String requesterSituationTutorAddressStreetNumber;
	private String requesterSituationTutorAddressStreetName;
	private String requesterSituationTutorAddressPlaceNameOrService;
	private String requesterSituationTutorAddressPostalCode;
	private String requesterSituationTutorAddressCity;
  	private String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	private String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	private String currentDwellingCurrentDwellingAddressStreetNumber;
	private String currentDwellingCurrentDwellingAddressStreetName;
	private String currentDwellingCurrentDwellingAddressPlaceNameOrService;
	private String currentDwellingCurrentDwellingAddressPostalCode;
	private String currentDwellingCurrentDwellingAddressCity;
	private String requesterSpouseSpouseInformationLastName;
	private String subjectAdultLastName;
  	private String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	private String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	private String requesterSpouseSpouseEmployerAddressStreetNumber;
	private String requesterSpouseSpouseEmployerAddressStreetName;
	private String requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	private String requesterSpouseSpouseEmployerAddressPostalCode;
	private String requesterSpouseSpouseEmployerAddressCity;
	private String subjectAdultBirthPlaceCity;
	private java.math.BigInteger taxesAmountLocalRate;
	private java.math.BigInteger requesterIncomesRequesterInvestmentIncome;
	private Calendar requesterSpouseSpouseFranceArrivalDate;
	private String requesterSpouseSpouseInformationBirthPlaceCity;
	private String requesterSpouseSpouseEmployer;
	private java.math.BigInteger capitalsBondsAmount;
	private String currentDwellingCurrentDwellingType;
	private java.math.BigInteger requesterSpouseIncomesSpouseInvestmentIncome;
	private java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea;
	private String requesterPensionPlan;
	private java.math.BigInteger requesterSpouseIncomesSpouseNetIncome;
	private boolean requesterSituationTutorPresence;
	private java.math.BigInteger taxesAmountPropertyTaxes;
	private String requesterSpouseSpousePensionPlan;
	private String nationality;
	private boolean requesterSpouseSpousePensionner;
	private java.math.BigInteger currentDwellingCurrentDwellingRoomNumber;
	private java.math.BigInteger requesterIncomesRequesterPensions;
	private java.math.BigInteger mensualExpensesRent;
	private String currentDwellingCurrentDwellingStatus;
	private String requesterSpouseSpouseNationality;
	private String requesterSpouseSpouseOccupation;
	private java.math.BigInteger taxesAmountProfessionalTaxes;
	private String requesterSpouseSpouseSocialSecurityNumber;
	private java.math.BigInteger mensualExpensesAlimonies;
	private java.math.BigInteger taxesAmountIncomeTax;
	private String socialSecurityKeyNumber;
	private Calendar franceArrivalDate;
	private Calendar subjectAdultBirthDate;
	private java.math.BigInteger requesterSpouseIncomesSpousePensions;
	private String subjectAdultMaidenName;
	private java.math.BigInteger requesterIncomesRequesterAllowances;
	private java.math.BigInteger requesterIncomesRequesterNetIncome;
	private String requesterSpouseSpouseSocialSecurityKeyNumber;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.requesterSituationTutorFirstName = request.getRequesterSituation().getTutorFirstName();
			this.socialSecurityNumber = request.getSocialSecurityNumber();
			this.requesterSpouseSpouseInformationMaidenName = request.getRequesterSpouse().getSpouseInformation().getMaidenName();
			this.requesterSpouseSpouseInformationBirthDate = request.getRequesterSpouse().getSpouseInformation().getBirthDate();
			if (request.getRequesterSituation().getTutor() != null)
			this.requesterSituationTutor = request.getRequesterSituation().getTutor().toString();
			this.requesterSpouseSpouseInformationFirstName = request.getRequesterSpouse().getSpouseInformation().getFirstName();
			this.currentDwellingCurrentDwellingArrivalDate = request.getCurrentDwelling().getCurrentDwellingArrivalDate();
			this.requesterSituationTutorName = request.getRequesterSituation().getTutorName();
			this.requesterSpouseIncomesSpouseAllowances = request.getRequesterSpouseIncomes().getSpouseAllowances();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
			this.capitalsSharesAmount = request.getCapitals().getSharesAmount();
  			this.requesterSituationTutorAddressAdditionalDeliveryInformation = request.getRequesterSituation().getTutorAddress().getAdditionalDeliveryInformation();
			this.requesterSituationTutorAddressAdditionalGeographicalInformation = request.getRequesterSituation().getTutorAddress().getAdditionalGeographicalInformation();
			this.requesterSituationTutorAddressStreetNumber = request.getRequesterSituation().getTutorAddress().getStreetNumber();
			this.requesterSituationTutorAddressStreetName = request.getRequesterSituation().getTutorAddress().getStreetName();
			this.requesterSituationTutorAddressPlaceNameOrService = request.getRequesterSituation().getTutorAddress().getPlaceNameOrService();
			this.requesterSituationTutorAddressPostalCode = request.getRequesterSituation().getTutorAddress().getPostalCode();
			this.requesterSituationTutorAddressCity = request.getRequesterSituation().getTutorAddress().getCity();
  			this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalDeliveryInformation();
			this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalGeographicalInformation();
			this.currentDwellingCurrentDwellingAddressStreetNumber = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetNumber();
			this.currentDwellingCurrentDwellingAddressStreetName = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetName();
			this.currentDwellingCurrentDwellingAddressPlaceNameOrService = request.getCurrentDwelling().getCurrentDwellingAddress().getPlaceNameOrService();
			this.currentDwellingCurrentDwellingAddressPostalCode = request.getCurrentDwelling().getCurrentDwellingAddress().getPostalCode();
			this.currentDwellingCurrentDwellingAddressCity = request.getCurrentDwelling().getCurrentDwellingAddress().getCity();
			this.requesterSpouseSpouseInformationLastName = request.getRequesterSpouse().getSpouseInformation().getLastName();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
  			this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalDeliveryInformation();
			this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalGeographicalInformation();
			this.requesterSpouseSpouseEmployerAddressStreetNumber = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetNumber();
			this.requesterSpouseSpouseEmployerAddressStreetName = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetName();
			this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = request.getRequesterSpouse().getSpouseEmployerAddress().getPlaceNameOrService();
			this.requesterSpouseSpouseEmployerAddressPostalCode = request.getRequesterSpouse().getSpouseEmployerAddress().getPostalCode();
			this.requesterSpouseSpouseEmployerAddressCity = request.getRequesterSpouse().getSpouseEmployerAddress().getCity();
			this.subjectAdultBirthPlaceCity = request.getSubject().getAdult().getBirthPlace().getCity();
			this.taxesAmountLocalRate = request.getTaxesAmount().getLocalRate();
			this.requesterIncomesRequesterInvestmentIncome = request.getRequesterIncomes().getRequesterInvestmentIncome();
			this.requesterSpouseSpouseFranceArrivalDate = request.getRequesterSpouse().getSpouseFranceArrivalDate();
			this.requesterSpouseSpouseInformationBirthPlaceCity = request.getRequesterSpouse().getSpouseInformation().getBirthPlace().getCity();
			this.requesterSpouseSpouseEmployer = request.getRequesterSpouse().getSpouseEmployer();
			this.capitalsBondsAmount = request.getCapitals().getBondsAmount();
			if (request.getCurrentDwelling().getCurrentDwellingType() != null)
			this.currentDwellingCurrentDwellingType = request.getCurrentDwelling().getCurrentDwellingType().toString();
			this.requesterSpouseIncomesSpouseInvestmentIncome = request.getRequesterSpouseIncomes().getSpouseInvestmentIncome();
			this.currentDwellingCurrentDwellingNetFloorArea = request.getCurrentDwelling().getCurrentDwellingNetFloorArea();
			if (request.getRequesterPensionPlan() != null)
			this.requesterPensionPlan = request.getRequesterPensionPlan().toString();
			this.requesterSpouseIncomesSpouseNetIncome = request.getRequesterSpouseIncomes().getSpouseNetIncome();
			this.requesterSituationTutorPresence = request.getRequesterSituation().getTutorPresence();
			this.taxesAmountPropertyTaxes = request.getTaxesAmount().getPropertyTaxes();
			if (request.getRequesterSpouse().getSpousePensionPlan() != null)
			this.requesterSpouseSpousePensionPlan = request.getRequesterSpouse().getSpousePensionPlan().toString();
			if (request.getNationality() != null)
			this.nationality = request.getNationality().toString();
			this.requesterSpouseSpousePensionner = request.getRequesterSpouse().getSpousePensionner();
			this.currentDwellingCurrentDwellingRoomNumber = request.getCurrentDwelling().getCurrentDwellingRoomNumber();
			this.requesterIncomesRequesterPensions = request.getRequesterIncomes().getRequesterPensions();
			this.mensualExpensesRent = request.getMensualExpenses().getRent();
			if (request.getCurrentDwelling().getCurrentDwellingStatus() != null)
			this.currentDwellingCurrentDwellingStatus = request.getCurrentDwelling().getCurrentDwellingStatus().toString();
			if (request.getRequesterSpouse().getSpouseNationality() != null)
			this.requesterSpouseSpouseNationality = request.getRequesterSpouse().getSpouseNationality().toString();
			this.requesterSpouseSpouseOccupation = request.getRequesterSpouse().getSpouseOccupation();
			this.taxesAmountProfessionalTaxes = request.getTaxesAmount().getProfessionalTaxes();
			this.requesterSpouseSpouseSocialSecurityNumber = request.getRequesterSpouse().getSpouseSocialSecurityNumber();
			this.mensualExpensesAlimonies = request.getMensualExpenses().getAlimonies();
			this.taxesAmountIncomeTax = request.getTaxesAmount().getIncomeTax();
			this.socialSecurityKeyNumber = request.getSocialSecurityKeyNumber();
			this.franceArrivalDate = request.getFranceArrivalDate();
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			this.requesterSpouseIncomesSpousePensions = request.getRequesterSpouseIncomes().getSpousePensions();
			this.subjectAdultMaidenName = request.getSubject().getAdult().getMaidenName();
			this.requesterIncomesRequesterAllowances = request.getRequesterIncomes().getRequesterAllowances();
			this.requesterIncomesRequesterNetIncome = request.getRequesterIncomes().getRequesterNetIncome();
			this.requesterSpouseSpouseSocialSecurityKeyNumber = request.getRequesterSpouse().getSpouseSocialSecurityKeyNumber();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getRequesterSituation().setTutorFirstName(this.requesterSituationTutorFirstName);
			request.setSocialSecurityNumber(this.socialSecurityNumber);
			request.getRequesterSpouse().getSpouseInformation().setMaidenName(this.requesterSpouseSpouseInformationMaidenName);
			request.getRequesterSpouse().getSpouseInformation().setBirthDate(this.requesterSpouseSpouseInformationBirthDate);
			request.getRequesterSituation().setTutor(DhrTutorType.Enum.forString(this.requesterSituationTutor));
			request.getRequesterSpouse().getSpouseInformation().setFirstName(this.requesterSpouseSpouseInformationFirstName);
			request.getCurrentDwelling().setCurrentDwellingArrivalDate(this.currentDwellingCurrentDwellingArrivalDate);
			request.getRequesterSituation().setTutorName(this.requesterSituationTutorName);
			request.getRequesterSpouseIncomes().setSpouseAllowances(this.requesterSpouseIncomesSpouseAllowances);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
			request.getCapitals().setSharesAmount(this.capitalsSharesAmount);
  			request.getRequesterSituation().getTutorAddress().setAdditionalDeliveryInformation(this.requesterSituationTutorAddressAdditionalDeliveryInformation);
			request.getRequesterSituation().getTutorAddress().setAdditionalGeographicalInformation(this.requesterSituationTutorAddressAdditionalGeographicalInformation);
			request.getRequesterSituation().getTutorAddress().setStreetNumber(this.requesterSituationTutorAddressStreetNumber);
			request.getRequesterSituation().getTutorAddress().setStreetName(this.requesterSituationTutorAddressStreetName);
			request.getRequesterSituation().getTutorAddress().setPlaceNameOrService(this.requesterSituationTutorAddressPlaceNameOrService);
			request.getRequesterSituation().getTutorAddress().setPostalCode(this.requesterSituationTutorAddressPostalCode);
			request.getRequesterSituation().getTutorAddress().setCity(this.requesterSituationTutorAddressCity);
  			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalDeliveryInformation(this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalGeographicalInformation(this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetNumber(this.currentDwellingCurrentDwellingAddressStreetNumber);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetName(this.currentDwellingCurrentDwellingAddressStreetName);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPlaceNameOrService(this.currentDwellingCurrentDwellingAddressPlaceNameOrService);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPostalCode(this.currentDwellingCurrentDwellingAddressPostalCode);
			request.getCurrentDwelling().getCurrentDwellingAddress().setCity(this.currentDwellingCurrentDwellingAddressCity);
			request.getRequesterSpouse().getSpouseInformation().setLastName(this.requesterSpouseSpouseInformationLastName);
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
  			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalDeliveryInformation(this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalGeographicalInformation(this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetNumber(this.requesterSpouseSpouseEmployerAddressStreetNumber);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetName(this.requesterSpouseSpouseEmployerAddressStreetName);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPlaceNameOrService(this.requesterSpouseSpouseEmployerAddressPlaceNameOrService);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPostalCode(this.requesterSpouseSpouseEmployerAddressPostalCode);
			request.getRequesterSpouse().getSpouseEmployerAddress().setCity(this.requesterSpouseSpouseEmployerAddressCity);
			request.getSubject().getAdult().getBirthPlace().setCity(this.subjectAdultBirthPlaceCity);
			request.getTaxesAmount().setLocalRate(this.taxesAmountLocalRate);
			request.getRequesterIncomes().setRequesterInvestmentIncome(this.requesterIncomesRequesterInvestmentIncome);
			request.getRequesterSpouse().setSpouseFranceArrivalDate(this.requesterSpouseSpouseFranceArrivalDate);
			request.getRequesterSpouse().getSpouseInformation().getBirthPlace().setCity(this.requesterSpouseSpouseInformationBirthPlaceCity);
			request.getRequesterSpouse().setSpouseEmployer(this.requesterSpouseSpouseEmployer);
			request.getCapitals().setBondsAmount(this.capitalsBondsAmount);
			request.getCurrentDwelling().setCurrentDwellingType(DhrDwellingType.Enum.forString(this.currentDwellingCurrentDwellingType));
			request.getRequesterSpouseIncomes().setSpouseInvestmentIncome(this.requesterSpouseIncomesSpouseInvestmentIncome);
			request.getCurrentDwelling().setCurrentDwellingNetFloorArea(this.currentDwellingCurrentDwellingNetFloorArea);
			request.setRequesterPensionPlan(DhrPensionPlanType.Enum.forString(this.requesterPensionPlan));
			request.getRequesterSpouseIncomes().setSpouseNetIncome(this.requesterSpouseIncomesSpouseNetIncome);
			request.getRequesterSituation().setTutorPresence(this.requesterSituationTutorPresence);
			request.getTaxesAmount().setPropertyTaxes(this.taxesAmountPropertyTaxes);
			request.getRequesterSpouse().setSpousePensionPlan(DhrPensionPlanType.Enum.forString(this.requesterSpouseSpousePensionPlan));
			request.setNationality(NationalityType.Enum.forString(this.nationality));
			request.getRequesterSpouse().setSpousePensionner(this.requesterSpouseSpousePensionner);
			request.getCurrentDwelling().setCurrentDwellingRoomNumber(this.currentDwellingCurrentDwellingRoomNumber);
			request.getRequesterIncomes().setRequesterPensions(this.requesterIncomesRequesterPensions);
			request.getMensualExpenses().setRent(this.mensualExpensesRent);
			request.getCurrentDwelling().setCurrentDwellingStatus(DhrDwellingStatusType.Enum.forString(this.currentDwellingCurrentDwellingStatus));
			request.getRequesterSpouse().setSpouseNationality(NationalityType.Enum.forString(this.requesterSpouseSpouseNationality));
			request.getRequesterSpouse().setSpouseOccupation(this.requesterSpouseSpouseOccupation);
			request.getTaxesAmount().setProfessionalTaxes(this.taxesAmountProfessionalTaxes);
			request.getRequesterSpouse().setSpouseSocialSecurityNumber(this.requesterSpouseSpouseSocialSecurityNumber);
			request.getMensualExpenses().setAlimonies(this.mensualExpensesAlimonies);
			request.getTaxesAmount().setIncomeTax(this.taxesAmountIncomeTax);
			request.setSocialSecurityKeyNumber(this.socialSecurityKeyNumber);
			request.setFranceArrivalDate(this.franceArrivalDate);
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.getRequesterSpouseIncomes().setSpousePensions(this.requesterSpouseIncomesSpousePensions);
			request.getSubject().getAdult().setMaidenName(this.subjectAdultMaidenName);
			request.getRequesterIncomes().setRequesterAllowances(this.requesterIncomesRequesterAllowances);
			request.getRequesterIncomes().setRequesterNetIncome(this.requesterIncomesRequesterNetIncome);
			request.getRequesterSpouse().setSpouseSocialSecurityKeyNumber(this.requesterSpouseSpouseSocialSecurityKeyNumber);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSocialSecurityNumber() &&
			((this.socialSecurityNumber == null) || (this.socialSecurityNumber.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationFirstName() &&
			((this.requesterSpouseSpouseInformationFirstName == null) || (this.requesterSpouseSpouseInformationFirstName.length() == 0)))
			return false;
		if (this.checkSubjectAdultFirstName() &&
			((this.subjectAdultFirstName == null) || (this.subjectAdultFirstName.length() == 0)))
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
  		if (this.checkCurrentDwellingCurrentDwellingAddressStreetName() &&
			((this.currentDwellingCurrentDwellingAddressStreetName == null) || (this.currentDwellingCurrentDwellingAddressStreetName.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingAddressPostalCode() &&
			((this.currentDwellingCurrentDwellingAddressPostalCode == null) || (this.currentDwellingCurrentDwellingAddressPostalCode.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingAddressCity() &&
			((this.currentDwellingCurrentDwellingAddressCity == null) || (this.currentDwellingCurrentDwellingAddressCity.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationLastName() &&
			((this.requesterSpouseSpouseInformationLastName == null) || (this.requesterSpouseSpouseInformationLastName.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
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
		if (this.checkSubjectAdultBirthPlaceCity() &&
			((this.subjectAdultBirthPlaceCity == null) || (this.subjectAdultBirthPlaceCity.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationBirthPlaceCity() &&
			((this.requesterSpouseSpouseInformationBirthPlaceCity == null) || (this.requesterSpouseSpouseInformationBirthPlaceCity.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpousePensionPlan() &&
			((this.requesterSpouseSpousePensionPlan == null) || (this.requesterSpouseSpousePensionPlan.length() == 0)))
			return false;
		if (this.checkNationality() &&
			((this.nationality == null) || (this.nationality.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseNationality() &&
			((this.requesterSpouseSpouseNationality == null) || (this.requesterSpouseSpouseNationality.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseSocialSecurityNumber() &&
			((this.requesterSpouseSpouseSocialSecurityNumber == null) || (this.requesterSpouseSpouseSocialSecurityNumber.length() == 0)))
			return false;
		if (this.checkSocialSecurityKeyNumber() &&
			((this.socialSecurityKeyNumber == null) || (this.socialSecurityKeyNumber.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseSocialSecurityKeyNumber() &&
			((this.requesterSpouseSpouseSocialSecurityKeyNumber == null) || (this.requesterSpouseSpouseSocialSecurityKeyNumber.length() == 0)))
			return false;
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

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}
	
	public boolean checkSocialSecurityNumber() {
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

	public void setRequesterSpouseSpouseInformationBirthDate(Calendar requesterSpouseSpouseInformationBirthDate) {
		this.requesterSpouseSpouseInformationBirthDate = requesterSpouseSpouseInformationBirthDate;
	}
	
	public Calendar getRequesterSpouseSpouseInformationBirthDate() {
		return this.requesterSpouseSpouseInformationBirthDate;
	}
	
	public boolean checkRequesterSpouseSpouseInformationBirthDate() {
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

	public void setRequesterSpouseSpouseInformationFirstName(String requesterSpouseSpouseInformationFirstName) {
		this.requesterSpouseSpouseInformationFirstName = requesterSpouseSpouseInformationFirstName;
	}
	
	public String getRequesterSpouseSpouseInformationFirstName() {
		return this.requesterSpouseSpouseInformationFirstName;
	}
	
	public boolean checkRequesterSpouseSpouseInformationFirstName() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingArrivalDate(Calendar currentDwellingCurrentDwellingArrivalDate) {
		this.currentDwellingCurrentDwellingArrivalDate = currentDwellingCurrentDwellingArrivalDate;
	}
	
	public Calendar getCurrentDwellingCurrentDwellingArrivalDate() {
		return this.currentDwellingCurrentDwellingArrivalDate;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingArrivalDate() {
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

	public void setRequesterSpouseIncomesSpouseAllowances(java.math.BigInteger requesterSpouseIncomesSpouseAllowances) {
		this.requesterSpouseIncomesSpouseAllowances = requesterSpouseIncomesSpouseAllowances;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseAllowances() {
		return this.requesterSpouseIncomesSpouseAllowances;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseAllowances() {
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

	public void setCapitalsSharesAmount(java.math.BigInteger capitalsSharesAmount) {
		this.capitalsSharesAmount = capitalsSharesAmount;
	}
	
	public java.math.BigInteger getCapitalsSharesAmount() {
		return this.capitalsSharesAmount;
	}
	
	public boolean checkCapitalsSharesAmount() {
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

  	public void setCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation(String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation) {
		this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation() {
		return this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation(String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation) {
		this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation() {
		return this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressStreetNumber(String currentDwellingCurrentDwellingAddressStreetNumber) {
		this.currentDwellingCurrentDwellingAddressStreetNumber = currentDwellingCurrentDwellingAddressStreetNumber;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressStreetNumber() {
		return this.currentDwellingCurrentDwellingAddressStreetNumber;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressStreetNumber() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressStreetName(String currentDwellingCurrentDwellingAddressStreetName) {
		this.currentDwellingCurrentDwellingAddressStreetName = currentDwellingCurrentDwellingAddressStreetName;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressStreetName() {
		return this.currentDwellingCurrentDwellingAddressStreetName;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressStreetName() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressPlaceNameOrService(String currentDwellingCurrentDwellingAddressPlaceNameOrService) {
		this.currentDwellingCurrentDwellingAddressPlaceNameOrService = currentDwellingCurrentDwellingAddressPlaceNameOrService;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressPlaceNameOrService() {
		return this.currentDwellingCurrentDwellingAddressPlaceNameOrService;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressPlaceNameOrService() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressPostalCode(String currentDwellingCurrentDwellingAddressPostalCode) {
		this.currentDwellingCurrentDwellingAddressPostalCode = currentDwellingCurrentDwellingAddressPostalCode;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressPostalCode() {
		return this.currentDwellingCurrentDwellingAddressPostalCode;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressPostalCode() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingAddressCity(String currentDwellingCurrentDwellingAddressCity) {
		this.currentDwellingCurrentDwellingAddressCity = currentDwellingCurrentDwellingAddressCity;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressCity() {
		return this.currentDwellingCurrentDwellingAddressCity;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingAddressCity() {
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

	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}
	
	public boolean checkSubjectAdultLastName() {
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
		return true;
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
		return true;
	}

	public void setRequesterSpouseSpouseEmployerAddressCity(String requesterSpouseSpouseEmployerAddressCity) {
		this.requesterSpouseSpouseEmployerAddressCity = requesterSpouseSpouseEmployerAddressCity;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressCity() {
		return this.requesterSpouseSpouseEmployerAddressCity;
	}
	
	public boolean checkRequesterSpouseSpouseEmployerAddressCity() {
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

	public void setTaxesAmountLocalRate(java.math.BigInteger taxesAmountLocalRate) {
		this.taxesAmountLocalRate = taxesAmountLocalRate;
	}
	
	public java.math.BigInteger getTaxesAmountLocalRate() {
		return this.taxesAmountLocalRate;
	}
	
	public boolean checkTaxesAmountLocalRate() {
		return true;
	}

	public void setRequesterIncomesRequesterInvestmentIncome(java.math.BigInteger requesterIncomesRequesterInvestmentIncome) {
		this.requesterIncomesRequesterInvestmentIncome = requesterIncomesRequesterInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterInvestmentIncome() {
		return this.requesterIncomesRequesterInvestmentIncome;
	}
	
	public boolean checkRequesterIncomesRequesterInvestmentIncome() {
		return true;
	}

	public void setRequesterSpouseSpouseFranceArrivalDate(Calendar requesterSpouseSpouseFranceArrivalDate) {
		this.requesterSpouseSpouseFranceArrivalDate = requesterSpouseSpouseFranceArrivalDate;
	}
	
	public Calendar getRequesterSpouseSpouseFranceArrivalDate() {
		return this.requesterSpouseSpouseFranceArrivalDate;
	}
	
	public boolean checkRequesterSpouseSpouseFranceArrivalDate() {
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

	public void setRequesterSpouseSpouseEmployer(String requesterSpouseSpouseEmployer) {
		this.requesterSpouseSpouseEmployer = requesterSpouseSpouseEmployer;
	}
	
	public String getRequesterSpouseSpouseEmployer() {
		return this.requesterSpouseSpouseEmployer;
	}
	
	public boolean checkRequesterSpouseSpouseEmployer() {
		return true;
	}

	public void setCapitalsBondsAmount(java.math.BigInteger capitalsBondsAmount) {
		this.capitalsBondsAmount = capitalsBondsAmount;
	}
	
	public java.math.BigInteger getCapitalsBondsAmount() {
		return this.capitalsBondsAmount;
	}
	
	public boolean checkCapitalsBondsAmount() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingType(String currentDwellingCurrentDwellingType) {
		this.currentDwellingCurrentDwellingType = currentDwellingCurrentDwellingType;
	}
	
	public String getCurrentDwellingCurrentDwellingType() {
		return this.currentDwellingCurrentDwellingType;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingType() {
		return true;
	}

	public void setRequesterSpouseIncomesSpouseInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseInvestmentIncome) {
		this.requesterSpouseIncomesSpouseInvestmentIncome = requesterSpouseIncomesSpouseInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseInvestmentIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseInvestmentIncome() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingNetFloorArea(java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea) {
		this.currentDwellingCurrentDwellingNetFloorArea = currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingNetFloorArea() {
		return this.currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingNetFloorArea() {
		return true;
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

	public void setRequesterSpouseIncomesSpouseNetIncome(java.math.BigInteger requesterSpouseIncomesSpouseNetIncome) {
		this.requesterSpouseIncomesSpouseNetIncome = requesterSpouseIncomesSpouseNetIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseNetIncome() {
		return this.requesterSpouseIncomesSpouseNetIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseNetIncome() {
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

	public void setTaxesAmountPropertyTaxes(java.math.BigInteger taxesAmountPropertyTaxes) {
		this.taxesAmountPropertyTaxes = taxesAmountPropertyTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountPropertyTaxes() {
		return this.taxesAmountPropertyTaxes;
	}
	
	public boolean checkTaxesAmountPropertyTaxes() {
		return true;
	}

	public void setRequesterSpouseSpousePensionPlan(String requesterSpouseSpousePensionPlan) {
		this.requesterSpouseSpousePensionPlan = requesterSpouseSpousePensionPlan;
	}
	
	public String getRequesterSpouseSpousePensionPlan() {
		return this.requesterSpouseSpousePensionPlan;
	}
	
	public boolean checkRequesterSpouseSpousePensionPlan() {
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

	public void setRequesterSpouseSpousePensionner(boolean requesterSpouseSpousePensionner) {
		this.requesterSpouseSpousePensionner = requesterSpouseSpousePensionner;
	}
	
	public boolean getRequesterSpouseSpousePensionner() {
		return this.requesterSpouseSpousePensionner;
	}
	
	public boolean checkRequesterSpouseSpousePensionner() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingRoomNumber(java.math.BigInteger currentDwellingCurrentDwellingRoomNumber) {
		this.currentDwellingCurrentDwellingRoomNumber = currentDwellingCurrentDwellingRoomNumber;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingRoomNumber() {
		return this.currentDwellingCurrentDwellingRoomNumber;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingRoomNumber() {
		return true;
	}

	public void setRequesterIncomesRequesterPensions(java.math.BigInteger requesterIncomesRequesterPensions) {
		this.requesterIncomesRequesterPensions = requesterIncomesRequesterPensions;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterPensions() {
		return this.requesterIncomesRequesterPensions;
	}
	
	public boolean checkRequesterIncomesRequesterPensions() {
		return true;
	}

	public void setMensualExpensesRent(java.math.BigInteger mensualExpensesRent) {
		this.mensualExpensesRent = mensualExpensesRent;
	}
	
	public java.math.BigInteger getMensualExpensesRent() {
		return this.mensualExpensesRent;
	}
	
	public boolean checkMensualExpensesRent() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingStatus(String currentDwellingCurrentDwellingStatus) {
		this.currentDwellingCurrentDwellingStatus = currentDwellingCurrentDwellingStatus;
	}
	
	public String getCurrentDwellingCurrentDwellingStatus() {
		return this.currentDwellingCurrentDwellingStatus;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingStatus() {
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

	public void setRequesterSpouseSpouseOccupation(String requesterSpouseSpouseOccupation) {
		this.requesterSpouseSpouseOccupation = requesterSpouseSpouseOccupation;
	}
	
	public String getRequesterSpouseSpouseOccupation() {
		return this.requesterSpouseSpouseOccupation;
	}
	
	public boolean checkRequesterSpouseSpouseOccupation() {
		return true;
	}

	public void setTaxesAmountProfessionalTaxes(java.math.BigInteger taxesAmountProfessionalTaxes) {
		this.taxesAmountProfessionalTaxes = taxesAmountProfessionalTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountProfessionalTaxes() {
		return this.taxesAmountProfessionalTaxes;
	}
	
	public boolean checkTaxesAmountProfessionalTaxes() {
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

	public void setMensualExpensesAlimonies(java.math.BigInteger mensualExpensesAlimonies) {
		this.mensualExpensesAlimonies = mensualExpensesAlimonies;
	}
	
	public java.math.BigInteger getMensualExpensesAlimonies() {
		return this.mensualExpensesAlimonies;
	}
	
	public boolean checkMensualExpensesAlimonies() {
		return true;
	}

	public void setTaxesAmountIncomeTax(java.math.BigInteger taxesAmountIncomeTax) {
		this.taxesAmountIncomeTax = taxesAmountIncomeTax;
	}
	
	public java.math.BigInteger getTaxesAmountIncomeTax() {
		return this.taxesAmountIncomeTax;
	}
	
	public boolean checkTaxesAmountIncomeTax() {
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

	public void setFranceArrivalDate(Calendar franceArrivalDate) {
		this.franceArrivalDate = franceArrivalDate;
	}
	
	public Calendar getFranceArrivalDate() {
		return this.franceArrivalDate;
	}
	
	public boolean checkFranceArrivalDate() {
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

	public void setRequesterSpouseIncomesSpousePensions(java.math.BigInteger requesterSpouseIncomesSpousePensions) {
		this.requesterSpouseIncomesSpousePensions = requesterSpouseIncomesSpousePensions;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpousePensions() {
		return this.requesterSpouseIncomesSpousePensions;
	}
	
	public boolean checkRequesterSpouseIncomesSpousePensions() {
		return true;
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

	public void setRequesterIncomesRequesterAllowances(java.math.BigInteger requesterIncomesRequesterAllowances) {
		this.requesterIncomesRequesterAllowances = requesterIncomesRequesterAllowances;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterAllowances() {
		return this.requesterIncomesRequesterAllowances;
	}
	
	public boolean checkRequesterIncomesRequesterAllowances() {
		return true;
	}

	public void setRequesterIncomesRequesterNetIncome(java.math.BigInteger requesterIncomesRequesterNetIncome) {
		this.requesterIncomesRequesterNetIncome = requesterIncomesRequesterNetIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterNetIncome() {
		return this.requesterIncomesRequesterNetIncome;
	}
	
	public boolean checkRequesterIncomesRequesterNetIncome() {
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

}
