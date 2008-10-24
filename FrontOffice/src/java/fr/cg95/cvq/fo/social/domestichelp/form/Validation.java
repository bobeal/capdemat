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

	private java.math.BigInteger taxesAmountIncomeTax;
	private java.math.BigInteger currentDwellingCurrentDwellingRoomNumber;
	private Calendar subjectAdultBirthDate;
	private String requesterSpouseSpouseNationality;
	private String requesterSpouseSpouseInformationLastName;
	private java.math.BigInteger requesterSpouseIncomesSpousePensions;
	private String requesterSituationTutor;
	private String requesterSpouseSpouseEmployer;
	private Calendar requesterSpouseSpouseFranceArrivalDate;
	private String pensionPlanPrecision;
  	private String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	private String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	private String requesterSpouseSpouseEmployerAddressStreetNumber;
	private String requesterSpouseSpouseEmployerAddressStreetName;
	private String requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	private String requesterSpouseSpouseEmployerAddressPostalCode;
	private String requesterSpouseSpouseEmployerAddressCity;
	private boolean requesterFamilyReferentFamilyReferentDesignated;
	private java.math.BigInteger requesterIncomesRequesterAllowances;
	private java.math.BigInteger requesterIncomesRequesterRealEstateInvestmentIncome;
	private String subjectAdultFirstName;
	private String subjectAdultFamilyStatus;
	private String currentDwellingCurrentDwellingType;
	private String subjectAdultMaidenName;
	private String requesterRequestKind;
	private String subjectAdultLastName;
	private boolean requesterSpouseSpousePensionner;
	private java.math.BigInteger taxesAmountPropertyTaxes;
	private boolean requesterSpouseSpouseMoreThan15YearsInFrance;
	private String requesterFamilyReferentFamilyReferentFirstName;
	private String requesterSpouseSpouseInformationTitle;
	private String requesterPensionPlan;
	private java.math.BigInteger taxesAmountLocalRate;
	private String nationality;
	private java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea;
	private String complementaryPensionPlanPrecision;
	private Calendar currentDwellingCurrentDwellingArrivalDate;
	private Calendar previousDwellingPreviousDwellingDepartureDate;
	private String requesterSituationTutorName;
  	private String requesterSituationTutorAddressAdditionalDeliveryInformation;
	private String requesterSituationTutorAddressAdditionalGeographicalInformation;
	private String requesterSituationTutorAddressStreetNumber;
	private String requesterSituationTutorAddressStreetName;
	private String requesterSituationTutorAddressPlaceNameOrService;
	private String requesterSituationTutorAddressPostalCode;
	private String requesterSituationTutorAddressCity;
	private java.math.BigInteger requesterIncomesRequesterNetIncome;
	private String requesterSpouseSpouseOccupation;
	private String requesterSpouseSpouseInformationBirthPlaceCity;
	private String currentDwellingCurrentDwellingPersonalPhone;
	private java.math.BigInteger requesterSpouseIncomesSpouseNetIncome;
	private java.math.BigInteger requesterIncomesRequesterFurnitureInvestmentIncome;
  	private String requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation;
	private String requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation;
	private String requesterFamilyReferentFamilyReferentAddressStreetNumber;
	private String requesterFamilyReferentFamilyReferentAddressStreetName;
	private String requesterFamilyReferentFamilyReferentAddressPlaceNameOrService;
	private String requesterFamilyReferentFamilyReferentAddressPostalCode;
	private String requesterFamilyReferentFamilyReferentAddressCity;
	private java.math.BigInteger requesterSpouseIncomesSpouseAllowances;
	private String requesterSpouseSpouseInformationMaidenName;
	private String requesterFamilyReferentFamilyReferentName;
	private String requesterHasSpouse;
	private String currentDwellingCurrentDwellingStatus;
	private String requesterSpouseSpouseComplementaryPensionPlanPrecision;
	private Calendar requesterSpouseSpouseInformationBirthDate;
  	private String previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	private String previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	private String previousDwellingPreviousDwellingAddressStreetNumber;
	private String previousDwellingPreviousDwellingAddressStreetName;
	private String previousDwellingPreviousDwellingAddressPlaceNameOrService;
	private String previousDwellingPreviousDwellingAddressPostalCode;
	private String previousDwellingPreviousDwellingAddressCity;
	private String subjectAdultTitle;
	private java.math.BigInteger taxesAmountProfessionalTaxes;
	private Calendar previousDwellingPreviousDwellingArrivalDate;
	private String requesterSpouseSpouseInformationFamilyStatus;
	private boolean requesterSituationTutorPresence;
	private java.math.BigInteger requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	private String requesterSpouseSpousePensionPlan;
	private java.math.BigInteger requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	private java.math.BigInteger requesterIncomesRequesterPensions;
	private Calendar franceArrivalDate;
	private boolean moreThan15YearsInFrance;
	private String requesterSpouseSpousePensionPlanPrecision;
	private String subjectAdultBirthPlaceCity;
  	private String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	private String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	private String currentDwellingCurrentDwellingAddressStreetNumber;
	private String currentDwellingCurrentDwellingAddressStreetName;
	private String currentDwellingCurrentDwellingAddressPlaceNameOrService;
	private String currentDwellingCurrentDwellingAddressPostalCode;
	private String currentDwellingCurrentDwellingAddressCity;
	private String requesterSpouseSpouseInformationFirstName;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summarytaxesAmount")) {
		}
		if (state.equals("summaryfamilyreferent")) {
		}
		if (state.equals("summaryrequestkind")) {
		}
		if (state.equals("summarypreviousdwelling")) {
		}
		if (state.equals("summarytutor")) {
		}
		if (state.equals("summarycurrentdwelling")) {
		}
		if (state.equals("summarynotrealassets")) {
		}
		if (state.equals("summaryrealassets")) {
		}
		if (state.equals("summaryspouse")) {
		}
		if (state.equals("summaryspouseincomes")) {
		}
		if (state.equals("summarysubjectincomes")) {
		}
		if (state.equals("summarysubject")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			this.taxesAmountIncomeTax = request.getTaxesAmount().getIncomeTax();
			this.currentDwellingCurrentDwellingRoomNumber = request.getCurrentDwelling().getCurrentDwellingRoomNumber();
			this.subjectAdultBirthDate = request.getSubject().getAdult().getBirthDate();
			if (request.getRequesterSpouse().getSpouseNationality() != null)
			this.requesterSpouseSpouseNationality = request.getRequesterSpouse().getSpouseNationality().toString();
			this.requesterSpouseSpouseInformationLastName = request.getRequesterSpouse().getSpouseInformation().getLastName();
			this.requesterSpouseIncomesSpousePensions = request.getRequesterSpouseIncomes().getSpousePensions();
			if (request.getRequesterSituation().getTutor() != null)
			this.requesterSituationTutor = request.getRequesterSituation().getTutor().toString();
			this.requesterSpouseSpouseEmployer = request.getRequesterSpouse().getSpouseEmployer();
			this.requesterSpouseSpouseFranceArrivalDate = request.getRequesterSpouse().getSpouseFranceArrivalDate();
			this.pensionPlanPrecision = request.getPensionPlanPrecision();
  			this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalDeliveryInformation();
			this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = request.getRequesterSpouse().getSpouseEmployerAddress().getAdditionalGeographicalInformation();
			this.requesterSpouseSpouseEmployerAddressStreetNumber = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetNumber();
			this.requesterSpouseSpouseEmployerAddressStreetName = request.getRequesterSpouse().getSpouseEmployerAddress().getStreetName();
			this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = request.getRequesterSpouse().getSpouseEmployerAddress().getPlaceNameOrService();
			this.requesterSpouseSpouseEmployerAddressPostalCode = request.getRequesterSpouse().getSpouseEmployerAddress().getPostalCode();
			this.requesterSpouseSpouseEmployerAddressCity = request.getRequesterSpouse().getSpouseEmployerAddress().getCity();
			this.requesterFamilyReferentFamilyReferentDesignated = request.getRequesterFamilyReferent().getFamilyReferentDesignated();
			this.requesterIncomesRequesterAllowances = request.getRequesterIncomes().getRequesterAllowances();
			this.requesterIncomesRequesterRealEstateInvestmentIncome = request.getRequesterIncomes().getRequesterRealEstateInvestmentIncome();
			this.subjectAdultFirstName = request.getSubject().getAdult().getFirstName();
			if (request.getSubject().getAdult().getFamilyStatus() != null)
			this.subjectAdultFamilyStatus = request.getSubject().getAdult().getFamilyStatus().toString();
			if (request.getCurrentDwelling().getCurrentDwellingType() != null)
			this.currentDwellingCurrentDwellingType = request.getCurrentDwelling().getCurrentDwellingType().toString();
			this.subjectAdultMaidenName = request.getSubject().getAdult().getMaidenName();
			if (request.getRequesterRequestKind() != null)
			this.requesterRequestKind = request.getRequesterRequestKind().toString();
			this.subjectAdultLastName = request.getSubject().getAdult().getLastName();
			this.requesterSpouseSpousePensionner = request.getRequesterSpouse().getSpousePensionner();
			this.taxesAmountPropertyTaxes = request.getTaxesAmount().getPropertyTaxes();
			this.requesterSpouseSpouseMoreThan15YearsInFrance = request.getRequesterSpouse().getSpouseMoreThan15YearsInFrance();
			this.requesterFamilyReferentFamilyReferentFirstName = request.getRequesterFamilyReferent().getFamilyReferentFirstName();
			if (request.getRequesterSpouse().getSpouseInformation().getTitle() != null)
			this.requesterSpouseSpouseInformationTitle = request.getRequesterSpouse().getSpouseInformation().getTitle().toString();
			if (request.getRequesterPensionPlan() != null)
			this.requesterPensionPlan = request.getRequesterPensionPlan().toString();
			this.taxesAmountLocalRate = request.getTaxesAmount().getLocalRate();
			if (request.getNationality() != null)
			this.nationality = request.getNationality().toString();
			this.currentDwellingCurrentDwellingNetFloorArea = request.getCurrentDwelling().getCurrentDwellingNetFloorArea();
			this.complementaryPensionPlanPrecision = request.getComplementaryPensionPlanPrecision();
			this.currentDwellingCurrentDwellingArrivalDate = request.getCurrentDwelling().getCurrentDwellingArrivalDate();
			this.previousDwellingPreviousDwellingDepartureDate = request.getPreviousDwelling().getPreviousDwellingDepartureDate();
			this.requesterSituationTutorName = request.getRequesterSituation().getTutorName();
  			this.requesterSituationTutorAddressAdditionalDeliveryInformation = request.getRequesterSituation().getTutorAddress().getAdditionalDeliveryInformation();
			this.requesterSituationTutorAddressAdditionalGeographicalInformation = request.getRequesterSituation().getTutorAddress().getAdditionalGeographicalInformation();
			this.requesterSituationTutorAddressStreetNumber = request.getRequesterSituation().getTutorAddress().getStreetNumber();
			this.requesterSituationTutorAddressStreetName = request.getRequesterSituation().getTutorAddress().getStreetName();
			this.requesterSituationTutorAddressPlaceNameOrService = request.getRequesterSituation().getTutorAddress().getPlaceNameOrService();
			this.requesterSituationTutorAddressPostalCode = request.getRequesterSituation().getTutorAddress().getPostalCode();
			this.requesterSituationTutorAddressCity = request.getRequesterSituation().getTutorAddress().getCity();
			this.requesterIncomesRequesterNetIncome = request.getRequesterIncomes().getRequesterNetIncome();
			this.requesterSpouseSpouseOccupation = request.getRequesterSpouse().getSpouseOccupation();
			this.requesterSpouseSpouseInformationBirthPlaceCity = request.getRequesterSpouse().getSpouseInformation().getBirthPlace().getCity();
			this.currentDwellingCurrentDwellingPersonalPhone = request.getCurrentDwelling().getCurrentDwellingPersonalPhone();
			this.requesterSpouseIncomesSpouseNetIncome = request.getRequesterSpouseIncomes().getSpouseNetIncome();
			this.requesterIncomesRequesterFurnitureInvestmentIncome = request.getRequesterIncomes().getRequesterFurnitureInvestmentIncome();
  			this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation = request.getRequesterFamilyReferent().getFamilyReferentAddress().getAdditionalDeliveryInformation();
			this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation = request.getRequesterFamilyReferent().getFamilyReferentAddress().getAdditionalGeographicalInformation();
			this.requesterFamilyReferentFamilyReferentAddressStreetNumber = request.getRequesterFamilyReferent().getFamilyReferentAddress().getStreetNumber();
			this.requesterFamilyReferentFamilyReferentAddressStreetName = request.getRequesterFamilyReferent().getFamilyReferentAddress().getStreetName();
			this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService = request.getRequesterFamilyReferent().getFamilyReferentAddress().getPlaceNameOrService();
			this.requesterFamilyReferentFamilyReferentAddressPostalCode = request.getRequesterFamilyReferent().getFamilyReferentAddress().getPostalCode();
			this.requesterFamilyReferentFamilyReferentAddressCity = request.getRequesterFamilyReferent().getFamilyReferentAddress().getCity();
			this.requesterSpouseIncomesSpouseAllowances = request.getRequesterSpouseIncomes().getSpouseAllowances();
			this.requesterSpouseSpouseInformationMaidenName = request.getRequesterSpouse().getSpouseInformation().getMaidenName();
			this.requesterFamilyReferentFamilyReferentName = request.getRequesterFamilyReferent().getFamilyReferentName();
			if (request.getRequesterHasSpouse() != null)
			this.requesterHasSpouse = request.getRequesterHasSpouse().toString();
			if (request.getCurrentDwelling().getCurrentDwellingStatus() != null)
			this.currentDwellingCurrentDwellingStatus = request.getCurrentDwelling().getCurrentDwellingStatus().toString();
			this.requesterSpouseSpouseComplementaryPensionPlanPrecision = request.getRequesterSpouse().getSpouseComplementaryPensionPlanPrecision();
			this.requesterSpouseSpouseInformationBirthDate = request.getRequesterSpouse().getSpouseInformation().getBirthDate();
  			this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = request.getPreviousDwelling().getPreviousDwellingAddress().getAdditionalDeliveryInformation();
			this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = request.getPreviousDwelling().getPreviousDwellingAddress().getAdditionalGeographicalInformation();
			this.previousDwellingPreviousDwellingAddressStreetNumber = request.getPreviousDwelling().getPreviousDwellingAddress().getStreetNumber();
			this.previousDwellingPreviousDwellingAddressStreetName = request.getPreviousDwelling().getPreviousDwellingAddress().getStreetName();
			this.previousDwellingPreviousDwellingAddressPlaceNameOrService = request.getPreviousDwelling().getPreviousDwellingAddress().getPlaceNameOrService();
			this.previousDwellingPreviousDwellingAddressPostalCode = request.getPreviousDwelling().getPreviousDwellingAddress().getPostalCode();
			this.previousDwellingPreviousDwellingAddressCity = request.getPreviousDwelling().getPreviousDwellingAddress().getCity();
			if (request.getSubject().getAdult().getTitle() != null)
			this.subjectAdultTitle = request.getSubject().getAdult().getTitle().toString();
			this.taxesAmountProfessionalTaxes = request.getTaxesAmount().getProfessionalTaxes();
			this.previousDwellingPreviousDwellingArrivalDate = request.getPreviousDwelling().getPreviousDwellingArrivalDate();
			if (request.getRequesterSpouse().getSpouseInformation().getFamilyStatus() != null)
			this.requesterSpouseSpouseInformationFamilyStatus = request.getRequesterSpouse().getSpouseInformation().getFamilyStatus().toString();
			this.requesterSituationTutorPresence = request.getRequesterSituation().getTutorPresence();
			this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = request.getRequesterSpouseIncomes().getSpouseFurnitureInvestmentIncome();
			if (request.getRequesterSpouse().getSpousePensionPlan() != null)
			this.requesterSpouseSpousePensionPlan = request.getRequesterSpouse().getSpousePensionPlan().toString();
			this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = request.getRequesterSpouseIncomes().getSpouseRealEstateInvestmentIncome();
			this.requesterIncomesRequesterPensions = request.getRequesterIncomes().getRequesterPensions();
			this.franceArrivalDate = request.getFranceArrivalDate();
			this.moreThan15YearsInFrance = request.getMoreThan15YearsInFrance();
			this.requesterSpouseSpousePensionPlanPrecision = request.getRequesterSpouse().getSpousePensionPlanPrecision();
			this.subjectAdultBirthPlaceCity = request.getSubject().getAdult().getBirthPlace().getCity();
  			this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalDeliveryInformation();
			this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = request.getCurrentDwelling().getCurrentDwellingAddress().getAdditionalGeographicalInformation();
			this.currentDwellingCurrentDwellingAddressStreetNumber = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetNumber();
			this.currentDwellingCurrentDwellingAddressStreetName = request.getCurrentDwelling().getCurrentDwellingAddress().getStreetName();
			this.currentDwellingCurrentDwellingAddressPlaceNameOrService = request.getCurrentDwelling().getCurrentDwellingAddress().getPlaceNameOrService();
			this.currentDwellingCurrentDwellingAddressPostalCode = request.getCurrentDwelling().getCurrentDwellingAddress().getPostalCode();
			this.currentDwellingCurrentDwellingAddressCity = request.getCurrentDwelling().getCurrentDwellingAddress().getCity();
			this.requesterSpouseSpouseInformationFirstName = request.getRequesterSpouse().getSpouseInformation().getFirstName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DomesticHelpRequest)) {
			DomesticHelpRequest request = (DomesticHelpRequest)xmlbRequest;
			request.getTaxesAmount().setIncomeTax(this.taxesAmountIncomeTax);
			request.getCurrentDwelling().setCurrentDwellingRoomNumber(this.currentDwellingCurrentDwellingRoomNumber);
			request.getSubject().getAdult().setBirthDate(this.subjectAdultBirthDate);
			request.getRequesterSpouse().setSpouseNationality(NationalityType.Enum.forString(this.requesterSpouseSpouseNationality));
			request.getRequesterSpouse().getSpouseInformation().setLastName(this.requesterSpouseSpouseInformationLastName);
			request.getRequesterSpouseIncomes().setSpousePensions(this.requesterSpouseIncomesSpousePensions);
			request.getRequesterSituation().setTutor(DhrTutorType.Enum.forString(this.requesterSituationTutor));
			request.getRequesterSpouse().setSpouseEmployer(this.requesterSpouseSpouseEmployer);
			request.getRequesterSpouse().setSpouseFranceArrivalDate(this.requesterSpouseSpouseFranceArrivalDate);
			request.setPensionPlanPrecision(this.pensionPlanPrecision);
  			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalDeliveryInformation(this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setAdditionalGeographicalInformation(this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetNumber(this.requesterSpouseSpouseEmployerAddressStreetNumber);
			request.getRequesterSpouse().getSpouseEmployerAddress().setStreetName(this.requesterSpouseSpouseEmployerAddressStreetName);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPlaceNameOrService(this.requesterSpouseSpouseEmployerAddressPlaceNameOrService);
			request.getRequesterSpouse().getSpouseEmployerAddress().setPostalCode(this.requesterSpouseSpouseEmployerAddressPostalCode);
			request.getRequesterSpouse().getSpouseEmployerAddress().setCity(this.requesterSpouseSpouseEmployerAddressCity);
			request.getRequesterFamilyReferent().setFamilyReferentDesignated(this.requesterFamilyReferentFamilyReferentDesignated);
			request.getRequesterIncomes().setRequesterAllowances(this.requesterIncomesRequesterAllowances);
			request.getRequesterIncomes().setRequesterRealEstateInvestmentIncome(this.requesterIncomesRequesterRealEstateInvestmentIncome);
			request.getSubject().getAdult().setFirstName(this.subjectAdultFirstName);
			request.getSubject().getAdult().setFamilyStatus(FamilyStatusType.Enum.forString(this.subjectAdultFamilyStatus));
			request.getCurrentDwelling().setCurrentDwellingType(DhrDwellingType.Enum.forString(this.currentDwellingCurrentDwellingType));
			request.getSubject().getAdult().setMaidenName(this.subjectAdultMaidenName);
			request.setRequesterRequestKind(DhrRequestKindType.Enum.forString(this.requesterRequestKind));
			request.getSubject().getAdult().setLastName(this.subjectAdultLastName);
			request.getRequesterSpouse().setSpousePensionner(this.requesterSpouseSpousePensionner);
			request.getTaxesAmount().setPropertyTaxes(this.taxesAmountPropertyTaxes);
			request.getRequesterSpouse().setSpouseMoreThan15YearsInFrance(this.requesterSpouseSpouseMoreThan15YearsInFrance);
			request.getRequesterFamilyReferent().setFamilyReferentFirstName(this.requesterFamilyReferentFamilyReferentFirstName);
			request.getRequesterSpouse().getSpouseInformation().setTitle(TitleType.Enum.forString(this.requesterSpouseSpouseInformationTitle));
			request.setRequesterPensionPlan(DhrPensionPlanType.Enum.forString(this.requesterPensionPlan));
			request.getTaxesAmount().setLocalRate(this.taxesAmountLocalRate);
			request.setNationality(NationalityType.Enum.forString(this.nationality));
			request.getCurrentDwelling().setCurrentDwellingNetFloorArea(this.currentDwellingCurrentDwellingNetFloorArea);
			request.setComplementaryPensionPlanPrecision(this.complementaryPensionPlanPrecision);
			request.getCurrentDwelling().setCurrentDwellingArrivalDate(this.currentDwellingCurrentDwellingArrivalDate);
			request.getPreviousDwelling().setPreviousDwellingDepartureDate(this.previousDwellingPreviousDwellingDepartureDate);
			request.getRequesterSituation().setTutorName(this.requesterSituationTutorName);
  			request.getRequesterSituation().getTutorAddress().setAdditionalDeliveryInformation(this.requesterSituationTutorAddressAdditionalDeliveryInformation);
			request.getRequesterSituation().getTutorAddress().setAdditionalGeographicalInformation(this.requesterSituationTutorAddressAdditionalGeographicalInformation);
			request.getRequesterSituation().getTutorAddress().setStreetNumber(this.requesterSituationTutorAddressStreetNumber);
			request.getRequesterSituation().getTutorAddress().setStreetName(this.requesterSituationTutorAddressStreetName);
			request.getRequesterSituation().getTutorAddress().setPlaceNameOrService(this.requesterSituationTutorAddressPlaceNameOrService);
			request.getRequesterSituation().getTutorAddress().setPostalCode(this.requesterSituationTutorAddressPostalCode);
			request.getRequesterSituation().getTutorAddress().setCity(this.requesterSituationTutorAddressCity);
			request.getRequesterIncomes().setRequesterNetIncome(this.requesterIncomesRequesterNetIncome);
			request.getRequesterSpouse().setSpouseOccupation(this.requesterSpouseSpouseOccupation);
			request.getRequesterSpouse().getSpouseInformation().getBirthPlace().setCity(this.requesterSpouseSpouseInformationBirthPlaceCity);
			request.getCurrentDwelling().setCurrentDwellingPersonalPhone(this.currentDwellingCurrentDwellingPersonalPhone);
			request.getRequesterSpouseIncomes().setSpouseNetIncome(this.requesterSpouseIncomesSpouseNetIncome);
			request.getRequesterIncomes().setRequesterFurnitureInvestmentIncome(this.requesterIncomesRequesterFurnitureInvestmentIncome);
  			request.getRequesterFamilyReferent().getFamilyReferentAddress().setAdditionalDeliveryInformation(this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setAdditionalGeographicalInformation(this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setStreetNumber(this.requesterFamilyReferentFamilyReferentAddressStreetNumber);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setStreetName(this.requesterFamilyReferentFamilyReferentAddressStreetName);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setPlaceNameOrService(this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setPostalCode(this.requesterFamilyReferentFamilyReferentAddressPostalCode);
			request.getRequesterFamilyReferent().getFamilyReferentAddress().setCity(this.requesterFamilyReferentFamilyReferentAddressCity);
			request.getRequesterSpouseIncomes().setSpouseAllowances(this.requesterSpouseIncomesSpouseAllowances);
			request.getRequesterSpouse().getSpouseInformation().setMaidenName(this.requesterSpouseSpouseInformationMaidenName);
			request.getRequesterFamilyReferent().setFamilyReferentName(this.requesterFamilyReferentFamilyReferentName);
			request.setRequesterHasSpouse(DhrRequesterHasSpouse.Enum.forString(this.requesterHasSpouse));
			request.getCurrentDwelling().setCurrentDwellingStatus(DhrDwellingStatusType.Enum.forString(this.currentDwellingCurrentDwellingStatus));
			request.getRequesterSpouse().setSpouseComplementaryPensionPlanPrecision(this.requesterSpouseSpouseComplementaryPensionPlanPrecision);
			request.getRequesterSpouse().getSpouseInformation().setBirthDate(this.requesterSpouseSpouseInformationBirthDate);
  			request.getPreviousDwelling().getPreviousDwellingAddress().setAdditionalDeliveryInformation(this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation);
			request.getPreviousDwelling().getPreviousDwellingAddress().setAdditionalGeographicalInformation(this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation);
			request.getPreviousDwelling().getPreviousDwellingAddress().setStreetNumber(this.previousDwellingPreviousDwellingAddressStreetNumber);
			request.getPreviousDwelling().getPreviousDwellingAddress().setStreetName(this.previousDwellingPreviousDwellingAddressStreetName);
			request.getPreviousDwelling().getPreviousDwellingAddress().setPlaceNameOrService(this.previousDwellingPreviousDwellingAddressPlaceNameOrService);
			request.getPreviousDwelling().getPreviousDwellingAddress().setPostalCode(this.previousDwellingPreviousDwellingAddressPostalCode);
			request.getPreviousDwelling().getPreviousDwellingAddress().setCity(this.previousDwellingPreviousDwellingAddressCity);
			request.getSubject().getAdult().setTitle(TitleType.Enum.forString(this.subjectAdultTitle));
			request.getTaxesAmount().setProfessionalTaxes(this.taxesAmountProfessionalTaxes);
			request.getPreviousDwelling().setPreviousDwellingArrivalDate(this.previousDwellingPreviousDwellingArrivalDate);
			request.getRequesterSpouse().getSpouseInformation().setFamilyStatus(FamilyStatusType.Enum.forString(this.requesterSpouseSpouseInformationFamilyStatus));
			request.getRequesterSituation().setTutorPresence(this.requesterSituationTutorPresence);
			request.getRequesterSpouseIncomes().setSpouseFurnitureInvestmentIncome(this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome);
			request.getRequesterSpouse().setSpousePensionPlan(DhrPensionPlanType.Enum.forString(this.requesterSpouseSpousePensionPlan));
			request.getRequesterSpouseIncomes().setSpouseRealEstateInvestmentIncome(this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome);
			request.getRequesterIncomes().setRequesterPensions(this.requesterIncomesRequesterPensions);
			request.setFranceArrivalDate(this.franceArrivalDate);
			request.setMoreThan15YearsInFrance(this.moreThan15YearsInFrance);
			request.getRequesterSpouse().setSpousePensionPlanPrecision(this.requesterSpouseSpousePensionPlanPrecision);
			request.getSubject().getAdult().getBirthPlace().setCity(this.subjectAdultBirthPlaceCity);
  			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalDeliveryInformation(this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setAdditionalGeographicalInformation(this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetNumber(this.currentDwellingCurrentDwellingAddressStreetNumber);
			request.getCurrentDwelling().getCurrentDwellingAddress().setStreetName(this.currentDwellingCurrentDwellingAddressStreetName);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPlaceNameOrService(this.currentDwellingCurrentDwellingAddressPlaceNameOrService);
			request.getCurrentDwelling().getCurrentDwellingAddress().setPostalCode(this.currentDwellingCurrentDwellingAddressPostalCode);
			request.getCurrentDwelling().getCurrentDwellingAddress().setCity(this.currentDwellingCurrentDwellingAddressCity);
			request.getRequesterSpouse().getSpouseInformation().setFirstName(this.requesterSpouseSpouseInformationFirstName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkCurrentDwellingCurrentDwellingRoomNumber() && (this.currentDwellingCurrentDwellingRoomNumber == null))
			return false;
		if (this.checkRequesterSpouseSpouseNationality() &&
			((this.requesterSpouseSpouseNationality == null) || (this.requesterSpouseSpouseNationality.length() == 0)))
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
		if (this.checkRequesterSpouseSpouseFranceArrivalDate() && (this.requesterSpouseSpouseFranceArrivalDate == null))
			return false;
		if (this.checkPensionPlanPrecision() &&
			((this.pensionPlanPrecision == null) || (this.pensionPlanPrecision.length() == 0)))
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
		if (this.checkSubjectAdultFamilyStatus() &&
			((this.subjectAdultFamilyStatus == null) || (this.subjectAdultFamilyStatus.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingType() &&
			((this.currentDwellingCurrentDwellingType == null) || (this.currentDwellingCurrentDwellingType.length() == 0)))
			return false;
		if (this.checkRequesterRequestKind() &&
			((this.requesterRequestKind == null) || (this.requesterRequestKind.length() == 0)))
			return false;
		if (this.checkSubjectAdultLastName() &&
			((this.subjectAdultLastName == null) || (this.subjectAdultLastName.length() == 0)))
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
		if (this.checkCurrentDwellingCurrentDwellingNetFloorArea() && (this.currentDwellingCurrentDwellingNetFloorArea == null))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingArrivalDate() && (this.currentDwellingCurrentDwellingArrivalDate == null))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingDepartureDate() && (this.previousDwellingPreviousDwellingDepartureDate == null))
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
		if (this.checkRequesterSpouseSpouseOccupation() &&
			((this.requesterSpouseSpouseOccupation == null) || (this.requesterSpouseSpouseOccupation.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpouseInformationBirthPlaceCity() &&
			((this.requesterSpouseSpouseInformationBirthPlaceCity == null) || (this.requesterSpouseSpouseInformationBirthPlaceCity.length() == 0)))
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
		if (this.checkRequesterHasSpouse() &&
			((this.requesterHasSpouse == null) || (this.requesterHasSpouse.length() == 0)))
			return false;
		if (this.checkCurrentDwellingCurrentDwellingStatus() &&
			((this.currentDwellingCurrentDwellingStatus == null) || (this.currentDwellingCurrentDwellingStatus.length() == 0)))
			return false;
  		if (this.checkPreviousDwellingPreviousDwellingAddressStreetName() &&
			((this.previousDwellingPreviousDwellingAddressStreetName == null) || (this.previousDwellingPreviousDwellingAddressStreetName.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingAddressPostalCode() &&
			((this.previousDwellingPreviousDwellingAddressPostalCode == null) || (this.previousDwellingPreviousDwellingAddressPostalCode.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingAddressCity() &&
			((this.previousDwellingPreviousDwellingAddressCity == null) || (this.previousDwellingPreviousDwellingAddressCity.length() == 0)))
			return false;
		if (this.checkPreviousDwellingPreviousDwellingArrivalDate() && (this.previousDwellingPreviousDwellingArrivalDate == null))
			return false;
		if (this.checkRequesterSpouseSpouseInformationFamilyStatus() &&
			((this.requesterSpouseSpouseInformationFamilyStatus == null) || (this.requesterSpouseSpouseInformationFamilyStatus.length() == 0)))
			return false;
		if (this.checkRequesterSpouseSpousePensionPlan() &&
			((this.requesterSpouseSpousePensionPlan == null) || (this.requesterSpouseSpousePensionPlan.length() == 0)))
			return false;
		if (this.checkFranceArrivalDate() && (this.franceArrivalDate == null))
			return false;
		if (this.checkSubjectAdultBirthPlaceCity() &&
			((this.subjectAdultBirthPlaceCity == null) || (this.subjectAdultBirthPlaceCity.length() == 0)))
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
		if (this.checkRequesterSpouseSpouseInformationFirstName() &&
			((this.requesterSpouseSpouseInformationFirstName == null) || (this.requesterSpouseSpouseInformationFirstName.length() == 0)))
			return false;
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

	public void setCurrentDwellingCurrentDwellingRoomNumber(java.math.BigInteger currentDwellingCurrentDwellingRoomNumber) {
		this.currentDwellingCurrentDwellingRoomNumber = currentDwellingCurrentDwellingRoomNumber;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingRoomNumber() {
		return this.currentDwellingCurrentDwellingRoomNumber;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingRoomNumber() {
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

	public void setRequesterSpouseSpouseInformationLastName(String requesterSpouseSpouseInformationLastName) {
		this.requesterSpouseSpouseInformationLastName = requesterSpouseSpouseInformationLastName;
	}
	
	public String getRequesterSpouseSpouseInformationLastName() {
		return this.requesterSpouseSpouseInformationLastName;
	}
	
	public boolean checkRequesterSpouseSpouseInformationLastName() {
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

	public void setRequesterSituationTutor(String requesterSituationTutor) {
		this.requesterSituationTutor = requesterSituationTutor;
	}
	
	public String getRequesterSituationTutor() {
		return this.requesterSituationTutor;
	}
	
	public boolean checkRequesterSituationTutor() {
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

	public void setRequesterSpouseSpouseFranceArrivalDate(Calendar requesterSpouseSpouseFranceArrivalDate) {
		this.requesterSpouseSpouseFranceArrivalDate = requesterSpouseSpouseFranceArrivalDate;
	}
	
	public Calendar getRequesterSpouseSpouseFranceArrivalDate() {
		return this.requesterSpouseSpouseFranceArrivalDate;
	}
	
	public boolean checkRequesterSpouseSpouseFranceArrivalDate() {
		return true;
	}

	public void setPensionPlanPrecision(String pensionPlanPrecision) {
		this.pensionPlanPrecision = pensionPlanPrecision;
	}
	
	public String getPensionPlanPrecision() {
		return this.pensionPlanPrecision;
	}
	
	public boolean checkPensionPlanPrecision() {
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

	public void setRequesterFamilyReferentFamilyReferentDesignated(boolean requesterFamilyReferentFamilyReferentDesignated) {
		this.requesterFamilyReferentFamilyReferentDesignated = requesterFamilyReferentFamilyReferentDesignated;
	}
	
	public boolean getRequesterFamilyReferentFamilyReferentDesignated() {
		return this.requesterFamilyReferentFamilyReferentDesignated;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentDesignated() {
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

	public void setRequesterIncomesRequesterRealEstateInvestmentIncome(java.math.BigInteger requesterIncomesRequesterRealEstateInvestmentIncome) {
		this.requesterIncomesRequesterRealEstateInvestmentIncome = requesterIncomesRequesterRealEstateInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterRealEstateInvestmentIncome() {
		return this.requesterIncomesRequesterRealEstateInvestmentIncome;
	}
	
	public boolean checkRequesterIncomesRequesterRealEstateInvestmentIncome() {
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

	public void setCurrentDwellingCurrentDwellingType(String currentDwellingCurrentDwellingType) {
		this.currentDwellingCurrentDwellingType = currentDwellingCurrentDwellingType;
	}
	
	public String getCurrentDwellingCurrentDwellingType() {
		return this.currentDwellingCurrentDwellingType;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingType() {
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

	public void setTaxesAmountPropertyTaxes(java.math.BigInteger taxesAmountPropertyTaxes) {
		this.taxesAmountPropertyTaxes = taxesAmountPropertyTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountPropertyTaxes() {
		return this.taxesAmountPropertyTaxes;
	}
	
	public boolean checkTaxesAmountPropertyTaxes() {
		return true;
	}

	public void setRequesterSpouseSpouseMoreThan15YearsInFrance(boolean requesterSpouseSpouseMoreThan15YearsInFrance) {
		this.requesterSpouseSpouseMoreThan15YearsInFrance = requesterSpouseSpouseMoreThan15YearsInFrance;
	}
	
	public boolean getRequesterSpouseSpouseMoreThan15YearsInFrance() {
		return this.requesterSpouseSpouseMoreThan15YearsInFrance;
	}
	
	public boolean checkRequesterSpouseSpouseMoreThan15YearsInFrance() {
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentFirstName(String requesterFamilyReferentFamilyReferentFirstName) {
		this.requesterFamilyReferentFamilyReferentFirstName = requesterFamilyReferentFamilyReferentFirstName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentFirstName() {
		return this.requesterFamilyReferentFamilyReferentFirstName;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentFirstName() {
		return true;
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

	public void setRequesterPensionPlan(String requesterPensionPlan) {
		this.requesterPensionPlan = requesterPensionPlan;
	}
	
	public String getRequesterPensionPlan() {
		return this.requesterPensionPlan;
	}
	
	public boolean checkRequesterPensionPlan() {
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

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	public boolean checkNationality() {
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

	public void setComplementaryPensionPlanPrecision(String complementaryPensionPlanPrecision) {
		this.complementaryPensionPlanPrecision = complementaryPensionPlanPrecision;
	}
	
	public String getComplementaryPensionPlanPrecision() {
		return this.complementaryPensionPlanPrecision;
	}
	
	public boolean checkComplementaryPensionPlanPrecision() {
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

	public void setPreviousDwellingPreviousDwellingDepartureDate(Calendar previousDwellingPreviousDwellingDepartureDate) {
		this.previousDwellingPreviousDwellingDepartureDate = previousDwellingPreviousDwellingDepartureDate;
	}
	
	public Calendar getPreviousDwellingPreviousDwellingDepartureDate() {
		return this.previousDwellingPreviousDwellingDepartureDate;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingDepartureDate() {
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

	public void setRequesterIncomesRequesterNetIncome(java.math.BigInteger requesterIncomesRequesterNetIncome) {
		this.requesterIncomesRequesterNetIncome = requesterIncomesRequesterNetIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterNetIncome() {
		return this.requesterIncomesRequesterNetIncome;
	}
	
	public boolean checkRequesterIncomesRequesterNetIncome() {
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

	public void setRequesterSpouseSpouseInformationBirthPlaceCity(String requesterSpouseSpouseInformationBirthPlaceCity) {
		this.requesterSpouseSpouseInformationBirthPlaceCity = requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public String getRequesterSpouseSpouseInformationBirthPlaceCity() {
		return this.requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public boolean checkRequesterSpouseSpouseInformationBirthPlaceCity() {
		return true;
	}

	public void setCurrentDwellingCurrentDwellingPersonalPhone(String currentDwellingCurrentDwellingPersonalPhone) {
		this.currentDwellingCurrentDwellingPersonalPhone = currentDwellingCurrentDwellingPersonalPhone;
	}
	
	public String getCurrentDwellingCurrentDwellingPersonalPhone() {
		return this.currentDwellingCurrentDwellingPersonalPhone;
	}
	
	public boolean checkCurrentDwellingCurrentDwellingPersonalPhone() {
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

	public void setRequesterIncomesRequesterFurnitureInvestmentIncome(java.math.BigInteger requesterIncomesRequesterFurnitureInvestmentIncome) {
		this.requesterIncomesRequesterFurnitureInvestmentIncome = requesterIncomesRequesterFurnitureInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterFurnitureInvestmentIncome() {
		return this.requesterIncomesRequesterFurnitureInvestmentIncome;
	}
	
	public boolean checkRequesterIncomesRequesterFurnitureInvestmentIncome() {
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
		return true;
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
		return true;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressCity(String requesterFamilyReferentFamilyReferentAddressCity) {
		this.requesterFamilyReferentFamilyReferentAddressCity = requesterFamilyReferentFamilyReferentAddressCity;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressCity() {
		return this.requesterFamilyReferentFamilyReferentAddressCity;
	}
	
	public boolean checkRequesterFamilyReferentFamilyReferentAddressCity() {
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
		return true;
	}

	public void setRequesterHasSpouse(String requesterHasSpouse) {
		this.requesterHasSpouse = requesterHasSpouse;
	}
	
	public String getRequesterHasSpouse() {
		return this.requesterHasSpouse;
	}
	
	public boolean checkRequesterHasSpouse() {
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

	public void setRequesterSpouseSpouseComplementaryPensionPlanPrecision(String requesterSpouseSpouseComplementaryPensionPlanPrecision) {
		this.requesterSpouseSpouseComplementaryPensionPlanPrecision = requesterSpouseSpouseComplementaryPensionPlanPrecision;
	}
	
	public String getRequesterSpouseSpouseComplementaryPensionPlanPrecision() {
		return this.requesterSpouseSpouseComplementaryPensionPlanPrecision;
	}
	
	public boolean checkRequesterSpouseSpouseComplementaryPensionPlanPrecision() {
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

  	public void setPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation(String previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation) {
		this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation() {
		return this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation(String previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation) {
		this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation() {
		return this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressStreetNumber(String previousDwellingPreviousDwellingAddressStreetNumber) {
		this.previousDwellingPreviousDwellingAddressStreetNumber = previousDwellingPreviousDwellingAddressStreetNumber;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressStreetNumber() {
		return this.previousDwellingPreviousDwellingAddressStreetNumber;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressStreetNumber() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressStreetName(String previousDwellingPreviousDwellingAddressStreetName) {
		this.previousDwellingPreviousDwellingAddressStreetName = previousDwellingPreviousDwellingAddressStreetName;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressStreetName() {
		return this.previousDwellingPreviousDwellingAddressStreetName;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressStreetName() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressPlaceNameOrService(String previousDwellingPreviousDwellingAddressPlaceNameOrService) {
		this.previousDwellingPreviousDwellingAddressPlaceNameOrService = previousDwellingPreviousDwellingAddressPlaceNameOrService;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressPlaceNameOrService() {
		return this.previousDwellingPreviousDwellingAddressPlaceNameOrService;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressPlaceNameOrService() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressPostalCode(String previousDwellingPreviousDwellingAddressPostalCode) {
		this.previousDwellingPreviousDwellingAddressPostalCode = previousDwellingPreviousDwellingAddressPostalCode;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressPostalCode() {
		return this.previousDwellingPreviousDwellingAddressPostalCode;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressPostalCode() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingAddressCity(String previousDwellingPreviousDwellingAddressCity) {
		this.previousDwellingPreviousDwellingAddressCity = previousDwellingPreviousDwellingAddressCity;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressCity() {
		return this.previousDwellingPreviousDwellingAddressCity;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingAddressCity() {
		return true;
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

	public void setTaxesAmountProfessionalTaxes(java.math.BigInteger taxesAmountProfessionalTaxes) {
		this.taxesAmountProfessionalTaxes = taxesAmountProfessionalTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountProfessionalTaxes() {
		return this.taxesAmountProfessionalTaxes;
	}
	
	public boolean checkTaxesAmountProfessionalTaxes() {
		return true;
	}

	public void setPreviousDwellingPreviousDwellingArrivalDate(Calendar previousDwellingPreviousDwellingArrivalDate) {
		this.previousDwellingPreviousDwellingArrivalDate = previousDwellingPreviousDwellingArrivalDate;
	}
	
	public Calendar getPreviousDwellingPreviousDwellingArrivalDate() {
		return this.previousDwellingPreviousDwellingArrivalDate;
	}
	
	public boolean checkPreviousDwellingPreviousDwellingArrivalDate() {
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

	public void setRequesterSituationTutorPresence(boolean requesterSituationTutorPresence) {
		this.requesterSituationTutorPresence = requesterSituationTutorPresence;
	}
	
	public boolean getRequesterSituationTutorPresence() {
		return this.requesterSituationTutorPresence;
	}
	
	public boolean checkRequesterSituationTutorPresence() {
		return true;
	}

	public void setRequesterSpouseIncomesSpouseFurnitureInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseFurnitureInvestmentIncome) {
		this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseFurnitureInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseFurnitureInvestmentIncome() {
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

	public void setRequesterSpouseIncomesSpouseRealEstateInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseRealEstateInvestmentIncome) {
		this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseRealEstateInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	}
	
	public boolean checkRequesterSpouseIncomesSpouseRealEstateInvestmentIncome() {
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

	public void setFranceArrivalDate(Calendar franceArrivalDate) {
		this.franceArrivalDate = franceArrivalDate;
	}
	
	public Calendar getFranceArrivalDate() {
		return this.franceArrivalDate;
	}
	
	public boolean checkFranceArrivalDate() {
		return true;
	}

	public void setMoreThan15YearsInFrance(boolean moreThan15YearsInFrance) {
		this.moreThan15YearsInFrance = moreThan15YearsInFrance;
	}
	
	public boolean getMoreThan15YearsInFrance() {
		return this.moreThan15YearsInFrance;
	}
	
	public boolean checkMoreThan15YearsInFrance() {
		return true;
	}

	public void setRequesterSpouseSpousePensionPlanPrecision(String requesterSpouseSpousePensionPlanPrecision) {
		this.requesterSpouseSpousePensionPlanPrecision = requesterSpouseSpousePensionPlanPrecision;
	}
	
	public String getRequesterSpouseSpousePensionPlanPrecision() {
		return this.requesterSpouseSpousePensionPlanPrecision;
	}
	
	public boolean checkRequesterSpouseSpousePensionPlanPrecision() {
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

	public void setRequesterSpouseSpouseInformationFirstName(String requesterSpouseSpouseInformationFirstName) {
		this.requesterSpouseSpouseInformationFirstName = requesterSpouseSpouseInformationFirstName;
	}
	
	public String getRequesterSpouseSpouseInformationFirstName() {
		return this.requesterSpouseSpouseInformationFirstName;
	}
	
	public boolean checkRequesterSpouseSpouseInformationFirstName() {
		return true;
	}

}