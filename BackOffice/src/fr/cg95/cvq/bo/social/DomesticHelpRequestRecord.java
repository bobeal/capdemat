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
	private java.math.BigInteger currentDwellingCurrentDwellingRoomNumber;
	private Calendar subjectAdultBirthDate;
	private java.math.BigInteger capitalsCapitalAmountTotal;
	private String requesterSpouseSpouseNationality;
	private String requesterSpouseSpouseInformationLastName;
	private java.math.BigInteger requesterSpouseIncomesSpousePensions;
	private String requesterSituationTutor;
	private String requesterSpouseSpouseEmployer;
  	private String requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation;
	private String requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation;
	private String requesterSpouseSpouseEmployerAddressStreetNumber;
	private String requesterSpouseSpouseEmployerAddressStreetName;
	private String requesterSpouseSpouseEmployerAddressPlaceNameOrService;
	private String requesterSpouseSpouseEmployerAddressPostalCode;
	private String requesterSpouseSpouseEmployerAddressCity;
	private Calendar requesterSpouseSpouseFranceArrivalDate;
	private java.math.BigInteger requesterIncomesRequesterIncomesAnnualTotal;
	private java.math.BigInteger requesterIncomesRequesterAllowances;
	private String subjectAdultFirstName;
	private String currentDwellingCurrentDwellingType;
	private String subjectAdultMaidenName;
	private String subjectAdultLastName;
	private boolean requesterSpouseSpousePensionner;
	private java.math.BigInteger taxesAmountTaxesTotal;
	private String requesterSpouseSpouseSocialSecurityKeyNumber;
	private java.math.BigInteger taxesAmountPropertyTaxes;
	private String requesterPensionPlan;
	private java.math.BigInteger taxesAmountLocalRate;
	private String nationality;
	private java.math.BigInteger realAssetsValuesTotal;
	private java.math.BigInteger currentDwellingCurrentDwellingNetFloorArea;
	private Calendar currentDwellingCurrentDwellingArrivalDate;
	private String requesterSituationTutorName;
	private java.math.BigInteger requesterSpouseIncomesSpouseInvestmentIncome;
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
	private String requesterSpouseSpouseSocialSecurityNumber;
	private String requesterSituationTutorFirstName;
	private java.math.BigInteger capitalsSharesAmount;
	private List savings;
	private String socialSecurityNumber;
	private java.math.BigInteger requesterIncomesRequesterInvestmentIncome;
	private java.math.BigInteger requesterSpouseIncomesSpouseNetIncome;
	private java.math.BigInteger requesterSpouseIncomesSpouseAllowances;
	private String requesterSpouseSpouseInformationMaidenName;
	private List realAssets;
	private String currentDwellingCurrentDwellingStatus;
	private Calendar requesterSpouseSpouseInformationBirthDate;
	private java.math.BigInteger mensualExpensesAlimonies;
	private java.math.BigInteger taxesAmountProfessionalTaxes;
	private java.math.BigInteger donationsValuesTotal;
	private java.math.BigInteger mensualExpensesExpensesTotal;
	private java.math.BigInteger savingsTotal;
	private java.math.BigInteger capitalsBondsAmount;
	private boolean requesterSituationTutorPresence;
	private String requesterSpouseSpousePensionPlan;
	private String socialSecurityKeyNumber;
	private java.math.BigInteger mensualExpensesRent;
	private List donations;
	private java.math.BigInteger requesterIncomesRequesterPensions;
	private Calendar franceArrivalDate;
	private List previousDwellings;
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
			this.currentDwellingCurrentDwellingRoomNumber = request.getCurrentDwellingRoomNumber();
			if (((Adult)request.getSubject()).getBirthDate() != null) {
				this.subjectAdultBirthDate = Calendar.getInstance(); 
	            this.subjectAdultBirthDate.setTime(((Adult)request.getSubject()).getBirthDate());
			}
			this.capitalsCapitalAmountTotal = request.getCapitalAmountTotal();
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
			if (request.getSpouseEmployerAddress() != null) {
				this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation = request.getSpouseEmployerAddress().getAdditionalDeliveryInformation();
				this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation = request.getSpouseEmployerAddress().getAdditionalGeographicalInformation();
				this.requesterSpouseSpouseEmployerAddressStreetNumber = request.getSpouseEmployerAddress().getStreetNumber();
				this.requesterSpouseSpouseEmployerAddressStreetName = request.getSpouseEmployerAddress().getStreetName();
				this.requesterSpouseSpouseEmployerAddressPlaceNameOrService = request.getSpouseEmployerAddress().getPlaceNameOrService();
				this.requesterSpouseSpouseEmployerAddressPostalCode = request.getSpouseEmployerAddress().getPostalCode();
				this.requesterSpouseSpouseEmployerAddressCity = request.getSpouseEmployerAddress().getCity();
			}
			if (request.getSpouseFranceArrivalDate() != null) {
				this.requesterSpouseSpouseFranceArrivalDate = Calendar.getInstance(); 
	            this.requesterSpouseSpouseFranceArrivalDate.setTime(request.getSpouseFranceArrivalDate());
			}
			this.requesterIncomesRequesterIncomesAnnualTotal = request.getRequesterIncomesAnnualTotal();
			this.requesterIncomesRequesterAllowances = request.getRequesterAllowances();
			this.subjectAdultFirstName = ((Adult)request.getSubject()).getFirstName();
			if (request.getCurrentDwellingType() != null)
                this.currentDwellingCurrentDwellingType = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(), 
                        "CurrentDwellingType", request.getCurrentDwellingType().toString());
			this.subjectAdultMaidenName = ((Adult)request.getSubject()).getMaidenName();
			this.subjectAdultLastName = ((Adult)request.getSubject()).getLastName();
			this.requesterSpouseSpousePensionner = request.getSpousePensionner();
			this.taxesAmountTaxesTotal = request.getTaxesTotal();
			this.requesterSpouseSpouseSocialSecurityKeyNumber = request.getSpouseSocialSecurityKeyNumber();
			this.taxesAmountPropertyTaxes = request.getPropertyTaxes();
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
			if (request.getCurrentDwellingArrivalDate() != null) {
				this.currentDwellingCurrentDwellingArrivalDate = Calendar.getInstance(); 
	            this.currentDwellingCurrentDwellingArrivalDate.setTime(request.getCurrentDwellingArrivalDate());
			}
			this.requesterSituationTutorName = request.getTutorName();
			this.requesterSpouseIncomesSpouseInvestmentIncome = request.getSpouseInvestmentIncome();
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
			this.requesterSpouseSpouseSocialSecurityNumber = request.getSpouseSocialSecurityNumber();
			this.requesterSituationTutorFirstName = request.getTutorFirstName();
			this.capitalsSharesAmount = request.getSharesAmount();
			this.socialSecurityNumber = request.getSocialSecurityNumber();
			this.requesterIncomesRequesterInvestmentIncome = request.getRequesterInvestmentIncome();
			this.requesterSpouseIncomesSpouseNetIncome = request.getSpouseNetIncome();
			this.requesterSpouseIncomesSpouseAllowances = request.getSpouseAllowances();
            if ((request.getSpouseInformation() != null))
			this.requesterSpouseSpouseInformationMaidenName = request.getSpouseInformation().getMaidenName();
			if (request.getCurrentDwellingStatus() != null)
                this.currentDwellingCurrentDwellingStatus = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(), 
                        "CurrentDwellingStatus", request.getCurrentDwellingStatus().toString());
            if ((request.getSpouseInformation() != null))
			if (request.getSpouseInformation().getBirthDate() != null) {
				this.requesterSpouseSpouseInformationBirthDate = Calendar.getInstance(); 
	            this.requesterSpouseSpouseInformationBirthDate.setTime(request.getSpouseInformation().getBirthDate());
			}
			this.mensualExpensesAlimonies = request.getAlimonies();
			this.taxesAmountProfessionalTaxes = request.getProfessionalTaxes();
			this.donationsValuesTotal = request.getDonationsValuesTotal();
			this.mensualExpensesExpensesTotal = request.getExpensesTotal();
			this.savingsTotal = request.getSavingsTotal();
			this.capitalsBondsAmount = request.getBondsAmount();
			this.requesterSituationTutorPresence = request.getTutorPresence();
			if (request.getSpousePensionPlan() != null)
                this.requesterSpouseSpousePensionPlan = getEnumElementTranslation(
                        fr.cg95.cvq.xml.social.RequesterSpouseType.class.getName(), 
                        "SpousePensionPlan", request.getSpousePensionPlan().toString());
			this.socialSecurityKeyNumber = request.getSocialSecurityKeyNumber();
			this.mensualExpensesRent = request.getRent();
			this.requesterIncomesRequesterPensions = request.getRequesterPensions();
			if (request.getFranceArrivalDate() != null) {
				this.franceArrivalDate = Calendar.getInstance(); 
	            this.franceArrivalDate.setTime(request.getFranceArrivalDate());
			}
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
  			if (request.getSpouseEmployerAddress() != null) {
				request.getSpouseEmployerAddress().setAdditionalDeliveryInformation(this.requesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation);
				request.getSpouseEmployerAddress().setAdditionalGeographicalInformation(this.requesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation);
				request.getSpouseEmployerAddress().setStreetNumber(this.requesterSpouseSpouseEmployerAddressStreetNumber);
				request.getSpouseEmployerAddress().setStreetName(this.requesterSpouseSpouseEmployerAddressStreetName);
				request.getSpouseEmployerAddress().setPlaceNameOrService(this.requesterSpouseSpouseEmployerAddressPlaceNameOrService);
				request.getSpouseEmployerAddress().setPostalCode(this.requesterSpouseSpouseEmployerAddressPostalCode);
				request.getSpouseEmployerAddress().setCity(this.requesterSpouseSpouseEmployerAddressCity);
			}
			if (this.requesterSpouseSpouseFranceArrivalDate != null)
			request.setSpouseFranceArrivalDate(this.requesterSpouseSpouseFranceArrivalDate.getTime());
			request.setRequesterIncomesAnnualTotal(this.requesterIncomesRequesterIncomesAnnualTotal);
			request.setRequesterAllowances(this.requesterIncomesRequesterAllowances);
			if (this.currentDwellingCurrentDwellingType != null)
                request.setCurrentDwellingType(
                    DhrDwellingType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(),
                            "CurrentDwellingType", this.currentDwellingCurrentDwellingType)
                    )
                );
			request.setSpousePensionner(this.requesterSpouseSpousePensionner);
			request.setTaxesTotal(this.taxesAmountTaxesTotal);
			request.setSpouseSocialSecurityKeyNumber(this.requesterSpouseSpouseSocialSecurityKeyNumber);
			request.setPropertyTaxes(this.taxesAmountPropertyTaxes);
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
			if (this.currentDwellingCurrentDwellingArrivalDate != null)
			request.setCurrentDwellingArrivalDate(this.currentDwellingCurrentDwellingArrivalDate.getTime());
			request.setTutorName(this.requesterSituationTutorName);
			request.setSpouseInvestmentIncome(this.requesterSpouseIncomesSpouseInvestmentIncome);
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
			request.setSpouseSocialSecurityNumber(this.requesterSpouseSpouseSocialSecurityNumber);
			request.setTutorFirstName(this.requesterSituationTutorFirstName);
			request.setSocialSecurityNumber(this.socialSecurityNumber);
			request.setRequesterInvestmentIncome(this.requesterIncomesRequesterInvestmentIncome);
			request.setSpouseNetIncome(this.requesterSpouseIncomesSpouseNetIncome);
			request.setSpouseAllowances(this.requesterSpouseIncomesSpouseAllowances);
			if (this.currentDwellingCurrentDwellingStatus != null)
                request.setCurrentDwellingStatus(
                    DhrDwellingStatusType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.CurrentDwellingType.class.getName(),
                            "CurrentDwellingStatus", this.currentDwellingCurrentDwellingStatus)
                    )
                );
			request.setAlimonies(this.mensualExpensesAlimonies);
			request.setProfessionalTaxes(this.taxesAmountProfessionalTaxes);
			request.setExpensesTotal(this.mensualExpensesExpensesTotal);
			request.setTutorPresence(this.requesterSituationTutorPresence);
			if (this.requesterSpouseSpousePensionPlan != null)
                request.setSpousePensionPlan(
                    DhrPensionPlanType.forString(
                        getEnumKeyTranslation(
                            fr.cg95.cvq.xml.social.RequesterSpouseType.class.getName(),
                            "SpousePensionPlan", this.requesterSpouseSpousePensionPlan)
                    )
                );
			request.setSocialSecurityKeyNumber(this.socialSecurityKeyNumber);
			request.setRent(this.mensualExpensesRent);
			request.setRequesterPensions(this.requesterIncomesRequesterPensions);
			if (this.franceArrivalDate != null)
			request.setFranceArrivalDate(this.franceArrivalDate.getTime());
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

	public void setCapitalsCapitalAmountTotal(java.math.BigInteger capitalsCapitalAmountTotal) {
		this.capitalsCapitalAmountTotal = capitalsCapitalAmountTotal;
	}
	
	public java.math.BigInteger getCapitalsCapitalAmountTotal() {
		return this.capitalsCapitalAmountTotal;
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

	public void setRequesterSpouseSpouseFranceArrivalDate(Calendar requesterSpouseSpouseFranceArrivalDate) {
		this.requesterSpouseSpouseFranceArrivalDate = requesterSpouseSpouseFranceArrivalDate;
	}
	
	public Calendar getRequesterSpouseSpouseFranceArrivalDate() {
		return this.requesterSpouseSpouseFranceArrivalDate;
	}

	public void setRequesterIncomesRequesterIncomesAnnualTotal(java.math.BigInteger requesterIncomesRequesterIncomesAnnualTotal) {
		this.requesterIncomesRequesterIncomesAnnualTotal = requesterIncomesRequesterIncomesAnnualTotal;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterIncomesAnnualTotal() {
		return this.requesterIncomesRequesterIncomesAnnualTotal;
	}

	public void setRequesterIncomesRequesterAllowances(java.math.BigInteger requesterIncomesRequesterAllowances) {
		this.requesterIncomesRequesterAllowances = requesterIncomesRequesterAllowances;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterAllowances() {
		return this.requesterIncomesRequesterAllowances;
	}

	public void setSubjectAdultFirstName(String subjectAdultFirstName) {
		this.subjectAdultFirstName = subjectAdultFirstName;
	}
	
	public String getSubjectAdultFirstName() {
		return this.subjectAdultFirstName;
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

	public void setSubjectAdultLastName(String subjectAdultLastName) {
		this.subjectAdultLastName = subjectAdultLastName;
	}
	
	public String getSubjectAdultLastName() {
		return this.subjectAdultLastName;
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

	public void setRequesterSpouseSpouseSocialSecurityKeyNumber(String requesterSpouseSpouseSocialSecurityKeyNumber) {
		this.requesterSpouseSpouseSocialSecurityKeyNumber = requesterSpouseSpouseSocialSecurityKeyNumber;
	}
	
	public String getRequesterSpouseSpouseSocialSecurityKeyNumber() {
		return this.requesterSpouseSpouseSocialSecurityKeyNumber;
	}

	public void setTaxesAmountPropertyTaxes(java.math.BigInteger taxesAmountPropertyTaxes) {
		this.taxesAmountPropertyTaxes = taxesAmountPropertyTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountPropertyTaxes() {
		return this.taxesAmountPropertyTaxes;
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

	public void setCurrentDwellingCurrentDwellingArrivalDate(Calendar currentDwellingCurrentDwellingArrivalDate) {
		this.currentDwellingCurrentDwellingArrivalDate = currentDwellingCurrentDwellingArrivalDate;
	}
	
	public Calendar getCurrentDwellingCurrentDwellingArrivalDate() {
		return this.currentDwellingCurrentDwellingArrivalDate;
	}

	public void setRequesterSituationTutorName(String requesterSituationTutorName) {
		this.requesterSituationTutorName = requesterSituationTutorName;
	}
	
	public String getRequesterSituationTutorName() {
		return this.requesterSituationTutorName;
	}

	public void setRequesterSpouseIncomesSpouseInvestmentIncome(java.math.BigInteger requesterSpouseIncomesSpouseInvestmentIncome) {
		this.requesterSpouseIncomesSpouseInvestmentIncome = requesterSpouseIncomesSpouseInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseInvestmentIncome() {
		return this.requesterSpouseIncomesSpouseInvestmentIncome;
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

	public void setRequesterSpouseSpouseSocialSecurityNumber(String requesterSpouseSpouseSocialSecurityNumber) {
		this.requesterSpouseSpouseSocialSecurityNumber = requesterSpouseSpouseSocialSecurityNumber;
	}
	
	public String getRequesterSpouseSpouseSocialSecurityNumber() {
		return this.requesterSpouseSpouseSocialSecurityNumber;
	}

	public void setRequesterSituationTutorFirstName(String requesterSituationTutorFirstName) {
		this.requesterSituationTutorFirstName = requesterSituationTutorFirstName;
	}
	
	public String getRequesterSituationTutorFirstName() {
		return this.requesterSituationTutorFirstName;
	}

	public void setCapitalsSharesAmount(java.math.BigInteger capitalsSharesAmount) {
		this.capitalsSharesAmount = capitalsSharesAmount;
	}
	
	public java.math.BigInteger getCapitalsSharesAmount() {
		return this.capitalsSharesAmount;
	}

	public void setSavings(List savings) {
		this.savings = savings;
	}
	
	public List getSavings() {
		return this.savings;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}

	public void setRequesterIncomesRequesterInvestmentIncome(java.math.BigInteger requesterIncomesRequesterInvestmentIncome) {
		this.requesterIncomesRequesterInvestmentIncome = requesterIncomesRequesterInvestmentIncome;
	}
	
	public java.math.BigInteger getRequesterIncomesRequesterInvestmentIncome() {
		return this.requesterIncomesRequesterInvestmentIncome;
	}

	public void setRequesterSpouseIncomesSpouseNetIncome(java.math.BigInteger requesterSpouseIncomesSpouseNetIncome) {
		this.requesterSpouseIncomesSpouseNetIncome = requesterSpouseIncomesSpouseNetIncome;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseNetIncome() {
		return this.requesterSpouseIncomesSpouseNetIncome;
	}

	public void setRequesterSpouseIncomesSpouseAllowances(java.math.BigInteger requesterSpouseIncomesSpouseAllowances) {
		this.requesterSpouseIncomesSpouseAllowances = requesterSpouseIncomesSpouseAllowances;
	}
	
	public java.math.BigInteger getRequesterSpouseIncomesSpouseAllowances() {
		return this.requesterSpouseIncomesSpouseAllowances;
	}

	public void setRequesterSpouseSpouseInformationMaidenName(String requesterSpouseSpouseInformationMaidenName) {
		this.requesterSpouseSpouseInformationMaidenName = requesterSpouseSpouseInformationMaidenName;
	}
	
	public String getRequesterSpouseSpouseInformationMaidenName() {
		return this.requesterSpouseSpouseInformationMaidenName;
	}

	public void setRealAssets(List realAssets) {
		this.realAssets = realAssets;
	}
	
	public List getRealAssets() {
		return this.realAssets;
	}

	public void setCurrentDwellingCurrentDwellingStatus(String currentDwellingCurrentDwellingStatus) {
		this.currentDwellingCurrentDwellingStatus = currentDwellingCurrentDwellingStatus;
	}
	
	public String getCurrentDwellingCurrentDwellingStatus() {
		return this.currentDwellingCurrentDwellingStatus;
	}

	public void setRequesterSpouseSpouseInformationBirthDate(Calendar requesterSpouseSpouseInformationBirthDate) {
		this.requesterSpouseSpouseInformationBirthDate = requesterSpouseSpouseInformationBirthDate;
	}
	
	public Calendar getRequesterSpouseSpouseInformationBirthDate() {
		return this.requesterSpouseSpouseInformationBirthDate;
	}

	public void setMensualExpensesAlimonies(java.math.BigInteger mensualExpensesAlimonies) {
		this.mensualExpensesAlimonies = mensualExpensesAlimonies;
	}
	
	public java.math.BigInteger getMensualExpensesAlimonies() {
		return this.mensualExpensesAlimonies;
	}

	public void setTaxesAmountProfessionalTaxes(java.math.BigInteger taxesAmountProfessionalTaxes) {
		this.taxesAmountProfessionalTaxes = taxesAmountProfessionalTaxes;
	}
	
	public java.math.BigInteger getTaxesAmountProfessionalTaxes() {
		return this.taxesAmountProfessionalTaxes;
	}

	public void setDonationsValuesTotal(java.math.BigInteger donationsValuesTotal) {
		this.donationsValuesTotal = donationsValuesTotal;
	}
	
	public java.math.BigInteger getDonationsValuesTotal() {
		return this.donationsValuesTotal;
	}

	public void setMensualExpensesExpensesTotal(java.math.BigInteger mensualExpensesExpensesTotal) {
		this.mensualExpensesExpensesTotal = mensualExpensesExpensesTotal;
	}
	
	public java.math.BigInteger getMensualExpensesExpensesTotal() {
		return this.mensualExpensesExpensesTotal;
	}

	public void setSavingsTotal(java.math.BigInteger savingsTotal) {
		this.savingsTotal = savingsTotal;
	}
	
	public java.math.BigInteger getSavingsTotal() {
		return this.savingsTotal;
	}

	public void setCapitalsBondsAmount(java.math.BigInteger capitalsBondsAmount) {
		this.capitalsBondsAmount = capitalsBondsAmount;
	}
	
	public java.math.BigInteger getCapitalsBondsAmount() {
		return this.capitalsBondsAmount;
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

	public void setSocialSecurityKeyNumber(String socialSecurityKeyNumber) {
		this.socialSecurityKeyNumber = socialSecurityKeyNumber;
	}
	
	public String getSocialSecurityKeyNumber() {
		return this.socialSecurityKeyNumber;
	}

	public void setMensualExpensesRent(java.math.BigInteger mensualExpensesRent) {
		this.mensualExpensesRent = mensualExpensesRent;
	}
	
	public java.math.BigInteger getMensualExpensesRent() {
		return this.mensualExpensesRent;
	}

	public void setDonations(List donations) {
		this.donations = donations;
	}
	
	public List getDonations() {
		return this.donations;
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

	public void setPreviousDwellings(List previousDwellings) {
		this.previousDwellings = previousDwellings;
	}
	
	public List getPreviousDwellings() {
		return this.previousDwellings;
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

