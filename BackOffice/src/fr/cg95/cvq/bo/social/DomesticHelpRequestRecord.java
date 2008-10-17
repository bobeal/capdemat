package fr.cg95.cvq.bo.social;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.social.*;

public class DomesticHelpRequestRecord extends RequestRecord {

	private java.math.BigInteger taxesAmountIncomeTax;
	private java.math.BigInteger notRealAssetsValuesTotal;
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
	private java.math.BigInteger requesterIncomesRequesterIncomesAnnualTotal;
	private boolean requesterFamilyReferentFamilyReferentDesignated;
	private java.math.BigInteger requesterIncomesRequesterAllowances;
	private java.math.BigInteger requesterIncomesRequesterRealEstateInvestmentIncome;
	private String subjectAdultFirstName;
	private String subjectAdultFamilyStatus;
	private String currentDwellingCurrentDwellingType;
	private String subjectAdultMaidenName;
	private String requesterRequestKind;
	private String subjectAdultLastName;
	private List notRealAssets;
	private boolean requesterSpouseSpousePensionner;
	private java.math.BigInteger taxesAmountTaxesTotal;
	private java.math.BigInteger taxesAmountPropertyTaxes;
	private boolean requesterSpouseSpouseMoreThan15YearsInFrance;
	private String requesterFamilyReferentFamilyReferentFirstName;
	private String requesterPensionPlan;
	private java.math.BigInteger taxesAmountLocalRate;
	private String nationality;
	private java.math.BigInteger realAssetsValuesTotal;
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
	private List realAssets;
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
	private boolean requesterSituationTutorPresence;
	private String requesterSpouseSpousePensionPlan;
	private java.math.BigInteger requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
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
	private java.math.BigInteger requesterSpouseIncomesSpouseIncomesAnnualTotal;

	public DomesticHelpRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DomesticHelpRequestRecord clonedRecord = (DomesticHelpRequestRecord)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 

			this.taxesAmountIncomeTax = request.getIncomeTax();
			this.notRealAssetsValuesTotal = request.getNotRealAssetsValuesTotal();
			this.currentDwellingCurrentDwellingRoomNumber = request.getCurrentDwellingRoomNumber();
			if (((Adult)request.getSubject()).getBirthDate() != null) {
				this.subjectAdultBirthDate = Calendar.getInstance(); 
	            this.subjectAdultBirthDate.setTime(((Adult)request.getSubject()).getBirthDate());
			}
			if (request.getSpouseNationality() != null)
                this.requesterSpouseSpouseNationality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RequesterSpouseType.class.getName(), 
                        "SpouseNationality", request.getSpouseNationality().toString());
            if ((request.getSpouseInformation() != null))
			this.requesterSpouseSpouseInformationLastName = request.getSpouseInformation().getLastName();
			this.requesterSpouseIncomesSpousePensions = request.getSpousePensions();
			if (request.getTutor() != null)
                this.requesterSituationTutor = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RequesterSituationType.class.getName(), 
                        "Tutor", request.getTutor().toString());
			this.requesterSpouseSpouseEmployer = request.getSpouseEmployer();
			if (request.getSpouseFranceArrivalDate() != null) {
				this.requesterSpouseSpouseFranceArrivalDate = Calendar.getInstance(); 
	            this.requesterSpouseSpouseFranceArrivalDate.setTime(request.getSpouseFranceArrivalDate());
			}
			this.pensionPlanPrecision = request.getPensionPlanPrecision();
			if (request.getSpouseEmployerAddress() != null) {
				this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = request.getSpouseEmployerAddress().getAdditionalDeliveryInformation();
				this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = request.getSpouseEmployerAddress().getAdditionalGeographicalInformation();
				this.requesterSpouseSpouseEmployerAddressStreetNumber = request.getSpouseEmployerAddress().getStreetNumber();
				this.requesterSpouseSpouseEmployerAddressStreetName = request.getSpouseEmployerAddress().getStreetName();
				this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = request.getSpouseEmployerAddress().getPlaceNameOrService();
				this.requesterSpouseSpouseEmployerAddressPostalCode = request.getSpouseEmployerAddress().getPostalCode();
				this.requesterSpouseSpouseEmployerAddressCity = request.getSpouseEmployerAddress().getCity();
			}
			this.requesterIncomesRequesterIncomesAnnualTotal = request.getRequesterIncomesAnnualTotal();
			this.requesterFamilyReferentFamilyReferentDesignated = request.getFamilyReferentDesignated();
			this.requesterIncomesRequesterAllowances = request.getRequesterAllowances();
			this.requesterIncomesRequesterRealEstateInvestmentIncome = request.getRequesterRealEstateInvestmentIncome();
			this.subjectAdultFirstName = ((Adult)request.getSubject()).getFirstName();
			if (request.getCurrentDwellingType() != null)
                this.currentDwellingCurrentDwellingType = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(), 
                        "CurrentDwellingType", request.getCurrentDwellingType().toString());
			this.subjectAdultMaidenName = ((Adult)request.getSubject()).getMaidenName();
			if (request.getRequesterRequestKind() != null)
                this.requesterRequestKind = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                        "RequesterRequestKind", request.getRequesterRequestKind().toString());
			this.subjectAdultLastName = ((Adult)request.getSubject()).getLastName();
			this.requesterSpouseSpousePensionner = request.getSpousePensionner();
			this.taxesAmountTaxesTotal = request.getTaxesTotal();
			this.taxesAmountPropertyTaxes = request.getPropertyTaxes();
			this.requesterSpouseSpouseMoreThan15YearsInFrance = request.getSpouseMoreThan15YearsInFrance();
			this.requesterFamilyReferentFamilyReferentFirstName = request.getFamilyReferentFirstName();
			if (request.getRequesterPensionPlan() != null)
                this.requesterPensionPlan = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                        "RequesterPensionPlan", request.getRequesterPensionPlan().toString());
			this.taxesAmountLocalRate = request.getLocalRate();
			if (request.getNationality() != null)
                this.nationality = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                        "Nationality", request.getNationality().toString());
			this.realAssetsValuesTotal = request.getRealAssetsValuesTotal();
			this.currentDwellingCurrentDwellingNetFloorArea = request.getCurrentDwellingNetFloorArea();
			this.complementaryPensionPlanPrecision = request.getComplementaryPensionPlanPrecision();
			if (request.getCurrentDwellingArrivalDate() != null) {
				this.currentDwellingCurrentDwellingArrivalDate = Calendar.getInstance(); 
	            this.currentDwellingCurrentDwellingArrivalDate.setTime(request.getCurrentDwellingArrivalDate());
			}
			if (request.getPreviousDwellingDepartureDate() != null) {
				this.previousDwellingPreviousDwellingDepartureDate = Calendar.getInstance(); 
	            this.previousDwellingPreviousDwellingDepartureDate.setTime(request.getPreviousDwellingDepartureDate());
			}
			this.requesterSituationTutorName = request.getTutorName();
			if (request.getTutorAddress() != null) {
				this.requesterSituationTutorAddressAdditionalDeliveryInformation = request.getTutorAddress().getAdditionalDeliveryInformation();
				this.requesterSituationTutorAddressAdditionalGeographicalInformation = request.getTutorAddress().getAdditionalGeographicalInformation();
				this.requesterSituationTutorAddressStreetNumber = request.getTutorAddress().getStreetNumber();
				this.requesterSituationTutorAddressStreetName = request.getTutorAddress().getStreetName();
				this.requesterSituationTutorAddressPlaceNameOrService = request.getTutorAddress().getPlaceNameOrService();
				this.requesterSituationTutorAddressPostalCode = request.getTutorAddress().getPostalCode();
				this.requesterSituationTutorAddressCity = request.getTutorAddress().getCity();
			}
			this.requesterIncomesRequesterNetIncome = request.getRequesterNetIncome();
			this.requesterSpouseSpouseOccupation = request.getSpouseOccupation();
            if ((request.getSpouseInformation() != null))
			this.requesterSpouseSpouseInformationBirthPlaceCity = request.getSpouseInformation().getBirthCity();
			this.currentDwellingCurrentDwellingPersonalPhone = request.getCurrentDwellingPersonalPhone();
			this.requesterSpouseIncomesSpouseNetIncome = request.getSpouseNetIncome();
			this.requesterIncomesRequesterFurnitureInvestmentIncome = request.getRequesterFurnitureInvestmentIncome();
			if (request.getFamilyReferentAddress() != null) {
				this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation = request.getFamilyReferentAddress().getAdditionalDeliveryInformation();
				this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation = request.getFamilyReferentAddress().getAdditionalGeographicalInformation();
				this.requesterFamilyReferentFamilyReferentAddressStreetNumber = request.getFamilyReferentAddress().getStreetNumber();
				this.requesterFamilyReferentFamilyReferentAddressStreetName = request.getFamilyReferentAddress().getStreetName();
				this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService = request.getFamilyReferentAddress().getPlaceNameOrService();
				this.requesterFamilyReferentFamilyReferentAddressPostalCode = request.getFamilyReferentAddress().getPostalCode();
				this.requesterFamilyReferentFamilyReferentAddressCity = request.getFamilyReferentAddress().getCity();
			}
			this.requesterSpouseIncomesSpouseAllowances = request.getSpouseAllowances();
            if ((request.getSpouseInformation() != null))
			this.requesterSpouseSpouseInformationMaidenName = request.getSpouseInformation().getMaidenName();
			this.requesterFamilyReferentFamilyReferentName = request.getFamilyReferentName();
			if (request.getRequesterHasSpouse() != null)
                this.requesterHasSpouse = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                        "RequesterHasSpouse", request.getRequesterHasSpouse().toString());
			if (request.getCurrentDwellingStatus() != null)
                this.currentDwellingCurrentDwellingStatus = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(), 
                        "CurrentDwellingStatus", request.getCurrentDwellingStatus().toString());
			this.requesterSpouseSpouseComplementaryPensionPlanPrecision = request.getSpouseComplementaryPensionPlanPrecision();
            if ((request.getSpouseInformation() != null))
			if (request.getSpouseInformation().getBirthDate() != null) {
				this.requesterSpouseSpouseInformationBirthDate = Calendar.getInstance(); 
	            this.requesterSpouseSpouseInformationBirthDate.setTime(request.getSpouseInformation().getBirthDate());
			}
			if (request.getPreviousDwellingAddress() != null) {
				this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = request.getPreviousDwellingAddress().getAdditionalDeliveryInformation();
				this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = request.getPreviousDwellingAddress().getAdditionalGeographicalInformation();
				this.previousDwellingPreviousDwellingAddressStreetNumber = request.getPreviousDwellingAddress().getStreetNumber();
				this.previousDwellingPreviousDwellingAddressStreetName = request.getPreviousDwellingAddress().getStreetName();
				this.previousDwellingPreviousDwellingAddressPlaceNameOrService = request.getPreviousDwellingAddress().getPlaceNameOrService();
				this.previousDwellingPreviousDwellingAddressPostalCode = request.getPreviousDwellingAddress().getPostalCode();
				this.previousDwellingPreviousDwellingAddressCity = request.getPreviousDwellingAddress().getCity();
			}
			this.taxesAmountProfessionalTaxes = request.getProfessionalTaxes();
			if (request.getPreviousDwellingArrivalDate() != null) {
				this.previousDwellingPreviousDwellingArrivalDate = Calendar.getInstance(); 
	            this.previousDwellingPreviousDwellingArrivalDate.setTime(request.getPreviousDwellingArrivalDate());
			}
			this.requesterSituationTutorPresence = request.getTutorPresence();
			if (request.getSpousePensionPlan() != null)
                this.requesterSpouseSpousePensionPlan = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RequesterSpouseType.class.getName(), 
                        "SpousePensionPlan", request.getSpousePensionPlan().toString());
			this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = request.getSpouseFurnitureInvestmentIncome();
			this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = request.getSpouseRealEstateInvestmentIncome();
			this.requesterIncomesRequesterPensions = request.getRequesterPensions();
			if (request.getFranceArrivalDate() != null) {
				this.franceArrivalDate = Calendar.getInstance(); 
	            this.franceArrivalDate.setTime(request.getFranceArrivalDate());
			}
            if ((request.getMoreThan15YearsInFrance() != null))
			this.moreThan15YearsInFrance = request.getMoreThan15YearsInFrance();
			this.requesterSpouseSpousePensionPlanPrecision = request.getSpousePensionPlanPrecision();
			this.subjectAdultBirthPlaceCity = ((Adult)request.getSubject()).getBirthCity();
			if (request.getCurrentDwellingAddress() != null) {
				this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = request.getCurrentDwellingAddress().getAdditionalDeliveryInformation();
				this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = request.getCurrentDwellingAddress().getAdditionalGeographicalInformation();
				this.currentDwellingCurrentDwellingAddressStreetNumber = request.getCurrentDwellingAddress().getStreetNumber();
				this.currentDwellingCurrentDwellingAddressStreetName = request.getCurrentDwellingAddress().getStreetName();
				this.currentDwellingCurrentDwellingAddressPlaceNameOrService = request.getCurrentDwellingAddress().getPlaceNameOrService();
				this.currentDwellingCurrentDwellingAddressPostalCode = request.getCurrentDwellingAddress().getPostalCode();
				this.currentDwellingCurrentDwellingAddressCity = request.getCurrentDwellingAddress().getCity();
			}
            if ((request.getSpouseInformation() != null))
			this.requesterSpouseSpouseInformationFirstName = request.getSpouseInformation().getFirstName();
			this.requesterSpouseIncomesSpouseIncomesAnnualTotal = request.getSpouseIncomesAnnualTotal();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 

			request.setIncomeTax(this.taxesAmountIncomeTax);
			request.setCurrentDwellingRoomNumber(this.currentDwellingCurrentDwellingRoomNumber);
			if (this.requesterSpouseSpouseNationality != null)
                request.setSpouseNationality(
                    NationalityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RequesterSpouseType.class.getName(),
                            "SpouseNationality", this.requesterSpouseSpouseNationality)
                    )
                );
			request.setSpousePensions(this.requesterSpouseIncomesSpousePensions);
			if (this.requesterSituationTutor != null)
                request.setTutor(
                    DhrTutorType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RequesterSituationType.class.getName(),
                            "Tutor", this.requesterSituationTutor)
                    )
                );
			request.setSpouseEmployer(this.requesterSpouseSpouseEmployer);
			if (this.requesterSpouseSpouseFranceArrivalDate != null)
			request.setSpouseFranceArrivalDate(this.requesterSpouseSpouseFranceArrivalDate.getTime());
			request.setPensionPlanPrecision(this.pensionPlanPrecision);
  			if (request.getSpouseEmployerAddress() != null) {
				request.getSpouseEmployerAddress().setAdditionalDeliveryInformation(this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation);
				request.getSpouseEmployerAddress().setAdditionalGeographicalInformation(this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation);
				request.getSpouseEmployerAddress().setStreetNumber(this.requesterSpouseSpouseEmployerAddressStreetNumber);
				request.getSpouseEmployerAddress().setStreetName(this.requesterSpouseSpouseEmployerAddressStreetName);
				request.getSpouseEmployerAddress().setPlaceNameOrService(this.requesterSpouseSpouseEmployerAddressPlaceNameOrService);
				request.getSpouseEmployerAddress().setPostalCode(this.requesterSpouseSpouseEmployerAddressPostalCode);
				request.getSpouseEmployerAddress().setCity(this.requesterSpouseSpouseEmployerAddressCity);
			}
			request.setRequesterIncomesAnnualTotal(this.requesterIncomesRequesterIncomesAnnualTotal);
			request.setFamilyReferentDesignated(this.requesterFamilyReferentFamilyReferentDesignated);
			request.setRequesterAllowances(this.requesterIncomesRequesterAllowances);
			request.setRequesterRealEstateInvestmentIncome(this.requesterIncomesRequesterRealEstateInvestmentIncome);
			if (this.currentDwellingCurrentDwellingType != null)
                request.setCurrentDwellingType(
                    DhrDwellingType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(),
                            "CurrentDwellingType", this.currentDwellingCurrentDwellingType)
                    )
                );
			if (this.requesterRequestKind != null)
                request.setRequesterRequestKind(
                    DhrRequestKindType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                            "RequesterRequestKind", this.requesterRequestKind)
                    )
                );
			request.setSpousePensionner(this.requesterSpouseSpousePensionner);
			request.setTaxesTotal(this.taxesAmountTaxesTotal);
			request.setPropertyTaxes(this.taxesAmountPropertyTaxes);
			request.setSpouseMoreThan15YearsInFrance(this.requesterSpouseSpouseMoreThan15YearsInFrance);
			request.setFamilyReferentFirstName(this.requesterFamilyReferentFamilyReferentFirstName);
			if (this.requesterPensionPlan != null)
                request.setRequesterPensionPlan(
                    DhrPensionPlanType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                            "RequesterPensionPlan", this.requesterPensionPlan)
                    )
                );
			request.setLocalRate(this.taxesAmountLocalRate);
			if (this.nationality != null)
                request.setNationality(
                    NationalityType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                            "Nationality", this.nationality)
                    )
                );
			request.setCurrentDwellingNetFloorArea(this.currentDwellingCurrentDwellingNetFloorArea);
			request.setComplementaryPensionPlanPrecision(this.complementaryPensionPlanPrecision);
			if (this.currentDwellingCurrentDwellingArrivalDate != null)
			request.setCurrentDwellingArrivalDate(this.currentDwellingCurrentDwellingArrivalDate.getTime());
			if (this.previousDwellingPreviousDwellingDepartureDate != null)
			request.setPreviousDwellingDepartureDate(this.previousDwellingPreviousDwellingDepartureDate.getTime());
			request.setTutorName(this.requesterSituationTutorName);
  			if (request.getTutorAddress() != null) {
				request.getTutorAddress().setAdditionalDeliveryInformation(this.requesterSituationTutorAddressAdditionalDeliveryInformation);
				request.getTutorAddress().setAdditionalGeographicalInformation(this.requesterSituationTutorAddressAdditionalGeographicalInformation);
				request.getTutorAddress().setStreetNumber(this.requesterSituationTutorAddressStreetNumber);
				request.getTutorAddress().setStreetName(this.requesterSituationTutorAddressStreetName);
				request.getTutorAddress().setPlaceNameOrService(this.requesterSituationTutorAddressPlaceNameOrService);
				request.getTutorAddress().setPostalCode(this.requesterSituationTutorAddressPostalCode);
				request.getTutorAddress().setCity(this.requesterSituationTutorAddressCity);
			}
			request.setRequesterNetIncome(this.requesterIncomesRequesterNetIncome);
			request.setSpouseOccupation(this.requesterSpouseSpouseOccupation);
			request.setCurrentDwellingPersonalPhone(this.currentDwellingCurrentDwellingPersonalPhone);
			request.setSpouseNetIncome(this.requesterSpouseIncomesSpouseNetIncome);
			request.setRequesterFurnitureInvestmentIncome(this.requesterIncomesRequesterFurnitureInvestmentIncome);
  			if (request.getFamilyReferentAddress() != null) {
				request.getFamilyReferentAddress().setAdditionalDeliveryInformation(this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation);
				request.getFamilyReferentAddress().setAdditionalGeographicalInformation(this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation);
				request.getFamilyReferentAddress().setStreetNumber(this.requesterFamilyReferentFamilyReferentAddressStreetNumber);
				request.getFamilyReferentAddress().setStreetName(this.requesterFamilyReferentFamilyReferentAddressStreetName);
				request.getFamilyReferentAddress().setPlaceNameOrService(this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService);
				request.getFamilyReferentAddress().setPostalCode(this.requesterFamilyReferentFamilyReferentAddressPostalCode);
				request.getFamilyReferentAddress().setCity(this.requesterFamilyReferentFamilyReferentAddressCity);
			}
			request.setSpouseAllowances(this.requesterSpouseIncomesSpouseAllowances);
			request.setFamilyReferentName(this.requesterFamilyReferentFamilyReferentName);
			if (this.requesterHasSpouse != null)
                request.setRequesterHasSpouse(
                    DhrRequesterHasSpouse.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest.class.getName(), 
                            "RequesterHasSpouse", this.requesterHasSpouse)
                    )
                );
			if (this.currentDwellingCurrentDwellingStatus != null)
                request.setCurrentDwellingStatus(
                    DhrDwellingStatusType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(),
                            "CurrentDwellingStatus", this.currentDwellingCurrentDwellingStatus)
                    )
                );
			request.setSpouseComplementaryPensionPlanPrecision(this.requesterSpouseSpouseComplementaryPensionPlanPrecision);
  			if (request.getPreviousDwellingAddress() != null) {
				request.getPreviousDwellingAddress().setAdditionalDeliveryInformation(this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation);
				request.getPreviousDwellingAddress().setAdditionalGeographicalInformation(this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation);
				request.getPreviousDwellingAddress().setStreetNumber(this.previousDwellingPreviousDwellingAddressStreetNumber);
				request.getPreviousDwellingAddress().setStreetName(this.previousDwellingPreviousDwellingAddressStreetName);
				request.getPreviousDwellingAddress().setPlaceNameOrService(this.previousDwellingPreviousDwellingAddressPlaceNameOrService);
				request.getPreviousDwellingAddress().setPostalCode(this.previousDwellingPreviousDwellingAddressPostalCode);
				request.getPreviousDwellingAddress().setCity(this.previousDwellingPreviousDwellingAddressCity);
			}
			request.setProfessionalTaxes(this.taxesAmountProfessionalTaxes);
			if (this.previousDwellingPreviousDwellingArrivalDate != null)
			request.setPreviousDwellingArrivalDate(this.previousDwellingPreviousDwellingArrivalDate.getTime());
			request.setTutorPresence(this.requesterSituationTutorPresence);
			if (this.requesterSpouseSpousePensionPlan != null)
                request.setSpousePensionPlan(
                    DhrPensionPlanType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RequesterSpouseType.class.getName(),
                            "SpousePensionPlan", this.requesterSpouseSpousePensionPlan)
                    )
                );
			request.setSpouseFurnitureInvestmentIncome(this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome);
			request.setSpouseRealEstateInvestmentIncome(this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome);
			request.setRequesterPensions(this.requesterIncomesRequesterPensions);
			if (this.franceArrivalDate != null)
			request.setFranceArrivalDate(this.franceArrivalDate.getTime());
            if ((request.getMoreThan15YearsInFrance() != null))
			request.setMoreThan15YearsInFrance(this.moreThan15YearsInFrance);
			request.setSpousePensionPlanPrecision(this.requesterSpouseSpousePensionPlanPrecision);
  			if (request.getCurrentDwellingAddress() != null) {
				request.getCurrentDwellingAddress().setAdditionalDeliveryInformation(this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation);
				request.getCurrentDwellingAddress().setAdditionalGeographicalInformation(this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation);
				request.getCurrentDwellingAddress().setStreetNumber(this.currentDwellingCurrentDwellingAddressStreetNumber);
				request.getCurrentDwellingAddress().setStreetName(this.currentDwellingCurrentDwellingAddressStreetName);
				request.getCurrentDwellingAddress().setPlaceNameOrService(this.currentDwellingCurrentDwellingAddressPlaceNameOrService);
				request.getCurrentDwellingAddress().setPostalCode(this.currentDwellingCurrentDwellingAddressPostalCode);
				request.getCurrentDwellingAddress().setCity(this.currentDwellingCurrentDwellingAddressCity);
			}
			request.setSpouseIncomesAnnualTotal(this.requesterSpouseIncomesSpouseIncomesAnnualTotal);
        }
    }
    
	public void setTaxesAmountIncomeTax(java.math.BigInteger taxesAmountIncomeTax) {
		this.taxesAmountIncomeTax = taxesAmountIncomeTax;
	}
	
	public java.math.BigInteger getTaxesAmountIncomeTax() {
		return this.taxesAmountIncomeTax;
	}

	public void setNotRealAssetsValuesTotal(java.math.BigInteger notRealAssetsValuesTotal) {
		this.notRealAssetsValuesTotal = notRealAssetsValuesTotal;
	}
	
	public java.math.BigInteger getNotRealAssetsValuesTotal() {
		return this.notRealAssetsValuesTotal;
	}

	public void setCurrentDwellingCurrentDwellingRoomNumber(java.math.BigInteger currentDwellingCurrentDwellingRoomNumber) {
		this.currentDwellingCurrentDwellingRoomNumber = currentDwellingCurrentDwellingRoomNumber;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingRoomNumber() {
		return this.currentDwellingCurrentDwellingRoomNumber;
	}

	public void setSubjectAdultBirthDate(Calendar subjectAdultBirthDate) {
		this.subjectAdultBirthDate = subjectAdultBirthDate;
	}
	
	public Calendar getSubjectAdultBirthDate() {
		return this.subjectAdultBirthDate;
	}

	public void setRequesterSpouseSpouseNationality(String requesterSpouseSpouseNationality) {
		this.requesterSpouseSpouseNationality = requesterSpouseSpouseNationality;
	}
	
	public String getRequesterSpouseSpouseNationality() {
		return this.requesterSpouseSpouseNationality;
	}

	public void setRequesterSpouseSpouseInformationLastName(String requesterSpouseSpouseInformationLastName) {
		this.requesterSpouseSpouseInformationLastName = requesterSpouseSpouseInformationLastName;
	}
	
	public String getRequesterSpouseSpouseInformationLastName() {
		return this.requesterSpouseSpouseInformationLastName;
	}

	public void setRequesterSpouseIncomesSpousePensions(java.math.BigInteger requesterSpouseIncomesSpousePensions) {
		this.requesterSpouseIncomesSpousePensions = requesterSpouseIncomesSpousePensions;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpousePensions() {
		return this.requesterSpouseIncomesSpousePensions;
	}

	public void setRequesterSituationTutor(String requesterSituationTutor) {
		this.requesterSituationTutor = requesterSituationTutor;
	}
	
	public String getRequesterSituationTutor() {
		return this.requesterSituationTutor;
	}

	public void setRequesterSpouseSpouseEmployer(String requesterSpouseSpouseEmployer) {
		this.requesterSpouseSpouseEmployer = requesterSpouseSpouseEmployer;
	}
	
	public String getRequesterSpouseSpouseEmployer() {
		return this.requesterSpouseSpouseEmployer;
	}

	public void setRequesterSpouseSpouseFranceArrivalDate(Calendar requesterSpouseSpouseFranceArrivalDate) {
		this.requesterSpouseSpouseFranceArrivalDate = requesterSpouseSpouseFranceArrivalDate;
	}
	
	public Calendar getRequesterSpouseSpouseFranceArrivalDate() {
		return this.requesterSpouseSpouseFranceArrivalDate;
	}

	public void setPensionPlanPrecision(String pensionPlanPrecision) {
		this.pensionPlanPrecision = pensionPlanPrecision;
	}
	
	public String getPensionPlanPrecision() {
		return this.pensionPlanPrecision;
	}

	public void setRequesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation(String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation) {
		this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation() {
		return this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	}

	public void setRequesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation(String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation) {
		this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation() {
		return this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	}

	public void setRequesterSpouseSpouseEmployerAddressStreetNumber(String requesterSpouseSpouseEmployerAddressStreetNumber) {
		this.requesterSpouseSpouseEmployerAddressStreetNumber = requesterSpouseSpouseEmployerAddressStreetNumber;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressStreetNumber() {
		return this.requesterSpouseSpouseEmployerAddressStreetNumber;
	}

	public void setRequesterSpouseSpouseEmployerAddressStreetName(String requesterSpouseSpouseEmployerAddressStreetName) {
		this.requesterSpouseSpouseEmployerAddressStreetName = requesterSpouseSpouseEmployerAddressStreetName;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressStreetName() {
		return this.requesterSpouseSpouseEmployerAddressStreetName;
	}

	public void setRequesterSpouseSpouseEmployerAddressPlaceNameOrService(String requesterSpouseSpouseEmployerAddressPlaceNameOrService) {
		this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressPlaceNameOrService() {
		return this.requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	}

	public void setRequesterSpouseSpouseEmployerAddressPostalCode(String requesterSpouseSpouseEmployerAddressPostalCode) {
		this.requesterSpouseSpouseEmployerAddressPostalCode = requesterSpouseSpouseEmployerAddressPostalCode;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressPostalCode() {
		return this.requesterSpouseSpouseEmployerAddressPostalCode;
	}

	public void setRequesterSpouseSpouseEmployerAddressCity(String requesterSpouseSpouseEmployerAddressCity) {
		this.requesterSpouseSpouseEmployerAddressCity = requesterSpouseSpouseEmployerAddressCity;
	}
	
	public String getRequesterSpouseSpouseEmployerAddressCity() {
		return this.requesterSpouseSpouseEmployerAddressCity;
	}

	public void setRequesterIncomesRequesterIncomesAnnualTotal(java.math.BigInteger requesterIncomesRequesterIncomesAnnualTotal) {
		this.requesterIncomesRequesterIncomesAnnualTotal = requesterIncomesRequesterIncomesAnnualTotal;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterIncomesAnnualTotal() {
		return this.requesterIncomesRequesterIncomesAnnualTotal;
	}

	public void setRequesterFamilyReferentFamilyReferentDesignated(boolean requesterFamilyReferentFamilyReferentDesignated) {
		this.requesterFamilyReferentFamilyReferentDesignated = requesterFamilyReferentFamilyReferentDesignated;
	}
	
	public boolean getRequesterFamilyReferentFamilyReferentDesignated() {
		return this.requesterFamilyReferentFamilyReferentDesignated;
	}

	public void setRequesterIncomesRequesterAllowances(java.math.BigInteger requesterIncomesRequesterAllowances) {
		this.requesterIncomesRequesterAllowances = requesterIncomesRequesterAllowances;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterAllowances() {
		return this.requesterIncomesRequesterAllowances;
	}

	public void setRequesterIncomesRequesterRealEstateInvestmentIncome(java.math.BigInteger requesterIncomesRequesterRealEstateInvestmentIncome) {
		this.requesterIncomesRequesterRealEstateInvestmentIncome = requesterIncomesRequesterRealEstateInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterRealEstateInvestmentIncome() {
		return this.requesterIncomesRequesterRealEstateInvestmentIncome;
	}

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
	}

	public void setSubjectAdultFamilyStatus(String subjectAdultFamilyStatus) {
		this.subjectAdultFamilyStatus = subjectAdultFamilyStatus;
	}
	
	public String getSubjectAdultFamilyStatus() {
		return this.subjectAdultFamilyStatus;
	}

	public void setCurrentDwellingCurrentDwellingType(String currentDwellingCurrentDwellingType) {
		this.currentDwellingCurrentDwellingType = currentDwellingCurrentDwellingType;
	}
	
	public String getCurrentDwellingCurrentDwellingType() {
		return this.currentDwellingCurrentDwellingType;
	}

	public void setSubjectAdultMaidenName(String subjectAdultMaidenName) {
		this.subjectAdultMaidenName = subjectAdultMaidenName;
	}
	
	public String getSubjectAdultMaidenName() {
		return this.subjectAdultMaidenName;
	}

	public void setRequesterRequestKind(String requesterRequestKind) {
		this.requesterRequestKind = requesterRequestKind;
	}
	
	public String getRequesterRequestKind() {
		return this.requesterRequestKind;
	}

	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
	}

	public void setNotRealAssets(List notRealAssets) {
		this.notRealAssets = notRealAssets;
	}
	
	public List getNotRealAssets() {
		return this.notRealAssets;
	}

	public void setRequesterSpouseSpousePensionner(boolean requesterSpouseSpousePensionner) {
		this.requesterSpouseSpousePensionner = requesterSpouseSpousePensionner;
	}
	
	public boolean getRequesterSpouseSpousePensionner() {
		return this.requesterSpouseSpousePensionner;
	}

	public void setTaxesAmountTaxesTotal(java.math.BigInteger taxesAmountTaxesTotal) {
		this.taxesAmountTaxesTotal = taxesAmountTaxesTotal;
	}
	
	public java.math.BigInteger getTaxesAmountTaxesTotal() {
		return this.taxesAmountTaxesTotal;
	}

	public void setTaxesAmountPropertyTaxes(java.math.BigInteger taxesAmountPropertyTaxes) {
		this.taxesAmountPropertyTaxes = taxesAmountPropertyTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountPropertyTaxes() {
		return this.taxesAmountPropertyTaxes;
	}

	public void setRequesterSpouseSpouseMoreThan15YearsInFrance(boolean requesterSpouseSpouseMoreThan15YearsInFrance) {
		this.requesterSpouseSpouseMoreThan15YearsInFrance = requesterSpouseSpouseMoreThan15YearsInFrance;
	}
	
	public boolean getRequesterSpouseSpouseMoreThan15YearsInFrance() {
		return this.requesterSpouseSpouseMoreThan15YearsInFrance;
	}

	public void setRequesterFamilyReferentFamilyReferentFirstName(String requesterFamilyReferentFamilyReferentFirstName) {
		this.requesterFamilyReferentFamilyReferentFirstName = requesterFamilyReferentFamilyReferentFirstName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentFirstName() {
		return this.requesterFamilyReferentFamilyReferentFirstName;
	}

	public void setRequesterPensionPlan(String requesterPensionPlan) {
		this.requesterPensionPlan = requesterPensionPlan;
	}
	
	public String getRequesterPensionPlan() {
		return this.requesterPensionPlan;
	}

	public void setTaxesAmountLocalRate(java.math.BigInteger taxesAmountLocalRate) {
		this.taxesAmountLocalRate = taxesAmountLocalRate;
	}
	
	public java.math.BigInteger getTaxesAmountLocalRate() {
		return this.taxesAmountLocalRate;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getNationality() {
		return this.nationality;
	}

	public void setRealAssetsValuesTotal(java.math.BigInteger realAssetsValuesTotal) {
		this.realAssetsValuesTotal = realAssetsValuesTotal;
	}
	
	public java.math.BigInteger getRealAssetsValuesTotal() {
		return this.realAssetsValuesTotal;
	}

	public void setCurrentDwellingCurrentDwellingNetFloorArea(java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea) {
		this.currentDwellingCurrentDwellingNetFloorArea = currentDwellingCurrentDwellingNetFloorArea;
	}
	
	public java.math.BigInteger getCurrentDwellingCurrentDwellingNetFloorArea() {
		return this.currentDwellingCurrentDwellingNetFloorArea;
	}

	public void setComplementaryPensionPlanPrecision(String complementaryPensionPlanPrecision) {
		this.complementaryPensionPlanPrecision = complementaryPensionPlanPrecision;
	}
	
	public String getComplementaryPensionPlanPrecision() {
		return this.complementaryPensionPlanPrecision;
	}

	public void setCurrentDwellingCurrentDwellingArrivalDate(Calendar currentDwellingCurrentDwellingArrivalDate) {
		this.currentDwellingCurrentDwellingArrivalDate = currentDwellingCurrentDwellingArrivalDate;
	}
	
	public Calendar getCurrentDwellingCurrentDwellingArrivalDate() {
		return this.currentDwellingCurrentDwellingArrivalDate;
	}

	public void setPreviousDwellingPreviousDwellingDepartureDate(Calendar previousDwellingPreviousDwellingDepartureDate) {
		this.previousDwellingPreviousDwellingDepartureDate = previousDwellingPreviousDwellingDepartureDate;
	}
	
	public Calendar getPreviousDwellingPreviousDwellingDepartureDate() {
		return this.previousDwellingPreviousDwellingDepartureDate;
	}

	public void setRequesterSituationTutorName(String requesterSituationTutorName) {
		this.requesterSituationTutorName = requesterSituationTutorName;
	}
	
	public String getRequesterSituationTutorName() {
		return this.requesterSituationTutorName;
	}

	public void setRequesterSituationTutorAddressAdditionalDeliveryInformation(String requesterSituationTutorAddressAdditionalDeliveryInformation) {
		this.requesterSituationTutorAddressAdditionalDeliveryInformation = requesterSituationTutorAddressAdditionalDeliveryInformation;
	}
	
	public String getRequesterSituationTutorAddressAdditionalDeliveryInformation() {
		return this.requesterSituationTutorAddressAdditionalDeliveryInformation;
	}

	public void setRequesterSituationTutorAddressAdditionalGeographicalInformation(String requesterSituationTutorAddressAdditionalGeographicalInformation) {
		this.requesterSituationTutorAddressAdditionalGeographicalInformation = requesterSituationTutorAddressAdditionalGeographicalInformation;
	}
	
	public String getRequesterSituationTutorAddressAdditionalGeographicalInformation() {
		return this.requesterSituationTutorAddressAdditionalGeographicalInformation;
	}

	public void setRequesterSituationTutorAddressStreetNumber(String requesterSituationTutorAddressStreetNumber) {
		this.requesterSituationTutorAddressStreetNumber = requesterSituationTutorAddressStreetNumber;
	}
	
	public String getRequesterSituationTutorAddressStreetNumber() {
		return this.requesterSituationTutorAddressStreetNumber;
	}

	public void setRequesterSituationTutorAddressStreetName(String requesterSituationTutorAddressStreetName) {
		this.requesterSituationTutorAddressStreetName = requesterSituationTutorAddressStreetName;
	}
	
	public String getRequesterSituationTutorAddressStreetName() {
		return this.requesterSituationTutorAddressStreetName;
	}

	public void setRequesterSituationTutorAddressPlaceNameOrService(String requesterSituationTutorAddressPlaceNameOrService) {
		this.requesterSituationTutorAddressPlaceNameOrService = requesterSituationTutorAddressPlaceNameOrService;
	}
	
	public String getRequesterSituationTutorAddressPlaceNameOrService() {
		return this.requesterSituationTutorAddressPlaceNameOrService;
	}

	public void setRequesterSituationTutorAddressPostalCode(String requesterSituationTutorAddressPostalCode) {
		this.requesterSituationTutorAddressPostalCode = requesterSituationTutorAddressPostalCode;
	}
	
	public String getRequesterSituationTutorAddressPostalCode() {
		return this.requesterSituationTutorAddressPostalCode;
	}

	public void setRequesterSituationTutorAddressCity(String requesterSituationTutorAddressCity) {
		this.requesterSituationTutorAddressCity = requesterSituationTutorAddressCity;
	}
	
	public String getRequesterSituationTutorAddressCity() {
		return this.requesterSituationTutorAddressCity;
	}

	public void setRequesterIncomesRequesterNetIncome(java.math.BigInteger requesterIncomesRequesterNetIncome) {
		this.requesterIncomesRequesterNetIncome = requesterIncomesRequesterNetIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterNetIncome() {
		return this.requesterIncomesRequesterNetIncome;
	}

	public void setRequesterSpouseSpouseOccupation(String requesterSpouseSpouseOccupation) {
		this.requesterSpouseSpouseOccupation = requesterSpouseSpouseOccupation;
	}
	
	public String getRequesterSpouseSpouseOccupation() {
		return this.requesterSpouseSpouseOccupation;
	}

	public void setRequesterSpouseSpouseInformationBirthPlaceCity(String requesterSpouseSpouseInformationBirthPlaceCity) {
		this.requesterSpouseSpouseInformationBirthPlaceCity = requesterSpouseSpouseInformationBirthPlaceCity;
	}
	
	public String getRequesterSpouseSpouseInformationBirthPlaceCity() {
		return this.requesterSpouseSpouseInformationBirthPlaceCity;
	}

	public void setCurrentDwellingCurrentDwellingPersonalPhone(String currentDwellingCurrentDwellingPersonalPhone) {
		this.currentDwellingCurrentDwellingPersonalPhone = currentDwellingCurrentDwellingPersonalPhone;
	}
	
	public String getCurrentDwellingCurrentDwellingPersonalPhone() {
		return this.currentDwellingCurrentDwellingPersonalPhone;
	}

	public void setRequesterSpouseIncomesSpouseNetIncome(java.math.BigInteger requesterSpouseIncomesSpouseNetIncome) {
		this.requesterSpouseIncomesSpouseNetIncome = requesterSpouseIncomesSpouseNetIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseNetIncome() {
		return this.requesterSpouseIncomesSpouseNetIncome;
	}

	public void setRequesterIncomesRequesterFurnitureInvestmentIncome(java.math.BigInteger requesterIncomesRequesterFurnitureInvestmentIncome) {
		this.requesterIncomesRequesterFurnitureInvestmentIncome = requesterIncomesRequesterFurnitureInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterFurnitureInvestmentIncome() {
		return this.requesterIncomesRequesterFurnitureInvestmentIncome;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation(String requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation) {
		this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation = requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation() {
		return this.requesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation(String requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation) {
		this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation = requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation() {
		return this.requesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressStreetNumber(String requesterFamilyReferentFamilyReferentAddressStreetNumber) {
		this.requesterFamilyReferentFamilyReferentAddressStreetNumber = requesterFamilyReferentFamilyReferentAddressStreetNumber;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressStreetNumber() {
		return this.requesterFamilyReferentFamilyReferentAddressStreetNumber;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressStreetName(String requesterFamilyReferentFamilyReferentAddressStreetName) {
		this.requesterFamilyReferentFamilyReferentAddressStreetName = requesterFamilyReferentFamilyReferentAddressStreetName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressStreetName() {
		return this.requesterFamilyReferentFamilyReferentAddressStreetName;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressPlaceNameOrService(String requesterFamilyReferentFamilyReferentAddressPlaceNameOrService) {
		this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService = requesterFamilyReferentFamilyReferentAddressPlaceNameOrService;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressPlaceNameOrService() {
		return this.requesterFamilyReferentFamilyReferentAddressPlaceNameOrService;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressPostalCode(String requesterFamilyReferentFamilyReferentAddressPostalCode) {
		this.requesterFamilyReferentFamilyReferentAddressPostalCode = requesterFamilyReferentFamilyReferentAddressPostalCode;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressPostalCode() {
		return this.requesterFamilyReferentFamilyReferentAddressPostalCode;
	}

	public void setRequesterFamilyReferentFamilyReferentAddressCity(String requesterFamilyReferentFamilyReferentAddressCity) {
		this.requesterFamilyReferentFamilyReferentAddressCity = requesterFamilyReferentFamilyReferentAddressCity;
	}
	
	public String getRequesterFamilyReferentFamilyReferentAddressCity() {
		return this.requesterFamilyReferentFamilyReferentAddressCity;
	}

	public void setRequesterSpouseIncomesSpouseAllowances(java.math.BigInteger requesterSpouseIncomesSpouseAllowances) {
		this.requesterSpouseIncomesSpouseAllowances = requesterSpouseIncomesSpouseAllowances;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseAllowances() {
		return this.requesterSpouseIncomesSpouseAllowances;
	}

	public void setRealAssets(List realAssets) {
		this.realAssets = realAssets;
	}
	
	public List getRealAssets() {
		return this.realAssets;
	}

	public void setRequesterSpouseSpouseInformationMaidenName(String requesterSpouseSpouseInformationMaidenName) {
		this.requesterSpouseSpouseInformationMaidenName = requesterSpouseSpouseInformationMaidenName;
	}
	
	public String getRequesterSpouseSpouseInformationMaidenName() {
		return this.requesterSpouseSpouseInformationMaidenName;
	}

	public void setRequesterFamilyReferentFamilyReferentName(String requesterFamilyReferentFamilyReferentName) {
		this.requesterFamilyReferentFamilyReferentName = requesterFamilyReferentFamilyReferentName;
	}
	
	public String getRequesterFamilyReferentFamilyReferentName() {
		return this.requesterFamilyReferentFamilyReferentName;
	}

	public void setRequesterHasSpouse(String requesterHasSpouse) {
		this.requesterHasSpouse = requesterHasSpouse;
	}
	
	public String getRequesterHasSpouse() {
		return this.requesterHasSpouse;
	}

	public void setCurrentDwellingCurrentDwellingStatus(String currentDwellingCurrentDwellingStatus) {
		this.currentDwellingCurrentDwellingStatus = currentDwellingCurrentDwellingStatus;
	}
	
	public String getCurrentDwellingCurrentDwellingStatus() {
		return this.currentDwellingCurrentDwellingStatus;
	}

	public void setRequesterSpouseSpouseComplementaryPensionPlanPrecision(String requesterSpouseSpouseComplementaryPensionPlanPrecision) {
		this.requesterSpouseSpouseComplementaryPensionPlanPrecision = requesterSpouseSpouseComplementaryPensionPlanPrecision;
	}
	
	public String getRequesterSpouseSpouseComplementaryPensionPlanPrecision() {
		return this.requesterSpouseSpouseComplementaryPensionPlanPrecision;
	}

	public void setRequesterSpouseSpouseInformationBirthDate(Calendar requesterSpouseSpouseInformationBirthDate) {
		this.requesterSpouseSpouseInformationBirthDate = requesterSpouseSpouseInformationBirthDate;
	}
	
	public Calendar getRequesterSpouseSpouseInformationBirthDate() {
		return this.requesterSpouseSpouseInformationBirthDate;
	}

	public void setPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation(String previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation) {
		this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation = previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation() {
		return this.previousDwellingPreviousDwellingAddressAdditionalDeliveryInformation;
	}

	public void setPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation(String previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation) {
		this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation = previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation() {
		return this.previousDwellingPreviousDwellingAddressAdditionalGeographicalInformation;
	}

	public void setPreviousDwellingPreviousDwellingAddressStreetNumber(String previousDwellingPreviousDwellingAddressStreetNumber) {
		this.previousDwellingPreviousDwellingAddressStreetNumber = previousDwellingPreviousDwellingAddressStreetNumber;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressStreetNumber() {
		return this.previousDwellingPreviousDwellingAddressStreetNumber;
	}

	public void setPreviousDwellingPreviousDwellingAddressStreetName(String previousDwellingPreviousDwellingAddressStreetName) {
		this.previousDwellingPreviousDwellingAddressStreetName = previousDwellingPreviousDwellingAddressStreetName;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressStreetName() {
		return this.previousDwellingPreviousDwellingAddressStreetName;
	}

	public void setPreviousDwellingPreviousDwellingAddressPlaceNameOrService(String previousDwellingPreviousDwellingAddressPlaceNameOrService) {
		this.previousDwellingPreviousDwellingAddressPlaceNameOrService = previousDwellingPreviousDwellingAddressPlaceNameOrService;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressPlaceNameOrService() {
		return this.previousDwellingPreviousDwellingAddressPlaceNameOrService;
	}

	public void setPreviousDwellingPreviousDwellingAddressPostalCode(String previousDwellingPreviousDwellingAddressPostalCode) {
		this.previousDwellingPreviousDwellingAddressPostalCode = previousDwellingPreviousDwellingAddressPostalCode;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressPostalCode() {
		return this.previousDwellingPreviousDwellingAddressPostalCode;
	}

	public void setPreviousDwellingPreviousDwellingAddressCity(String previousDwellingPreviousDwellingAddressCity) {
		this.previousDwellingPreviousDwellingAddressCity = previousDwellingPreviousDwellingAddressCity;
	}
	
	public String getPreviousDwellingPreviousDwellingAddressCity() {
		return this.previousDwellingPreviousDwellingAddressCity;
	}

	public void setSubjectAdultTitle(String subjectAdultTitle) {
		this.subjectAdultTitle = subjectAdultTitle;
	}
	
	public String getSubjectAdultTitle() {
		return this.subjectAdultTitle;
	}

	public void setTaxesAmountProfessionalTaxes(java.math.BigInteger taxesAmountProfessionalTaxes) {
		this.taxesAmountProfessionalTaxes = taxesAmountProfessionalTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountProfessionalTaxes() {
		return this.taxesAmountProfessionalTaxes;
	}

	public void setPreviousDwellingPreviousDwellingArrivalDate(Calendar previousDwellingPreviousDwellingArrivalDate) {
		this.previousDwellingPreviousDwellingArrivalDate = previousDwellingPreviousDwellingArrivalDate;
	}
	
	public Calendar getPreviousDwellingPreviousDwellingArrivalDate() {
		return this.previousDwellingPreviousDwellingArrivalDate;
	}

	public void setRequesterSituationTutorPresence(boolean requesterSituationTutorPresence) {
		this.requesterSituationTutorPresence = requesterSituationTutorPresence;
	}
	
	public boolean getRequesterSituationTutorPresence() {
		return this.requesterSituationTutorPresence;
	}

	public void setRequesterSpouseSpousePensionPlan(String requesterSpouseSpousePensionPlan) {
		this.requesterSpouseSpousePensionPlan = requesterSpouseSpousePensionPlan;
	}
	
	public String getRequesterSpouseSpousePensionPlan() {
		return this.requesterSpouseSpousePensionPlan;
	}

	public void setRequesterSpouseIncomesSpouseFurnitureInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseFurnitureInvestmentIncome) {
		this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome = requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseFurnitureInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseFurnitureInvestmentIncome;
	}

	public void setRequesterSpouseIncomesSpouseRealEstateInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseRealEstateInvestmentIncome) {
		this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome = requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseRealEstateInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseRealEstateInvestmentIncome;
	}

	public void setRequesterIncomesRequesterPensions(java.math.BigInteger requesterIncomesRequesterPensions) {
		this.requesterIncomesRequesterPensions = requesterIncomesRequesterPensions;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterPensions() {
		return this.requesterIncomesRequesterPensions;
	}

	public void setFranceArrivalDate(Calendar franceArrivalDate) {
		this.franceArrivalDate = franceArrivalDate;
	}
	
	public Calendar getFranceArrivalDate() {
		return this.franceArrivalDate;
	}

	public void setMoreThan15YearsInFrance(boolean moreThan15YearsInFrance) {
		this.moreThan15YearsInFrance = moreThan15YearsInFrance;
	}
	
	public boolean getMoreThan15YearsInFrance() {
		return this.moreThan15YearsInFrance;
	}

	public void setRequesterSpouseSpousePensionPlanPrecision(String requesterSpouseSpousePensionPlanPrecision) {
		this.requesterSpouseSpousePensionPlanPrecision = requesterSpouseSpousePensionPlanPrecision;
	}
	
	public String getRequesterSpouseSpousePensionPlanPrecision() {
		return this.requesterSpouseSpousePensionPlanPrecision;
	}

	public void setSubjectAdultBirthPlaceCity(String subjectAdultBirthPlaceCity) {
		this.subjectAdultBirthPlaceCity = subjectAdultBirthPlaceCity;
	}
	
	public String getSubjectAdultBirthPlaceCity() {
		return this.subjectAdultBirthPlaceCity;
	}

	public void setCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation(String currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation) {
		this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation = currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressAdditionalDeliveryInformation() {
		return this.currentDwellingCurrentDwellingAddressAdditionalDeliveryInformation;
	}

	public void setCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation(String currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation) {
		this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation = currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressAdditionalGeographicalInformation() {
		return this.currentDwellingCurrentDwellingAddressAdditionalGeographicalInformation;
	}

	public void setCurrentDwellingCurrentDwellingAddressStreetNumber(String currentDwellingCurrentDwellingAddressStreetNumber) {
		this.currentDwellingCurrentDwellingAddressStreetNumber = currentDwellingCurrentDwellingAddressStreetNumber;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressStreetNumber() {
		return this.currentDwellingCurrentDwellingAddressStreetNumber;
	}

	public void setCurrentDwellingCurrentDwellingAddressStreetName(String currentDwellingCurrentDwellingAddressStreetName) {
		this.currentDwellingCurrentDwellingAddressStreetName = currentDwellingCurrentDwellingAddressStreetName;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressStreetName() {
		return this.currentDwellingCurrentDwellingAddressStreetName;
	}

	public void setCurrentDwellingCurrentDwellingAddressPlaceNameOrService(String currentDwellingCurrentDwellingAddressPlaceNameOrService) {
		this.currentDwellingCurrentDwellingAddressPlaceNameOrService = currentDwellingCurrentDwellingAddressPlaceNameOrService;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressPlaceNameOrService() {
		return this.currentDwellingCurrentDwellingAddressPlaceNameOrService;
	}

	public void setCurrentDwellingCurrentDwellingAddressPostalCode(String currentDwellingCurrentDwellingAddressPostalCode) {
		this.currentDwellingCurrentDwellingAddressPostalCode = currentDwellingCurrentDwellingAddressPostalCode;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressPostalCode() {
		return this.currentDwellingCurrentDwellingAddressPostalCode;
	}

	public void setCurrentDwellingCurrentDwellingAddressCity(String currentDwellingCurrentDwellingAddressCity) {
		this.currentDwellingCurrentDwellingAddressCity = currentDwellingCurrentDwellingAddressCity;
	}
	
	public String getCurrentDwellingCurrentDwellingAddressCity() {
		return this.currentDwellingCurrentDwellingAddressCity;
	}

	public void setRequesterSpouseSpouseInformationFirstName(String requesterSpouseSpouseInformationFirstName) {
		this.requesterSpouseSpouseInformationFirstName = requesterSpouseSpouseInformationFirstName;
	}
	
	public String getRequesterSpouseSpouseInformationFirstName() {
		return this.requesterSpouseSpouseInformationFirstName;
	}

	public void setRequesterSpouseIncomesSpouseIncomesAnnualTotal(java.math.BigInteger requesterSpouseIncomesSpouseIncomesAnnualTotal) {
		this.requesterSpouseIncomesSpouseIncomesAnnualTotal = requesterSpouseIncomesSpouseIncomesAnnualTotal;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseIncomesAnnualTotal() {
		return this.requesterSpouseIncomesSpouseIncomesAnnualTotal;
	}

}

