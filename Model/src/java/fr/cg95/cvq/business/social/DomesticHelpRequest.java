package fr.cg95.cvq.business.social;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="domestic_help_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class DomesticHelpRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public DomesticHelpRequest() {
        super();
        tutorPresence = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        DomesticHelpRequestDocument object = (DomesticHelpRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DomesticHelpRequestDocument domesticHelpRequestDoc = DomesticHelpRequestDocument.Factory.newInstance();
        DomesticHelpRequestDocument.DomesticHelpRequest domesticHelpRequest = domesticHelpRequestDoc.addNewDomesticHelpRequest();
        super.fillCommonXmlInfo(domesticHelpRequest);
        MensualExpensesType mensualExpensesTypeMensualExpenses = domesticHelpRequest.addNewMensualExpenses();
        if (this.expensesTotal != null)
            mensualExpensesTypeMensualExpenses.setExpensesTotal(new BigInteger(this.expensesTotal.toString()));
        CurrentDwellingType currentDwellingTypeCurrentDwelling = domesticHelpRequest.addNewCurrentDwelling();
        if (this.currentDwellingType != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingType(fr.cg95.cvq.xml.social.DhrDwellingType.Enum.forString(this.currentDwellingType.toString()));
        int i = 0;
        if (savings != null) {
            fr.cg95.cvq.xml.social.DhrPersonalEstateAndSavingType[] savingsTypeTab = new fr.cg95.cvq.xml.social.DhrPersonalEstateAndSavingType[savings.size()];
            Iterator savingsIt = savings.iterator();
            while (savingsIt.hasNext()) {
                DhrPersonalEstateAndSaving object = (DhrPersonalEstateAndSaving) savingsIt.next();
                savingsTypeTab[i] = (DhrPersonalEstateAndSavingType) object.modelToXml();
                i = i + 1;
            }
            domesticHelpRequest.setSavingsArray(savingsTypeTab);
        }
        TaxesAmountType taxesAmountTypeTaxesAmount = domesticHelpRequest.addNewTaxesAmount();
        if (this.professionalTaxes != null)
            taxesAmountTypeTaxesAmount.setProfessionalTaxes(new BigInteger(this.professionalTaxes.toString()));
        RequesterSpouseType requesterSpouseTypeRequesterSpouse = domesticHelpRequest.addNewRequesterSpouse();
        requesterSpouseTypeRequesterSpouse.setSpouseSocialSecurityNumber(this.spouseSocialSecurityNumber);
        i = 0;
        if (donations != null) {
            fr.cg95.cvq.xml.social.DhrDonationType[] donationsTypeTab = new fr.cg95.cvq.xml.social.DhrDonationType[donations.size()];
            Iterator donationsIt = donations.iterator();
            while (donationsIt.hasNext()) {
                DhrDonation object = (DhrDonation) donationsIt.next();
                donationsTypeTab[i] = (DhrDonationType) object.modelToXml();
                i = i + 1;
            }
            domesticHelpRequest.setDonationsArray(donationsTypeTab);
        }
        SpouseIncomesType spouseIncomesTypeRequesterSpouseIncomes = domesticHelpRequest.addNewRequesterSpouseIncomes();
        if (this.spousePensions != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpousePensions(new BigInteger(this.spousePensions.toString()));
        if (this.taxesTotal != null)
            taxesAmountTypeTaxesAmount.setTaxesTotal(new BigInteger(this.taxesTotal.toString()));
        RequesterSituationType requesterSituationTypeRequesterSituation = domesticHelpRequest.addNewRequesterSituation();
        if (this.tutorAddress != null)
            requesterSituationTypeRequesterSituation.setTutorAddress(Address.modelToXml(this.tutorAddress));
        RequesterIncomesType requesterIncomesTypeRequesterIncomes = domesticHelpRequest.addNewRequesterIncomes();
        if (this.requesterInvestmentIncome != null)
            requesterIncomesTypeRequesterIncomes.setRequesterInvestmentIncome(new BigInteger(this.requesterInvestmentIncome.toString()));
        if (this.alimonies != null)
            mensualExpensesTypeMensualExpenses.setAlimonies(new BigInteger(this.alimonies.toString()));
        i = 0;
        if (realAssets != null) {
            fr.cg95.cvq.xml.social.DhrRealAssetType[] realAssetsTypeTab = new fr.cg95.cvq.xml.social.DhrRealAssetType[realAssets.size()];
            Iterator realAssetsIt = realAssets.iterator();
            while (realAssetsIt.hasNext()) {
                DhrRealAsset object = (DhrRealAsset) realAssetsIt.next();
                realAssetsTypeTab[i] = (DhrRealAssetType) object.modelToXml();
                i = i + 1;
            }
            domesticHelpRequest.setRealAssetsArray(realAssetsTypeTab);
        }
        DhrPersonalEstateAndCapitalType dhrPersonalEstateAndCapitalTypeCapitals = domesticHelpRequest.addNewCapitals();
        if (this.sharesAmount != null)
            dhrPersonalEstateAndCapitalTypeCapitals.setSharesAmount(new BigInteger(this.sharesAmount.toString()));
        date = this.currentDwellingArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            currentDwellingTypeCurrentDwelling.setCurrentDwellingArrivalDate(calendar);
        }
        if (this.incomeTax != null)
            taxesAmountTypeTaxesAmount.setIncomeTax(new BigInteger(this.incomeTax.toString()));
        requesterSituationTypeRequesterSituation.setTutorName(this.tutorName);
        if (this.spouseAllowances != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseAllowances(new BigInteger(this.spouseAllowances.toString()));
        if (this.currentDwellingNetFloorArea != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingNetFloorArea(new BigInteger(this.currentDwellingNetFloorArea.toString()));
        if (this.currentDwellingStatus != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingStatus(fr.cg95.cvq.xml.social.DhrDwellingStatusType.Enum.forString(this.currentDwellingStatus.toString()));
        requesterSpouseTypeRequesterSpouse.setSpouseEmployer(this.spouseEmployer);
        if (this.requesterPensionPlan != null)
            domesticHelpRequest.setRequesterPensionPlan(fr.cg95.cvq.xml.social.DhrPensionPlanType.Enum.forString(this.requesterPensionPlan.toString()));
        if (this.nationality != null)
            domesticHelpRequest.setNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(this.nationality.toString()));
        if (this.realAssetsValuesTotal != null)
            domesticHelpRequest.setRealAssetsValuesTotal(new BigInteger(this.realAssetsValuesTotal.toString()));
        if (this.spouseEmployerAddress != null)
            requesterSpouseTypeRequesterSpouse.setSpouseEmployerAddress(Address.modelToXml(this.spouseEmployerAddress));
        if (this.spouseNationality != null)
            requesterSpouseTypeRequesterSpouse.setSpouseNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(this.spouseNationality.toString()));
        if (this.currentDwellingAddress != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingAddress(Address.modelToXml(this.currentDwellingAddress));
        if (this.spouseInformation != null)
            requesterSpouseTypeRequesterSpouse.setSpouseInformation(Adult.modelToXml(this.spouseInformation));
        if (this.tutorPresence != null)
            requesterSituationTypeRequesterSituation.setTutorPresence(this.tutorPresence.booleanValue());
        domesticHelpRequest.setSocialSecurityNumber(this.socialSecurityNumber);
        if (this.requesterIncomesAnnualTotal != null)
            requesterIncomesTypeRequesterIncomes.setRequesterIncomesAnnualTotal(new BigInteger(this.requesterIncomesAnnualTotal.toString()));
        if (this.tutor != null)
            requesterSituationTypeRequesterSituation.setTutor(fr.cg95.cvq.xml.social.DhrTutorType.Enum.forString(this.tutor.toString()));
        if (this.localRate != null)
            taxesAmountTypeTaxesAmount.setLocalRate(new BigInteger(this.localRate.toString()));
        if (this.requesterPensions != null)
            requesterIncomesTypeRequesterIncomes.setRequesterPensions(new BigInteger(this.requesterPensions.toString()));
        date = this.spouseFranceArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            requesterSpouseTypeRequesterSpouse.setSpouseFranceArrivalDate(calendar);
        }
        if (this.capitalAmountTotal != null)
            dhrPersonalEstateAndCapitalTypeCapitals.setCapitalAmountTotal(new BigInteger(this.capitalAmountTotal.toString()));
        if (this.propertyTaxes != null)
            taxesAmountTypeTaxesAmount.setPropertyTaxes(new BigInteger(this.propertyTaxes.toString()));
        requesterSituationTypeRequesterSituation.setTutorFirstName(this.tutorFirstName);
        if (this.donationsValuesTotal != null)
            domesticHelpRequest.setDonationsValuesTotal(new BigInteger(this.donationsValuesTotal.toString()));
        if (this.savingsTotal != null)
            domesticHelpRequest.setSavingsTotal(new BigInteger(this.savingsTotal.toString()));
        if (this.spouseIncomesAnnualTotal != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseIncomesAnnualTotal(new BigInteger(this.spouseIncomesAnnualTotal.toString()));
        domesticHelpRequest.setSocialSecurityKeyNumber(this.socialSecurityKeyNumber);
        requesterSpouseTypeRequesterSpouse.setSpouseSocialSecurityKeyNumber(this.spouseSocialSecurityKeyNumber);
        requesterSpouseTypeRequesterSpouse.setSpouseOccupation(this.spouseOccupation);
        date = this.franceArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            domesticHelpRequest.setFranceArrivalDate(calendar);
        }
        if (this.requesterAllowances != null)
            requesterIncomesTypeRequesterIncomes.setRequesterAllowances(new BigInteger(this.requesterAllowances.toString()));
        i = 0;
        if (previousDwellings != null) {
            fr.cg95.cvq.xml.social.DhrPreviousDwellingType[] previousDwellingsTypeTab = new fr.cg95.cvq.xml.social.DhrPreviousDwellingType[previousDwellings.size()];
            Iterator previousDwellingsIt = previousDwellings.iterator();
            while (previousDwellingsIt.hasNext()) {
                DhrPreviousDwelling object = (DhrPreviousDwelling) previousDwellingsIt.next();
                previousDwellingsTypeTab[i] = (DhrPreviousDwellingType) object.modelToXml();
                i = i + 1;
            }
            domesticHelpRequest.setPreviousDwellingsArray(previousDwellingsTypeTab);
        }
        if (this.spouseInvestmentIncome != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseInvestmentIncome(new BigInteger(this.spouseInvestmentIncome.toString()));
        if (this.spousePensionPlan != null)
            requesterSpouseTypeRequesterSpouse.setSpousePensionPlan(fr.cg95.cvq.xml.social.DhrPensionPlanType.Enum.forString(this.spousePensionPlan.toString()));
        if (this.bondsAmount != null)
            dhrPersonalEstateAndCapitalTypeCapitals.setBondsAmount(new BigInteger(this.bondsAmount.toString()));
        if (this.spouseNetIncome != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseNetIncome(new BigInteger(this.spouseNetIncome.toString()));
        if (this.spousePensionner != null)
            requesterSpouseTypeRequesterSpouse.setSpousePensionner(this.spousePensionner.booleanValue());
        if (this.requesterNetIncome != null)
            requesterIncomesTypeRequesterIncomes.setRequesterNetIncome(new BigInteger(this.requesterNetIncome.toString()));
        if (this.rent != null)
            mensualExpensesTypeMensualExpenses.setRent(new BigInteger(this.rent.toString()));
        if (this.currentDwellingRoomNumber != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingRoomNumber(new BigInteger(this.currentDwellingRoomNumber.toString()));
        return domesticHelpRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        DomesticHelpRequestDocument domesticHelpRequestDoc =
            (DomesticHelpRequestDocument) modelToXml();
        return domesticHelpRequestDoc.getDomesticHelpRequest();
    }

    public static DomesticHelpRequest xmlToModel(DomesticHelpRequestDocument domesticHelpRequestDoc) {

        DomesticHelpRequestDocument.DomesticHelpRequest domesticHelpRequestXml = domesticHelpRequestDoc.getDomesticHelpRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DomesticHelpRequest domesticHelpRequest = new DomesticHelpRequest();
        domesticHelpRequest.fillCommonModelInfo(domesticHelpRequest,domesticHelpRequestXml);
        domesticHelpRequest.setExpensesTotal(domesticHelpRequestXml.getMensualExpenses().getExpensesTotal());
        if (domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingType() != null)
            domesticHelpRequest.setCurrentDwellingType(fr.cg95.cvq.business.social.DhrDwellingType.forString(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingType().toString()));
        else
            domesticHelpRequest.setCurrentDwellingType(fr.cg95.cvq.business.social.DhrDwellingType.getDefaultDhrDwellingType());
        HashSet savingsSet = new HashSet();
        if ( domesticHelpRequestXml.sizeOfSavingsArray() > 0) {
            for (int i = 0; i < domesticHelpRequestXml.getSavingsArray().length; i++) {
                savingsSet.add(DhrPersonalEstateAndSaving.xmlToModel(domesticHelpRequestXml.getSavingsArray(i)));
            }
        }
        domesticHelpRequest.setSavings(savingsSet);
        domesticHelpRequest.setProfessionalTaxes(domesticHelpRequestXml.getTaxesAmount().getProfessionalTaxes());
        domesticHelpRequest.setSpouseSocialSecurityNumber(domesticHelpRequestXml.getRequesterSpouse().getSpouseSocialSecurityNumber());
        HashSet donationsSet = new HashSet();
        if ( domesticHelpRequestXml.sizeOfDonationsArray() > 0) {
            for (int i = 0; i < domesticHelpRequestXml.getDonationsArray().length; i++) {
                donationsSet.add(DhrDonation.xmlToModel(domesticHelpRequestXml.getDonationsArray(i)));
            }
        }
        domesticHelpRequest.setDonations(donationsSet);
        domesticHelpRequest.setSpousePensions(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpousePensions());
        domesticHelpRequest.setTaxesTotal(domesticHelpRequestXml.getTaxesAmount().getTaxesTotal());
        if (domesticHelpRequestXml.getRequesterSituation().getTutorAddress() != null)
            domesticHelpRequest.setTutorAddress(Address.xmlToModel(domesticHelpRequestXml.getRequesterSituation().getTutorAddress()));
        domesticHelpRequest.setRequesterInvestmentIncome(domesticHelpRequestXml.getRequesterIncomes().getRequesterInvestmentIncome());
        domesticHelpRequest.setAlimonies(domesticHelpRequestXml.getMensualExpenses().getAlimonies());
        HashSet realAssetsSet = new HashSet();
        if ( domesticHelpRequestXml.sizeOfRealAssetsArray() > 0) {
            for (int i = 0; i < domesticHelpRequestXml.getRealAssetsArray().length; i++) {
                realAssetsSet.add(DhrRealAsset.xmlToModel(domesticHelpRequestXml.getRealAssetsArray(i)));
            }
        }
        domesticHelpRequest.setRealAssets(realAssetsSet);
        domesticHelpRequest.setSharesAmount(domesticHelpRequestXml.getCapitals().getSharesAmount());
        calendar = domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setCurrentDwellingArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setIncomeTax(domesticHelpRequestXml.getTaxesAmount().getIncomeTax());
        domesticHelpRequest.setTutorName(domesticHelpRequestXml.getRequesterSituation().getTutorName());
        domesticHelpRequest.setSpouseAllowances(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseAllowances());
        domesticHelpRequest.setCurrentDwellingNetFloorArea(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingNetFloorArea());
        if (domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingStatus() != null)
            domesticHelpRequest.setCurrentDwellingStatus(fr.cg95.cvq.business.social.DhrDwellingStatusType.forString(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingStatus().toString()));
        else
            domesticHelpRequest.setCurrentDwellingStatus(fr.cg95.cvq.business.social.DhrDwellingStatusType.getDefaultDhrDwellingStatusType());
        domesticHelpRequest.setSpouseEmployer(domesticHelpRequestXml.getRequesterSpouse().getSpouseEmployer());
        if (domesticHelpRequestXml.getRequesterPensionPlan() != null)
            domesticHelpRequest.setRequesterPensionPlan(fr.cg95.cvq.business.social.DhrPensionPlanType.forString(domesticHelpRequestXml.getRequesterPensionPlan().toString()));
        else
            domesticHelpRequest.setRequesterPensionPlan(fr.cg95.cvq.business.social.DhrPensionPlanType.getDefaultDhrPensionPlanType());
        if (domesticHelpRequestXml.getNationality() != null)
            domesticHelpRequest.setNationality(fr.cg95.cvq.business.users.NationalityType.forString(domesticHelpRequestXml.getNationality().toString()));
        else
            domesticHelpRequest.setNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
        domesticHelpRequest.setRealAssetsValuesTotal(domesticHelpRequestXml.getRealAssetsValuesTotal());
        if (domesticHelpRequestXml.getRequesterSpouse().getSpouseEmployerAddress() != null)
            domesticHelpRequest.setSpouseEmployerAddress(Address.xmlToModel(domesticHelpRequestXml.getRequesterSpouse().getSpouseEmployerAddress()));
        if (domesticHelpRequestXml.getRequesterSpouse().getSpouseNationality() != null)
            domesticHelpRequest.setSpouseNationality(fr.cg95.cvq.business.users.NationalityType.forString(domesticHelpRequestXml.getRequesterSpouse().getSpouseNationality().toString()));
        else
            domesticHelpRequest.setSpouseNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
        if (domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingAddress() != null)
            domesticHelpRequest.setCurrentDwellingAddress(Address.xmlToModel(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingAddress()));
        if (domesticHelpRequestXml.getRequesterSpouse().getSpouseInformation() != null)
            domesticHelpRequest.setSpouseInformation(Adult.xmlToModel(domesticHelpRequestXml.getRequesterSpouse().getSpouseInformation()));
        domesticHelpRequest.setTutorPresence(Boolean.valueOf(domesticHelpRequestXml.getRequesterSituation().getTutorPresence()));
        domesticHelpRequest.setSocialSecurityNumber(domesticHelpRequestXml.getSocialSecurityNumber());
        domesticHelpRequest.setRequesterIncomesAnnualTotal(domesticHelpRequestXml.getRequesterIncomes().getRequesterIncomesAnnualTotal());
        if (domesticHelpRequestXml.getRequesterSituation().getTutor() != null)
            domesticHelpRequest.setTutor(fr.cg95.cvq.business.social.DhrTutorType.forString(domesticHelpRequestXml.getRequesterSituation().getTutor().toString()));
        else
            domesticHelpRequest.setTutor(fr.cg95.cvq.business.social.DhrTutorType.getDefaultDhrTutorType());
        domesticHelpRequest.setLocalRate(domesticHelpRequestXml.getTaxesAmount().getLocalRate());
        domesticHelpRequest.setRequesterPensions(domesticHelpRequestXml.getRequesterIncomes().getRequesterPensions());
        calendar = domesticHelpRequestXml.getRequesterSpouse().getSpouseFranceArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setSpouseFranceArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setCapitalAmountTotal(domesticHelpRequestXml.getCapitals().getCapitalAmountTotal());
        domesticHelpRequest.setPropertyTaxes(domesticHelpRequestXml.getTaxesAmount().getPropertyTaxes());
        domesticHelpRequest.setTutorFirstName(domesticHelpRequestXml.getRequesterSituation().getTutorFirstName());
        domesticHelpRequest.setDonationsValuesTotal(domesticHelpRequestXml.getDonationsValuesTotal());
        domesticHelpRequest.setSavingsTotal(domesticHelpRequestXml.getSavingsTotal());
        domesticHelpRequest.setSpouseIncomesAnnualTotal(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseIncomesAnnualTotal());
        domesticHelpRequest.setSocialSecurityKeyNumber(domesticHelpRequestXml.getSocialSecurityKeyNumber());
        domesticHelpRequest.setSpouseSocialSecurityKeyNumber(domesticHelpRequestXml.getRequesterSpouse().getSpouseSocialSecurityKeyNumber());
        domesticHelpRequest.setSpouseOccupation(domesticHelpRequestXml.getRequesterSpouse().getSpouseOccupation());
        calendar = domesticHelpRequestXml.getFranceArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setFranceArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setRequesterAllowances(domesticHelpRequestXml.getRequesterIncomes().getRequesterAllowances());
        HashSet previousDwellingsSet = new HashSet();
        if ( domesticHelpRequestXml.sizeOfPreviousDwellingsArray() > 0) {
            for (int i = 0; i < domesticHelpRequestXml.getPreviousDwellingsArray().length; i++) {
                previousDwellingsSet.add(DhrPreviousDwelling.xmlToModel(domesticHelpRequestXml.getPreviousDwellingsArray(i)));
            }
        }
        domesticHelpRequest.setPreviousDwellings(previousDwellingsSet);
        domesticHelpRequest.setSpouseInvestmentIncome(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseInvestmentIncome());
        if (domesticHelpRequestXml.getRequesterSpouse().getSpousePensionPlan() != null)
            domesticHelpRequest.setSpousePensionPlan(fr.cg95.cvq.business.social.DhrPensionPlanType.forString(domesticHelpRequestXml.getRequesterSpouse().getSpousePensionPlan().toString()));
        else
            domesticHelpRequest.setSpousePensionPlan(fr.cg95.cvq.business.social.DhrPensionPlanType.getDefaultDhrPensionPlanType());
        domesticHelpRequest.setBondsAmount(domesticHelpRequestXml.getCapitals().getBondsAmount());
        domesticHelpRequest.setSpouseNetIncome(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseNetIncome());
        domesticHelpRequest.setSpousePensionner(Boolean.valueOf(domesticHelpRequestXml.getRequesterSpouse().getSpousePensionner()));
        domesticHelpRequest.setRequesterNetIncome(domesticHelpRequestXml.getRequesterIncomes().getRequesterNetIncome());
        domesticHelpRequest.setRent(domesticHelpRequestXml.getMensualExpenses().getRent());
        domesticHelpRequest.setCurrentDwellingRoomNumber(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingRoomNumber());
        return domesticHelpRequest;
    }

    private java.math.BigInteger expensesTotal;

    public final void setExpensesTotal(final java.math.BigInteger expensesTotal) {
        this.expensesTotal = expensesTotal;
    }


    /**
     * @hibernate.property
     *  column="expenses_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getExpensesTotal() {
        return this.expensesTotal;
    }

    private fr.cg95.cvq.business.social.DhrDwellingType currentDwellingType;

    public final void setCurrentDwellingType(final fr.cg95.cvq.business.social.DhrDwellingType currentDwellingType) {
        this.currentDwellingType = currentDwellingType;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_type"
     */
    public final fr.cg95.cvq.business.social.DhrDwellingType getCurrentDwellingType() {
        return this.currentDwellingType;
    }

    private Set savings;

    public final void setSavings(final Set savings) {
        this.savings = savings;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="domestic_help_request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.social.DhrPersonalEstateAndSaving"
     */
    public final Set getSavings() {
        return this.savings;
    }

    private java.math.BigInteger professionalTaxes;

    public final void setProfessionalTaxes(final java.math.BigInteger professionalTaxes) {
        this.professionalTaxes = professionalTaxes;
    }


    /**
     * @hibernate.property
     *  column="professional_taxes"
     *  type="serializable"
     */
    public final java.math.BigInteger getProfessionalTaxes() {
        return this.professionalTaxes;
    }

    private String spouseSocialSecurityNumber;

    public final void setSpouseSocialSecurityNumber(final String spouseSocialSecurityNumber) {
        this.spouseSocialSecurityNumber = spouseSocialSecurityNumber;
    }


    /**
     * @hibernate.property
     *  column="spouse_social_security_number"
     *  length="13"
     */
    public final String getSpouseSocialSecurityNumber() {
        return this.spouseSocialSecurityNumber;
    }

    private Set donations;

    public final void setDonations(final Set donations) {
        this.donations = donations;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="domestic_help_request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.social.DhrDonation"
     */
    public final Set getDonations() {
        return this.donations;
    }

    private java.math.BigInteger spousePensions;

    public final void setSpousePensions(final java.math.BigInteger spousePensions) {
        this.spousePensions = spousePensions;
    }


    /**
     * @hibernate.property
     *  column="spouse_pensions"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpousePensions() {
        return this.spousePensions;
    }

    private java.math.BigInteger taxesTotal;

    public final void setTaxesTotal(final java.math.BigInteger taxesTotal) {
        this.taxesTotal = taxesTotal;
    }


    /**
     * @hibernate.property
     *  column="taxes_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getTaxesTotal() {
        return this.taxesTotal;
    }

    private fr.cg95.cvq.business.users.Address tutorAddress;

    public final void setTutorAddress(final fr.cg95.cvq.business.users.Address tutorAddress) {
        this.tutorAddress = tutorAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="tutor_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getTutorAddress() {
        return this.tutorAddress;
    }

    private java.math.BigInteger requesterInvestmentIncome;

    public final void setRequesterInvestmentIncome(final java.math.BigInteger requesterInvestmentIncome) {
        this.requesterInvestmentIncome = requesterInvestmentIncome;
    }


    /**
     * @hibernate.property
     *  column="requester_investment_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterInvestmentIncome() {
        return this.requesterInvestmentIncome;
    }

    private java.math.BigInteger alimonies;

    public final void setAlimonies(final java.math.BigInteger alimonies) {
        this.alimonies = alimonies;
    }


    /**
     * @hibernate.property
     *  column="alimonies"
     *  type="serializable"
     */
    public final java.math.BigInteger getAlimonies() {
        return this.alimonies;
    }

    private Set realAssets;

    public final void setRealAssets(final Set realAssets) {
        this.realAssets = realAssets;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="domestic_help_request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.social.DhrRealAsset"
     */
    public final Set getRealAssets() {
        return this.realAssets;
    }

    private java.math.BigInteger sharesAmount;

    public final void setSharesAmount(final java.math.BigInteger sharesAmount) {
        this.sharesAmount = sharesAmount;
    }


    /**
     * @hibernate.property
     *  column="shares_amount"
     *  type="serializable"
     */
    public final java.math.BigInteger getSharesAmount() {
        return this.sharesAmount;
    }

    private java.util.Date currentDwellingArrivalDate;

    public final void setCurrentDwellingArrivalDate(final java.util.Date currentDwellingArrivalDate) {
        this.currentDwellingArrivalDate = currentDwellingArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_arrival_date"
     */
    public final java.util.Date getCurrentDwellingArrivalDate() {
        return this.currentDwellingArrivalDate;
    }

    private java.math.BigInteger incomeTax;

    public final void setIncomeTax(final java.math.BigInteger incomeTax) {
        this.incomeTax = incomeTax;
    }


    /**
     * @hibernate.property
     *  column="income_tax"
     *  type="serializable"
     */
    public final java.math.BigInteger getIncomeTax() {
        return this.incomeTax;
    }

    private String tutorName;

    public final void setTutorName(final String tutorName) {
        this.tutorName = tutorName;
    }


    /**
     * @hibernate.property
     *  column="tutor_name"
     *  length="38"
     */
    public final String getTutorName() {
        return this.tutorName;
    }

    private java.math.BigInteger spouseAllowances;

    public final void setSpouseAllowances(final java.math.BigInteger spouseAllowances) {
        this.spouseAllowances = spouseAllowances;
    }


    /**
     * @hibernate.property
     *  column="spouse_allowances"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseAllowances() {
        return this.spouseAllowances;
    }

    private java.math.BigInteger currentDwellingNetFloorArea;

    public final void setCurrentDwellingNetFloorArea(final java.math.BigInteger currentDwellingNetFloorArea) {
        this.currentDwellingNetFloorArea = currentDwellingNetFloorArea;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_net_floor_area"
     *  type="serializable"
     */
    public final java.math.BigInteger getCurrentDwellingNetFloorArea() {
        return this.currentDwellingNetFloorArea;
    }

    private fr.cg95.cvq.business.social.DhrDwellingStatusType currentDwellingStatus;

    public final void setCurrentDwellingStatus(final fr.cg95.cvq.business.social.DhrDwellingStatusType currentDwellingStatus) {
        this.currentDwellingStatus = currentDwellingStatus;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_status"
     */
    public final fr.cg95.cvq.business.social.DhrDwellingStatusType getCurrentDwellingStatus() {
        return this.currentDwellingStatus;
    }

    private String spouseEmployer;

    public final void setSpouseEmployer(final String spouseEmployer) {
        this.spouseEmployer = spouseEmployer;
    }


    /**
     * @hibernate.property
     *  column="spouse_employer"
     *  length="50"
     */
    public final String getSpouseEmployer() {
        return this.spouseEmployer;
    }

    private fr.cg95.cvq.business.social.DhrPensionPlanType requesterPensionPlan;

    public final void setRequesterPensionPlan(final fr.cg95.cvq.business.social.DhrPensionPlanType requesterPensionPlan) {
        this.requesterPensionPlan = requesterPensionPlan;
    }


    /**
     * @hibernate.property
     *  column="requester_pension_plan"
     */
    public final fr.cg95.cvq.business.social.DhrPensionPlanType getRequesterPensionPlan() {
        return this.requesterPensionPlan;
    }

    private fr.cg95.cvq.business.users.NationalityType nationality;

    public final void setNationality(final fr.cg95.cvq.business.users.NationalityType nationality) {
        this.nationality = nationality;
    }


    /**
     * @hibernate.property
     *  column="nationality"
     *  length="32"
     */
    public final fr.cg95.cvq.business.users.NationalityType getNationality() {
        return this.nationality;
    }

    private java.math.BigInteger realAssetsValuesTotal;

    public final void setRealAssetsValuesTotal(final java.math.BigInteger realAssetsValuesTotal) {
        this.realAssetsValuesTotal = realAssetsValuesTotal;
    }


    /**
     * @hibernate.property
     *  column="real_assets_values_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getRealAssetsValuesTotal() {
        return this.realAssetsValuesTotal;
    }

    private fr.cg95.cvq.business.users.Address spouseEmployerAddress;

    public final void setSpouseEmployerAddress(final fr.cg95.cvq.business.users.Address spouseEmployerAddress) {
        this.spouseEmployerAddress = spouseEmployerAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="spouse_employer_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getSpouseEmployerAddress() {
        return this.spouseEmployerAddress;
    }

    private fr.cg95.cvq.business.users.NationalityType spouseNationality;

    public final void setSpouseNationality(final fr.cg95.cvq.business.users.NationalityType spouseNationality) {
        this.spouseNationality = spouseNationality;
    }


    /**
     * @hibernate.property
     *  column="spouse_nationality"
     *  length="32"
     */
    public final fr.cg95.cvq.business.users.NationalityType getSpouseNationality() {
        return this.spouseNationality;
    }

    private fr.cg95.cvq.business.users.Address currentDwellingAddress;

    public final void setCurrentDwellingAddress(final fr.cg95.cvq.business.users.Address currentDwellingAddress) {
        this.currentDwellingAddress = currentDwellingAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="current_dwelling_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getCurrentDwellingAddress() {
        return this.currentDwellingAddress;
    }

    private fr.cg95.cvq.business.users.Adult spouseInformation;

    public final void setSpouseInformation(final fr.cg95.cvq.business.users.Adult spouseInformation) {
        this.spouseInformation = spouseInformation;
    }


    /**
     * @hibernate.many-to-one
     *  column="spouse_information_id"
     *  class="fr.cg95.cvq.business.users.Adult"
     */
    public final fr.cg95.cvq.business.users.Adult getSpouseInformation() {
        return this.spouseInformation;
    }

    private Boolean tutorPresence;

    public final void setTutorPresence(final Boolean tutorPresence) {
        this.tutorPresence = tutorPresence;
    }


    /**
     * @hibernate.property
     *  column="tutor_presence"
     */
    public final Boolean getTutorPresence() {
        return this.tutorPresence;
    }

    private String socialSecurityNumber;

    public final void setSocialSecurityNumber(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


    /**
     * @hibernate.property
     *  column="social_security_number"
     *  length="13"
     */
    public final String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    private java.math.BigInteger requesterIncomesAnnualTotal;

    public final void setRequesterIncomesAnnualTotal(final java.math.BigInteger requesterIncomesAnnualTotal) {
        this.requesterIncomesAnnualTotal = requesterIncomesAnnualTotal;
    }


    /**
     * @hibernate.property
     *  column="requester_incomes_annual_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterIncomesAnnualTotal() {
        return this.requesterIncomesAnnualTotal;
    }

    private fr.cg95.cvq.business.social.DhrTutorType tutor;

    public final void setTutor(final fr.cg95.cvq.business.social.DhrTutorType tutor) {
        this.tutor = tutor;
    }


    /**
     * @hibernate.property
     *  column="tutor"
     */
    public final fr.cg95.cvq.business.social.DhrTutorType getTutor() {
        return this.tutor;
    }

    private java.math.BigInteger localRate;

    public final void setLocalRate(final java.math.BigInteger localRate) {
        this.localRate = localRate;
    }


    /**
     * @hibernate.property
     *  column="local_rate"
     *  type="serializable"
     */
    public final java.math.BigInteger getLocalRate() {
        return this.localRate;
    }

    private java.math.BigInteger requesterPensions;

    public final void setRequesterPensions(final java.math.BigInteger requesterPensions) {
        this.requesterPensions = requesterPensions;
    }


    /**
     * @hibernate.property
     *  column="requester_pensions"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterPensions() {
        return this.requesterPensions;
    }

    private java.util.Date spouseFranceArrivalDate;

    public final void setSpouseFranceArrivalDate(final java.util.Date spouseFranceArrivalDate) {
        this.spouseFranceArrivalDate = spouseFranceArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="spouse_france_arrival_date"
     */
    public final java.util.Date getSpouseFranceArrivalDate() {
        return this.spouseFranceArrivalDate;
    }

    private java.math.BigInteger capitalAmountTotal;

    public final void setCapitalAmountTotal(final java.math.BigInteger capitalAmountTotal) {
        this.capitalAmountTotal = capitalAmountTotal;
    }


    /**
     * @hibernate.property
     *  column="capital_amount_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getCapitalAmountTotal() {
        return this.capitalAmountTotal;
    }

    private java.math.BigInteger propertyTaxes;

    public final void setPropertyTaxes(final java.math.BigInteger propertyTaxes) {
        this.propertyTaxes = propertyTaxes;
    }


    /**
     * @hibernate.property
     *  column="property_taxes"
     *  type="serializable"
     */
    public final java.math.BigInteger getPropertyTaxes() {
        return this.propertyTaxes;
    }

    private String tutorFirstName;

    public final void setTutorFirstName(final String tutorFirstName) {
        this.tutorFirstName = tutorFirstName;
    }


    /**
     * @hibernate.property
     *  column="tutor_first_name"
     *  length="38"
     */
    public final String getTutorFirstName() {
        return this.tutorFirstName;
    }

    private java.math.BigInteger donationsValuesTotal;

    public final void setDonationsValuesTotal(final java.math.BigInteger donationsValuesTotal) {
        this.donationsValuesTotal = donationsValuesTotal;
    }


    /**
     * @hibernate.property
     *  column="donations_values_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getDonationsValuesTotal() {
        return this.donationsValuesTotal;
    }

    private java.math.BigInteger savingsTotal;

    public final void setSavingsTotal(final java.math.BigInteger savingsTotal) {
        this.savingsTotal = savingsTotal;
    }


    /**
     * @hibernate.property
     *  column="savings_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getSavingsTotal() {
        return this.savingsTotal;
    }

    private java.math.BigInteger spouseIncomesAnnualTotal;

    public final void setSpouseIncomesAnnualTotal(final java.math.BigInteger spouseIncomesAnnualTotal) {
        this.spouseIncomesAnnualTotal = spouseIncomesAnnualTotal;
    }


    /**
     * @hibernate.property
     *  column="spouse_incomes_annual_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseIncomesAnnualTotal() {
        return this.spouseIncomesAnnualTotal;
    }

    private String socialSecurityKeyNumber;

    public final void setSocialSecurityKeyNumber(final String socialSecurityKeyNumber) {
        this.socialSecurityKeyNumber = socialSecurityKeyNumber;
    }


    /**
     * @hibernate.property
     *  column="social_security_key_number"
     *  length="2"
     */
    public final String getSocialSecurityKeyNumber() {
        return this.socialSecurityKeyNumber;
    }

    private String spouseSocialSecurityKeyNumber;

    public final void setSpouseSocialSecurityKeyNumber(final String spouseSocialSecurityKeyNumber) {
        this.spouseSocialSecurityKeyNumber = spouseSocialSecurityKeyNumber;
    }


    /**
     * @hibernate.property
     *  column="spouse_social_security_key_number"
     *  length="2"
     */
    public final String getSpouseSocialSecurityKeyNumber() {
        return this.spouseSocialSecurityKeyNumber;
    }

    private String spouseOccupation;

    public final void setSpouseOccupation(final String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }


    /**
     * @hibernate.property
     *  column="spouse_occupation"
     *  length="50"
     */
    public final String getSpouseOccupation() {
        return this.spouseOccupation;
    }

    private java.util.Date franceArrivalDate;

    public final void setFranceArrivalDate(final java.util.Date franceArrivalDate) {
        this.franceArrivalDate = franceArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="france_arrival_date"
     */
    public final java.util.Date getFranceArrivalDate() {
        return this.franceArrivalDate;
    }

    private java.math.BigInteger requesterAllowances;

    public final void setRequesterAllowances(final java.math.BigInteger requesterAllowances) {
        this.requesterAllowances = requesterAllowances;
    }


    /**
     * @hibernate.property
     *  column="requester_allowances"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterAllowances() {
        return this.requesterAllowances;
    }

    private Set previousDwellings;

    public final void setPreviousDwellings(final Set previousDwellings) {
        this.previousDwellings = previousDwellings;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="domestic_help_request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.social.DhrPreviousDwelling"
     */
    public final Set getPreviousDwellings() {
        return this.previousDwellings;
    }

    private java.math.BigInteger spouseInvestmentIncome;

    public final void setSpouseInvestmentIncome(final java.math.BigInteger spouseInvestmentIncome) {
        this.spouseInvestmentIncome = spouseInvestmentIncome;
    }


    /**
     * @hibernate.property
     *  column="spouse_investment_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseInvestmentIncome() {
        return this.spouseInvestmentIncome;
    }

    private fr.cg95.cvq.business.social.DhrPensionPlanType spousePensionPlan;

    public final void setSpousePensionPlan(final fr.cg95.cvq.business.social.DhrPensionPlanType spousePensionPlan) {
        this.spousePensionPlan = spousePensionPlan;
    }


    /**
     * @hibernate.property
     *  column="spouse_pension_plan"
     */
    public final fr.cg95.cvq.business.social.DhrPensionPlanType getSpousePensionPlan() {
        return this.spousePensionPlan;
    }

    private java.math.BigInteger bondsAmount;

    public final void setBondsAmount(final java.math.BigInteger bondsAmount) {
        this.bondsAmount = bondsAmount;
    }


    /**
     * @hibernate.property
     *  column="bonds_amount"
     *  type="serializable"
     */
    public final java.math.BigInteger getBondsAmount() {
        return this.bondsAmount;
    }

    private java.math.BigInteger spouseNetIncome;

    public final void setSpouseNetIncome(final java.math.BigInteger spouseNetIncome) {
        this.spouseNetIncome = spouseNetIncome;
    }


    /**
     * @hibernate.property
     *  column="spouse_net_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseNetIncome() {
        return this.spouseNetIncome;
    }

    private Boolean spousePensionner;

    public final void setSpousePensionner(final Boolean spousePensionner) {
        this.spousePensionner = spousePensionner;
    }


    /**
     * @hibernate.property
     *  column="spouse_pensionner"
     */
    public final Boolean getSpousePensionner() {
        return this.spousePensionner;
    }

    private java.math.BigInteger requesterNetIncome;

    public final void setRequesterNetIncome(final java.math.BigInteger requesterNetIncome) {
        this.requesterNetIncome = requesterNetIncome;
    }


    /**
     * @hibernate.property
     *  column="requester_net_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterNetIncome() {
        return this.requesterNetIncome;
    }

    private java.math.BigInteger rent;

    public final void setRent(final java.math.BigInteger rent) {
        this.rent = rent;
    }


    /**
     * @hibernate.property
     *  column="rent"
     *  type="serializable"
     */
    public final java.math.BigInteger getRent() {
        return this.rent;
    }

    private java.math.BigInteger currentDwellingRoomNumber;

    public final void setCurrentDwellingRoomNumber(final java.math.BigInteger currentDwellingRoomNumber) {
        this.currentDwellingRoomNumber = currentDwellingRoomNumber;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_room_number"
     *  type="serializable"
     */
    public final java.math.BigInteger getCurrentDwellingRoomNumber() {
        return this.currentDwellingRoomNumber;
    }

}
